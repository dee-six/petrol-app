FROM azul/zulu-openjdk-alpine:14

WORKDIR /usr/app/petrol-app

ARG JAR_FILE=target/petrol-app-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} ${WORKDIR}/app.jar

ENTRYPOINT ["java","-jar","/usr/app/petrol-app/app.jar"]

