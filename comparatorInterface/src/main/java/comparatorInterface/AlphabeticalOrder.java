package comparatorInterface;

import java.util.Comparator;

public class AlphabeticalOrder implements Comparator<Student> {


    public int compare(Student student1, Student student2){
        return (student1.getSurname() + " " + student1.getName()).compareTo(student2.getSurname() + " " + student2.getName());

    }

}
