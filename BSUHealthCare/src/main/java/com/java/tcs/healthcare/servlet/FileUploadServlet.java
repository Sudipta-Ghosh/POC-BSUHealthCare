package com.java.tcs.healthcare.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.tcs.healthcare.fileupload.MultipartRequestHandler;
import com.java.tcs.healthcare.vo.FileTO;
import com.java.tcs.healthcare.xml.ReadXMLFile;
import com.java.tcs.healthcare.xml.XMLReader;


//this to be used with Java Servlet 3.0 API
@MultipartConfig 
public class FileUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// this will store uploaded files
	private static List<FileTO> files = new LinkedList<FileTO>();
	/***************************************************
	 * URL: /upload
	 * doPost(): upload the files and other parameters
	 ****************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
	    
		// 1. Upload File Using Java Servlet API
		//files.addAll(MultipartRequestHandler.uploadByJavaServletAPI(request));			
		
		// 1. Upload File Using Apache FileUpload
		files.addAll(MultipartRequestHandler.uploadByApacheFileUpload(request));
		
		// Remove some files
		while(files.size() > 20)
		{
			files.remove(0);
		}
		
		// 2. Set response type to json
		response.setContentType("application/json");
		
		// 3. Convert List<FileMeta> into JSON format
    	ObjectMapper mapper = new ObjectMapper();
    	
    	// 4. Send resutl to client
    	mapper.writeValue(response.getOutputStream(), files);
	
	}
	/***************************************************
	 * URL: /upload?f=value
	 * doGet(): get file of index "f" from List<FileMeta> as an attachment
	 ****************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
		  
		 // 1. Get f from URL upload?f="?"
		 String value = request.getParameter("f");
		 String event = request.getParameter("event");
		 
			 
		 // 2. Get the file of index "f" from the list "files"
		 FileTO getFile = files.get(Integer.parseInt(value));
		 
		 try {		
			 
			 	// 5. Copy file inputstream to response outputstream
		        InputStream input = getFile.getContent();
		       
		        byte[] buffer = new byte[1024*10];
		        StringBuilder sb = new StringBuilder();
		        int ch;
		        while((ch = input.read())!= -1)
		            sb.append((char)ch);
		        System.out.println("String1------"+sb.toString());
		       
		        if(event!=null && event.equals("GenerateReport")){
		        	String result=ReadXMLFile.printFirstPart()+XMLReader.readXMLAttributes(sb.toString())+ReadXMLFile.printLastPart();
		        System.out.println("GenerateReport String1------"+result);
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println(result);
		        out.close();
				
		        }
		        
		      
		        
		      
		        input.close();
		 }catch (IOException e) {
				e.printStackTrace();
		 }
		
	}
}
