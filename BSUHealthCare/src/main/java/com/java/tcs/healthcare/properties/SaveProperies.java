package com.java.tcs.healthcare.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaveProperies {

	public static String saveProperties(String key, String value) throws IOException {
		Properties prop = new Properties();
		Map mapOut=ReadProperties.getAllProperties();
		FileOutputStream fileOutputStream  = new FileOutputStream(new File("Healthcare.properties"),true);

	
			// set the properties value
		Iterator entries = mapOut.entrySet().iterator();
		if(!entries.hasNext()){
			prop.setProperty(key,value); 
		}else{
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
	      if((String)thisEntry.getKey()!=null && ((String)thisEntry.getKey()).equals(key)){
	    	  prop.setProperty((String)thisEntry.getKey(),(String) thisEntry.getValue()+","+value);
	    	  break;
	      }else{
	    	  prop.setProperty(key,value); 
	      }
		}
		}	

			// save properties to project root folder
			prop.store(fileOutputStream, null);
			fileOutputStream.close();

		
		return "Properties Save Successfuly";

	}
	
	public static String WritePropertiesFile(String key, String data) throws IOException
	{
		   XSSFWorkbook workbook = new XSSFWorkbook(); 
	         
	        //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Employee Data");
	          
	        //This data needs to be written (Object[])
	        Map<String, Object[]> data = new TreeMap<String, Object[]>();
	        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
	        data.put("2", new Object[] {1, "Amit", "Shukla"});
	        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
	        data.put("4", new Object[] {3, "John", "Adwards"});
	        data.put("5", new Object[] {4, "Brian", "Schultz"});
	          
	        //Iterate over data and write to sheet
	        Set<String> keyset = data.keySet();
	        int rownum = 0;
	        for (String key : keyset)
	        {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = data.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr)
	            {
	               Cell cell = row.createCell(cellnum++);
	               if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Integer)
	                    cell.setCellValue((Integer)obj);
	            }
	        }
	        try
	        {
	            //Write the workbook in file system
	            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
	            workbook.write(out);
	            out.close();
	            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	return "Properties Save Successfuly";
	}

}
