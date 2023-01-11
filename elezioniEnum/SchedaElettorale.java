package elezioniEnum;

public class SchedaElettorale {

    private Opzione voto;

    public SchedaElettorale(Opzione voto){

        this.voto = voto;
    }

    public Opzione getVoto(){
        return voto;
    }

    public void setVoto(Opzione voto){
        this.voto = voto;
    }
}
