package org.rage.util.reader;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.util.List;


/**
 * ProjectFileReader represents ...
 *
 * @author <a href="mailto:hector.mendoza@24hourfit.com">hector.mendoza</a>
 * @version $Id$
 * @since 30/01/2015
 *
 * @todo Complete description
 */
public class ProjectFileReaderImpl implements FileReader
{
   private List <HealthArtifact> projects;
   private String                fileName;
   private boolean               readTargetVersion = Boolean.FALSE;


   /**
    * Constructs an instance of ProjectReaderManagerImpl object.
    *
    * @param value
    */
   public ProjectFileReaderImpl (final String value)
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
   public ProjectFileReaderImpl (final String value, final boolean readTargetVersionValue)
   {
      this.fileName = value;
      this.readTargetVersion = readTargetVersionValue;
      readFile ();
   }


   /**
    * Constructs an instance of ProjectFileReaderImpl object.
    */
   public ProjectFileReaderImpl ()
   {
      // TODO Auto-generated constructor stub

   }


   /**
    * Read a file and transform its lines into HealthArtifacts
    *
    * @since Oct 24, 2014
    */
   public void readFile ()
   {/*
     * final File file = new File (fileName); try { final List <String> lines = FileUtils.readLines (file, "UTF-8");
     * projects = new ArrayList <ProjectExtended> ();
     * 
     * for (final String line : lines) { if (ReaderHelper.includeLine (line)) { final String[] data = line.split (",");
     * if (readTargetVersion) { projects.add (new ProjectExtended (data[0], new Integer (data[1]), data[2], data[3])); }
     * else { projects.add (new ProjectExtended (data[0], new Integer (data[1]), data[2])); } } } } catch (final
     * Exception e) { System.err.println (e.getMessage ()); e.printStackTrace (); }
     */
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
