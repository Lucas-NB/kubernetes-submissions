FROM maven:3.8.3-openjdk-17 AS builder

WORKDIR /usr/app

COPY . .

RUN mvn clean package -DskipTests


FROM openjdk:17.0.1-slim

WORKDIR /usr/app/src

COPY --from=builder /usr/app/target/the-project-0.0.1-SNAPSHOT.jar the-project-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "the-project-0.0.1-SNAPSHOT.jar"]