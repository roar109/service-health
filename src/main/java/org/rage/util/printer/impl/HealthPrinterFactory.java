package org.rage.util.printer.impl;


import org.apache.commons.lang3.StringUtils;
import org.rage.util.model.health.HealthArtifact;
import org.rage.util.model.health.Project;
import org.rage.util.printer.HealthPrinter;
import org.rage.util.printer.HealthPrinterConstants;
import org.rage.util.printer.HealthPrinterType;
import org.rage.util.service.health.util.PrintStreamDecorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


/**
 *
 * @author Hector Mendoza
 * @since Oct 24, 2014
 *
 */
public class HealthPrinterFactory implements HealthPrinter
{
   private static final String    SERVER_NAME_LABEL = "Host";
   private static final String    STATUS_NAME_LABEL = "Status";
   private static PrintStream     DEFAULT_STREAM    = System.out;
   private PrintStream            outputStream      = null;
   private static HealthPrinter[] instances         = new HealthPrinter[HealthPrinterType.getCount ()];
   private boolean                toFile            = Boolean.FALSE;
   private String                 resultsPath       = null;

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

      if (healthPrinter == null){
         switch (type)
         {
            case PROJECT_HEALTH :
               healthPrinter = new HealthPrinterVersionImpl ();
               break;
            case SERVICE_HEALTH :
               healthPrinter = new HealthPrinterFactory ();
               break;
            case VERSION :
               healthPrinter = new HealthPrinterVersionImpl ();
               break;
            case WEBSITE :
                healthPrinter = new WebsiteHealthPrinterImpl ();
                break;
         }
         instances[type.getValue () - 1] = healthPrinter;
      }
      return healthPrinter;
   }


   /**
    * Represents printHeaders
    *
    * @since Oct 29, 2014
    *
    */
   public void printHeaders ()
   {
      printHeadersInternal (getCurrentStream ());
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
    * @since Oct 29, 2014
    *
    */
   public void print (final HealthArtifact artifact)
   {
      printInternal (artifact, getCurrentStream ());
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
      stream.append (String.format ("%-40s %s %s\n", artifact.getServer (), getActiveServerText (artifact.isStatus ()),
            getVersionMatchText (artifact)));
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


   /**
    * Overrides setPrintToFile
    *
    * @param toFile
    * @since 02/02/2015
    * @see org.rage.util.printer.HealthPrinter#setPrintToFile(boolean)
    */
   public void setPrintToFile (final boolean toFile)
   {
      this.toFile = toFile;
   }


   /**
    * Overrides getCurrentStream
    *
    * @return decorator
    * @since 02/02/2015
    * @see org.rage.util.printer.HealthPrinter#getCurrentStream()
    */
   public PrintStreamDecorator getCurrentStream ()
   {
      if (toFile)
      {
         PrintStreamDecorator decorator = null;
         try
         {
            if (outputStream == null)
            {
               resultsPath = StringUtils.isNoneEmpty (resultsPath)
                     ? resultsPath
                     : HealthPrinterConstants.DEFAULT_FILENAME;
               outputStream = new PrintStream (new File (resultsPath));
            }
            decorator = new PrintStreamDecorator (DEFAULT_STREAM, outputStream);
         }
         catch (final FileNotFoundException e)
         {
            /***/
         }
         return decorator;
      }
      return new PrintStreamDecorator (DEFAULT_STREAM);
   }


   /**
    * Represents setResultsPath
    *
    * @param resultsPath
    * @since 02/02/2015
    *
    */
   public void setResultsPath (final String resultsPath)
   {
      this.resultsPath = resultsPath;
   }
}
