package org.rage.util.service.health.util;


/**
 * ValidationHealthServiceHelper represents ...
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 03/02/2015
 *
 */
public final class ValidationHealthServiceHelper
{

   /**
    * Validate that the array ios not null or empty
    *
    * @param arguments
    * @since 03/02/2015
    *
    */
   public static void validateArguments (final String[] arguments)
   {
      if ( (arguments == null) || (arguments.length == 0))
      {
         throw new IllegalArgumentException ("Ilegal arguments passed.");
      }
   }
}
