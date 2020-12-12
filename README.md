# Gmail
GmailReceived


Gmail-received Selenium BDD project 

Project Repository:

Clone project from GitHub Repository : 
         https://github.com/LakshmaTandra/Gmail


Tests Execution:

Feature: To verify an email from a gmail account is received successfully on another gmail account.
1- scenario written in cucumber gherkin syntax to verify the email received feature.

Tests configured to Run on Chrome Browser.

Install the maven.
Open terminal navigate to project folder: $ cd <ProjectName>
Run command:  $ mvn clean verify

Project_framework:
Behavioural driven development automation framework using selenium, cucumber-java, Junit, maven.
Tools and technologies used:
Language: Java
Testing framework: Junit
BDD framework: Cucumber-jvm
Automation tool: Selenium Webdriver
Build tool: maven
Reporting: cucumber reporting

Features of the framework
 - BDD framework using Cucumber-jvm. Feature files can be written easily using Given,When, Then etc.
 - Browser(Chrome/ Firefox/Edge) can be configured in config.properties file.
 - Url is configured in config.properties file.
 - Html report gets generated after each test run and can be found /target/cucumber-html-report folder.



package(under src/test/resources): features : It contains all Features and Scenarios defined in .feature file.



package(under src/test/java):Steps: Contains 
 - Hooks : for browser setup and teardown.
 - StepDefinitions : contains excution for each feature step defined in feature file




package(under src/test/java) Runner:
 - TestRunner.java : Features to be executed are defined in this class. Other test configurations are also defined here.



package(under src/test/java) pages: A POM model for defining web pages. Element locators and methods corresponding to each page are defined.



pom.XML file : List all the dependencies required for execution.

config.properties file : Used for environment configuration (such as url or browser).

screenshot folder : Saves all screenshots for failed scenarios

target folder : for HTML reports.

