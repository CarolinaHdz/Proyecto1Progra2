
package domain;

public class Car extends Vehicle{
    private String name;
    private int year;
    private float mileage;//kilometraje
    private boolean american;
    private int serie;
    
    public Car() {
        super();
         this.name = "";
        this.year = 0;
        this.mileage = 0;
        this.american = true;
        this.serie = 0;
    }
    
    public Car(String name, int year, float mileage, boolean american, int serie) {
        this.name = name;
        this.year = year;
        this.mileage = mileage;
        this.american = american;
        this.serie = serie;
    }

    public Car(String idVehicle, String model, String cardBrand, boolean available, String name, int year, float mileage, boolean american, int serie) {
        super(idVehicle, model, cardBrand, available);
        this.name = name;
        this.year = year;
        this.mileage = mileage;
        this.american = american;
        this.serie = serie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public boolean isAmerican() {
        return american;
    }

    public void setAmerican(boolean american) {
        this.american = american;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
    
    

    @Override
    public String toString() {
        return  "Vehicle ID: "+this.getIdVehicle()+"\n"+
                "Model: "+this.getModel()+"\n"+
                " Car brand: "+this.getCardBrand()+
                "\n"+
                "CAR \n{" +
                "Name: " + this.name+"\n"+ 
                "Year: " + this.year +"\n"+
                "Mileage: " + this.mileage+"\n"+
                "Serie: "+this.serie;
    }
    
    //valor en bytes de cada atributo del objeto
    public int sizeInBytes() {
        return this.getIdVehicle().length()*2+this.getCardBrand().length()*2+
                this.getModel().length()*2+1+this.getName().length()*2+4+4+1+4;
    }

    
   
}//class CarDriver
