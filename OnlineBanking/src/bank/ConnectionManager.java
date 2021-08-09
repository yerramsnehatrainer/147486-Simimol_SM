package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection getConnection() throws SQLException {
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
		return connection;
	}

}
