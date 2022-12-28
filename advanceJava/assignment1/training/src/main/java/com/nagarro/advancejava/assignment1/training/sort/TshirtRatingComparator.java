package com.nagarro.advancejava.assignment1.training.sort;

import com.nagarro.advancejava.assignment1.training.tshirtmodel.Tshirt;

import java.util.*;
import com.nagarro.advancejava.assignment1.training.tshirtmodel.Tshirt;


public class TshirtRatingComparator implements Comparator<Tshirt> {
	
	public int compare(Tshirt a, Tshirt b)
	{
		Double y = a.getRating()-b.getRating();
		if(y<0)
			return -1;
		else if(y>0)
			return 1;
		else 
			return 0;
	}


}
