package com.java.tcs.healthcare.xml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.java.tcs.healthcare.algorithm.DistanceComparator;
import com.java.tcs.healthcare.algorithm.LevenshteinDistanceCalculator;
import com.java.tcs.healthcare.dao.SearchDictionaryDao;
import com.java.tcs.healthcare.vo.XMLTO;

public class ReadXMLFile {

	static List arrList = new ArrayList();
	static List resultList = new ArrayList();
	static Map treemap = new TreeMap();

	

	public static List printNote(NodeList nodeList, String inputString,
			List arrList) {
		String resultString = SearchDictionaryDao
				.searchDictionaryDAO(inputString.toUpperCase());
		PrintWriter out = null;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\HealthCare\\Healthcare.txt", true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);

			String arr[] = new String[100];
			
			if (resultString != null && resultString.indexOf(",") != -1) {
				arr = resultString.split(",");
				for (int counter = 0; counter < arr.length; counter++) {
					String str = "";
					arrList = calculateDistanceForIndividualStringWithNode(
							nodeList, arr[counter].toUpperCase(), arrList);
					Collections.sort(arrList, new DistanceComparator());
					XMLTO xmlTo = null;
					for (int counter1 = 0; counter1 <= 2; counter1++) {
						xmlTo = (XMLTO) arrList.get(counter1);
						str = str+xmlTo.getNodeName() + ",";

					}
					str = arr[counter].toUpperCase() + "," + str;
					out.print(str);
					out.println();
					arrList=new ArrayList();

				}
			}
		} catch (IOException e) {
			// File writing/opening failed at some stage.
		} finally {
			try {
				if (out != null) {
					out.close(); // Will close bw and fw too
				} else if (bw != null) {
					bw.close(); // Will close fw too
				} else if (fw != null) {
					fw.close();
				} else {
					// Oh boy did it fail hard! :3
				}
			} catch (IOException e) {
				// Closing the file writers failed for some obscure reason
			}
		}
		return resultList;

	}

	public static List calculateDistanceForIndividualStringWithNode(
			NodeList nodeList, String inputString, List arrList) {
		XMLTO xmlto = new XMLTO();
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				String nodeName = tempNode.getNodeName();
				NamedNodeMap attributes = tempNode.getAttributes();

				int distance = LevenshteinDistanceCalculator
						.computeLevenshteinDistance(nodeName.toUpperCase(),
								inputString);
				xmlto.setNodeName(nodeName);
				xmlto.setXmlStrVal(inputString);
				xmlto.setDistance(distance);
				arrList.add(xmlto);
				// System.out.println("nodeName:::"+nodeName+"::::StrVal:::"+inputString+":::distance"+distance+":::Length::::"+attributes.getLength());
				// get the number of nodes in this map
				int numAttrs = attributes.getLength();

				for (int i = 0; i < numAttrs; i++) {
					Attr attr = (Attr) attributes.item(i);
					String attrName = attr.getNodeName();
					String attrValue = attr.getNodeValue();
					// System.out.println("Found attribute: " + attrName +
					// " with value: " + attrValue);
					arrList = calculateDistanceForIndividualStringWithNodeAttribute(
							attrName, inputString, arrList);
				}

				if (tempNode.hasChildNodes()) { // loop again if has
												// child nodes
					arrList = calculateDistanceForIndividualStringWithNode(
							tempNode.getChildNodes(), inputString, arrList);
				}

			}
		}
		return arrList;

	}

	public static List calculateDistanceForIndividualStringWithNodeAttribute(
			String attrName, String inputString, List arrList) {
		XMLTO xmlto = new XMLTO();
		int distance = LevenshteinDistanceCalculator
				.computeLevenshteinDistance(attrName, inputString);
		xmlto.setNodeName(attrName);
		xmlto.setXmlStrVal(inputString);
		xmlto.setDistance(distance);
		arrList.add(xmlto);
		// System.out.println("attrName:::"+attrName+"::::StrVal:::"+inputString+":::distance"+distance);

		return arrList;

	}

	public static String printFirstPart() {
		StringBuffer sb = new StringBuffer();
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
		return sb.toString();

	}

	public static String printLastPart() {
		StringBuffer sb = new StringBuffer();
		sb.append("</tbody>");
		sb.append("</table>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

}