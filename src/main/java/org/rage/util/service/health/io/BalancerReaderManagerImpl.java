package org.rage.util.service.health.io;


import org.apache.commons.io.FileUtils;
import org.rage.util.service.health.pojo.Balancer;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.util.HealthCheckerConstants;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * VIPReaderManagerImpl represents ...
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class BalancerReaderManagerImpl implements ReaderManager
{
   private final String          fileName;
   private List <HealthArtifact> artifacts;


   /**
    * Constructs an instance of VIPReaderManagerImpl object.
    * 
    * @param value
    */
   public BalancerReaderManagerImpl (final String value)
   {
      this.fileName = value;
      readFile ();
   }


   /**
    * Overrides readFile
    * 
    * @since Oct 24, 2014
    * @see org.rage.util.service.health.io.ReaderManager#readFile()
    */
   private void readFile ()
   {
      final File file = new File (fileName);
      try
      {
         final List <String> lines = FileUtils.readLines (file, "UTF-8");
         artifacts = new ArrayList <HealthArtifact> ();

         for (final String line : lines)
         {
            if (ReaderHelper.includeLine (line))
            {
               artifacts.add (new Balancer (line, HealthCheckerConstants.BALANCER_PORT));
            }
         }
      }
      catch (final Exception e)
      {
         System.err.println (e.getMessage ());
         e.printStackTrace ();
      }
   }


   /**
    * Overrides getServiceList
    * 
    * @return artifacts
    * @since Oct 24, 2014
    * @see org.rage.util.service.health.io.ReaderManager#getServiceList()
    */
   @Override
   public List <HealthArtifact> getServiceList ()
   {
      return artifacts;
   }

}
