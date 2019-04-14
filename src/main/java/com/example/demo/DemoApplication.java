package com.example.demo;

import com.example.demo.Models.Konsultation;
import com.example.demo.Repositories.DiagnoseRepositorySQL;
import com.example.demo.Repositories.KonsultationRepositorySQL;
import com.example.demo.Repositories.PatientRepositorySQL;
import com.example.demo.Repositories.ReceptRepositorySQL;
import com.example.demo.Services.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PatientRepositorySQL patientRepositorySQL = new PatientRepositorySQL();
        patientRepositorySQL.createPatientTable();
        ReceptRepositorySQL receptRepositorySQL = new ReceptRepositorySQL();
        receptRepositorySQL.createReceptTable();
        DiagnoseRepositorySQL diagnoseRepositorySQL = new DiagnoseRepositorySQL();
        diagnoseRepositorySQL.createDiagnoseTable();
        SpringApplication.run(DemoApplication.class, args);


//
//        DiagnoseRepositorySQL diagnoseRepositorySQL = new DiagnoseRepositorySQL();
//        diagnoseRepositorySQL.createDiagnoseTable();


//        KonsultationRepositorySQL konsultationRepositorySQL = new KonsultationRepositorySQL();
//        konsultationRepositorySQL.createKonsultationTable();
    }



}
