package org.rage.util.service.health.io;


import org.apache.commons.lang3.StringUtils;


/**
 * Helper utility with common functions to read files.
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public final class ReaderHelper
{
   /**
    * Check the passed string against some basic validates to discard white spaces and comments.
    * 
    * @param line
    * @return boolean
    * @since Oct 24, 2014
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
