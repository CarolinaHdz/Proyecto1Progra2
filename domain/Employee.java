/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

public class Employee implements Serializable{
    
    private String name;
    private String surnames;
    private double salary;
    private String id;
    private String employeeNumber;
    private boolean qualify;//false si no está calificado y true si si lo está

    public Employee() {
        this.name="";
        this.surnames="";
        this.salary=0;
        this.id="";
        this.employeeNumber="";
        this.qualify=false;
    }

    public Employee(String name, String surnames, double salary, String id, String employeeNumber, boolean qualify) {
        this.name = name;
        this.surnames = surnames;
        this.salary = salary;
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.qualify=qualify;
    }

    public Employee(String name, String surnames, String id, String employeeNumber, boolean qualify) {
        this.name = name;
        this.surnames = surnames;
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.qualify = qualify;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean isQualify() {
        return qualify;
    }

    public void setQualify(boolean qualify) {
        this.qualify = qualify;
    }

    @Override
    public String toString() {
        return "Employee: \n" + 
                "Name: " + name +"\n"+
                "Surnames: " + surnames +"\n"+
                "Salary: " + salary + "\n"+
                "ID: " + id + "\n"+
                "Employee Number:" + employeeNumber +"\n"+
                "Is qualified?: " + String.valueOf(qualify );
    }
    
  
    public void calculateSalary(double fixedSalary) { 
       double porcent=fixedSalary*0.0395;
//        double porcent=fixedSalary/(3.95);
        if(qualify==true)
           salary=salary+porcent;    
    }//calculeSalary
    
    
    
    
}//class
