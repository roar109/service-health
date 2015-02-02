package org.rage.util.health.main;


import org.rage.util.service.health.HealthService;
import org.rage.util.service.health.impl.ServerHealthServiceImpl;


/**
 * ServerHealthMain represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public class ServerHealthMain
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
      final HealthService service = new ServerHealthServiceImpl ();
      service.checkHealthStatus (args);
   }
}
