package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class DiagnoseRepositorySQL {


    public void createDiagnoseTable() throws ClassNotFoundException, SQLException {
        System.out.println("1");


        Statement stmt = DBConfig.getConnection().createStatement();


        System.out.println("5");

      String sql_createDiagnoseTable = "CREATE TABLE IF NOT EXISTS diagnose" +
                "(DiagnoseID int ," +
                "Diagnose_navn varchar(100)," +
                "Medicin_navn varchar (100)," +
                ")";


        System.out.println("6 - Det virker");
        stmt.execute(sql_createDiagnoseTable);
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
