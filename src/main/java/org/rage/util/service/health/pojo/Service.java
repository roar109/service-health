package org.rage.util.service.health.pojo;


/**
 * Service represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 *
 */
public class Service implements HealthArtifact
{
   private String  server;
   private int     port;
   private boolean status;


   /**
    * Constructs an instance of Service object.
    *
    * @param serverValue
    * @param portValue
    */
   public Service (final String serverValue, final int portValue)
   {
      this.server = serverValue;
      this.port = portValue;
   }



   /**
    * @return the server
    */
   public String getServer ()
   {
      return server;
   }


   /**
    * @param value the server to set
    */
   public void setServer (final String value)
   {
      this.server = value;
   }


   /**
    * @return the port
    */
   public int getPort ()
   {
      return port;
   }


   /**
    * @param value the port to set
    */
   public void setPort (final int value)
   {
      this.port = value;
   }


   /**
    * @return the status
    */
   public boolean isStatus ()
   {
      return status;
   }


   /**
    * @param value the status to set
    */
   public void setStatus (final boolean value)
   {
      this.status = value;
   }

}
