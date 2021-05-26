package Utils;


import Model.Data;
import Model.DateIdentificare;
import Model.Nume;
import Model.Student;

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

    public static String adaugaStudent(Student s){
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
                return resultSet.getString(1);
            }
            else
                return "0";
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred");
        }
    }

}


