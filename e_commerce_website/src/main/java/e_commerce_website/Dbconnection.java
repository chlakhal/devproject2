package e_commerce_website;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dbconnection {
	 private static Connection connection = null;

		    

		    public static Connection getConnection() throws ClassNotFoundException,SQLException {
		        if (connection == null) {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_website","root","sesnum2025");
		            System.out.println("connected");
		            }
		        return connection;
		    }
		}



