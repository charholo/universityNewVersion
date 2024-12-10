package org.university;

public class Person {

    private String name;
    private String lastName;

    public Person(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
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
