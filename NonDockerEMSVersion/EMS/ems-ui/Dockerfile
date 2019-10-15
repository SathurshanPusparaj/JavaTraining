From java:8
WORKDIR usr/app
copy ./target/ems-ui-0.0.1-SNAPSHOT.jar /usr/app
run sh -c 'touch ems-ui-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ems-ui-0.0.1-SNAPSHOT.jar"]