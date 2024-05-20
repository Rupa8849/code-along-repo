<%-- 
    Document   : studentajax
    Created on : Jun 20, 2023, 8:22:53 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" 
        integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" 
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="js/index.js"></script>
</head>


<c:if test="${process eq 'viewstudents' || process eq 'editstudents' || process eq 'deletestudents'}">
    <table class="table table-bordered justify-content-center" id="tbl">
        <thead>
            <tr class="info">
                <th class = "text-center">Student Id</th>
                <th class = "text-center">Name</th>
                <th class = "text-center">Address</th>
                <th class = "text-center">Email</th>
                <th class = "text-center">State</th>
                <th class = "text-center">City</th>
                    <c:if test="${process eq 'editstudents'}">
                    <th class = "text-center">Edit</th>
                    </c:if>
                    <c:if test="${process eq 'deletestudents'}">
                    <th class = "text-center">Delete</th>
                    </c:if>
            </tr>
        </thead>
        <tbody>
            <% ResultSet rs = (ResultSet) request.getAttribute("result");
                while (rs.next()) {
            %>
            <tr>
                <td class = "text-center"><%=rs.getInt("s_id")%></td>
                <td class = "text-center"><%=rs.getString("name")%></td>
                <td class = "text-center"><%=rs.getString("address")%></td>
                <td class = "text-center"><%=rs.getString("email")%></td>
                <td class = "text-center"><%=rs.getString("state")%></td>
                <td class = "text-center"><%=rs.getString("city")%></td>

                <c:if test="${process eq 'editstudents'}">
                    <td class = "text-center"> <button data-toggle="modal" data-target="#modalRegisterForm" onclick="EditStudents(<%=rs.getInt("s_id")%>)"><i class="fa fa-edit" style="color: #1ae817"></i></button></td>
                </c:if>
                <c:if test="${process eq 'deletestudents'}">
                <td class = "text-center" onclick="DeleteStudents(<%=rs.getInt("s_id")%>)"><i class="fa fa-trash" style="color: #ff052b;"></i></td>
                </c:if>
            </tr>
            <%
                }
            %>
        </tbody>

    </table>
     
</c:if>

<c:if test="${process eq 'addstudents'}">
    
    <div class="mx-auto" style="width:50%">
        <h2>Add Student Form</h2>
        <form id="studentform" method="POST">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" name="address">
            </div>
            <div class="form-group">
                <label for="email">Email address:</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" class="form-control" id="state" name="state">
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="city">
            </div>
            <div class="text-center">
                <button class="btn btn-primary" onclick="return ValidateStudentForm()">Add Students</button>
                <button type="reset" class="btn btn-warning">RESET</button>
          </div>
        </form>
    </div>
    <div id="processAjax">
        
    </div>
    
</c:if>
        
