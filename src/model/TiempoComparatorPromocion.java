package model;

import java.util.Comparator;

public class TiempoComparatorPromocion implements Comparator<Promocion> {

	@Override
	public int compare(Promocion p1, Promocion p2) {
		return (-1)*Double.compare(p1.getTiempo(), p2.getTiempo());
	}


}
