package Rezervari;


import Eveniment.EvenimentFirma;

import java.util.Arrays;

public class Agenda {
    private Rezervare[] rezervari;
    private EvenimentFirma[] evenimenteleFirmei;

    public Agenda(Rezervare[] rezervari, EvenimentFirma[] evenimenteleFirmei) {
        this.rezervari = rezervari;
        this.evenimenteleFirmei = evenimenteleFirmei;
    }

    public Rezervare[] getRezervari() {
        return rezervari;
    }

    public void setRezervari(Rezervare[] rezervari) {
        this.rezervari = rezervari;
    }

    public EvenimentFirma[] getEvenimenteleFirmei() {
        return evenimenteleFirmei;
    }

    public void setEvenimenteleFirmei(EvenimentFirma[] evenimenteleFirmei) {
        this.evenimenteleFirmei = evenimenteleFirmei;
    }

    public void adaugaRezervare(Rezervare rezNoua) {
        Rezervare[] aux = new Rezervare[this.rezervari.length+1];
        System.arraycopy(this.rezervari,0,aux,0,this.rezervari.length);
        aux[this.rezervari.length]=new Rezervare(rezNoua);
        this.rezervari = new Rezervare[aux.length];
        System.arraycopy(aux,0,this.rezervari,0,aux.length);
    }

    public void adaugaEvenimentFirma(EvenimentFirma evNou) {
        EvenimentFirma[] aux = new EvenimentFirma[this.evenimenteleFirmei.length+1];
        System.arraycopy(this.evenimenteleFirmei,0,aux,0,this.evenimenteleFirmei.length);
        aux[this.evenimenteleFirmei.length]=new EvenimentFirma(evNou);
        this.evenimenteleFirmei = new EvenimentFirma[aux.length];
        System.arraycopy(aux,0,this.evenimenteleFirmei,0,aux.length);
    }

    @Override
    public String toString() {
        return "\nRezervari: "+ Arrays.toString(rezervari)+"\n\nEvenimente firma: "+Arrays.toString(evenimenteleFirmei)+"\n";
    }
}
