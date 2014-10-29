package org.rage.util.service.health.service;


import org.rage.util.service.health.checker.ServiceHealthCheckerMain;
import org.rage.util.service.health.io.BalancerReaderManagerImpl;
import org.rage.util.service.health.io.ReaderManager;
import org.rage.util.service.health.io.ServerReaderManagerImpl;
import org.rage.util.service.health.pojo.HealthArtifact;
import org.rage.util.service.health.util.HealthCheckerConstants;
import org.rage.util.service.health.util.PrintHealthHelper;

import java.util.List;


/**
 * Main class to check the health of some servers
 * 
 * @author Hector Mendoza
 * @version $Id$
 * @since Oct 24, 2014
 * 
 */
public class HealthCheckerService
{
   /**
    * Represents main
    * 
    * @param args
    * @since Oct 24, 2014
    * 
    */
   public static void main (final String[] args)
   {
      if (args.length == 0)
      {
         System.out.println ("No files specified");
         System.exit (1);
      }
      // "c:\\servers-list.txt"
      System.out.println ("***" + HealthCheckerConstants.SERVER_NAMES + "***");
      final ReaderManager svs = new ServerReaderManagerImpl (args[0]);
      final ServiceHealthCheckerMain checker = new ServiceHealthCheckerMain (svs.getServiceList ());
      final List <HealthArtifact> artifacts = checker.runAllAndWait ();
      PrintHealthHelper.printHeaders ();
      for (final HealthArtifact artifact : artifacts)
      {
         PrintHealthHelper.print (artifact);
      }
      if (args.length < 1)
      {
         return;
      }
      // "c:\\servers-list-vip.txt"
      System.out.println ("\n***" + HealthCheckerConstants.BALANCER_NAME + "***");
      final ReaderManager svsBalancer = new BalancerReaderManagerImpl (args[1]);
      final ServiceHealthCheckerMain checkerVIP = new ServiceHealthCheckerMain (svsBalancer.getServiceList ());
      final List <HealthArtifact> artifactsVip = checkerVIP.runAllAndWait ();
      PrintHealthHelper.printHeaders ();
      for (final HealthArtifact artifact : artifactsVip)
      {
         PrintHealthHelper.print (artifact);
      }
   }

}
