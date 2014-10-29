service-health
==============

Small command line service to check if some hosts/jvm are alive

Execute with eclipse the launch file or with maven:

`mvn exec:java -Dexec.mainClass=org.rage.util.service.health.service.ConsoleHealthChecker -Dexec.args="c:\servers-list.txt"`

You can add the `-DtoFile=y` parameter to export the content to a results.txt

Parameters:
- args[0] = path/to/file/servers.txt
- args[1] [Optional] =  path/to/file/balancers.txt

Read each line of the file in this format:
hostname.com,port

For balancer by default uses 8180 as a port
