package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


import dao.UtilisateurDao;
import e_commerce_website.Dbconnection;
import e_commerce_website.Utilisateur;

public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet  () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			

			UtilisateurDao udao = new UtilisateurDao(Dbconnection.getConnection());
			Utilisateur utilisateur = udao. utilisateurLogin(email, password);
			if (utilisateur != null) {
				request.getSession().setAttribute("auth",utilisateur);
				
			    //out.println("utilisateur inscrit");
				request.getSession().setAttribute("auth", utilisateur);
				response.sendRedirect("tous.jsp");
				
			} else {
				out.println("il n'y'a pas un utilisateur avec un nom pareil");
				response.sendRedirect("login.jsp");
				
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	}
