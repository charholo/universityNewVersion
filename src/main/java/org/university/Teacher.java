package org.university;

public class Teacher extends Person{
    private int idTeacher;
    private double salary;
    private int subject;

    public Teacher(int idTeacher, String nameTeacher,String lastNameTeacher, double salary, int subject){
        super(nameTeacher,lastNameTeacher);
        this.idTeacher=idTeacher;
        this.salary=salary;
        this.subject=subject;
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
    public int getSubject(){
        return subject;
    }
    public void setSubject(int subject){
        this.subject = subject;

    }



    @Override
    public void displayInfoPerson(){
        super.displayInfoPerson();
        System.out.println("Teacher Id : " + getIdTeacher());
        System.out.println("Salary: " + getSalary());
        System.out.println("Subject id: " + getSubject());
    }




}
