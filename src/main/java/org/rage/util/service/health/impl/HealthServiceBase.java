package org.rage.util.service.health.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.monitor.health.HealthMonitorType;
import org.rage.util.monitor.health.impl.HealthMonitorImpl;
import org.rage.util.printer.HealthPrinter;
import org.rage.util.printer.HealthPrinterType;
import org.rage.util.printer.impl.HealthPrinterFactory;
import org.rage.util.reader.FileReader;
import org.rage.util.reader.FileReaderType;
import org.rage.util.reader.impl.FileReaderFactory;
import org.rage.util.service.health.util.HealthServiceHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * HealthServiceBase represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public class HealthServiceBase
{
   private boolean             printToFile = Boolean.FALSE;
   private String              resultsPath = null;
   /** HealthServiceBase for artifacts */
   final List <HealthArtifact> artifacts   = new ArrayList <HealthArtifact> ();


   /**
    * Constructs an instance of HealthServiceBase object.
    */
   public HealthServiceBase ()
   {
      printToFile = HealthServiceHelper.checkExportAsFileProperty ();

      if (printToFile)
      {
         resultsPath = HealthServiceHelper.getResultsPath ();
      }
   }


   /**
    * Represents logArtifacts
    *
    * @param healthPrinterType
    * @since 02/02/2015
    *
    */
   public void logArtifacts (final HealthPrinterType healthPrinterType)
   {
      final HealthPrinter printer = HealthPrinterFactory.instance (healthPrinterType);
      printer.printHeaders ();

      for (final HealthArtifact artifact : artifacts)
      {
         printer.print (artifact);
      }
   }


   /**
    * Represents checkArtifactsHealth
    *
    * @param healthMonitorType
    * @since 02/02/2015
    *
    */
   public void checkArtifactsHealth (final HealthMonitorType healthMonitorType)
   {
      (new HealthMonitorImpl (artifacts)).runAllAndWait (healthMonitorType);
   }


   /**
    * Represents readArtifacts
    *
    * @param fileName
    * @param fileReaderType
    * @since 02/02/2015
    *
    */
   public void readArtifacts (final String fileName, final FileReaderType fileReaderType)
   {
      final FileReader fileReader = FileReaderFactory.createFileReader (fileReaderType, fileName);
      artifacts.addAll (fileReader.getServiceList ());
   }
}
