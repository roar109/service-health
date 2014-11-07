package org.rage.util.service.health.io;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.util.List;


/**
 * Reader Interface, provides a basic layout for other implementation of readers.
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public interface ReaderManager
{
   /**
    * Get list of artifacts.
    * 
    * @return list
    * @since Oct 24, 2014
    * 
    */
   List <HealthArtifact> getServiceList ();
}
