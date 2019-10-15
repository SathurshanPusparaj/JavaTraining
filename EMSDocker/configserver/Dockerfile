FROM java:8
WORKDIR /usr/app
copy ./target/configserver-0.0.1.jar /usr/app
run sh -c 'touch configserver-0.0.1.jar'
ENTRYPOINT ["java","-jar","configserver-0.0.1.jar"]