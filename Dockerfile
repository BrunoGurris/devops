FROM maven:3.8.3-openjdk-17

ENV PROJECT_HOME /app
ENV JAR_NAME app.jar

# Create destination directory
RUN mkdir -p $PROJECT_HOME
WORKDIR $PROJECT_HOME

# Bundle app source
COPY . .

# Package the application as a JAR file
RUN mvn clean install -DskipTests

# Move file
RUN mv $PROJECT_HOME/target/$JAR_NAME $PROJECT_HOME/

EXPOSE 8080

ENTRYPOINT ["mvn", "spring-boot:run"]