package org.rage.util.service.health.io;


import org.apache.commons.lang3.StringUtils;


/**
 * ReaderHelper represents ...
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public final class ReaderHelper
{
   /**
    * Represents includeLine
    * 
    * @param line
    * @return boolean
    * @since Oct 24, 2014
    * 
    */
   public static boolean includeLine (final String line)
   {
      final String lineFormatted = StringUtils.strip (line);
      final boolean comment = StringUtils.startsWith (lineFormatted, "#");
      return comment ? false : true;
   }
}
