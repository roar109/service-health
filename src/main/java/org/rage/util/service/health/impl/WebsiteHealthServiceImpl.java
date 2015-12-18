package org.rage.util.service.health.impl;

import org.rage.util.monitor.health.HealthMonitorType;
import org.rage.util.printer.HealthPrinterType;
import org.rage.util.reader.FileReaderType;
import org.rage.util.service.health.HealthService;

public class WebsiteHealthServiceImpl extends HealthServiceBase implements HealthService {

	@Override
	public void checkHealthStatus(String[] arguments) {
		validateArguments(arguments);
		readArtifacts(arguments[0], FileReaderType.WEBSITE);
		checkArtifactsHealth(HealthMonitorType.WEBSITE);
		logArtifacts(HealthPrinterType.WEBSITE);
	}

}
