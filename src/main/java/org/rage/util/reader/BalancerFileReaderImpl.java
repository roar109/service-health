package org.rage.util.reader;


import org.apache.commons.io.FileUtils;
import org.rage.util.reader.util.ReaderHelper;
import org.rage.util.service.health.pojo.Balancer;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.util.HealthCheckerConstants;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * BalancerFileReaderImpl represents ...
 *
 * @author hector mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 * @todo Complete description
 */
public class BalancerFileReaderImpl implements FileReader
{
   private String                fileName = null;
   private List <HealthArtifact> artifacts;


   /**
    * Constructs an instance of VIPReaderManagerImpl object.
    *
    * @param value
    */
   public BalancerFileReaderImpl (final String value)
   {
      this.fileName = value;
      readFile ();
   }


   /**
    * Constructs an instance of BalancerFileReaderImpl object.
    */
   public BalancerFileReaderImpl ()
   {
      // TODO Auto-generated constructor stub
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
   public List <HealthArtifact> getServiceList ()
   {
      return artifacts;
   }
}
