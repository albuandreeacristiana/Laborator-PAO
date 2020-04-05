package Eveniment;

public class Botez extends Eveniment {
    private String numeBebelus;
    private String genBebelus;
    private Boolean ServiciuUrsitoare;

    public Botez(int nrParticipanti, String numeBebelus, String genBebelus, Boolean serviciuUrsitoare) {
        super(nrParticipanti);
        this.numeBebelus = numeBebelus;
        this.genBebelus = genBebelus;
        ServiciuUrsitoare = serviciuUrsitoare;
    }

    public Botez(Eveniment eveniment, String numeBebelus, String genBebelus, Boolean serviciuUrsitoare) {
        super(eveniment);
        this.numeBebelus = numeBebelus;
        this.genBebelus = genBebelus;
        ServiciuUrsitoare = serviciuUrsitoare;
    }

    public String getNumeBebelus() {
        return numeBebelus;
    }

    public void setNumeBebelus(String numeBebelus) {
        this.numeBebelus = new String(numeBebelus);
    }

    public String getGenBebelus() {
        return genBebelus;
    }

    public void setGenBebelus(String genBebelus) {
        this.genBebelus = new String(genBebelus);
    }

    public Boolean getServiciuUrsitoare() {
        return ServiciuUrsitoare;
    }

    public void setServiciuUrsitoare(Boolean serviciuUrsitoare) {
        ServiciuUrsitoare = serviciuUrsitoare;
    }

    @Override
    public String toString() {
        if(getServiciuUrsitoare())
            return super.toString()+"Nume bebelus: "+numeBebelus+"\nGen bebelus: "+genBebelus+"\nServiciu ursitoare: DA";
        else
            return super.toString()+"Nume bebelus: "+numeBebelus+"\nGen bebelus: "+genBebelus+"\nServiciu ursitoare: NU";


    }
}
