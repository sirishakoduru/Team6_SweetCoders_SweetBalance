Feature: Validation for onboarding step 8

Background: User should have completed until  step 6 in onboarding process
Given User is on the upload page
When User clicks options upto step 6 to navigate to step seven

Scenario: verify yes ,no options are displayed in step 8
Given User is in step 7
When User selects from one of the cuisine options in step 7
Then User should see options yes ✅ ,No❌ in step 8

Scenario: Verify heading for step 8 is visible
When User selects from one of the cuisine options in step 7
Then User should see title "Allergic to any foods?" of step eight

Scenario: Verify subtext for step 8 is visible
When User selects from one of the cuisine options in step 7
Then User should see subtext "Select yesif you have any food allergies" of step eight.

Scenario: Verify back button is visible in step 8
When User selects from one of the cuisine options in step 7
Then User should see the back button in left down corner of the page

Scenario: Confirm the progress bar displays “Step 8 of 12".
When User selects from one of the cuisine options in step 7
Then Progress bar should visually indicate "Step 8 of 12" in step eight

