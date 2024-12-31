package controller;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        University university = new University();

        int menuOption, showSubject,numberStudentToCreate,numberSubjectToCreate,studentId,numberTeacherToCreate;
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
                    university.printSubjects();
                    System.out.println("Please enter id of Subject to display information of class");
                    showSubject = read.nextInt();
                    System.out.println(university.searchSubjects(showSubject));
                    university.searchSubjects(showSubject).getStudentsToSubject();
                    break;

                case 3:
                    System.out.println("How many students do you need register?");
                    numberStudentToCreate = read.nextInt();
                    university.createStudent(numberStudentToCreate);
                    break;

                case 4:
                    System.out.println("How many Subjects do you need create?");
                    numberSubjectToCreate = read.nextInt();
                    university.createSubject(numberSubjectToCreate);
                    break;

                case 5:
                    System.out.println("Enter StudentID");
                    studentId = read.nextInt();
                    university.listAllSubjectByStudent(studentId);
                    break;

                case 6:
                    System.out.println("How many Teachers do you need create?");
                    numberTeacherToCreate = read.nextInt();
                    university.createTeacher(numberTeacherToCreate);
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
