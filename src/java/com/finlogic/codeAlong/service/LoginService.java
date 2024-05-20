/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.finlogic.codeAlong.service;

import com.finlogic.codeAlong.repository.LoginRepository;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class LoginService {
    
    LoginRepository loginrepository = new LoginRepository();
    
    public int verifyLoginDetails(String username, String pass) throws SQLException, ClassNotFoundException {
        
        return loginrepository.checkLoginDetails(username, pass);
        
    }
    
    public int registerStudent(String username, String pass) throws SQLException, ClassNotFoundException {
        return loginrepository.registerStudent(username, pass);
    }
    
    
}
