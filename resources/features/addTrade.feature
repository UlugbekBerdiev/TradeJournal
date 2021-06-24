@Smoke
Feature: RC-5  Create add a Trade Functionality


  Scenario: As a user, I should be able to add a trade
    Given I am on the app sign in page
    When I enter valid username "Evren" and password "SuperEvren123!"
    And I click on trade sign in button 
    Then I should be in the trade homepage
    When I click on Add Trade button
    Then I should be on Save Trade Form
    When I enter following new trade details 
    |Buy to Open|DXF|04/12/2021|1.42|05/08/2021|1.72|
    And I click save button 
    Then the trade is displayed in the trade table