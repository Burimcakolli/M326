package Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Classes.*;

// KinoBuchungsSystem Controller -> Ist der Hauptcontroller der gesamten Applikation
public class KBS_C {
	private MySQLConnection db = new MySQLConnection();
	private Sammler myData = new Sammler();
	
//Saale verwalten
	public void erfasseSaal(Saal saal){
		this.db.insert_Saal(saal);
	}//-erfasseSaal
	
	public ArrayList<Saal> getSaale(){
		return this.myData.getSaale();
	}//-getSaale
		
	public ArrayList<Sitz> getSitzeFkSaal(Saal saal){
		return this.myData.get_SitzFkSaal(saal);
	}//-getSitzeFkSaal
	
	public void setzeSitz(Sitz sitz){
		this.db.update_Sitz(sitz);
	}//-setzeSitz
//End Saale verwalten
	
//Filme verwalten
	public void erfasseFilm(Film film){
		this.db.insert_Film(film);
	}//-erfasseFilm
	
	public ArrayList<Film> getFilme(){
		return this.myData.getFilme();
	}//-getFilme
//End Filme verwalten
	
//Vorstellungen verwalten
	public void erfasseVorstellung(Vorstellung vorstellung){
		this.db.insert_Vorstellung(vorstellung);
	}//-erfasseVorstellung
	
	public void erfasseVorstellung_Real(Vorstellung_Real vorstellung_real){
		this.db.insert_Vorstellung_Real(vorstellung_real);
	}//-erfasseVorstellung_Real
	
	public ArrayList<Vorstellung> getVorstellungen(){
		return this.myData.getVorstellungen();
	}//-getVorstellungen
	
	public ArrayList<Vorstellung_Real> getVorstellungenReal(Vorstellung vorstellung){
		return this.myData.getVorstellungen_realFkVorstellung(vorstellung);
	} 
	
//End Vorstellungen verwalten
	
//Reservationen verwalten	
	public void erfasseReservation(Reservation reservation){
		this.db.insert_Reservation(reservation);
	}//-erfasseReservation
	
	public Map<Reservation, ArrayList<Ticket>> getReservationen(){
		return this.myData.getReservationen();
	}//-getReservationen
//End Reservationen verwalten

//Tickets verwalten	
	public void erfasseTicket(Ticket ticket){
		this.db.insert_Ticket(ticket);
	}//-erfasseTicket
//End Tickets verwalten
	
}//-class
