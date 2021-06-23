@Delete		@Smoke
Feature: RC-8 Delete Button Functionality
			
			User should be able to delete stocks from the table view and data base
			by clicking on the delete button

	
Scenario: RC-59 Verify that user can successfully delete stock table in UI

		Given That user is on login page
    And the user enters valid username "Hakan" and password "SuperHakan123!" and clicks SignIn
    Then User should be directed to home page
		Then verify user is on the home page
		When the user clicks on the delete button
		Then a pop-up modal should appear with the text: Are you sure you want to delete this record?
		When the user clicks on Ok button
		Then the modal should close and the system should delete that particular stock from the table view
	
		
Scenario: RC-59 Verify that user can navigate from deleting a stock back to home page	
		
		Given That user is on login page
    And the user enters valid username "Hakan" and password "SuperHakan123!" and clicks SignIn
    Then User should be directed to home page
		Then verify user is on the home page
		When the user clicks on the delete button
		Then a pop-up modal should appear with the text: Are you sure you want to delete this record?
		When the user clicks on Cancel button
		Then the modal should close without anything been deleted
		
		
		

