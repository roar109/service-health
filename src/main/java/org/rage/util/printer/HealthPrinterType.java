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
   /** HealthPrinterType for VERSION */
   VERSION (1), /** HealthPrinterType for PROJECT_HEALTH */
   PROJECT_HEALTH (2), /** HealthPrinterType for SERVICE_HEALTH */
   SERVICE_HEALTH (3);

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
      return 3;
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
