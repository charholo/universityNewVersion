package model;

public abstract class Teacher extends Person {

    public Teacher(int id, String name,String lastName){
        super(id, name,lastName);
    }
    public Teacher(){
    }

    public abstract void displayInfoPerson();

    public abstract double calculateSalary(double salary, double seniorityExperience);

}
