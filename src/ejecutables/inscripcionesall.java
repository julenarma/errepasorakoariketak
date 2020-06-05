package ejecutables;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;

public class inscripcionesall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado= new Scanner (System.in);
		ModeloInscripcion mi=new ModeloInscripcion();
		ArrayList <Inscripcion> inscripciones= new ArrayList <Inscripcion>();

		inscripciones=mi.selectAll();
		for (int i = 0; i < inscripciones.size(); i++) {
			System.out.println(inscripciones.get(i));
		
			
		}
		
		
		
		
		
		
	}

}
