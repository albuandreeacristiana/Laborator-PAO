package Eveniment;

public class Aniversare extends Eveniment {
    private String numeSarbatorit;
    private int varstaAniversata;

    public Aniversare(int nrParticipanti, String numeSarbatorit, int varstaAniversata) {
        super(nrParticipanti);
        this.numeSarbatorit = new String(numeSarbatorit);
        this.varstaAniversata = varstaAniversata;
    }

    public Aniversare(Eveniment eveniment, String numeSarbatorit, int varstaAniversata) {
        super(eveniment);
        this.numeSarbatorit = new String(numeSarbatorit);
        this.varstaAniversata = varstaAniversata;
    }

    public String getNumeSarbatorit() {
        return numeSarbatorit;
    }

    public void setNumeSarbatorit(String numeSarbatorit) {
        this.numeSarbatorit = new String(numeSarbatorit);
    }

    public int getVarstaAniversata() {
        return varstaAniversata;
    }

    public void setVarstaAniversata(int varstaAniversata) {
        this.varstaAniversata = varstaAniversata;
    }

    @Override
    public String toString() {
        return super.toString()+"Nume sarbatorit: "+numeSarbatorit+"\nVarsta aniversata: "+varstaAniversata+"\n";
    }
}
