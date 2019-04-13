package com.example.demo.Services;

import com.example.demo.Models.Patient;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface PatientService {

     void opretPatient(Patient patient) throws SQLException, ClassNotFoundException;

     /*boolean tjekLogin(int cpr) throws SQLException, ClassNotFoundException;*/

     Patient FindPatient(int cpr) throws SQLException, ClassNotFoundException;

     List<Patient> findAllePatienter() throws SQLException, ClassNotFoundException;

     void SletPatient(int cpr) throws SQLException, ClassNotFoundException;

}
