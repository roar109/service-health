package org.rage.util.service.health.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


/**
 * OutputResultHelper represents ...
 * 
 * @author <a href="mailto:hmendoza@24hourfit.com">Hector Mendoza</a>
 * @version $Id$
 * @since Oct 29, 2014
 * 
 */
public class OutputResultHelper
{
   /** OutputResultHelper for output */
   final static File                 output   = new File ("results.txt");
   /** OutputResultHelper for ps */
   static PrintStream                ps       = null;
   private static OutputResultHelper instance = new OutputResultHelper ();


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
            ps = new PrintStream (output);
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
   public PrintStream getOutputResults ()
   {
      return ps;
   }
}
