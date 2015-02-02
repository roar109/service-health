package org.rage.util.printer.impl;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.model.health.Project;
import org.rage.util.printer.HealthPrinter;
import org.rage.util.service.health.util.PrintStreamDecorator;


/**
 * HealthPrinterVersionImpl
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 *
 */
public class HealthPrinterVersionImpl implements HealthPrinter
{

   /**
    * Represents printHeaders
    *
    * @param stream
    *
    * @since Oct 29, 2014
    *
    */
   public void printHeaders (final PrintStreamDecorator stream)
   {
      // NOIMPLEMENTATION
   }


   /**
    * Represents printHeaders
    *
    * @since Oct 29, 2014
    *
    */
   public void printHeaders ()
   {
      // NOIMPLEMENTATION
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Oct 29, 2014
    *
    */
   public void print (final HealthArtifact artifact, final PrintStreamDecorator stream)
   {
      // NOIMPLEMENTATION
   }


   /**
    * Represents print
    *
    * @param artifact
    * @since Oct 29, 2014
    *
    */
   public void print (final HealthArtifact artifact)
   {
      // NOIMPLEMENTATION
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Dic 09, 2014
    *
    */
   static void printInternal (final HealthArtifact artifact, final PrintStreamDecorator stream)
   {
      final StringBuilder sb = new StringBuilder ();
      sb.append ("\n").append ("URL: ").append (artifact.getCompletePath ()).append ("\n");
      sb.append ("Status: ").append (getActiveServerText (artifact.isStatus ())).append ("\n");
      sb.append ("Version Match?: ").append (getVersionMatchText (artifact)).append ("\n");
      stream.append (sb.toString ());
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
    * @param artifact
    * @return string
    * */
   private static String getVersionMatchText (final HealthArtifact artifact)
   {
      if (artifact.getProject () != null)
      {
         final Project project = artifact.getProject ();
         if ( (project.getTargetVersion () != null) && artifact.isStatus ())
         {
            return project.isSameVersion () ? "MATCH" : "NOT MATCH";
         }
      }
      return "";
   }
}