From java:8
WORKDIR usr/app
copy ./target/models-0.0.1.jar /usr/app
run sh -c 'touch models-0.0.1.jar'
ENTRYPOINT ["java","-jar","models-0.0.1.jar"]