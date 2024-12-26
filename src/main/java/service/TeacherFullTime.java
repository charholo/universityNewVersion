package service;

import model.Teacher;

public class TeacherFullTime extends Teacher {
    //private int id;
    private double baseSalary;
    private double seniorityExperience;


    public TeacherFullTime(int id, String name,String lastName, double baseSalary, double seniorityExperience){
        super(id,name,lastName);
        //this.id=id;
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
    public void displayInfoTeacher(){
        System.out.println("Id: " + getId() + " " + getName() + " " + getLastName());
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Teacher Code OLD: " + getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " experience " + getSeniorityExperience()+ " years ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString(){
        return  "Teacher Code: " + super.getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " experience " + getSeniorityExperience()+ " years ";
    }

    @Override
    public double calculateSalary (double baseSalary, double seniorityExperience){
        return baseSalary * (1 + 0.1 * seniorityExperience);
    }
}
