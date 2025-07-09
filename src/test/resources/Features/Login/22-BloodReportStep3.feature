Feature: Onboarding Step 2 UI

Background: User should have completed until step 1
Given User is on uploading page and clicks upload blood report
When User clicks continue onboarding button 

Scenario: Verify  option selection in step 2 
Given User is in Step two for onboarding process 
When User selects one option from intensity
Then User should move to step three

Scenario: Verify navigation to Step 1
Given User is in Step two for onboarding process
When User clicks back button
Then User Should navigate back to Step one

Scenario: Verify Step 3 heading is visible
Given User is in Step two for onboarding process
When User selects one option from intensity
Then Page should display title "Your taste buds—what team are they on?" of blood report step two

Scenario: Verify step 3 sub text
Given User is in Step two for onboarding process
When User selects one option from intensity
Then Page should have sub text Select your dietary preference

Scenario: Progress bar reflects Step 3 of 5
Given User is in Step two for onboarding process
When User selects one option from intensity
Then Progress bar should visually indicate "Step 3 of 5" of blood report step3

Scenario: Verify options is displayed
Given User is in Step two for onboarding process
When User selects one option from intensity
Then User should see an option labeled  "All-inclusive diet,Vegetarian,Vegan" of step three

Scenario: Verify Back button is visible
Given User is in Step two for onboarding process
When User selects one option from intensity
Then Back button should be visible for steps

