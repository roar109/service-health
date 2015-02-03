package org.rage.util.printer;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.service.health.util.PrintStreamDecorator;


/**
 * HealthPrinter represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 */
public interface HealthPrinter
{
   /**
    * Represents printHeaders
    *
    * @since 18/12/2014
    *
    */
   void printHeaders ();


   /**
    * Represents print
    *
    * @param artifact
    * @since 18/12/2014
    *
    */
   void print (final HealthArtifact artifact);


   /**
    * Represents setPrintToFile
    *
    * @param toFile
    * @since 02/02/2015
    *
    */
   void setPrintToFile (final boolean toFile);


   /**
    * Represents getCurrentStream
    *
    * @return printStream
    * @since 02/02/2015
    *
    * @todo complete description
    */
   PrintStreamDecorator getCurrentStream ();


   /**
    * Represents setResultsPath
    *
    * @param resultsPath
    * @since 02/02/2015
    *
    */
   void setResultsPath (final String resultsPath);
}
