/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.finlogic.codeAlong.controller;

import com.finlogic.codeAlong.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class ProcessStudentServlet extends HttpServlet {
    StudentService studentservice = new StudentService();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String process = request.getParameter("process");
            
            if (process.equals("viewstudents") 
                || process.equals("editstudents") 
                || process.equals("deletestudents")){
//                out.print("1");
                ResultSet rs = studentservice.getAllStudents();
                
                request.setAttribute("result",rs);
                request.setAttribute("process",process);
                
                RequestDispatcher view = request.
                        getRequestDispatcher("studentajax.jsp");
                view.forward(request, response);

            }
            else if(process.equals("addstudents")){
                request.setAttribute("process",process);
                
                RequestDispatcher view = request.
                        getRequestDispatcher("studentajax.jsp");
                view.forward(request, response);
            }
            else if(process.equals("insertstudents")){
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String state = request.getParameter("state");
                String city = request.getParameter("city");

                
                int result = studentservice.insertStudents(name, address, email, state, city);
                request.setAttribute("process",process);
                request.setAttribute("status",result);

                RequestDispatcher view = request.
                        getRequestDispatcher("mastertask.jsp");
                view.forward(request, response);
            }
            else if(process.equals("delete")){
                int s_id = Integer.parseInt(request.getParameter("id"));
                int result = studentservice.deleteStudents(s_id);
                
                request.setAttribute("result",result);
                request.setAttribute("process",process);
                
                RequestDispatcher view = request.
                        getRequestDispatcher("students.jsp");
                view.forward(request, response);
            }
            
            else if(process.equals("edit")){
                int s_id = Integer.parseInt(request.getParameter("id"));
                ResultSet result = studentservice.editStudents(s_id);
                
                request.setAttribute("process",process);
                request.setAttribute("result",result);
                
                RequestDispatcher view = request.
                        getRequestDispatcher("students.jsp");
                view.forward(request, response);
            }
            
            else if(process.equals("updatestudents")){
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String state = request.getParameter("state");
                String city = request.getParameter("city");
                int s_id = Integer.parseInt(request.getParameter("sid"));
                
                int update = studentservice.updateStudents(name, address, email, state, city, s_id);
          
                request.setAttribute("process",process);
                request.setAttribute("result",update);

                RequestDispatcher view = request.
                        getRequestDispatcher("mastertask.jsp");
                view.forward(request, response);
            }
            

        }catch(Exception ex){
            System.out.println("An exception is occured "+ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
