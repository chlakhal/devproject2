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


import e_commerce_website.Panier;








/**
 * Servlet implementation class IncrDecr
 */
public class IncrDecr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncrDecr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Panier> panier_list = (ArrayList<Panier>) request.getSession().getAttribute("panier-list");

			if (action != null && id >= 1) {
				if (action.equals("inc")) {
					for (Panier c : panier_list) {
						if (c.getId() == id) {
							int quantité = c.getQuantité();
							quantité++;
							c.setQuantité(quantité);
							response.sendRedirect("panier.jsp");
						}
					}
				}

				if (action.equals("dec")) {
					for (Panier c : panier_list) {
						if (c.getId() == id && c.getQuantité() > 1) {
							int quantité = c.getQuantité();
							quantité--;
							c.setQuantité(quantité);
							break;
						}
					}
					response.sendRedirect("panier.jsp");
				}
			} else {
				response.sendRedirect("panier.jsp");
			}
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
