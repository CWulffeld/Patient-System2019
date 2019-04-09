package com.example.demo.Repositories;

import com.example.demo.Configs.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PatientRepositorySQL {



    @Autowired
    DBConfig DB;

    public void createPatientTable() throws ClassNotFoundException, SQLException {

        //Statement stmt = DB.connect();

        //Statement stmtt = DB.connect().createStatement;


//                con().createStatement();
//
//        String sql_createTable = "CREATE TABLE products " +
//                "(Pid int," +
//                "Product_name varchar(100)," +
//                "Product_price int," +
//                "Product_location varchar(10)" +
//                ")";
//
//        stmt.execute(sql_createTable);
//        stmt.close();

    }
}