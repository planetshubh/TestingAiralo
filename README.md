# TestingAiralo

# Airalo Testing Framework

## Overview
This repository provides a unified framework for both UI and API testing for Airalo's Test.
The solution covers:
 - UI Automation for verifying eSIM package details on Airalo's website.
 - API Automation for creating and validating eSIM orders using Airalo's Partner API.

## Test Tools used 
- Java 11
- Rest Assured for API Automation
- Selenide for UI Automation

## Setup Instructions
1. **Clone the repository**:
    ```bash
    git clone https://github.com/planetshubh/TestingAiralo.git
    cd TestingAiralo
    ```

2. **Install dependencies from pom.xml**:
    ```bash
    mvn clean install
    ```

## Running the Tests
1. **Run the API tests**:
    ```bash
    mvn test -Dtest=com.airalo.tests.APITest
    ```

2. **Run the UI tests**:
    ```bash
    mvn test -Dtest=com.airalo.tests.UITest
    ```

## Approach to Implementation

### Unified Framework for UI and API Testing

- **Token Generation**: Before API tests, generates an OAuth2 token using provided credentials.
- **Order Creation and Validation**: Automates the process of creating an order and validate the response using RestAssured.
- **UI Interaction**: Use Selenium WebDriver for automating interactions with Airalo's website.
- **Assertions**: Use TestNG assertions to validate both UI and API responses, ensuring data correctness and status codes.


### API Test Cases Steps
- **Authentication**: Obtain OAuth2 tokens.
- **Create Order**: POST an order for 6 eSIMs.
- **Validate Order**: GET the list of eSIMs and verify the order details. 
- ** Used the orderID to match if the orders generated in POST request are the same fetched by GET request and not some random order**

### UI Test Case Steps
- **Navigate to Airalo's website**.
- **Search for Japan**: In the search field, type "Japan" and select the destination from the "Local" section.
- **Select an eSIM Package**: Choose the first eSIM package and click "Buy Now."
- **Verify Package Details**: Asserted that the data displayed is as expected.
