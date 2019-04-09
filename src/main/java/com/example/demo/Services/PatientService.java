package com.example.demo.Services;

import com.example.demo.Models.Patient;

import java.sql.SQLException;

public interface PatientService {


     void OpretPatient(Patient patient) throws SQLException, ClassNotFoundException;
}
