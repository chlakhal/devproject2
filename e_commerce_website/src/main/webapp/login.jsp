<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.ProduitDao" %>
<%@page import="e_commerce_website.Dbconnection" %>
<%@page import="e_commerce_website.Produit" %>
<%@page import="e_commerce_website.Panier" %>
<%@page import="e_commerce_website.Utilisateur" %>


<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
    
    <% 
	Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
	ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");
	if (panier_list != null) {
		request.setAttribute("panier_list", panier_list);
	}
	%> 
<!DOCTYPE html>
<html>
<head>

<title>ElectroUniverse.Login</title>
<%@ include file="contient/head.jsp" %>
<Style>
.center{text-align:center;
}
</Style>

</head>
<body>
<%@ include file="contient/bootstap_nabvar.jsp" %>
<div class="container">
  <form action="LoginServelet" method="post">
 
 
 <div class="row">
    <div class="col-md-12">
    <h4 class="center">Please Login</h4>
    </div>
 </div>
 
 </div>
 
 
 
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <form>
        <div class="form-group">
          <label for="email">Email </label>
          <input type="email" name="email" class="form-control">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" name="password" class="form-control">
        </div>
        <div class="form-group text-center">
          <button type="submit" class="btn btn-primary">Login</button>
        </div>
      </form>
    </div>
  </div>
</div>
 
  
   
 
 




</form>
<%@ include file="contient/footer.jsp" %>
</body>
</html>

