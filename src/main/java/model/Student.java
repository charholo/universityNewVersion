package model;

public class Student extends Person {
    private int age;

    public Student(int id, String name, String lastName, int age){
        super(id, name,lastName);
        this.age = age;
    }
    public int getId(){
        return super.getId();
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return  "Student code: " + getId() + " " + super.getName() + " " + super.getLastName() + " " + getAge() + " years old" + "\r";
    }
}
