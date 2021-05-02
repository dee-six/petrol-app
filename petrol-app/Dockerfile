FROM azul/zulu-openjdk-alpine:14

ARG APP_DIR=/usr/app/petrol-app
ARG JAR_FILE=/petrol-app/target/petrol-app-0.0.1-SNAPSHOT.jar

WORKDIR ${APP_DIR}

COPY ${JAR_FILE} ${APP_DIR}/app.jar

CMD ["ls -l", "/usr/app/petrol-app"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/petrol-app/app.jar"]

