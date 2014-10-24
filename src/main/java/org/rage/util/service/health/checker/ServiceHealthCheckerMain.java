package org.rage.util.service.health.checker;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * ServiceHealthChecker represents ...
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
    * Represents runAllAndWait
    * 
    * @return artifacts
    * @since Oct 24, 2014
    * 
    */
   public List <HealthArtifact> runAllAndWait ()
   {
      final ExecutorService executor = Executors.newFixedThreadPool (artifacts.size ());
      for (final HealthArtifact artifact : artifacts)
      {
         final Runnable child = new ServiceCheckerHealthChild (artifact);
         executor.execute (child);
      }
      executor.shutdown ();
      while ( !executor.isTerminated ())
      {
         // TODO
      }
      return artifacts;
   }


}
