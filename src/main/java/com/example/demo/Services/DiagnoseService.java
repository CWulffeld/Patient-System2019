package com.example.demo.Services;

import com.example.demo.Models.*;

import java.sql.SQLException;
import java.util.List;

public interface DiagnoseService {
    void opretDiagnose(Diagnose diagnose) throws SQLException, ClassNotFoundException;

    List<Diagnose> findDiagnoserViaCpr(int cpr) throws SQLException, ClassNotFoundException;
}
