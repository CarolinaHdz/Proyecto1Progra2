
package domain;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class Administrative extends Employee implements Serializable{
    private int category;
    private String academyGrade;
    private double fixedSalary;
    
    public Administrative() {
        super();
        this.category = 0;
        this.academyGrade = "Unspecified";
        this.fixedSalary=0;
    }
    
    public Administrative(int category, String academyGrade, double fixedSalary) {
        super();
        this.category = category;
        this.academyGrade = academyGrade;
        this.fixedSalary= fixedSalary;
    }

    public Administrative(String name, String surnames, String id, String employeeNumber, boolean qualify, String academyGrade,int category) {
        super(name, surnames, id, employeeNumber, qualify);
        this.category = category;
        this.academyGrade = academyGrade;
        this.fixedSalary= fixedSalary;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAcademyGrade() {
        return academyGrade;
    }

    public void setAcademyGrade(String academyGrade) {
        this.academyGrade = academyGrade;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public void calculateSalary(double fixedSalary) {
        if (this.category==1) {
            this.setSalary(250);
//            JOptionPane.showMessageDialog(null,"El salario del administrativo categoría: "+this.category+" es de: "+this.getSalary());
        } else if(this.category==2){
            this.setSalary(250+(250/5));
//            JOptionPane.showMessageDialog(null,"El salario del administrativo categoría: "+this.category+" es de: "+this.getSalary());
        }else{
            JOptionPane.showMessageDialog(null,"Category not specified");
        }
        super.calculateSalary(this.getSalary()); //To change body of generated methods, choose Tools | Templates.
        JOptionPane.showMessageDialog(null,"The administrative category: " +this.category+ " salary is: "+this.fixedSalary);
    }
    public String toString(){
        return "Employee \n" + "Name: " + this.getName() +"\n"+
                "Surnames: " + this.getSurnames() + "\n"+
                "Salary: " + String.valueOf(this.getSalary()) +"\n"+
                "ID: " + this.getId() + "\n"+
                "Employee Number: " + this.getEmployeeNumber() +"\n"+
                "Is qualified?:  " + String.valueOf(this.isQualify())+"\n"+
                "Academy Grade: "+this.academyGrade+"\n"+
                "Category: "+this.category;
    }
    
    
}//employee

