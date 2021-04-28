package Model;

import java.util.ArrayList;
import java.util.List;

public class Grupa {
    private int nr;
    private List<Student> studenti;

    public Grupa(int nr, List<Student> studenti) {
        this.nr = nr;
        this.studenti = studenti;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
        //this.studenti = List.copyOf(studenti);
        //this.studenti.addAll();
    }

    @Override
    public String toString() {
        return "Grupa{" +
                "nr=" + nr +
                ", studenti=" + studenti +
                '}';
    }
    public void addStudent(Student s){
        this.studenti.add(s);
    }
}
