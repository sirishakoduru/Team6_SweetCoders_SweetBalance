Feature: Validation for onboarding step 12

Background: User should have completed until  step 10 in onboarding process
Given User is on the upload page
When User clicks options upto step 11 to navigate to step twelve

Scenario: Verify title in step 12
Given User is in Step eleven
When User clicks option from the preferred intensity level
Then User should see the title "Final Step- What’s your latest HbA1c number?!" inStep twelve.

Scenario: Verify input field is displayed in step 12
When User clicks option from the preferred intensity level
Then User should see input field with Text "Enter your HbA1c value(e.g.,7.0)"

Scenario: Verify the text below the input field
When User clicks option from the preferred intensity level
Then User should see the text "Please enter a value between 4.0 and 15.0" in Step twelve

Scenario: Verify step 12 has continue button
When User clicks option from the preferred intensity level
Then User should see "Continue" Continuebutton

Scenario: Verify the description in step 12
When User clicks option from the preferred intensity level
Then User should see description "HbA1c measures your average blood sugar levels over the past 2-3 months. This important value helps us create a personalized diabetes management plan tailored specifically to your needs."

Scenario: Verify the back button in step 12
When User clicks option from the preferred intensity level
Then User should see the back button in left down corner of the page

Scenario: Confirm the progress bar displays “Step 12 of 12".
When User clicks option from the preferred intensity level
Then Progress bar should visually indicate "Step 12 of 12" of step twelve.