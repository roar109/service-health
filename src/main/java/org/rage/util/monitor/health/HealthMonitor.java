/**
 * 
 */
package org.rage.util.monitor.health;

import java.util.List;

import org.rage.util.model.health.HealthArtifact;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public interface HealthMonitor {

	List <HealthArtifact> runAllAndWait (HealthMonitorType healthMonitorType);
}
