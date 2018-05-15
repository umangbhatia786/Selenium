#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Deal data creation
Scenario: Create a new CRM Scenario
Given user is already on login page
When Title of the login page is Free CRM
Then user enters usename and password
|naveenk | test@123|
Then user clicks on login button
Then user is on home page
Then user moves to new deal page
Then user eneters deal details
| test deal | 1000 | 50 | 10 |
Then Close the browser
