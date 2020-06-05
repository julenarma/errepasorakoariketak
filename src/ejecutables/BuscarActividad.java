package ejecutables;

import java.util.Scanner;

import modelo.dao.ModeloActividad;

public class BuscarActividad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
ModeloActividad ma= new ModeloActividad();

Scanner teclado= new Scanner (System.in);

	System.out.println("Introduce una parte de nombre");
	
	String partes=teclado.next();
		
		ma.SelectLike(partes);
		
	}

}
