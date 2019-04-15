package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import com.example.demo.Models.Diagnose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DiagnoseRepositorySQL {


    public void createDiagnoseTable() throws ClassNotFoundException, SQLException {
        String sql_createDiagnoseTable = "CREATE TABLE IF NOT EXISTS " +DBConfig.getUser() + ".diagnose" +
                "(Patient_navn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL,"  +
                "Diagnose varchar(100) NOT NULL, " +
                "Medicin_navn varchar(100) NOT NULL, " +
                "Diagnose_note varchar(100)," +
                "Diagnose_udstedt varchar(10) NOT NULL," +
                "FOREIGN KEY(Patient_cpr)" +
                "REFERENCES patient(Patient_cpr)" +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";

                /* Den der stod her før hvis den skal bruges.
                "(DiagnoseID int ," +
                "Diagnose_navn varchar(100)," +
                "Medicin_navn varchar (100)," +
                ")";
                */

        SQLExecute(sql_createDiagnoseTable);
    }

    public void insertDiagnosetoDB(String navn, int cpr, String diagnose, String medicin, String note, String udstedt) throws SQLException, ClassNotFoundException {
        String sql_insertDiagnose = "INSERT INTO diagnose" +
                "(Patient_navn, " +
                "Patient_cpr, " +
                "Diagnose, "+
                "Medicin_navn, " +
                "Diagnose_note, " +
                "Diagnose_udstedt) " +
                "VALUES " +
                "('" + navn +  "', " + cpr + ", '" + diagnose +
                "', '" + medicin + "', '" + note + "', '" + udstedt +
                "')";
        SQLExecute(sql_insertDiagnose);
    }

    public List<Diagnose> findPatientDiagnoseData(int cpr) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        String FindDiagnoseData = "SELECT * FROM diagnose WHERE (Patient_cpr = '" + cpr + "');";
        List<Diagnose> diagnoser = new ArrayList<>();

        ResultSet rs = stmt.executeQuery(FindDiagnoseData);
        while(rs.next()){
            String navn = rs.getString("Patient_navn");
            int Cpr = rs.getInt("Patient_cpr");
            String diagnose = rs.getString("Diagnose");
            String medicin = rs.getString("Medicin_navn");
            String note = rs.getString("Diagnose_note");
            String dato = rs.getString("Diagnose_udstedt");

            diagnoser.add(new Diagnose(navn, Cpr, diagnose, medicin, note, dato));
        }
        stmt.close();
        return diagnoser;
    }

    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }
}
