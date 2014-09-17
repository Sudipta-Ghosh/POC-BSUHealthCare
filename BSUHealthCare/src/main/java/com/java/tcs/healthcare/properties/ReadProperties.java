package com.java.tcs.healthcare.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadProperties {
	
	public static Map getPropertieswithKey(String key) throws IOException {
		InputStream input = null;
		Map mapOut=new HashMap();
		 
		try {
			Properties prop = new Properties();
			input = new FileInputStream("Healthcare.properties");
	 
			// load a properties file
			prop.load(input);
			mapOut.put(key, prop.getProperty(key));
			// get the property value and print it out
			System.out.println(mapOut);
			
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mapOut;
	}
	public static Map getAllProperties() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		Map mapOut=new HashMap();
		try {
	 
			input = new FileInputStream("Healthcare.properties");
			 
			// load a properties file
	
	 
			prop.load(input);
	 
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				System.out.println("Key : " + key + ", Value : " + value);
				mapOut.put(key, value);
			}
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mapOut;
	}

}
