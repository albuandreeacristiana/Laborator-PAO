package Model;

import CSV.CsvTypeFactory;

import java.util.Comparator;
import java.util.List;

public class Student extends DateIdentificare {

    private int an;
    private int grupa;
    private List<Nota> note;

    public Student(Nume nume, Data dataNasterii, String adresa, String stareCivila, int an, int grupa, List<Nota> note) {
        super(nume, dataNasterii, adresa, stareCivila);
        this.an = an;
        this.grupa = grupa;
        this.note = note;
    }

    public Student() {
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public List<Nota> getNote() {
        return note;
    }

    public void setNote(List<Nota> note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume=" + nume +
                ", dataNasterii=" + dataNasterii +
                ", adresa='" + adresa + '\'' +
                ", stareCivila='" + stareCivila + '\'' +
                ", an=" + an +
                ", grupa=" + grupa +
                ", note=" + note +
                '}';
    }

    public static Comparator<Student> compStudent = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getGrupa() != o2.getGrupa()){
            return o1.getGrupa()- o2.getGrupa();
            }
            else{
                if( o1.getNume().getNume().compareTo(o2.getNume().getNume()) != 0){
                    return o1.getNume().getNume().compareTo(o2.getNume().getNume());
                }
                else{
                    return o1.getNume().getPrenume().compareTo(o2.getNume().getPrenume());
                }
            }

        }

    };
}