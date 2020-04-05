package Eveniment;
//verifica la citire daca nr de participanti este mai mic sau egal cu capacitatea maxima a restaurantului
public class Eveniment {
    protected int nrParticipanti;

    public Eveniment(int nrParticipanti) {
        this.nrParticipanti = nrParticipanti;
    }

    public Eveniment(Eveniment eveniment) {
        this.nrParticipanti = eveniment.nrParticipanti;
    }

    public int getNrParticipanti() {
        return nrParticipanti;
    }

    public void setNrParticipanti(int nrParticipanti) {
        this.nrParticipanti = nrParticipanti;
    }

    @Override
    public String toString() {
        return "Nr. Participanti: "+nrParticipanti+"\n";
    }
}
