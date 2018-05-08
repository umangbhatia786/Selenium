Feature: Reset functionality on login page of Application 
	Scenario Outline: Verification of Reset button 
	Given Open the Firefox and launch the application			
	When Enter the Username <username>and Password <password>		
	Then Reset the credential
	Examples:                      		

|username  |password         |		

|User1     |password1        |		

|User2     |password2        |		

|User3     |password3        |
