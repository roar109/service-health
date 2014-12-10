package org.rage.util.service.health.service;


/**
 * ConsoleHealthChecker represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 29, 2014
 * 
 * @TODO Try to merge with the ConsoleProjectHealthChecker
 *
 */
public class ConsoleAppVersionChecker
{
   private static final String TO_FILE_PARAMETERNAME = "toFile";
   private static final String PATH_RESULTS          = "resultsPath";


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

         if (System.getProperty (PATH_RESULTS) != null)
         {
            System.out.println ("Using output filename " + System.getProperty (PATH_RESULTS));
            hcs.setResultsPath (System.getProperty (PATH_RESULTS));
         }
      }

      hcs.setPrintToFile (printToFile);
      hcs.executeAppVersionFlow(args);

      System.out.println ("Finished");
   }
}
