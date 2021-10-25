FROM maven:3.8.3-jdk-8
COPY / app/
WORKDIR app/
RUN mvn package
CMD java -jar ./target/iotrestapiexample-1.0-RELEASE.jar
