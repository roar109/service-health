package org.rage.util.service.health.service;


import org.rage.util.service.health.checker.AppVersionCheckerMain;
import org.rage.util.service.health.checker.ProjectHealthCheckMain;
import org.rage.util.service.health.checker.ServiceHealthCheckerMain;
import org.rage.util.service.health.io.BalancerReaderManagerImpl;
import org.rage.util.service.health.io.ProjectReaderManagerImpl;
import org.rage.util.service.health.io.ReaderManager;
import org.rage.util.service.health.io.ServerReaderManagerImpl;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Project;
import org.rage.util.service.health.pojo.ProjectExtended;
import org.rage.util.service.health.printer.HealthPrinter;
import org.rage.util.service.health.printer.HealthPrinterFactory;
import org.rage.util.service.health.printer.HealthPrinterType;
import org.rage.util.service.health.util.OutputResultHelper;

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
   private String      resultsPath  = null;
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
         outputStream.println ("No file specified to analyze. Shutdown program...");
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
    * @param args
    * */
   public void executeProjectFlow (final String[] args)
   {
      checkPrintStream ();
      if (args.length == 0)
      {
         outputStream.println ("No file specified to analyze. Shutdown program...");
         System.exit (1);
      }
      outputStream.println ("Starting health service\n");
      checkProjectHealth (args[0]);
      outputStream.println ("\nFinish health service");
   }


   /**
    * @param args
    * */
   public void executeAppVersionFlow (final String[] args)
   {
      checkPrintStream ();
      if (args.length == 0)
      {
         outputStream.println ("No file specified to analyze. Shutdown program...");
         System.exit (1);
      }
      outputStream.println ("Starting health service\n");
      checkAppVersionHealth (args[0]);
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

      HealthPrinter printer = HealthPrinterFactory.instance(HealthPrinterType.SERVICE_HEALTH);
      printer.printHeaders (outputStream);
      for (final HealthArtifact artifact : artifactsVip)
      {
    	  printer.print (artifact, outputStream);
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

      HealthPrinter printer = HealthPrinterFactory.instance(HealthPrinterType.SERVICE_HEALTH);
      printer.printHeaders (outputStream);
      for (final HealthArtifact artifact : artifacts)
      {
    	  printer.print (artifact, outputStream);
      }
   }


   /**
    * Represents checkServersHealth
    *
    * @param fileName
    * @since Dic 9, 2014
    *
    */
   public void checkProjectHealth (final String fileName)
   {
      checkPrintStream ();
      final ProjectReaderManagerImpl svs = new ProjectReaderManagerImpl (fileName);
      final ProjectHealthCheckMain checker = new ProjectHealthCheckMain (svs.getServiceList ());
      final List <ProjectExtended> artifacts = checker.runAllAndWait ();

      HealthPrinter printer = HealthPrinterFactory.instance(HealthPrinterType.PROJECT_HEALTH);
      printer.printHeaders (outputStream);
      for (final Project artifact : artifacts)
      {
    	  printer.print (artifact, outputStream);
      }
   }


   /**
    * Represents checkAppVersionHealth
    *
    * @param fileName
    * @since 10/12/2014
    *
    */
   public void checkAppVersionHealth (final String fileName)
   {
      checkPrintStream ();
      final ProjectReaderManagerImpl svs = new ProjectReaderManagerImpl (fileName, Boolean.TRUE);
      final AppVersionCheckerMain checker = new AppVersionCheckerMain (svs.getServiceList ());
      final List <ProjectExtended> artifacts = checker.runAllAndWait ();
      
      HealthPrinter printer = HealthPrinterFactory.instance(HealthPrinterType.VERSION);
      for (final Project artifact : artifacts)
      {
    	  printer.print (artifact, outputStream);
      }
   }


   /**
    * Review if the output has been initialized. Checks the printToFile property.
    * */
   private void checkPrintStream ()
   {
      if (outputStream != null)
      {
         return;
      }
      if (printToFile)
      {
         if (resultsPath != null)
         {
            outputStream = OutputResultHelper.instance (resultsPath).getOutputResultsStream ();
         }
         else
         {
            outputStream = OutputResultHelper.instance ().getOutputResultsStream ();
         }
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


   /**
    * @return the resultsPath
    */
   public String getResultsPath ()
   {
      return resultsPath;
   }


   /**
    * @param value the resultsPath to set
    */
   public void setResultsPath (final String value)
   {
      this.resultsPath = value;
   }


}
