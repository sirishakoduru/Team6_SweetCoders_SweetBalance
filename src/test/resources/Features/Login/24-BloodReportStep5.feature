Feature: Onboarding Step 5 UI

Background: User should have completed until step 5
Given User is on uploading page and clicks upload blood report
When User clicks continue onboarding button

Scenario: Verify back button function 
Given User is in step five of uploading blood report
When User clicks back button
Then User should navigate to step four

Scenario: Verify single selection in allergy
Given User is in step five of uploading blood report
When User selects single allergy and clicks submit
Then User should navigate to subscription details

Scenario: Verify multiple selection in allergy
Given User is in step five of uploading blood report
When User selects multiple allergies and clicks submit
Then User should navigate to "Upgrade to premium plus" after submitting form
