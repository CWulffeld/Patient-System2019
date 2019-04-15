package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import com.example.demo.Models.Konsultation;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KonsultationRepositorySQL {
    public void createKonsultationTable() throws ClassNotFoundException, SQLException {
        String sql_createKonsultationTable = "CREATE TABLE IF NOT EXISTS " + DBConfig.getUser() + ".konsultation" +
                "(Patient_navn varchar(100)" +
                "Patient_cpr int(4), "+
                "Konsultation_beskrivelse varchar (300)," +
                "Konsultation_konklusion varchar(300)," +
                "Konsultation_dato varchar(10)" +
                "FOREIGN KEY(Patient_cpr)" +
                "REFERENCES patient(Patient_cpr)" +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";
        SQLExecute(sql_createKonsultationTable);
    }

    public void insertKonsultationToDB(String navn, int cpr, String beskrivelse, String konklusion, String dato) throws SQLException, ClassNotFoundException {
        String sql_insertKonsultation = "INSERT INTO konsultation" +
                "(Patient_navn, " +
                "Patient_cpr, " +
                "Konsultation_beskrivelse, " +
                "Konsultation_konklusion, " +
                "Konsultation_dato) " +
                "VALUES " +
                "('" + navn + "', '" + cpr + "', '" + beskrivelse + "', '" + konklusion +
                "', '" + dato +
                "')";
        SQLExecute(sql_insertKonsultation);
    }

    public List<Konsultation> FindPatientKonsultationData(int cpr) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        String FindKonsultationData = "SELECT * FROM konsultation WHERE (Patient_cpr = '" + cpr + "');";
        List<Konsultation> konsultationer = new ArrayList<>();

        ResultSet rs = stmt.executeQuery(FindKonsultationData);
        while(rs.next()){
            String navn = rs.getString("Patient_navn");
            int Cpr = rs.getInt("Patient_cpr");
            String beskrivelse = rs.getString("Konsultation_beskrivelse");
            String konklusion = rs.getString("Konsultation_konklusion");
            String dato = rs.getString("Konsultation_dato");

            konsultationer.add(new Konsultation(navn, Cpr, beskrivelse, konklusion, dato));
        }
        stmt.close();
        return konsultationer;
    }

    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }

}
