## Tests Included

1. **Login Functionality:**
   - Test successful and unsuccessful login scenarios.
   
2. **Add Product to Cart:**
   - Add a specific product to the cart and verify its presence.
   
3. **End-to-End Purchase Process:**
   - Perform a complete purchase process from login to order confirmation.

## Features and Scenarios

1. **Login Feature:**
   - Scenario: Submitting a Login form with vaid credentials.

2. **Login Feature:**
   - Scenario: Submitting a Login form with a invalid password.
   
3. **Add Product to Cart Feature:**
   - Scenario: Add "Sauce Labs Backpack" to cart and verify its presence.
   
4. **End-to-End Purchase Feature:**
   - Scenario: Complete the purchase process from login to order confirmation.

### Table of summary tests an scenarios

| **Test**                     | **Scenario (Test Case)**         | **Summary Description**                           |
|-------------------------------|----------------------------------|---------------------------------------------------|
| Login                         | Successful login                 | Tests login with "standard_user" and "secret_sauce". |
| Login                         | Failed login                     | Tests login with "standard_user" and "secret_sauce1". |
| Add Product to Cart           | Add "Sauce Labs Backpack"        | Adds product and verifies in cart.                |
| End-to-End Purchase           | Complete purchase process        | Login, add product, checkout, and order confirmation. |


## How to Clone and Run the Project

1. **Clone the Repository:**
```bash
   git clone https://github.com/jandersonj/swaglabs-automations
```

### Navigate to the Project Directory:
```bash
cd swaglabs-automations
```

### Run the Tests:
```bash 
mvn test
```


## Ensure Dependencies:

* Java 21
* Maven 3.9.9 or compatible version



## Notes

- The project uses BDD with Cucumber for defining tests in natural language. 
- The site tested is [Saucedemo.com](https://www.saucedemo.com/), which may change over time. If elements or URLs change, the tests may need to be updated.
- For more information on the tools used: 
  [Selenium](https://www.selenium.dev/), 
  [Cucumber](https://cucumber.io/docs), 
  [TestNG](https://testng.org/doc/index.html), 
  [WebDriverManager](https://bonigarcia.dev/webdrivermanager/).

