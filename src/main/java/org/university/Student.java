package org.university;

public class Student extends Person{

    private int idStudent;
    private String nameStudent;
    private String lastNameStudent;
    private int ageStudent;


    public Student(int idStudent, String nameStudent, String lastNameStudent, int ageStudent){
        super(nameStudent,lastNameStudent,ageStudent);
        this.idStudent=idStudent;
    }
    public int getIdStudent(){
        return idStudent;
    }
    public void setIdStudent(int idStudent){
        this.idStudent=idStudent;
    }

    @Override
    public void displayInfoPerson(){
        super.displayInfoPerson();
        System.out.println("Student Id: " + getIdStudent());

    }


}
