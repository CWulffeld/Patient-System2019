package com.example.demo.Services;

import com.example.demo.Models.Patient;
import com.example.demo.Repositories.PatientRepository;
import com.example.demo.Repositories.PatientRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepositorySQL patientRepositorySQL;

    private PatientRepository patientRepository;


    @Override
    public void OpretPatient(Patient patient) throws SQLException, ClassNotFoundException {
    patientRepositorySQL.insertPatientToDB(patient.getForNavn()
            , patient.getEfterNavn()
            , patient.getCpr()
            , patient.getFødselsdato()
            , patient.getTelefonNr()
            , patient.getAdresse()
            , patient.getHøjde()
            , patient.getVægt()
            , patient.getKortBeskrivelse());


    patientRepository.save(patient);
    }


}
