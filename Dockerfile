# Etapa de build (compilar el proyecto y generar el JAR)
FROM maven:3.9.9-ibm-semeru-17-focal AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de runtime (solo para ejecutar el JAR)
FROM ibm-semeru-runtimes:open-17-jre
WORKDIR /app
# Copiamos el JAR desde la etapa de build
COPY --from=build /app/target/proyectosaberpro-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8087
# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
