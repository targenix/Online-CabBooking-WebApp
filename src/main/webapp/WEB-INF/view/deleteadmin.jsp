<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Add Admin</title> 
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

    <form:form action="fetchdeleteadmin" modelAttribute="admin" method="post"> 
      <!-- <div class="form-group">
      <label for="adminId">User Name</label>
      <form:input path="adminId" 
        class="form-control" name="" id="adminId"/>
    </div>  -->
    <div class="form-group">
      <label for="adminId">Admin Id</label>
      <form:input path="adminId" 
        class="form-control" name="" id="adminId"/>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Fetch Admin Record</button>
    </div>
</form:form>
</div>
</body>  
</html>  