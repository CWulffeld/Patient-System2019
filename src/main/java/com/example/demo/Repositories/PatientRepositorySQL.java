package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import com.example.demo.Models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Date;

@Repository
public class PatientRepositorySQL{

//    @Autowired
//    DBConfig DB;
    //Måske have en composite primary key her af fødselsdato og cpr, da det ellers muligvis kommer til at have duplicates?
    public void createPatientTable() throws ClassNotFoundException, SQLException {
            String sql_createPatientTable = "CREATE TABLE IF NOT EXISTS patient" +
                "(Patient_forNavn varchar (100)," +
                "Patient_efterNavn varchar(100)," +
                "Patient_cpr int(4)," +
                "Patient_fødselsdato DATE, " +
                "Patient_telefonnr int (8)," +
                "Patient_adresse varchar (100),"+
                "Patient_højde int (4)," +
                "Patient_vægt int (4)," +
                "Patient_beskrivelse varchar (250)" +
                ")";
        SQLExecute(sql_createPatientTable);
    }
    //Har problem med duplicate key til Primary - Gætter cpr? Samt at tallet ikke behøves at være 4 cifre, default er 0.
    public void insertPatienttoDB(String fornavn, String efternavn, int cpr, String fødselsdato, int telefonnr, String adresse, int højde, int vægt, String beskrivelse)
            throws SQLException, ClassNotFoundException {
        String sql_insertPatient = "INSERT INTO patient" +
                "(Patient_fornavn, " +
                "Patient_efterNavn, " +
                "Patient_cpr, " +
                "Patient_fødselsdato, "+
                "Patient_telefonnr, " +
                "Patient_adresse, " +
                "Patient_højde, "+
                "Patient_vægt, "+
                "Patient_beskrivelse) " +

                "VALUES " +
                 "('" + fornavn + "', '" +
                efternavn + "', '" +
                cpr + "', '" +
                fødselsdato + "', '" + telefonnr + "', '" + adresse + "', '" + højde + "', '" + vægt + "', '" + beskrivelse + "')";
        SQLExecute(sql_insertPatient);

    }


    //SELECT DISTINCT. selecter patient cpr via argumentet.
    public void selectPatientCpr(int cpr ) throws SQLException, ClassNotFoundException {
        String sql_selectPatientCpr = "SELECT patient_cpr From patient WHERE patient_cpr = " + cpr;
        SQLExecute(sql_selectPatientCpr);

    }
    //Sorter table via parametre
    public void SorterViaFornavn() throws ClassNotFoundException, SQLException{
        String SortViaEfternavn = "SELECT * FROM patient ORDER BY Patient_fornavn ASC|DESC";
        SQLExecute(SortViaEfternavn);
    }

    public void SorterViaEfternavn() throws ClassNotFoundException, SQLException{
        String SortViaEfternavn = "SELECT * FROM patient ORDER BY Patient_efternavn ASC|DESC";
        SQLExecute(SortViaEfternavn);
    }

    public void SorterViaCpr() throws ClassNotFoundException, SQLException{
        String SortViaEfternavn = "SELECT * FROM patient ORDER BY Patient_cpr ASC|DESC";
        SQLExecute(SortViaEfternavn);
    }

    public void SorterViaAlder() throws ClassNotFoundException, SQLException{
        String SortViaAlder = "SELECT * FROM patient ORDER BY Patient_alder ASC|DESC";
        SQLExecute(SortViaAlder);
    }
    public void SorterViaHøjde() throws ClassNotFoundException, SQLException{
        String SortViaHøjde = "SELECT * FROM patient ORDER BY Patient_højde ASC|DESC";
        SQLExecute(SortViaHøjde);
    }

    public void SorterViaVægt() throws ClassNotFoundException, SQLException{
        String SortViaVægt = "SELECT * FROM patient ORDER BY Patient_vægt ASC|DESC";
        SQLExecute(SortViaVægt);
    }

    public void FindPatientData(int cpr) throws ClassNotFoundException, SQLException{
        String FindPatientData = "SELECT * FROM tables WHERE (Patient_cpr = '" + cpr + "');";
        SQLExecute(FindPatientData);
    }

    //Bare fordi det skal genbruges. Kan være det burde stå så alt SQl kan nå den samme.
    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }
}