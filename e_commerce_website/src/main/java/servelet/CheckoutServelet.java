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
 * Servlet implementation class CheckoutServelet
 */
public class CheckoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServelet() {
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
			Date date = new Date(0, 0, 0)  ;
			ArrayList<Panier> panier_list = (ArrayList<Panier>) request.getSession().getAttribute("panier-list");
			Utilisateur auth = (Utilisateur) request.getSession().getAttribute("auth");
			if(panier_list != null && auth!=null) {
				for(Panier c:panier_list) {
					Commande commande = new Commande();
					commande.setId(c.getId());
					commande.setUid(auth.getId());
					commande.setQuantité(c.getQuantité());
					commande.setDate(formatter.format(date));
					
					CommandeDao cDao = new CommandeDao(Dbconnection.getConnection());
					boolean result = cDao.insertCommande(commande);
					if(!result) break;
				}
				panier_list.clear();
				response.sendRedirect("commandes.jsp");
			}else {
				if(auth==null) {
					response.sendRedirect("login.jsp");
				}
				
			}
		} catch (ClassNotFoundException|SQLException e) {
			
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
