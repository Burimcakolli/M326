package Classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

@Override
public void delete_Texte(Texte text) {
	// TODO Auto-generated method stub
	
}

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
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

@Override
public Object get_Saal(Saal saal) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Saal(Saal saal) {
	// TODO Auto-generated method stub
	
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
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch		
}

@Override
public Object get_Sitz(Sitz sitz) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Sitz(Sitz sitz) {
	// TODO Auto-generated method stub
	
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
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

@Override
public Object get_Ticket(Ticket ticket) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Ticket(Ticket ticket) {
	// TODO Auto-generated method stub
	
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
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

@Override
public Object get_Reservation(Reservation reservation) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Reservation(Reservation reservation) {
	// TODO Auto-generated method stub
	
}



public Integer insert_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Vorstellung_Real"), Statement.RETURN_GENERATED_KEYS);
		stm.setDate(1, (Date) vorstellung_real.getAbspiel_zeit_effektiv());
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
		stm.setDate(1, (Date) vorstellung_real.getAbspiel_zeit_effektiv());
		stm.setInt(2, vorstellung_real.getSpielt_in_saal().getId());
		stm.setInt(3, vorstellung_real.getVorstellungsinfos().getId());
		stm.setInt(4, vorstellung_real.getId());
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
}

@Override
public Object get_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Vorstellung_Real(Vorstellung_Real vorstellung_real) {
	// TODO Auto-generated method stub
	
}

public Integer insert_Vorstellung(Vorstellung vorstellung) {
	PreparedStatement stm = null;
	Integer result = 0;
	try {
		stm = (PreparedStatement) con.prepareStatement(Queries.getQuery("insert_Vorstellung"), Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, vorstellung.getLaufender_film().getId() );	
		stm.setInt(2, vorstellung.getZusatzlaenge_min());
		stm.setDate(3, (Date) vorstellung.getStart_datum());
		stm.setDate(4, (Date) vorstellung.getEnd_datum());
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
		stm.setDate(3, (Date) vorstellung.getStart_datum());
		stm.setDate(4, (Date) vorstellung.getEnd_datum());
		stm.setInt(5, vorstellung.getId());
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
	
}

@Override
public Object get_Vorstellung(Vorstellung vorstellung) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Vorstellung(Vorstellung vorstellung) {
	// TODO Auto-generated method stub
	
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
		stm.executeQuery();
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
		stm.executeQuery();
		stm.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}//-catch	
	
}

@Override
public Object get_Film(Film film) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void delete_Film(Film film) {
	// TODO Auto-generated method stub
	
}

  
}//-classes