package Controllers;

import java.util.ArrayList;

import Classes.MySQLConnection;
import Classes.Saal;
import Classes.Sitz;

// KinoBuchungsSystem Controller -> Ist der Hauptcontroller der gesamten Applikation
public class KBS_C {
	private MySQLConnection db = new MySQLConnection();
	
	public void erfasseSaalTest(){
		Saal saal = new Saal("Dies ist ein KinoSaal 2",7,5);
		int fk_saal_test = db.insert_Saal(saal);
		
		System.out.println(fk_saal_test);
		saal.setId(fk_saal_test);
		
		//erfasse alle sitzplaetze
		for(int i = 0; i < (7*5); i++){ //10*10 steht für x mal y
			Sitz sitz = new Sitz(true, 10,10,saal);
			db.insert_Sitz(sitz);
		}//-for	 
	}//-erfasseSaal
		
	
}//-class
