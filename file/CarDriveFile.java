/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Administrative;
import domain.Car;
import domain.CarDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caro
 */
public class CarDriveFile implements Serializable{
      private String path;

    /**
     * 
     * @param path_
     */
      public CarDriveFile(String path_) {  
          super();
        this.path = path_;
    }


    public void saveCarDriver(CarDriver carDriver) throws IOException, ClassNotFoundException{
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que se obtiene y se guarda en archivo
        List<CarDriver> carList = new ArrayList<CarDriver>();
        
        //si el archivo existe, recupero la lista
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting a lista
            carList = (List<CarDriver>)aux;
            objectInput.close();//siempre se debe cerrar el archivo sea eltipo de archivo que sea RAF,serializable etc  
        }
        //para agregar se lee toda lista se agrega el objeto y luego se vuelve a guardar la lista
        //agrego la persona a la lista
        carList.add(carDriver);
        
        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(carList);
        
        //cierro el archivo
        output.close();
    }
           
    public CarDriver getCarDriver(String name_) throws IOException, ClassNotFoundException {
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que voy a recorrer para buscar a una persona
        List<CarDriver> carList = new ArrayList<CarDriver>();
        
        //si el archivo existe entonces recupero a la persona
        if(myFile.exists()){
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting del objeto
            carList = (List<CarDriver>)aux;
            objectInput.close();  
        }
        
        //mi instancia a retornar
        CarDriver myCarDriver = new CarDriver();
        
        //recorro la lista en busca de la persona que me interesa
        for(int i = 0; i < carList.size(); i++){
            
            //pregunta si es la persona
            if(carList.get(i).getName().equalsIgnoreCase(name_)){
                //
                myCarDriver = carList.get(i);
                
                //esta linea me hace salir del ciclo
                break;
            }
        }
        
        //retorna la persona ya sea con datos nulos o con la persona buscada
        return myCarDriver;
    }//getCarDriver

    public void deletedCarDriver(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        System.out.println("entra");
        List<CarDriver> carList = new ArrayList<CarDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            carList = (List<CarDriver>) aux;
            objectInputStream.close();
        }//if
        CarDriver carDriver = null;
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i));
            if (carList.get(i).getName().equals(name)) {
                System.out.println("entra2");
                carList.remove(i);
                System.out.println(carList.size());
            }
        }
        
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(carList);//escribe el objeto
        System.out.println(carList.size());
        output.close();
    }//deleted
    
       public CarDriver updateCarDriver(String name, String surname, String id,String eN,boolean qualify,String typeLicense, int hours, boolean turn, int typeDriver) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        List<CarDriver> carList = new ArrayList<CarDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            carList = (List<CarDriver>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        CarDriver carDriver = null;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getName().equals(name)) {
                carList.remove(i);
                carDriver = new CarDriver(name, surname, id, typeLicense, qualify, typeLicense, hours, turn, typeDriver);
                carList.add(carDriver);   
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
                output.writeUnshared(carList);
                break;
            } // if 
        } // for i
        return carDriver;
    }
    
 
       
    public List<CarDriver> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<CarDriver> carList = new ArrayList<CarDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            carList = (List<CarDriver>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return carList;
    }//arrays
       
    public boolean getByIDBoolean(String id) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<CarDriver> carList = new ArrayList<CarDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            carList = (List<CarDriver>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        CarDriver carDrivers = null;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId().equals(id)) {
                carDrivers = carList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if
        }//for i
        return false;
    }//getByIDBoolean
}
