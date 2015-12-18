package org.rage.util.printer.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.apache.commons.lang3.StringUtils;
import org.rage.util.model.health.HealthArtifact;
import org.rage.util.printer.HealthPrinter;
import org.rage.util.printer.HealthPrinterConstants;
import org.rage.util.service.health.util.PrintStreamDecorator;

public class WebsiteHealthPrinterImpl implements HealthPrinter {
	private static PrintStream DEFAULT_STREAM = System.out;
	private PrintStream outputStream = null;
	private boolean toFile = Boolean.FALSE;
	private String resultsPath = null;

	@Override
	public void printHeaders() {
		getCurrentStream().append("");

	}

	@Override
	public void print(final HealthArtifact artifact) {
		final StringBuilder sb = new StringBuilder();
		sb.append("URL: ").append(artifact.getServer()).append("\n");
		sb.append("Status: ").append(artifact.isStatus()).append("\n\n");
		;
		getCurrentStream().append(sb.toString());
	}

	@Override
	public void setPrintToFile(final boolean toFile) {
		this.toFile = toFile;
	}

	@Override
	public PrintStreamDecorator getCurrentStream() {
		if (toFile) {
			PrintStreamDecorator decorator = null;
			try {
				if (outputStream == null) {
					resultsPath = StringUtils.isNoneEmpty(resultsPath) ? resultsPath
							: HealthPrinterConstants.DEFAULT_FILENAME;
					outputStream = new PrintStream(new File(resultsPath));
				}
				decorator = new PrintStreamDecorator(DEFAULT_STREAM, outputStream);
			} catch (final FileNotFoundException e) {
				/***/
			}
			return decorator;
		}
		return new PrintStreamDecorator(DEFAULT_STREAM);
	}

	@Override
	public void setResultsPath(String resultsPath) {
		this.resultsPath = resultsPath;
	}

}
