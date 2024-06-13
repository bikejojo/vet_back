# Usar la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo jar al contenedor
COPY target/vet_cristo-0.0.1-SNAPSHOT.jar /app/vet_cristo.jar

# Exponer el puerto que usará la aplicación
EXPOSE 8081

# Configurar la entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "vet_cristo.jar"]
