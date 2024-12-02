package org.university;

public class University {
    public static void main(String[] args) {

        Student studen1 = new Student(10,"Charles","Holguín",40);
        studen1.displayInfoPerson();

        System.out.println("");
        Teacher teacher1 = new Teacher(11,"Felipe","Gomez",4000,1);
        teacher1.displayInfoPerson();
    }
}
