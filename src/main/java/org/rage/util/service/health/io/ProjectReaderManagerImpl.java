/*
 * Copyright © 2000 - 2008 24 Hour Fitness. All rights reserved.
 */
package org.rage.util.service.health.io;


import org.apache.commons.io.FileUtils;
import org.rage.util.service.health.pojo.Project;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * ProjectReaderManagerImpl represents ...
 *
 * @author <a href="mailto:hector.mendoza@24hourfit.com">hector.mendoza</a>
 * @version $Id$
 * @since 09/12/2014
 *
 * @todo Complete description
 */
public class ProjectReaderManagerImpl
{

   private List <Project> projects;
   private final String   fileName;


   public ProjectReaderManagerImpl (final String value)
   {
      this.fileName = value;
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
         projects = new ArrayList <Project> ();

         for (final String line : lines)
         {
            if (ReaderHelper.includeLine (line))
            {
               final String[] data = line.split (",");
               projects.add (new Project (data[0], new Integer (data[1]), data[2]));
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
   public List <Project> getServiceList ()
   {
      return projects;
   }

}
