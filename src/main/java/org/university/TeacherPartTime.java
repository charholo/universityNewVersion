package org.university;

public class TeacherPartTime extends Teacher{
    private int idTeacher;
    private double salary;
    private double hoursPerWeek;


    public TeacherPartTime(int idTeacher, String nameTeacher,String lastNameTeacher, double salary, double hoursPerWeek){
        super(nameTeacher,lastNameTeacher);
        this.idTeacher=idTeacher;
        this.salary=salary;
        this.hoursPerWeek= hoursPerWeek;
    }
    public TeacherPartTime(){
    }

    public int getIdTeacher(){
        return idTeacher;
    }
    public double getSalary(){
        return salary;
    }
    public double getHoursPerWeek(){
        return hoursPerWeek;
    }
    @Override
    public void displayInfoTeacher(){
        System.out.println("Id: " + getIdTeacher() + " " + getName() + " " + getLastName());
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Teacher Code: " + getIdTeacher() + " " + super.getName() + " " +  super.getLastName() + " " + " Salary: " + getSalary() + " Us " + " Hours per week " + getHoursPerWeek());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public double calculateSalary (double salary, double getHoursPerWeek){
        return salary * (00.1 * getHoursPerWeek);
    }
}
