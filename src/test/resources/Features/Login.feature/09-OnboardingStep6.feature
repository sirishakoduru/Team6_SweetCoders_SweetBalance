Feature: Functional test for Onboarding Step 5 and non functional scenarios for Step 6

Background: User should have completed until  step 4 in onboarding process
Given User is on the upload page
When User clicks options of step 1,2,3 and 4 to navigate to step five

Scenario: Validate notification message for weight option less than 59 
Given User is in step five
When User selects a weight option less than 59 
Then User should see notification text "Light as a feather! But don't worry, our recipes will keep you grounded. 🪶"

Scenario: Validate notification message for weight option between 60 -84
When User selects a weight option between 60 -84
Then User should see notification text "Perfectly balanced, as all things should be! ⚖️"

Scenario: Validate notification message for weight option greater than 85	
When User selects a weight option greater than 85
Then User should see notification text "More of you to love! And more energy to power those workouts. 💪"

Scenario: Validate user able to select from option in kilogram
When User selects from options available in kilogram
Then User should redirect to Step six

Scenario: Validate user able to select from option in pound
When User clicks back button in step five
Then User should redirect to Step four

Scenario: Verify the functionality of the Back button in Step 5
When User selects from options available in pound
Then User should redirected to step four

Scenario: Ensure the heading for Step 6 is visible
When User selects from options available in pound
Then Page should display title "Your taste buds—what team are they on?" of Step six

Scenario: Verify the subtext displayed in Step 6
When User selects from options available in pound
Then User should see sub text "Select your dietary preference" of step six

Scenario: Confirm the progress bar displays “Step 6 of 12.
When User selects from options available in pound
Then Progress bar should visually indicate "Step 6 of 12" of step six

Scenario: Check that the Back button is visible in Step 6
When User selects from options available in pound
Then Back button should be visible in step six

Scenario: Ensure Step 6 contains options to select dietary preference
When User selects from options available in pound
Then User should see options labeled "All-inclusive diet 🍴🍖🍎,Vegetarian 🥗🍆🥕,Vegan 🥬🌱🌿" for step six




