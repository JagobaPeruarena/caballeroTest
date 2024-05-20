package modelo.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Caballero;

public class ModeloCaballero {
	private Conector conector;
	
	
	public ArrayList<Caballero> getCaballeros(){
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		String query = "SELECT * from CABALLEROS";
		Statement st;
		try {
			st = conector.getCon().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Caballero caballero = new Caballero();
				caballero.setId(rs.getInt("id"));
				caballero.setNombre(rs.getString("nombre"));
				caballero.setFuerza(rs.getInt("fuerza"));
				caballero.setExperiencia(rs.getInt("experiencia"));
				Arma arma =new Arma();
				arma.setId(rs.getInt("arma_id"));
				caballero.setArma(arma);
				arma.setFoto(rs.getString("foto"));
				
				caballeros.add(caballero);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return caballeros;
		
		
		
	}
	
	public void setConector(Conector conector) {
		this.conector = conector;
	}

}
