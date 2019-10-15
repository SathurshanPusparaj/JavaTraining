From java:8
WORKDIR usr/app
copy ./target/emsservice-0.0.1-SNAPSHOT.jar /usr/app
run sh -c 'touch emsservice-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","emsservice-0.0.1-SNAPSHOT.jar"]