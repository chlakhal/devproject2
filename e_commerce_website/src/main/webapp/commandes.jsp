<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="dao.ProduitDao" %>
<%@page import="e_commerce_website.Dbconnection" %>
<%@page import="e_commerce_website.Produit" %>
<%@page import="e_commerce_website.Panier" %>
<%@page import="e_commerce_website.Utilisateur" %>
<%@page import="e_commerce_website.Commande" %>
<%@page import="dao.CommandeDao" %>

<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%


Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");
List<Commande> commandes = null;
if (auth != null) {
    request.setAttribute("person", auth);
    CommandeDao commandeDao  = new CommandeDao(Dbconnection.getConnection());
    commandes = commandeDao.utilisateursCommandes(auth.getId());
}else{
	response.sendRedirect("login.jsp");
}
ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");
if (panier_list != null) {
	request.setAttribute("panier_list", panier_list);
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<Style>
.center{text-align:center;
}
</Style>

<title>Insert title here</title>

<%@ include file="contient/head.jsp" %>

</head>
<body>
<%@ include file="contient/bootstap_nabvar.jsp" %>
<<div class="container"><div class="row">
    <div class="col-md-12">
    <h4 class="center">All Orders</h4>
    </div>
 </div>
 
 </div>
 
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>

			<%
			if(commandes != null){
				for(Commande co:commandes){%>
					<tr>
						<td><%=co.getDate() %></td>
						<td><%=co.getNom() %></td>
						<td><%=co.getCatégorie() %></td>
						<td><%=co.getQuantité() %></td>
						<td><%=co.getPrix()%></td>
						<td><a class="btn btn-sm btn-danger" href="Annuler?id=<%=co.getCo_id()%>">Annuler</a></td>
					</tr>
				<%}
			}
			%>

			</tbody>
		</table>
	</div>

<%@ include file="contient/footer.jsp" %>

</body>
</html>