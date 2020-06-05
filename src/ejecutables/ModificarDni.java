package ejecutables;

import java.util.Scanner;

import modelo.bean.Usuario;
import modelo.dao.ModeloUsuario;

public class ModificarDni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
     Scanner teclado= new Scanner(System.in);

   ModeloUsuario mu= new ModeloUsuario();
        int id=Integer.parseInt(teclado.next());

		Usuario usuario= mu.get(id);
		
		
		System.out.println("Introduce un dni");
		String dni= teclado.next();
		
		usuario.setDni(dni);
		
		
		mu.update(usuario);
		
		
		
		
	}

}
