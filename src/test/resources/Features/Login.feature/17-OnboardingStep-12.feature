Feature: Validation for non functional features in step 12 and personalised screen

Background: User should have completed until  step 11 in onboarding process
Given User is on the upload page
When User clicks options upto step 11 to navigate to step twelve

Scenario: Verify user cannot enter invalid HbA1c value
Given User is in step 12
When User tries to enter an invalid HbA1c value in the input field
Then User should see the input field does not accept value

Scenario: Verify user able to enter valid HbA1c value
When User enters valid range of value in input field 
Then User should see input field accept the value

Scenario: Verify user can proceed after entering a valid HbA1c value
Given User is on Step 12 of the onboarding process after entering a valid HbA1c value 
When User clicks continue
Then User should see success message

Scenario: Verify personalization screen appears after clicking Continue
When User clicks continue
Then User should see a loading indicator 

Scenario: Verify the message in personalised screen
When User clicks continue
Then User should see the message "Getting you all set—like a VIP pass to better health!" success.

Scenario: Verify the subtext in personalised screen
When User clicks continue
Then User should see the subtext "Just a moment while we personalize your experience" on screen

Scenario: Verify Upgrade to Plus screen is displayed after personalization loading
Given User is on loading personalised screen 
When User views the screen
Then User should be navigated to the "Upgrade to Plus" screen after loading personalised screen