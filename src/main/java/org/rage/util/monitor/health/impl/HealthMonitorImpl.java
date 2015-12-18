package org.rage.util.monitor.health.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.monitor.health.HealthMonitor;
import org.rage.util.monitor.health.HealthMonitorType;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public class HealthMonitorImpl implements HealthMonitor
{
   private final List <HealthArtifact> artifacts;


   /**
    * Constructs an instance of HealthMonitorImpl object.
    *
    * @param artifacts
    */
   public HealthMonitorImpl (final List <HealthArtifact> artifacts)
   {
      this.artifacts = artifacts;
   }


   /**
    * Overrides runAllAndWait
    *
    * @param healthMonitorType
    * @return artifacts
    * @since 02/02/2015
    * @see org.rage.util.monitor.health.HealthMonitor#runAllAndWait(org.rage.util.monitor.health.HealthMonitorType)
    */
   public List <HealthArtifact> runAllAndWait (final HealthMonitorType healthMonitorType)
   {
      /*
       * Create a fixed pool of threads to handle all the artifacts at the same time.
       */
      final ExecutorService executor = Executors.newFixedThreadPool (artifacts.size ());

      for (final HealthArtifact artifact : artifacts)
      {
         switch (healthMonitorType)
         {// TODO try other approach
            case SERVER :
            case BALANCER :
               executor.execute (new ServerHealthMonitorImpl (artifact));
               break;
            case PROJECT :
            case PROJECT_MATCHER :
               executor.execute (new ProjectHealthMonitorImpl (artifact));
               break;
            case WEBSITE :
                executor.execute (new WebsiteHealthMonitorImpl (artifact));
                break;
         }
      }

      executor.shutdown ();
      while ( !executor.isTerminated ())
      {
         // nothing here just wait until is done.
      }
      return this.artifacts;
   }

}
