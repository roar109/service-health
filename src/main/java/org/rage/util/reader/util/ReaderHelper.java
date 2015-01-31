package org.rage.util.reader.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Helper utility with common functions to read files.
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 * 
 */
public final class ReaderHelper {
	/**
	 * Check the passed string against some basic validates to discard white
	 * spaces and comments.
	 * 
	 * @param line
	 * @return boolean
	 * @since 30/01/2015
	 * 
	 */
	public static boolean includeLine(final String line) {
		if (StringUtils.isBlank(line)) {
			return false;
		}
		final String lineFormatted = StringUtils.strip(line);
		final boolean comment = StringUtils.startsWith(lineFormatted, "#");
		return comment ? false : true;
	}

	public static List<String> getLinesFromFile(String fileName) {
		File file = new File(fileName);
		if (!file.exists())
			throw new IllegalArgumentException("File doesnt exist!");
		try {
			return FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
