package org.university;

import java.util.ArrayList;

public class Subject {
    private String nameSubject;
    private ArrayList<Student> storeStudentsBySubject;
    private Teacher teacher;


    public Subject(String nameSubject){
        this.nameSubject=nameSubject;
        this.storeStudentsBySubject = new ArrayList<>();
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
            student.displayInfoPerson();
        }
    }

    public void displaySubjectDetails() {
        System.out.println("\nSubject: " + nameSubject);
        if (teacher != null) {
            System.out.println("Teacher:");
            teacher.displayInfoPerson();
        } else {
            System.out.println("No teacher assigned yet.");
        }
    }
}
