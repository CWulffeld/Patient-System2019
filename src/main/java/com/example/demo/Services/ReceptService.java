package com.example.demo.Services;

import com.example.demo.Models.*;

import java.sql.SQLException;
import java.util.List;

public interface ReceptService {
    void opretRecept(Recept recept) throws SQLException, ClassNotFoundException;

    List<Recept> findRecepterViaCpr(int cpr) throws SQLException, ClassNotFoundException;
}
