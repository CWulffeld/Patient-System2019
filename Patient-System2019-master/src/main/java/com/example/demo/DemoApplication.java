package com.example.demo;

import com.example.demo.Models.Patient;
import com.example.demo.Services.PatientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("Module.xml");

        PatientService patientService = (PatientService) context.getBean("Patient");
        Patient patient = new Patient(4321, "Hald");
        patientService.insert(patient);*/

        SpringApplication.run(DemoApplication.class, args);
    }


}
