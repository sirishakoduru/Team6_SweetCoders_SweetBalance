Feature: validation for onboarding step 10

Background: User should have completed until  step 9 in onboarding process
Given User is on the upload page
When User clicks options upto step 8 to navigate to step ten by clicks No button

Scenario: Verify step 10 contains the list of other medical conditions
Given User is in Step ten
When User clicks No button
Then User should see the option in step ten "High Blood Pressure, High Cholesterol, Heart Disease, PCOS (Polycystic Ovary Syndrome), Chronic kidney disease Third-stage kidney disease patients should not follow the meal plan., Gastroesophageal reflux disease, Anemia, Hypothyroidism, Hyperthyroidism, None of the above"

Scenario: Validate title in step 10
When User clicks No button
Then User should see title "Any medical quirks worth mentioning?"

Scenario: Validate subtext in step 10
When User clicks No button
Then User should see subtext "Do you have any other medical conditions?" of Step ten.

Scenario: verify back button in step 10
When User clicks No button
Then User should see the back button in left down corner of the page

Scenario: Confirm the progress bar displays “Step 10 of 12".
When User clicks No button
Then Progress bar should visually indicate "Step 10 of 12" of step ten