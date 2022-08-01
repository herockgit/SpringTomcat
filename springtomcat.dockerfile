# Choose the smallest base image from https://github.com/docker-library/docs/blob/master/tomcat/README.md#supported-tags-and-respective-dockerfile-links
FROM tomcat:9.0.64-jre11-openjdk-slim
COPY server.xml /usr/local/tomcat/conf
COPY ./target/*.war /usr/local/tomcat/webapps/
EXPOSE 80
CMD ["catalina.sh", "run"]