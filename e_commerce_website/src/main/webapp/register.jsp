<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Electronics World .Login</title>
<%@ include file="contient/head.jsp" %>
<Style>
.center{text-align:center;
}
</Style>


</head>
<body>
<%@ include file="contient/bootstap_nabvar.jsp" %>
<div class="container">
  <form action="RegisterServelet" method="post">
 
 
 <div class="row">
    <div class="col-md-12">
    <h4 class="center">Please register</h4>
    </div>
 </div>
 
 </div>
 
 
 
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <form>
       <div class="form-group">
          <label for="name">Name </label>
          <input type="text" class="form-control" name="nom">
        </div>
        <div class="form-group">
          <label for="email">Email </label>
          <input type="email" class="form-control" name="email">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" name="password">
        </div>
        <div class="form-group text-center">
          <button type="submit" class="btn btn-primary">Register</button>
        </div>
      </form>
    </div>
  </div>
</div>
 
  
   
 
 




</form>
<%@ include file="contient/footer.jsp" %>

</body>
</html>

