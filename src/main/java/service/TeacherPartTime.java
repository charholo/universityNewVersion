package service;

import model.Teacher;

public class TeacherPartTime extends Teacher {
    private int id;
    private double salary;
    private double hoursPerWeek;


    public TeacherPartTime(int id, String name,String lastName, double salary, double hoursPerWeek){
        super(name,lastName);
        this.id=id;
        this.salary=salary;
        this.hoursPerWeek= hoursPerWeek;
    }
    public TeacherPartTime(){
    }

    public int getId(){
        return id;
    }
    public double getSalary(){
        return salary;
    }
    public double getHoursPerWeek(){
        return hoursPerWeek;
    }
    @Override
    public void displayInfoTeacher(){
        System.out.println("Id: " + getId() + " " + getName() + " " + getLastName());
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Teacher Code: " + getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " Hours per week " + getHoursPerWeek());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public double calculateSalary (double salary, double getHoursPerWeek){
        return salary * (00.1 * getHoursPerWeek);
    }
}
