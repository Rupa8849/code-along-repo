<%-- 
    Document   : students
    Created on : Jun 15, 2023, 10:56:42 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.ResultSet"%>
<script src="js/index.js"></script>


<c:if test="${process eq 'load'}">
    <ul class="nav nav-pills">
        <li class="active" onclick="return AddStudents()"><a href="#">Add Students</a></li>
        <li><a href="#" onclick="ViewStudent('editstudents')">Edit Students</a></li>
        <li><a href="#" onclick="ViewStudent('deletestudents')">Delete Students</a></li>
        <li onclick="ViewStudent('viewstudents')"><a href="#" >View Students</a></li>
    </ul><br><br>
    <div id="studentload" class="container-fluid p-5">

    </div>
</c:if>
    
<c:if test="${process eq 'delete'}">
        <%
            int result = (Integer) request.getAttribute("result");
//            out.print(result);
        %>
</c:if>
    
<c:if test="${process eq 'edit'}">
    <div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Update Students Details</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body mx-3">
                    <% ResultSet rs = (ResultSet) request.getAttribute("result");
                        while (rs.next()) {
                    %>

                    <div class="md-form mb-5">
                        <label data-error="wrong" data-success="right" for="orangeForm-id">Student ID :</label>
                        <input type="text" id="sid" name="sid" class="form-control validate" value="<%=rs.getInt("s_id")%>">
                    </div>

                    <div class="md-form mb-5">
                        <label data-error="wrong" data-success="right" for="orangeForm-name">Name :</label>
                        <input type="text" id="name" name="name" class="form-control validate" value="<%=rs.getString("name")%>">
                    </div>

                    <div class="md-form mb-5">
                        <label data-error="wrong" data-success="right" for="orangeForm-address">Address :</label>
                        <input type="text" id="address" name="address" class="form-control validate" value="<%=rs.getString("address")%>">
                    </div>

                    <div class="md-form mb-5">
                        <label data-error="wrong" data-success="right" for="orangeForm-email">Email :</label>
                        <input type="email" id="email" name="email" class="form-control validate" value="<%=rs.getString("email")%>">
                    </div>

                    <div class="md-form mb-5">
                        <label data-error="wrong" data-success="right" for="orangeForm-state">State :</label>
                        <input type="text" id="state" name="state" class="form-control validate" value="<%=rs.getString("state")%>">
                    </div>

                    <div class="md-form mb-5">
                        <label data-error="wrong" data-success="right" for="orangeForm-city">City :</label>
                        <input type="text" id="city" name="city" class="form-control validate" value="<%=rs.getString("city")%>">
                    </div>
                    <%
                        }
                    %>
                </div>
              
                <div class="text-center">
                    <button class="btn btn-success" onclick="return validateEditForm()">Update Students</button>
                    <button type="reset" class="btn btn-warning">RESET</button>
                </div>
            </div>
        </div>
    </div>
                    <div id="updateData" type="text"></div>
</c:if>


    
