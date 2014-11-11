package com.java.tcs.healthcare.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tcs.healthcare.properties.ReadProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadDictionaryServlet.
 */
public class ReadDictionaryServlet extends HttpServlet {
	
	  /* (non-Javadoc)
  	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  	 */
  	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	  {
		  Map mapOut=ReadProperties.getAllProperties();
	      request.setAttribute("mapOut", mapOut);
	      RequestDispatcher requestDispatcher =request.getRequestDispatcher("/dictionary.jsp");
	      requestDispatcher.forward(request, response);
	  }
	  
  	/* (non-Javadoc)
  	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  	 */
  	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException{
		  this.doGet(request, response);
		  
	  }
	  
  	/* (non-Javadoc)
  	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
  	 */
  	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		       // do something in here
		  this.doGet(request, response);
		  }

}
