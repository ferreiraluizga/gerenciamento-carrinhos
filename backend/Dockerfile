# Estágio 1: Compilação do projeto com Maven e Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY core/pom.xml ./core/
COPY infrastructure/pom.xml ./infrastructure/

RUN mvn dependency:go-offline -B

COPY core/src ./core/src
COPY infrastructure/src ./infrastructure/src

RUN mvn clean package -DskipTests

# Estágio 2: Execução da aplicação com Java 21
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

COPY --from=build /app/infrastructure/target/*.jar app.jar

USER appuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]