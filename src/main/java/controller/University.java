package controller;
import helpers.Utilities;
import model.Student;
import model.Subject;
import model.Teacher;
import service.TeacherFullTime;
import service.TeacherPartTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University extends Utilities {
    public List<Teacher> teacherDatabase = new ArrayList<>();
    public List<Student> studentDatabase = new ArrayList<>();
    public List<Subject> subjectDatabase = new ArrayList<>();

    int idSubjectToAsociateStudent, randomStudentId,studentAge,idTeacherToAsociateSubject,studentId, randomSubjectId,menuOptionTeacher,randomTeacherId;
    String studentName,studentLastName,subjectName,classRoom,teacherName,teacherLastName;
    double teacherSalary,seniorityExperience;
    Scanner read = new Scanner(System.in);

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
        //initialize Teacher to Subject
        searchSubjects(1000).addTeacher(searchTeacher(10));
        searchSubjects(1001).addTeacher(searchTeacher(20));
        searchSubjects(1002).addTeacher(searchTeacher(10));
        searchSubjects(1003).addTeacher(searchTeacher(20));
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

    public void createStudent(int studentsToCreate){
        for (int i = 1; i <= studentsToCreate; i ++){
            System.out.println("\n");
            randomStudentId = getRandomNumberId(Utilities.RandomIdentifier.STUDENT);
            System.out.println(randomStudentId + " Automatical ID " + " to Student "  + i);
            System.out.println("Enter NAME of student "+ i);
            studentName = read.next();
            System.out.println("Enter LASTNAME of student " + i);
            studentLastName = read.next();
            System.out.println("Enter AGE of student" + i);
            studentAge = read.nextInt();
            studentDatabase.add(new Student(randomStudentId, studentName, studentLastName, studentAge));
            do {
                cleanConsole();
                printSubjects();
                System.out.println("Select one available subject id to asociate Student " + i);
                idSubjectToAsociateStudent = read.nextInt();

            }while (searchSubjects(idSubjectToAsociateStudent) == null);
            searchSubjects(idSubjectToAsociateStudent).addStudent(searchStudent(randomStudentId));
            }
        }

    public void createSubject(int subjectsToCreate){
        for (int j = 1; j <= subjectsToCreate; j ++){

            randomSubjectId = getRandomNumberId(Utilities.RandomIdentifier.SUBJECT);
            System.out.println(randomSubjectId + " Automatical ID" + " to Subject "  + j);
            System.out.println("Enter NAME of Subject "+ j);
            subjectName = read.next();
            System.out.println("Enter ClassRoom of teacher " + j);
            classRoom = read.next();
            subjectDatabase.add(new Subject(randomSubjectId, subjectName, classRoom));
            printTechers();
            do {
                System.out.println("please enter correct teacher Id");
                idTeacherToAsociateSubject = read.nextInt();
                printTechers();
            }while (searchTeacher(idTeacherToAsociateSubject) == null);
            searchSubjects(randomSubjectId).addTeacher(searchTeacher(idTeacherToAsociateSubject));
            cleanConsole();
            printStudents();
            do {
                System.out.println(" ");
                System.out.println("Please enter correct Student: " + subjectName);
                studentId = read.nextInt();
                cleanConsole();
                printStudents();
            }while (searchStudent(studentId) == null);
            cleanConsole();
            searchSubjects(randomSubjectId).addStudent(searchStudent(studentId));
        }
    }
    public void createTeacher(int teachersToCreate){
        for (int t = 1; t <= teachersToCreate; t ++){
            randomTeacherId = getRandomNumberId(Utilities.RandomIdentifier.TEACHER);
            System.out.println(randomTeacherId + " Automatical ID " + " to teacher "  + t);
            System.out.println("Enter NAME of teacher "+ t);
            teacherName = read.next();
            System.out.println("Enter LASTNAME of teacher " + t);
            teacherLastName = read.next();
            System.out.println("Enter SALARY of teacher" + t);
            teacherSalary = read.nextDouble();
            System.out.println("Select option to create teacher" + t);
            System.out.println("1. Full time");
            System.out.println("2. Part time");
            menuOptionTeacher = read.nextInt();

            if (menuOptionTeacher == 1){
                System.out.println("To full time teacher please enter year of expiriences " + t);
                seniorityExperience = read.nextInt();
                TeacherFullTime objectToCalculatefullTimeSalary = new TeacherFullTime();
                double finalSalary = objectToCalculatefullTimeSalary.calculateSalary(teacherSalary, seniorityExperience);
                teacherDatabase.add(new TeacherFullTime(randomTeacherId, teacherName, teacherLastName, finalSalary,seniorityExperience));
            }else if (menuOptionTeacher == 2){
                System.out.println("To part  time teacher please enter hours per week  " + t);
                seniorityExperience = read.nextInt();
                TeacherPartTime objectToCalculatefullPartTimeSalary = new TeacherPartTime();
                double finalSalary = objectToCalculatefullPartTimeSalary.calculateSalary(teacherSalary, seniorityExperience);
                teacherDatabase.add(new TeacherPartTime(randomTeacherId, teacherName, teacherLastName, finalSalary,seniorityExperience));
            }else {
                System.out.println("Sorry wrong option");
            }
         }
    }

    public void listAllSubjectByStudent(int studentId){
        for (Subject key : subjectDatabase){
            searchSubjects(key.getId()).getStudentsById(studentId);
        }
    }
}