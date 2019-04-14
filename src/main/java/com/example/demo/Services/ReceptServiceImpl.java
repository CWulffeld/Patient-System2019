package com.example.demo.Services;

import com.example.demo.Models.Recept;
import com.example.demo.Repositories.ReceptRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class ReceptServiceImpl implements ReceptService {

    ReceptRepositorySQL receptRepositorySQL = new ReceptRepositorySQL();

    @Override
    public void opretRecept(Recept recept) throws SQLException, ClassNotFoundException, NullPointerException {
        System.out.println(recept.toString() + " " + recept.getCpr());
        receptRepositorySQL.insertRecepttoDB(recept.getPatientNavn(),
                recept.getCpr(), recept.getNote(), recept.getMedicin(), recept.getDato());
    }
}
