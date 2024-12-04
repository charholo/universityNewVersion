package org.university;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {
        ArrayList<Integer> idsStudents;
        int opt,showSubject,numeroAlum,ageS,idAsociateS,numeroSubj,idTeacherAssociate,studentId,StudentID,numeroTeach,isFullTime,subjectId,teacherId;
        double salaryT;
        String nameS,lsNameS,nameSj,classRoom,nameT,lsNameT;
        Scanner leer = new Scanner(System.in);

        initData();


        //Database HashMap Teacher
        HashMap<Integer, Teacher> teacherDatabase = new HashMap<>();
        teacherDatabase.put(10, new Teacher(1, "Felipe", "Jiménez", 40000));
        teacherDatabase.put(20, new Teacher(2,"Santiago", "Ponce de Leon", 3000));

        //Imprimo el Objeto
        System.out.println("Imprimo el map: " + teacherDatabase.get(20).getLastName());
        System.out.println("Contiene el valor: " + teacherDatabase.containsKey(210));
        System.out.println("Contiene el valors: " + teacherDatabase.containsValue(3000));


        //Database HashMap Students
        HashMap<Integer, Student> studentDatabase = new HashMap<>();
        studentDatabase.put(1, new Student(1,"Charholo","Holguin",31));
        studentDatabase.put(2, new Student(2,"Lizfer","Rios",34));
        studentDatabase.put(3, new Student(3,"Cesar","Ramirez",22));
        studentDatabase.put(4, new Student(4,"Jaime","Arias",36));
        studentDatabase.put(5, new Student(5,"Luisa","Montes",19));
        studentDatabase.put(6, new Student(6,"Fernanda","Rios",21));

        //Database HashMap Subject
        HashMap<Integer,Subject> subjectDatabase = new HashMap<>();
        subjectDatabase.put(1000,new Subject(1000,"Java programming","a12",11));
        subjectDatabase.put(1001,new Subject(1001,"Poo Python","a12",11));
        subjectDatabase.put(1002,new Subject(1002,"Java Script class","a12",11));
        subjectDatabase.put(1003,new Subject(1003,"Android class","a12",11));


        subjectDatabase.get(1002).displaySubjectDetails();




        //Crear Subject
        Subject subjectJava = new Subject(5000,"Scrum","a133",10);

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
        System.out.println("Muestra contenido de la subject");
        subjectJava.displaySubjectDetails();


        System.out.println("Mostrar data profesores");
        Teacher teacher1 = new Teacher(11,"Felipe","Gomez",4000);
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
        //Cambiar implementación de que mostar


        ///Menu********************************************************
        /////
        do{
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
            opt = leer.nextInt();

            switch (opt) {

                case 1:
                    System.out.println("**List of all teacher**");
                    System.out.println(" ");
                    //System.out.println(teacherDatabase);
                    //teacherDatabase.get(20).displayInfoPerson();
                    for (Integer key : teacherDatabase.keySet()){
                        teacherDatabase.get(key).displayInfoPerson();
                        System.out.println( " ");
                    }
                    break;

                case 2:

                    System.out.println("Option B");
                    System.out.println(" ");
                    System.out.println(subjectDatabase);
                    System.out.println("Please enter id of Subject to display information of class");
                    showSubject = leer.nextInt();

                    subjectDatabase.get(showSubject).displaySubjects();
                    System.out.println("By ");
                    subjectDatabase.get(showSubject).displaySubjectDetails();
                    subjectDatabase.get(showSubject).displayStudents();


                    break;


                case 3:
                    System.out.println("Option C");
                    //Crear Alumno y asociarlo a una Materia
                    System.out.println("How many students do you need register?");
                    numeroAlum = leer.nextInt();

                    for (int i = 1; i <= numeroAlum; i ++){

                        System.out.println("\n");
                        Random numAleatorioS = new Random();
                        int idS = numAleatorioS.nextInt(700-500+1) + 500;
                        System.out.println(idS + " Automatical ID " + " to Student "  + i);
                        System.out.println("Enter NAME of student "+ i);
                        nameS = leer.next();
                        System.out.println("Enter LASTNAME of student " + i);
                        lsNameS = leer.next();
                        System.out.println("Enter AGE of student" + i);
                        ageS = leer.nextInt();

                        studentDatabase.put(idS, new Student(idS,nameS,lsNameS,ageS));

                        //System.out.println(subjectDatabase.keySet()); //Revisar porque trae solo el objeto

                        System.out.println(" ");
                        for (Integer key : subjectDatabase.keySet()){
                            subjectDatabase.get(key).displaySubjects();
                        }


                        System.out.println("Select one available subject id to asociate Student " + i);
                        idAsociateS = leer.nextInt();
                        subjectDatabase.get(idAsociateS).addStudent(new Student(idS, nameS, lsNameS, ageS));

                        System.out.println("Process to asociate was correct " + i);
                        subjectDatabase.get(idAsociateS).displayStudents();
                    }
                    break;

                case 4:
                    System.out.println("Option D");

                    //Crear subject
                    System.out.println("¿Cuantas Subjects desea crear e Inscribir en el sistema?");
                    numeroSubj = leer.nextInt();

                    for (int sj = 1; sj <= numeroSubj; sj ++){ //Recorrer las Materias

                        Random numAleatorioSb = new Random();
                        int idSj = numAleatorioSb.nextInt(900-800+1) + 800;
                        System.out.println(idSj + " Automatical ID" + " to Subject "  + sj);
                        System.out.println("Enter NAME of Subject "+ sj);
                        nameSj = leer.next();
                        System.out.println("Enter ClassRoom of teacher " + sj);
                        classRoom = leer.next();

                        do {
                            System.out.println("Enter correct id teacher to asociate");
                            idTeacherAssociate = leer.nextInt();
                        }while (teacherDatabase.get(idTeacherAssociate) == null);

                        //Objeto que lleva todos los datos Subject
                        subjectDatabase.put(idSj,new Subject(idSj, nameSj, classRoom,idTeacherAssociate));
                        Teacher eT = teacherDatabase.get(idTeacherAssociate);
                        subjectDatabase.get(idSj).assignTeacherToSubject(eT);

                        do {
                            //Asociate student with Subject
                            System.out.println("Enter correct Student to add in subject: " + nameSj);
                            studentId = leer.nextInt();
                        }while (studentDatabase.get(studentId) == null);
                        Student eS = studentDatabase.get(studentId);
                        subjectDatabase.get(idSj).addStudent(eS);

                    }
                    break;

                case 5:
                    System.out.println("Option E");
                    System.out.println("Enter StudentID");
                    StudentID = leer.nextInt();
                    subjectDatabase.get(11).displayStudents(); // revisar para buscar por Id studiante
                    break;


                case 6:

                    System.out.println("Option 6");
                    //Crear teacher
                    System.out.println("¿Cuantos Teacher desea crear e Inscribir en el sistema?");
                    numeroTeach = leer.nextInt();

                    for (int t = 1; t <= numeroTeach; t ++){

                        Random numAleatorio = new Random();
                        int idT = numAleatorio.nextInt(200-100+1) + 200;
                        System.out.println(idT + " Automatical ID" + " to teacher "  + t);
                        System.out.println("Enter NAME of teacher "+ t);
                        nameT = leer.next();
                        System.out.println("Enter LASTNAME of teacher " + t);
                        lsNameT = leer.next();
                        System.out.println("Enter SALARY of teacher" + t);
                        salaryT = leer.nextDouble();
                        System.out.println("¿The Teacher working full time? Enter value '1' to TRUE or value '2' to FALSE " + t);
                        isFullTime = leer.nextInt();


                        Teacher calcSalary = new Teacher(11,"chch","test",444);
                        double finalSalary = calcSalary.calcSalaryteacher(salaryT,isFullTime);
                        teacherDatabase.put(idT, new Teacher(idT, nameT, lsNameT, finalSalary));
                    }
                    break;

                case 7:
                    System.out.println("Option 7");

                    //Busqueda ID  Subject

                    subjectDatabase.get(11); // revisar traer todas las subjects
                    System.out.println(" ");
                    System.out.println("Seek Subject ID");
                    subjectId = leer.nextInt();
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
                    studentId = leer.nextInt();
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

                    teacherId = leer.nextInt();
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
                    opt = leer.nextInt();
                    break;
            }
        }
        while(opt!=10);

        ///Menu********************************************************





    }

    static void initData(){
        System.out.println("Inicializar datos...");
    }


}
