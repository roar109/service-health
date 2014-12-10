/*
 * Copyright © 2000 - 2008 24 Hour Fitness. All rights reserved.
 */
package org.rage.util.service.health.checker;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.rage.util.service.health.pojo.Project;

import java.io.IOException;


/**
 * ProjectCheckerHealthChild represents ...
 *
 * @author <a href="mailto:hector.mendoza@24hourfit.com">hector.mendoza</a>
 * @version $Id$
 * @since 09/12/2014
 *
 * @todo Complete description
 */
public class ProjectCheckerHealthChild implements Runnable
{
   private final Project       project;
   private final static String APP_VERSION   = "AppVersion";
   private final static String URL_SEPARATOR = "/";
   private final static String PROTOCOL      = "http";

   /**
    * @param projectValue
    * */
   public ProjectCheckerHealthChild (final Project projectValue)
   {
      this.project = projectValue;
   }


   private String getCompleteUrl ()
   {
      return PROTOCOL + ":" + URL_SEPARATOR + URL_SEPARATOR + project.getServer () + ":" + project.getPort ()
            + URL_SEPARATOR + project.getProjectContext () + URL_SEPARATOR + APP_VERSION;
   }


   private boolean hostAvailabilityCheck ()
   {
      try
      {
         project.setCompletePath (getCompleteUrl ());
         final CloseableHttpClient httpclient = HttpClients.createDefault ();
         final HttpGet httpget = new HttpGet (project.getCompletePath ());
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
         return true;
      }
      catch (final Exception ex)
      {
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
   public void run ()
   {
      this.project.setStatus (hostAvailabilityCheck ());
   }
}
