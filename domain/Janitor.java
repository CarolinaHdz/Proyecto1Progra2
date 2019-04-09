/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class Janitor extends Employee implements Serializable{
    private int extraHours;
    private double fixedSalary;
    
    
    public Janitor() {
        super();
        this.extraHours = 0;
        this.fixedSalary = 120;
    }
    
    public Janitor(int extraHours) {
        super();
        this.extraHours = extraHours;
        this.fixedSalary = 120;
    }

    public Janitor(String name, String surnames, double salary, String id, String employeeNumber, boolean qualify,int extraHours) {
        super(name, surnames, salary, id, employeeNumber, qualify);
        this.extraHours = extraHours;
        this.fixedSalary = 120;
    }

    public Janitor(String name, String surnames, String id, String employeeNumber, boolean qualify,int extraHours) {
        super(name, surnames, id, employeeNumber, qualify);
        this.extraHours = extraHours;
    }
    
    

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(float fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public void calculateSalary(double fixedSalary) {
        this.setSalary(120);
        if (this.extraHours>0) {
            for (int i = 0; i < this.extraHours; i++) {
                this.setSalary(this.getSalary()+(this.fixedSalary/4));
            }
        }
        super.calculateSalary(this.getSalary()); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null, "The janitor's salary is: "+this.getSalary());
    }
    
    public String toString(){
        return  "Name: " + this.getName() + "\n"+
                "Surnames: " + this.getSurnames() +"\n"+
                "Salary: " + String.valueOf(this.getSalary()) +"\n"+
                "ID: " + this.getId() +"\n"+
                "Employee Number: " + this.getEmployeeNumber()+"\n"+ 
                "Is qualified?: " + String.valueOf(this.isQualify())+"\n"+
                "Extra Hours: "+String.valueOf(extraHours);
    }
    
    
    
}
