#!/bin/bash

# build the war
gradle build -x test

# build the container
docker build -t parallel-api:1.0.0 .
docker run --name parallel-api -d -p 8080:8080 -p 8009:8009 parallel-api:1.0.0

docker ps
