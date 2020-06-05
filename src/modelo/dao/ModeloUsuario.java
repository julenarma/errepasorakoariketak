package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.bean.Actividad;
import modelo.bean.Usuario;
import modelox.Conector;

public class ModeloUsuario extends Conector {

	public Usuario get (int id) {
		
		Usuario usuario= new Usuario();
		
		try {
			
			PreparedStatement pst= super.conexion.prepareStatement("select * from usuarios where id=?");
			ResultSet rs= pst.executeQuery();
			
			
			while (rs.next()) {
			
				
			usuario.setId(rs.getInt("id"));	
			usuario.setNombre_apellido(rs.getString("nombre_apellido"));
			usuario.setDni(rs.getString("dni"));
			usuario.setCodigo(rs.getString("codigo"));
			
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		return usuario;
		
		
		
	}
	
	
	public ArrayList<Usuario> SelectAll(){
		
		ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios");
			ResultSet rs= pst.executeQuery();
			
			
			while (rs.next()) {
			
				Usuario usuario= new Usuario();
				
				
				usuario.setId(rs.getInt("id"));
				usuario.setNombre_apellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				usuarios.add(usuario);
		
			}
			
			
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return usuarios;
		
		
	}
	
	
	public Usuario SelectLike(String partes) {
		
		
		Usuario usuario= new Usuario();
		
		
		try {
			PreparedStatement pst= super.conexion.prepareStatement("select * from usuarios where nombre like'%"+partes+"%'");
			
	        ResultSet rs= pst.executeQuery();
			
	        
	        while (rs.next()) {
			
	        	usuario.setId(rs.getInt("id"));
	        	usuario.setNombre_apellido(rs.getString("nombre_apellido"));
	        	usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
			
				
				System.out.print(usuario);
			}
			
			
		} catch (SQLException e) {
		
			
			
			e.printStackTrace();
		}
		
		
		
		return usuario;
		
		
		
	}
	
	
	public void delete (Usuario usuario) {
		
		
		 try {
			
			 
			 
			 PreparedStatement pst= super.conexion.prepareStatement("delete from usuarios where id=?");
			 pst.setInt(1, usuario.getId());
			 pst.execute();
	
			 
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			
		}
		
		
		
		
		
		
	}
	
	
	public void update (Usuario usuario) {
		
		
		
		try {
			PreparedStatement pst= super.conexion.prepareStatement("update usuarios set nombre_apellido=?, dni=?, codigo=? where id=?");
			pst.setInt(1, usuario.getId());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getCodigo());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insert(Usuario usuario) {
		
		try {
			PreparedStatement pst= super.conexion.prepareStatement("insert into usuarios (nombre_apellido, dni, codigo) values(?,?,?)");
			pst.setString(1, usuario.getNombre_apellido());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getCodigo());
			pst.execute();
			
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	
}
