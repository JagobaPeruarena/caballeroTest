package modelo.dao;

import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Caballero;

public class ModeloCaballero {
	private Conector conector;
	
	
	public ArrayList<Caballero> getCaballeros(){
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		String query = "SELECT * from CABALLEROS";
		ModeloArma mdArma = new ModeloArma();
		mdArma.setConector(conector);
		ModeloEscudo mdEscudo = new ModeloEscudo();
		mdEscudo.setConector(conector);
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
				caballero.setArma(mdArma.select(rs.getInt("arma_id")));
				caballero.setEscudo(mdEscudo.select(rs.getInt("escudo_id")));
				
				caballero.setFoto(rs.getString("foto"));
				
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
