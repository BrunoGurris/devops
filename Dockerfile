# Fase de build: Usar uma imagem base do Maven para compilar o projeto
FROM maven:3.8.5-openjdk-17 AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Fase de execução: Usar uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado da fase de build
COPY --from=build /app/target/*.jar app.jar

# Expor a porta em que a aplicação estará rodando
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
