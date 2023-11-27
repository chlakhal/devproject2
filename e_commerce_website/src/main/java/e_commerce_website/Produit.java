package e_commerce_website;

public class Produit {
	private int id;
	private String nom;
	
	private double prix;
	private String image;
	private String catégorie;
	
	public Produit(int id, String nom, String image, double prix, String catégorie) {
        this.id =id;
        this.nom = nom;
        this.image = image;
        this.prix=prix;
        this.catégorie = catégorie;
        
	}
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCatégorie() {
		
		return catégorie;
	}
	public void setCatégorie(String catégorie) {
		this.catégorie = catégorie;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", image=" + image + ", catégorie="
				+ catégorie + "]";
	}
	
	
	
}
