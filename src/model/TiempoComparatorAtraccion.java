package model;

import java.util.Comparator;

public class TiempoComparatorAtraccion implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion p1, Atraccion p2) {
		return (-1)*Double.compare(p1.getTiempo(), p2.getTiempo());
	}


}
