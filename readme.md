### Overview
Tool that analyzes text and returns back tone analysis on the text. It uses 
IBM Watson's Tone Analyzer to do the analysis. 

#### Usage

The following properties need to be set in the application:

* watson.toneanalyzer.username
* watson.toneanalyzer.password

You can get these credentials for yourself by signing up at [IBM bluemix](https://www.ibm.com/cloud-computing/bluemix/). Once you've signed up there, you can click around until you find the Watson space and then sign up for the Tone Analyzer service.

Run via a jar:

    ./gradlew assemble
    java -jar build/libs/toneanalyzer.jar --watson.toneanalyzer.password=password --watson.toneanalyzer.username=username
    
Run via gradle:

    echo -e "--watson.toneanalyzer.password=password\n--watson.toneanalyzer.username=username"
    ./gradlew bootRun

Post text for analysis:

    curl -X POST --header "Content-Type: application/json" -d '{"text":"This is a test"}' localhost:8080/toneAnalysis


#### Technologies used 

* [Watson's Tone Analyzer](https://www.ibm.com/watson/developercloud/tone-analyzer.html)
* [Gradle](https://gradle.org/)
* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring Actuator](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)
* [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)