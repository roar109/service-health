package org.rage.util.service.health.impl;


import org.rage.util.monitor.health.HealthMonitorType;
import org.rage.util.printer.HealthPrinterType;
import org.rage.util.reader.FileReaderType;
import org.rage.util.service.health.HealthService;


/**
 * ProjectHealthServiceImpl represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public class ProjectHealthServiceImpl extends HealthServiceBase implements HealthService
{

   /**
    * Overrides checkHealthStatus
    *
    * @param arguments
    * @since 02/02/2015
    * @see org.rage.util.service.health.HealthService#checkHealthStatus(java.lang.String[])
    */
   public void checkHealthStatus (final String[] arguments)
   {
      validateArguments (arguments);
      readArtifacts (arguments[0], FileReaderType.PROJECT);
      checkArtifactsHealth (HealthMonitorType.PROJECT);
      logArtifacts (HealthPrinterType.PROJECT_HEALTH);
   }

}
