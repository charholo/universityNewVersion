package model;

public class Person {

    private String name;
    private String lastName;
    private int id;

    public Person(int id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    public Person(){
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public String getLastName(){
        return lastName;
    }
    public void displayInfoPerson(){
        System.out.println(getName() + " " + getLastName());
    }
}
