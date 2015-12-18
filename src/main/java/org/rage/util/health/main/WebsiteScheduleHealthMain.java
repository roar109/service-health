package org.rage.util.health.main;

import static java.util.concurrent.TimeUnit.MINUTES;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.rage.util.service.health.impl.WebsiteHealthServiceImpl;

public class WebsiteScheduleHealthMain {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public static void main(String[] args) {
		System.out.println("Starting: "+new Date());
		Runnable healthCheckJob = () -> { System.out.println(new Date()); new WebsiteHealthServiceImpl().checkHealthStatus(args); };
		scheduler.scheduleAtFixedRate(healthCheckJob, 1, 5, MINUTES);
	}

}
