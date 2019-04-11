package com.example.demo.Services;

import com.example.demo.Models.Patient;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


public interface PatientService {

     void opretPatient(Patient patient) throws SQLException, ClassNotFoundException;

     boolean tjekLogin(int cpr) throws SQLException, ClassNotFoundException;

     Patient FindPatient(int cpr) throws SQLException, ClassNotFoundException;

}
