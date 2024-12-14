package org.university;

public class TeacherFullTime extends Teacher{
    private int idTeacher;
    private double salary;
    private double seniorityExperience;


    public TeacherFullTime(int idTeacher, String nameTeacher,String lastNameTeacher, double salary, double seniorityExperience){
        super(nameTeacher,lastNameTeacher);
        this.idTeacher=idTeacher;
        this.salary=salary;
        this.seniorityExperience= seniorityExperience;
    }
    public TeacherFullTime(){
    }

    public int getIdTeacher(){
        return idTeacher;
    }
    public double getSalary(){
        return salary;
    }
    public double getSeniorityExperience(){
        return seniorityExperience;
    }
    @Override
    public void displayInfoTeacher(){
        System.out.println("Id: " + getIdTeacher() );
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Teacher Code: " + getIdTeacher() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " experience " + getSeniorityExperience()+ " years ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public double calculateSalary (double salary, double seniorityExperience){
        return salary * (1 + 0.1 * seniorityExperience);
    }
}
