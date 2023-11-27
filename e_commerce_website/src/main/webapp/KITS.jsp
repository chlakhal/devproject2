<%@page import="dao.ProduitDao" %>
<%@page import="e_commerce_website.Dbconnection" %>
<%@page import="e_commerce_website.Produit" %>
<%@page import="java.util.List" %>
<%@page import="java.util.*" %>
<%@page import="e_commerce_website.Utilisateur" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <% Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");
  if (auth != null) {
	    request.setAttribute("person", auth);
	}
        ProduitDao pd = new ProduitDao(Dbconnection.getConnection());
        List<Produit> produits = pd.getAll("Kits"); 
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Kits</title>
    <%@ include file="contient/head.jsp" %>
    <style >
  .card w-100 {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  gap: 16px;
  max-width: 1400px;
  margin: 0 auto;
  padding: 20px 10px;
}

.card-img-top {
  width: 100%;
  max-width: 500px;
  height: 300px;
  object-fit: cover;
  border-radius: 10px;
}
.center{text-align:center;
}
  </style>
  
</head>
<body>
    <%@ include file="contient/bootstap_nabvar.jsp" %>
    <div class="container"><div class="row">
    <div class="col-md-12">
    <h4 class="center">Kits</h4>
    </div>
    <div class="container">
       
        <div class="row">
            <%
            if (!produits.isEmpty()) {
                for (Produit p : produits) {
            %>
            <div class="col-md-4 my-4">
                <div class="card w-100">
                    <img class="card-img-top" src="produits_images/<%=p.getImage() %>" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><%=p.getNom() %></h5>
                        <h6 class="price">Price:<%=p.getPrix() %>dh</h6>
                        <h6 class="category">Category: <%=p.getCatégorie() %></h6>
                        <div class="mt-3 d-flex justify-content-between">
                            <a class="btn btn-dark" href="Ajouter?id=<%=p.getId()%>">Add to Cart</a>
                            <form action="CommandeServelet" method="get" class="form-inline">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="id" value="<%=p.getId()%>">
                    <button type="submit" class="btn btn-primary ">Buy Now</button>
                   </form>
                        </div>
                    </div>
                </div>
            </div>
            <%
                }
            } else {
                out.println("There are no products in this category");
            }
            %>
        </div>
    </div>
    <%@ include file="contient/footer.jsp" %>
</body>
</html>
