/**
 * 
 */
package org.rage.util.monitor.health.impl;

import org.rage.util.model.health.HealthArtifact;
import org.rage.util.monitor.health.HealthMonitorExecutor;

/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public class ProjectHealthMonitorImpl implements HealthMonitorExecutor {
	private HealthArtifact healthArtifact;
	
	public ProjectHealthMonitorImpl(final HealthArtifact healthArtifact){
		this.healthArtifact = healthArtifact;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub

	}

}
