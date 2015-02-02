package org.rage.util.reader.util;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

import java.util.List;


/**
 * Helper utility with common functions to read files.
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 */
public final class ReaderHelper
{
   /**
    * Check the passed string against some basic validates to discard white spaces and comments.
    * 
    * @param line
    * @return boolean
    * @since 30/01/2015
    * 
    */
   public static boolean includeLine (final String line)
   {
      if (StringUtils.isBlank (line))
      {
         return false;
      }
      final String lineFormatted = StringUtils.strip (line);
      final boolean comment = StringUtils.startsWith (lineFormatted, "#");
      return comment ? false : true;
   }


   public static List <String> getLinesFromFile (final String fileName)
   {
      final File file = new File (fileName);
      if ( !file.exists ())
      {
         throw new IllegalArgumentException ("File doesnt exist!");
      }
      try
      {
         return FileUtils.readLines (file, "UTF-8");
      }
      catch (final IOException e)
      {
         e.printStackTrace ();
         return null;
      }
   }
}
