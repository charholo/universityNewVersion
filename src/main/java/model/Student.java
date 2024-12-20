package model;

public class Student extends Person {

    private int id;
    private int age;

    public Student(int id, String name, String lastName, int age){
        super(name,lastName);
        this.id=id;
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("-------------------------------------");
        super.displayInfoPerson();
        System.out.println("Cod:" + getId() + " " + getAge()+ " years old" );
    }
}
