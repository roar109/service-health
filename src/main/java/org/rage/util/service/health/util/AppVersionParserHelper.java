package org.rage.util.service.health.util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.rage.util.service.health.pojo.ProjectExtended;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parse the AppVersion XML
 * */
public class AppVersionParserHelper {

	/**
	 * Converts all the xml attributes to a map in the Project
	 * 
	 * @param project
	 * @throws ParserConfigurationException, SAXException, IOExcepti
	 * */
	public static void parseAddress(ProjectExtended project) throws ParserConfigurationException, SAXException, IOException  {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(project.getCompletePath());
		doc.getDocumentElement().normalize();
		
		NodeList lists = doc.getElementsByTagName("attribute");
		for(int i = 0; i< lists.getLength();i++){
			Node node = lists.item(i);
			NamedNodeMap nodeAttr = node.getAttributes();
			if(nodeAttr != null && nodeAttr.getLength() > 0){
				Node attribute = nodeAttr.item(0);
				project.getAttributes().put(attribute.getNodeValue(), node.getFirstChild().getTextContent());
			}
		}
	}
}
