package org.example.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    // Java Database Connectivity = JDBC API Specification

    public static void main(String[] args) throws Exception {
        updateUser();
        getAllUser();
    }

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "12345";

        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    public static void getAllUser() throws SQLException, ClassNotFoundException {
        Connection c = connect();
        Statement stmt = c.createStatement();
        stmt.execute("SELECT * FROM user");
        ResultSet rs = stmt.getResultSet();
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");

            System.out.println("id="+id);
            System.out.println("name="+name);
            System.out.println("surname="+surname);
            System.out.println("phone="+phone);
            System.out.println("email="+email);

            System.out.println("----------");
        }
    }

    public static void updateUser() throws ClassNotFoundException, SQLException {
        Connection c = connect();
        Statement stmt = c.createStatement();
        stmt.execute("update user set name='AZAY', surname='JALIL' where id = 1");
        ResultSet rs = stmt.getResultSet();

    }
}

/*
    Connection




*/