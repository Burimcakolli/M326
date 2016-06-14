package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String uName = "root";
		String uPass = "";
		
		Connection con = DriverManager.getConnection(host, uName, uPass);
	}//-Main
	
	

}//-Class
