package com.nagarro.advancejava.assignment1.training.sort;

import java.util.*;
import com.nagarro.advancejava.assignment1.training.tshirtmodel.Tshirt;

public class TshirtPriceComparator implements Comparator<Tshirt> {
	public int compare(Tshirt a, Tshirt b)
	{
		Double x = a.getPrice()-b.getPrice();
		if(x<0)
			return -1;
		else if(x>0)
			return 1;
		else 
			return 0;
	}

}
