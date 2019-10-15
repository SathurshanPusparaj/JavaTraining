From java:8
WORKDIR usr/app
copy ./target/taskservice-0.0.1.jar /usr/app
run sh -c 'touch taskservice-0.0.1.jar'
ENTRYPOINT ["java","-jar","taskservice-0.0.1.jar"]