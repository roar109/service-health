package org.rage.util.service.health.checker;

import java.io.IOException;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.rage.util.service.health.pojo.ProjectExtended;
import org.rage.util.service.health.util.AppVersionParserHelper;


public class AppVersionCheckerChild implements Runnable {

	private final ProjectExtended project;
	private final static String APP_VERSION = "AppVersion";
	private final static String URL_SEPARATOR = "/";
	private final static String PROTOCOL = "http";
	private final static String GET_AS_XML = "?viewXml=y";

	/**
	 * @param projectValue
	 * */
	public AppVersionCheckerChild(final ProjectExtended projectValue) {
		this.project = projectValue;
	}

	private String getCompleteUrl() {
		return PROTOCOL + ":" + URL_SEPARATOR + URL_SEPARATOR
				+ project.getServer() + ":" + project.getPort() + URL_SEPARATOR
				+ project.getProjectContext() + URL_SEPARATOR + APP_VERSION+GET_AS_XML;
	}

	private boolean hostAvailabilityCheck() {
		try {
			project.setCompletePath(getCompleteUrl());
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			final HttpGet httpget = new HttpGet(project.getCompletePath());
			final ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse arg0)
						throws ClientProtocolException, IOException {
					final int status = arg0.getStatusLine().getStatusCode();
					if ((status >= 200) && (status < 300)) {
						final HttpEntity entity = arg0.getEntity();
						return entity != null ? EntityUtils.toString(entity)
								: null;
					}
					throw new ClientProtocolException(
							"Unexpected response status: " + status);
				}

			};
			httpclient.execute(httpget, responseHandler);
			AppVersionParserHelper.parseAddress(project);
			return true;
		} catch (final Exception ex) {
			/* ignore */
		}
		return false;
	}

	/**
	 * Overrides run
	 *
	 * @since 09/12/2014
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.project.setStatus(hostAvailabilityCheck());
		AppVersionCheckerHelper.checkVersion(project);
	}

}
