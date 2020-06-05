package ejecutables;

import java.util.Scanner;

import modelo.bean.Usuario;
import modelo.dao.ModeloUsuario;

public class InsertarUsuario {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Inserta un nombre y apelido");
		
		String nombreApellido= teclado.nextLine();
		
		System.out.println("Inserta un dni");
		
		
		String dni= teclado.nextLine();
		
		
		System.out.println("Introduce un codigo");
		
		
		String codigo= teclado.nextLine();
		
		
		Usuario usuario= new Usuario();
		
		usuario.setNombre_apellido(nombreApellido);
		usuario.setDni(dni);
		usuario.setCodigo(codigo);
		
		ModeloUsuario mu= new ModeloUsuario();
		
		mu.update(usuario);
		
		
		
	}

}
