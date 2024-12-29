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
    private static List<Teacher> teacherDatabase = new ArrayList<>();
    private static List<Student> studentDatabase = new ArrayList<>();
    private static List<Subject> subjectDatabase = new ArrayList<>();

    public static void main(String[] args) {
        int menuOption,menuOptionTeacher, showSubject,numberStudentToCreate,studentAge,idSubjectToAsociateStudent,numberSubjectToCreate,idTeacherToAsociateSubject,studentId,numberTeacherToCreate,isFullTime,randomStudentId,randomSubjectId,randomTeacherId;
        String studentName,studentLastName,subjectName,classRoom,teacherName,teacherLastName;
        double teacherSalary,seniorityExperience;
        Scanner read = new Scanner(System.in);
        initData();

        do{
            printMenu();
            menuOption = read.nextInt();

            switch (menuOption) {

                case 1:
                    System.out.println("****List of all teachers****");
                    printTechers();
                    break;

                case 2:
                    System.out.println(" ");
                    printSubjects();
                    System.out.println(" ");
                    System.out.println("Please enter id of Subject to display information of class");
                    showSubject = read.nextInt();
                    searchSubjects(showSubject).displaySubjects();
                    searchSubjects(showSubject).getStudentsToSubject();
                    break;

                case 3:
                    System.out.println("How many students do you need register?");
                    numberStudentToCreate = read.nextInt();

                    for (int i = 1; i <= numberStudentToCreate; i ++){
                        System.out.println("\n");
                        randomStudentId = getRandomNumberId(RandomIdentifier.STUDENT);
                        System.out.println(randomStudentId + " Automatical ID " + " to Student "  + i);
                        System.out.println(" ");
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
                    break;

                case 4:
                    System.out.println("How many Subjects do you need create?");
                    numberSubjectToCreate = read.nextInt();

                    for (int j = 1; j <= numberSubjectToCreate; j ++){

                        randomSubjectId = getRandomNumberId(RandomIdentifier.SUBJECT);
                        System.out.println(randomSubjectId + " Automatical ID" + " to Subject "  + j);
                        System.out.println("Enter NAME of Subject "+ j);
                        subjectName = read.next();
                        System.out.println("Enter ClassRoom of teacher " + j);
                        classRoom = read.next();

                        subjectDatabase.add(new Subject(randomSubjectId, subjectName, classRoom));


                        printTechersIds();
                        do {
                            System.out.println("please enter correct teacher Id");
                            idTeacherToAsociateSubject = read.nextInt();
                            cleanConsole();
                            printTechersIds();
                        }while (searchTeacher(idTeacherToAsociateSubject) == null);

                        searchSubjects(randomSubjectId).addTeacher(searchTeacher(idTeacherToAsociateSubject));

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


                    break;

                case 5:
                    System.out.println("Enter StudentID");
                    studentId = read.nextInt();

                    for (Subject key : subjectDatabase){
                        searchSubjects(key.getId()).displayStudentsById(studentId);

                    }
                    break;

                case 6:
                    System.out.println("How many Teachers do you need create?");
                    numberTeacherToCreate = read.nextInt();

                    for (int t = 1; t <= numberTeacherToCreate; t ++){

                        randomTeacherId = getRandomNumberId(RandomIdentifier.TEACHER);
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
                    break;

                case 7:
                    System.out.println("Program Finish!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unavailable option!");
                    System.out.println("¿Return to menu?");
                    System.out.println("0 = Yes or 8 = No");
                    menuOption = read.nextInt();
                    break;

            }
        }

        while(menuOption!=8);

    }

    static void initData(){
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

    private static void printMenu(){
        System.out.println("\n");
        System.out.println("**** Wellcome to the University **** \n");
        System.out.println("1: Print all the profesors with its data");
        System.out.println("2: Print all the classes and a submenu by subject id");
        System.out.println("3: Create a new Student and add an existing Class");
        System.out.println("4: Create a new class and add and existing teacher & student");
        System.out.println("5: List all the clases given student is included (search by id) ");
        System.out.println("6: Create Teacher ");
        System.out.println("7: Exit");
        System.out.print("To continue select any option: ");
        System.out.println(" ");

    }

    private static void printSubjects(){
        System.out.println(" ");
        /*for (Integer key : subjectDatabase.keySet()){
            //subjectDatabase.get(key).displaySubjects();
            subjectDatabase.get(key).toString();
        }

         */
        System.out.println(subjectDatabase);
    }

    private static Subject searchSubjects(int idSubject){
        Subject subjectObject = null;
        for (Subject subjectObjectLoop : subjectDatabase){
            if (subjectObjectLoop.getId() == idSubject) {
                subjectObject = subjectObjectLoop;
                return subjectObject;
            }
        }
        return subjectObject;
    }

    private static Teacher searchTeacher(int idTeacher){
        Teacher teacherObject = null;
        for (Teacher teacherObjectLoop : teacherDatabase){
            if (teacherObjectLoop.getId() == idTeacher) {
                teacherObject = teacherObjectLoop;
                return teacherObject;
            }
        }
        return teacherObject;
    }

    private static Student searchStudent (int idStudent){
        Student studentObject = null;
        for (Student studentObjectLoop : studentDatabase){
            if (studentObjectLoop.getId() == idStudent) {
                studentObject = studentObjectLoop;
                return studentObject;
            }
        }
        return studentObject;
    }



    private static void printTechers(){
        /*for (Integer key : teacherDatabase.keySet()){
            teacherDatabase.get(key).displayInfoPerson();
        }

         */

        System.out.println(teacherDatabase);
    }
    private static void printStudents(){
        System.out.println(" ");
        /*for (Integer key : studentDatabase.keySet()){
            studentDatabase.get(key).displayInfoPerson();
        }
        */
        System.out.println(studentDatabase);
    }
    private static void printTechersIds(){
        /*for (Integer key : teacherDatabase.keySet()){
            teacherDatabase.get(key).displayInfoTeacher();
            System.out.println("------------------------------");
        }

         */
        System.out.println(teacherDatabase);
    }

    private static void cleanConsole(){
        for (int i = 0; i < 80; i++) {
            System.out.println();
        }
    }

}
