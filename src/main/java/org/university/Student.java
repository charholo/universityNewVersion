package org.university;

public class Student extends Person{

    private int idStudent;
    private int ageStudent;

    public Student(int idStudent, String nameStudent, String lastNameStudent, int ageStudent){
        super(nameStudent,lastNameStudent);
        this.idStudent=idStudent;
        this.ageStudent = ageStudent;
    }
    public int getIdStudent(){
        return idStudent;
    }
    public int getAgeStudent(){
        return ageStudent;
    }

    @Override
    public void displayInfoPerson(){
        System.out.println("-------------------------------------");
        super.displayInfoPerson();
        System.out.println("Cod:" + getIdStudent() + " " + getAgeStudent()+ " years old" );
    }
}
