package Utils;

public class Queries {
    public static final String Adauga_Date =
            "insert into date_identificare (nume, initiale, prenume, zi_nastere, luna_nastere, an_nastere, adresa, stare_civila) " +
                    "values(?,?,?,?,?,?,?,?)";
    public static final String Citeste_Date =
            "select id_date, nume, initiale, prenume, zi_nastere, luna_nastere, an_nastere, adresa, stare_civila from date_identificare  ";
    public static final String Sterge_Date = "DELETE FROM date_identificare WHERE (id_date = ?)";

    public static final String Actualizare_Date = "UPDATE catalog.date_identificare SET nume = ?,initiale =?, prenume=?, zi_nastere=?, luna_nastere=?, an_nastere=?, adresa=?, stare_civila=?   WHERE (id_date = ?)";

    public static final String Adauga_Student = "insert into student (grupa, id_date) values(?,?)";
    public static final String Citeste_Student = "SELECT nume, initiale, prenume, zi_nastere, luna_nastere, an_nastere, adresa, stare_civila, grupa FROM catalog.student s join catalog.date_identificare d on s.id_date = d.id_date";

}
