package model;

import java.util.Comparator;

public class CostoComparatorAtraccion implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion p1, Atraccion p2) {
		return (-1)*Integer.compare(p1.getCosto(), p2.getCosto());
	}

}