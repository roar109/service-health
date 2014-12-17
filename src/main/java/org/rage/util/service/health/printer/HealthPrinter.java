package org.rage.util.service.health.printer;

import java.io.PrintStream;

import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Project;

public interface HealthPrinter {
	void printHeaders ();
	void printHeaders (final PrintStream stream);
	void print (final HealthArtifact artifact, final PrintStream stream);
	void print (final HealthArtifact artifact);
	void print (final Project artifact, final PrintStream stream);
}
