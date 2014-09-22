package com.java.tcs.healthcare.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.java.tcs.healthcare.algorithm.LevenshteinDistanceCalculator;
import com.java.tcs.healthcare.dao.SearchDictionaryDao;
import com.java.tcs.healthcare.vo.XMLTO;

public class ReadXMLFile {
	static StringBuffer sb=new StringBuffer();
	static List arrList=new ArrayList();
	static Map treemap=new TreeMap(); 

	public static void main(String[] args) {

		Scanner ob = new Scanner(System.in);

		System.out.println("Please enter the String:: ");
		String str = ob.nextLine();
		FileOutputStream out=null;
		try {
			 out = new FileOutputStream(new File("Healthcare.html"));
			ReadXMLFile.printFirstPart();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ReadXMLFile.readXML(str);
		ReadXMLFile.printLastPart();
		String resultStr=sb.toString();
		byte[] contentInBytes = resultStr.getBytes();
		 
		try {
			out.write(contentInBytes);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static void readXML(String inputString) {
		try {

			File file = new File("output_1.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();

			Document doc = dBuilder.parse(file);
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) {
				//printNote(doc.getChildNodes(), inputString);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static List printNote(NodeList nodeList, String inputString,List arrList) {
		String resultString = SearchDictionaryDao
				.searchDictionaryDAO(inputString.toUpperCase());
		
		String arr[] = new String[100];
		if (resultString != null && resultString.indexOf(",") != -1) {
			arr = resultString.split(",");
			for (int counter = 0; counter < arr.length; counter++) {
				calculateDistanceForIndividualStringWithNode(nodeList,arr[counter].toUpperCase(),arrList);
			}
		}
		return arrList;

	}
	
	public  static List calculateDistanceForIndividualStringWithNode(NodeList nodeList, String inputString,List arrList){
		XMLTO xmlto=new XMLTO();
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				String nodeName = tempNode.getNodeName();
				NamedNodeMap attributes = tempNode.getAttributes();
				
				int distance = LevenshteinDistanceCalculator.computeLevenshteinDistance(nodeName.toUpperCase(),inputString);
				xmlto.setNodeName(nodeName);
				xmlto.setXmlStrVal(inputString);
				xmlto.setDistance(distance);
				arrList.add(xmlto);
				System.out.println("nodeName:::"+nodeName+"::::StrVal:::"+inputString+":::distance"+distance+":::Length::::"+attributes.getLength());
				// get the number of nodes in this map
				int numAttrs = attributes.getLength();

				for (int i = 0; i < numAttrs; i++) {
					Attr attr = (Attr) attributes.item(i);					
					String attrName = attr.getNodeName();
					String attrValue = attr.getNodeValue();					
					System.out.println("Found attribute: " + attrName + " with value: " + attrValue);
					arrList=calculateDistanceForIndividualStringWithNodeAttribute(attrName,inputString,arrList);
				}
				
				if (tempNode.hasChildNodes()) { // loop again if has
												// child nodes
					arrList=calculateDistanceForIndividualStringWithNode(tempNode.getChildNodes(), inputString,arrList);
				}

			}
		}
		return arrList;
		
	}
	
	
	public  static List calculateDistanceForIndividualStringWithNodeAttribute(String attrName, String inputString,List arrList){
		XMLTO xmlto=new XMLTO();		
		int distance = LevenshteinDistanceCalculator.computeLevenshteinDistance(attrName,inputString);
		xmlto.setNodeName(attrName);
		xmlto.setXmlStrVal(inputString);
		xmlto.setDistance(distance);
		arrList.add(xmlto);
		System.out.println("attrName:::"+attrName+"::::StrVal:::"+inputString+":::distance"+distance);
				
		
		return arrList;
		
	}
	
	private static void printFirstPart(){
		sb.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />");
		sb.append("<title>DataTables jQuery UI example</title>");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css\">");
		sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://cdn.datatables.net/plug-ins/725b2a2115b/integration/jqueryui/dataTables.jqueryui.css\">");
		sb.append("<script type=\"text/javascript\" language=\"javascript\" src=\"http://code.jquery.com/jquery-1.10.2.min.js\"></script>");
		sb.append("<script type=\"text/javascript\" language=\"javascript\" src=\"http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js\"></script>");
		sb.append("<script type=\"text/javascript\" language=\"javascript\" src=\"http://cdn.datatables.net/plug-ins/725b2a2115b/integration/jqueryui/dataTables.jqueryui.js\"></script>");
		sb.append("<script type=\"text/javascript\" charset=\"utf-8\">");
		sb.append("$(document).ready(function() {");
		sb.append("$('#example').dataTable();");
		sb.append("} );");
		sb.append("</script>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class=\"container\">");
		sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\" id=\"example\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Node Name In XML</th>");
		sb.append("<th>Best Match</th>");
		sb.append("<th>2 nd Best Match</th>");		
		sb.append("<th>3 rd Best Match</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("<tbody>");
		
	}
	
	private static void printLastPart(){
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
	
	}
	

}