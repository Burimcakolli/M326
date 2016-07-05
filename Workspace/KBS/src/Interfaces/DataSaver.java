package Interfaces;

import Classes.Film;
import Classes.Reservation;
import Classes.Saal;
import Classes.Sitz;
import Classes.Texte;
import Classes.Ticket;
import Classes.Vorstellung;
import Classes.Vorstellung_Real;

public interface DataSaver {
	/* Struktur:
	 * -Modelklasse
	 * --insert_class
	 * --update_class
	 * --get_class
	 * --delete_class
	 */
	
	//-class_Texte
	public Integer insert_Texte(Texte text); 
	public void update_Texte(Texte text);
	public Object get_Texte(Texte text);
	public void delete_Texte(Texte text);
	//-End Texte
		
	//-class_Saal
	public Integer insert_Saal(Saal saal);
	public void update_Saal(Saal saal);
	public Object get_Saal(Saal saal);
	public void delete_Saal(Saal saal);
	//-End Saal
	
	//-class_Sitz
	public Integer insert_Sitz(Sitz sitz);
	public void update_Sitz(Sitz sitz);
	public Object get_Sitz(Sitz sitz);
	public void delete_Sitz(Sitz sitz);
	//-End Sitz
	
	//-class_Tickets
	public Integer insert_Ticket(Ticket ticket);
	public void update_Ticket(Ticket ticket);
	public Object get_Ticket(Ticket ticket);
	public void delete_Ticket(Ticket ticket);	
	//-End Tickets
	
	//-class_Reservation
	public Integer insert_Reservation(Reservation reservation);
	public void update_Reservation(Reservation reservation);
	public Object get_Reservation(Reservation reservation);
	public void delete_Reservation(Reservation reservation);
	//-End Reservation
	
	//-class_Vorstellung_Real
	public Integer insert_Vorstellung_Real(Vorstellung_Real vorstellung_real);
	public void update_Vorstellung_Real(Vorstellung_Real vorstellung_real);
	public Object get_Vorstellung_Real(Vorstellung_Real vorstellung_real);
	public void delete_Vorstellung_Real(Vorstellung_Real vorstellung_real);
	//-End Vorstellung_Real
	
	//-class_Vorstellung
	public Integer insert_Vorstellung(Vorstellung vorstellung);
	public void update_Vorstellung(Vorstellung vorstellung);
	public Object get_Vorstellung(Vorstellung vorstellung);
	public void delete_Vorstellung(Vorstellung vorstellung);	
	//-End Vorstellung
	
	//-class_Film
	public Integer insert_Film(Film film);
	public void update_Film(Film film);	
	public Object get_Film(Film film); 
	public void delete_Film(Film film);
	//-End Film	
	
}//-DataSaver
