package Rezervari;

import Eveniment.Eveniment;

import java.util.Arrays;

public class Rezervare {
    private Data data;
    private String ora;
    private Eveniment eveniment;
    private Contact[] persoaneDeContact;

    public Rezervare(Data data, String ora, Eveniment eveniment, Contact[] persoaneDeContact) {
        this.data = new Data(data);
        this.ora = ora;
        this.eveniment = eveniment;
        this.persoaneDeContact = Arrays.copyOf(persoaneDeContact,persoaneDeContact.length);
        Arrays.sort(this.persoaneDeContact);

    }
    public Rezervare(Rezervare ob) {
        this.data = new Data(ob.data);
        this.ora = ob.ora;
        this.eveniment = ob.eveniment;
        this.persoaneDeContact = Arrays.copyOf(ob.persoaneDeContact,ob.persoaneDeContact.length);
        Arrays.sort(this.persoaneDeContact);

    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = new Data(data);
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = new String(ora);
    }

    public Eveniment getEveniment() {
        return eveniment;
    }

    public void setEveniment(Eveniment eveniment) {
        this.eveniment = new Eveniment(eveniment);
    }

    public Contact[] getPersoaneDeContact() {
        return persoaneDeContact;
    }

    public void setPersoaneDeContact(Contact[] persoaneDeContact) {
        this.persoaneDeContact = Arrays.copyOf(persoaneDeContact,persoaneDeContact.length) ;
        Arrays.sort(this.persoaneDeContact);
    }

    public void adaugaPersoanaDeContact(Contact contactNou){
        Contact[] aux = new Contact[this.persoaneDeContact.length+1];
        System.arraycopy(this.persoaneDeContact,0,aux,0,this.persoaneDeContact.length);
        aux[this.persoaneDeContact.length]=new Contact(contactNou);
        this.persoaneDeContact = new Contact[aux.length];
        System.arraycopy(aux,0,this.persoaneDeContact,0,aux.length);
        Arrays.sort(this.persoaneDeContact);
    }

    @Override
    public String toString() {
        return data+"\nOra: "+ora+"\n"+eveniment+"Persoane de contact: "+Arrays.toString(persoaneDeContact)+"\n";
    }

}
