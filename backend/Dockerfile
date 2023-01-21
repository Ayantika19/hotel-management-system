FROM adoptopenjdk/openjdk11:alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build/libs/hotelmanagement-0.0.1.jar hotelmanagement.jar
EXPOSE 8080
CMD ["java", "-jar", "hotelmanagement.jar"]