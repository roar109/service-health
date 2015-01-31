package org.rage.util.reader;



import org.rage.util.service.health.pojo.HealthArtifact;

import java.util.List;


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
