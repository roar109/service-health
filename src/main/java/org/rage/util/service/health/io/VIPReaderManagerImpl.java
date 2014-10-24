package org.rage.util.service.health.io;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Service;
import org.rage.util.service.health.util.HealthCheckerConstants;

import java.io.File;
import java.io.IOException;

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
public class VIPReaderManagerImpl implements ReaderManager
{
   private final String          fileName;
   private List <HealthArtifact> artifacts;


   /**
    * Constructs an instance of VIPReaderManagerImpl object.
    * 
    * @param value
    */
   public VIPReaderManagerImpl (final String value)
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
            if (StringUtils.isNotBlank (line) && ReaderHelper.includeLine (line))
            {
               artifacts.add (new Service (line, HealthCheckerConstants.BALANCER_PORT));
            }
         }
      }
      catch (final IOException e)
      {
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
