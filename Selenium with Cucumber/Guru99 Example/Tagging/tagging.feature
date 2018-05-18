#This feature file is used to understand the concept of tagging
@FunctionalTest
Feature: Free CRM Application Test

  @SmokeTest @RegressionTest
  Scenario: Login with correct Username and correct Password
    Given This is a Login Test

  @RegressionTest
  Scenario: Login with incorrect Username and correct Password
    Given This is an incorrect Login Test

  @SmokeTest
  Scenario: Create a contact
    Given This is a contact test case

  @SmokeTest @RegressionTest
  Scenario: Create a deal
    Given This is a deal test case

  @RegressionTest
  Scenario: Create a task
    Given This is a task test case

  @SmokeTest
  Scenario: Create a case
    Given This is a case test case

  @SmokeTest @RegressionTest
  Scenario: Verify left panel links
    Given Clicking on left panel links

  @SmokeTest
  Scenario: Search a deal
    Given This is a search deal test case

  @SmokeTest
  Scenario: Search a contact
    Given This is a search contact test case

  @SmokeTest @RegressionTest
  Scenario: Search a case
    Given This is a search case test case

  @SmokeTest @RegressionTest
  Scenario: Search a task
    Given This is a search task test case

  @SmokeTest @End2EndTest
  Scenario: Search a call
    Given This is a search call test case

  @SmokeTest @End2EndTest
  Scenario: Search an email
    Given This is a search email test case

  @SmokeTest @End2EndTest
  Scenario: Search a form
    Given This is a search form test case

  @SmokeTest @End2EndTest
  Scenario: Search a doc
    Given This is a search doc test case

  @End2EndTest
  Scenario: Validate a report
    Given This is a validation test

  @End2EndTest
  Scenario: Application logout
    Given This is a logout test
