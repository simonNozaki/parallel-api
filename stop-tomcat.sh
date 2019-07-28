#!/bin/bash
./workspace/bin/apache-tomcat-8.0.53/bin/shutdown.sh

rm /workspace/bin/apache-tomcat-8.0.53/webapps/boot-camp-api.war
rm -rf /workspace/bin/apache-tomcat-8.0.53/webapps/boot-camp-api
