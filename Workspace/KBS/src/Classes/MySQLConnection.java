package Classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Interfaces.DataSaver;

import com.mysql.jdbc.PreparedStatement;
 
public class MySQLConnection implements DataSaver{
private static Connection con = null;
private static String dbHost = "localhost"; // Hostname
private static String dbPort = "3306";      // Port -- Standard: 3306
private static String dbName = "kinobuchdb";   // Datenbankname
private static String dbUser = "root";     // Datenbankuser
private static String dbPass = "";      // Datenbankpasswort
 
	public MySQLConnection(){
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.
	 
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
	
	public void reCreateDb(){
		System.out.println("Von hand Script ausführen :/");
	}//-deleteDB
 

public Integer insert_Texte(Texte text) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Texte"), Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, text.getTextinhalt());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void update_Texte(Texte text) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Texte"));
		stm.setString(1, text.getTextinhalt());
		stm.setInt(2, text.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public Object get_Texte(Texte text) {
	PreparedStatement stm = null;
	Texte result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Texte"));
		stm.setInt(1, text.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			result =  new Texte(rs.getInt(1), rs.getString(2));			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void delete_Texte(Texte text) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Texte"));
		stm.setInt(1, text.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch		
}//-delete_Texte


public Integer insert_Saal(Saal saal) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Saal"), Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, saal.getX());
		stm.setInt(2, saal.getY());
		stm.setString(3, saal.getBeschreibung());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
			result = rs.getInt(1);
			saal.setId(result);
			for(int reihe = 0; reihe < saal.getY();reihe++){
				for(int nummer = 0; nummer < saal.getX();nummer++){
					Sitz sitz = new Sitz(true, reihe, nummer, saal);
					this.insert_Sitz(sitz);
				}//-for
			}//-for
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}//-insert_Saal

public void update_Saal(Saal saal) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Saal"));
		stm.setInt(1, saal.getX());
		stm.setInt(2, saal.getY());
		stm.setString(3, saal.getBeschreibung());
		stm.setInt(4, saal.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public Object get_Saal(Saal saal) {
	PreparedStatement stm = null;
	Saal result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Saal"));
		stm.setInt(1, saal.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			result =  new Saal(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public Map<Saal, ArrayList<Sitz>> getAll_Saal(){
	PreparedStatement stm = null;
	Map<Saal, ArrayList<Sitz>> result = new HashMap();
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("getAll_Saal"));
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			Saal saal = null;
			ArrayList<Sitz> sitze = new ArrayList();
			Sitz sitz = null;
			
			saal = new Saal(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));
			
			stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Sitz_fkSaal"));
			stm.setInt(1, saal.getId());
			ResultSet es = stm.executeQuery();
			while(es.next()){
				sitz = new Sitz(es.getInt(1), es.getBoolean(2), es.getInt(3), es.getInt(4), saal);
				sitze.add(sitz);
			}//-for
			result.put(saal, sitze);
		}//-while
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}//-getAll_Saal

public void delete_Saal(Saal saal) {
	PreparedStatement stm = null;
	try {
		this.delete_Sitz(saal);
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Saal"));
		stm.setInt(1, saal.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}


public Integer insert_Sitz(Sitz sitz) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Sitz"), Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, sitz.getNummer());
		stm.setInt(2, sitz.getReihe());
		stm.setInt(3, sitz.getSaalangehoerig().getId());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch	
}//-insert_Sitz

public void update_Sitz(Sitz sitz) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Sitz"));
		stm.setInt(1, sitz.getNummer());
		stm.setInt(2, sitz.getReihe());
		stm.setInt(3, sitz.getSaalangehoerig().getId());
		stm.setInt(4, sitz.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch		
}

@Override
public Object get_Sitz(Sitz sitz) {
	PreparedStatement stm = null;
	Sitz result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Sitz"));
		stm.setInt(1, sitz.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			Saal angehoerig = (Saal) this.get_Saal(sitz.getSaalangehoerig());
			result =  new Sitz(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), angehoerig );			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void delete_Sitz(Sitz sitz) {
	PreparedStatement stm = null;
	try {
		this.delete_Ticket(sitz);
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Sitz"));
		stm.setInt(1, sitz.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public void delete_Sitz(Saal saal){
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Sitz_fkSaal"));
		stm.setInt(1, saal.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch
}


public Integer insert_Ticket(Ticket ticket) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Ticket"), Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, ticket.getSitzplatz().getId());
		stm.setInt(2, ticket.getReservierung().getId());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch	
}

public void update_Ticket(Ticket ticket) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Ticket"));
		stm.setInt(1, ticket.getSitzplatz().getId());
		stm.setInt(2, ticket.getReservierung().getId());
		stm.setInt(3, ticket.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public Object get_Ticket(Ticket ticket) {
	PreparedStatement stm = null;
	Ticket result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Ticket"));
		stm.setInt(1, ticket.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			Sitz sitz = (Sitz) this.get_Sitz(ticket.getSitzplatz());
			Reservation reserv = (Reservation) this.get_Reservation(ticket.getReservierung());
			result =  new Ticket(rs.getInt(1), sitz, reserv);			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void delete_Ticket(Ticket ticket) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Ticket"));
		stm.setInt(1, ticket.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch		
}

public void delete_Ticket(Sitz sitz){
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Ticket_fkSitz"));
		stm.setInt(1, sitz.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public void delete_Ticket(Reservation reservation){
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Ticket_fkReservation"));
		stm.setInt(1, reservation.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch		
}


public Integer insert_Reservation(Reservation reservation) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Reservation"), Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, reservation.getTelnumer());
		stm.setInt(2, reservation.getGebuchte_Vorstellung().getId());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch	
}

public void update_Reservation(Reservation reservation) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Reservation"));
		stm.setString(1, reservation.getTelnumer());
		stm.setInt(2, reservation.getGebuchte_Vorstellung().getId());
		stm.setInt(3, reservation.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public Object get_Reservation(Reservation reservation) {
	PreparedStatement stm = null;
	Reservation result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Reservation"));
		stm.setInt(1, reservation.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			Vorstellung_Real vr = (Vorstellung_Real) this.get_Vorstellung_Real(reservation.getGebuchte_Vorstellung());
			result =  new Reservation(rs.getInt(1), rs.getString(2), rs.getDate(3), vr);			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public Map<Reservation, ArrayList<Ticket>> getAll_Reservationen(){
	PreparedStatement stm = null;
	Map<Reservation, ArrayList<Ticket>>  result = new HashMap<Reservation, ArrayList<Ticket>>();
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("getAll_Reservation"));
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			Vorstellung_Real gebuchteVorstellung = (Vorstellung_Real) this.get_Vorstellung_Real(new Vorstellung_Real(rs.getInt(3)));
			Reservation reservation = new Reservation(rs.getInt(1), rs.getString(2), rs.getDate(4), gebuchteVorstellung);
			
			stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Ticket_fkReservation"));
			ResultSet es = stm.executeQuery();
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();
			while(es.next()){
				Sitz sitz = (Sitz) this.get_Sitz(new Sitz(es.getInt(2)));
				Ticket ticket = new Ticket(es.getInt(1), sitz, reservation);
				tickets.add(ticket);
			}//-while
			result.put(reservation, tickets);
		}//-while
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}//-getAll_Reservationen

public void delete_Reservation(Reservation reservation) {
	PreparedStatement stm = null;
	try {
		this.delete_Ticket(reservation);
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Reservation"));
		stm.setInt(1, reservation.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch		
}

public void delete_Reservation(Vorstellung_Real vr){
//TODO !ACHTUNG ZUERST ALLE GETTEN, ALLE FK LÖSCHEN UND DANN ALLE LÖSCHEN
}



public Integer insert_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Vorstellung_Real"), Statement.RETURN_GENERATED_KEYS);
		stm.setDate(1, new java.sql.Date( vorstellung_real.getAbspiel_zeit_effektiv().getTime()) );
		stm.setInt(2, vorstellung_real.getSpielt_in_saal().getId());
		stm.setInt(3, vorstellung_real.getVorstellungsinfos().getId());	
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch	
}

public void update_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Vorstellung_Real"));
		stm.setDate(1, new java.sql.Date( vorstellung_real.getAbspiel_zeit_effektiv().getTime()) );
		stm.setInt(2, vorstellung_real.getSpielt_in_saal().getId());
		stm.setInt(3, vorstellung_real.getVorstellungsinfos().getId());
		stm.setInt(4, vorstellung_real.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

public Object get_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	PreparedStatement stm = null;
	Vorstellung_Real result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Vorstellung_Real"));
		stm.setInt(1, vorstellung_real.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			Saal sl = (Saal) this.get_Saal(vorstellung_real.getSpielt_in_saal());
			Vorstellung vrstl = (Vorstellung) this.get_Vorstellung(vorstellung_real.getVorstellungsinfos());
			result =  new Vorstellung_Real(rs.getInt(1), rs.getDate(2), sl, vrstl);			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public Map<Vorstellung, ArrayList<Vorstellung_Real>> getAll_Vorstellungen(){
	PreparedStatement stm = null;
	Map<Vorstellung, ArrayList<Vorstellung_Real>> result = new HashMap();
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("getAll_Vorstellung"));
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			Vorstellung vorstellung = null;
			ArrayList<Vorstellung_Real> liste_vorst_real = new ArrayList();
			Vorstellung_Real vorst_real = null;
			
			Film film = (Film) this.get_Film( new Film(rs.getInt(2)));
			vorstellung = new Vorstellung(rs.getInt(1), film, rs.getInt(3), rs.getDate(4), rs.getDate(5));
			
			stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Vorstellung_Real_fkVorstellung"));
			stm.setInt(1, vorstellung.getId());
			ResultSet es = stm.executeQuery();
			while(es.next()){
				Saal saal = (Saal) this.get_Saal(new Saal(es.getInt(3)));
				vorst_real = new Vorstellung_Real(es.getInt(1), es.getDate(2), saal ,vorstellung);
				liste_vorst_real.add(vorst_real);
			}//-for
			result.put(vorstellung, liste_vorst_real);
		}//-while
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}//-getAll_Vorstellungen

public void delete_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	PreparedStatement stm = null;
	try {
		this.delete_Reservation(vorstellung_real);
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Vorstellung_Real"));
		stm.setInt(1, vorstellung_real.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch
}

public void delete_Vorstellung_Real(Vorstellung vorstellung){
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Vorstellung_Real_fkVorstellung"));
		stm.setInt(1, vorstellung.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch
}


public Integer insert_Vorstellung(Vorstellung vorstellung) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Vorstellung"), Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, vorstellung.getLaufender_film().getId() );	
		stm.setInt(2, vorstellung.getZusatzlaenge_min());
		stm.setDate(3, new java.sql.Date(  vorstellung.getStart_datum().getTime()) ); 
		stm.setDate(4, new java.sql.Date(  vorstellung.getEnd_datum().getTime()) );
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void update_Vorstellung(Vorstellung vorstellung) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Vorstellung"));
		stm.setInt(1, vorstellung.getLaufender_film().getId());
		stm.setInt(2, vorstellung.getZusatzlaenge_min());
		stm.setDate(3, new java.sql.Date( vorstellung.getStart_datum().getTime()) );
		stm.setDate(4, new java.sql.Date( vorstellung.getEnd_datum().getTime()) );
		stm.setInt(5, vorstellung.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
	
}

public Object get_Vorstellung(Vorstellung vorstellung) {
	PreparedStatement stm = null;
	Vorstellung result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Vorstellung"));
		stm.setInt(1, vorstellung.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			Film flm = (Film) this.get_Film(vorstellung.getLaufender_film());
			result =  new Vorstellung(rs.getInt(1), flm, rs.getInt(3), rs.getDate(4), rs.getDate(5));			
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void delete_Vorstellung(Vorstellung vorstellung) {
	PreparedStatement stm = null;
	try {
		this.delete_Vorstellung_Real(vorstellung);
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("delete_Vorstellung"));
		stm.setInt(1, vorstellung.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
	
}


public Integer insert_Film(Film film) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Film"), Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, film.getBild_pfad());
		stm.setString(2, film.getTitel());
		stm.setString(3, film.getBeschreibung());
		stm.setInt(4, film.getLaenge_min());
		stm.executeUpdate();
		ResultSet rs = stm.getGeneratedKeys();
		if (rs.next()){
		result = rs.getInt(1);
		}//-if
		rs.close();
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public void update_Film(Film film) {
	PreparedStatement stm = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("update_Film"));
		stm.setString(1, film.getBild_pfad());
		stm.setString(2, film.getTitel());
		stm.setString(3, film.getBeschreibung());
		stm.setInt(4, film.getLaenge_min());
		stm.setInt(5, film.getId());
		stm.executeUpdate();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
	
}

public Object get_Film(Film film) {
	PreparedStatement stm = null;
	Film result = null;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("get_Film"));
		stm.setInt(1, film.getId());
		ResultSet rs = stm.executeQuery();
		if(rs.next()){
			result =  new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
		}//-if
		stm.close();
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}

public ArrayList<Film> getAll_Filme(){
	PreparedStatement stm = null;
	ArrayList<Film> result = new ArrayList();
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("getAll_Film"));
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			Film film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			result.add(film);
		}//-while
		return result;
	} catch (SQLException e1) {
		e1.printStackTrace();
		return result;
	}//-catch
}//-getAll_Filme

public void delete_Film(Film film) {
	// TODO 
}

  
}//-classes