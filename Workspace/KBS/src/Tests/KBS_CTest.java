package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import Classes.*;
import Controllers.KBS_C;

public class KBS_CTest {
	public  KBS_C kbs_c = new KBS_C();
	public MySQLConnection db = new MySQLConnection(); 
	
/*	!Wichtig :
	Datenbank mit ReCreate SQL Script zuerst löschen
	eventuell gleich Javafunktion hierfür implementieren 
*/	
	
	//Prüft Methoden: erfasseSaal, getSaale
	@Ignore
	public void erfasseSaal() {
		//-Eingaben vorbereiten
		Saal saal = new Saal("Dies ist ein Saal",2,2);
		//-End Eingaben vorbereiten
		
		//-Ergebnisse vorbereiten
		Map<Saal, ArrayList<Sitz>> erwartet_saale = new HashMap();
		ArrayList<Sitz> erwartet_sitze = new ArrayList();
		Sitz sitz = new Sitz(1,true, 0, 0, saal);
		erwartet_sitze.add(sitz);
		sitz = new Sitz(2,true, 0, 1, saal);
		erwartet_sitze.add(sitz);
		sitz = new Sitz(3,true, 1, 0, saal);
		erwartet_sitze.add(sitz);
		sitz = new Sitz(4,true, 1, 1, saal);
		erwartet_sitze.add(sitz);
		
		erwartet_saale.put(saal, erwartet_sitze);		
		//-End Ergebnisse vorbereiten
		
		//Ausführung
		kbs_c.erfasseSaal(saal);
		Map<Saal, ArrayList<Sitz>> saale = kbs_c.getSaale();
		//-End Ausführung
		
		String aktuellStr = "";
		//Umwandlung in String für vergleich
		for (Map.Entry<Saal, ArrayList<Sitz>> entry : saale.entrySet()) {
			Saal mySaal = (Saal) entry.getKey();
		    ArrayList<Sitz> sitze = (ArrayList<Sitz>) entry.getValue() ;
		    aktuellStr +=(mySaal.getId()+"::"+mySaal.getBeschreibung()+"::"+mySaal.getY()+"::"+mySaal.getX());
		    aktuellStr +=("Beinhaltet==");
		    for (int i = 0; i < sitze.size(); i++) {
		    	aktuellStr +=(sitze.get(i).getId()+"::Reihe::"+sitze.get(i).getReihe()+" Nummer::"+sitze.get(i).getNummer());
			}//-for
		}//-for
		
		String erwartetStr = "";
		for (Map.Entry<Saal, ArrayList<Sitz>> entry : erwartet_saale.entrySet()) {
			Saal mySaal = (Saal) entry.getKey();
		    ArrayList<Sitz> sitze = (ArrayList<Sitz>) entry.getValue() ;
		    erwartetStr +=(mySaal.getId()+"::"+mySaal.getBeschreibung()+"::"+mySaal.getY()+"::"+mySaal.getX());
		    erwartetStr +=("Beinhaltet==");
		    for (int i = 0; i < sitze.size(); i++) {
		    	erwartetStr +=(sitze.get(i).getId()+"::Reihe::"+sitze.get(i).getReihe()+" Nummer::"+sitze.get(i).getNummer());
			}//-for
		}//-for
		//-End Umwandlung
		
		assertEquals(aktuellStr, erwartetStr); //Vergleich
	}//-erfasseSaal

	//Prüft Methoden: erfasseFilm, getFilme
	@Ignore
	public void erfasseFilm(){
		//-Eingaben vorbereiten
			Film film = new Film(1,"https://en.wikipedia.org/wiki/Straight_Outta_Compton_(film)#/media/File:Straight_Outta_Compton_poster.jpg", "Straight Outta Compton", "Eine Gruppe junger schwarzer Rapper die, die Musikbranche revolutionieren.", 120);	
		//-End Eingaben vorbereiten
		
		//-Ergebnisse vorbereiten
			ArrayList<Film> erwartet_filme = new ArrayList();
			erwartet_filme.add(film);
		//-End Ergebnisse vorbereiten
			
		//-Ausführung
			kbs_c.erfasseFilm(film);
			ArrayList<Film> filme = kbs_c.getFilme();
		//-End Ausführung
			
		String aktuellStr = "";
		//Umwandlung in String für vergleich
		for (int i = 0; i < filme.size(); i++) {
			Film myFilm = filme.get(i);
			aktuellStr += "ID::"+myFilm.getId()+" Bild_Pfad::"+myFilm.getBild_pfad()+" titel::"+myFilm.getTitel()+" beschreibung::"+myFilm.getBeschreibung()+" laengeMin::"+myFilm.getLaenge_min();			
		}//-for
		
		String erwartetStr = "";
		for (int i = 0; i < erwartet_filme.size(); i++) {
			Film myFilm = erwartet_filme.get(i);
			erwartetStr += "ID::"+myFilm.getId()+" Bild_Pfad::"+myFilm.getBild_pfad()+" titel::"+myFilm.getTitel()+" beschreibung::"+myFilm.getBeschreibung()+" laengeMin::"+myFilm.getLaenge_min();			
		}//-for
		//-End Umwandlung
		
		assertEquals(erwartetStr, aktuellStr); //Vergleich
	}//-erfasseFilm
	
//	!Wichtig : Bei Getten von Date ist anderes Format, deshalb unequalse
	//Prüft Methoden: erfasseVorstellung, erfasseVorstellung_Real,getVorstellungen
	@Ignore
	public void erfasseVorstellung(){
		//-Eingaben vorbereiten
		ArrayList<Film> filme = kbs_c.getFilme();
		Map<Saal, ArrayList<Sitz>> saale = kbs_c.getSaale();
		Film film = filme.get(0);
		Saal saal = null;
		for (Map.Entry<Saal, ArrayList<Sitz>> entry : saale.entrySet()) {
			saal = (Saal) entry.getKey();
		}//-for
		Vorstellung vorstellung = new Vorstellung(1, film, 20, new Date(116,5,16), new Date(116,5,25));
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(116,5,16)); // Now use today date.
		c.add(Calendar.DATE, 1); // Adds 15 days
		Vorstellung_Real vorst_real = new Vorstellung_Real(c.getTime(), saal, vorstellung);
		
		//-End Eingaben vorbereiten
		
		//-Ergebnisse vorbereiten
		Map<Vorstellung, ArrayList<Vorstellung_Real>> erwartet_vorstellungen = new HashMap();
		ArrayList<Vorstellung_Real> erwartet_vorstellungen_real = new ArrayList();
		vorst_real = new Vorstellung_Real(new Date(116,05,16), saal, vorstellung);
		erwartet_vorstellungen_real.add(vorst_real);
		
		erwartet_vorstellungen.put(vorstellung, erwartet_vorstellungen_real);
		//-End Ergebnisse vorbereiten
		
		//Ausführung
		kbs_c.erfasseVorstellung(vorstellung);
		Map<Vorstellung, ArrayList<Vorstellung_Real>> vorstellungen = kbs_c.getVorstellungen();
		kbs_c.erfasseVorstellung_Real(vorst_real);
		//-End Ausführung
		
		String aktuellStr = "";
		//Umwandlung in String für vergleich
		for (Map.Entry<Vorstellung, ArrayList<Vorstellung_Real>> entry : vorstellungen.entrySet()) {
			Vorstellung myVorstellung = (Vorstellung) entry.getKey();
		    ArrayList<Vorstellung_Real> vorstellungen_real = (ArrayList<Vorstellung_Real>) entry.getValue() ;
		    aktuellStr +=("VorstellungsId::"+myVorstellung.getId()+" Filmname::"+myVorstellung.getLaufender_film().getTitel()+" zusatzlaenge::"+myVorstellung.getZusatzlaenge_min()+" start_datum::"+myVorstellung.getStart_datum()+" end_datum::"+myVorstellung.getEnd_datum());
		    aktuellStr +=("Beinhaltet==");
		    for (int i = 0; i < erwartet_vorstellungen_real.size(); i++) {
		    	aktuellStr +=("Vorst_RealID::"+erwartet_vorstellungen_real.get(i).getId()+" abspiel_zeit_effektiv::"+erwartet_vorstellungen_real.get(i).getAbspiel_zeit_effektiv()+" Saal::"+erwartet_vorstellungen_real.get(i).getSpielt_in_saal().getBeschreibung()+" SpielenderFilm::"+erwartet_vorstellungen_real.get(i).getVorstellungsinfos().getLaufender_film().getTitel());
			}//-for
		}//-for
		
		String erwartetStr = "";
		for (Map.Entry<Vorstellung, ArrayList<Vorstellung_Real>> entry : erwartet_vorstellungen.entrySet()) {
			Vorstellung myVorstellung = (Vorstellung) entry.getKey();
		    erwartetStr +=("VorstellungsId::"+myVorstellung.getId()+" Filmname::"+myVorstellung.getLaufender_film().getTitel()+" zusatzlaenge::"+myVorstellung.getZusatzlaenge_min()+" start_datum::"+myVorstellung.getStart_datum()+" end_datum::"+myVorstellung.getEnd_datum());
		    erwartetStr +=("Beinhaltet==");
		    for (int i = 0; i < erwartet_vorstellungen_real.size(); i++) {
		    	erwartetStr +=("Vorst_RealID::"+erwartet_vorstellungen_real.get(i).getId()+" abspiel_zeit_effektiv::"+erwartet_vorstellungen_real.get(i).getAbspiel_zeit_effektiv()+" Saal::"+erwartet_vorstellungen_real.get(i).getSpielt_in_saal().getBeschreibung()+" SpielenderFilm::"+erwartet_vorstellungen_real.get(i).getVorstellungsinfos().getLaufender_film().getTitel());
			}//-for
		}//-for
		//-End Umwandlung
		assertEquals(erwartetStr, aktuellStr); //Vergleich
	}//-erfasseVorstellung
	
	//Prüft Methoden: erfasseReservation, getReservationen
	@Test
	public void erfasseReservation(){
		//-Eingaben vorbereiten
		Map<Vorstellung, ArrayList<Vorstellung_Real>> vorstellungen = kbs_c.getVorstellungen();
		ArrayList<Vorstellung_Real> vorst_real = new ArrayList<Vorstellung_Real>();
		for (Map.Entry<Vorstellung, ArrayList<Vorstellung_Real>> entry : vorstellungen.entrySet()) {
			vorst_real = entry.getValue();
		}//-for
		Reservation reservation = new Reservation(1,"0789532522", new Date(), vorst_real.get(0) );
		//-End Eingaben vorbereiten
		
		//-Erwartete Ergebnisse vorbereiten
		Map<Reservation, ArrayList<Ticket>> erwartet_reservationen = new HashMap<Reservation, ArrayList<Ticket>>();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Sitz sitz = new Sitz(1, false, 0, 0, new Saal(1,"Dies ist ein Saal",2,2));
		Ticket ticket = new Ticket(1, sitz, reservation);
		tickets.add(ticket);
		erwartet_reservationen.put(reservation, tickets);
		//-Erwartete Ergebnisse vorbereiten
		
		//-Ausführen
		kbs_c.erfasseReservation(reservation);
		this.db.insert_Ticket(ticket);
		Map<Reservation, ArrayList<Ticket>> reservationen = kbs_c.getReservationen();
		//-Ausführen
		
		//Umwandlung in String für vergleich
		String aktuellStr = "";
		for (Map.Entry<Reservation, ArrayList<Ticket>> entry : reservationen.entrySet()) {
			Reservation myReservation = (Reservation) entry.getKey();
		    ArrayList<Ticket> tickets_ = (ArrayList<Ticket>) entry.getValue();
		    aktuellStr +=("ID::"+myReservation.getId()+" tel::"+myReservation.getTelnumer()+" ID_Vors::"+myReservation.getGebuchte_Vorstellung().getId());
		    aktuellStr +=("Beinhaltet==");
		    for (int i = 0; i < tickets_.size(); i++) {
		    	aktuellStr +=("ID::"+tickets.get(i).getId()+" fk_Sitz::"+tickets.get(i).getSitzplatz().getId()+" fk_reservation::"+tickets.get(i).getReservierung().getId());
			}//-for
		}//-for
		
		String erwartetStr = "";
		for (Map.Entry<Reservation, ArrayList<Ticket>> entry : erwartet_reservationen.entrySet()) {
			Reservation myReservation = (Reservation) entry.getKey();
		    ArrayList<Ticket> tickets_ = (ArrayList<Ticket>) entry.getValue();
		    erwartetStr +=("ID::"+myReservation.getId()+" tel::"+myReservation.getTelnumer()+" ID_Vors::"+myReservation.getGebuchte_Vorstellung().getId());
		    erwartetStr +=("Beinhaltet==");
		    for (int i = 0; i < tickets_.size(); i++) {
		    	erwartetStr +=("ID::"+tickets.get(i).getId()+" fk_Sitz::"+tickets.get(i).getSitzplatz().getId()+" fk_reservation::"+tickets.get(i).getReservierung().getId());
			}//-for
		}//-for
		//-End Umwandlung
		
		assertEquals(erwartetStr, aktuellStr); //Vergleich
	}//-erfasseReservation
	
}//-class
