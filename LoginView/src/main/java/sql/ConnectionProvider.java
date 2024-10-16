package sql;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
 static  Connection con = null;
	public static Connection getConnection() {
		try {
			Class.forName(DBConnection.DB_Driver);
			con = DriverManager.getConnection(DBConnection.DB_URl, DBConnection.DB_User, DBConnection.DB_pass);
		}
		catch (Exception e ) {
			
		}
		return con;
	}
}