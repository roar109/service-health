package org.rage.util.monitor.health.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.monitor.health.HealthMonitorExecutor;

import java.io.IOException;

import java.net.Socket;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public class ServerHealthMonitorImpl implements HealthMonitorExecutor
{

   private final HealthArtifact artifact;


   /**
    * Constructs an instance of ServerHealthMonitorImpl object.
    *
    * @param artifact
    */
   public ServerHealthMonitorImpl (final HealthArtifact artifact)
   {
      this.artifact = artifact;
   }


   /**
    * Overrides run
    *
    * @since 02/02/2015
    * @see java.lang.Runnable#run()
    */
   public void run ()
   {
      artifact.setStatus (hostAvailabilityCheck (artifact.getServer (), artifact.getPort ()));
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
}
