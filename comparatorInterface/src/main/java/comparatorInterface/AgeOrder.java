package comparatorInterface;

import java.util.Comparator;

public class AgeOrder implements Comparator<Student> {


  public int compare(Student student1, Student student2){

        Long dateBirth1 = student1.getDateBirth().toEpochDay();
        Long dateBirth2 = student2.getDateBirth().toEpochDay();


        int result = dateBirth1.compareTo(dateBirth2);

        return result;
    }


}
