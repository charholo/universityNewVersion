package model;

public class Student extends Person {

    //private int id;
    private int age;

    public Student(int id, String name, String lastName, int age){
        super(id, name,lastName);
        //this.id=id;
        this.age = age;
    }
    public int getId(){
        return super.getId();
    }
    public int getAge(){
        return age;
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("-------------------------------------");
        super.displayInfoPerson();
        System.out.println("Cod old:" + getId() + " " + getAge()+ " years old" );
    }

    @Override
    public String toString(){
        return  "Code: " + getId() + " " + super.getName() + " " + super.getLastName() + " " + getAge() + " years old" + "\r";
    }
}
