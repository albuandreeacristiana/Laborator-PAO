package Model;
import Model.Nume;

public class DateIdentificare {
    protected Nume nume;
    protected Data dataNasterii;
    protected String adresa;
    protected String stareCivila;

    public Nume getNume() {
        return nume;
    }

    public void setNume(Nume nume) {
        this.nume = nume;
    }

    public Data getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Data dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getStareCivila() {
        return stareCivila;
    }

    public void setStareCivila(String stareCivila) {
        this.stareCivila = stareCivila;
    }

    public DateIdentificare(Nume nume, Data dataNasterii, String adresa, String stareCivila) {
        this.nume = nume;
        this.dataNasterii = dataNasterii;
        this.adresa = adresa;
        this.stareCivila = stareCivila;
    }

    public DateIdentificare() {
    }

    @Override
    public String toString() {
        return "DateIdentificare{" +
                "nume=" + nume +
                ", dataNasterii=" + dataNasterii +
                ", adresa='" + adresa + '\'' +
                ", stareCivila='" + stareCivila + '\'' +
                '}';
    }
}
