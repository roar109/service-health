package org.rage.util.service.health.impl;


import org.rage.util.monitor.health.HealthMonitorType;
import org.rage.util.printer.HealthPrinterType;
import org.rage.util.reader.FileReaderType;
import org.rage.util.service.health.HealthService;


/**
 * ServerHealthServiceImpl represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public class ServerHealthServiceImpl extends HealthServiceBase implements HealthService
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
      readArtifacts (arguments[0], FileReaderType.SERVER);
      if (arguments.length > 1)
      {
         readArtifacts (arguments[1], FileReaderType.BALANCER);
      }
      checkArtifactsHealth (HealthMonitorType.SERVER);
      logArtifacts (HealthPrinterType.SERVICE_HEALTH);
   }
}
