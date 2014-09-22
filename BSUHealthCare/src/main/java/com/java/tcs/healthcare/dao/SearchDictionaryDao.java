package com.java.tcs.healthcare.dao;

import java.util.HashMap;
import java.util.Map;

import com.java.tcs.healthcare.properties.ReadProperties;

public class SearchDictionaryDao {
	
	public static String searchDictionaryDAO(String searchString){
		Map mapout=ReadProperties.getAllProperties();		
		return (String) mapout.get(searchString);
		
	}

}
