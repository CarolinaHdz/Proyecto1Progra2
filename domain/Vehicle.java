/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

//import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;


public abstract class Vehicle {
    private String idVehicle;
    private String model;
    private String cardBrand;
    private boolean available;//true si esta disponible, false si no
    
    public Vehicle() {
        this.idVehicle = "Unspecified";
        this.model = "Unspecified";
        this.cardBrand="Unspecified";
        this.available=true;
        
    }

    public Vehicle(String idVehicle, String model, String cardBrand, boolean available) {
        this.idVehicle = idVehicle;
        this.model = model;
        this.cardBrand= cardBrand;
        this.available = available;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    
    
    public String toString(){
        return "Vehicle ID: "+this.idVehicle+"\n"+
                "Model: "+this.model+"\n"+
                " Car brand: "+this.cardBrand+
                "It is available?: "+this.available;
    }
}
