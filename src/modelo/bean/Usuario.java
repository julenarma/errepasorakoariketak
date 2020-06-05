package modelo.bean;

import java.util.ArrayList;

public class Usuario {

	
	private ArrayList <Inscripcion> inscripciones;
	private int id;
	private String nombre_apellido;
	private String dni;
	@Override
	public String toString() {
		return "Usuario [inscripciones=" + inscripciones + ", id=" + id + ", nombre_apellido=" + nombre_apellido
				+ ", dni=" + dni + ", codigo=" + codigo + "]";
	}
	public Usuario(ArrayList<Inscripcion> inscripciones, int id, String nombre_apellido, String dni, String codigo) {
		super();
		this.inscripciones = inscripciones;
		this.id = id;
		this.nombre_apellido = nombre_apellido;
		this.dni = dni;
		this.codigo = codigo;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Inscripcion> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_apellido() {
		return nombre_apellido;
	}
	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	private String codigo;
	
	
	
}
