package com.java.tcs.healthcare.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tcs.healthcare.properties.ReadProperties;

public class ReadDictionaryServlet extends HttpServlet {
	
	  public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	  {
		  Map mapOut=ReadProperties.getAllProperties();
	      request.setAttribute("mapOut", mapOut);
	      RequestDispatcher requestDispatcher =request.getRequestDispatcher("/dictionary.jsp");
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
