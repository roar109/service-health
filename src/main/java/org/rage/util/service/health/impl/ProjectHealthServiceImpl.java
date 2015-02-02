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
 * ProjectHealthServiceImpl represents ...
 *
 * @author <a href="mailto:hector.mendoza@24hourfit.com">hector.mendoza</a>
 * @version $Id$
 * @since 02/02/2015
 *
 * @todo Complete description
 */
public class ProjectHealthServiceImpl implements HealthService
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
      readArtifacts (arguments[0]);
      checkArtifactsHealth ();
      logArtifacts ();
   }


   private void readArtifacts (final String fileName)
   {
      final FileReader fileReader = FileReaderFactory.createFileReader (FileReaderType.PROJECT, fileName);
      artifacts.addAll (fileReader.getServiceList ());
   }


   private void checkArtifactsHealth ()
   {
      (new HealthMonitorImpl (artifacts)).runAllAndWait (HealthMonitorType.PROJECT);
   }


   private void logArtifacts ()
   {
      final HealthPrinter printer = HealthPrinterFactory.instance (HealthPrinterType.PROJECT_HEALTH);
      printer.printHeaders ();

      for (final HealthArtifact artifact : artifacts)
      {
         printer.print (artifact);
      }
   }

}
