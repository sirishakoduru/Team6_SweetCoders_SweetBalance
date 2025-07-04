Feature: validation for onboarding step 11

Background: User should have completed until  step 9 in onboarding process
Given User is on the upload page
When User clicks options upto step 9 to navigate to step ten by clicks No button in Step nine

Scenario: Verify user able to select multiple checkbox
Given User is in Step ten
When User checks more than one checkbox
Then User should see multiple checkbox selected

Scenario: Verify step 11 contain options to choose
When User clicks continue in step ten
Then User should see options "Easy 🦋","Medium 💪","Hard 🔥" in step ten

Scenario: Verify the title in step 11
When User clicks continue in step ten
Then User should see title "Pick your pace: chill stroll or marathon magic?" of step eleven.

Scenario: Verify the subtext in step 11
When User clicks continue in step ten
Then User should see subtext "Select your preferred exercise intensity level" of step 11

Scenario: Verify back button in step 11
When User clicks continue in step ten
Then User should see the back button in left down corner of the page

Scenario: Confirm the progress bar displays “Step 11 of 12".
When User clicks continue in step ten
Then Progress bar should visually indicate "Step 11 of 12" for step eleven.





