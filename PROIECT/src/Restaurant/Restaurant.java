package Restaurant;

import Rezervari.Agenda;

public final class Restaurant {
    final private String nume;
    final private Adresa adresa;
    final private int capacitateMaxima;
    private Agenda agenda;

    public Restaurant(String nume, Adresa adresa, int capacitateMaxima, Agenda agenda) {
        this.nume = new String(nume);
        this.adresa = new Adresa(adresa);
        this.capacitateMaxima = capacitateMaxima;
        this.agenda = agenda; //copyConstr
    }

    public String getNume() {
        return nume;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public int getCapacitateMaxima() {
        return capacitateMaxima;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Nume: "+nume+"\n"+adresa+"\nCapacitate maxima: "+capacitateMaxima+"\n"+agenda;
    }
}
