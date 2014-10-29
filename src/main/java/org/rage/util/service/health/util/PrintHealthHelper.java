package org.rage.util.service.health.util;


import org.rage.util.service.health.pojo.HealthArtifact;


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


   /**
    * Represents printHeaders
    * 
    * @since Oct 24, 2014
    * 
    */
   public static void printHeaders ()
   {
      System.out.printf ("%-40s %s \n", SERVER_NAME_LABEL, STATUS_NAME_LABEL);
   }


   /**
    * Represents print
    * 
    * @param artifact
    * @since Oct 24, 2014
    * 
    */
   public static void print (final HealthArtifact artifact)
   {
      System.out.printf ("%-40s %s \n", artifact.getServer (), getActiveServerText (artifact.isStatus ()));
   }


   private static String getActiveServerText (final boolean active)
   {
      return active ? "ACTIVE" : "UNAVAILABLE";
   }
}
