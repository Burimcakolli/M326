package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MySQLConnection{
private static Connection con = null;
private static String dbHost = "localhost"; // Hostname
private static String dbPort = "3306";      // Port -- Standard: 3306
private static String dbName = "kinobuchdb";   // Datenbankname
private static String dbUser = "root";     // Datenbankuser
private static String dbPass = "";      // Datenbankpasswort
 
	private MySQLConnection(){
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber f�r JDBC Schnittstellen laden.
	 
	        // Verbindung zur JDBC-Datenbank herstellen.
	        con = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+ dbPort+"/"+dbName+"?"+"user="+dbUser+"&"+"password="+dbPass);
	    } catch (ClassNotFoundException e) {
	        System.out.println("Treiber nicht gefunden");
	    } catch (SQLException e) {
	        System.out.println("Verbindung nicht moglich");
	        System.out.println("SQLException: " + e.getMessage());
	        System.out.println("SQLState: " + e.getSQLState());
	        System.out.println("VendorError: " + e.getErrorCode());
	    }//-catch
	 }//-MySQLConnection
 
	private static Connection getInstance(){
	    if(con == null)
	        new MySQLConnection();
	    return con;
	}//-getInstance
 
  //Gebe Tabelle in die Konsole aus
  public static void printNameList(){
      con = getInstance();
 
      if(con != null){
      // Abfrage-Statement erzeugen.
      Statement query;
      try {
          query = con.createStatement();
 
          // Tabelle anzeigen
          String sql =
                "SELECT * FROM tbl_Saal";
          ResultSet result = query.executeQuery(sql);
 
        // Ergebnisstabelle durchforsten
          while (result.next()) {
          String beschreibung = result.getString("Beschreibung");       
          String info = beschreibung;
         
          System.out.println(info);
          }//-while
      } catch (SQLException e) {
        e.printStackTrace();
      }//-catch
    }//-if
  }//-printNameList
  
  public static void main(String[] args){ //Entfernen nicht vergessen
	  MySQLConnection.printNameList();
  }//-main
  
}//-classes