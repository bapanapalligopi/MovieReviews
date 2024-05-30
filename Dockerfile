FROM eclipse-temurin:17

LABEL maintainer="abdabd1703@gmail.com"

WORKDIR /app

COPY MovieReviews/target/MovieReviews-0.0.1-SNAPSHOT.jar /app/reviewsDocker.jar

ENTRYPOINT ["java", "-jar", "reviewsDocker.jar"]
