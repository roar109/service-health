package org.rage.util.service.health.io;


import org.rage.util.service.health.pojo.HealthArtifact;

import java.util.List;


/**
 * ReaderManager represents ...
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public interface ReaderManager
{
   /**
    * Represents getServiceList
    * 
    * @return
    * @since Oct 24, 2014
    * 
    */
   List <HealthArtifact> getServiceList ();
}
