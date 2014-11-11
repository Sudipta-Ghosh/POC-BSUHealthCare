package com.java.tcs.healthcare.dao;

import java.util.Map;

import com.java.tcs.healthcare.properties.ReadProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchDictionaryDao.
 */
public class SearchDictionaryDao {
	
	/**
	 * Search dictionary dao.
	 *
	 * @param searchString the search string
	 * @return the string
	 */
	public static String searchDictionaryDAO(String searchString){
		Map mapout=ReadProperties.getAllProperties();		
		return (String) mapout.get(searchString);
		
	}

}
