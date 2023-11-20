   FROM openjdk:17-alpine
   COPY target/asm01-0.0.1-SNAPSHOT.war asm01-0.0.1-SNAPSHOT.war
   ENV spring.datasource.url jdbc:mysql://monorail.proxy.rlwy.net:45833/railway
   ENV spring.datasource.username root
   ENV spring.datasource.password 2dgC3364gCB6bdfdH1-CDC4BEEae62AC
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","asm01-0.0.1-SNAPSHOT.war"]