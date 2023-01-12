package comparatorInterface;

import java.time.LocalDate;
import java.util.Comparator;

public class Main{

    public static void  main(String[] args) {

        Student[] students = new Student[6];

        students[0] = new Student("Pippo", "aaa", "15/10/1956");
        students[1] = new Student("Giovanni", "bbb", "12/05/1992");
        students[2] = new Student("Andrea", "ccc", "14/01/1986");
        students[3] = new Student("Alessia", "ddd", "16/12/1950");
        students[4] = new Student("Daniela", "eee", "01/12/1977");
        students[5] = new Student("Alice", "fff", "01/08/1999");


        ageOrder(students);
        alphabeticalOrder(students);


    }


    public static void ageOrder(Student[] students){

        AgeOrder ageO = new AgeOrder();

        int i, j, result;

        Student temp;

        for (i = 0; i < students.length; i++) {
            for (j = 0; j < students.length; j++){
                result = ageO.compare(students[i], students[j]);
                if (result > 0){
                    temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                }
            }
        }

        System.out.println("Age order: ");
        for (Student s : students)
            System.out.print(s.getSurname() + " " + s.getName() + " di anni " + (s.getDateBirth().toEpochDay())/365 + "\t");

        System.out.println("\n\n");
    }




    public static void alphabeticalOrder(Student[] students){

        AlphabeticalOrder aO = new AlphabeticalOrder();

        int i, j, result;

        Student temp;

        for (i = 0; i < students.length; i++) {
            for (j = 0; j < students.length; j++){
                result = aO.compare(students[i], students[j]);
                if (result < 0){
                    temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                }
            }
        }

        System.out.println("Alphabetical order: ");
        for (Student s : students)
            System.out.print(s.getSurname() + " " + s.getName() + " di anni " + s.getDateBirth().toEpochDay()/365 + "\t");



    }



}
