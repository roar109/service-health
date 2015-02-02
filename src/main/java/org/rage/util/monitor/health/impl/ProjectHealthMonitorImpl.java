/**
 *
 */
package org.rage.util.monitor.health.impl;


import org.apache.commons.lang3.StringUtils;
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
import org.rage.util.monitor.health.util.MonitorHelper;

import java.io.IOException;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public class ProjectHealthMonitorImpl implements HealthMonitorExecutor
{
   private final HealthArtifact healthArtifact;
   private final boolean        useVersionMatcher;


   /**
    * Constructs an instance of ProjectHealthMonitorImpl object.
    *
    * @param healthArtifact
    */
   public ProjectHealthMonitorImpl (final HealthArtifact healthArtifact)
   {
      this.healthArtifact = healthArtifact;
      if (StringUtils.isNoneBlank (healthArtifact.getProject ().getTargetVersion ()))
      {
         useVersionMatcher = Boolean.TRUE;
      }
      else
      {
         useVersionMatcher = Boolean.FALSE;
      }
   }


   /**
    * Overrides run
    *
    * @since 02/02/2015
    * @see java.lang.Runnable#run()
    */
   public void run ()
   {
      final boolean hostActive = hostAvailabilityCheck ();
      healthArtifact.setStatus (hostActive);

      if (useVersionMatcher)
      {
         MonitorHelper.checkVersion (healthArtifact);
      }
   }


   private boolean hostAvailabilityCheck ()
   {
      try
      {
         if (useVersionMatcher)
         {
            MonitorHelper.setCompleteURLVersion (healthArtifact);
         }
         else
         {
            MonitorHelper.setCompleteURL (healthArtifact);
         }

         final CloseableHttpClient httpclient = HttpClients.createDefault ();
         final HttpGet httpget = new HttpGet (healthArtifact.getCompletePath ());
         final ResponseHandler <String> responseHandler = new ResponseHandler <String> ()
         {
            public String handleResponse (final HttpResponse arg0) throws ClientProtocolException, IOException
            {
               final int status = arg0.getStatusLine ().getStatusCode ();
               if ( (status >= 200) && (status < 300))
               {
                  final HttpEntity entity = arg0.getEntity ();
                  return entity != null ? EntityUtils.toString (entity) : null;
               }
               throw new ClientProtocolException ("Unexpected response status: " + status);
            }

         };
         httpclient.execute (httpget, responseHandler);

         if (useVersionMatcher)
         {
            MonitorHelper.parseAddress (healthArtifact);
         }
         return true;
      }
      catch (final Exception ex)
      {
         /* ignore */
      }
      return false;
   }
}
