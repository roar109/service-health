package org.rage.util.service.health.checker;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.rage.util.service.health.pojo.ProjectExtended;

/**
 * Check the AppVersion of the wars
 * @TODO join with the ProjectCheckerHealthMain
 * */
public class AppVersionCheckerMain {
	  private final List <ProjectExtended> projects;


	   /**
	    * Constructs an instance of ServiceHealthCheckerMain object.
	    *
	    * @param value
	    */
	   public AppVersionCheckerMain (final List <ProjectExtended> value)
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

	      for (final ProjectExtended artifact : projects)
	      {
	         final Runnable child = new AppVersionCheckerChild (artifact);
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
