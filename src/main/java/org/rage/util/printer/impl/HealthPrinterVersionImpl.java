package org.rage.util.printer.impl;


import org.apache.commons.lang3.StringUtils;
import org.rage.util.model.health.HealthArtifact;
import org.rage.util.model.health.Project;
import org.rage.util.printer.HealthPrinter;
import org.rage.util.printer.HealthPrinterConstants;
import org.rage.util.service.health.util.PrintStreamDecorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


/**
 * HealthPrinterVersionImpl
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 *
 */
public class HealthPrinterVersionImpl implements HealthPrinter
{
   private static PrintStream DEFAULT_STREAM = System.out;
   private PrintStream        outputStream   = null;
   private boolean            toFile         = Boolean.FALSE;
   private String             resultsPath    = null;


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
      stream.append ("");
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
    * @since Dic 09, 2014
    *
    */
   static void printInternal (final HealthArtifact artifact, final PrintStreamDecorator stream)
   {
      final StringBuilder sb = new StringBuilder ();
      sb.append ("\n").append ("URL: ").append (artifact.getCompletePath ()).append ("\n");
      sb.append ("Status: ").append (getActiveServerText (artifact.isStatus ())).append ("\n");
      if ( (artifact.getProject () != null) && (artifact.getProject ().getTargetVersion () != null))
      {
         sb.append ("Version Match?: ").append (getVersionMatchText (artifact)).append ("\n");
      }
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
