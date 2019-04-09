/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

public class Driver extends Employee implements Serializable{
    
    private double hoursWorked;
    private boolean turn;//true si es dia y false si es de noche
    private int typeDriver;//1 si es automovil y 2 si es maquinariaPesada
    private double priceForHour;
    
    public Driver(){
        super();
        this.hoursWorked=0;
        this.turn=true;//true quiere decir que no tiene turno nocturno
        this.typeDriver=-1;//no se especifica el tipo de vehículo que maneja
        this.priceForHour=8;//se le pagaran a 8 dolares la hora
    }

    public Driver( String name, String surnames, String id, String employeeNumber, boolean qualify,double hoursWorked, boolean turn) {
        super(name, surnames, id, employeeNumber, qualify);
        this.hoursWorked = hoursWorked;
        this.turn = turn;
    }

  

    public Driver(double hoursWorked, boolean turn, double priceForHour, String name, String surnames, String id, String employeeNumber, boolean qualify) {
        super(name, surnames, id, employeeNumber, qualify);
        this.hoursWorked = hoursWorked;
        this.turn = turn;
        this.priceForHour = priceForHour;
    }
    
    
    
     

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getTypeDriver() {
        return typeDriver;
    }

    public void setTypeDriver(int typeDriver) {
        this.typeDriver = typeDriver;
    }

    public double getPriceForHour() {
        return priceForHour;
    }

    public void setPriceForHour(double priceForHour) {
        this.priceForHour = priceForHour;
    }
    public String toString(){
        return "Employee: \n" +
                "Name: " + this.getName() +"\n"+
                "Surnames: " + this.getSurnames() + "\n"+
                "Salary: " + String.valueOf(this.getSalary()) +"\n"+
                "ID: " + this.getId() + "\n"+
                "Employee Number: " + this.getEmployeeNumber() + "\n"+
                "Is qualified?: " + String.valueOf(this.isQualify())+"\n"+
                "Worked Hours: "+String.valueOf(hoursWorked)+"\n"+
                "Turn: "+String.valueOf(turn)+"\n"+
                "Typer of Driver: "+String.valueOf(typeDriver);
    }
}//class driver
