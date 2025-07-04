@verification

Feature: Verification on  button navigation in home page


Background:  User logged onto the application
Scenario: Verify user able download weekly plan
When User clicks Weekly plan 
Then User should get pdf download of weekly plan 

When User clicks on Blood glucose button
Then User should redirect to Blood Glucose popup window

When User clicks on physical activity button
Then User should redirect to physical activity popup window

When User clicks on food intake button
Then User should redirect to food intake popup window

When User clicks on medication button
Then User should redirect to medication popup window

When User clicks log button
Then User should redirected to dashboard page 










