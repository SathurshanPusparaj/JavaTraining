From java:8
WORKDIR usr/app
copy ./target/projectservice-0.0.1.jar /usr/app
run sh -c 'touch projectservice-0.0.1.jar'
ENTRYPOINT ["java","-jar","projectservice-0.0.1.jar"]