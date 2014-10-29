package org.rage.util.service.health.service;


/**
 * ConsoleHealthChecker represents ...
 * 
 * @author <a href="mailto:hmendoza@24hourfit.com">Hector Mendoza</a>
 * @version $Id$
 * @since Oct 29, 2014
 * 
 */
public class ConsoleHealthChecker
{

   /**
    * Executes a main flow 1- normal servers, 2- Balancers
    * 
    * @param args
    * @since Oct 29, 2014
    * 
    */
   public static void main (final String[] args)
   {
      System.out.println ("Starting...");
      final HealthCheckerService hcs = new HealthCheckerService ();
      hcs.setPrintToFile (Boolean.FALSE);
      hcs.executeMainFlow (args);
      // hcs.checkServersHealth (args[0]);
      // hcs.checkBalancersHealth (args[1]);
      System.out.println ("Finished");
   }

}
