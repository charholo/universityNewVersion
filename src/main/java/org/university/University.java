package org.university;
import java.util.HashMap;
import java.util.Scanner;

public class University extends Utilities {
    private static HashMap<Integer, Teacher> teacherDatabase = new HashMap<>();
    private static HashMap<Integer, Student> studentDatabase = new HashMap<>();
    private static HashMap<Integer, Subject> subjectDatabase = new HashMap<>();

    public static void main(String[] args) {
        int menuOption,showSubject,numberStudentToCreate,studentAge,idSubjectToAsociateStudent,numberSubjectToCreate,idTeacherToAsociateSubject,studentId,numberTeacherToCreate,isFullTime,subjectId,teacherId,randomStudentId,randomSubjectId,randomTeacherId;
        String studentName,studentLastName,subjectName,classRoom,teacherName,teacherLastName;
        double teacherSalary;
        Scanner read = new Scanner(System.in);
        initData();

        do{
            printMenu();
            menuOption = read.nextInt();
            switch (menuOption) {

                case 1:
                    System.out.println("****List of all teacher****");
                    printTechers();
                    break;

                case 2:
                    System.out.println(" ");
                    printSubjects();
                    System.out.println(" ");
                    System.out.println("Please enter id of Subject to display information of class");
                    showSubject = read.nextInt();
                    subjectDatabase.get(showSubject).displaySubjects();
                    subjectDatabase.get(showSubject).displaySubjectDetails();
                    subjectDatabase.get(showSubject).displayStudents();
                    break;

                case 3:
                    System.out.println("How many students do you need register?");
                    numberStudentToCreate = read.nextInt();

                    for (int i = 1; i <= numberStudentToCreate; i ++){
                        System.out.println("\n");
                        randomStudentId = getRandomNumberId(1);
                        System.out.println(randomStudentId + " Automatical ID " + " to Student "  + i);
                        System.out.println("Enter NAME of student "+ i);
                        studentName = read.next();
                        System.out.println("Enter LASTNAME of student " + i);
                        studentLastName = read.next();
                        System.out.println("Enter AGE of student" + i);
                        studentAge = read.nextInt();
                        studentDatabase.put(randomStudentId, new Student(randomStudentId,studentName,studentLastName,studentAge));

                        System.out.println(" ");

                        printSubjects();

                        System.out.println("Select one available subject id to asociate Student " + i);
                        idSubjectToAsociateStudent = read.nextInt();
                        subjectDatabase.get(idSubjectToAsociateStudent).addStudent(new Student(randomStudentId, studentName, studentLastName, studentAge));

                        System.out.println("Process to asociate was correct " + i);
                        subjectDatabase.get(idSubjectToAsociateStudent).displayStudents();
                    }
                    break;

                case 4:

                    System.out.println("How many Subjects do you need create?");
                    numberSubjectToCreate = read.nextInt();

                    for (int sj = 1; sj <= numberSubjectToCreate; sj ++){

                        randomSubjectId = getRandomNumberId(2);
                        System.out.println(randomSubjectId + " Automatical ID" + " to Subject "  + sj);
                        System.out.println("Enter NAME of Subject "+ sj);
                        subjectName = read.next();
                        System.out.println("Enter ClassRoom of teacher " + sj);
                        classRoom = read.next();

                        printTechersIds();

                        do {
                            System.out.println("Enter correct id teacher to asociate");
                            idTeacherToAsociateSubject = read.nextInt();
                        }while (teacherDatabase.get(idTeacherToAsociateSubject) == null);

                        subjectDatabase.put(randomSubjectId,new Subject(randomSubjectId, subjectName, classRoom,idTeacherToAsociateSubject));
                        //Teacher eT = teacherDatabase.get(idTeacherToAsociateSubject);
                        //subjectDatabase.get(randomSubjectId).assignTeacherToSubject(eT);
                        //eT.displayInfoTeacher();

                        do {
                            //Asociate student with Subject
                            System.out.println(" ");
                            System.out.println("Enter correct Student to add in subject: " + subjectName);
                            studentId = read.nextInt();
                        }while (studentDatabase.get(studentId) == null);
                        Student eS = studentDatabase.get(studentId);
                        subjectDatabase.get(randomSubjectId).addStudent(eS);

                    }
                    break;

                case 5:
                    System.out.println("Enter StudentID");
                    studentId = read.nextInt();

                    for (Integer key : subjectDatabase.keySet()){
                        subjectDatabase.get(key).displayStudentsById(studentId);
                    }
                    break;

                case 6:
                    System.out.println("How many Teachers do you need create?");
                    numberTeacherToCreate = read.nextInt();

                    for (int t = 1; t <= numberTeacherToCreate; t ++){

                        randomTeacherId = getRandomNumberId(3);
                        System.out.println(randomTeacherId + " Automatical ID " + " to teacher "  + t);

                        System.out.println("Enter NAME of teacher "+ t);
                        teacherName = read.next();
                        System.out.println("Enter LASTNAME of teacher " + t);
                        teacherLastName = read.next();
                        System.out.println("Enter SALARY of teacher" + t);
                        teacherSalary = read.nextDouble();
                        System.out.println("¿The Teacher working full time? Enter value '1' to TRUE or value '2' to FALSE " + t);
                        isFullTime = read.nextInt();

                        Teacher calcSalary = new Teacher(11,"charles","test",444);
                        double finalSalary = calcSalary.calcSalaryteacher(teacherSalary,isFullTime);
                        teacherDatabase.put(randomTeacherId, new Teacher(randomTeacherId, teacherName, teacherLastName, finalSalary));
                    }
                    break;

                case 7:
                    System.out.println("Option 7");

                    //Busqueda ID  Subject

                    subjectDatabase.get(11); // revisar traer todas las subjects
                    System.out.println(" ");
                    System.out.println("Seek Subject ID");
                    subjectId = read.nextInt();
                    Subject sJ = subjectDatabase.get(subjectId);
                    if (sJ == null){
                        System.out.println("Id doesn't exist ");
                    }else{
                        System.out.println("Subject  found MenuCase8: " + sJ);
                    }
                    break;



                case 8:
                    System.out.println("Option 8");
                    System.out.println("Seek Student by ID");
                    studentId = read.nextInt();
                    Student eSs = studentDatabase.get(studentId);
                    if (eSs == null){
                        System.out.println("Id doesn't exist");
                    }else{
                        System.out.println("Student found: " + eSs);

                    }

                    break;



                case 9:
                    //Busqueda variable Teacher
                    System.out.println("Option 9");
                    System.out.println("Seek Teacher ID");

                    teacherId = read.nextInt();
                    Teacher tE = teacherDatabase.get(teacherId);
                    if (tE == null){
                        System.out.println("Id doesn't exist");
                        Teacher tt = new Teacher(11,"chch","test",444);

                        tt.displayInfoPerson();
                    }else{
                        System.out.println("Teacher found: " + tE);
                    }
                    break;


                case 10:
                    System.out.println("Program Finish!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unavailable option!");
                    System.out.println("¿Return to menu?");
                    System.out.println("0 = Yes or 7 = No");
                    menuOption = read.nextInt();
                    break;
            }
        }
        while(menuOption!=10);

    }

    static void initData(){
        //initialize Database Teacher
        teacherDatabase.put(10, new Teacher(10, "Felipe", "Jiménez", 40000));
        teacherDatabase.put(20, new Teacher(20,"Santiago", "Ponce de Leon", 3500));
        //initialize Database Students
        studentDatabase.put(1, new Student(1,"Charholo","Holguin",31));
        studentDatabase.put(2, new Student(2,"Lizfer","Rios",34));
        studentDatabase.put(3, new Student(3,"Cesar","Ramirez",22));
        studentDatabase.put(4, new Student(4,"Jaime","Arias",36));
        studentDatabase.put(5, new Student(5,"Luisa","Montes",19));
        studentDatabase.put(6, new Student(6,"Fernanda","Rios",21));
        //initialize Database Subject
        subjectDatabase.put(1000,new Subject(1000,"Java programming","a12",11));
        subjectDatabase.put(1001,new Subject(1001,"Poo Python","a12",11));
        subjectDatabase.put(1002,new Subject(1002,"Java Script class","a12",11));
        subjectDatabase.put(1003,new Subject(1003,"Android class","a12",11));
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
        System.out.println("7: Search Subject by ID");
        System.out.println("8: Search Student By ID");
        System.out.println("9: Search Teacher ID");
        System.out.println("10: Exit");
        System.out.print("To continue select any option: ");
        System.out.println(" ");

    }

    private static void printSubjects(){
        System.out.println(" ");
        for (Integer key : subjectDatabase.keySet()){
            subjectDatabase.get(key).displaySubjects();
        }
    }

    private static void printTechers(){
        System.out.println(" ");
        for (Integer key : teacherDatabase.keySet()){
            teacherDatabase.get(key).displayInfoPerson();
            System.out.println( " ");
        }
    }
    private static void printTechersIds(){
        for (Integer key : teacherDatabase.keySet()){
            teacherDatabase.get(key).displayInfoTeacher();
            System.out.println( " ");
        }
    }

}
