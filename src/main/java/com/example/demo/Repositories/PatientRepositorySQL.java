package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import com.example.demo.Models.Patient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepositorySQL{

    //Måske have en composite primary key her af fødselsdato og cpr, da det ellers muligvis kommer til at have duplicates?
    public void createPatientTable() throws ClassNotFoundException, SQLException {
            String sql_createPatientTable = "CREATE TABLE IF NOT EXISTS "+ DBConfig.getUser() +".patient " +
                "(Patient_fornavn varchar(50), " +
                "Patient_efternavn varchar(50), " +
                "Patient_cpr int(4) NOT NULL, " +
                "Patient_fødselsdato varchar(10), " +
                "Patient_telefonnr int(8), " +
                "Patient_adresse varchar(100), "+
                "Patient_højde int(4), " +
                "Patient_vægt int(4), " +
                "Patient_beskrivelse varchar(250), " +
                "PRIMARY KEY(Patient_cpr))";
        SQLExecute(sql_createPatientTable);
    }
    //Er ikke så glad for duplicate primary key - CPR
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

    public void sletPatient(int cpr)throws SQLException, ClassNotFoundException{
        String sletPatientViaCpr = "DELETE FROM patient WHERE (Patient_cpr = '" + cpr + "');";
        SQLExecute(sletPatientViaCpr);
    }

    public void opdaterPatient(Patient patient) throws SQLException, ClassNotFoundException{
        String opdaterPatientViaCpr = "UPDATE patient " +
                "SET Patient_fornavn = '" + patient.getForNavn() +
                "', Patient_efternavn = '" + patient.getEfterNavn() +
                "', Patient_fødselsdato = '" + patient.getFoedselsdato() +
                "', Patient_telefonnr = '" + patient.getTelefonNr() +
                "', Patient_adresse = '" + patient.getAdresse() +
                "', Patient_højde = '" + patient.getHoejde() +
                "', Patient_vægt = '" + patient.getVaegt() +
                "', Patient_beskrivelse = '" + patient.getKortBeskrivelse() +
                "' WHERE (Patient_cpr = '" + patient.getCpr() +"');";

        SQLExecute(opdaterPatientViaCpr);
    }
    //2 næste, ikke færdig, aldrig brugt
    public List<?> liste() throws SQLException, ClassNotFoundException
    {
        String innerJoin = "SELECT p.Patient_fornavn, p.Patient_efternavn, p.Patient_cpr, d.Medicin_navn" +
                "FROM " + DBConfig.getUser() + ".patient as p" +
                "INNER JOIN diagnose as d" +
                "ON p.Patient_cpr = d.Patient_cpr";

        Statement stmt = DBConfig.getConnection().createStatement();
        List<?> liste = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(innerJoin);
        while(rs.next()){
            String fornavn = rs.getString("Patient_fornavn");
            String efternavn = rs.getString("Patient_efternavn");
            int Cpr = rs.getInt("Patient_cpr");
            String medicin = rs.getString("Diagnose_medicin");

            //liste.add(new object(fornavn, efternavn, Cpr, medicin));
        }
        stmt.close();
        return liste;
    }

    public List<?> mnayToMany() throws SQLException, ClassNotFoundException
    {
        String manyTomany = "SELECT p.Patient_fornavn, p.Patient_efternavn, p.Patient_cpr, d.Diagnose" +
                "FROM " + DBConfig.getUser() + ".patient as p" +
                "INNER JOIN diagnose as d" +
                "ON p.Patient_cpr = d.Patient_cpr";

        Statement stmt = DBConfig.getConnection().createStatement();
        List<?> liste = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(manyTomany);
        while(rs.next()){
            String fornavn = rs.getString("Patient_fornavn");
            String efternavn = rs.getString("Patient_efternavn");
            int Cpr = rs.getInt("Patient_cpr");
            String diagnose = rs.getString("Diagnose");

            //liste.add(new object(fornavn, efternavn, Cpr, diagnose));
        }
        stmt.close();
        return liste;
    }

    //Sorter table via parametre
    public void SorterViaFornavn() throws ClassNotFoundException, SQLException{
        String SortViaFornavn = "SELECT * FROM patient ORDER BY Patient_fornavn DESC";
        SQLExecute(SortViaFornavn);
    }

    public void SorterViaEfternavn() throws ClassNotFoundException, SQLException{
        String SortViaEfternavn = "SELECT * FROM patient ORDER BY Patient_efternavn ASC";
        SQLExecute(SortViaEfternavn);
    }

    public void SorterViaCpr() throws ClassNotFoundException, SQLException{
        String SortViaEfternavn = "SELECT * FROM patient ORDER BY Patient_cpr ASC";
        SQLExecute(SortViaEfternavn);
    }

    public void SorterViaAlder() throws ClassNotFoundException, SQLException{
        String SortViaAlder = "SELECT * FROM patient ORDER BY Patient_alder ASC";
        SQLExecute(SortViaAlder);
    }
    public void SorterViaHøjde() throws ClassNotFoundException, SQLException{
        String SortViaHøjde = "SELECT * FROM patient ORDER BY Patient_højde ASC";
        SQLExecute(SortViaHøjde);
    }

    public void SorterViaVægt() throws ClassNotFoundException, SQLException{
        String SortViaVægt = "SELECT * FROM patient ORDER BY Patient_vægt ASC";
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
}