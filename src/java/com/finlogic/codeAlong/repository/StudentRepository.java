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
public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/jdbc_db";
    String user = "root";
    String password = "ruPa2000@";
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    
    public ResultSet getAllStudents() throws ClassNotFoundException, SQLException{
        Class.forName(dbDriver);
        
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("select s_id, name, address, email, state, city from studentexample;");
        
        ResultSet rs = stmt.executeQuery();
        return rs;
    }
    
    public int insertStudents(String name, String address, String email, String state, String city) throws SQLException, ClassNotFoundException{
        Class.forName(dbDriver);
        
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("insert into studentexample (name, address, email, state, city) values (?,?,?,?,?);");
        
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, state);
        stmt.setString(5, city);

        return stmt.executeUpdate();
    }
    
    public int deleteStudents(int s_id) throws ClassNotFoundException, SQLException{
        Class.forName(dbDriver);
        
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("delete from studentexample where s_id=?;");
        
        stmt.setInt(1, s_id);
        return stmt.executeUpdate();
    }
    
    public ResultSet editStudents(int s_id) throws ClassNotFoundException, SQLException{
        Class.forName(dbDriver);
        
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("select s_id, name, address, email, state, city from studentexample where s_id=?;");
        
        stmt.setInt(1, s_id);
        ResultSet rs = stmt.executeQuery();
        return rs;
        
    }
    
    public int updateStudents(String name, String address, String email, String state, String city,int id) throws ClassNotFoundException, SQLException{
        Class.forName(dbDriver);
        
        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = con.prepareStatement("update studentexample set name=?,address=?, email=?, state=?, city=? where s_id=?;");
        
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, state);
        stmt.setString(5, city);
        stmt.setInt(6, id);
        return stmt.executeUpdate();

    }
    
    public static void main(String []args) throws ClassNotFoundException, SQLException{
//        
        StudentRepository sr = new StudentRepository();
        try{
//            int s_id = 3;
            int rs = sr.updateStudents("kanak", "sachin", "rupali@gmail.com", "bihar", "goahati",6);
            
            System.out.println(rs);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

//    public static void main(String []args) throws ClassNotFoundException, SQLException{
//        
//        StudentRepository sr = new StudentRepository();
//        try{
//            int s_id = 7;
//            ResultSet rs = sr.showStudents(s_id);
//            while(rs.next()){
//                System.out.println("id : "+rs.getInt("s_id"));
//                System.out.println("id : "+rs.getString("name"));
//                System.out.println("id : "+rs.getString("address"));
//                System.out.println("id : "+rs.getString("email"));
//                System.out.println("id : "+rs.getString("state"));
//                System.out.println("id : "+rs.getString("city"));
//            }
//                
//
//        }
//        
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
    
    

