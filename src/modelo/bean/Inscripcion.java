package modelo.bean;

public class Inscripcion {
	
	private int id; 
	private Usuario usuario;
	private Actividad actividad;
	
	
	
	
	
	public Inscripcion(int id, Usuario usuario, Actividad actividad) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.actividad = actividad;
	}





	public Inscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Usuario getUsuario() {
		return usuario;
	}





	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}





	public Actividad getActividad() {
		return actividad;
	}





	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}





	@Override
	public String toString() {
		return "Inscripcion [id=" + id + ", usuario=" + usuario + ", actividad=" + actividad + "]";
	}
	
	
	
	
	
	
	
	
	
}
