package org.rage.util.reader.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.reader.FileReader;
import org.rage.util.reader.FileReaderConstants;
import org.rage.util.reader.util.ReaderHelper;

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
   private final String                fileName;
   private final List <HealthArtifact> artifacts = new ArrayList <HealthArtifact> ();


   /**
    * Constructs an instance of ServerFileReaderImpl object.
    */
   public ServerFileReaderImpl (final String fileName)
   {
      this.fileName = fileName;
      readFile ();
   }


   /**
    * Overrides getServiceList
    * 
    * @since 30/01/2015
    * @see org.rage.util.reader.FileReader#getServiceList()
    */
   public void readFile ()
   {
      try
      {
         final List <String> lines = ReaderHelper.getLinesFromFile (fileName);

         for (final String line : lines)
         {
            if (ReaderHelper.includeLine (line))
            {
               final String[] data = line.split (",");
               int port = FileReaderConstants.SERVER_DEFAULT_PORT;
               if (data.length > 1)
               {
                  port = new Integer (data[1]);
               }
               artifacts.add (new HealthArtifact (data[0], port));
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
      readFile ();// TODO check this - do it different
      return artifacts;
   }
}
