package org.university;

public abstract class Teacher extends Person{

    public Teacher(String nameTeacher,String lastNameTeacher){
        super(nameTeacher,lastNameTeacher);
    }
    public Teacher(){
    }

    public abstract void displayInfoTeacher();

    public abstract void displayInfoPerson();

    public abstract double calculateSalary(double salary, double seniorityExperience);

}
