package org.rage.util.service.health.printer;


import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.pojo.Project;

import java.io.PrintStream;


/**
 * HealthPrinter represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 18/12/2014
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
    * Represents printHeaders
    *
    * @param stream
    * @since 18/12/2014
    *
    */
   void printHeaders (final PrintStream stream);


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since 18/12/2014
    *
    */
   void print (final HealthArtifact artifact, final PrintStream stream);


   /**
    * Represents print
    *
    * @param artifact
    * @since 18/12/2014
    *
    */
   void print (final HealthArtifact artifact);


   /**
    * Represents print
    *
    * @param artifact
    * @param stream
    * @since 18/12/2014
    *
    */
   void print (final Project artifact, final PrintStream stream);
}
