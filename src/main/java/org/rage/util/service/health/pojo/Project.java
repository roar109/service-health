package org.rage.util.service.health.pojo;


/**
 * Project represents ...
 *
 * @author Hector Mendoza
 * @version $Id$
 * @since 09/12/2014
 *
 */
public class Project
{
   private String  server;
   private int     port;
   private boolean status;
   private String  projectContext;
   private String  completePath;


   /**
    * @param serverName
    * @param portValue
    * @param value
    * */
   public Project (final String serverName, final int portValue, final String value)
   {
      this.server = serverName;
      this.port = portValue;
      this.projectContext = value;
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


   /**
    * @return the projectContext
    */
   public String getProjectContext ()
   {
      return projectContext;
   }


   /**
    * @param value the projectContext to set
    */
   public void setProjectContext (final String value)
   {
      this.projectContext = value;
   }


   /**
    * @return the completePath
    */
   public String getCompletePath ()
   {
      return completePath;
   }


   /**
    * @param value the completePath to set
    */
   public void setCompletePath (final String value)
   {
      this.completePath = value;
   }


}
