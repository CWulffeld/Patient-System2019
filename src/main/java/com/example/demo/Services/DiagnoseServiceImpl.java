package com.example.demo.Services;

import com.example.demo.Models.Bruger;
import com.example.demo.Models.Diagnose;
import com.example.demo.Repositories.DiagnoseRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DiagnoseServiceImpl implements DiagnoseService {

    @Autowired
    DiagnoseRepositorySQL diagnoseRepositorySQL;

    @Override
    public void opretDiagnose(Diagnose diagnose) throws SQLException, ClassNotFoundException {
        diagnoseRepositorySQL.insertDiagnosetoDB(diagnose.getPatientNavn(),
                diagnose.getCpr(), diagnose.getDiagnose(), diagnose.getMedicin(),
                diagnose.getNote(), diagnose.getDato());
    }

    @Override
    public List<Diagnose> findDiagnoserViaCpr(int cpr) throws SQLException, ClassNotFoundException {
        List<Diagnose> diagnoser = diagnoseRepositorySQL.findPatientDiagnoseData(cpr);
        return diagnoser;
    }

}
