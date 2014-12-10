package org.rage.util.service.health.util;


import org.rage.util.service.health.pojo.ProjectExtended;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * Parse the AppVersion XML
 * */
public class AppVersionParserHelper
{

   /**
    * Converts all the xml attributes to a map in the Project
    * 
    * @param project
    * @throws ParserConfigurationException
    * @throws SAXException
    * @throws IOException
    * */
   public static void parseAddress (final ProjectExtended project) throws ParserConfigurationException, SAXException,
         IOException
   {
      final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
      final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
      final Document doc = dBuilder.parse (project.getCompletePath ());
      doc.getDocumentElement ().normalize ();

      final NodeList lists = doc.getElementsByTagName ("attribute");
      for (int i = 0; i < lists.getLength (); i++)
      {
         final Node node = lists.item (i);
         final NamedNodeMap nodeAttr = node.getAttributes ();
         if ( (nodeAttr != null) && (nodeAttr.getLength () > 0))
         {
            final Node attribute = nodeAttr.item (0);
            project.getAttributes ().put (attribute.getNodeValue (), node.getFirstChild ().getTextContent ());
         }
      }
   }
}
