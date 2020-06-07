#!/bin/bash

# Build war of Spring boot
gradle build -x test

# Build and push to ECR
docker build -t parallel-api .

docker tag parallel-api:latest 549110186018.dkr.ecr.ap-northeast-1.amazonaws.com/parallel-api:latest

docker push 549110186018.dkr.ecr.ap-northeast-1.amazonaws.com/parallel-api:latest