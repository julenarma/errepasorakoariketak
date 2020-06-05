package ejecutables;

import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

public class actividad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		ModeloActividad ma= new ModeloActividad();
		
		Scanner teclado= new Scanner (System.in);
		
		System.out.println("Introduce una id");
	int	idActividad= Integer.parseInt(teclado.next());
	
	
	   ma.get(idActividad);
		
		
		
		
		
	}

}
