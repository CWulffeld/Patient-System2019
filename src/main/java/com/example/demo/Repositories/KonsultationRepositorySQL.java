package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class KonsultationRepositorySQL {
    public void createKonsultationTable() throws ClassNotFoundException, SQLException {
        String sql_createKonsultationTable = "CREATE TABLE IF NOT EXISTS konsultation" +
                "(Konsultation_ID int, "+
                "Konsultation_beskrivelse varchar (300)," +
                "Konsultation_konklusion varchar(300)," +
                "Konsultation_dato varchar(15)" +
                ")";

        SQLExecute(sql_createKonsultationTable);
    }

    public void insertKonsultationToDB(String beskrivelse, String konklusion, String dato) throws SQLException, ClassNotFoundException {
        String sql_insertKonsultation = "INSERT INTO konsultation" +
                "(Konsultation_beskrivelse, " +
                "Konsultation_konklusion, " +
                "Konsultation_dato) " +
                "VALUES " +
                "('" + beskrivelse + "', '" + konklusion +
                "', '" + dato +
                "')";
        SQLExecute(sql_insertKonsultation);


    }

    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }

}
