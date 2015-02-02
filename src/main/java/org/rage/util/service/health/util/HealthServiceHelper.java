package org.rage.util.service.health.util;


/**
 * HealthServiceHelper represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public final class HealthServiceHelper
{
   private static final String TO_FILE_PARAMETERNAME = "toFile";
   private static final String PATH_RESULTS          = "resultsPath";


   /**
    * Represents checkExportAsFileProperty
    *
    * @return boolean
    * @since 02/02/2015
    *
    */
   public static boolean checkExportAsFileProperty ()
   {
      if (System.getProperty (TO_FILE_PARAMETERNAME) != null)
      {
         return Boolean.TRUE;
      }
      return Boolean.FALSE;
   }


   /**
    * Represents getResultsPath
    *
    * @return string
    * @since 02/02/2015
    *
    */
   public static String getResultsPath ()
   {
      if (System.getProperty (PATH_RESULTS) != null)
      {
         return System.getProperty (PATH_RESULTS);
      }
      return null;
   }
}
