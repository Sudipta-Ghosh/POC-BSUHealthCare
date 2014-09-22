package com.java.tcs.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

	      // Actual logic goes here.
	      String sourceName=request.getParameter("Source Name");
	      String probableName=request.getParameter("Probable Name");
	      SaveProperies saveProperies =new SaveProperies();
	      String result=saveProperies.saveProperties(sourceName,probableName);
	      request.setAttribute("pSubmitStatus", result);
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
