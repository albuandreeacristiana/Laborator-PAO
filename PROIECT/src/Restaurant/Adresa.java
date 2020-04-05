package Restaurant;

public class Adresa {
    private String nume;
    private int numar;

    public Adresa(String nume, int numar) {
        this.nume = new String (nume);
        this.numar = numar;
    }

    public Adresa(Adresa adr){
        this.nume = new String (adr.nume);
        this.numar = adr.numar;
    }

    public String getNume() {
        return new String(nume);
    }

    public int getNumar() {
        return numar;
    }

    public void setNume(String nume) {
        this.nume =new String(nume) ;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public String toString() {
        return "Adresa: Strada "+getNume()+", Nr. "+getNumar()+"." ;
    }
}
