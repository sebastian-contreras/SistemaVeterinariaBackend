FROM amazoncorretto:17

MAINTAINER SebastianContreras

COPY target/SistemaVeterinaria-0.0.1-SNAPSHOT.jar SistemaVeterinaria-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/SistemaVeterinaria-0.0.1-SNAPSHOT.jar"]