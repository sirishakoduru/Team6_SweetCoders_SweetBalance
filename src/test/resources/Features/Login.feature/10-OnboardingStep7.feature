Feature: Functional test for onboarding step 6 and non functional scenarios for step 7

Background: User should have completed until  step 5 in onboarding process
Given User is on the upload page
When User clicks options of steps 1,2,3.4 and 5 to navigate to step six

Scenario: Verify cuisine options 
Given User is in step six
When User selects from the options in step six
Then User should redirect to step seven

Scenario: Verify options in step 7
When User selects from the options in step six
Then User should see options "Indian 🍛, American 🍔, Continental 🥖, Mediterranean 🥙, Asian 🍜, Middle Eastern 🥙, Mexican 🌮" in step seven

Scenario: Verify heading for step 7 is visible
When User selects from the options in step six
Then User should see title "What's your go-to food passport?"

Scenario: Verify subtext for step 7 is visible 
When User selects from the options in step six
Then User should see subtext "To create a meal plan you'll enjoy, please select your preferred cuisines!" of step seven

Scenario: Confirm the progress bar displays “Step 7 of 12".
When User selects from the options in step six
Then Progress bar should visually indicate "Step 7 of 12" of step seven

Scenario: Verify back button is visible in step 7
When User selects from the options in step six
Then User should see the back button in left down corner of the page

