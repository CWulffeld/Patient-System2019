package com.example.demo.Services;

import com.example.demo.Models.Recept;
import com.example.demo.Repositories.ReceptRepositorySQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class ReceptServiceImpl implements ReceptService {

    ReceptRepositorySQL receptRepositorySQL = new ReceptRepositorySQL();

    @Override
    public void opretRecept(Recept recept) throws SQLException, ClassNotFoundException, NullPointerException {
        receptRepositorySQL.insertRecepttoDB(recept.getPatientNavn(),
                recept.getCpr(), recept.getNote(), recept.getMedicin(), recept.getDato());
    }

    @Override
    public List<Recept> findRecepterViaCpr(int cpr) throws SQLException, ClassNotFoundException {
        List<Recept> recepter = receptRepositorySQL.FindPatientReceptData(cpr);
        return recepter;
    }
}
