package service;

import model.Teacher;

public class TeacherFullTime extends Teacher {
    private int id;
    private double salary;
    private double seniorityExperience;


    public TeacherFullTime(int id, String name,String lastName, double salary, double seniorityExperience){
        super(name,lastName);
        this.id=id;
        this.salary=salary;
        this.seniorityExperience= seniorityExperience;
    }
    public TeacherFullTime(){
    }

    public int getId(){
        return id;
    }
    public double getSalary(){
        return salary;
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
        System.out.println("Teacher Code: " + getId() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " experience " + getSeniorityExperience()+ " years ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public double calculateSalary (double salary, double seniorityExperience){
        return salary * (1 + 0.1 * seniorityExperience);
    }
}
