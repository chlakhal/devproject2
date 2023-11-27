package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import e_commerce_website.Commande;
import e_commerce_website.Produit;

public class CommandeDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;



	public CommandeDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertCommande(Commande model) {
        boolean result = false;
        try {
            query = "insert into commandes (p_id,  quantité, date,u_id) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getQuantité() );
            pst.setString(3, model.getDate() );
            pst.setInt(4, model. getUid());
            
           
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public List<Commande> utilisateursCommandes(int id) {
        List<Commande> list = new ArrayList<>();
        try {
            query = "select * from commandes where u_id=? order by commandes.co_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Commande commande = new Commande();
                ProduitDao produitDao = new ProduitDao(this.con);
                int pId = rs.getInt("p_id");
                Produit produit = produitDao.getSingleProduit(pId);
                commande.setCo_id(rs.getInt("co_id"));
                commande.setId(pId);
                commande.setNom(produit.getNom());
                commande.setCatégorie(produit.getCatégorie());
                commande.setPrix(produit.getPrix()*rs.getInt("quantité"));
                commande.setQuantité(rs.getInt("quantité"));
                commande.setDate(rs.getString("date"));
                list.add(commande);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void annulerCommande(int id) {
        //boolean result = false;
        try {
            query = "delete from commandes where co_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
}


