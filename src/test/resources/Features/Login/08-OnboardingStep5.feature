Feature: Functional test for Onboarding Step 4 and non functional scenarios for Step 5

Background: User should have completed until step 3 in onboarding process
Given User is on the upload page
When User clicks options of step 1,2 and 3 to navigate to step 4

Scenario: Validate notification message for height above 180 cm
Given User is in Step four
When User selects a height option greater than 180 cm
Then User should see notification "How's the weather up there? (Sorry, we had to do it once) 🌤️"

Scenario: Validate notification message for height below 159
Given User is in Step four
When User selects a height option less than 159
Then User should see notification "Good things come in smaller packages! 📦"

Scenario: Validate notification message for  height between 160-179
Given User is in Step four
When User selects a height option between 160-179
Then User should see notification "Right in the middle - you can reach shelves AND fit in airplane seats! ✈️"

Scenario: Validate user able to select from option in centimeters
Given User is in Step four
When User selects from options available in centimeters
Then User should redirect to Step five

Scenario: Validate user able to select from option in feet & inches
Given User is in Step four
When User selects from options available in feet & inches
Then User should redirect to Step five

Scenario: Verify the functionality of the Back button in Step 4.
Given User is in Step four
When User clicks back button in step four
Then User should redirected to step three

Scenario: Ensure the heading for Step 5 is visible 
Given User is in Step four
When User selects from options available in feet & inches
Then Page should display title "How much awesome do you weigh?" for weight

Scenario: Verify the subtext displayed in Step 5
Given User is in Step four
When User selects from options available in feet & inches
Then User should see sub text "We will personalize your nutrition plan to guide you towards your goals!" for weight

Scenario: Confirm the progress bar displays “Step 5 of 12.
Given User is in Step four
When User selects from options available in feet & inches
Then Progress bar should visually indicate "Step 5 of 12" of step five

Scenario: Check that the Back button is visible in Step 5
Given User is in Step four
When User selects from options available in feet & inches
Then Back button should be visible in step five

Scenario: Ensure Step 5 contains two tabs for selecting weight
Given User is in Step four
When User selects from options available in feet & inches
Then 2 tab option should be present

Scenario: Verify the first tab in Step 5 is visible
Given User is in Step four
When User selects from options available in feet & inches
Then 1st tab should have Kilograms

Scenario: Verify the second tab in Step 5 is visible
Given User is in Step four
When User selects from options available in feet & inches
Then 2nd tab should have Pounds

Scenario: Validate values for kilograms options
Given User is in Step four
When User selects from options available in feet & inches
Then Kilogram option should have 40 to 190 kg

Scenario: Validate values for pounds options
Given User is in Step four
When User selects from options available in feet & inches
Then Pounds options should have 90 to 550 lbs   

