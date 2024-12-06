package org.university;

import java.util.ArrayList;

public class Subject {
    private int id;
    private String nameSubject;
    private String classRoom;
    private int idTeacher;
    private ArrayList<Student> storeStudentsBySubject;
    private Teacher teacher;


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


    public void assignTeacherToSubject(Teacher teacher){
        this.teacher = teacher;
        System.out.println(teacher.getName() + " has been assigned to " + nameSubject);
    }


    public void addStudent(Student student){
        storeStudentsBySubject.add(student);
        System.out.println(student.getName() + " Has been added " + nameSubject);
    }

    public void displayStudents() {
        for (Student student : storeStudentsBySubject) {
            System.out.println("pruebaaaa " + student.getIdStudent());
            student.displayInfoPerson();
        }
    }

    public void displayStudentsById(int student) {
        for (Student studentById : storeStudentsBySubject) {
            if (student == studentById.getIdStudent()){
                System.out.println("Subject: " + nameSubject);
                studentById.displayInfoPerson();
            }
        }
    }

    public void displaySubjectDetails() {
        //System.out.println(nameSubject);
        if (teacher != null) {
            //System.out.println("Teacher:");
            teacher.displayInfoTeacher();
        } else {
            System.out.println("No teacher assigned yet.");
        }
    }

    public void displaySubjects(){
        System.out.println(getId() + " - " + getNameSubject());
    }
}
