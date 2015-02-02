package org.rage.util.service.health.util;


import java.io.PrintStream;


/**
 * Use the "decorator" pattern - not really but close :)
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 */
public class PrintStreamDecorator
{

   private PrintStream outputStream     = null;
   private PrintStream outputStreamFile = null;


   /**
    * Constructs an instance of PrintStreamDecorator object.
    *
    * @param outputStreamValue
    */
   public PrintStreamDecorator (final PrintStream outputStreamValue)
   {
      this.outputStream = outputStreamValue;
   }


   /**
    * Constructs an instance of PrintStreamDecorator object. Print to passed printer and to standard console output.
    *
    * @param outputStreamValue
    * @param outputStreamFileValue
    */
   public PrintStreamDecorator (final PrintStream outputStreamValue, final PrintStream outputStreamFileValue)
   {
      this.outputStream = outputStreamValue;
      this.outputStreamFile = outputStreamFileValue;
   }


   /**
    * Represents println
    *
    * @param x
    * @since 30/01/2015
    *
    */
   public void println (final String x)
   {
      outputStream.println (x);
      if (outputStreamFile != null)
      {
         outputStreamFile.println (x);
      }
   }


   /**
    * Represents println
    *
    * @since 30/01/2015
    *
    */
   public void println ()
   {
      outputStream.println ();
      if (outputStreamFile != null)
      {
         outputStreamFile.println ();
      }
   }


   /**
    * Represents append
    *
    * @param c
    * @since 30/01/2015
    *
    */
   public void append (final char c)
   {
      outputStream.append (c);
      if (outputStreamFile != null)
      {
         outputStreamFile.append (c);
      }
   }


   /**
    * Represents append
    *
    * @param csq
    * @since 30/01/2015
    *
    */
   public void append (final CharSequence csq)
   {
      outputStream.append (csq);
      if (outputStreamFile != null)
      {
         outputStreamFile.append (csq);
      }
   }
}
