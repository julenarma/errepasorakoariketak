package modelo.util;

import java.util.Comparator;

import modelo.bean.Actividad;

public class ActividadPrecioAscendente implements Comparator<Actividad> {

	@Override
	public int compare(Actividad a1, Actividad a2) {
		if (a1.getPrecio()>a2.getPrecio()) {
			return 1;
		}else if(a1.getPrecio()<a2.getPrecio()) {
		return -1;
	}else{
		return 0;
	}

}
}

