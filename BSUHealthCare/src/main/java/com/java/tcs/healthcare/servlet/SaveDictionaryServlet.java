package com.java.tcs.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tcs.healthcare.properties.SaveProperies;

public class SaveDictionaryServlet extends HttpServlet {
	
	  private String message;  

	  public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	  {
	      // Set response content type
	      response.setContentType("text/html");
	      
	      Map<String, String[]> requestParams = request.getParameterMap();
	      StringBuilder sb = new StringBuilder();
	      String pSourceName="";
	      String pInputField="";
	      
	        // retrieve parameter name - values pair from parameter map
	      for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
	            String key = entry.getKey();         // parameter name
	            String[] value = entry.getValue();   // parameter values as array of String
	            String valueString = "";
	            
	            // in case of checkbox input, value may be array of length greater than one
	            if (value.length > 1) {
	                for (int i = 0; i < value.length; i++) {
	                	if(i+1==value.length){
	                		 valueString += value[i];	
	                	}else{
	                    valueString += value[i] + "@";
	                	}
	                }
	            } else {
	                valueString = value[0];
	            }
	            
	            System.out.println("***** " + key + " - " + valueString);
	            if(key!=null && key.equals("pSourceName")){
	            	pSourceName=valueString;
	            }else  if(key!=null && key.equals("pInputField")){
	            	pInputField=valueString;
	            }
	        }
	      System.out.println("pSourceName----------"+pSourceName);
	      System.out.println("pInputField----------"+pInputField);
	      // Actual logic goes here.
	      String arrSourceName[]=pSourceName.split("@");
	      String arrInputField[]=pInputField.split("@");
	      
	      SaveProperies saveProperies =new SaveProperies();
	      String sourceName;
	      String probableName;
	      for(int counter=0;counter<arrSourceName.length;counter++){
	    	  sourceName=arrSourceName[counter];
	    	  probableName=arrInputField[counter];
	      String result=saveProperies.saveProperties(sourceName,probableName);
	      }
	      //request.setAttribute("pSubmitStatus", result);
	      RequestDispatcher requestDispatcher =request.getRequestDispatcher("/DictionaryUpdate.jsp");
	      requestDispatcher.forward(request, response);
	      
	  }
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException{
		  this.doGet(request, response);
		  
	  }
	  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		       // do something in here
		  this.doGet(request, response);
		  }
	  

}
