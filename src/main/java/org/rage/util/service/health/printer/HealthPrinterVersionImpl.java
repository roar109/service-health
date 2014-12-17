package org.rage.util.service.health.printer;

import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Project;
import org.rage.util.service.health.pojo.ProjectExtended;

import java.io.PrintStream;

/**
 * HealthPrinterVersionImpl
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class HealthPrinterVersionImpl implements HealthPrinter {

	/**
	 * Represents printHeaders
	 * 
	 * @param stream
	 * 
	 * @since Oct 29, 2014
	 * 
	 */
	public void printHeaders(final PrintStream stream) {
		
	}

	/**
	 * Represents printHeaders
	 * 
	 * @since Oct 29, 2014
	 * 
	 */
	public void printHeaders() {
		
	}

	/**
	 * Represents print
	 * 
	 * @param artifact
	 * @param stream
	 * @since Oct 29, 2014
	 * 
	 */
	public void print(final HealthArtifact artifact, final PrintStream stream) {

	}

	/**
	 * Represents print
	 * 
	 * @param artifact
	 * @param stream
	 * @since Dic 09, 2014
	 * 
	 */
	public void print(final Project artifact, final PrintStream stream) {
		printInternal(artifact, stream);
	}

	/**
	 * Represents print
	 * 
	 * @param artifact
	 * @since Oct 29, 2014
	 * 
	 */
	public void print(final HealthArtifact artifact) {

	}

	/**
	 * Represents print
	 * 
	 * @param artifact
	 * @param stream
	 * @since Dic 09, 2014
	 * 
	 */
	static void printInternal(final Project artifact, final PrintStream stream) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append("URL: ").append(artifact.getCompletePath())
				.append("\n");
		sb.append("Status: ").append(getActiveServerText(artifact.isStatus()))
				.append("\n");
		sb.append("Version Match?: ").append(getVersionMatchText(artifact))
				.append("\n");
		stream.append(sb.toString());
	}

	/**
	 * 
	 * @param active
	 * @return string
	 * */
	private static String getActiveServerText(final boolean active) {
		return active ? "ACTIVE" : "UNAVAILABLE";
	}

	/**
	 * 
	 * @param project
	 * @return string
	 * */
	private static String getVersionMatchText(final Project project) {
		if (project instanceof ProjectExtended) {
			final ProjectExtended pv = ((ProjectExtended) project);
			if ((pv.getTargetVersion() != null) && pv.isStatus()) {
				return pv.isSameVersion() ? "MATCH" : "NOT MATCH";
			}
		}
		return "";
	}
}
