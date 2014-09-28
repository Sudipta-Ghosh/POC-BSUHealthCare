package com.java.tcs.healthcare.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.java.tcs.healthcare.vo.XMLTO;

public class XMLReader {
	
	public static String readXMLAttributes(String xmlString){
	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder builder;	
	 Document doc = null;
	 String nodeName="";
	 StringBuffer sb=new StringBuffer();
	try {
		builder = factory.newDocumentBuilder();
		 InputSource is = new InputSource();
		 is.setCharacterStream(new StringReader(xmlString));
		doc = builder.parse(is);
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/* NodeList list = doc.getElementsByTagName("*");
	 System.out.println("XML Elements: ");
	 for (int i=0; i<list.getLength(); i++) {
	   Element element = (Element)list.item(i);
	   System.out.println(element.getNodeName());
	 }*/
	List resultList=XMLReader.fixedColumn();
	List arrList=new ArrayList();
	for (int i=0; i<resultList.size(); i++) {
		System.out.println("resultList----"+resultList.get(i));
		arrList=ReadXMLFile.printNote(doc.getChildNodes(), (String)resultList.get(i),arrList);
	}
	

	for (int i=0; i<arrList.size(); i++) {
		XMLTO xmlto=(XMLTO) arrList.get(i);
		System.out.println(xmlto.getNodeName()+":::"+xmlto.getXmlStrVal()+":::"+xmlto.getDistance());
		sb.append("<tr>");
		sb.append("<td>");
		sb.append(xmlto.getNodeName());
		sb.append("<td>");
		sb.append("<td>");
		sb.append(xmlto.getXmlStrVal());
		sb.append("<td>");
		sb.append("<td>");
		sb.append(xmlto.getNodeName());
		sb.append("<td>");
		sb.append("<tr>");
		
	}
	   return sb.toString();
		
	}
	
	public static List fixedColumn(){
		InputStream input = null;
		Map mapOut=new HashMap();
		String key="";
		String value="";
		List arrList=new ArrayList();
		 
		try {
			Properties prop = new Properties();
			input = new FileInputStream("D:\\HealthCare\\oracle_table_structure.txt");
	 
			// load a properties file
			prop.load(input);
			

			Enumeration enuKeys = prop.keys();
			while (enuKeys.hasMoreElements()) {
				 key = (String) enuKeys.nextElement();
				 arrList.add(key);
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
		return arrList;

}
}
