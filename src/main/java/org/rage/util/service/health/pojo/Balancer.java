package org.rage.util.service.health.pojo;


/**
 * Balancer
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class Balancer extends Service
{

   /**
    * Constructs an instance of VIP object.
    * 
    * @param server
    * @param port
    */
   public Balancer (final String server, final int port)
   {
      super (server, port);
   }
}
