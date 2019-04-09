/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


public class HeavyMachinery extends Vehicle{
    
    private int type;//1 si es vagoneta, 2 si es grua y 3 si es montacarga.
    private double loadingCapacity;//capacidad de carga

    public HeavyMachinery() {
        super();
        this.type = -1;//tipo de maquinaria no especificado
        this.loadingCapacity = 0;//carga
    }

    public HeavyMachinery(int type,double loadingCapacity, String idVehicle, String model, String cardBrand, boolean available) {
        super(idVehicle, model, cardBrand, available);
        this.type = type;
        this.loadingCapacity = loadingCapacity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    
   
    public String toString(){
        return "Vehicle ID: "+this.getIdVehicle()+"\n"+
                "Model: "+this.getModel()+"\n"+
                "Car brand: "+this.getCardBrand()+
                "\n"+
                "HEAVY MACHINE \n"+
                "Typer of Maquinery: "+String.valueOf(type)+"\n"+
                "Loading Capacity: "+String.valueOf(this.loadingCapacity);
    }
    //valor en bytes de cada atributo del objeto
    public int sizeInBytes() {
        return this.getIdVehicle().length()*2+this.getCardBrand().length()*2+
                this.getModel().length()*2+1+4+4;
    }
}//class HeavyMachinery
