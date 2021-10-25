FROM maven:3.8.3-jdk8
COPY / app/
WORKDIR app/
RUN mvn clean install
CMD ["java -jar ./target/iotrestapiexample-1.0-RELEASE.jar"]