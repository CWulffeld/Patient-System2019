package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ReceptRepositorySQL {
    public void createReceptTable() throws ClassNotFoundException, SQLException {
        String sql_createReceptTable = "CREATE TABLE IF NOT EXISTS " +DBConfig.getUser() + ".recept" +
                "(Patient_navn varchar(100) NOT NULL," +
                "Patient_cpr int(4) NOT NULL," +
                "Recept_note varchar(200),"+
                "Medicin_navn varchar(100) NOT NULL," +
                "Recept_udstedt varchar(10) NOT NULL," +
                "FOREIGN KEY(Patient_cpr)" +
                "REFERENCES patient(Patient_cpr)" +
                "ON UPDATE CASCADE ON DELETE CASCADE" +
                ")";

        SQLExecute(sql_createReceptTable);

    }

    public void insertRecepttoDB(String navn, int cpr, String note, String medicin, String udstedt) throws SQLException, ClassNotFoundException {
        String sql_insertRecept = "INSERT INTO Recept" +
                "(Patient_navn, " +
                "Patient_cpr, " +
                "Recept_note, "+
                "Medicin_navn, " +
                "Recept_udstedt) " +
                "VALUES " +
                "('" + navn + "', '" + cpr + "', '" + note +
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
