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
    request.setAttribute("person", auth);
}
ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");
List<Panier> panierProduit = null;
if (panier_list != null) {
	ProduitDao pDao = new ProduitDao(Dbconnection.getConnection());
	panierProduit = pDao.getPanierProduits(panier_list);
	double total = pDao.getTotalPrixPanier(panier_list);
	request.setAttribute("total", total);
	
	
	request.setAttribute("panier_list", panier_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
<%@ include file="contient/head.jsp" %>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
<%@ include file="contient/bootstap_nabvar.jsp" %>
<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price : ${total}dh </h3> <a class="mx-3 btn btn-primary" href="Checkout">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (panier_list != null) {
					for (Panier c : panierProduit) {
				%>
				<tr>
					<td><%=c.getNom()%></td>
					<td><%=c.getCatégorie()%></td>
					<td><%=c.getPrix()%></td>
					
					<td>
						<form action="CommandeServelet" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantity-incr-decr?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantité()%>" readonly> 
								<a class="btn bnt-sm btn-incre" href="quantity-incr-decr?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a> 
							</div>
							<a href="CommandeServelet?quantity=1&id=<%=c.getId()%>" class="btn btn-primary btn-sm" >Buy</button>
						</form>
					</td>
					<td><a href="Supprimer?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>


<%@ include file="contient/footer.jsp" %>

</body>
</html>