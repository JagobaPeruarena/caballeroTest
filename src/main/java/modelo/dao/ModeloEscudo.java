package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Escudo;

public class ModeloEscudo {

private Conector conector;
	
	
	public ArrayList<Escudo> getEscudos(){
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		String query = "SELECT * from ESCUDOS";
		Statement st;
		try {
			st = conector.getCon().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));						
				
				
				escudos.add(escudo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return escudos;
		
		
		
	}
	public Escudo select(int id) {
		String query = "SELECT * from ESCUDOS where id = ?";
		
		
		
		try {
			PreparedStatement ps = conector.getCon().prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Escudo escudo = new Escudo();
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));						
				
				
				return escudo;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}
	
	public void setConector(Conector conector) {
		this.conector = conector;
	}
}
