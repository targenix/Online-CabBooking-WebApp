<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Add Customer</title> 
 <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

 <!-- jQuery library -->
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
 
 <!-- Popper JS -->
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 
 <!-- Latest compiled JavaScript -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>  
</head>  
<body>  
  <div class="container" style="width: 500px; background-color:cadetblue; margin: 5px; padding: 5px">

    <form:form action="addcustomer" modelAttribute="customer" method="post"> 
    <div class="form-group">
      <label for="userName">User Name</label>
      <form:input path="userName" 
        class="form-control" name="" id="userName"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:input path="password" 
          class="form-control" name="" id="password"/>
      </div>
      <div class="form-group">
        <label for="mobileNumber">Mobile</label>
        <form:input path="mobileNumber" 
          class="form-control" name="" id="mobileNumber"/>
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <form:input path="email" 
          class="form-control" name="" id="email"/>
      </div>
      <div class="form-group">
        <button type="submit" class="btn btn-primary">Save</button>
      </div>
</form:form>
</div>
</body>  
</html> 