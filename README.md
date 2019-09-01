# Google Tests

Google Tests is a project for UI testing using Selenium WebDriver and Cucumber for BDD style.

## Installation

Clone repository to your local storage

```bash
git clone https://github.com/vitaliidzubenko/GoogleTask.git
```
## Running Tests
From Test.class
```bash
TestRunner.class or BddRunner.class
```
From terminal:
```bash
mvn -Dtest=BddRunner clean test verify
mvn -Dtest=TestRunner clean test
```
From properties file:
```bash
testng.xml
```
## Reporting
To generete Allure Report run command in terminal:
```bash
mvn allure:serve
```
Report for BDD style will be generated automatically after test run.

Reports can be found here (Cucumber and Allure)
```bash
target/cucumber-reports/cucumber-pretty
target/cucumber-reports/advanced-reports
and
target/allure-results
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
This project is fully open-sourced