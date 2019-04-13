package com.example.demo.Services;

import com.example.demo.Models.Patient;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface PatientService {

     void opretPatient(Patient patient) throws SQLException, ClassNotFoundException;

     /*boolean tjekLogin(int cpr) throws SQLException, ClassNotFoundException;*/

     Patient findPatient(int cpr) throws SQLException, ClassNotFoundException;

     List<Patient> findAllePatienter() throws SQLException, ClassNotFoundException;

     void sletPatient(int cpr) throws SQLException, ClassNotFoundException;

     void opdaterPatient(Patient patient) throws SQLException, ClassNotFoundException;
}
