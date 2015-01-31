package org.rage.util.reader;


/**
 * FileReaderFactory represents ...
 *
 * @author <a href="mailto:hector.mendoza@24hourfit.com">hector.mendoza</a>
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
    * @return FileReader
    * @since 30/01/2015
    *
    */
   public static FileReader buildFileReader (final FileReaderType fileReaderType)
   {
      FileReader fileReader = null;
      switch (fileReaderType)
      {
         case BALANCER :
            fileReader = new BalancerFileReaderImpl ();
            break;
         case SERVER :
            fileReader = new ServerFileReaderImpl ();
            break;
         case PROJECT :
            fileReader = new ProjectFileReaderImpl ();
            break;
      }
      return fileReader;
   }
}
