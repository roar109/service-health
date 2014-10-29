package org.rage.util.service.health.pojo;


/**
 * HealthArtifact represents ...
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public interface HealthArtifact
{

   /**
    * Represents getServer
    * 
    * @return string
    * @since Oct 28, 2014
    * 
    */
   String getServer ();


   /**
    * Represents setServer
    * 
    * @param server
    * @since Oct 28, 2014
    * 
    */
   void setServer (final String server);


   /**
    * Represents isStatus
    * 
    * @return boolean
    * @since Oct 28, 2014
    * 
    */
   boolean isStatus ();


   /**
    * Represents setStatus
    * 
    * @param status
    * @since Oct 28, 2014
    * 
    */
   void setStatus (final boolean status);


   /**
    * Represents setPort
    * 
    * @param port
    * @since Oct 28, 2014
    * 
    */
   void setPort (int port);


   /**
    * Represents getPort
    * 
    * @return int
    * @since Oct 28, 2014
    * 
    */
   int getPort ();
}
