package Tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import Classes.MySQLConnection;
import Classes.Texte;

public class MySQLConnectionTest {
	
	//-Zu gebrauchende Instanzen für das Testing
	private MySQLConnection mysql = new MySQLConnection();
	//-End Instanzen
	
	@BeforeClass
	public static void reCreateDb() {
		MySQLConnection cn = new MySQLConnection();
		cn.reCreateDb();
	}//-DeleteDB
		
	@Test
	public void insert_Texte() {
		Texte text = new Texte("Ulaf");
		int id =  mysql.insert_Texte(text);
		text.setId(id);
		assertEquals(1, text.getId());
	}//-test

}
