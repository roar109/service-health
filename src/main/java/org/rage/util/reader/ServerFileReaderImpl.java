package org.rage.util.reader;


import org.apache.commons.io.FileUtils;
import org.rage.util.reader.util.ReaderHelper;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Service;
import org.rage.util.service.health.util.HealthCheckerConstants;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * ServerFileReaderImpl represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 * @todo Complete description
 */
public class ServerFileReaderImpl implements FileReader
{
   private String                fileName;
   private List <HealthArtifact> artifacts;


   /**
    * Constructs an instance of ServerReaderManagerImpl object.
    *
    * @param value
    */
   public ServerFileReaderImpl (final String value)
   {
      this.fileName = value;
      readFile ();
   }


   /**
    * Constructs an instance of ServerFileReaderImpl object.
    */
   public ServerFileReaderImpl ()
   {
      // TODO Auto-generated constructor stub

   }


   /**
    * Overrides getServiceList
    *
    * @since 30/01/2015
    * @see org.rage.util.reader.FileReader#getServiceList()
    */
   public void readFile ()
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
               final String[] data = line.split (",");
               int port = HealthCheckerConstants.SERVER_DEFAULT_PORT;
               if (data.length > 1)
               {
                  port = new Integer (data[1]);
               }
               artifacts.add (new Service (data[0], port));
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
