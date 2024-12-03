package org.university;

import java.util.ArrayList;

public class Subject {
    private String nameSubject;
    private ArrayList<Student> storeStudentsBySubject;


    public Subject(String nameSubject){
        this.nameSubject=nameSubject;
        this.storeStudentsBySubject = new ArrayList<>();
    }

    public void addStudent(Student student){
        storeStudentsBySubject.add(student);
        System.out.println(student.getName() + "Has been added " + nameSubject);
    }

    public void displayStudents(){
        for (Student student : storeStudentsBySubject){
            student.displayInfoPerson();
        }
    }
}
