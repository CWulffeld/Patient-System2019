package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import com.example.demo.Models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    /*public boolean selectPatientCpr(int cpr ) throws SQLException, ClassNotFoundException {
        Statement stmt = DBConfig.getConnection().createStatement();
        String sql_selectPatientCpr = "SELECT patient_cpr From patient WHERE patient_cpr = " + cpr;
        ResultSet rs = stmt.executeQuery(sql_selectPatientCpr);
        boolean cprFundet = false;
        while(rs.next()){
            if(rs.getInt("Patient_cpr") == cpr){
                cprFundet = true;
            }
        }
        stmt.close();
        return cprFundet;
    }*/

    public Patient FindPatientData(int cpr) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        String FindPatientData = "SELECT * FROM patient WHERE (Patient_cpr = '" + cpr + "');";
        Patient patient = new Patient();
        ResultSet rs = stmt.executeQuery(FindPatientData);
        while(rs.next()){
            String fornavn = rs.getString("Patient_fornavn");
            String efternavn = rs.getString("Patient_efternavn");
            int Cpr = rs.getInt("Patient_cpr");
            String dato = rs.getString("Patient_fødselsdato");
            int telefonNr = rs.getInt("Patient_telefonnr");
            String adresse = rs.getString("Patient_adresse");
            int højde = rs.getInt("Patient_højde");
            int vægt = rs.getInt("Patient_vægt");
            String beskrivelse = rs.getString("Patient_beskrivelse");

            patient = new Patient(fornavn, efternavn, Cpr, dato, telefonNr, adresse, højde, vægt,beskrivelse );
        }
        stmt.close();
        return patient;
    }

    public List<Patient> findAllePatienter() throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        String SortViaFornavn = "SELECT * FROM patient ORDER BY Patient_fornavn ASC";
        List<Patient> patienter = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(SortViaFornavn);
        while(rs.next()){
            String fornavn = rs.getString("Patient_fornavn");
            String efternavn = rs.getString("Patient_efternavn");
            int Cpr = rs.getInt("Patient_cpr");
            String dato = rs.getString("Patient_fødselsdato");
            int telefonNr = rs.getInt("Patient_telefonnr");
            String adresse = rs.getString("Patient_adresse");
            int højde = rs.getInt("Patient_højde");
            int vægt = rs.getInt("Patient_vægt");
            String beskrivelse = rs.getString("Patient_beskrivelse");

            patienter.add(new Patient(fornavn, efternavn, Cpr, dato, telefonNr, adresse, højde, vægt, beskrivelse));
        }
        stmt.close();
        return patienter;
    }

    //Sorter table via parametre
    public void SorterViaFornavn() throws ClassNotFoundException, SQLException{
        String SortViaFornavn = "SELECT * FROM patient ORDER BY Patient_fornavn ASC|DESC";
        SQLExecute(SortViaFornavn);
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


    //Bare fordi det skal genbruges. Kan være det burde stå så alt SQl kan nå den samme.
    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }

    private ResultSet SQLExecuteQuery(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        stmt.close();
        return rs;
    }

    private void SQLExecuteUpdate(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.executeUpdate(SQL);
        stmt.close();
    }
}