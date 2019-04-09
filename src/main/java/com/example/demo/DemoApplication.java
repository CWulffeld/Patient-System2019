package com.example.demo;

import com.example.demo.Repositories.PatientRepositorySQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(DemoApplication.class, args);


        PatientRepositorySQL patientRepositorySQL = new PatientRepositorySQL();


        patientRepositorySQL.createPatientTable();



    }



}
