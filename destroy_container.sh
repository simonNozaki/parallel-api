#!/bin/bash

docker container stop parallel-api
docker rm parallel-api
docker rmi parallel-api:1.0.0

docker ps -a
