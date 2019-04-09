/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Car;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utility.Path;

/**
 *
 * @author Caro
 */
public class CarFile {
     public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tama;o del registro
    private String myFilePath;//ruta
    public File file;
    
    //constructor
    public CarFile() throws IOException {
        //almaceno la ruta
        this.file=new File(Path.my_cars_path);
        myFilePath = file.getPath();
        start(file);
    }
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = 180;
        
        //una validacion basica
        if(file.exists() && !file.isFile()){
            throw new IOException(file.getName() 
                    + " is an invalid file");
        }
        else{
            //crear la nueva instancia de randomAccessFile
            randomAccessFile = new RandomAccessFile(file, "rw");
            
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)regSize);
        }
    }//fin start
    //MUY IMPORTANTE cerrar nuestros archivos
    public void close() throws IOException {
        randomAccessFile.close();
    }

    //indicar la cantidad de registros de nuestro archivo
    public int fileSize() {
        return this.regsQuantity;
    }

    //insertar un nuevo resgistro en una posicion especifica
    public boolean putValue(int position, Car car) throws IOException {
        //primero verificar que sea valida la insercion
        if (position < 0 && position > this.regsQuantity) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (car.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size is out of bounds");
                return false;
            } else {
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(car.getIdVehicle());
                randomAccessFile.writeUTF(car.getModel());
                randomAccessFile.writeUTF(car.getCardBrand());
                randomAccessFile.writeBoolean(car.isAvailable());
                
                randomAccessFile.writeUTF(car.getName());
                randomAccessFile.writeInt(car.getYear());
                randomAccessFile.writeFloat(car.getMileage());
                randomAccessFile.writeBoolean(car.isAmerican());
                randomAccessFile.writeInt(car.getSerie());

                return true;
            }
        }
    }//end method

    //insertar al final del archivo
    public boolean addEndRecord(Car car) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, car);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    public Car getCar(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Car myCar = new Car();
            
            //llevamos a cabo las lecturas
            myCar.setIdVehicle(randomAccessFile.readUTF());
            myCar.setModel(randomAccessFile.readUTF());
            myCar.setCardBrand(randomAccessFile.readUTF());
            myCar.setAvailable(randomAccessFile.readBoolean());
            
            myCar.setName(randomAccessFile.readUTF());
            myCar.setYear(randomAccessFile.readInt());
            myCar.setMileage(randomAccessFile.readFloat());
            myCar.setAmerican(randomAccessFile.readBoolean());
            myCar.setSerie(randomAccessFile.readInt());
            //si es delete no retorno
            if(myCar.getSerie()==-1){
                return null;
            }
            else{
                return myCar;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo
    
    //eliminar carro
    public boolean deleteCar(int serie) throws IOException{
        Car myCar;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            
            //obtengo al carro de esa posicion
            myCar = this.getCar(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myCar.getSerie()==serie){

                //marcar este carro como eliminada
                myCar.setSerie(-1);

                return this.putValue(i, myCar);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }

    //retornar una lista de carros
    public ArrayList<Car> getAllCars() throws IOException {
        ArrayList<Car> carsArray = new ArrayList<Car>();
        for (int i = 0; i < this.regsQuantity; i++) {
            Car sTemp = this.getCar(i);
            if (sTemp != null) {
                carsArray.add(sTemp);
            }
        }//end for
        return carsArray;
    }
    public int Search(int serieToSearch) throws IOException{
        int serie;
        for (int i = 0; i < this.fileSize(); i++) {
            this.randomAccessFile.seek(i * this.regSize);
            serie = getCar(i).getSerie();
            if(serie==serieToSearch){
                return i;
            }
        }
        return -1;
    }//fin buscarVehiculoNumeroPlaca
    public boolean updateCar(int serie,Car car) throws IOException {
        Car myCar;
        //buscar el carro
        for (int i = 0; i < this.regsQuantity; i++) {
            //obtener el carro de la posicion actual
            myCar = this.getCar(i);
            //preguntar si el carro que deseo eliminar 
            if (this.getCar(i) != null) {
                if (myCar.getSerie()==serie) {
                    //marcar como eliminado
                    myCar=(Car)car;
                    return this.putValue(i, myCar);
                }
            }
        }
        return false;
    }
}
