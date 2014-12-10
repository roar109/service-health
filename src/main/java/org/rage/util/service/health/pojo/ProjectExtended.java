package org.rage.util.service.health.pojo;


import java.util.HashMap;


/**
 * ProjectExtended represents ...
 *
 * @author <a href="mailto:hmendoza@24hourfit.com">hector.mendoza</a>
 * @version $Id$
 * @since 10/12/2014
 *
 */
public class ProjectExtended extends Project
{
   private HashMap <String, String> attributes = new HashMap <String, String> ();
   private String                   targetVersion;
   private boolean                  sameVersion;


   /**
    * Constructs an instance of ProjectExtended object.
    *
    * @param serverName
    * @param portValue
    * @param value
    */
   public ProjectExtended (final String serverName, final int portValue, final String value)
   {
      super (serverName, portValue, value);
   }


   /**
    * Constructs an instance of ProjectExtended object.
    *
    * @param serverName
    * @param portValue
    * @param value
    * @param targetVersionValue
    */
   public ProjectExtended (final String serverName, final int portValue, final String value,
         final String targetVersionValue)
   {
      super (serverName, portValue, value);
      this.targetVersion = targetVersionValue;
   }


   /**
    * Constructs an instance of ProjectExtended object.
    *
    * @param project
    */
   public ProjectExtended (final Project project)
   {
      super (project.getServer (), project.getPort (), project.getProjectContext ());
   }


   /**
    * Represents getAttributes
    *
    * @return sameVersion
    * @since 10/12/2014
    *
    */
   public HashMap <String, String> getAttributes ()
   {
      return attributes;
   }


   /**
    * Represents setAttributes
    *
    * @param attributesValue
    * @since 10/12/2014
    *
    */
   public void setAttributes (final HashMap <String, String> attributesValue)
   {
      this.attributes = attributesValue;
   }


   /**
    * Represents getTargetVersion
    *
    * @return targetVersion
    * @since 10/12/2014
    *
    */
   public String getTargetVersion ()
   {
      return targetVersion;
   }


   /**
    * Represents setTargetVersion
    *
    * @param targetVersionValue
    * @since 10/12/2014
    *
    */
   public void setTargetVersion (final String targetVersionValue)
   {
      this.targetVersion = targetVersionValue;
   }


   /**
    * Represents isSameVersion
    *
    * @return sameVersion
    * @since 10/12/2014
    *
    */
   public boolean isSameVersion ()
   {
      return sameVersion;
   }


   /**
    * Represents setSameVersion
    *
    * @param sameVersionValue
    * @since 10/12/2014
    *
    */
   public void setSameVersion (final boolean sameVersionValue)
   {
      this.sameVersion = sameVersionValue;
   }

}
