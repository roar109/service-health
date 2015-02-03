package org.rage.util.reader.impl;


import org.rage.util.reader.FileReader;
import org.rage.util.reader.FileReaderType;


/**
 * FileReaderFactory represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 */
public final class FileReaderFactory
{

   /**
    * Represents buildFileReader
    *
    * @param fileReaderType
    * @param fileName
    * @return FileReader
    * @since 30/01/2015
    *
    */
   public static FileReader createFileReader (final FileReaderType fileReaderType, final String fileName)
   {
      FileReader fileReader = null;
      switch (fileReaderType)
      {
         case BALANCER :
            fileReader = new BalancerFileReaderImpl (fileName);
            break;
         case SERVER :
            fileReader = new ServerFileReaderImpl (fileName);
            break;
         case PROJECT :
            fileReader = new ProjectFileReaderImpl (Boolean.FALSE, fileName);
            break;
         case PROJECT_VERSION_MATCHER :
            fileReader = new ProjectFileReaderImpl (Boolean.TRUE, fileName);
            break;
      }
      return fileReader;
   }
}
