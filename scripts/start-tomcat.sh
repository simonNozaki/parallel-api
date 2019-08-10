#!/bin/bash

./workspace/bin/apache-tomcat-8.0.53/bin/startup.sh

chown -R worker:worker /workspace/bin/apache-tomcat-8.0.53/webapps/parallel-api