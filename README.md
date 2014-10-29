service-health
==============

Small command line service to check if some hosts/jvm are alive

Execute with eclipse the launch file or with plain java
Parameters:
args[0] = path/to/file/servers.txt
args[1](Optional) =  path/to/file/balancers.txt

Read each line of the file in this format:
hostname.com,port
For balancer by default uses 8180 as a port
