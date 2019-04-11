package com.example.demo.Services;

import com.example.demo.Models.*;

import java.sql.SQLException;

public interface ReceptService {
    void opretRecept(Recept recept) throws SQLException, ClassNotFoundException;
}
