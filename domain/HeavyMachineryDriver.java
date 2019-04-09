/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class HeavyMachineryDriver extends Driver implements Serializable{
    private double weight;//peso de la maquinaria
    private int age;
    
    public HeavyMachineryDriver() {
        super();
        this.weight =0;
        this.age = 0;
    }
    
  
    
    public HeavyMachineryDriver(String name, String surnames, String id, String employeeNumber, boolean qualify, double hoursWorked, boolean turn,double heigth, int age) {
        super(name, surnames, id, employeeNumber, qualify,hoursWorked,turn);
        this.weight = heigth;
        this.age = age;
    }

    public double getHeigth() {
        return weight;
    }

    public void setHeigth(double heigth) {
        this.weight = heigth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void calculateSalary(double hours,HeavyMachinery maquinery) {
        this.setSalary(hours*this.getPriceForHour());//se calcula el salario por horas trabajadas
        //se valida el turno en el que grabaja, si trabaja de noche ganan el doble
        if (this.getTurn()==false) {
            this.setSalary(this.getSalary()*2);
        }
        switch(maquinery.getType()){
            //vagoneta
            case 1:
                this.setSalary(this.getSalary()+6);
                break;
                //grua
            case 2:
                this.setSalary(this.getSalary()+8);
                break;
                //montacarga
            case 3:
                this.setSalary(this.getSalary()+14);
                break;
        }
        super.calculateSalary(this.getSalary()); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "the driver's salary for heavy machinery type: "+maquinery.getType()+" is: "+this.getSalary());
    }
    public String toString(){
        return "Name: " + this.getName() +"\n"+
                "Surnames: " + this.getSurnames() +"\n"+
                "Salary: " + String.valueOf(this.getSalary()) +"\n"+
                "ID: " + this.getId() + "\n"+
                "Employee Number: " + this.getEmployeeNumber() +"\n"+
                "Is qualified: " + String.valueOf(this.isQualify())+"\n"+
                "Worked Hours: "+String.valueOf(this.getHoursWorked())+"\n"+
                "Turn: "+String.valueOf(this.getTurn())+"\n"+
                "Typer of Driver: "+String.valueOf(this.getTypeDriver())+"\n"+
                "Driver weigth"+String.valueOf(weight)+"\n"+
                " Age: "+String.valueOf(age);
    }
    
}
