package com.example.demo.Services;

import com.example.demo.Models.Bruger;
import com.example.demo.Models.Patient;
import com.example.demo.Repositories.PatientRepository;
import com.example.demo.Repositories.PatientRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
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


    //Mangler kode til at tjekke om cpr nummeret i databasen er det samme som fra GUI
    @Override
    public boolean tjekLogin(int cpr) throws SQLException, ClassNotFoundException {
        Patient patient = new Patient();
        patient.setCpr(cpr);
        boolean fundetCpr = patientRepositorySQL.selectPatientCpr(cpr);
        return fundetCpr;
    }

    @Override
    public Patient FindPatient(int cpr) throws SQLException, ClassNotFoundException {
        Patient fundetPatient = patientRepositorySQL.FindPatientData(cpr);

        return fundetPatient;
    }

    @Override
    public List<Patient> findAllePatienter() throws SQLException, ClassNotFoundException {
        List<Patient> patiener = patientRepositorySQL.findAllePatienter();
        return patiener;
    }


}
