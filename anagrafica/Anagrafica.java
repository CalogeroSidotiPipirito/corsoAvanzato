package anagrafica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Anagrafica {

    private final String nome;
    private final String cognome;
    private final String cittaNascita;

    private final String dataNascita;

    private static Integer id;


    public Anagrafica(String nome, String cognome, String cittaNascita, String dataNascita, int id){

        this.nome = nome;
        this.cognome = cognome;
        this.cittaNascita = cittaNascita;
        this.dataNascita = dataNascita;
        this.id = ++id;

    }


    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getCittaNascita(){
        return cittaNascita;
    }

    public LocalDate getDataNascita(){
        return formattaDataInEntrata();
    }

    public int getId(){
        return id;
    }

    public LocalDate formattaDataInEntrata(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String date = dataNascita;

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        return localDate;
    }

    public void printAnagrafica(){
        System.out.println(id + " | " + getNome() + " | " + getCognome() + " | " + getCittaNascita() + " | " + formattaDataInEntrata());
    }


}
