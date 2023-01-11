package timer;

import java.time.*;

public class Timer {

    public static void main(String[] args){
        timer();
    }

    public static void timer(){
        Instant corrente = Instant.now();
        while(true)
        {
            Instant millisecondi = Instant.now();
            if (((corrente.toEpochMilli() + 5000) == millisecondi.toEpochMilli())) {
                corrente = millisecondi;
                System.out.println("Sono passati 5 secondi!\n");
            }
        }
    }


}
