Feature: Onboarding Step 1 UI

Background: User clicks onboarding button after reaching to report analysis
Given User is on uploading page and clicks upload blood report
When User clicks continue onboarding button 

Scenario: Verify Step 2 heading is visible
Given User is in step 1 for onboarding process
When User clicks continue after filling form
Then Page should display title: "Pick your pace: chill stroll or marathon magic" of blood report step2

Scenario: Verify subtitle is visible
When User clicks continue after filling form
Then Page should show text: "Select your preferred exercise intensity level"

Scenario: Verify Back button is visible
When User clicks continue after filling form
Then Back button should be visible for blood report steps

Scenario: Verify Step 2 progress bar is filled
When User clicks continue after filling form
Then Progress bar should reflect "Step 2 of 5" as filled

Scenario: Verify presence of all 3 intensity options
When User clicks continue after filling form
Then User should see options "Easy , Medium , Hard "
