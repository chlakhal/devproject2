package e_commerce_website;



public class Utilisateur {
	private int id;
	private String email;
	private String password;
	public Utilisateur(int id,String email,String password) {
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
	}
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}



