package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import modelo.bean.Inscripcion;
import modelo.bean.Usuario;
import modelox.Conector;

public class ModeloInscripcion extends Conector {

	
	public ArrayList <Usuario> getUsuariosinscritos(int idActividad) {
		
		ArrayList <Usuario> usuarios= new ArrayList <Usuario>();
		
		try {
			
			
			PreparedStatement pst = super.conexion.prepareStatement("select usuarios.* "
					+ "from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id "
					+ "where inscripciones.id_actividad = ?");
			pst.setInt(1, idActividad);
			ResultSet rs = pst.executeQuery();
			
		while (rs.next()) {
			
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre_apellido(rs.getString("nombre_apellido"));
			usuario.setDni(rs.getString("dni"));
			usuario.setCodigo(rs.getString("codigo"));
			
			usuarios.add(usuario);
			
			
			
			
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
		
		
		
	}
	

	public ArrayList <Inscripcion> selectAll() {
		
		ArrayList <Inscripcion> inscripciones= new ArrayList <Inscripcion>();
		ModeloActividad ma= new ModeloActividad();
		ModeloUsuario mu= new ModeloUsuario();
		try {
			
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from inscripciones");
			ResultSet rs = pst.executeQuery();
			
		while (rs.next()) {
			
			Inscripcion inscripcion = new Inscripcion();
			inscripcion.setId(rs.getInt("id"));
			inscripcion.setActividad(ma.get(rs.getInt("id_actividad")));
			inscripcion.setUsuario(mu.get(rs.getInt("id_usuario")));
			
			
			inscripciones.add(inscripcion);
			
			
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
		
		
		
		
	}

}
