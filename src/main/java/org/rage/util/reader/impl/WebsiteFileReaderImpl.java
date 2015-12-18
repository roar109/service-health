package org.rage.util.reader.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rage.util.model.health.HealthArtifact;
import org.rage.util.reader.FileReader;
import org.rage.util.reader.util.ReaderHelper;

public class WebsiteFileReaderImpl implements FileReader {

	final String fileName;
	private final List<HealthArtifact> artifacts = new ArrayList<HealthArtifact>();

	public WebsiteFileReaderImpl(final String fileName) {
		this.fileName = fileName;
		readArtifactsFromFile();
	}

	private void readArtifactsFromFile() {
		final Optional<List<String>> optionalFileLines = ReaderHelper.getLinesFromFile(fileName);
		optionalFileLines.ifPresent(fileLines -> filterAndConvertArtifacts(fileLines));
	}

	private void filterAndConvertArtifacts(List<String> fileLines) {
		fileLines.stream().filter(line -> ReaderHelper.includeLine(line)).forEach(line -> {
			artifacts.add(new HealthArtifact(line));
		});
	}

	@Override
	public List<HealthArtifact> getServiceList() {
		return artifacts;
	}

}
