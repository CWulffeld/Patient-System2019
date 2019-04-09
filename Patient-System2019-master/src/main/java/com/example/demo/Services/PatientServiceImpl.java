package com.example.demo.Services;
import com.example.demo.Repositories.PatientRepository;
import com.example.demo.Models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*@Autowired
    PatientRepository patientRepo;

    List<Patient> patienter = new ArrayList<>();

    public PatientServiceImpl(){
        //for loop
        //patienter.add();
    }*/

    @Override
    public List<Patient> findAllePatienter() {
        return null; //Find alle patienter
    }

    @Override
    public Patient findViaCPR(int cpr) {
        return null; //Find en patient via CPR
    }

    @Override
    public void insert(Patient patient) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, patient.getCpr());
            ps.setString(2, patient.getNavn());
            ps.setInt(3, patient.getTelefonNr());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
