package org.rage.util.service.health.checker;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.io.IOException;

import java.net.Socket;


/**
 * ServiceCheckerHealthChild represents ...
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
    * Represents hostAvailabilityCheck
    * 
    * @param serverAddress
    * @param port
    * @return
    * @since Oct 24, 2014
    * 
    */
   public boolean hostAvailabilityCheck (final String serverAddress, final int port)
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
      final boolean available = hostAvailabilityCheck (artifact.getServer (), artifact.getPort ());
      artifact.setStatus (available);
   }

}
