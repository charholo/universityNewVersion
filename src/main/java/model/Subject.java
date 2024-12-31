package model;

import java.util.ArrayList;

public class Subject {
    private int id;
    private String name;
    private String classRoom;
    private ArrayList<Student> storeStudentsBySubject;
    private ArrayList<Teacher> storeTeacherBySubject;

    public Subject(int id, String nameSubject,String classRoom){
        this.id=id;
        this.classRoom=classRoom;
        this.name=nameSubject;
        this.storeStudentsBySubject = new ArrayList<>();
        this.storeTeacherBySubject = new ArrayList<>();
    }

    public int getId(){
        return id;
    }
    public String getNameSubject(){
        return name;
    }
    public String getClassRoom(){
        return classRoom;
    }

    public String getIdTeacher(){
        String name = "";
        for (Teacher teacher : storeTeacherBySubject) {
            name = teacher.getName() + " " + teacher.getLastName();
        }
        return name;
    }

    public void addStudent(Student student){
        storeStudentsBySubject.add(student);
    }

    public void addTeacher(Teacher teacher){
        storeTeacherBySubject.add(teacher);
    }

    public void getStudentsToSubject() {
        for (Student student : storeStudentsBySubject) {
            student.getInfoPerson();
            }
    }

    public void getStudentsById(int student) {
        for (Student studentById : storeStudentsBySubject) {
            if (student == studentById.getId()){
                System.out.println(" ");
                System.out.println("Subject: " + name + " Code: " + getId());
                studentById.getInfoPerson();
            }
        }
    }

    @Override
    public String toString() {
        System.out.println("***************************************************************************************************************************");
        return "Subject Code: " + getId() + " -- to  " + getNameSubject() + " -- Teacher : " + getIdTeacher() + " -- Class: " + getClassRoom() + "\r";
    }
}
