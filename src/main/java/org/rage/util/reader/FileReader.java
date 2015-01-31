package org.rage.util.reader;


import java.util.List;

import org.rage.util.model.health.HealthArtifact;


/**
 * Reader Interface, provides a basic layout for other implementation of readers.
 *
 * @author hector.mendoza
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
