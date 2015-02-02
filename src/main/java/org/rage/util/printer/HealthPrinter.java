package org.rage.util.printer;


import org.rage.util.model.health.HealthArtifact;
import org.rage.util.service.health.util.PrintStreamDecorator;


/**
 * HealthPrinter represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 02/02/2015
 *
 * @todo Complete description
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
    * Represents printHeaders
    *
    * @param stream
    * @since 18/12/2014
    *
    */
   void printHeaders (final PrintStreamDecorator stream);


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since 18/12/2014
    *
    */
   void print (final HealthArtifact artifact, final PrintStreamDecorator stream);


   /**
    * Represents print
    *
    * @param artifact
    * @since 18/12/2014
    *
    */
   void print (final HealthArtifact artifact);
}
