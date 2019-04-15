package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseRepository {
    public void createTables() throws ClassNotFoundException, SQLException {
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

        String sql_createDiagnoseTable = "CREATE TABLE IF NOT EXISTS " + DBConfig.getUser() + ".diagnose" +
                "(Patient_navn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL,"  +
                "Diagnose varchar(100) NOT NULL, " +
                "Medicin_navn varchar(100) NOT NULL, " +
                "Diagnose_note varchar(100)," +
                "Diagnose_udstedt varchar(10) NOT NULL," +
                "FOREIGN KEY(Patient_cpr)" +
                "REFERENCES patient(Patient_cpr)" +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";

        String sql_createReceptTable = "CREATE TABLE IF NOT EXISTS " +DBConfig.getUser() + ".recept" +
                "(Patient_navn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL," +
                "Recept_note varchar(200),"+
                "Medicin_navn varchar(100) NOT NULL," +
                "Recept_udstedt varchar(10) NOT NULL," +
                "FOREIGN KEY(Patient_cpr)" +
                "REFERENCES patient(Patient_cpr)" +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";

        String sql_createKonsultationTable = "CREATE TABLE IF NOT EXISTS " + DBConfig.getUser() + ".konsultation" +
                "(Patient_navn varchar(100), " +
                "Patient_cpr int(4) NOT NULL, "+
                "Konsultation_beskrivelse varchar (300)," +
                "Konsultation_konklusion varchar(300)," +
                "Konsultation_dato varchar(10), " +
                "FOREIGN KEY(Patient_cpr) " +
                "REFERENCES patient(Patient_cpr) " +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";

        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(sql_createPatientTable);
        stmt.execute(sql_createDiagnoseTable);
        stmt.execute(sql_createReceptTable);
        stmt.execute(sql_createKonsultationTable);
        stmt.close();

    }
}
