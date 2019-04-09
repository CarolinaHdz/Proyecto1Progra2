/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.HeavyMachineryDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caro
 */
public class HeavyMechineryDriverFile {
              private String path;

    /**
     * 
     * @param path_
     */
      public HeavyMechineryDriverFile(String path_) {  
          super();
        this.path = path_;
    }


    public void saveHMDriver(HeavyMachineryDriver heavyM) throws IOException, ClassNotFoundException{
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que se obtiene y se guarda en archivo
        List<HeavyMachineryDriver> hmList = new ArrayList<HeavyMachineryDriver>();
        
        //si el archivo existe, recupero la lista
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting a lista
            hmList = (List<HeavyMachineryDriver>)aux;
            objectInput.close();//siempre se debe cerrar el archivo sea eltipo de archivo que sea RAF,serializable etc  
        }
        //para agregar se lee toda lista se agrega el objeto y luego se vuelve a guardar la lista
        //agrego la persona a la lista
        hmList.add(heavyM);
        
        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(hmList);
        
        //cierro el archivo
        output.close();
    }
           
    public HeavyMachineryDriver getHMDriver(String name_) throws IOException, ClassNotFoundException {
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que voy a recorrer para buscar a una persona
        List<HeavyMachineryDriver> hmList = new ArrayList<HeavyMachineryDriver>();
        
        //si el archivo existe entonces recupero a la persona
        if(myFile.exists()){
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting del objeto
            hmList = (List<HeavyMachineryDriver>)aux;
            objectInput.close();  
        }
        
        //mi instancia a retornar
        HeavyMachineryDriver myHMDriver = new HeavyMachineryDriver();
        
        //recorro la lista en busca de la persona que me interesa
        for(int i = 0; i < hmList.size(); i++){
            
            //pregunta si es la persona
            if(hmList.get(i).getName().equalsIgnoreCase(name_)){
                //
                myHMDriver = hmList.get(i);
                
                //esta linea me hace salir del ciclo
                break;
            }
        }
        
        //retorna la persona ya sea con datos nulos o con la persona buscada
        return myHMDriver;
    }//getCarDriver

    public void deleteHMDriver(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        System.out.println("entra");
        List<HeavyMachineryDriver> hmList = new ArrayList<HeavyMachineryDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            hmList = (List<HeavyMachineryDriver>) aux;
            objectInputStream.close();
        }//if
        HeavyMachineryDriver hmDriver = null;
        for (int i = 0; i < hmList.size(); i++) {
            System.out.println(hmList.get(i));
            if (hmList.get(i).getName().equals(name)) {
                System.out.println("entra2");
                hmList.remove(i);
                System.out.println(hmList.size());
            }
        }
        
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(hmList);//escribe el objeto
        System.out.println(hmList.size());
        output.close();
    }//deleted
    
       public HeavyMachineryDriver updateHMDriver(String name, String surnames, String id, String employeeNumber, boolean qualify, double hoursWorked, boolean turn,double heigth, int age) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        List<HeavyMachineryDriver> hmList = new ArrayList<HeavyMachineryDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            hmList = (List<HeavyMachineryDriver>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        HeavyMachineryDriver hmDriver = null;
        for (int i = 0; i < hmList.size(); i++) {
            if (hmList.get(i).getName().equals(name)) {
                hmList.remove(i);
                hmDriver = new HeavyMachineryDriver(name,surnames,id,employeeNumber,qualify,hoursWorked,turn,heigth,age);
                hmList.add(hmDriver);   
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
                output.writeUnshared(hmList);
                break;
            } // if 
        } // for i
        return hmDriver;
    }
    
 
       
    public List<HeavyMachineryDriver> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<HeavyMachineryDriver> hmList = new ArrayList<HeavyMachineryDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            hmList = (List<HeavyMachineryDriver>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return hmList;
    }//arrays
       
    public boolean getByIDBoolean(String id) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<HeavyMachineryDriver> hmList = new ArrayList<HeavyMachineryDriver>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            hmList = (List<HeavyMachineryDriver>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        HeavyMachineryDriver hmDrivers = null;
        for (int i = 0; i < hmList.size(); i++) {
            if (hmList.get(i).getId().equals(id)) {
                hmDrivers = hmList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if
        }//for i
        return false;
    }//getByIDBoolean
}


    

