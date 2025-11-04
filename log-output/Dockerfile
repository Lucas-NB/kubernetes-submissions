FROM openjdk:17.0.1-slim AS builder

WORKDIR /usr/app

COPY . .

RUN javac src/main/java/Main.java


FROM openjdk:17.0.1-slim

COPY --from=builder /usr/app/src/main/java/Main.class .

CMD ["java", "Main"]