package org.rage.util.reader.impl;

import org.rage.util.model.health.HealthArtifact;
import org.rage.util.reader.FileReader;
import org.rage.util.reader.util.ReaderHelper;
import org.rage.util.service.health.util.HealthCheckerConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * BalancerFileReaderImpl represents ...
 * 
 * @author hector mendoza
 * @version $Id$
 * @since 30/01/2015
 * 
 * @todo Complete description
 */
public class BalancerFileReaderImpl implements FileReader {
	private String fileName = null;
	private List<HealthArtifact> artifacts = new ArrayList<HealthArtifact>();

	/**
	 * Constructs an instance of BalancerFileReaderImpl object.
	 */
	public BalancerFileReaderImpl(final String fileName) {
		this.fileName = fileName;
		readFile();
	}

	/**
	 * Overrides readFile
	 * 
	 * @since Oct 24, 2014
	 * @see org.rage.util.service.health.io.ReaderManager#readFile()
	 */
	private void readFile() {
		try {
			final List<String> lines = ReaderHelper.getLinesFromFile(fileName);

			for (final String line : lines) {
				if (ReaderHelper.includeLine(line)) {
					artifacts.add(new HealthArtifact(line,
							HealthCheckerConstants.BALANCER_PORT));
				}
			}
		} catch (final Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Overrides getServiceList
	 * 
	 * @return artifacts
	 * @since Oct 24, 2014
	 * @see org.rage.util.service.health.io.ReaderManager#getServiceList()
	 */
	public List<HealthArtifact> getServiceList() {
		return artifacts;
	}
}
