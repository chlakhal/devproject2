package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;



import e_commerce_website.Utilisateur;

public class UtilisateurDao {
	
	
	
		private Connection con;

		private String query;
	    private PreparedStatement pst;
	    private ResultSet rs;

		

		public UtilisateurDao(Connection con) {
			this.con = con;
		}
		public Utilisateur utilisateurRegister(String nom,String email,String password)  {
			Utilisateur utilisateur = null;
			pst = null;
			
			try {
				
				
				query="insert into utilisateurs(nom ,email,password)"+"values(?,?,?)";
				pst = con.prepareStatement(query);
				
				pst.setString(1,nom);
				pst.setString(2,email);
				pst.setString(3,password);
				
			    pst.executeUpdate();
	        } catch (SQLException exp) {
	            System.out.println(exp.getMessage());
	        }
			return utilisateur;
	    }
	


				
			
		

		public Utilisateur utilisateurLogin(String email, String password) throws NoSuchAlgorithmException {
			Utilisateur utilisateur = null;
	        try {query = "select * from utilisateurs where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password );
            
            rs = pst.executeQuery();
            if(rs.next()){
            	utilisateur = new Utilisateur();
            	utilisateur.setId(rs.getInt("id"));
            	
            	utilisateur.setEmail(rs.getString("email"));
	        
		        }
		        

	        	
	            
	            
	        } catch (SQLException e) {
	            System.out.print(e.getMessage());
	        }
	        return utilisateur;
	    }

}
