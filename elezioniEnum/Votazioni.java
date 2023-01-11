package elezioniEnum;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Votazioni {

    private static ArrayList<SchedaElettorale> schedeElettorali = new ArrayList<>();

    public static SchedaElettorale vota(Opzione scelta){
        SchedaElettorale scheda = new SchedaElettorale(scelta);
        schedeElettorali.add(scheda);
        return scheda;
    }


    public static void main(String[] args) {

        SecureRandom n = new SecureRandom();
        Scanner in = new Scanner(System.in);
        int scelta;
        String nome, cognome, nomeCognome;
        Opzione voto = null;
        boolean continua = true;
        ArrayList<String> votanti = null;

        do {
            System.out.print("Ci sono votanti? (1 per SI, altro qualsiasi intero per NO)  ");

            scelta = in.nextInt();

            if (scelta == 1) {
                System.out.print("Nome: ");
                nome = in.next();
                System.out.print("Cognome: ");
                cognome = in.next();
                nomeCognome = nome + " " + cognome;
                votanti.add(nomeCognome);
                System.out.println("Referendum: Vuoi la Monarchia o la Repubblica? (1 Monarchia, 2 Repubblica)");
                scelta = in.nextInt();
                if (scelta == 1)
                    voto = Opzione.MONARCHIA;
                else if (scelta == 2)
                    voto = Opzione.REPUBBLICA;
                vota(voto);

            }
            else
                continua = false;

        }
        while(continua);


        for (int i = 0; i < schedeElettorali.size(); i++)
            System.out.println(schedeElettorali.get(i).getVoto());

        System.out.println("Numero totale elettori: " + votanti.size());

        System.out.println(votanti.get(n.nextInt(votanti.size())) + " ha votato!\n");
    }

}
