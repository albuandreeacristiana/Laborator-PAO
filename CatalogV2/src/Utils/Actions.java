package Utils;


import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Utils.Queries.*;

public class Actions {
    private static DbConnection dbConnection = DbConnection.getInstance();

    public static int adaugaDate(DateIdentificare date){
    ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Date, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, date.getNume().getNume());
            preparedStatement.setString(2, date.getNume().getInitialeleTatalui());
            preparedStatement.setString(3, date.getNume().getPrenume());
            preparedStatement.setInt(4, date.getDataNasterii().getZi());
            preparedStatement.setInt(5, date.getDataNasterii().getLuna());
            preparedStatement.setInt(6, date.getDataNasterii().getAn());
            preparedStatement.setString(7, date.getAdresa());
            preparedStatement.setString(8, date.getStareCivila());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            else
                return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
}
}

    public static List<DateIdentificare> citesteDate() {
        List<DateIdentificare> date = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Citeste_Date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Nume n = new Nume(resultSet.getString(2),resultSet.getString(3), resultSet.getString(4));
                Data dn = new Data(resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7));
                DateIdentificare d = new DateIdentificare(n,dn,resultSet.getString(8),resultSet.getString(9));
                date.add(d);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void stergeDate(int id){


        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Sterge_Date, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void actualizareDate(DateIdentificare date, int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.getDBConnection().prepareStatement(Actualizare_Date, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setString(1, date.getNume().getNume());
        preparedStatement.setString(2, date.getNume().getInitialeleTatalui());
        preparedStatement.setString(3, date.getNume().getPrenume());
        preparedStatement.setInt(4, date.getDataNasterii().getZi());
        preparedStatement.setInt(5, date.getDataNasterii().getLuna());
        preparedStatement.setInt(6, date.getDataNasterii().getAn());
        preparedStatement.setString(7, date.getAdresa());
        preparedStatement.setString(8, date.getStareCivila());
        preparedStatement.setInt(9, id);
        preparedStatement.executeUpdate();
    }

////////////////////////////////////////////////////////////////////////////////////////////


    public static List<Materie> citesteMaterii(int id){
        List<Materie> materii = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Citeste_Job);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int m = resultSet.getInt(1);

                PreparedStatement st = dbConnection.getDBConnection().prepareStatement(Citeste_Materie);
                ResultSet r = st.executeQuery();
                while(r.next()){
                    if (r.getInt(1) == m){
                        Materie mat = new Materie();
                        mat.setId(r.getInt(1));
                        mat.setDenumire(r.getString(2));
                        mat.setAnStudiu(r.getInt(3));
                        mat.setNrSemestre(r.getInt(4));
                        materii.add(mat);
                    }
                }


            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return materii;
    }
    public static List<Profesor> citesteProfesori(){
        List<Profesor> profesori = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Citeste_Profesor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Nume n = new Nume(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3));
                Data dn = new Data(resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6));
                DateIdentificare d = new DateIdentificare(n,dn,resultSet.getString(7),resultSet.getString(8));
                List<Materie> materii = new ArrayList<>();
                Data da = new Data(resultSet.getInt(9),resultSet.getInt(10),resultSet.getInt(11));
                Profesor p = new Profesor(n,dn,d.getAdresa(),d.getStareCivila(),da,materii);
                p.setId(resultSet.getInt(12));
                p.setMaterii(citesteMaterii(p.getId()));
                profesori.add(p);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return profesori;
    }
    public static List<Nota> citesteNote(int id,List<Materie> materii, List<Profesor> profesori){
        List<Nota> note = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Citeste_Nota);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            int prof = resultSet.getInt(7);
            int materie = resultSet.getInt(5);
            Nota n = new Nota(resultSet.getInt(6),new Data(resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4)),new Materie(),new Profesor());
            for(int i=0; i<materii.size();i++){
                if(materii.get(i).getId() == materie){
                    n.setMaterie(materii.get(i));
                }
            }
                for(int i=0; i<profesori.size();i++){
                    if(profesori.get(i).getId() == prof){
                        n.setProfesor(profesori.get(i));
                    }
                }
            note.add(n);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return note;
    }
    public static List<Student> citesteStudenti(List<Materie> materii, List<Profesor>profesori) {
        List<Student> studenti = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Citeste_Student);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Nume n = new Nume(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3));
                Data dn = new Data(resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6));
                DateIdentificare d = new DateIdentificare(n,dn,resultSet.getString(7),resultSet.getString(8));
                List<Nota> note = new ArrayList<>();
                Student s = new Student(n,dn,d.getAdresa(),d.getStareCivila(),0,resultSet.getInt(9),note);
                s.setId(resultSet.getInt(10));
                s.setNote(citesteNote(s.getId(),materii,profesori));
                studenti.add(s);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return studenti;
    }


    public static int adaugaStudent(Student s){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Student, Statement.RETURN_GENERATED_KEYS);
            DateIdentificare d = new DateIdentificare(s.getNume(),s.getDataNasterii(),s.getAdresa(),s.getStareCivila());
             int i = adaugaDate(d);
             preparedStatement.setInt(1,s.getGrupa());
             preparedStatement.setInt(2,i);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            else
                return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
        }
    }
    public static int adaugaMaterie(Materie m){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Materie, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,m.getDenumire());
            preparedStatement.setInt(2,m.getAnStudiu());
            preparedStatement.setInt(3,m.getNrSemestre());



            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            else
                return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
        }
    }
    public static int adaugaJob(int m, int p){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Job, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,m);
            preparedStatement.setInt(2,p);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            else
                return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
        }
    }
    public static int adaugaProfesor(Profesor p){

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Profesor, Statement.RETURN_GENERATED_KEYS);
            DateIdentificare d = new DateIdentificare(p.getNume(),p.getDataNasterii(),p.getAdresa(),p.getStareCivila());
            int i = adaugaDate(d);
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2,p.getDataAngajarii().getZi());
            preparedStatement.setInt(3,p.getDataAngajarii().getLuna());
            preparedStatement.setInt(4,p.getDataAngajarii().getAn());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                for(int x=0;x<p.getMaterii().size();x++){
                    int m = adaugaMaterie(p.getMaterii().get(x));
                    adaugaJob(m,resultSet.getInt(1));
                }
                return resultSet.getInt(1);
            }
            else
                return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
        }
    }
    public static int adaugaNota(Nota n,int idStudent) throws SQLException {
        ResultSet resultSet;
        try{
            int job=0;

            PreparedStatement st = dbConnection.getDBConnection().prepareStatement(Cauta_Job);
            st.setInt(1,n.getProfesor().getId());
            st.setInt(2,n.getMaterie().getId());
            ResultSet r = st.executeQuery();
            while(r.next()){
                job = r.getInt(1);
                }

            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Nota, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,n.getData().getZi());
            preparedStatement.setInt(2,n.getData().getLuna());
            preparedStatement.setInt(3,n.getData().getAn());
            preparedStatement.setInt(4,idStudent);
            preparedStatement.setInt(5,n.getValoare());
            preparedStatement.setInt(6,job);

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            else
                return 0;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
        }
    }

    public static void stergeStudent(int id){


        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Sterge_Student, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}


