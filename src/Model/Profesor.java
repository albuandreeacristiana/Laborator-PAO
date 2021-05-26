package Model;

import java.util.Arrays;
import java.util.List;

public class Profesor extends DateIdentificare{
    private Data dataAngajarii;
    List<Materie> materii;

    public Profesor(Nume nume, Data dataNasterii, String adresa, String stareCivila, Data dataAngajarii, List<Materie> materii) {
        super(nume, dataNasterii, adresa, stareCivila);
        this.dataAngajarii = dataAngajarii;
        this.materii = materii;
    }

    public Profesor() {
    }

    public Data getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Data dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public void setMaterii(List<Materie> materii) {
        this.materii = materii;
    }

    @Override
    public String toString() {
        return "Profesor{" +super.toString()+
                "dataAngajarii=" + dataAngajarii +
                ", materii=" + materii +
                '}';
    }
}
