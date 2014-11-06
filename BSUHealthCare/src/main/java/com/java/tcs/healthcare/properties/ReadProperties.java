package com.java.tcs.healthcare.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	public static Map getAllProperties() {
		Map mapOut=new HashMap();
		 try
	        {
	            FileInputStream file = new FileInputStream(new File("D:\\HealthCare\\Healthcare.xlsx"));
	            String keyName="";
	 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            //org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            //org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                 
	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                    switch (cell.getCellType()) 
	                    {	                       
	                        case Cell.CELL_TYPE_STRING:	                 
	                            if(cell.getColumnIndex()==0||(cell.getColumnIndex())%2==0){	                            	
	                            	keyName=cell.getStringCellValue();
	                            }else{
	                            	mapOut.put(keyName, cell.getStringCellValue());
	                            	keyName="";
	                            	
	                            }
	                            break;
	                    }
	                }
	               
	            }
	            file.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		 return mapOut;
	}

}
