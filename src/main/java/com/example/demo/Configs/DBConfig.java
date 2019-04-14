package com.example.demo.Configs;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfig {

    static String connectString = "jdbc:mysql://den1.mysql3.gear.host:3306/pshdb";
    static String user = "pshdb";
    static String password = "Ar59BgBAR~-e";

    public static String getUser(){
        return user;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("2");
    Class.forName("com.mysql.cj.jdbc.Driver");


        System.out.println("3");
    Connection connect = DriverManager
            .getConnection(connectString, user, password);
            //getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/datamatiker18a", "datamatiker18a", "Ie5qK~3?U8Zy");


        System.out.println("4");
        return connect;
    }



}
