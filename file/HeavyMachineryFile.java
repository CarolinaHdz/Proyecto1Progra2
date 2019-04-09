/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Car;
import domain.HeavyMachinery;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import utility.Path;

/**
 *
 * @author Christian
 */
public class HeavyMachineryFile {
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tama;o del registro
    private String myFilePath;//ruta
    public File file;
    
    //constructor
    public HeavyMachineryFile() throws IOException {
        //almaceno la ruta
        this.file=new File(Path.my_machinery_path);
        myFilePath = file.getPath();
        start(file);
    }
    
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = 140;
        
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
    public void close() throws IOException {
        randomAccessFile.close();
    }

    //indicar la cantidad de registros de nuestro archivo
    public int fileSize() {
        return this.regsQuantity;
    }

    //insertar un nuevo resgistro en una posicion especifica
    public boolean putValue(int position, HeavyMachinery heavyM) throws IOException {
        //primero verificar que sea valida la insercion
        if (position <= 0 && position > this.regsQuantity) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (heavyM.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size is out of bounds");
                return false;
            } else {
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeInt(heavyM.getType());
                randomAccessFile.writeDouble(heavyM.getLoadingCapacity());
                               
                randomAccessFile.writeUTF(heavyM.getIdVehicle());
                randomAccessFile.writeUTF(heavyM.getModel());
                randomAccessFile.writeUTF(heavyM.getCardBrand());
                randomAccessFile.writeBoolean(heavyM.isAvailable());
                return true;
            }
        }
    }//end method
    
    //insertar al final del archivo
    public boolean addEndRecord(HeavyMachinery heavyM) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, heavyM);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    public HeavyMachinery getHeavyM(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de maquinaria
            HeavyMachinery myMachinery = new HeavyMachinery();
            
            //llevamos a cabo las lecturas
            myMachinery.setType(randomAccessFile.readInt());
            myMachinery.setLoadingCapacity(randomAccessFile.readDouble());
            
            myMachinery.setIdVehicle(randomAccessFile.readUTF());
            myMachinery.setModel(randomAccessFile.readUTF());
            myMachinery.setCardBrand(randomAccessFile.readUTF());
            myMachinery.setAvailable(randomAccessFile.readBoolean());
            
            if(myMachinery.getIdVehicle().equals("deleted")){
                return null;
            }
            else{
                return myMachinery;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo
    
    //eliminar maquinaria
    public boolean deleteMachnery(String idMaquinery) throws IOException{
        HeavyMachinery myMachinery;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            
            //obtengo al carro de esa posicion
            myMachinery = this.getHeavyM(i);
                
            //pregunto si es la pmaquinaria que quiero eliminar
            if(myMachinery.getIdVehicle().equalsIgnoreCase(idMaquinery)){

                //marcar esta maquinaria como eliminada
                myMachinery.setIdVehicle("deleted");

                return this.putValue(i, myMachinery);
            }
        }
        
        //si llega a este punto no encontro la maquinaria
        return false;
    }

    //retornar una lista de maquinerias
    public ArrayList<HeavyMachinery> getAllMaquinerie() throws IOException {
        ArrayList<HeavyMachinery> machineryArray = new ArrayList<HeavyMachinery>();
        for (int i = 0; i < this.regsQuantity; i++) {
            HeavyMachinery machineryTemp = this.getHeavyM(i);
            if (machineryTemp != null) {
                machineryArray.add(machineryTemp);
            }
        }//end for
        return machineryArray;
    }
    
    public int Search(String idToSearch) throws IOException{
        String id;
        for (int i = 0; i < this.fileSize(); i++) {
            this.randomAccessFile.seek(i * this.regSize);
            id = getHeavyM(i).getIdVehicle();
            if(id.equalsIgnoreCase(idToSearch)){
                return i;
            }
        }
        return -1;
    }//fin buscarMaquinariaID
    public boolean updateMachinery(String idMachinery,HeavyMachinery machinery) throws IOException {
        HeavyMachinery myMachinery;
        //buscar el carro
        for (int i = 0; i < this.regsQuantity; i++) {
            //obtener el carro de la posicion actual
            myMachinery = this.getHeavyM(i);
            //preguntar si el carro que deseo eliminar 
            if (this.getHeavyM(i) != null) {
                if (myMachinery.getIdVehicle().equalsIgnoreCase(idMachinery)) {
                    //marcar como eliminado
                    myMachinery=(HeavyMachinery)machinery;
                    return this.putValue(i, myMachinery);
                }
            }
        }
        return false;
    }
}
