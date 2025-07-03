Feature: Food Intake Tracker Functional Testing

  Background:
    Given User Food Intake in tracker

  Scenario: Verify user able to save food entry with valid data
    Given User is in the Breakfast section of the Food Intake Tracker
    When User clicks save food entry after entering valid
    Then User should see "Food Entry is recorded"

  Scenario: Verify user able to save food entry with invalid value
    When User clicks save food entry button after entering invalid value in food name
    Then User should see alert with message "Failed to save food intake"

  Scenario: Verify custom field in serving size
    When User selects custom option in serving size
    Then User should see new input field added below the serving field

  Scenario: Verify user error message for invalid value in calorie using calculator
    When User enters invalid value in food name
    Then User should see error message "Please enter valid food name"

  Scenario: Verify the presence of automatic calorie calculation in calorie field
    When User enters valid food name
    Then User should see calorie value for the food name calculated automatically

  Scenario: Verify the presence of helper text after automatic calorie calculation
    When User enters valid food name
    Then User should see helper text after automatic calorie calculation

  Scenario: Verify helper text after automatic calorie calculation
    When User enters valid food name
    Then User should see "Calories calculated automatically. You can edit if needed." as helper text in calorie field

  Scenario: Verify the automatic calorie value change after selecting serving size
    When User changes serving size from the default value after entering the food name
    Then User should see change value in calorie

  Scenario: Verify user able to edit the calorie value after automatic calorie calculation
    When User edit calorie value after automatic calorie calculation
    Then User should see edited value in automatic calorie value

  Scenario: Verify user able to save food entry with null value in food name
    When User clicks the Save Food Entry button after leaving the Food Name field empty
    Then User should see an error message indicating that the Food Name is required

  Scenario: Verify datepicker option
    When User clicks on date field
    Then User should see date calendar

  Scenario: Verify date in picker
    Then User should see today's date highlighted

  Scenario: Verify the presence the previous button in date picker
    Then User should see previous button in date

  Scenario: Verify the presence the Next button in date picker
    Then User should see next button in date

  Scenario: Verify user able to edit date in date picker
    When User selects previous date in the calendar after clicking date field
    Then User should see selected date in the field

  Scenario: Verify user receives error message for entering more than 250 words in notes
    When User clicks save food entry after more than 250 words in notes
    Then User should see error message in alert
