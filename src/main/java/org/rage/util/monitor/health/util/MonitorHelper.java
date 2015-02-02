package org.rage.util.monitor.health.util;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.model.health.Project;
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
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public final class MonitorHelper
{
   private static final String IMPLEMENTATION_VERSION = "Implementation-Version";
   private final static String APP_VERSION            = "AppVersion";
   private final static String URL_SEPARATOR          = "/";
   private final static String PROTOCOL               = "http";
   private final static String GET_AS_XML             = "?viewXml=y";


   /**
    * @param artifact
    * */
   public static void checkVersion (final HealthArtifact artifact)
   {
      if ( (artifact != null) && artifact.isStatus () && (artifact.getProject () != null)
            && !artifact.getProject ().getAttributes ().isEmpty ())
      {
         final Project project = artifact.getProject ();
         if (project.getAttributes ().containsKey (IMPLEMENTATION_VERSION)
               && (project.getAttributes ().get (IMPLEMENTATION_VERSION) != null)
               && (project.getTargetVersion () != null)
               && project.getAttributes ().get (IMPLEMENTATION_VERSION).equals (project.getTargetVersion ()))
         {
            project.setSameVersion (Boolean.TRUE);
         }
      }
   }


   /**
    * Represents setCompleteURLVersion
    *
    * @param artifact
    * @since 02/02/2015
    *
    */
   public static void setCompleteURLVersion (final HealthArtifact artifact)
   {
      setCompleteURL (artifact);
      artifact.setCompletePath (artifact.getCompletePath () + GET_AS_XML);
   }


   /**
    * Represents setCompleteURL
    *
    * @param artifact
    * @since 02/02/2015
    *
    */
   public static void setCompleteURL (final HealthArtifact artifact)
   {
      final String DOTS = ":";
      final StringBuilder sb = new StringBuilder (PROTOCOL);
      sb.append (DOTS).append (URL_SEPARATOR).append (URL_SEPARATOR);
      sb.append (artifact.getServer ()).append (DOTS).append (artifact.getPort ());
      sb.append (URL_SEPARATOR).append (artifact.getProject ().getProjectContext ());
      sb.append (URL_SEPARATOR).append (APP_VERSION);
      artifact.setCompletePath (sb.toString ());
   }


   /**
    * Converts all the xml attributes to a map in the Project
    *
    * @param artifact
    * @throws ParserConfigurationException
    * @throws SAXException
    * @throws IOException
    * */
   public static void parseAddress (final HealthArtifact artifact) throws ParserConfigurationException, SAXException,
         IOException
   {
      final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
      final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
      final Document doc = dBuilder.parse (artifact.getCompletePath ());
      doc.getDocumentElement ().normalize ();

      final NodeList lists = doc.getElementsByTagName ("attribute");
      for (int i = 0; i < lists.getLength (); i++)
      {
         final Node node = lists.item (i);
         final NamedNodeMap nodeAttr = node.getAttributes ();
         if ( (nodeAttr != null) && (nodeAttr.getLength () > 0))
         {
            final Node attribute = nodeAttr.item (0);
            artifact.getProject ().getAttributes ().put (attribute.getNodeValue (),
                  node.getFirstChild ().getTextContent ());
         }
      }
   }
}
