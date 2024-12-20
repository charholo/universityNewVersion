package model;

public class Person {

    private String name;
    private String lastName;

    public Person(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }
    public Person(){
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public void displayInfoPerson(){
        System.out.println(getName() + " " + getLastName());
    }
}
