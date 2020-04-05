import Restaurant.Adresa;
import Eveniment.EvenimentFirma;
import Rezervari.Agenda;
import Rezervari.Rezervare;
import Restaurant.Restaurant;


public class Main {
    public static void main(String[] args){
        //creez un restaurant cu agenda goala
        Adresa adresa = new Adresa("Pacii",53);
        Rezervare[] rezervari = new Rezervare[0];
        EvenimentFirma[] evenimenteF = new EvenimentFirma[0];
        Agenda agenda = new Agenda (rezervari,evenimenteF);
        Restaurant restaurant = new Restaurant("Restaurantul meu",adresa,300,agenda);

/*Servicii.detaliiRestaurant(restaurant);
Servicii.afiseazaAgenda(restaurant);
Servicii.afiseazaRezervarile(restaurant.getAgenda());
Servicii.afiseazaEvenimenteleFirmei(restaurant.getAgenda());*/

//formatul datelor de intrare se va verifica la citire, toti constructorii/metodele primesc date valide

    }

}
