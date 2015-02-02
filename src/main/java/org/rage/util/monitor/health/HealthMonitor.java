package org.rage.util.monitor.health;


import org.rage.util.model.health.HealthArtifact;

import java.util.List;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public interface HealthMonitor
{

   /**
    * Represents runAllAndWait
    *
    * @param healthMonitorType
    * @return list
    * @since 02/02/2015
    *
    */
   List <HealthArtifact> runAllAndWait (HealthMonitorType healthMonitorType);
}
