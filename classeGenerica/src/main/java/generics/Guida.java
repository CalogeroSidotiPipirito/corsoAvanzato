package generics;

public class Guida<V extends Veicolo> {

    private V tipologia;

    public Guida(V v){
        tipologia = v;
    }


    public V getTipologia(){
        return tipologia;
    }


    public void start(){
        System.out.println("Il motore si è acceso!\n");
    }

    public void accelera(){
        System.out.println("Il veicolo ha raggiuto la velocità massima di " + tipologia.getVelocitaMax() + "!");
    }
}
