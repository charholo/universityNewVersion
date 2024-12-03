package org.university;

public class University {
    public static void main(String[] args) {

        Subject subjectJava = new Subject("Java");

        System.out.println("");
        Teacher teacher1 = new Teacher(11,"Felipe","Gomez",4000,1);
        teacher1.displayInfoPerson();

        Student studen1 = new Student(10,"Charles","Holguín",40);
        studen1.displayInfoPerson();

        Student studen2 = new Student(11,"Liz","Rios",30);
        studen2.displayInfoPerson();

        subjectJava.addStudent(studen1);
        subjectJava.addStudent(studen2);

        System.out.println("");
        subjectJava.displayStudents();

        System.out.println("");
        Student newStudent = new Student(777,"Test","CH",18);
        subjectJava.addStudent(newStudent);
        System.out.println("");
        subjectJava.displayStudents();


    }
}
