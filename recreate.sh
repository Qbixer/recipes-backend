#!/bin/bash
docker rm recipes_app_1
docker-compose pull
docker-compose up --force-recreate
