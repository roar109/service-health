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

   String getServer ();


   void setServer (final String server);


   boolean isStatus ();


   void setStatus (final boolean status);


   void setPort (int port);


   int getPort ();
}
