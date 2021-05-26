package Service;

import Model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static Model.Student.compStudent;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Services {
    private List<Student> studenti = new ArrayList<Student>();
    private List<Materie> materii = new ArrayList<Materie>();
    private List<Profesor> profesori = new ArrayList<Profesor>();
    private List<Grupa> grupe = new ArrayList<Grupa>();
    private FileWriter logWriter;

    public void addStudent(String nume, String initialaTatalui, String prenume,
                           int zi, int luna, int an,
                           String adresa, String stareCivila,
                           int anStudiu, int nrGrupa){
        Nume n = new Nume(nume, initialaTatalui, prenume);
        Data dn = new Data(zi,luna,an);
        List <Nota> note = new ArrayList<Nota>();
        Student s = new Student(n,dn,adresa,stareCivila,anStudiu,nrGrupa, note);
        studenti.add(s);
        int found = 0;

        for(int i = 0; i < grupe.size(); i++){
            Grupa temp = grupe.get(i);
            if(temp.getNr() == nrGrupa) {
                found = 1;
                temp.addStudent(s);
            }
        }
        if(found != 1){
            List<Student> l= new ArrayList<Student>();
            Grupa temp = new Grupa(nrGrupa, l);
            temp.addStudent(s);
            grupe.add(temp);

        }
        Collections.sort(studenti ,compStudent);
    }

    public void addProfesor(String nume, String initialaTatalui, String prenume,
                           int zi, int luna, int an,
                           String adresa, String stareCivila,
                           int zia, int lunaa, int ana, List<Materie> mat){
        Nume n = new Nume(nume, initialaTatalui, prenume);
        Data dn = new Data(zi,luna,an);
        Data da = new Data(zia,lunaa,ana);
        Profesor p= new Profesor(n,dn,adresa,stareCivila,da, mat);
        profesori.add(p);
        if (mat.size() > 0 && materii.size() > 0) {
            for (int j = 0; j < mat.size(); j++) {
                Materie search = mat.get(j);
                if(searchMaterie(search.getDenumire()) == -1){
                    materii.add(search);
                }
            }
        }
        else {
            if(mat.size()>0) {
                materii.addAll(mat);
            }
        }
    }
    public int addNota(Nume student, int valoare, int zi, int luna, int an, String materie, Nume profesor){
        if(materii.size()==0){
            System.out.println("Materia nu exista.");
            return 0;
        }
        Student st = new Student();
        Profesor prof = new Profesor();
        Materie m = new Materie();
        if(studenti.size()==0){
            System.out.println("Studentul pe care incercati sa il punctati nu este inregistrat.");
            return 0;
        }
        else{int found = 0;
            for(int i = 0; i < studenti.size();i++){
                st = studenti.get(i);
                if(st.getNume().equals(student)){
                    found = 1;
                    break;
                }
            }
            if(found == 0){
                System.out.println("Studentul pe care incercati sa il punctati nu este inregistrat.");
                return 0;
            }
        }
        if(profesori.size()==0){
            System.out.println("Profesorul nu este inregistrat.");
            return 0;
        }
        else{
            int found = 0;
            for(int i = 0; i < profesori.size();i++){
                prof = profesori.get(i);
                if(prof.getNume().equals(profesor)){
                    found = 1;
                    break;
                }
            }
            if(found == 0){
                System.out.println("Profesorul nu este inregistrat.");
                return 0;
            }
            else
            {
                int f = 0;
                for(int i = 0; i <= prof.getMaterii().size(); i ++){
                    m = prof.getMaterii().get(i);
                    if(m.getDenumire().equals(materie)){
                        f = 1;
                        break;
                    }
                }
                if(f == 0){
                    System.out.println("Profesorul selectat nu preda aceasta materie!");
                }
                else{
                    Nota n = new Nota(valoare,new Data(zi, luna, an),m, prof );
                    st.getNote().add(n);
                }
            }
        }

    return 0;
    }

    public int searchStudent(Nume student){
        if(studenti.size()>0){
            for(int i = 0; i < studenti.size(); i++){
                if(studenti.get(i).getNume().equals(student)){
                    System.out.println(studenti.get(i));
                    return i;
                }
            }
            System.out.println("Studentul cautat nu a fost gasit!");
            return -1;
        }
        else{
            System.out.println("Nu exista studenti inregistrati.");
            return -1;
        }
    }

    public int searchProfesor(Nume profesor){
        if(profesori.size()>0){
            for(int i = 0; i < profesori.size(); i++){
                if(profesori.get(i).getNume().equals(profesor)){
                    System.out.println(profesori.get(i));
                    return i;
                }
            }
            System.out.println("Profesorul cautat nu a fost gasit!");
            return -1;
        }
        else{
            System.out.println("Nu exista profesori inregistrati.");
            return -1;
        }
    }

    public void medieStudent(Nume student){
        Student temp = studenti.get(searchStudent(student));
        float medie = 0;
        if(temp.getNote().size()>0)
        {
            for (int i = 0; i < temp.getNote().size(); i++) {
                medie = medie + temp.getNote().get(i).getValoare();
            }
            System.out.println("Media studentului " +
                    student + " este " + medie / temp.getNote().size());
        }
        else{
            System.out.println("Studentul nu are note!");
        }
    }

    public int searchMaterie(String denumire){
        if(materii.size()<1){
            return -1;
        }
        else{
            for(int i = 0; i < materii.size(); i++){
                if(materii.get(i).getDenumire().equals(denumire)){
                    return i;
                }
            }
            return -1;
        }
    }

    public void addMaterie(Nume profesor, Materie materie, int add){
        int index = searchProfesor(profesor);
        if(index == -1){
            System.out.println("Profesorul nu este inregistrat");
        }
        else{
            if(!profesori.get(index).getMaterii().contains(materie)) {
                profesori.get(index).getMaterii().add(materie);
            }
            if(add == 1){
                materii.add(materie);
            }
        }
    }

    public int changeGrupa(Nume student, int grupa){
        int index = searchStudent(student);
        if(index == -1){
            System.out.println("Studentul nu este inregistrat.");
            return 0;
        }
        Student aux = studenti.get(index);
        addStudent(aux.getNume().getNume(),aux.getNume().getInitialeleTatalui(),aux.getNume().getPrenume(),
                aux.getDataNasterii().getZi(),aux.getDataNasterii().getLuna(), aux.getDataNasterii().getAn(),
                aux.getAdresa(),aux.getStareCivila(),aux.getAn(), grupa);
        studenti.get(studenti.size()-1).setNote(aux.getNote());
        if(grupe.size()>0){
            int pos = -1;
            for(int i = 0; i < grupe.size(); i++){
                if(grupe.get(i).getNr() == aux.getGrupa()){
                    pos = i;
                    break;
                }
            }
            grupe.get(pos).getStudenti().remove(aux);
            studenti.remove(aux);

        }
        Collections.sort(studenti ,compStudent);
        return 0;
    }

    public int deleteStudent(Nume student){
        int index = searchStudent(student);
        if(index == -1){
            System.out.println("Studentul nu este inregistrat.");
            return 0;
        }
        Student aux = studenti.get(index);
        int pos = -1;
        for(int i = 0; i < grupe.size(); i++){
            if(grupe.get(i).getNr() == aux.getGrupa()){
                pos = i;
                break;
            }
        }
        grupe.get(pos).getStudenti().remove(aux);
        studenti.remove(aux);
        return 0;

    }

    public void deleteProfesor(Nume profesor){
        profesori.remove(searchProfesor(profesor));
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public void logAction(String actionName) throws IOException {

        File file = new File("C:\\Users\\albua\\Desktop\\test.csv");
        this.logWriter = new FileWriter(file,true);
        Date timestamp = new Date();
        String line = timestamp + "," + actionName + "\n";
        try {
            logWriter.append(line);
            logWriter.flush();
        } catch (IOException e) {
            System.err.print("Unable to write to log file");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Services{" +
                "studenti=" + studenti +
                ", materii=" + materii +
                ", profesori=" + profesori +
                ", grupe=" + grupe +
                '}';
    }
}
