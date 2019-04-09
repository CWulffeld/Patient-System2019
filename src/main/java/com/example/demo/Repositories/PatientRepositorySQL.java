package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PatientRepositorySQL {


//
//    @Autowired
//    DBConfig DB;

    public void createPatientTable() throws ClassNotFoundException, SQLException {
        System.out.println("1");


        Statement stmt = DBConfig.getConnection().createStatement();


        System.out.println("5");

            String sql_createPatientTable = "CREATE TABLE IF NOT EXISTS patient" +
                "(Patient_forNavn varchar (100)," +
                "Patient_efterName varchar(100)," +
                "Patient_cpr int(4)," +
                "Patient_fødselsdato DATE, " +
                "Patient_telefonnr int (8)," +
                "Patient_adresse varchar (100),"+
                "Patient_højde int (4)," +
                "Patient_vægt int (4)," +
                "Patient_beskrivelse varchar (250)" +
                ")";


        System.out.println("2 - Det virker");
        stmt.execute(sql_createPatientTable);
        stmt.close();

    }
}