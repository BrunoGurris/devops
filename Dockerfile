# Etapa 1: Usar uma imagem base com Maven para construir a aplicação
FROM maven:3.8.3-openjdk-17-slim AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e as dependências para o diretório de trabalho
COPY . .

# Compile e empacote a aplicação Spring Boot em um JAR
RUN mvn clean install -DskipTests

# Etapa 2: Usar uma imagem mais enxuta para rodar a aplicação (sem o Maven)
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado na etapa anterior para o contêiner
COPY --from=build . .

# Exponha a porta 8080 para acessar a aplicação
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot no contêiner
ENTRYPOINT ["java", "-jar", "app/target/app.jar"]
