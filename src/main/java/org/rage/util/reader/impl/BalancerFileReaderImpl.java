package org.rage.util.reader.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.reader.FileReader;
import org.rage.util.reader.util.ReaderHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * BalancerFileReaderImpl represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 */
public class BalancerFileReaderImpl implements FileReader
{
   private String                      fileName  = null;
   private final List <HealthArtifact> artifacts = new ArrayList <HealthArtifact> ();


   /**
    * Constructs an instance of BalancerFileReaderImpl object.
    *
    * @param fileName
    */
   public BalancerFileReaderImpl (final String fileName)
   {
      this.fileName = fileName;
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
      try
      {
         final Optional<List <String>> optionalLines = ReaderHelper.getLinesFromFile (fileName);

         optionalLines.ifPresent(lines -> lines.stream().forEach(line -> {
             if (ReaderHelper.includeLine (line)){
                artifacts.add (new HealthArtifact (line, ReaderHelper.getBalancerPort ()));
             }
         }));
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
    */
   public List <HealthArtifact> getServiceList ()
   {
      return artifacts;
   }
}
