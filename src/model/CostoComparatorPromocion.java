package model;

import java.util.Comparator;

public class CostoComparatorPromocion implements Comparator<Promocion> {

	@Override
	public int compare(Promocion p1, Promocion p2) {
		return (-1)*Integer.compare(p1.getCosto(), p2.getCosto());
	}

}