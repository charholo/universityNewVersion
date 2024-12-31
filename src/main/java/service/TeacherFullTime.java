package service;

import model.Teacher;

public class TeacherFullTime extends Teacher {
    private double baseSalary;
    private double seniorityExperience;


    public TeacherFullTime(int id, String name,String lastName, double baseSalary, double seniorityExperience){
        super(id,name,lastName);
        this.baseSalary=baseSalary;
        this.seniorityExperience= seniorityExperience;
    }
    public TeacherFullTime(){
    }

    public int getId(){
        return super.getId();
    }
    public double getSalary(){
        return baseSalary;
    }
    public double getSeniorityExperience(){
        return seniorityExperience;
    }

    @Override
    public String toString(){
        return  "Code: " + super.getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " experience " + getSeniorityExperience()+ " years ";
    }

    @Override
    public double calculateSalary (double baseSalary, double seniorityExperience){
        return baseSalary * (1 + 0.1 * seniorityExperience);
    }
}
