<%@ page import="e_commerce_website.Dbconnection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="e_commerce_website.Utilisateur" %>
    <%@page import="java.util.*" %>
   <%  Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
    String selectedLanguage = (String) session.getAttribute("selectedLanguage");
    ResourceBundle messages = ResourceBundle.getBundle("messages_" + selectedLanguage);
}
%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>ElectroUniverse</title>
  <style>
  body {
  margin: 0;
  padding: 0;
  font-family: 'Arial', sans-serif; /* Changer la police si désiré */
}

.image-with-text {
  position: relative;
  text-align: center;
}

.image-with-text img {
  width: 100%;
  height: auto;
  display: block;
}

.text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  text-align: center;
}

.text h1 {
  font-size: 50px;
  margin-bottom: 10px;}

.text p {
  font-size: 25px;
  margin-bottom: 10px;
}
</style>
  
  
  
</head>


<%@ include file="contient/head.jsp" %>

<body>
<%@ include file="contient/bootstap_nabvar.jsp" %>
<div class="image-with-text">
    <div class="text">
      <h1> Welcome to ElectroUnivers</h1>
      <p>where the current is the oxygen</p>
    </div>
    <img src="contient/design/page.jpg" alt="Image avec texte">
  </div>
  
</body>
</html>
<%@ include file="contient/footer.jsp" %>
</body>
</html>