package model;

public abstract class Teacher extends Person {

    public Teacher(String name,String lastName){
        super(name,lastName);
    }
    public Teacher(){
    }

    public abstract void displayInfoTeacher();

    public abstract void displayInfoPerson();

    public abstract double calculateSalary(double salary, double seniorityExperience);

}
