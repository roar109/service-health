package org.rage.util.service.health.checker;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Service that launch a pool thread to check the health of the passed artifacts
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class ServiceHealthCheckerMain
{
   private final List <HealthArtifact> artifacts;


   /**
    * Constructs an instance of ServiceHealthCheckerMain object.
    * 
    * @param value
    */
   public ServiceHealthCheckerMain (final List <HealthArtifact> value)
   {
      this.artifacts = value;
   }


   /**
    * Run artifacts.length number of threads to check if a server is alive.
    * 
    * @return artifacts
    * @since Oct 24, 2014
    * 
    */
   public List <HealthArtifact> runAllAndWait ()
   {
      /* Create a fixed pool of threads to handle all the artifacts at the same time. */
      final ExecutorService executor = Executors.newFixedThreadPool (artifacts.size ());

      for (final HealthArtifact artifact : artifacts)
      {
         final Runnable child = new ServiceCheckerHealthChild (artifact);
         executor.execute (child);
      }

      executor.shutdown ();
      while ( !executor.isTerminated ())
      {
         // nothing here just wait until is done.
      }
      return artifacts;
   }
}
