package org.rage.util.printer;


/**
 * HealthPrinterType represents the types of possible printer objects.
 *
 * @author <roar109@gmail.com> Hector Mendoza
 * @version $Id$
 * @since 18/12/2014
 *
 */
public enum HealthPrinterType
{
   VERSION (1),
   PROJECT_HEALTH (2), 
   SERVICE_HEALTH (3),
   WEBSITE(4);

   private int value;


   HealthPrinterType (final int intValue)
   {
      this.value = intValue;
   }


   /**
    * Represents getCount
    *
    * @return count
    * @since 18/12/2014
    *
    */
   public static int getCount ()
   {
      return 4;
   }


   /**
    * Represents getValue
    *
    * @return value
    * @since 18/12/2014
    *
    */
   public int getValue ()
   {
      return this.value;
   }
}
