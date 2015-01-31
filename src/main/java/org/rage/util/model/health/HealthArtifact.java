package org.rage.util.model.health;


/**
 * HealthArtifact represents ...
 *
 * @author hector.mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 * @todo Complete description
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
