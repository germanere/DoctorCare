   FROM openjdk:17-alpine
   COPY target/asm01-0.0.1-SNAPSHOT.war asm01-0.0.1-SNAPSHOT.war
   ENV spring.datasource.url jdbc:mysql://mysql-156389-0.cloudclusters.net:10050/asm01
   ENV spring.datasource.username admin
   ENV spring.datasource.password SM1BZH94
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","asm01-0.0.1-SNAPSHOT.war"]