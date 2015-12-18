package org.rage.util.reader.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.model.health.Project;
import org.rage.util.reader.FileReader;
import org.rage.util.reader.util.ReaderHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * ProjectFileReader represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 */
public class ProjectFileReaderImpl implements FileReader
{
   private final List <HealthArtifact> projects          = new ArrayList <HealthArtifact> ();
   private final String                fileName;
   private boolean                     readTargetVersion = Boolean.FALSE;


   /**
    * Constructs an instance of ProjectReaderManagerImpl object.
    * 
    * @param readTargetVersion
    */
   public ProjectFileReaderImpl (final boolean readTargetVersion, final String fileName)
   {
      this.readTargetVersion = readTargetVersion;
      this.fileName = fileName;
      readFile ();
   }


   /**
    * Read a file and transform its lines into HealthArtifacts
    * 
    * @since Oct 24, 2014
    */
   public void readFile ()
   {
      try
      {
         final Optional<List <String>> optionalLines = ReaderHelper.getLinesFromFile (fileName);

         optionalLines.ifPresent(lines -> lines.forEach(line -> {
        	 if (ReaderHelper.includeLine (line)){
                final String[] data = line.split (",");
                final HealthArtifact artifact = new HealthArtifact (data[0], new Integer (data[1]));
                if (readTargetVersion){
                   artifact.setProject (new Project (data[2], data[3]));
                   projects.add (artifact);
                }else{
                   artifact.setProject (new Project (data[2]));
                   projects.add (artifact);
                }
             }
         }));
      }
      catch (final Exception e){
         System.err.println (e.getMessage ());
         e.printStackTrace ();
      }

   }


   /**
    * Overrides getServiceList
    * 
    * @return projects
    * @since 09/12/2014
    */
   public List <HealthArtifact> getServiceList ()
   {
      return projects;
   }

}
