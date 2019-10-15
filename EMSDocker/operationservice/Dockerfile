From java:8
WORKDIR usr/app
copy ./target/operations-0.0.1.jar /usr/app
run sh -c 'touch operations-0.0.1.jar'
ENTRYPOINT ["java","-jar","operations-0.0.1.jar"]