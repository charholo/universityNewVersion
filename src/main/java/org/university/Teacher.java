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
    public double getSalary(){
        return salary;
    }

    public void displayInfoTeacher(){
        System.out.println("Id: " + getIdTeacher() );
        super.displayInfoPerson();
    }

    @Override
    public void displayInfoPerson(){
        super.displayInfoPerson();
        System.out.println("Id: " + getIdTeacher() + " Salary: " + getSalary() );
    }

}
