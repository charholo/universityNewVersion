package org.university;

public class Teacher extends Person{
    private int idTeacher;
    private double salary;

    public Teacher(int idTeacher, String nameTeacher,String lastNameTeacher, double salary){
        super(nameTeacher,lastNameTeacher);
        this.idTeacher=idTeacher;
        this.salary=salary;
    }

    public int getIdTeacher(){
        return idTeacher;
    }
    public void setIdTeacher(int idTeacher){
        this.idTeacher=idTeacher;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    public double calcSalaryteacher (double salary, int isFullTime){
        double finalSalary = 0;
        if (isFullTime == 1){
            return  (salary * (10 * 1.1)); //10 years of experiences
        } else if (isFullTime == 2) {
            return (salary * (30 * 0.1));// 30 hours per week
        }else
            return finalSalary;
    }

    @Override
    public void displayInfoPerson(){
        super.displayInfoPerson();
        System.out.println("Id: " + getIdTeacher() + " Salary: " + getSalary() );
    }




}
