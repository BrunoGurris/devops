# Usar uma imagem base do Maven com OpenJDK
FROM maven:3.8.5-openjdk-17-slim AS build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml .

# Copiar os arquivos do código fonte
COPY src ./src

# Executar o Maven para construir a aplicação
RUN mvn clean package -DskipTests

# Usar uma imagem base do OpenJDK para a aplicação
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expor a porta que a aplicação Spring Boot usará
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
