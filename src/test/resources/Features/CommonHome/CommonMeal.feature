Feature: Validation on meal section
  Background: 
#    Given User is logged into the app
    
  Scenario: Verify each meal section is clickable to show details
    Given User is on home page
    When User clicks on the "Breakfast" section
    Then Breakfast details become visible
    
  Scenario: Verify lunch section is clickable to show details
    Given User is on home page
    When User clicks on the "Lunch" section
    Then Lunch details become visible
    
  Scenario: Verify dinner section is clickable to show details
    Given User is on home page
    When User clicks on the "Dinner" section
    Then Dinner details become visible
    
  Scenario: Verify snacks section is clickable to show details
    Given User is on home page
    When User clicks on the "Snacks" section
    Then Snacks details become visible