package org.rage.util.health.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import org.rage.util.service.health.impl.WebsiteHealthServiceImpl;

import static java.util.concurrent.TimeUnit.*;

import java.util.Date;

public class WebsiteScheduleHealthMain {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public static void main(String[] args) {
		System.out.println("Starting: "+new Date());
		Runnable healthCheckJob = () -> { System.out.println(new Date()); new WebsiteHealthServiceImpl().checkHealthStatus(args); };
		final ScheduledFuture<?> beeperHandle =  scheduler.scheduleAtFixedRate(healthCheckJob, 1, 5, MINUTES);
		try {
			System.out.println("-- "+new Date());
			Thread.sleep(1000*60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
