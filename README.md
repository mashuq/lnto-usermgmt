# lnto-usermgmt
Learn &amp; Teach Online User Management Microservice

Build the project:
mvn install -P dev -Dspring-boot.run.profiles=dev -DskipTests

Run the project:
mvn -P dev spring-boot:run -Dspring-boot.run.profiles=dev -DskipTests

Test the project:
mvn test  -P test -Dspring-boot.run.profiles=test