FROM maven:3-openjdk-15

WORKDIR /root
COPY . ./
RUN rm -rf /root/.m2
RUN mv ./docker-resources/.m2 /root/
RUN mvn clean package -DskipTests
RUN mv /root/main/target/*.jar /root/app.jar
RUN java -Djarmode=layertools -jar /root/app.jar extract

FROM 828770992256.dkr.ecr.eu-west-1.amazonaws.com/services-image:jdk-15
WORKDIR /var/app
COPY --from=0 /root/dependencies/ ./
COPY --from=0 /root/spring-boot-loader/ ./
COPY --from=0 /root/snapshot-dependencies/ ./
COPY --from=0 /root/project-dependencies/ ./
COPY --from=0 /root/application/ ./

CMD ["java", "org.springframework.boot.loader.JarLauncher"]
