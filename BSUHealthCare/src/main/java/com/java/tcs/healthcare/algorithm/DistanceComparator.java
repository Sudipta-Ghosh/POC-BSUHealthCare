package com.java.tcs.healthcare.algorithm;

import java.util.Comparator;

import com.java.tcs.healthcare.vo.XMLTO;

public class DistanceComparator implements Comparator<XMLTO>{
	
	public int compare(XMLTO o1, XMLTO o2)
    {
        return o1.getDistance().compareTo(o2.getDistance());
    }
}
