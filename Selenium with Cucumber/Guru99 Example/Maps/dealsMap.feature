#This feature file is to learn the concept of mapping in cucumber
Feature: Deal data creation

  @End2EndTest
  Scenario: Create a new CRM Scenario
    Given user is already on the login page
    When title of the login page is Free CRM
    Then user enters the usename and password
      | username | password |
      | naveenk  | test@123 |
    Then user clicks on the login button
    Then user is on the home page
    Then user moves to the new deal page
    Then user enters deal details
      | title      | amount | probability | comission |
      | test deal1 |   1000 |          50 |        10 |
      | test deal2 |   2000 |          60 |        20 |
      | test deal3 |   3000 |          70 |        30 |
    Then close the browser
