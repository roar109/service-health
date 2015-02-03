package org.rage.util.reader;


import org.rage.util.model.health.HealthArtifact;

import java.util.List;


/**
 * Reader Interface, provides a basic layout for other implementation of readers.
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 30/01/2015
 *
 */
public interface FileReader
{
   /**
    * Get list of artifacts.
    *
    * @return list
    * @since 30/01/2015
    *
    */
   List <HealthArtifact> getServiceList ();
}
