package org.university;

import java.util.ArrayList;

public class Subject {
    private int id;
    private String nameSubject;
    private String classRoom;
    private int idTeacher;
    private Teacher teacher;
    private ArrayList<Student> storeStudentsBySubject;

    public Subject(int id, String nameSubject,String classRoom,int idTeacher){
        this.id=id;
        this.classRoom=classRoom;
        this.idTeacher=idTeacher;
        this.nameSubject=nameSubject;
        this.storeStudentsBySubject = new ArrayList<>();
    }

    public int getId(){
        return id;
    }
    public String getNameSubject(){
        return nameSubject;
    }
    public String getClassRoom(){
        return classRoom;
    }
    public int getIdTeacher(){
        return idTeacher;
    }

    public void addStudent(Student student){
        storeStudentsBySubject.add(student);
        System.out.println(student.getName() + " Has been added " + nameSubject);
    }

    public void displayStudents() {
        for (Student student : storeStudentsBySubject) {
            student.displayInfoPerson();
        }
    }

    public void displayStudentsById(int student) {
        for (Student studentById : storeStudentsBySubject) {
            if (student == studentById.getIdStudent()){
                System.out.println(" ");
                System.out.println("Subject: " + nameSubject);
                studentById.displayInfoPerson();
            }
        }
    }

    public void displaySubjectDetails() {
        if (teacher != null) {
            teacher.displayInfoTeacher();
        }
    }

    public void displaySubjects(){
        System.out.println("***************************************************************************************************************************");
        System.out.println("Subject Code: " + getId() + " ------ to  " + getNameSubject() + " ------ Teacher code asociate : " + getIdTeacher()  + " -------- Class code asociate: " +getClassRoom());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }
}
