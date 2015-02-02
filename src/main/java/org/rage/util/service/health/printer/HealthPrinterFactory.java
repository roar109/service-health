package org.rage.util.service.health.printer;


import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Project;
import org.rage.util.service.health.pojo.ProjectExtended;
import org.rage.util.service.health.util.PrintStreamDecorator;

import java.io.PrintStream;


/**
 * PrintHealthHelper represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 *
 */
public class HealthPrinterFactory implements HealthPrinter
{
   private static final String    SERVER_NAME_LABEL = "Host";
   private static final String    STATUS_NAME_LABEL = "Status";
   private static PrintStream     OUTPUT_STREAM     = System.out;
   private static HealthPrinter[] instances         = new HealthPrinter[HealthPrinterType.getCount ()];


   private HealthPrinterFactory ()
   {
   }


   /**
    * Returns the instance of the printer associated with the type
    *
    * @param type
    * @return healthPrinter
    * @since 18/12/2014
    *
    */
   public static HealthPrinter instance (final HealthPrinterType type)
   {
      HealthPrinter healthPrinter = instances[type.getValue () - 1];

      if (healthPrinter == null)
      {
         switch (type)
         {
            case PROJECT_HEALTH :
               healthPrinter = new HealthPrinterFactory ();
               break;
            case SERVICE_HEALTH :
               healthPrinter = new HealthPrinterFactory ();
               break;
            case VERSION :
               healthPrinter = new HealthPrinterVersionImpl ();
               break;
         }
         instances[type.getValue () - 1] = healthPrinter;
      }
      return healthPrinter;
   }


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
      printHeadersInternal (stream);
   }


   /**
    * Represents printHeaders
    *
    * @since Oct 29, 2014
    *
    */
   public void printHeaders ()
   {
      printHeadersInternal (new PrintStreamDecorator (OUTPUT_STREAM));
   }


   /**
    * Represents printHeaders
    *
    * @param stream
    *
    * @since Oct 24, 2014
    *
    */
   private static void printHeadersInternal (final PrintStreamDecorator stream)
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
   public void print (final HealthArtifact artifact, final PrintStreamDecorator stream)
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
   public void print (final Project artifact, final PrintStreamDecorator stream)
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
   public void print (final HealthArtifact artifact)
   {
      printInternal (artifact, new PrintStreamDecorator (OUTPUT_STREAM));
   }


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since Oct 24, 2014
    *
    */
   public static void printInternal (final HealthArtifact artifact, final PrintStreamDecorator stream)
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
   static void printInternal (final Project artifact, final PrintStreamDecorator stream)
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
         if ( (pv.getTargetVersion () != null) && pv.isStatus ())
         {
            return pv.isSameVersion () ? "MATCH" : "NOT MATCH";
         }
      }
      return "";
   }
}