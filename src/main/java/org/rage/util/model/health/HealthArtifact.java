package org.rage.util.model.health;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public class HealthArtifact
{
   private String           server;
   private int              port;
   private boolean          status;
   private transient String completePath;
   private Project          project;


   /**
    * Constructs an instance of HealthArtifact object.
    *
    * @param server
    * @param port
    */
   public HealthArtifact (final String server, final int port)
   {
      this.server = server;
      this.port = port;
   }
   
   public HealthArtifact (final String server){
	   this.server = server;
   }


   /**
    * Represents getServer
    *
    * @return server
    * @since 02/02/2015
    *
    */
   public String getServer ()
   {
      return server;
   }


   /**
    * Represents setServer
    *
    * @param server
    * @since 02/02/2015
    *
    */
   public void setServer (final String server)
   {
      this.server = server;
   }


   /**
    * Represents getPort
    *
    * @return
    * @since 02/02/2015
    *
    */
   public int getPort ()
   {
      return port;
   }


   /**
    * Represents setPort
    *
    * @param port
    * @since 02/02/2015
    *
    */
   public void setPort (final int port)
   {
      this.port = port;
   }


   /**
    * Represents isStatus
    *
    * @return
    * @since 02/02/2015
    *
    */
   public boolean isStatus ()
   {
      return status;
   }


   /**
    * Represents setStatus
    *
    * @param status
    * @since 02/02/2015
    *
    */
   public void setStatus (final boolean status)
   {
      this.status = status;
   }


   /**
    * Represents getCompletePath
    *
    * @return
    * @since 02/02/2015
    *
    */
   public String getCompletePath ()
   {
      return completePath;
   }


   /**
    * Represents setCompletePath
    *
    * @param completePath
    * @since 02/02/2015
    *
    */
   public void setCompletePath (final String completePath)
   {
      this.completePath = completePath;
   }


   /**
    * Represents getProject
    *
    * @return project
    * @since 02/02/2015
    *
    */
   public Project getProject ()
   {
      return project;
   }


   /**
    * Represents setProject
    *
    * @param project
    * @since 02/02/2015
    *
    */
   public void setProject (final Project project)
   {
      this.project = project;
   }

}
