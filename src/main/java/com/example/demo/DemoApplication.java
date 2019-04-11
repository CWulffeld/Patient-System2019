package com.example.demo;

import com.example.demo.Models.Konsultation;
import com.example.demo.Repositories.DiagnoseRepositorySQL;
import com.example.demo.Repositories.KonsultationRepositorySQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(DemoApplication.class, args);

//
//        DiagnoseRepositorySQL diagnoseRepositorySQL = new DiagnoseRepositorySQL();
//        diagnoseRepositorySQL.createDiagnoseTable();


//        KonsultationRepositorySQL konsultationRepositorySQL = new KonsultationRepositorySQL();
//        konsultationRepositorySQL.createKonsultationTable();
    }



}
