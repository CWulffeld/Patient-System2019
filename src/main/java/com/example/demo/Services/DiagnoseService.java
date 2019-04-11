package com.example.demo.Services;

import com.example.demo.Models.Diagnose;
import com.example.demo.Models.Patient;

import java.sql.SQLException;

public interface DiagnoseService {

    void tildelDiagnose(Diagnose diagnose) throws SQLException, ClassNotFoundException;
}
