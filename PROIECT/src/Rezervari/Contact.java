package Rezervari;
//verifica la citire nr telefon cu regex
public class Contact implements Comparable<Contact>{
    private String nume;
    private String nrTelefon;

    public Contact(String nume, String nrTelefon) {
        this.nume = new String(nume);
        this.nrTelefon = new String(nrTelefon);
    }
    public Contact(Contact ob) {
        this.nume = new String(ob.nume);
        this.nrTelefon = new String(ob.nrTelefon);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = new String(nume);
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = new String(nrTelefon);
    }

    @Override
    public String toString() {
        return "{" + "nume='" + nume + '\'' + ", nrTelefon='" + nrTelefon + '\'' + '}';
    }

    @Override
    public int compareTo(Contact o) {
        return toString().compareTo(o.toString());
    }
}
