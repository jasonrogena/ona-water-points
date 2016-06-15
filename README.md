## Software Engineer Challenge Question

This repository holds code for the Ona Software Engineer Challenge question.

### Testing and Executing the Project

This is a Maven project. It's therefore need to have Maven installed on the machine you'd like to run it.

#### Running the Tests

To check whether all JUnit tests in the project checkout, run in the project's root directory:

```
mvn clean test
```

#### Executing the Project

To execute the project using the [default input URL](https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json), run:

```
mvn clean exec:java
```

You can also provide another URL with similarly structured data by running:

```
mvn clean exec:java -Dexec.args="[the input URL]"
```
