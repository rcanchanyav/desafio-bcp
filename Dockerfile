FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD ./target/desafio.jar service-bcp-desafio.jar
ENTRYPOINT ["java","-jar","/service-bcp-desafio.jar"]