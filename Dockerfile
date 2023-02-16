FROM openjdk:17
EXPOSE 9969
COPY /build/libs/BrownField-0.0.1-SNAPSHOT.jar brownfield.jar
ENTRYPOINT ["java", "-jar", "brownfield.jar"]
