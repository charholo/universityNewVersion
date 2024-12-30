package service;

import model.Teacher;

public class TeacherPartTime extends Teacher {
    //private int id;
    private double baseSalary;
    private double hoursPerWeek;


    public TeacherPartTime(int id, String name,String lastName, double baseSalary, double hoursPerWeek){
        super(id,name,lastName);
        //this.id=id;
        this.baseSalary=baseSalary;
        this.hoursPerWeek= hoursPerWeek;
    }
    public TeacherPartTime(){
    }

    public int getId(){
        return super.getId();
    }
    public double getSalary(){
        return baseSalary;
    }
    public double getHoursPerWeek(){
        return hoursPerWeek;
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Teacher Code: " + getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " Hours per week " + getHoursPerWeek());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString(){
        return  "Teacher Code: " + super.getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " Hours per week " + getHoursPerWeek();
    }

    @Override
    public double calculateSalary (double baseSalary, double getHoursPerWeek){
        return baseSalary * (00.1 * getHoursPerWeek);
    }
}
