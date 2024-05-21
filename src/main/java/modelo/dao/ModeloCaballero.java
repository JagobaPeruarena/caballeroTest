package modelo.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
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
	public boolean insert(Caballero caballero) {
		String query = " INSERT into CABALLEROS (nombre,fuerza,experiencia,foto,arma_id,escudo_id) VALUES (?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = conector.getCon().prepareStatement(query);
			ps.setString(1, caballero.getNombre());
			ps.setInt(2, caballero.getFuerza());
			ps.setInt(3, caballero.getExperiencia());
			ps.setString(4, caballero.getFoto());
			ps.setInt(5, caballero.getArma().getId());
			ps.setInt(6, caballero.getEscudo().getId());
			
			int rs = ps.executeUpdate();
			
			return rs >0;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
		
	}

}
