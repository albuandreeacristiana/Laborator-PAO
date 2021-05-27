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
    public static final String Citeste_Student = "SELECT nume, initiale, prenume, zi_nastere, luna_nastere, an_nastere, adresa, stare_civila, grupa, id_student FROM catalog.student s join catalog.date_identificare d on s.id_date = d.id_date";
    public static final String Sterge_Student = "DELETE FROM student WHERE (id_student = ?)";
    public static final String Actualizare_Student = "UPDATE catalog.student SET grupa = ? where (id_student =?)";

    public static final String Adauga_Profesor = "insert into profesor (id_date, zi_angajare, luna_angajare, an_angajare) values(?,?,?,?)";
    public static final String Citeste_Profesor = "SELECT nume, initiale, prenume, zi_nastere, luna_nastere, an_nastere, adresa, stare_civila, zi_angajare, luna_angajare, an_angajare, id_profesor FROM catalog.profesor p join catalog.date_identificare d on p.id_date = d.id_date";
    public static final String Sterge_Profesor = "DELETE FROM profesor WHERE (id_profesor = ?)";

    public static final String Adauga_Materie = "insert into materie (nume, an_studiu, nr_semestre) values(?,?,?)";
    public static final String Citeste_Materie = "select id_materie, nume, an_studiu, nr_semestre from materie ";
    public static final String Sterge_Materie = "delete from materie where (id_materie = ?)";
    public static final String Actualizare_Materie = "update catalog.materie set nume = ?, an_studiu=?, nr_semestre=? where id_materie =? ";

    public static final String Adauga_Job = "insert into jobs (id_materie, id_profesor) values(?,?)";
    public static final String Citeste_Job = "select id_materie from jobs where(id_profesor = ?)";
    public static final String Sterge_Job = "delete from job where(id_profesor = ?)";
    public static final String Cauta_Job = "select id_job from jobs where id_profesor = ? and id_materie = ?";

    public static final String Adauga_Nota = "insert into nota (zi, luna, an, id_student, valoare, id_job) values(?,?,?,?,?,?)";
    public static final String Citeste_Nota = "select id_nota, zi, luna, an, id_materie, valoare, id_profesor from nota join jobs on nota.id_job = jobs.id_job where(id_student = ?)";
    public static final String Actualizare_Nota = "update catalog.nota set valoare = ? where id_nota = ?";
    public static final String Sterge_Nota = "delete from nota where(id_nota = ?)";
}
