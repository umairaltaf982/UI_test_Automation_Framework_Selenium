﻿# UI_test_Automation_Framework_Selenium
# Selenium Test Project

## Overview
This project is a Selenium-based test automation framework for testing the login functionality, product search, product selection, and checkout process of an e-commerce website. The project uses Java, Maven, Cucumber, and TestNG for writing and executing tests.

## Project Structure
```
Selenium_test_1/
├── pom.xml
├── src/
│   ├── test/
│   │   ├── Features/
│   │   │   ├── login.feature
│   │   │   ├── selectProduct.feature
│   │   │   ├── beforeCheckout.feature
│   │   ├── java/
│   │   │   ├── stepDefinition/
│   │   │   │   ├── BaseTest.java
│   │   │   │   ├── LoginSteps.java
│   │   │   │   ├── SearchSteps.java
│   │   │   │   ├── selectProductSteps.java
│   │   │   │   ├── beforeCheckoutSteps.java
│   │   │   │   ├── TestRunners.java
│   │   │   ├── org/example/utils/
│   │   │   │   ├── CSVUtils.java
│   │   ├── resources/
│   │   │   ├── userdata.csv
```

## Dependencies
The project uses the following dependencies:
- `org.apache.commons:commons-csv:1.12.0`
- `org.slf4j:slf4j-simple:2.0.16`
- `io.cucumber:cucumber-java:7.20.1`
- `org.seleniumhq.selenium:selenium-java:4.25.0`
- `org.junit.jupiter:junit-jupiter-api:5.11.2`
- `io.cucumber:cucumber-junit:7.20.1`
- `io.qameta.allure:allure-cucumber7-jvm:2.29.0`
- `io.qameta.allure:allure-junit4:2.29.0`
- `io.qameta.allure:allure-java-commons:2.29.0`
- `org.testng:testng:RELEASE`

## Features

### 1. Login Functionality
**Feature File:** `src/test/Features/login.feature`
```gherkin
Feature: Feature to test login functionality

  Scenario: Check login is successful with valid credentials from CSV file
    Given User is on login page
    When user enters username and password from CSV
    And click on login button
    Then User is navigated to home page
```

**Step Definition:** `src/test/java/stepDefinition/LoginSteps.java`
- Reads credentials from `userdata.csv`.
- Performs login for each set of credentials.
- Asserts that the user is navigated to the home page.

### 2. Product Search
**Feature File:** `src/test/Features/search.feature`
```gherkin
Feature: Feature to test product search functionality

  Scenario: Check product search is successful
    Given User is on Dashboard page
    When User enters search credentials
    And click on search button
    Then User is navigated to product related detail page
```

**Step Definition:** `src/test/java/stepDefinition/SearchSteps.java`
- Enters search criteria.
- Clicks the search button.
- Asserts that the user is navigated to the product detail page.

### 3. Product Selection and Addition to Cart
**Feature File:** `src/test/Features/selectProduct.feature`
```gherkin
Feature: Selecting and Adding a Product to Cart

  Scenario: Successful Product Selection and Addition to Cart
    Given User is on the product details page
    When User selects the product
    And clicks the add to cart button
    Then Product is added to the cart
```

**Step Definition:** `src/test/java/stepDefinition/selectProductSteps.java`
- Selects a product.
- Adds the product to the cart.
- Asserts that the product is added to the cart.

### 4. Checkout Process
**Feature File:** `src/test/Features/beforeCheckout.feature`
```gherkin
Feature: Selecting the products in Cart before Checkout

  Scenario: Navigating to Checkout Page Successfully
    Given User is on the shopping cart page
    When User enter a random message
    And clicks the checkout button
    Then Checkout page will appear
```

**Step Definition:** `src/test/java/stepDefinition/beforeCheckoutSteps.java`
- Navigates to the shopping cart page.
- Enters a message.
- Clicks the checkout button.
- Asserts that the checkout page appears.

## Running the Tests
To run the tests, use the following command:
```shell
mvn test
```

## Reports
The test results are generated in the following formats:
- JUnit XML: `target/JUnitReport.xml`
- JSON: `target/JsonReport.json`
- HTML: `target/HtmlReport.html`
- Allure: `target/allure-results`

## CSV Data
The credentials for login tests are stored in `src/test/resources/userdata.csv`:
```csv
username,password
user1,password1
user2,password2
user3,password3
user4,password4
```

## Utility Classes
**CSVUtils:** Utility class for reading CSV files.
```java
package org.example.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> records = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                records.add(new String[]{record.get("username"), record.get("password")});
            }
        }
        return records;
    }
}
```

## Test Runner
**TestRunners:** Class to run the Cucumber tests.
```java
package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReport.xml",
                "pretty", "json:target/JsonReport.json",
                "pretty", "html:target/HtmlReport.html",
                "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunners {

}
```

## Conclusion
This project provides a comprehensive test automation framework for an e-commerce website, covering login, product search, product selection, and checkout functionalities. The use of Cucumber and Allure ensures readable test scenarios and detailed reporting.
