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
import org.rage.util.service.health.util.HealthServiceHelper;
import org.rage.util.service.health.util.ValidationHealthServiceHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Hector Mendoza
 * @since 02/02/2015
 *
 */
public class HealthServiceBase {

	private boolean printToFile = Boolean.FALSE;
	private String resultsPath = null;
	final List<HealthArtifact> artifacts = new ArrayList<HealthArtifact>();

	public HealthServiceBase() {
		printToFile = HealthServiceHelper.checkExportAsFileProperty();

		if (printToFile) {
			resultsPath = HealthServiceHelper.getResultsPath();
		}
	}

	/**
	 * Validate the passed argument list.
	 *
	 * @param arguments
	 * @since 03/02/2015
	 *
	 */
	public void validateArguments(final String[] arguments) {
		ValidationHealthServiceHelper.validateArguments(arguments);
	}

	/**
	 *
	 * @param fileName
	 * @param fileReaderType
	 * @since 02/02/2015
	 *
	 */
	public void readArtifacts(final String fileName, final FileReaderType fileReaderType) {
		final Optional<FileReader> fileReaderOptional = FileReaderFactory.createFileReader(fileReaderType, fileName);
		fileReaderOptional.ifPresent(fileReader -> {
			artifacts.addAll(fileReader.getServiceList());
		});
	}

	/**
	 *
	 * @param healthMonitorType
	 * @since 02/02/2015
	 *
	 */
	public void checkArtifactsHealth(final HealthMonitorType healthMonitorType) {
		(new HealthMonitorImpl(artifacts)).runAllAndWait(healthMonitorType);
	}

	/**
	 *
	 * @param healthPrinterType
	 * @since 02/02/2015
	 *
	 */
	public void logArtifacts(final HealthPrinterType healthPrinterType) {
		final HealthPrinter printer = HealthPrinterFactory.instance(healthPrinterType);
		printer.setPrintToFile(printToFile);
		printer.setResultsPath(resultsPath);
		printer.printHeaders();
		artifacts.stream().forEach(artifact -> {
			printer.print(artifact);
		});
	}

}
