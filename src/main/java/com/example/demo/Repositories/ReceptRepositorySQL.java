package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;

import java.sql.SQLException;
import java.sql.Statement;

public class ReceptRepositorySQL {
    public void createReceptTable() throws ClassNotFoundException, SQLException {
        String sql_createReceptTable = "CREATE TABLE IF NOT EXISTS recept" +
                "(Patient_forNavn varchar(100) NOT NULL," +
                "Patient_efterNavn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL," +
                "Recept_note varchar(200),"+
                "Medicin_navn varchar(100) NOT NULL," +
                "Recept_udstedt DATE NOT NULL," +
                "PRIMARY KEY(Patient_cpr)" +
                ")";

        SQLExecute(sql_createReceptTable);

    }

    public void insertRecepttoDB(String fornavn, String efternavn, int cpr, String note, String medicin, String udstedt) throws SQLException, ClassNotFoundException {
        String sql_insertRecept = "INSERT INTO Recept" +
                "(Patient_fornavn, " +
                "Patient_efterNavn, " +
                "Patient_cpr, " +
                "Recept_note, "+
                "Medicin_navn, " +
                "Recept_udstedt, " +
                "VALUES " +
                "('" + fornavn + "', '" + efternavn +
                "', '" + cpr + "', '" + note +
                "', '" + medicin+ "', '" + udstedt +
                "')";
        SQLExecute(sql_insertRecept);
    }

    private void SQLExecute(String SQL) throws ClassNotFoundException, SQLException{
        Statement stmt = DBConfig.getConnection().createStatement();
        stmt.execute(SQL);
        stmt.close();
    }


}
