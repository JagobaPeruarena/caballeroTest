package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Arma;


public class ModeloArma {
	
private Conector conector;
	
	
	public ArrayList<Arma> getArmas(){
		ArrayList<Arma> armas = new ArrayList<Arma>();
		String query = "SELECT * from ARMAS";
		Statement st;
		try {
			st = conector.getCon().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setCapacidad_danio(rs.getInt("capacidad_danio"));						
				arma.setFoto(rs.getString("foto"));
				
				armas.add(arma);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return armas;
		
		
		
	}
	public Arma select(int id) {
		String query = "SELECT * from ARMAS where id = ?";
		
		
		
		try {
			PreparedStatement ps = conector.getCon().prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Arma arma = new Arma();
				arma.setId(rs.getInt("id"));
				arma.setNombre(rs.getString("nombre"));
				arma.setCapacidad_danio(rs.getInt("capacidad_danio"));						
				arma.setFoto(rs.getString("foto"));
				
				return arma;
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
