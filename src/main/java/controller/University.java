package controller;
import helpers.Utilities;
import model.Student;
import model.Subject;
import model.Teacher;
import service.TeacherFullTime;
import service.TeacherPartTime;
import java.util.ArrayList;
import java.util.List;

public class University extends Utilities {
    public List<Teacher> teacherDatabase = new ArrayList<>();
    public List<Student> studentDatabase = new ArrayList<>();
    public List<Subject> subjectDatabase = new ArrayList<>();



    public void initData(){
        //initialize Database Teacher
        teacherDatabase.add(new TeacherFullTime(10, "Felipe", "Jiménez", 4000,8));
        teacherDatabase.add(new TeacherPartTime(20,"Santiago", "Ponce de Leon", 4000,40));
        //initialize Database Students
        studentDatabase.add(new Student(1,"Charholo","Holguin",31));
        studentDatabase.add(new Student(2,"Lizfer","Rios",34));
        studentDatabase.add(new Student(3,"Cesar","Ramirez",22));
        studentDatabase.add(new Student(4,"Jaime","Arias",36));
        studentDatabase.add(new Student(5,"Luisa","Montes",19));
        studentDatabase.add(new Student(6,"Fernanda","Rios",21));
        //initialize Database Subject
        subjectDatabase.add(new Subject(1000,"Java programming","a12"));
        subjectDatabase.add(new Subject(1001,"Poo Python","a12"));
        subjectDatabase.add(new Subject(1002,"Java Script class","a12"));
        subjectDatabase.add(new Subject(1003,"Android class","a12"));
    }


    public void printSubjects() {
    System.out.println("Subjetcs: ");
    for (Subject subject: subjectDatabase){
        System.out.println(subject);
    }

    }

    public Subject searchSubjects(int idSubject){
        Subject subjectObject = null;
        for (Subject subjectObjectLoop : subjectDatabase){
            if (subjectObjectLoop.getId() == idSubject) {
                subjectObject = subjectObjectLoop;
                return subjectObject;
            }
        }
        return subjectObject;
    }

    public Teacher searchTeacher(int idTeacher){
        Teacher teacherObject = null;
        for (Teacher teacherObjectLoop : teacherDatabase){
            if (teacherObjectLoop.getId() == idTeacher) {
                teacherObject = teacherObjectLoop;
                return teacherObject;
            }
        }
        return teacherObject;
    }

    public  Student searchStudent (int idStudent){
        Student studentObject = null;
        for (Student studentObjectLoop : studentDatabase){
            if (studentObjectLoop.getId() == idStudent) {
                studentObject = studentObjectLoop;
                return studentObject;
            }
        }
        return studentObject;
    }



    public void printTechers(){
        System.out.println("Teachers: ");
        for (Teacher teacher : teacherDatabase) {
            System.out.println(teacher);
        }
    }
    public void printStudents(){
        System.out.println("Students: ");
        for (Student student : studentDatabase) {
            System.out.println(student);
        }
    }

    public  void cleanConsole(){
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }

}
