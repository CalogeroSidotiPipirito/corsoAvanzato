package generics;

public class Main {

    public static void main(String[] args){
        Guida<Auto> veicolo1 = new Guida<Auto>(new Auto("Toyota", "Prius", 178));
        Guida<Furgone> veicolo2 = new Guida<Furgone>(new Furgone("Fiat", "Ducato", 145));
        Autista mario = new Autista("Mario");

        mario.avviaVeicolo((Guida<? extends Veicolo>) veicolo1);
        veicolo1.start();
        mario.acceleraATavoletta((Guida<? extends Veicolo>) veicolo1);
        veicolo1.accelera();

        mario.avviaVeicolo((Guida<? extends Veicolo>) veicolo2);
        veicolo2.start();
        mario.acceleraATavoletta((Guida<? extends Veicolo>) veicolo2);
        veicolo2.accelera();
    }

}
