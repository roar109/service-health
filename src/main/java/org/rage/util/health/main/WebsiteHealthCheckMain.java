package org.rage.util.health.main;

import org.rage.util.service.health.HealthService;
import org.rage.util.service.health.impl.WebsiteHealthServiceImpl;

public class WebsiteHealthCheckMain {

	public static void main(String[] args) {
		final HealthService healthService = new WebsiteHealthServiceImpl();
		healthService.checkHealthStatus(args);
	}

}
