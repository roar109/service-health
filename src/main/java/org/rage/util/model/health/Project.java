package org.rage.util.model.health;


import java.util.HashMap;


/**
 * @author <roar109@gmail.com> Hector Mendoza
 *
 */
public class Project
{
   private String                   projectContext;
   private HashMap <String, String> attributes = new HashMap <String, String> ();
   private String                   targetVersion;
   private boolean                  sameVersion;


   /**
    * Constructs an instance of Project object.
    * 
    * @param projectContext
    */
   public Project (final String projectContext)
   {
      this.projectContext = projectContext;
   }


   /**
    * Constructs an instance of Project object.
    * 
    * @param projectContext
    * @param targetVersion
    */
   public Project (final String projectContext, final String targetVersion)
   {
      this.projectContext = projectContext;
      this.targetVersion = targetVersion;
   }


   /**
    * Represents getAttributes
    * 
    * @return attributes
    * @since 02/02/2015
    * 
    */
   public HashMap <String, String> getAttributes ()
   {
      return attributes;
   }


   /**
    * Represents setAttributes
    * 
    * @param attributes
    * @since 02/02/2015
    * 
    */
   public void setAttributes (final HashMap <String, String> attributes)
   {
      this.attributes = attributes;
   }


   /**
    * Represents getTargetVersion
    * 
    * @return targetVersion
    * @since 02/02/2015
    * 
    */
   public String getTargetVersion ()
   {
      return targetVersion;
   }


   /**
    * Represents setTargetVersion
    * 
    * @param targetVersion
    * @since 02/02/2015
    * 
    */
   public void setTargetVersion (final String targetVersion)
   {
      this.targetVersion = targetVersion;
   }


   /**
    * Represents isSameVersion
    * 
    * @return sameVersion
    * @since 02/02/2015
    * 
    */
   public boolean isSameVersion ()
   {
      return sameVersion;
   }


   /**
    * Represents setSameVersion
    * 
    * @param sameVersion
    * @since 02/02/2015
    * 
    */
   public void setSameVersion (final boolean sameVersion)
   {
      this.sameVersion = sameVersion;
   }


   /**
    * Represents getProjectContext
    * 
    * @return projectContext
    * @since 02/02/2015
    * 
    */
   public String getProjectContext ()
   {
      return projectContext;
   }


   /**
    * Represents setProjectContext
    * 
    * @param projectContext
    * @since 02/02/2015
    * 
    */
   public void setProjectContext (final String projectContext)
   {
      this.projectContext = projectContext;
   }

}
