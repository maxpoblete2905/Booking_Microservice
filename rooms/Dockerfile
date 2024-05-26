# Utiliza una imagen base que contenga Java runtime y las herramientas necesarias para construir y ejecutar los tests
FROM maven:3.8.4 AS build

# Copia el código fuente y los archivos de configuración necesarios para construir y ejecutar los tests
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Ejecuta los tests
RUN mvn clean test

# Construye el JAR del microservicio
RUN mvn package -DskipTests

# Crea la imagen final del contenedor
FROM openjdk:17-jdk-slim

# Copia el JAR del microservicio al contenedor
COPY --from=build /app/target/rooms-0.0.1-SNAPSHOT.jar /rooms-0.0.1-SNAPSHOT.jar

# Ejecuta el microservicio
ENTRYPOINT ["java","-jar","/rooms-0.0.1-SNAPSHOT.jar"]
