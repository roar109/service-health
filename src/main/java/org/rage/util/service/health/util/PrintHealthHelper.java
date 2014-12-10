package org.rage.util.service.health.util;


import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Project;
import org.rage.util.service.health.pojo.ProjectExtended;

import java.io.PrintStream;


/**
 * PrintHealthHelper represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 *
 */
public class PrintHealthHelper
{
   private static final String SERVER_NAME_LABEL = "Host";
   private static final String STATUS_NAME_LABEL = "Status";
   private static PrintStream  OUTPUT_STREAM     = System.out;


   /**
    * Represents printHeaders
    *
    * @param stream
    *
    * @since Oct 29, 2014
    *
    */
   public static void printHeaders (final PrintStream stream)
   {
      printHeadersInternal (stream);
   }


   /**
    * Represents printHeaders
    *
    * @since Oct 29, 2014
    *
    */
   public static void printHeaders ()
   {
      printHeadersInternal (OUTPUT_STREAM);
   }


   /**
    * Represents printHeaders
    *
    * @param stream
    *
    * @since Oct 24, 2014
    *
    */
   public static void printHeadersInternal (final PrintStream stream)
   {
      stream.append (String.format ("%-40s %s \n", SERVER_NAME_LABEL, STATUS_NAME_LABEL));
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Oct 29, 2014
    *
    */
   public static void print (final HealthArtifact artifact, final PrintStream stream)
   {
      printInternal (artifact, stream);
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Dic 09, 2014
    *
    */
   public static void print (final Project artifact, final PrintStream stream)
   {
      printInternal (artifact, stream);
   }


   /**
    * Represents print
    *
    * @param artifact
    * @since Oct 29, 2014
    *
    */
   public static void print (final HealthArtifact artifact)
   {
      printInternal (artifact, OUTPUT_STREAM);
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Oct 24, 2014
    *
    */
   public static void printInternal (final HealthArtifact artifact, final PrintStream stream)
   {
      stream.append (String.format ("%-40s %s \n", artifact.getServer (), getActiveServerText (artifact.isStatus ())));
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Dic 09, 2014
    *
    */
   static void printInternal (final Project artifact, final PrintStream stream)
   {
      stream.append (String.format ("%-40s %s %s \n", artifact.getCompletePath (), getActiveServerText (artifact
            .isStatus ()), getVersionMatchText (artifact)));
   }


   /**
    *
    * @param active
    * @return string
    * */
   private static String getActiveServerText (final boolean active)
   {
      return active ? "ACTIVE" : "UNAVAILABLE";
   }


   /**
    *
    * @param project
    * @return string
    * */
   private static String getVersionMatchText (final Project project)
   {
      if (project instanceof ProjectExtended)
      {
         final ProjectExtended pv = ((ProjectExtended) project);
         if (pv.getTargetVersion () != null)
         {
            return pv.isSameVersion () ? "MATCH" : "NOT MATCH";
         }
      }
      return "";
   }
}
