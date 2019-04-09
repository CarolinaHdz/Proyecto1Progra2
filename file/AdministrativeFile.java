/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Administrative;
import gui.InsertAdministrative;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import utility.Path;

/**
 *
 * @author Caro
 */
public class AdministrativeFile implements Serializable{
   
    
    private String path;

    /**
     * 
     * @param path_
     */
      public AdministrativeFile(String path_) {  
          super();
        this.path = path_;
    }

    

    /**
     * Guarda en archivo un objeto de tipo Person
     * @param administrative
     * @throws IOException
     * @throws ClassNotFoundException
     */
    
    public void saveAdministrative(Administrative adm) throws IOException, ClassNotFoundException{
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que se obtiene y se guarda en archivo
        List<Administrative> admList = new ArrayList<Administrative>();
        
        //si el archivo existe, recupero la lista
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting a lista
            admList = (List<Administrative>)aux;
            objectInput.close();//siempre se debe cerrar el archivo sea eltipo de archivo que sea RAF,serializable etc  
        }
        //para agregar se lee toda lista se agrega el objeto y luego se vuelve a guardar la lista
        //agrego la persona a la lista
        admList.add(adm);
        
        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(admList);
        
        //cierro el archivo
        output.close();
    }
           
    public Administrative getAdministrative(String name_) throws IOException, ClassNotFoundException {
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que voy a recorrer para buscar a una persona
        List<Administrative> admList = new ArrayList<Administrative>();
        
        //si el archivo existe entonces recupero a la persona
        if(myFile.exists()){
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting del objeto
            admList = (List<Administrative>)aux;
            objectInput.close();  
        }
        
        //mi instancia a retornar
        Administrative myAdm = new Administrative();
        
        //recorro la lista en busca de la persona que me interesa
        for(int i = 0; i < admList.size(); i++){
            
            //pregunta si es la persona
            if(admList.get(i).getName().equalsIgnoreCase(name_)){
                //
                myAdm = admList.get(i);
                
                //esta linea me hace salir del ciclo
                break;
            }
        }
        
        //retorna la persona ya sea con datos nulos o con la persona buscada
        return myAdm;
    }//getAdministrative

    public void deletedAdministrative(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        System.out.println("entra");
        List<Administrative> admList = new ArrayList<Administrative>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            admList = (List<Administrative>) aux;
            objectInputStream.close();
        }//if
        Administrative adm = null;
        for (int i = 0; i < admList.size(); i++) {
            System.out.println(admList.get(i));
            if (admList.get(i).getName().equals(name)) {
                System.out.println("entra2");
                admList.remove(i);
                System.out.println(admList.size());
            }
        }
        
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(admList);//escribe el objeto
        System.out.println(admList.size());
        output.close();
    }//deleted
    
       public Administrative updateAdministrative(String name, String surname, String id,String eN,boolean qualify,String acdGrade,int category) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        List<Administrative> admList = new ArrayList<Administrative>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            admList = (List<Administrative>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        Administrative adm = null;
        for (int i = 0; i < admList.size(); i++) {
            if (admList.get(i).getName().equals(name)) {
                admList.remove(i);
                adm = new Administrative(name, surname, id, eN, qualify, acdGrade, category);
                admList.add(adm);   
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
                output.writeUnshared(admList);
                break;
            } // if 
        } // for i
        return adm;
    }
    
 
       
    public List<Administrative> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Administrative> admList = new ArrayList<Administrative>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            admList = (List<Administrative>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return admList;
    }//arrays
       
    public boolean getByIDBoolean(String id) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Administrative> admList = new ArrayList<Administrative>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            admList = (List<Administrative>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Administrative administratives = null;
        for (int i = 0; i < admList.size(); i++) {
            if (admList.get(i).getId().equals(id)) {
                administratives = admList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if
        }//for i
        return false;
    }//getByIDBoolean
       
}//class  
  
    

