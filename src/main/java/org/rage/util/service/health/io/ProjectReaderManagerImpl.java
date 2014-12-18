package org.rage.util.service.health.io;


import org.apache.commons.io.FileUtils;
import org.rage.util.service.health.pojo.ProjectExtended;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * ProjectReaderManagerImpl represents ... Used for AppVersion-xml and the GET to the AppVersion
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 09/12/2014
 *
 */
public class ProjectReaderManagerImpl
{
   private List <ProjectExtended> projects;
   private final String           fileName;
   private boolean                readTargetVersion = Boolean.FALSE;


   /**
    * Constructs an instance of ProjectReaderManagerImpl object.
    *
    * @param value
    */
   public ProjectReaderManagerImpl (final String value)
   {
      this.fileName = value;
      readFile ();
   }


   /**
    * Constructs an instance of ProjectReaderManagerImpl object.
    *
    * @param value
    * @param readTargetVersionValue
    */
   public ProjectReaderManagerImpl (final String value, final boolean readTargetVersionValue)
   {
      this.fileName = value;
      this.readTargetVersion = readTargetVersionValue;
      readFile ();
   }


   /**
    * Read a file and transform its lines into HealthArtifacts
    *
    * @since Oct 24, 2014
    */
   public void readFile ()
   {
      final File file = new File (fileName);
      try
      {
         final List <String> lines = FileUtils.readLines (file, "UTF-8");
         projects = new ArrayList <ProjectExtended> ();

         for (final String line : lines)
         {
            if (ReaderHelper.includeLine (line))
            {
               final String[] data = line.split (",");
               if (readTargetVersion)
               {
                  projects.add (new ProjectExtended (data[0], new Integer (data[1]), data[2], data[3]));
               }
               else
               {
                  projects.add (new ProjectExtended (data[0], new Integer (data[1]), data[2]));
               }
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
    * @return projects
    * @since 09/12/2014
    */
   public List <ProjectExtended> getServiceList ()
   {
      return projects;
   }

}
