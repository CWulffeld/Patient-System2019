package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class DiagnoseRepositorySQL {


    public void createDiagnoseTable() throws ClassNotFoundException, SQLException {
        String sql_createDiagnoseTable = "CREATE TABLE IF NOT EXISTS diagnose" +
                "Patient_fornavn varchar(100) NOT NULL," +
                "Patient_efternavn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL,"  +
                "Diagnose varchar(100) NOT NULL, " +
                "Medicin_navn varchar(100) NOT NULL, " +
                "Diagnose_note varchar(100)," +
                "Diagnose_udstedt DATE NOT NULL," +
                "PRIMARY KEY()" +
                ")";

                /* Den der stod her før hvis den skal bruges.
                "(DiagnoseID int ," +
                "Diagnose_navn varchar(100)," +
                "Medicin_navn varchar (100)," +
                ")";
                */

        SQLExecute(sql_createDiagnoseTable);
    }

    public void insertDiagnosetoDB(String fornavn, String efternavn, int cpr, String diagnose, String medicin, String note, String udstedt) throws SQLException, ClassNotFoundException {
        String sql_insertDiagnose = "INSERT INTO diagnose" +
                "(Patient_fornavn, " +
                "Patient_efterNavn, " +
                "Patient_cpr, " +
                "Diagnose, "+
                "Medicin_navn, " +
                "Diagnose_note, " +
                "Diagnose_udstedt, " +
                "VALUES " +
                "('" + fornavn + "', '" + efternavn +
                "', " + cpr + ", '" + diagnose +
                "', '" + note + "'. '" + medicin+
                "', '" + udstedt +
                "')";
        SQLExecute(sql_insertDiagnose);
    }

    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }
   // public void createDiagnose


//    public void createPatientDiagnoseTable() throws SQLException, ClassNotFoundException {
//        System.out.println("1");
//
//
//        Statement stmt = DBConfig.getConnection().createStatement();
//
//
//        System.out.println("5");
//
//        String sql_createDiagnoseTable = "CREATE TABLE IF NOT EXISTS patientDiagnose" +
//                "(Patient_forNavn varchar (100)," +
//                "Patient_efterName varchar(100)," +
//                "Patient_cpr int(4)," +
//                "Patient_fødselsdato DATE, " +
//                "Patient_telefonnr int (8)," +
//                "Patient_adresse varchar (100),"+
//                "Patient_højde int (4)," +
//                "Patient_vægt int (4)," +
//                "Patient_beskrivelse varchar (250)" +
//                ")";
//
//
//        System.out.println("2 - Det virker");
//        stmt.execute(sql_createDiagnoseTable);
//        stmt.close();
//
//    }
}
