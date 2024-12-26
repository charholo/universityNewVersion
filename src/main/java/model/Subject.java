package model;

import java.util.ArrayList;

public class Subject {
    private int id;
    private String nameSubject;
    private String classRoom;
    private Teacher teacher;
    private ArrayList<Student> storeStudentsBySubject;
    private ArrayList<Teacher> storeTeacherBySubject;

    public Subject(int id, String nameSubject,String classRoom){
        this.id=id;
        this.classRoom=classRoom;
        this.nameSubject=nameSubject;
        this.storeStudentsBySubject = new ArrayList<>();
        this.storeTeacherBySubject = new ArrayList<>();
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

    public String getIdTeacher(){
        String name = "";
        for (Teacher teacher : storeTeacherBySubject) {
            name = teacher.getName() + " " + teacher.getLastName();
        }
        return name;
    }

    public void addStudent(Student student){
        storeStudentsBySubject.add(student);
        System.out.println(student.getName() + " Has been added " + nameSubject);
    }

    public void addTeacher(Teacher teacher){
        storeTeacherBySubject.add(teacher);
        System.out.println(teacher.getName() + " Has been added " + nameSubject);
    }

    public void displayStudents() {
        for (Student student : storeStudentsBySubject) {
            student.displayInfoPerson();
        }
    }

    public void displayStudentsById(int student) {
        for (Student studentById : storeStudentsBySubject) {
            if (student == studentById.getId()){
                System.out.println(" ");
                System.out.println("Subject: " + nameSubject + " Code: " + getId());
                studentById.displayInfoPerson();
            }
        }
    }

    public void displaySubjects(){
        System.out.println("***************************************************************************************************************************");
        System.out.println("Subject Code old: " + getId() + " ------ to  " + getNameSubject() + " ------ Teacher code asociate : " + getIdTeacher()  + " -------- Class code asociate: " +getClassRoom());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString(){
        return  "Subject Code: " + getId() + " ------ to  " + getNameSubject() + " ------ Teacher code asociate : " + getIdTeacher()  + " -------- Class code asociate: " + getClassRoom() + "\r\n";
    }
}
