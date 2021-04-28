package Model;

public class Nota {
    private int valoare;
    private Data data;
    private Materie materie;
    private Profesor profesor;

    public Nota(int valoare, Data data, Materie materie, Profesor profesor) {
        this.valoare = valoare;
        this.data = data;
        this.materie = materie;
        this.profesor = profesor;
    }

    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Materie getMaterie() {
        return materie;
    }

    public void setMaterie(Materie materie) {
        this.materie = materie;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "valoare=" + valoare +
                ", data=" + data +
                ", materie=" + materie +
                ", profesor=" + profesor +
                '}';
    }
}
