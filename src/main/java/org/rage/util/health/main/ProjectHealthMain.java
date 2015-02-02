package org.rage.util.health.main;


import org.rage.util.service.health.HealthService;
import org.rage.util.service.health.impl.ProjectHealthServiceImpl;


/**
 * ProjectHealthMain represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 * @todo Complete description
 */
public class ProjectHealthMain
{

   /**
    * Represents main
    *
    * @param args
    * @since 02/02/2015
    *
    * @todo complete description
    */
   public static void main (final String[] args)
   {
      final HealthService service = new ProjectHealthServiceImpl ();
      service.checkHealthStatus (args);

   }

}
