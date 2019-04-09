/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Janitor;
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
public class JanitorFile {
    
    private String path;
    
    public JanitorFile(String path_) {  
       super();
       this.path = path_;
    }


    public void saveJanitor(Janitor janitor) throws IOException, ClassNotFoundException{
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que se obtiene y se guarda en archivo
        List<Janitor > janitorList = new ArrayList<Janitor>();
        
        //si el archivo existe, recupero la lista
        if(myFile.exists()){
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting a lista
            janitorList = (List<Janitor>)aux;
            objectInput.close();//siempre se debe cerrar el archivo sea eltipo de archivo que sea RAF,serializable etc  
        }
        //para agregar se lee toda lista se agrega el objeto y luego se vuelve a guardar la lista
        //agrego la persona a la lista
        janitorList.add(janitor);
        
        //escribo el objeto lista (que contiene objetos de tipo Person) en archivo
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(janitorList);
        
        //cierro el archivo
        output.close();
    }
           
    public Janitor  getJanitor(String name_) throws IOException, ClassNotFoundException {
        
        //instancia de file
        File myFile = new File(path);
        
        //lista que voy a recorrer para buscar a una persona
        List<Janitor > janitorList = new ArrayList<Janitor >();
        
        //si el archivo existe entonces recupero a la persona
        if(myFile.exists()){
            //llevo a cabo una lectura de la lista
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInput.readObject();
            
            //casting del objeto
            janitorList = (List<Janitor>)aux;
            objectInput.close();  
        }
        
        //mi instancia a retornar
        Janitor  myJanitor = new Janitor();
        
        //recorro la lista en busca de la persona que me interesa
        for(int i = 0; i < janitorList.size(); i++){
            
            //pregunta si es la persona
            if(janitorList.get(i).getName().equalsIgnoreCase(name_)){
                //
                myJanitor = janitorList.get(i);
                
                //esta linea me hace salir del ciclo
                break;
            }
        }
        
        //retorna la persona ya sea con datos nulos o con la persona buscada
        return myJanitor;
    }//getCarDriver

    public void deletedJanitor(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        System.out.println("entra");
        List<Janitor> janitorList = new ArrayList<Janitor>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            janitorList = (List<Janitor>) aux;
            objectInputStream.close();
        }//if
        Janitor janitor = null;
        for (int i = 0; i < janitorList.size(); i++) {
            System.out.println(janitorList.get(i));
            if (janitorList.get(i).getName().equals(name)) {
                System.out.println("entra2");
                janitorList.remove(i);
                System.out.println(janitorList.size());
            }
        }
        
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(janitorList);//escribe el objeto
        System.out.println(janitorList.size());
        output.close();
    }//deleted
    
       public Janitor updateJanitor(String name, String surnames, String id, String employeeNumber, boolean qualify, int extraHours) throws IOException, ClassNotFoundException {
        File myFile = new File(path);
        List<Janitor> janitorList = new ArrayList<Janitor>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            janitorList = (List<Janitor>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        Janitor janitor = null;
        for (int i = 0; i < janitorList.size(); i++) {
            if (janitorList.get(i).getName().equals(name)) {
                janitorList.remove(i);
                janitor = new Janitor(name,surnames,id,employeeNumber,qualify,extraHours);
                janitorList.add(janitor);   
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
                output.writeUnshared(janitorList);
                break;
            } // if 
        } // for i
        return janitor;
    }
    
 
       
    public List<Janitor> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Janitor> janitorList = new ArrayList<Janitor>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            janitorList = (List<Janitor>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return janitorList;
    }//arrays
       
    public boolean getByIDBoolean(String id) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Janitor> janList = new ArrayList<Janitor>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            janList = (List<Janitor>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Janitor janitors = null;
        for (int i = 0; i < janList.size(); i++) {
            if (janList.get(i).getId().equals(id)) {
                janitors = janList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if
        }//for i
        return false;
    }//getByIDBoolean
}//JanitorFile
    

