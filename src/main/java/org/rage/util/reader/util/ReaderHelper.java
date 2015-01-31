package org.rage.util.reader.util;


import org.apache.commons.lang3.StringUtils;


/**
 * Helper utility with common functions to read files.
 *
 * @author Hector Mendoza
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
}
