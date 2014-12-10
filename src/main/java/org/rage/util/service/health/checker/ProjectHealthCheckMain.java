/*
 * Copyright © 2000 - 2008 24 Hour Fitness. All rights reserved.
 */
package org.rage.util.service.health.checker;


import org.rage.util.service.health.pojo.Project;
import org.rage.util.service.health.pojo.ProjectExtended;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * ProjectHealthCheckMain represents ...
 *
 * @author <a href="mailto:hmendoza@24hourfit.com">hector.mendoza</a>
 * @version $Id$
 * @since 09/12/2014
 *
 */
public class ProjectHealthCheckMain
{
   private final List <ProjectExtended> projects;


   /**
    * Constructs an instance of ServiceHealthCheckerMain object.
    *
    * @param value
    */
   public ProjectHealthCheckMain (final List <ProjectExtended> value)
   {
      this.projects = value;
   }


   /**
    * Run artifacts.length number of threads to check if a server is alive.
    *
    * @return artifacts
    * @since Oct 24, 2014
    *
    */
   public List <ProjectExtended> runAllAndWait ()
   {
      /* Create a fixed pool of threads to handle all the artifacts at the same time. */
      final ExecutorService executor = Executors.newFixedThreadPool (projects.size ());

      for (final Project artifact : projects)
      {
         final Runnable child = new ProjectCheckerHealthChild (artifact);
         executor.execute (child);
      }

      executor.shutdown ();
      while ( !executor.isTerminated ())
      {
         // nothing here just wait until is done.
      }
      return projects;
   }
}
