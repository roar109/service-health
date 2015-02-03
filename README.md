service-health
==============

Small command line service to check if some hosts/jvm are alive

Execute with eclipse the launch file or with maven:

`mvn exec:java -Dexec.mainClass=org.rage.util.health.main.ServerHealthMain -Dexec.args="c:\servers-list.txt"`

You can add the `-DtoFile=y` parameter to export the content to a results.txt

Parameters:
- args[0] = path/to/file/servers.txt
- args[1] [Optional] =  path/to/file/balancers.txt

Read each line of the file in this format `hostname.com,port`

For the balancer urls by default uses 8180 as port

### WARs
For deployed wars this tool can:
- Check if are up (Do a GET request to the AppVersion servlet)
- Check if the deployed version match the versions passed (Do a GET request to the AppVersion and get the response as xml)
 
See `example-files` folder to see input file examples.

Example commands from maven console
cmd /k mvn exec:java -Dexec.mainClass=org.rage.util.health.main.ServerHealthMain -Dexec.args="example-files\servers-list.txt example-files\servers-list-vip.txt"

cmd /k mvn exec:java -Dexec.mainClass=org.rage.util.health.main.ProjectHealthMain -Dexec.args="example-files\project-list.txt" -DtoFile=y -DresultsPath=results-project.txt

cmd /k mvn exec:java -Dexec.mainClass=org.rage.util.health.main.ProjectMatcherHealthMain -Dexec.args="example-files\projectversion-list.txt" -DtoFile=y -DresultsPath=results-version.txt

### Completed from TODO
- `-Dbalancer.port=890`

### TODO
- Path to check if is alive a war (optional)
- Generate a war that checks automatically each X time the servers health.
