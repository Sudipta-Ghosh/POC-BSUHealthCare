package com.java.tcs.healthcare.algorithm;

import java.util.Comparator;

import com.java.tcs.healthcare.vo.XMLTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DistanceComparator.
 */
public class DistanceComparator implements Comparator<XMLTO>{
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(XMLTO o1, XMLTO o2)
    {
        return o1.getDistance().compareTo(o2.getDistance());
    }
}
