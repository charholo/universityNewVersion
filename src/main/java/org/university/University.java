package org.university;
import java.util.HashMap;
import java.util.ArrayList;

public class University {
    public static void main(String[] args) {
        ArrayList<Integer> idsStudents;

        //Database HashMap Teacher
        HashMap<Integer, Teacher> teacherDatabase = new HashMap<>();
        teacherDatabase.put(10, new Teacher(1, "Teacher1", "Bruno", 40000,100));
        teacherDatabase.put(20, new Teacher(2,"Teacher2", "Rios", 3000, 101));

        //Database HashMap Students
        HashMap<Integer, Student> studentDatabase = new HashMap<>();
        studentDatabase.put(1, new Student(1, "Charles", "Holguin", 41));
        studentDatabase.put(2, new Student(2,"Liz", "Gonzalez", 35));

        //Crear Subject
        Subject subjectJava = new Subject("Java");

        // Assign a teacher by ID
        Integer teacherID = 10;
        if (teacherDatabase.containsKey(teacherID)) {
            subjectJava.assignTeacherToSubject((teacherDatabase.get(teacherID)));
        } else {
            System.out.println("Teacher with ID " + teacherID + " not found.");
        }

        // Enroll students by ID
        //int[] studentIDs = {1,2};
        idsStudents = new ArrayList<>();
        idsStudents.add(1);
        for (int studentID : idsStudents) {
            if (studentDatabase.containsKey(studentID)) {
                subjectJava.addStudent((studentDatabase.get(studentID)));
            } else {
                System.out.println("Student with ID " + studentID + " not found.");
            }
        }


        System.out.println("Mostrar data profesores");
        Teacher teacher1 = new Teacher(11,"Felipe","Gomez",4000,1);
        teacher1.displayInfoPerson();

        Student studen1 = new Student(10,"Charles","Holguín",40);
        studen1.displayInfoPerson();

        Student studen2 = new Student(11,"Liz","Rios",30);
        studen2.displayInfoPerson();

        subjectJava.addStudent(studen1);
        subjectJava.addStudent(studen2);

        System.out.println("");
        System.out.println("displayStudents: ");
        subjectJava.displayStudents();

        System.out.println("");
        Student newStudent = new Student(777,"Test","CH",18);
        subjectJava.addStudent(newStudent);
        System.out.println("new student ch");
        subjectJava.displayStudents();

        // Display subject details
        System.out.println("Detalles de la subject ");
        subjectJava.displaySubjectDetails();


    }
}
