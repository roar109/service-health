package org.rage.util.monitor.health.util;

import org.rage.util.service.health.pojo.ProjectExtended;

/**
 * @author <roar109@gmail.com> Hector Mendoza
 * 
 */
public final class MonitorTransformerHelper {
	private static final String IMPLEMENTATION_VERSION = "Implementation-Version";

	/**
	 * @param project
	 * */
	public static void checkVersion(final ProjectExtended project) {
		if ((project != null) && project.isStatus()
				&& !project.getAttributes().isEmpty()) {
			if (project.getAttributes().containsKey(IMPLEMENTATION_VERSION)
					&& (project.getAttributes().get(IMPLEMENTATION_VERSION) != null)
					&& (project.getTargetVersion() != null)
					&& project.getAttributes().get(IMPLEMENTATION_VERSION)
							.equals(project.getTargetVersion())) {
				project.setSameVersion(Boolean.TRUE);
			}
		}
	}
}
