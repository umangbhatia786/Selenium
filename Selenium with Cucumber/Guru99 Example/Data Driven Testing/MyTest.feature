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
Feature: Reset functionality on login page of Application 
	Scenario Outline: Verification of Reset button 
	Given Open the Firefox and launch the application			
	When Enter the Username <username> and Password <password>		
	Then Reset the credential
	
	Examples:
	| username | password |
	| user1  | password1   |
	| user2 | password2   |
	| user3  | password3  |
	
	
	



	
