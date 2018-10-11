<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<style type="text/css">
    .fieldset-auto-width {
         display: inline-block;
    }
</style>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

.form-heading{
 text-align: center;
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

.userform {
      margin: 0 auto;
     width: 500px; 
     height: 400px;
}

.button1 {
    background-color: #008CBA; 
    border: 2px solid #4CAF50;
    width: 100px; 
    float: right;

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>

<body>

<div id="container" class="userform"> 

<h2 class="form-heading">REGISTER</h2>
<form method="POST" action="register" class="form-signin">


  <div class="container">
    
    <br/>
    <label for="firstname"><b>Firstname</b></label>
    <input type="text" maxlength="10" size="12" placeholder="Enter Firstname" name="firstname" required>
    
    <label for="lastname"><b>Lastname</b></label>
    <input type="text" maxlength="10" size="12" placeholder="Enter Lastname" name="lastname" required>
    
    <label for="uname"><b>Username</b></label>
    <input type="text" maxlength="10" size="12" placeholder="Enter Username" name="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" maxlength="10" size="12" placeholder="Enter Password" name="password" required>
        
        
    <button type="submit">Register</button>
    
      <div class="container" style="background-color:#f1f1f1">
    <span style="color:red">${message}</span>
     
  </div>

</div>  

</form>


  <div >
    <form action="home.jsp">
   <button class="button button1" >back</button>
   </form>
    
  </div>


</body>
</html>
