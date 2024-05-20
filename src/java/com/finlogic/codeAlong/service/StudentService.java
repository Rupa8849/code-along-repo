/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.codeAlong.service;

import com.finlogic.codeAlong.repository.StudentRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class StudentService {
    
    StudentRepository studentrepository = new StudentRepository();
    
    public ResultSet getAllStudents() throws SQLException, ClassNotFoundException{
        return studentrepository.getAllStudents();
    }
    
    
    public int insertStudents(String name, String address, String email, String state, String city) throws SQLException, ClassNotFoundException{
        return studentrepository.insertStudents(name, address, email, state, city);
    }

    public int deleteStudents(int s_id) throws ClassNotFoundException, SQLException{
        return studentrepository.deleteStudents(s_id);
    }
    
//    public static void main(String []args){
//        StudentService sr = new StudentService();
//        try{
//            int id = 3;
//            int status = sr.deleteStudents(id);
//            if(status > 0 ){
//                System.out.println(status);
//            }
//            else{
//                System.out.println("Error");
//            }
//        }
//        catch(ClassNotFoundException | SQLException e){
//            System.out.println("error : "+e.getMessage());
//        }
//    }
    
    public ResultSet editStudents(int s_id) throws ClassNotFoundException, SQLException{
        return studentrepository.editStudents(s_id);
    }
    
    public int updateStudents(String name, String address, String email, String state, String city,int id) throws ClassNotFoundException, SQLException{
        return studentrepository.updateStudents(name, address, email, state, city, id);
    }
    
    }


