Feature: Verification on Diabetes Risk Analyzer functional

Background: User clicked on Check Your Risk button in home page

Scenario: Validate 'Cancel" button to return home page
Given User is in diabetes risk analyzer
When User clicks Cancel button
Then User should be returned to the home page

Scenario: Validation "Calculate Risk" button enabled 
Given User is in diabetes risk analyzer
When User enters values in all fields
Then User should see "Calculate Risk" button is  enabled

Scenario: Verify valid values in all field  dialog  form
Given User is in diabetes risk analyzer
When User clicks "Calculate Risk" button after entering valid values in all fields
Then User should see "Your Diabetes Risk Assessment" dialog box