package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dao.CommandeDao;
import e_commerce_website.Commande;
import e_commerce_website.Dbconnection;
import e_commerce_website.Panier;
import e_commerce_website.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class CommandeServelet
 */
public class CommandeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(0, 0, 0) ;
			Utilisateur auth=(Utilisateur)request.getSession().getAttribute("auth");
			if(auth !=null) {
				String produitId=request.getParameter("id");
				int produitQuantité= Integer.parseInt(request.getParameter("quantity"));
				if(produitQuantité<0) {
					produitQuantité=1;
				}
				Commande commande = new Commande();
				commande.setId(Integer.parseInt(produitId));
				commande.setUid(auth.getId());
				commande.setQuantité(produitQuantité);
				commande.setDate(formatter.format(date));
				
				
				CommandeDao cDao = new CommandeDao(Dbconnection.getConnection());
				cDao.insertCommande(commande);
				boolean result = cDao.insertCommande(commande);
				if(result) {
					response.sendRedirect("commandes.jsp");
					
			}
				else {
					out.println("commande échouée");
				}
			
				
				
				
			}else {
				response.sendRedirect("login.jsp");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
       
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
