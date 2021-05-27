package Model;

public class Materie {
    private int id = 0;
    private String denumire;
    private int nrSemestre;
    private int anStudiu;

    public Materie(String denumire, int nrSemestre, int anStudiu) {
        this.denumire = denumire;
        this.nrSemestre = nrSemestre;
        this.anStudiu = anStudiu;
    }

    public Materie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }


    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrSemestre() {
        return nrSemestre;
    }

    public void setNrSemestre(int nrSemestre) {
        this.nrSemestre = nrSemestre;
    }

    public int getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(int anStudiu) {
        this.anStudiu = anStudiu;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "denumire='" + denumire + '\'' +
                ", nrSemestre=" + nrSemestre +
                ", anStudiu=" + anStudiu +
                '}';
    }
}
