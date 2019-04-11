package com.example.demo.Services;

import com.example.demo.Models.Recept;
import com.example.demo.Repositories.ReceptRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class ReceptServiceImpl implements ReceptService {

    @Autowired
    ReceptRepositorySQL receptRepositorySQL;

    @Override
    public void opretRecept(Recept recept) throws SQLException, ClassNotFoundException {
        receptRepositorySQL.insertRecepttoDB(recept.getPatientFornavn(), recept.getPatientEfternavn(),
                recept.getCpr(), recept.getNote(), recept.getMedicin(), recept.getDato());
    }
}
