/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class CarDriver extends Driver implements Serializable{
    private String typeOfLicense;
    
    
    public CarDriver() {
        super();
        this.typeOfLicense = "Unspecified";
    }
    
    public CarDriver(String typeOfLicense) {
        super();
        this.typeOfLicense = typeOfLicense;
    }

    public CarDriver( String name, String surnames, String id, String employeeNumber, boolean qualify,String typeOfLicense, int hoursWorked, boolean turn, int typeDriver) {
        super(hoursWorked, turn, typeDriver, name, surnames, id, employeeNumber, qualify);
        this.typeOfLicense = typeOfLicense;
    }

    public String getTypeOfLicense() {
        return typeOfLicense;
    }

    public void setTypeOfLicense(String typeOfLicense) {
        this.typeOfLicense = typeOfLicense;
    }


    @Override
    public void calculateSalary(double hours) {
        this.setSalary(hours*this.getPriceForHour());//se calcula el salario por horas trabajadas
        //se valida el turno en el que grabaja, si trabaja de noche ganan el doble
        if (!this.getTurn()) {
            this.setSalary(this.getSalary()*2);
        }
        super.calculateSalary(this.getSalary()); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "The automobile driver's salary is: "+this.getSalary());
    }
    public String toString(){
        return  "Name: " + this.getName() +"\n"+
                "Surnames: " + this.getSurnames() +"\n"+
                "Salary: " +String.valueOf(this.getSalary()) +"\n"+
                "ID: " + this.getId() + "\n"+
                "Employee Number: " + this.getEmployeeNumber() + "\n"+
                "Is qualified?: " + String.valueOf(this.isQualify())+ "\n"+
                "Worked Hours: "+String.valueOf(this.getHoursWorked())+ "\n"+
                "Turn: "+String.valueOf(this.getTurn())+ "\n"+
                "Typer of Driver: "+String.valueOf(this.getTypeDriver())+"\n"
                +"Type of License: "+typeOfLicense;
    }
    
}
