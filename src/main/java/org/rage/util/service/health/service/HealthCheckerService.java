package org.rage.util.service.health.service;


import org.rage.util.service.health.checker.ServiceHealthCheckerMain;
import org.rage.util.service.health.io.BalancerReaderManagerImpl;
import org.rage.util.service.health.io.ReaderManager;
import org.rage.util.service.health.io.ServerReaderManagerImpl;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.util.OutputResultHelper;
import org.rage.util.service.health.util.PrintHealthHelper;

import java.io.PrintStream;

import java.util.List;


/**
 * Main class to check the health of some servers
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class HealthCheckerService
{
   private boolean     printToFile  = Boolean.FALSE;
   private PrintStream outputStream = null;


   /**
    * Represents main
    * 
    * @param args
    * @since Oct 24, 2014
    * 
    */
   public void executeMainFlow (final String[] args)
   {
      checkPrintStream ();
      if (args.length == 0)
      {
         outputStream.println ("No files specified");
         System.exit (1);
      }
      outputStream.println ("Starting health service\n");
      checkServersHealth (args[0]);
      if (args.length < 2)
      {
         return;
      }
      outputStream.println ();
      checkBalancersHealth (args[1]);
      outputStream.println ("\nFinish health service");
   }


   /**
    * Represents checkServersHealth
    * 
    * @param fileName
    * @since Oct 29, 2014
    * 
    */
   public void checkBalancersHealth (final String fileName)
   {
      checkPrintStream ();
      final ReaderManager svsBalancer = new BalancerReaderManagerImpl (fileName);
      final ServiceHealthCheckerMain checkerVIP = new ServiceHealthCheckerMain (svsBalancer.getServiceList ());
      final List <HealthArtifact> artifactsVip = checkerVIP.runAllAndWait ();
      PrintHealthHelper.printHeaders (outputStream);
      for (final HealthArtifact artifact : artifactsVip)
      {
         PrintHealthHelper.print (artifact, outputStream);
      }
   }


   /**
    * Represents checkServersHealth
    * 
    * @param fileName
    * @since Oct 29, 2014
    * 
    */
   public void checkServersHealth (final String fileName)
   {
      checkPrintStream ();
      final ReaderManager svs = new ServerReaderManagerImpl (fileName);
      final ServiceHealthCheckerMain checker = new ServiceHealthCheckerMain (svs.getServiceList ());
      final List <HealthArtifact> artifacts = checker.runAllAndWait ();
      PrintHealthHelper.printHeaders (outputStream);
      for (final HealthArtifact artifact : artifacts)
      {
         PrintHealthHelper.print (artifact, outputStream);
      }
   }


   private void checkPrintStream ()
   {
      if (outputStream != null)
      {
         return;
      }
      if (printToFile)
      {
         outputStream = OutputResultHelper.instance ().getOutputResults ();
      }
      else
      {
         outputStream = System.out;
      }
   }


   /**
    * @return the printToFile
    */
   public boolean isPrintToFile ()
   {
      return printToFile;
   }



   /**
    * If all output results are appended to a results.txt file. Each time the file is replaced.
    * 
    * @param value the printToFile to set
    */
   public void setPrintToFile (final boolean value)
   {
      this.printToFile = value;
   }
}
