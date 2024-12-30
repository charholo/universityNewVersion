package controller;
import helpers.Utilities;
import model.Student;
import model.Subject;
import service.TeacherFullTime;
import service.TeacherPartTime;
import java.util.Scanner;
import static helpers.Utilities.getRandomNumberId;


public class Menu {

    public static void main(String[] args) {

        University university = new University();

        int menuOption,menuOptionTeacher, showSubject,numberStudentToCreate,studentAge,idSubjectToAsociateStudent,numberSubjectToCreate,idTeacherToAsociateSubject,studentId,numberTeacherToCreate,isFullTime,randomStudentId,randomSubjectId,randomTeacherId;
        String studentName,studentLastName,subjectName,classRoom,teacherName,teacherLastName;
        double teacherSalary,seniorityExperience;
        Scanner read = new Scanner(System.in);
        university.printTechers();
        university.initData();

        do{
            printMenu();
            menuOption = read.nextInt();

            switch (menuOption) {

                case 1:
                    System.out.println("****List of all teachers****");
                    university.printTechers();
                    break;

                case 2:
                    System.out.println(" ");
                    university.printSubjects();
                    System.out.println(" ");
                    System.out.println("Please enter id of Subject to display information of class");
                    showSubject = read.nextInt();
                    System.out.println(university.searchSubjects(showSubject));
                    university.searchSubjects(showSubject).getStudentsToSubject();
                    break;

                case 3:
                    System.out.println("How many students do you need register?");
                    numberStudentToCreate = read.nextInt();

                    for (int i = 1; i <= numberStudentToCreate; i ++){
                        System.out.println("\n");
                        randomStudentId = getRandomNumberId(Utilities.RandomIdentifier.STUDENT);
                        System.out.println(randomStudentId + " Automatical ID " + " to Student "  + i);
                        System.out.println("Enter NAME of student "+ i);
                        studentName = read.next();
                        System.out.println("Enter LASTNAME of student " + i);
                        studentLastName = read.next();
                        System.out.println("Enter AGE of student" + i);
                        studentAge = read.nextInt();
                        university.studentDatabase.add(new Student(randomStudentId, studentName, studentLastName, studentAge));

                        do {
                            university.cleanConsole();
                            university.printSubjects();
                            System.out.println("Select one available subject id to asociate Student " + i);
                            idSubjectToAsociateStudent = read.nextInt();

                        }while (university.searchSubjects(idSubjectToAsociateStudent) == null);
                        university.searchSubjects(idSubjectToAsociateStudent).addStudent(university.searchStudent(randomStudentId));

                    }
                    break;

                case 4:
                    System.out.println("How many Subjects do you need create?");
                    numberSubjectToCreate = read.nextInt();

                    for (int j = 1; j <= numberSubjectToCreate; j ++){

                        randomSubjectId = getRandomNumberId(Utilities.RandomIdentifier.SUBJECT);
                        System.out.println(randomSubjectId + " Automatical ID" + " to Subject "  + j);
                        System.out.println("Enter NAME of Subject "+ j);
                        subjectName = read.next();
                        System.out.println("Enter ClassRoom of teacher " + j);
                        classRoom = read.next();

                        university.subjectDatabase.add(new Subject(randomSubjectId, subjectName, classRoom));


                        university.printTechers();
                        do {
                            System.out.println("please enter correct teacher Id");
                            idTeacherToAsociateSubject = read.nextInt();
                            university.printTechers();
                        }while (university.searchTeacher(idTeacherToAsociateSubject) == null);

                        university.searchSubjects(randomSubjectId).addTeacher(university.searchTeacher(idTeacherToAsociateSubject));
                        university.cleanConsole();
                        university.printStudents();
                        do {
                            System.out.println(" ");
                            System.out.println("Please enter correct Student: " + subjectName);
                            studentId = read.nextInt();
                            university.cleanConsole();
                            university.printStudents();
                        }while (university.searchStudent(studentId) == null);
                        university.cleanConsole();
                        university.searchSubjects(randomSubjectId).addStudent(university.searchStudent(studentId));
                    }
                    break;

                case 5:
                    System.out.println("Enter StudentID");
                    studentId = read.nextInt();

                    for (Subject key : university.subjectDatabase){
                        university.searchSubjects(key.getId()).getStudentsById(studentId);

                    }
                    break;

                case 6:
                    System.out.println("How many Teachers do you need create?");
                    numberTeacherToCreate = read.nextInt();

                    for (int t = 1; t <= numberTeacherToCreate; t ++){

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
                            university.teacherDatabase.add(new TeacherFullTime(randomTeacherId, teacherName, teacherLastName, finalSalary,seniorityExperience));

                        }else if (menuOptionTeacher == 2){
                            System.out.println("To part  time teacher please enter hours per week  " + t);
                            seniorityExperience = read.nextInt();

                            TeacherPartTime objectToCalculatefullPartTimeSalary = new TeacherPartTime();
                            double finalSalary = objectToCalculatefullPartTimeSalary.calculateSalary(teacherSalary, seniorityExperience);
                            university.teacherDatabase.add(new TeacherPartTime(randomTeacherId, teacherName, teacherLastName, finalSalary,seniorityExperience));

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

}
