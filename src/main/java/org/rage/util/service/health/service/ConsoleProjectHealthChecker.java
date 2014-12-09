package org.rage.util.service.health.service;


/**
 * ConsoleHealthChecker represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 29, 2014
 *
 */
public class ConsoleProjectHealthChecker
{
   private static final String TO_FILE_PARAMETERNAME = "toFile";


   /**
    * @param args
    * */
   public static void main (final String[] args)
   {
      System.out.println ("Starting...");
      boolean printToFile = Boolean.FALSE;
      final HealthCheckerService hcs = new HealthCheckerService ();

      if (System.getProperty (TO_FILE_PARAMETERNAME) != null)
      {
         System.out.println ("Writing output to file...");
         printToFile = Boolean.TRUE;
      }

      hcs.setPrintToFile (printToFile);
      hcs.executeProjectFlow (args);

      System.out.println ("Finished");
   }
}
