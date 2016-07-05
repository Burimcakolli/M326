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
	
	Texte test_text = new Texte(1,"Test");
		
	@Test
	public void insert_Texte() {
		int id =  mysql.insert_Texte(test_text);
		test_text.setId(id);
		assertEquals(1, test_text.getId());
	}//-insert_Texte

	@Test
	public void get_Texte(){
		test_text = (Texte) mysql.get_Texte(test_text);
		assertEquals("Test", test_text.getTextinhalt());
	}//-get_Texte
	
	@Test
	public void update_Texte(){
		test_text.setTextinhalt("Test wurde geändert");
		mysql.update_Texte(test_text);
		Texte t_temp = new Texte(1,"unwichtig");
		Texte t = (Texte) mysql.get_Texte(t_temp);
		assertEquals(test_text.getTextinhalt(), t.getTextinhalt());
	}
	
}//-TestClass
