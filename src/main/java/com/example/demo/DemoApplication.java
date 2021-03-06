package com.example.demo;

import com.example.demo.Models.Konsultation;
import com.example.demo.Repositories.*;
import com.example.demo.Services.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Bare så databaserne er der, ikke endelig løsning.
        DatabaseRepository database = new DatabaseRepository();
        database.createTables();
        SpringApplication.run(DemoApplication.class, args);


//
//        DiagnoseRepositorySQL diagnoseRepositorySQL = new DiagnoseRepositorySQL();
//        diagnoseRepositorySQL.createDiagnoseTable();


//        KonsultationRepositorySQL konsultationRepositorySQL = new KonsultationRepositorySQL();
//        konsultationRepositorySQL.createKonsultationTable();
    }



}
