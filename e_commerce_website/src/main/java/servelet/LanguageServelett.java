package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Servlet implementation class LanguageServelett
 */
public class LanguageServelett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LanguageServelett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
         String lang = request.getParameter("lang");
        
        // Si la langue est définie et n'est pas vide
        if (lang != null && !lang.isEmpty()) {
            // Stocker la langue choisie dans la session
            request.getSession().setAttribute("selectedLanguage", lang);
        } else {
            // Si aucune langue spécifique n'est choisie, utilisez l'anglais comme langue par défaut
            lang = "en";
        }
        
        // Charger le fichier de propriétés correspondant à la langue sélectionnée
        ResourceBundle messages = ResourceBundle.getBundle("webapp/contient/messages_" +lang+".properties.txt");
        
        // Vous pouvez envoyer des données au frontend ou rediriger vers une nouvelle page selon vos besoins
        // Exemple : envoyer des données au frontend sous forme de paramètres de requête
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

		 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
