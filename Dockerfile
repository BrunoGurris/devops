# Etapa 1: Usar uma imagem com Maven e JDK 17 (para construir a aplicação)
FROM maven:latest AS build

# Definir diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo pom.xml e a pasta src
COPY pom.xml .
COPY src ./src

# Rodar o Maven para compilar e empacotar a aplicação
RUN mvn clean package -DskipTests

# Verificar o conteúdo do diretório target (listar os arquivos gerados)
RUN ls -l /app/target/

# Etapa 2: Usar uma imagem mais enxuta para rodar a aplicação (com JRE 17)
FROM openjdk:17-slim

# Definir diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado pela etapa anterior para o contêiner
COPY --from=build /app/target/*.jar /app/app.jar

# Expor a porta 8080 (porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
CMD ["java", "-jar", "/app/app.jar"]