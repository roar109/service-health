/*
 * Copyright � 2000 - 2008 24 Hour Fitness. All rights reserved.
 */
package org.rage.util.health.main;


import org.rage.util.service.health.HealthService;
import org.rage.util.service.health.impl.ProjectHealthServiceImpl;


/**
 * ProjectHealthMain represents ...
 *
 * @author <a href="mailto:hector.mendoza@24hourfit.com">hector.mendoza</a>
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
      service.checkHealthStatus (new String[] {"example-files\\project-list.txt"});

   }

}
