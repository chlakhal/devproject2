package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import e_commerce_website.*;


/**
 * Servlet implementation class AjouterAuPanierServelet
 */
public class AjouterAuPanierServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterAuPanierServelet() {
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
//        	out.print("add to Panier servlet");

            ArrayList<Panier> panierList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Panier cm = new Panier();
            cm.setId(id);
            cm.setQuantité(1);
            HttpSession session = request.getSession();
            ArrayList<Panier> panier_list = (ArrayList<Panier>) session.getAttribute("panier-list");
            if (panier_list == null) {
                panierList.add(cm);
                session.setAttribute("panier-list", panierList);
                response.sendRedirect("panier.jsp");
            } else {
                panierList = panier_list;

                boolean exist = false;
                for (Panier c : panier_list) {
                    if (c.getId() == id) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Panier. <a href='panier.jsp'>GO to Panier Page</a></h3>");
                    }
                }

                if (!exist) {
                    panierList.add(cm);
                    response.sendRedirect("panier.jsp");
                
                
            
            }
            }
            
       } 
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
