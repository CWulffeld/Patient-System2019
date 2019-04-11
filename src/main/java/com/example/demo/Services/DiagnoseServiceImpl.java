package com.example.demo.Services;

import com.example.demo.Models.Diagnose;
import com.example.demo.Models.Patient;
import com.example.demo.Repositories.DiagnoseRepositorySQL;
import com.example.demo.Repositories.PatientRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DiagnoseServiceImpl implements DiagnoseService {
    @Autowired
    DiagnoseRepositorySQL diagnoseRepositorySQL;



    // private PatientRepository patientRepository;


    @Override
    public void tildelDiagnose(Diagnose diagnose) throws SQLException, ClassNotFoundException {
        diagnoseRepositorySQL.insertDiagnosetoDB(diagnose.getPatientFornavn()
                , diagnose.getPatientEfternavn()
                , diagnose.getCpr()
                , diagnose.getDiagnose()
                , diagnose.getMedicin()
                , diagnose.getNote()
                , diagnose.getDato());


        //patientRepository.save(patient);
    }
}
