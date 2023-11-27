package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import e_commerce_website.Panier;
import   e_commerce_website.Produit;


public class ProduitDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
	public ProduitDao(Connection con) {
		super();
		this.con = con;
	
	
	    }
	 public List<Produit> getAll(String catégorie) {
		    List<Produit> book = new ArrayList<>();
		    PreparedStatement pst = null;
		    ResultSet rs;
		    
		    try {
		        query = "SELECT * FROM produits WHERE catégorie = ?";
		        pst = this.con.prepareStatement(query);
		        pst.setString(1, catégorie); // 
		        rs = pst.executeQuery();
		        
		        while (rs.next()) {
		            Produit row = new Produit();
		            row.setId(rs.getInt("id"));
		            row.setNom(rs.getString("nom"));
		            row.setCatégorie(rs.getString("catégorie"));
		            row.setPrix(rs.getDouble("prix"));
		            row.setImage(rs.getString("image"));
		            // Utilisation de setQuantite au lieu de setQuantité si nécessaire
		            book.add(row);
		        }
		              
		            
		            
		        
		        
		    } catch (SQLException exp) {
		        System.out.println(exp.getMessage());
		    
		    }
		    return book;
		}
	 public List<Produit> getAll() {
		    List<Produit> book = new ArrayList<>();
		    PreparedStatement pst = null;
		    ResultSet rs;
		    
		    try {
		        query = "SELECT * FROM produits ";
		        pst = this.con.prepareStatement(query);
		        
		        rs = pst.executeQuery();
		        
		        while (rs.next()) {
		            Produit row = new Produit();
		            row.setId(rs.getInt("id"));
		            row.setNom(rs.getString("nom"));
		            row.setCatégorie(rs.getString("catégorie")); // Utilisation de setCategorie au lieu de setCatégorie si nécessaire
		            row.setPrix(rs.getDouble("prix"));
		            row.setImage(rs.getString("image"));
		            // Utilisation de setQuantite au lieu de setQuantité si nécessaire
		            book.add(row);
		        }
		              
		            
		            
		        
		        
		    } catch (SQLException exp) {
		        System.out.println(exp.getMessage());
		    
		    }
		    return book;
		}
	 public List<Panier> getPanierProduits(ArrayList<Panier> panierList) {
	        List<Panier> book = new ArrayList<>();
	        try {
	            if (panierList.size() > 0) {
	                for (Panier item : panierList) {
	                    query = "select * from produits where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        Panier row = new Panier();
	                        row.setId(rs.getInt("id"));
	                        row.setNom(rs.getString("nom"));
	                        row.setCatégorie(rs.getString("catégorie"));
	                        row.setPrix(rs.getDouble("prix")*item.getQuantité());
	                        row.setQuantité(item.getQuantité());
	                        book.add(row);
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return book;
	    }
	 public double getTotalPrixPanier(ArrayList<Panier> panierList) {
	        double sum = 0;
	        try {
	            if (panierList.size() > 0) {
	                for (Panier item : panierList) {
	                    query = "select prix from produits where id=?";
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        sum+=rs.getDouble("prix")*item.getQuantité();
	                    }

	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return sum;
	    }
	 public Produit getSingleProduit(int id) {
		 Produit row = null;
	        try {
	            query = "select * from produits where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Produit();
	                row.setId(rs.getInt("id"));
	                row.setNom(rs.getString("nom"));
	                row.setCatégorie(rs.getString("catégorie"));
	                row.setPrix(rs.getDouble("prix"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }

	}





