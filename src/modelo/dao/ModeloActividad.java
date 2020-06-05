package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.bean.Actividad;
import modelox.Conector;

public class ModeloActividad extends Conector {

	public ArrayList<Actividad> SelectAll() {

		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {

			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setDias_semana(rs.getString("dias_semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setPrecio(rs.getDouble("precio"));

				actividades.add(actividad);
            
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actividades;

	}
	
	
	
	public Actividad SelectLike(String partes) {

		Actividad actividad = new Actividad();

		try {

			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where nombre like '%" + partes + "%'");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setDias_semana(rs.getString("dias_semana"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMax_participantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));

				System.out.println(actividad);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return actividad;

	}


	public Actividad get(int idActividad) {

		Actividad actividad = new Actividad();

		try {

			PreparedStatement pst= super.conexion.prepareStatement("select * from actividades where id=?");
			pst.setInt(1, idActividad);
			ResultSet rs= pst.executeQuery();
			
			
			while (rs.next()) {
			
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias_semana(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMax_participantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				 System.out.println(actividad);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return actividad;

	}

	public void update(Actividad actividad) {
		
		try {
			
			PreparedStatement pst= super.conexion.prepareStatement("update actividades set nombre=?, fecha_inicio=?, dias_semana=?, horas=?, max_participantes=?, precio=? where id=?");
			//No tiene resultset
			
			pst.setInt(1, actividad.getId());
			pst.setString(2, actividad.getNombre());
			pst.setDate(3, new java.sql.Date(actividad.getFecha_inicio().getTime()));
			pst.setString(4, actividad.getDias_semana());
			pst.setInt(5, actividad.getHoras());
			pst.setInt(6, actividad.getMax_participantes());
			pst.setDouble(7, actividad.getPrecio());
			
			
			//update con executeupdate
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void Insert(Actividad actividad) {
		
		
		try {
			
				PreparedStatement pst= super.conexion.prepareStatement("insert into actividades(nombre,fecha_inicio, dias_semana, horas,max_participantes,precio) values (?, ?, ?, ?, ?, ?)");
				pst.setInt(1, actividad.getId());
				pst.setString(2, actividad.getNombre());
				pst.setDate(3, new java.sql.Date(actividad.getFecha_inicio().getTime()));
				pst.setString(4, actividad.getDias_semana());
				pst.setInt(5, actividad.getHoras());
				pst.setInt(6, actividad.getMax_participantes());
				pst.setDouble(7, actividad.getPrecio());
				
				
				//update con executeupdate
				pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(Actividad actividad) {
		
		try {
			PreparedStatement pst= super.conexion.prepareStatement("delete from actividades where id=?");
			pst.setInt(1, actividad.getId());
			pst.execute();
			
			
		} catch (SQLException e) {
			
			
			
		e.printStackTrace();
		}
		
	}
	
	
	
	
}
