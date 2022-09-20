package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String args[]){
        String jdbsUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            Connection myCon = DriverManager.getConnection(jdbsUrl, user, pass);
            System.out.println("Connection successful");

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
