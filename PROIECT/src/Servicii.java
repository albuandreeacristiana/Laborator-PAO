import Eveniment.EvenimentFirma;
import Restaurant.Restaurant;
import Rezervari.Agenda;
import Rezervari.Contact;
import Rezervari.Rezervare;

import java.util.Arrays;

public final class Servicii {
    public static void detaliiRestaurant(Restaurant r)
    {
        System.out.println("Nume: "+r.getNume()+"\n"+r.getAdresa()+"\nCapacitate maxima: "+r.getCapacitateMaxima()+"\n");
    }

    public static void afiseazaAgenda(Restaurant r)
    {
        System.out.println(r.getAgenda());
    }

    public static void afiseazaRezervarile(Agenda a)
    {
        System.out.println(Arrays.toString(a.getRezervari()));
    }

    public static void afiseazaEvenimenteleFirmei(Agenda a)
    {
        System.out.println(Arrays.toString(a.getEvenimenteleFirmei()));
    }

    public static void stergeAgenda(Agenda a){
       Rezervare[] aux = new Rezervare[0];
        a.setRezervari(aux);

        EvenimentFirma[] auxx = new EvenimentFirma[0];
        a.setEvenimenteleFirmei(auxx);
    }

    public static void addRezervare(Rezervare r,Agenda a){
        a.adaugaRezervare(r); //definita in Agenda
    }

    public static void addEvenimentFirma(EvenimentFirma e, Agenda a){
        a.adaugaEvenimentFirma(e); //definita in Agenda
    }

    public static void adaugaContact(Contact c, int indexRezervare, Agenda a){ //adauga o persoana de contact unei rezervari
        a.getRezervari()[indexRezervare].adaugaPersoanaDeContact(c); //definita in rezervare
    }

    //Implementari viitoare: modificare detalii rezervare, anulare rezervare
}
