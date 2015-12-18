package org.rage.util.reader.impl;


import java.util.Optional;

import org.rage.util.reader.FileReader;
import org.rage.util.reader.FileReaderType;


/**
 *
 * @author Hector Mendoza
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
   public static Optional<FileReader> createFileReader (final FileReaderType fileReaderType, final String fileName)
   {
      Optional<FileReader> fileReader = Optional.empty();
      
      switch (fileReaderType)
      {
         case BALANCER :
            fileReader = Optional.of(new BalancerFileReaderImpl (fileName));
            break;
         case SERVER :
            fileReader =  Optional.of(new ServerFileReaderImpl (fileName));
            break;
         case PROJECT :
            fileReader = Optional.of(new ProjectFileReaderImpl (Boolean.FALSE, fileName));
            break;
         case PROJECT_VERSION_MATCHER :
            fileReader = Optional.of(new ProjectFileReaderImpl (Boolean.TRUE, fileName));
            break;
         case WEBSITE :
             fileReader = Optional.of(new WebsiteFileReaderImpl (fileName));
             break;
      }
      return fileReader;
   }
}
