package ejecutables;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

public class actividadesall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado= new Scanner (System.in);
		ModeloActividad ma=new ModeloActividad();
		ArrayList <Actividad> actividades= new ArrayList <Actividad>();

		actividades=ma.SelectAll();
		for (int i = 0; i < actividades.size(); i++) {
			System.out.println(actividades.get(i));
		
			
		}
		
		
		
	}

}
