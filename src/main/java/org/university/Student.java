package org.university;

public class Student extends Person{

    private int idStudent;
    private String nameStudent;
    private String lastNameStudent;
    private int ageStudent;


    public Student(int idStudent, String nameStudent, String lastNameStudent, int ageStudent){
        super(nameStudent,lastNameStudent);
        this.idStudent=idStudent;
        this.ageStudent = ageStudent;
    }
    public int getIdStudent(){
        return idStudent;
    }
    public void setIdStudent(int idStudent){
        this.idStudent=idStudent;
    }
    public int getAgeStudent(){
        return ageStudent;
    }
    public void setAgeStudent(int ageStudent){
        this.ageStudent=ageStudent;
    }

    @Override
    public void displayInfoPerson(){
        super.displayInfoPerson();
        System.out.println("Student Id: " + getIdStudent());
        System.out.println("Student Age:" + getAgeStudent());

    }


}
