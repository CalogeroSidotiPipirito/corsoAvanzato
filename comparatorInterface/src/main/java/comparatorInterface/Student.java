package comparatorInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    private final String name;
    private final String surname;

    private final LocalDate dateBirth;

    public Student(String name, String surname, String dateBirth){
        this.name = name;
        this.surname = surname;
        this.dateBirth = stringToLocalDate(dateBirth);
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public LocalDate getDateBirth(){
        return dateBirth;
    }

    public LocalDate stringToLocalDate(String dateBirth){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataParsed = LocalDate.parse(dateBirth, formatter);

        return dataParsed;
    }

}
