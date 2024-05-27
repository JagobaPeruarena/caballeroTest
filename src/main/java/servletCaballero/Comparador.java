package servletCaballero;

import java.util.Comparator;

import modelo.bean.Caballero;

public class Comparador implements Comparator<Caballero>{

	@Override
	public int compare(Caballero o1, Caballero o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}	
