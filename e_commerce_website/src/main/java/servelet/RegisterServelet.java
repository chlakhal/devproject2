package servelet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

import dao.UtilisateurDao;
import e_commerce_website.Dbconnection;
import e_commerce_website.Utilisateur;

/**
 * Servlet implementation class RegisterServelet
 */
public class RegisterServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		
			
			
			try (PrintWriter out = response.getWriter()) {
				
				String nom = request.getParameter("nom");
				String email= request.getParameter("email");
				String password = request.getParameter("password");
				
				

				UtilisateurDao udao = new UtilisateurDao(Dbconnection.getConnection());
				Utilisateur utilisateur = udao. utilisateurRegister( nom, email,password);
	             response.sendRedirect("login.jsp");
				
				
				
			} catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
				System.out.println("erreue");
				
			} 

		

		}}

		

		

	

	


