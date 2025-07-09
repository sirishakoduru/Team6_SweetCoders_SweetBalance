Feature: Functional test for Onboarding Step 2 and non functional scenarios for Step 3

Background: User should have completed until step 1 in onboarding process
Given User is on the upload page
When User goes to step 1 after clicking onboarding button and completes step 1

Scenario: Verify back button function in Step 2
Given User is in step 2
When User clicks back button in step 2
Then User should redirected to step 1

Scenario: Verify option is selectable
Given User is in step 2
When User selects a gender  in step 2
Then User should navitae to step 3

Scenario: Verify Step 3 heading is visible
Given User is in step 2
When User selects a gender  in step 2
Then Page should display title "Age: own it, pick your number." here

Scenario: Verify step 3 sub text
Given User is in step 2
When User selects a gender  in step 2
Then User should see sub text "Please select your age"

Scenario: Progress bar reflects Step 3 of 12
Given User is in step 2
When User selects a gender  in step 2
Then Progress bar should visually indicate "Step 3 of 12" of step three

Scenario: Verify Back button is visible in step 3
Given User is in step 2
When User selects a gender  in step 2
Then Back button should be visible

Scenario: Verify user should able to scroll the iframe to see options
Given User is in step 2
When User selects a gender  in step 2
Then iframe options should have scroll option

Scenario: Verify options is displayed in step 3
Given User is in step 2
When User selects a gender  in step 2
Then User should see options for age "18 years to 100 years "