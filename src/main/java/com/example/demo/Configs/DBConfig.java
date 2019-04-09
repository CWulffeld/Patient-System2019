package com.example.demo.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DBConfig {

    public void connect() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection conn = DriverManager
            .getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/datamatiker18a", "datamatiker18a", "Ie5qK~3?U8Zy");

        System.out.println("virker");
    }
}
