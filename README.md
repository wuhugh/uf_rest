# UF Resources

http://uf-rest.herokuapp.com/


This repo aims to provide a uniform and convenient way to retrieve data from UF's various APIs such as their courses and
events. It's basically a proxy for their resources. See the [UF API](https://github.com/Rolstenhouse/uf_api) for the resources that are currently available (from UF's website, not this one).

Currently there is only the `/courses` endpoint up. It's located at `http://uf-rest.herokuapp.com/courses/{year}/{semester}` where `year` is a four digit year (ex: 2018) and `semester` is either `spring`, `summer`, or `fall`. For some reason the actual data isn't being serialized so it is returning a string (literally a very long string in JSON format) for now.


## Building the Project
Prerequisites:
  - [Apache Maven](https://maven.apache.org/download.cgi)
  - [Spring Boot](https://projects.spring.io/spring-boot/)
  
The pom.xml file should contain the Spring Boot dependencies, but you can also include the JARs from their website. Spring Boot should also include the Jackson JSON libraries for reading and writing Java objects into JSON.

To build the application, run `mvn package` from the root directory and a .jar file should be created in the `target/` directory. Run `java -jar <generated-jar-filename>` to start the web server and navigate to `localhost:8080`.

To just run the application, run `mvn spring-boot:run` and the web server should start up.

If you want to debug the project on IntelliJ, right click on the Application.java file and run debug. It should start the web server as well as let you put breakpoints in the code.


## Useful Links
- https://github.com/Rolstenhouse/uf_api
- https://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/
- http://www.studytrails.com/java/json/java-jackson-introduction/
