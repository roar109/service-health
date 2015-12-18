package org.rage.util.monitor.health.impl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.rage.util.model.health.HealthArtifact;
import org.rage.util.monitor.health.HealthMonitorExecutor;

public class WebsiteHealthMonitorImpl implements HealthMonitorExecutor {
	private final HealthArtifact healthArtifact;

	public WebsiteHealthMonitorImpl(final HealthArtifact healthArtifact) {
		this.healthArtifact = healthArtifact;
	}

	@Override
	public void run() {
		boolean activeWebsite = checkWebsiteAvailability();
		healthArtifact.setStatus(activeWebsite);
	}

	private boolean checkWebsiteAvailability() {
		try {
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			final HttpGet httpget = new HttpGet(healthArtifact.getServer());
			final ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse arg0) throws ClientProtocolException, IOException {
					final int status = arg0.getStatusLine().getStatusCode();
					if ((status >= 200) && (status < 300)) {
						final HttpEntity entity = arg0.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					}
					throw new ClientProtocolException("Unexpected response status: " + status);
				}

			};
			httpclient.execute(httpget, responseHandler);
			return Boolean.TRUE;
		} catch (Exception ex) {
			/* ignore */
		}
		return Boolean.FALSE;
	}

}
