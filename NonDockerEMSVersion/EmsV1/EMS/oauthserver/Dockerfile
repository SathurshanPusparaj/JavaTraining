From java:8
WORKDIR usr/app
copy ./target/oauthserver-0.0.1-SNAPSHOT.jar /usr/app
run sh -c 'touch oauthserver-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","oauthserver-0.0.1-SNAPSHOT.jar"]