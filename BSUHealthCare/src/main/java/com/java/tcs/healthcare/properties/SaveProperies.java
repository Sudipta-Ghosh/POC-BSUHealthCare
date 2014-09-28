package com.java.tcs.healthcare.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaveProperies {

	public static String saveProperties(String key, String value) throws IOException {
		
		if( value!=null && !value.equals("")){
		Map mapOut=ReadProperties.getAllProperties();
		//Map mapOut=new HashMap();
		
    	 XSSFWorkbook workbook = new XSSFWorkbook(); 
         XSSFSheet sheet = workbook.createSheet("Attribute Data");
         
         Map<String, Object[]> dataMap = new TreeMap<String, Object[]>();
	
			// set the properties value
        int counter=1; 
        String valueInMap=(String) mapOut.get(key);
        if(valueInMap!=null && !valueInMap.equals("")){
        	mapOut.put(key,valueInMap+","+value);
        }else{
        	mapOut.put(key,value);
        }
        Iterator iterator = mapOut.entrySet().iterator();
    	while (iterator.hasNext()) {
    		Map.Entry mapEntry = (Map.Entry) iterator.next();
    		System.out.println("The key is: " + mapEntry.getKey()
    			+ ",value is :" + mapEntry.getValue());
    		dataMap.put(counter+"", new Object[] {mapEntry.getKey(), mapEntry.getValue()});
    		counter++;
    	}
		//Iterate over data and write to sheet
        Set<String> keyset = dataMap.keySet();
        int rownum = 0;
        for (String keyinMap : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = dataMap.get(keyinMap);
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
            FileOutputStream out = new FileOutputStream(new File("D:\\HealthCare\\Healthcare.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Healthcare.xls written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		}

	
		
		return "Healthcare.xls written successfully on disk.";

	}
	
	public static String WritePropertiesFile(String key, String data) throws IOException
	{
		   XSSFWorkbook workbook = new XSSFWorkbook(); 
	         
	        //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Employee Data");
	          
	        //This data needs to be written (Object[])
	        Map<String, Object[]> dataMap = new TreeMap<String, Object[]>();
	        dataMap.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
	        dataMap.put("2", new Object[] {1, "Amit", "Shukla"});
	        dataMap.put("3", new Object[] {2, "Lokesh", "Gupta"});
	        dataMap.put("4", new Object[] {3, "John", "Adwards"});
	        dataMap.put("5", new Object[] {4, "Brian", "Schultz"});
	          
	        //Iterate over data and write to sheet
	        Set<String> keyset = dataMap.keySet();
	        int rownum = 0;
	        for (String keyinMap : keyset)
	        {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = dataMap.get(keyinMap);
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
