package com.example.demo.Services;

import com.example.demo.Models.Patient;
import com.example.demo.Repositories.PatientRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepositorySQL patientRepositorySQL;


    @Override
    public void opretPatient(Patient patient) throws SQLException, ClassNotFoundException {
    patientRepositorySQL.insertPatienttoDB(patient.getForNavn()
            , patient.getEfterNavn()
            , patient.getCpr()
            , patient.getFødselsdato()
            , patient.getTelefonNr()
            , patient.getAdresse()
            , patient.getHøjde()
            , patient.getVægt()
            , patient.getKortBeskrivelse());
    }
}
