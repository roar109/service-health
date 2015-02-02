package org.rage.util.health.main;


import org.rage.util.service.health.HealthService;
import org.rage.util.service.health.impl.ProjectMatcherHealthServiceImpl;


/**
 * ProjectMatcherHealthMain represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public class ProjectMatcherHealthMain
{

   /**
    * Represents main
    *
    * @param args
    * @since 02/02/2015
    *
    */
   public static void main (final String[] args)
   {
      final HealthService health = new ProjectMatcherHealthServiceImpl ();
      health.checkHealthStatus (args);
   }

}
