# Web Crawler
A Web crawler that crawls list of website concurrently

The Following command use to build docker image and run that image on your system.

1. sbt docker:publishLocal
   * this command create an image "web_crawler" with tag "0.1.0-SNAPSHOT"

2. docker run --rm -p 9991:9991 web_crawler:0.1.0-SNAPSHOT
    * this command run the web crawler inside the container and forward the request coming in the local system to docker container
    * press ctrl+c to exit from the container.
    * once container is in running state you can test the api through postman.

3. use below link to import postman collection for testing.
   * link:- https://www.getpostman.com/collections/7d10fb39145719c9cf58
