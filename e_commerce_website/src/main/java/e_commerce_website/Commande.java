package e_commerce_website;

import java.sql.Date;

public class Commande extends Produit {
    private int co_id;
    private int uid;
   
    private int quantité;
    private String date;
    
	public int getCo_id() {
		return co_id;
	}
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Commande(int co_id, int uid,int quantité, String date) {
		super();
		this.co_id = co_id;
		this.uid = uid;
		
		this.quantité = quantité;
		this.date = date;
	}
	public Commande() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Commande [co_id=" + co_id + ", uid=" + uid + ",   quantité=" + quantité
				+ ", date=" + date + "]";
	}
	
}
