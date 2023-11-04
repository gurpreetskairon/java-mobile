# Cucumber BDD Framework with Appium for Mobile Native App Automation

## Overview

This project is a Java Maven project that demonstrates how to use the Cucumber BDD (Behavior-Driven Development) framework with Appium for mobile native app automation. This combination allows you to write human-readable scenarios and automate the testing of mobile applications.

## Prerequisites

Before you begin, make sure you have the following prerequisites installed on your system:

- Java Development Kit (JDK) 8 or higher
- Maven (latest version)
- Appium (latest version)
- Android SDK (for Android app automation) or Xcode (for iOS app automation)
- Mobile device or emulator/simulator with the app to be tested installed

## Project Structure

The project structure is organized as follows:

```
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- framework
|   |   |   |   |-- Element.java
|   |   |   |   |-- TestDriver.java
|   |   |-- resources
|   |   |   |-- AppiumConfig.properties
|   |-- test
|   |   |-- java
|   |   |   |-- features
|   |   |   |-- pages
|   |   |   |-- steps
|   |   |   |   |-- Hooks.java
|   |   |   |   |-- TestRunner.java
|   |   |-- resources
|   |   |   |-- ApiDemos-debug.apk
|-- pom.xml
|-- README.md
```

- `src/main/java/framework`: This is where you can find the framework code.
- `src/test/resources/features`: This is where you can find Cucumber feature files.
- `src/test/resources/pages`: This is where you can find Page Object Model files.
- `src/test/resources/features`: This is where you can find step definition files.

## Getting Started

1. Clone this repository to your local machine.

2. Open the `pom.xml` file and ensure that the following dependencies are added:
    - `io.appium:java-client`: Appium Java client library.
    - `io.cucumber:cucumber-java` and `io.cucumber:cucumber-junit`: Cucumber BDD framework.
    - `junit:junit`: JUnit for running your Cucumber tests.
    - Other necessary dependencies.

3. Configure your `src/main/resources/AppiumConfig.properties` file to specify the device configurations, app paths, and other settings needed for Appium.

4. Create your Cucumber feature files in `src/test/resources/*.apk`. .

5. Implement your Cucumber step definitions in `src/test/java/steps/*.java`.

6. Run your Cucumber tests by executing the `TestRunner.java` class.

## Running Tests

You can run your Cucumber tests using Maven. To run all tests, execute the following command in the project root directory:

```bash
mvn clean test
```

## Reporting

The Cucumber framework will generate HTML reports in the `target/cucumber-reports` directory after test execution. You can view these reports to see the test results and identify any issues.

