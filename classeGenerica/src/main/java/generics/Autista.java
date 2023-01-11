package generics;

public class Autista {

    private String nome;

    public Autista(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void avviaVeicolo(Guida<? extends Veicolo> v){
        System.out.println("L'autista Mario avvia la guida del veicolo " + v.getTipologia().getMarca() + " " + v.getTipologia().getModello() + "\n");
    }

    public void acceleraATavoletta(Guida<? extends Veicolo> v){
        System.out.println("L'autista Mario accelera la guida del veicolo " + v.getTipologia().getMarca() + " " + v.getTipologia().getModello() + "\n");
    }

}
