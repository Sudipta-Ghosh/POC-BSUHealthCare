package com.java.tcs.healthcare.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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

// TODO: Auto-generated Javadoc
/**
 * The Class XMLReader.
 */
public class XMLReader {

	/**
	 * Read xml attributes.
	 *
	 * @param xmlString the xml string
	 * @return the string
	 */
	public static String readXMLAttributes(String xmlString) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc = null;
		StringBuffer sb = new StringBuffer();
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

		List resultList = XMLReader.fixedColumn();
		List arrList = new ArrayList();
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println("resultList----" + resultList.get(i));
		    ReadXMLFile.printNote(doc.getChildNodes(),(String) resultList.get(i));
		}
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(
					"D:\\HealthCare\\Healthcare.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String arr[] = sCurrentLine.split(",");
				sb.append("<tr>");
				for (int counter = 0; counter <= arr.length - 1; counter++) {
					sb.append("<td>");
					sb.append(arr[counter]);
					sb.append("</td>");
				}

				sb.append("</tr>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return sb.toString();

	}

	/**
	 * Fixed column.
	 *
	 * @return the list
	 */
	public static List fixedColumn() {
		InputStream input = null;
		String key = "";
		List arrList = new ArrayList();

		try {
			Properties prop = new Properties();
			input = new FileInputStream(
					"D:\\HealthCare\\oracle_table_structure.txt");
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
