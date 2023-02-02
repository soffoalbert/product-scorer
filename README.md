## The UML Diagram

        +--------------+
        |  Product     |
        +--------------+
        | - name: String |
        | - type: String |
        | - color: String |
        | - cost: double  |
        | - weight: double|
        | - score: double |
        +--------------+
                /\
                ||
                \/
        +--------------+
        |   Rule       |
        +--------------+
        | - conditions: List<Condition> |
        | - score: int  |
        | - negative: boolean |
        +--------------+
                /\
                ||
                \/
        +--------------+
        | Condition    |
        +--------------+
        | - attributeName: String |
        | - value: Object     |
        | - operator: String  |
        +--------------+



## How to Run the application on a command line

### Introduction
This guide will help you to run the application on a command line using Maven.

### Prerequisites

* Java JDK installed on your machine
* Maven installed on your machine
* A Java standalone application code

### Steps

Open the terminal/command prompt in the root directory of the application.

Run the following command to build the application using Maven:

```mvn clean install```

This will download all the dependencies specified in the pom.xml file and build the application.

Once the build is successful, you can run the following command to execute the application:

```java -jar target/assingment-clx-1.0-SNAPSHOT.jar```

The application should now be running.

### Conclusion
By following these steps, you should be able to run the application on a command line using Maven. If you encounter any issues, refer to the Maven documentation for more information.



