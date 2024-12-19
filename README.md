# Automation Testing Suite

This project contains an automation testing suite that encompasses both web automation tests for the way2automation.com. The tests are organized using TestNG, a popular testing framework in Java.

## Project Structure

```
├── src
│   └── test
│       ├── java
│       │   ├── base
│       │   │   └── BasePage.java
│       │   │   └── BaseTest.java
│       │   ├── Pages
│       │   │   └── CartPage.java
│       │   │   └── CheckoutPage.java
│       │   │   └── HomePage.java
│       │   │   └── LoginPage.java
│       │   │   └── RegisterPage.java
│       │   ├── tests
│       │   │   └── TestFlow.java
│       │   ├── utils
│       │   │   └── BrowserDriverFactory.java
│       │   │   └── Screenshots.java
│       ├── resources
│       │   ├── config.properties
├── pom.xml                                # Maven project configuration file
└── README.md                              # Project documentation
```

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java JDK** (version 17 or higher)
- **Maven** (version 3.6 or higher)
- An IDE (like IntelliJ IDEA or Eclipse) with Maven support

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/EamnNabil/OpencartAutomation.git
   cd way2automation
   ```

2. **Install dependencies**:
   Navigate to the project directory and run:
   ```bash
   mvn install
   ```

3. **Run the Test Suite**:
   You can run the entire test suite using Maven:
   ```bash
   mvn test
   ```

## Key Features

- Page Object Model (POM): Ensures modular and maintainable code.
- Cross-Browser Support: Configurable WebDriver.
- Reusable Components: Methods for interacting with dynamic elements.

## Improvements

- Implement the Data-Driven Testing technique to dynamically inject test data.
