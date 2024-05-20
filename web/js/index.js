/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function validateForm() {
    // validate
    var result = validate_empty('username', 'Username') &&
            validate_empty('password', 'Password');

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    if (result) {
        //ajax call
        ajaxCall('POST', 'HomeServlet.fin', 'username='+username+'&password='+password, 'ajax');
    
//         read hidden value
        var status = document.getElementById('ajax').value;
        
        if (status > 0) {
            window.location.href="dashboard.jsp";
        } else {
            alert("Username or Password is invalid!");
        }
    }
    
    return false;
    // ajax call
}

// validation functions
function validate_empty(elementId, elementLabel) {
    var value = document.getElementById(elementId).value;

    if (value === '') {
        alert(elementLabel + " is required and cannot be empty!");
        document.getElementById(elementId).focus();
        return false;
    }
    return true;
}


function ajaxCall(method, url, data, destination,isHtml) {
    var xhttp = new XMLHttpRequest();
    // event
    xhttp.onload = function () {
        if(isHtml){
            document.getElementById(destination).innerHTML = this.responseText;
        }
        else{
            document.getElementById(destination).value = this.responseText;
        }
    };
    xhttp.open(method, url, false);
    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
    xhttp.send(data);
}

function logoutUser() {
    var res = confirm('Are you sure, you want to logout?');
    
    if (res) {
        window.location.href="index.jsp";
    }
}

function validateRegisterForm() {
    // validate
    var result = validate_empty('username', 'Username') &&
            validate_empty('password', 'Password') &&
            validate_empty('cpassword', 'ConfirmPassword');

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var cpassword = document.getElementById('cpassword').value;

    if (result) {
        //ajax call
        if (cpassword === password){
            ajaxCall('POST', 'RegistrationServlet.fin', 'username='+username+'&password='+password+'&cpassword='+cpassword, 'ajax');
            alert("Registeration successfull !");
//            window.location.href="index.jsp";

        }
        else {
            alert("Please enter a valid password !");
        }
        return false;
        
//         read hidden value
//        var status = document.getElementById('ajax').value;
//        if (status > 0) {
//            alert("Registeration successfull !");
//            window.location.href="index.jsp";
//        } else {
//            alert("Username or Password is invalid!");
//        
//        }
    }
    
    return false;
}

function StudentsLoader(){
    ajaxCall('POST', 'student.fin', 'process=load', 'ajax','html');
   
}

function ViewStudent(param){
//    alert("function called");
//    alert("ajax called");
    ajaxCall('POST', 'processStudent.fin', 'process='+param, 'studentload','html');
//    alert("ajax ends");
}

function AddStudents(){
    ajaxCall('POST', 'processStudent.fin', 'process=addstudents', 'studentload','html');

}

function ValidateStudentForm(){
    var result = validate_empty('name', 'Name')
            && validate_empty('address', 'Address')
            && validate_empty('email', 'Email Address')
            && validate_empty('state', 'State')
            && validate_empty('city', 'City');
         
    var name = document.getElementById('name').value;
    var address = document.getElementById('address').value;
    var email = document.getElementById('email').value;
    var  state = document.getElementById('state').value;
    var city = document.getElementById('city').value;
    
    if(result){
        var data = 'name=' + name + '&address=' + address + '&email=' + email + 
                '&state=' + state + '&city=' + city + '&process=insertstudents';
        ajaxCall('POST', 'processStudent.fin', data, 'processAjax','html');

        var status = document.getElementById('status').value;
//        var form = document.getElementById('studentform');

        if(status > 0){
            alert("Student inserted successfully !");
            ResetForm(document.getElementById('studentform'));
        }
        else{
            alert("Problem in insertion !!");
        }
    }
            return false;

}

function ResetForm(formObj){
    formObj.reset();
}

function DeleteStudents(id){
    var cnfrm = confirm("are you sure ?");
    alert("id"+id);
    if(cnfrm){
        ajaxCall('POST','processStudent.fin','process=delete&id='+id,'deleteinput','html');
        alert("student deleted successfully!");
        ViewStudent('viewstudents');

    }
    else{
        alert("error");
    }
}

function EditStudents(id){
//    alert(id);
    ajaxCall('POST', 'processStudent.fin', 'process=edit&id='+id, 'studentload','html');
}

function validateEditForm(){
     var result = validate_empty('name', 'Name')
            && validate_empty('address', 'Address')
            && validate_empty('email', 'Email Address')
            && validate_empty('state', 'State')
            && validate_empty('city', 'City');
    alert(result);
    var name = document.getElementById('name').value;
    var address = document.getElementById('address').value;
    var email = document.getElementById('email').value;
    var state = document.getElementById('state').value;
    var city = document.getElementById('city').value;
    var id = document.getElementById('sid').value;
    alert(id);
    if(result){
        var data = 'name=' + name + '&address=' + address + '&email=' + email + 
                '&state=' + state + '&city=' + city + '&sid=' + id +'&process=updatestudents';
        alert("ajax call start");
        
        ajaxCall('POST', 'processStudent.fin', data, 'updateData','html');
//        alert(data);

        alert("ajax call ends");
        
        var status = document.getElementById('update').value;
        alert(status);
        
        if(status > 0){
            alert("student record updated successfully!");
            ViewStudent('viewstudents');
        }
        else{
            alert("problem in updation");
        }
    }
    return false;
}