package Controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import Classes.Main_GUI_C;
import Classes.Saal;
import Classes.Sitz;

//Die Klasse ist für den Start der Applikation zuständig und beinhaltet Grundsätzlich die static main Funktion
public class Starter {
	
	public static void main(String[] args){
		KBS_C myKBS = new KBS_C();
		
				
		Map<Saal, ArrayList<Sitz>> saale_mit_sitze = myKBS.getSaale();
		Iterator it = saale_mit_sitze.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
		    System.out.println(pair.getKey() + " = " + pair.getValue());
		    it.remove(); // avoids a ConcurrentModificationException
		}//-while
	
	}//-main
	
	
	
}//-Starter
