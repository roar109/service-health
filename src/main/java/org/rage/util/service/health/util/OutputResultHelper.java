package org.rage.util.service.health.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


/**
 * OutputResultHelper represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 29, 2014
 *
 */
public class OutputResultHelper
{
   /** OutputResultHelper for output */
   private static File               output      = null;
   /** OutputResultHelper for ps */
   static PrintStreamDecorator       ps          = null;
   private static OutputResultHelper instance    = new OutputResultHelper ();
   private static final PrintStream  DEFAULT_OUT = System.out;


   private OutputResultHelper ()
   {
      // np
   }


   /**
    * Represents instance
    *
    * @return instance
    * @since Oct 29, 2014
    *
    */
   public static OutputResultHelper instance ()
   {
      if (ps == null)
      {
         try
         {
            output = new File ("results.txt");
            ps = new PrintStreamDecorator (DEFAULT_OUT, new PrintStream (output));
         }
         catch (final FileNotFoundException e)
         {
            e.printStackTrace ();
         }
      }
      return instance;
   }


   /**
    * Represents instance
    *
    * @return instance
    * @param fileName
    * @since Dic 9, 2014
    *
    */
   public static OutputResultHelper instance (final String fileName)
   {
      if (ps == null)
      {
         try
         {
            output = new File (fileName);
            ps = new PrintStreamDecorator (DEFAULT_OUT, new PrintStream (output));
         }
         catch (final FileNotFoundException e)
         {
            e.printStackTrace ();
         }
      }
      return instance;
   }


   /**
    * Represents createOutputResults
    *
    * @return ps
    * @since Oct 29, 2014
    *
    */
   public PrintStreamDecorator getOutputResultsStream ()
   {
      return ps;
   }
}
