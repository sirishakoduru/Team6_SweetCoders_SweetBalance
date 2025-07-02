
Feature: Food Intake Validation

  Background:
    Given User is in home page after logged into app

  Scenario: Verify title in Food Intake form
    When User clicks Food Intake
    Then User should see title "Food Intake Tracker"

  Scenario: Verify subtext in form
    Then User should see subtext "Track what you eat to manage your diabetes better"

  Scenario: Verify the presence of 4 tabs in food intake
    Then User should see "Breakfast, Lunch, dinner, snack" tabs

  Scenario: Verify fields in food intake form
    Then User should see field for Food Name, Serving Size, Calorie, Date, Notes

  Scenario: Verify default meal tab selection
    Then User should see "Breakfast" tab selected by default

  Scenario: Verify input field for food name
    Then User should see input field for field food name

  Scenario: Verify the presence of placeholder in input field
    Then User should see text "e.g., Grilled Chicken Salad" as placeholder in input field

  Scenario: Verify Serving Size default value
    Then User should see "Medium (1 cup)" as the default value in the Serving Size dropdown

  Scenario: Verify the dropdown options for serving size
    Then User should see small (1/2 cup), Medium (1 cup), Large (2 cup), Custom

  Scenario: Verify the presence calculator icon in calorie
    Then User should see calculator icon in calorie

  Scenario: Verify the input field for calorie
    Then User should see input field for calorie

  Scenario: Verify the placeholder text for calorie
    Then User should see text "e.g. 250" as placeholder in calorie field

  Scenario: Verify helper text below Calories field
    Then User should see helper text "Enter calories or click the calculator icon for automatic calculation."

  Scenario: Verify the date picker option
    Then User should see date picker

  Scenario: Verify Date field default value
    Then User should see "June 26th, 2025" displayed in the Date field

  Scenario: Verify the presence of input block for notes
    Then User should see input block for notes

  Scenario: Verify the presence of placeholder in notes blocks
    Then User should see text "Add any additional info…" in place holder

  Scenario: Verify the save food entry button
    Then User should see save food entry button