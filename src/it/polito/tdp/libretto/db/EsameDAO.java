package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.libretto.model.Esame;

public class EsameDAO {
	//classe che farà tutte le query
	
	public Esame find(String codice) {
		String sql = 
				"SELECT codice, titolo, docente, superato, voto, data_superamento "+
				"FROM esame "+
				"WHERE codice=?";
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		Esame result = null;
		try {
			Connection con = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement st = con.prepareStatement(sql);
			
			//devo rimpiazzare il punto interrogativo nei punti specifico -> metto i set al posto dei get precedenti
			st.setString(1, codice); //1 corrisponde al primo punto interrogativo , 2 al secondo, cosi via...
			
			ResultSet res = st.executeQuery();
			//che risultati mi aspetto ? 0 o 1 -> o lo trovo e se lo trovo è unico (perchè ho usato una chiave primaria) se non lo trovo avrò zero
			
			//avremo al massimo una riga -> non vale la pena fare il while
			
			if(res.next()) {
				//se res.next è true vuol dire che c'è un risultato, altrimenti no 
				
				Esame e = new Esame(res.getString("codice"), res.getString("titolo"), res.getString("docente"));
				result = e;
				// non estraiamo ancora la classe completa (TODO : voto e data_superamento)
				
			} else  {
				result = null;
				} //TODO : devo chiudere la connessione -> qualunque cosa arrivi a fare il programma devo chiudere la connessione
			con.close();
			return result; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	public boolean create(Esame e) {
		//query di tipo INSERT
		String sql = "INSERT INTO 'esame' (`codice`, `titolo`, `docente`, `superato`, `voto`, `data_superamento`) "+
"VALUES ('?', '?', '?', 0, NULL, NULL)";
		
		//copio e incollo tutto il resto
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		
		try {
			
			Connection con = DriverManager.getConnection(jdbcURL);
			
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, e.getCodice());
		ps.setString(2, e.getTitolo());
		ps.setString(1, e.getDocente());
		
		int result = ps.executeUpdate();
		
		con.close();
		
		if(result==1) {
			return true;
		} else return false;

			
		} catch(SQLException sqle) {
			sqle.getStackTrace();
			return false;
		}
		

	}

}
