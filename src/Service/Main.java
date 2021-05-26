package Service;

import Model.*;
import Utils.Actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
//        Nume n = new Nume("alllllllbu","sa","andreea");
//        Data date = new Data(20,11,1999);
//        DateIdentificare d = new DateIdentificare(n,date,"adresaaaaa","necasatorita");
//        //Actions.adaugaDate(d);
//        //Actions.stergeDate(1);
//        Actions.actualizareDate(d, 2);
//        List<Nota> note = new ArrayList<>();
//        Student s = new Student(n,date,"adresa noua","blabla",3,222,note);
//        Actions.adaugaStudent(s);
//        System.out.println(Actions.citesteDate());
        System.out.println("Scrieti numarul corespunzator actiunii dorite!\n" +
                "Meniu:\n" +
                "1. Adauga student\n" +
                "2. Adauga profesor\n" +
                "3. Adauga nota\n" +
                "4. Afiseaza student\n" +
                "5. Afiseaza profesor\n" +
                "6. Afiseaza media unui student\n" +
                "7. Adauga materie predata unui profesor\n" +
                "8. Modificare grupa student\n" +
                "9. Stergere student\n" +
                "10. Stergere profesor\n" +
                "11. Exit\n");
        int option = 0;
        boolean ok = false;
        while(!ok){
            try{
                System.out.println("Optiune: ");
                Scanner in = new Scanner(System.in);
                option = in.nextInt();
                ok = true;
            }
            catch(Exception e){
                System.out.println("Puteti introduce doar int-uri! \n");
            }
        }
        Services serv = new Services();
        while(option != 11){
            if(option == 1){
                Scanner in = new Scanner(System.in);
                System.out.println("Nume student:");
                String nume = in.nextLine();
                System.out.println("Initiale tata student:");
                String initiale = in.nextLine();
                System.out.println("Prenume student:");
                String prenume = in.nextLine();
                System.out.println("Data nasterii \n Zi:");
                int zi = in.nextInt();
                System.out.println("Luna:");
                int luna = in.nextInt();
                System.out.println("An:");
                int an = in.nextInt();
                System.out.println("Adresa:");
                in.nextLine();
                String adresa = in.nextLine();
                System.out.println("Stare civila student:");
                String stareCivila = in.nextLine();
                System.out.println("Grupa:");
                int nrGrupa = in.nextInt();
                System.out.println("An studiu:");
                int anStudiu = in.nextInt();
                serv.addStudent(nume, initiale, prenume, zi, luna, an,adresa,stareCivila, anStudiu,nrGrupa);
                System.out.println(serv);
                serv.logAction("Adaugare student");
            }
            else
                if(option == 2){
                    Scanner in = new Scanner(System.in);
                    System.out.println("Nume profesor:");
                    String nume = in.nextLine();
                    System.out.println("Initiale tata profesor:");
                    String initiale = in.nextLine();
                    System.out.println("Prenume profesor:");
                    String prenume = in.nextLine();
                    System.out.println("Data nasterii \nZi:");
                    int zi = in.nextInt();
                    System.out.println("Luna:");
                    int luna = in.nextInt();
                    System.out.println("An:");
                    int an = in.nextInt();
                    System.out.println("Adresa:");
                    in.nextLine();
                    String adresa = in.nextLine();
                    System.out.println("Stare civila profesor:");
                    String stareCivila = in.nextLine();
                    System.out.println("Data angajarii \nZi:");
                    int zia = in.nextInt();
                    System.out.println("Luna:");
                    int lunaa = in.nextInt();
                    System.out.println("An:");
                    int ana = in.nextInt();
                    System.out.println("Introduceti materiile predate sau exit pentru a termina:\nDenumirea materiei:");
                    in.nextLine();
                    List<Materie> mat = new ArrayList<Materie>();
                    String denumire = in.nextLine();
                    while(!denumire.equals("exit")){
                        System.out.println("Numarul de semestre:");
                        int nrs = in.nextInt();
                        System.out.println("An de studiu:");
                        int ans = in.nextInt();
                        Materie m = new Materie(denumire,nrs,ans);
                        mat.add(m);
                        System.out.println("Denumirea materiei:");
                        in.nextLine();
                        denumire = in.nextLine();
                    }
                    serv.addProfesor(nume, initiale, prenume, zi, luna, an,adresa,stareCivila,zia,lunaa,ana,mat);
                    System.out.println(serv);
                    serv.logAction("Adaugare profesor");
                }
                else
                    if(option == 3){
                        Scanner in = new Scanner(System.in);
                        System.out.println("Nume student:");
                        String numes = in.nextLine();
                        System.out.println("Initiale tata student:");
                        String initiales = in.nextLine();
                        System.out.println("Prenume student:");
                        String prenumes = in.nextLine();
                        System.out.println("Nota:");
                        int val = in.nextInt();
                        System.out.println("Data:\nZi:");
                        int zi = in.nextInt();
                        System.out.println("Luna:");
                        int luna = in.nextInt();
                        System.out.println("An:");
                        int an = in.nextInt();
                        in.nextLine();
                        System.out.println("Denumire materie:");
                        String materie = in.nextLine();
                        System.out.println("Nume profesor:");
                        String numep = in.nextLine();
                        System.out.println("Initiale tata profesor:");
                        String initialep = in.nextLine();
                        System.out.println("Prenume profesor:");
                        String prenumep = in.nextLine();
                        serv.addNota(new Nume(numes,initiales,prenumes),val,zi,luna,an,materie,new Nume(numep,initialep,prenumep));
                        serv.logAction("Adaugare nota");
                    }
                    else
                        if(option == 4){
                        Scanner in = new Scanner(System.in);
                            System.out.println("Introduceti numele studentului cautat! \nNume:");
                            String nume = in.nextLine();
                            System.out.println("Prenume:");
                            String prenume = in.nextLine();
                            System.out.println("Initialele tatalui");
                            String initiale = in.nextLine();
                            serv.searchStudent(new Nume(nume,initiale,prenume));
                            serv.logAction("Afisare student");
                        }
                        else
                            if(option == 5){
                                Scanner in = new Scanner(System.in);
                                System.out.println("Introduceti numele profesorului cautat! \nNume:");
                                String nume = in.nextLine();
                                System.out.println("Prenume:");
                                String prenume = in.nextLine();
                                System.out.println("Initialele tatalui");
                                String initiale = in.nextLine();
                                serv.searchProfesor(new Nume(nume,initiale,prenume));
                                System.out.println(serv);
                                serv.logAction("Afisare profesor");

                            }
                            else
                                if(option == 6){
                                    Scanner in = new Scanner(System.in);
                                    System.out.println("Introduceti numele studentului pentru care doriti media! \nNume:");
                                    String nume = in.nextLine();
                                    System.out.println("Prenume:");
                                    String prenume = in.nextLine();
                                    System.out.println("Initialele tatalui");
                                    String initiale = in.nextLine();
                                    serv.medieStudent(new Nume(nume,initiale,prenume));
                                    System.out.println(serv);
                                    serv.logAction("Afisare medie student");

                                }
                                else
                                    if(option == 7){
                                        Scanner in = new Scanner(System.in);
                                        System.out.println("Nume profesor:");
                                        String nume = in.nextLine();
                                        System.out.println("Initiale tata profesor:");
                                        String initiale = in.nextLine();
                                        System.out.println("Prenume profesor:");
                                        String prenume = in.nextLine();
                                        System.out.println("Despre materie\nDenumire:");
                                        String denumire = in.nextLine();
                                        int index = serv.searchMaterie(denumire);
                                        if (index == -1) {
                                            System.out.println("Numarul de semestre:");
                                            int nrs = in.nextInt();
                                            System.out.println("An de studiu:");
                                            int ans = in.nextInt();
                                            serv.addMaterie(new Nume(nume, initiale,prenume),new Materie(denumire,nrs,ans),1);
                                        }
                                        else{
                                            serv.addMaterie(new Nume(nume,initiale,prenume),serv.getMaterii().get(index),0);
                                        }
                                        System.out.println(serv);
                                        serv.logAction("Adauga materie");
                                    }
                                    else
                                        if(option == 8){
                                            Scanner in = new Scanner(System.in);
                                            System.out.println("Introduceti numele studentului pentru care doriti schimbarea grupei! \nNume:");
                                            String nume = in.nextLine();
                                            System.out.println("Prenume:");
                                            String prenume = in.nextLine();
                                            System.out.println("Initialele tatalui");
                                            String initiale = in.nextLine();
                                            System.out.println("Nr grupei noi:");
                                            int nrg = in.nextInt();
                                            serv.changeGrupa(new Nume(nume,initiale,prenume),nrg);
                                            System.out.println(serv);
                                            serv.logAction("Modificare grupa student");

                                        }
                                        else
                                            if(option == 9){
                                                Scanner in = new Scanner(System.in);
                                                System.out.println("Introduceti numele studentului pe care doriti sa il eliminati! \nNume:");
                                                String nume = in.nextLine();
                                                System.out.println("Prenume:");
                                                String prenume = in.nextLine();
                                                System.out.println("Initialele tatalui");
                                                String initiale = in.nextLine();
                                                serv.deleteStudent(new Nume(nume,initiale,prenume));
                                                System.out.println(serv);
                                                serv.logAction("Stergere student");

                                            }
                                            else
                                                if(option == 10){
                                                    Scanner in = new Scanner(System.in);
                                                    System.out.println("Introduceti numele profesorului pe care doriti sa il eliminati! \nNume:");
                                                    String nume = in.nextLine();
                                                    System.out.println("Prenume:");
                                                    String prenume = in.nextLine();
                                                    System.out.println("Initialele tatalui");
                                                    String initiale = in.nextLine();
                                                    serv.deleteProfesor(new Nume(nume,initiale,prenume));
                                                    System.out.println(serv);
                                                    serv.logAction("Stergere profesor");

                                                }
                                                else
                                                {
                                                    System.out.println("Aceasta optiune nu exista!");
                                                }
            ok = false;
            while(!ok){
                try{
                    System.out.println("Optiune: ");
                    Scanner in = new Scanner(System.in);
                    option = in.nextInt();
                    ok = true;
                }
                catch(Exception e){
                    System.out.println("Puteti introduce doar int-uri! \n");
                }
            }
        }
    }
}
