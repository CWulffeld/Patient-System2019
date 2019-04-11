package com.example.demo.Services;

import com.example.demo.Models.*;

import java.sql.SQLException;

public interface DiagnoseService {
    void opretDiagnose(Diagnose diagnose) throws SQLException, ClassNotFoundException;
    void tjekLogin(Bruger bruger) throws SQLException, ClassNotFoundException;
}
