#!/bin/bash
docker run -it --rm -d -p 3306:3306\
 -e MYSQL_DATABASE=lecture\
 -e MYSQL_ROOT_PASSWORD=mysql\
 -e MYSQL_USER=scott\
 -e MYSQL_PASSWORD=tiger\
 --name mysql8\
 -v dummysql:/var/lib/mysql mysql