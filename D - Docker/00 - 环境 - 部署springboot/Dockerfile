FROM openjdk:8
ENV workdir=/root/springcloud/eureka
COPY . ${workdir}
WORKDIR ${workdir}
EXPOSE 8761
CMD ["java","-jar","eureka-server.jar"]