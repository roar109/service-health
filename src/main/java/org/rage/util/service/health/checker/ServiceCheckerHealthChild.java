package org.rage.util.service.health.checker;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.io.IOException;

import java.net.Socket;


/**
 * Service that check if a host is available.
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class ServiceCheckerHealthChild implements Runnable
{
   private final HealthArtifact artifact;


   /**
    * Constructs an instance of ServiceCheckerHealthChild object.
    * 
    * @param value
    */
   public ServiceCheckerHealthChild (final HealthArtifact value)
   {
      this.artifact = value;
   }


   /**
    * Creates a Socket to try to connect to a specified host and port.
    * 
    * @param serverAddress
    * @param port
    * @return boolean
    * @since Oct 24, 2014
    * 
    */
   private boolean hostAvailabilityCheck (final String serverAddress, final int port)
   {
      try
      {
         new Socket (serverAddress, port);
         return true;
      }
      catch (final IOException ex)
      {
         /* ignore */
      }
      return false;
   }


   /**
    * Overrides run
    * 
    * @since Oct 24, 2014
    * @see java.lang.Runnable#run()
    */
   @Override
   public void run ()
   {
      artifact.setStatus (hostAvailabilityCheck (artifact.getServer (), artifact.getPort ()));
   }

}
