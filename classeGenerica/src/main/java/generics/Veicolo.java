package generics;

public class Veicolo {
    private final String marca;
    private final String modello;

    private int velocitaMax;

    public Veicolo(String marca, String modello, int velocitaMax){
        this.marca = marca;
        this.modello = modello;
        this.velocitaMax = velocitaMax;

    }

    public String getMarca(){
        return marca;
    }

    public String getModello(){
        return modello;
    }

    public int getVelocitaMax(){
        return velocitaMax;
    }

    public void setVelocitaMax(int velocitaMax){
        this.velocitaMax = velocitaMax;
    }

}
