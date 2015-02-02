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
import org.rage.util.service.health.HealthService;

import java.util.ArrayList;
import java.util.List;


/**
 * ServerHealthServiceImpl represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public class ServerHealthServiceImpl implements HealthService
{
   private final List <HealthArtifact> artifacts = new ArrayList <HealthArtifact> ();


   /**
    * Overrides checkHealthStatus
    *
    * @param arguments
    * @since 02/02/2015
    * @see org.rage.util.service.health.HealthService#checkHealthStatus(java.lang.String[])
    */
   public void checkHealthStatus (final String[] arguments)
   {
      readArtifacts (arguments[0], Boolean.FALSE);
      if (arguments.length > 1)
      {
         readArtifacts (arguments[1], Boolean.TRUE);
      }
      checkArtifactsHealth ();
      logArtifacts ();
   }


   private void readArtifacts (final String fileName, final boolean isBalancer)
   {
      final FileReader fileReader = FileReaderFactory.createFileReader (isBalancer
            ? FileReaderType.BALANCER
            : FileReaderType.SERVER, fileName);
      artifacts.addAll (fileReader.getServiceList ());
   }


   private void checkArtifactsHealth ()
   {
      (new HealthMonitorImpl (artifacts)).runAllAndWait (HealthMonitorType.SERVER);
   }


   private void logArtifacts ()
   {
      final HealthPrinter printer = HealthPrinterFactory.instance (HealthPrinterType.SERVICE_HEALTH);
      printer.printHeaders ();

      for (final HealthArtifact artifact : artifacts)
      {
         printer.print (artifact);
      }

   }
}
