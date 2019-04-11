package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;

import java.sql.SQLException;
import java.sql.Statement;

public class KonsultationRepositorySQL {
    public void createKonsultationTable() throws ClassNotFoundException, SQLException {
        String sql_createKonultationTable = "CREATE TABLE IF NOT EXISTS konsultation" +
                "(Patient_forNavn varchar (100) NOT NULL," +
                "Patient_efterNavn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL," +
                "Konsultation_beskrivelse varchar(500), " +
                "Konsultation_konklusion varchar(100)," +
                "Konsultation_dato DATE NOT NULL,"+
                "PRIMARY KEY()" +
                ")";
        SQLExecute(sql_createKonultationTable);
    }

    public void insertKonulstationtoDB(String fornavn, String efternavn, int cpr, String beskrivelse, String konklusion, String dato) throws SQLException, ClassNotFoundException {
        String sql_insertKonsultation = "INSERT INTO konsultation" +
                "(Patient_fornavn, " +
                "Patient_efterNavn, " +
                "Patient_cpr, " +
                "Konsultation_beskrivelse, "+
                "Konsultation_konklusion, " +
                "Konsultation_dato, " +
                "VALUES " +
                "('" + fornavn + "', '" + efternavn +
                "', '" + cpr + "', '" + beskrivelse +
                "', '" + konklusion+ "', '" + dato +
                "')";
        SQLExecute(sql_insertKonsultation);
    }

    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }

}
