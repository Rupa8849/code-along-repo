/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.codeAlong.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class LoginRepository {
    
    String url = "jdbc:mysql://localhost:3306/jdbc_db";
    String user = "root";
    String password = "ruPa2000@";
    String dbDriver = "com.mysql.jdbc.Driver";
    
    public int checkLoginDetails(String username , String pass) throws SQLException, ClassNotFoundException {
        Class.forName(dbDriver);

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("select count(username) from loginexample where username=? and password=?;");
        
        stmt.setString(1, username);
        stmt.setString(2, pass);

        int status = 0;
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            status = rs.getInt(1);
        }
        return status;
    }
    
    //insert into registration form
    public int registerStudent(String username, String pass) throws SQLException, ClassNotFoundException {
                Class.forName(dbDriver);

        Connection con = DriverManager.getConnection(url, user, password);
        // insert statement
        PreparedStatement stmt = con.prepareStatement(
                "insert into loginexample (username, password) values (?, ?);");
        stmt.setString(1, username);
        stmt.setString(2, pass);
//        stmt.setString(3, cpass);
        
        return stmt.executeUpdate();
    }
    
}
