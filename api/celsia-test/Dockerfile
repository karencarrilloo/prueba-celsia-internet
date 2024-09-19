# Utiliza una imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY build/libs/celsia-test-0.0.1-SNAPSHOT.jar /app/api.jar

# Expone el puerto en el que correrá la API
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/api.jar"]