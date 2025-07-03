

Feature: Validation for View Full Meal Plan
Background: User  clicks view meal plan after reaching home page
  Scenario: Verify each meal section have Pre meal title
    Given User clicks view meal plan 
    When User clicks Meal sections
    Then Each meal section should display a pre-meal title
   Scenario:  Verify pre-meal includes description under the item name for each meal section
    Then Item description should be displayed
     Scenario: Verify Pre meal calorie in view full plan for each meal section 
    Then Calories value should be displayed
 Scenario:    Verify pre meal preparation in view full plan for each meal section
    Then Preparation instructions displayed if available , if not then   "N/A"
    Scenario: Verify Nutrients (Pre-meal portion) in view full plan for each meal section 
    Then User should see "carb, protein, fat"
     Scenario: Verify the nutrients value (Pre-meal portion) in view full plan for each meal section
    Then User should see value present in all nutrients
     Scenario: Verify pre-breakfast time in View Full Plan for each meal section
    Then Pre-meal time for Breakfast displayed
     Scenario: Verify pre-lunch time in View Full Plan for each meal section
    Then Pre-meal time for lunch displayed
     Scenario: Verify pre-dinner time in View Full Plan for each meal section
    Then Pre-meal time for dinner displayed
     Scenario: Verify each meal section have meal title 
    Then Each meal section should display a main-meal title
     Scenario: Verify meal preparation in view full plan for each meal section
    Then Preparation instructions displayed
     Scenario: Verify Nutrients information in view full plan for each meal section
    Then User should see "Nutrients information"
     Scenario: Verify meal total calorie in view full plan for each meal section 
    Then Total Calories value should be visible
     Scenario:  Verify ingredients details present in main meal for each meal section
    Then User should see ingredients list for the meal
     Scenario: Verify the presence of heading "Diabetes Management Tips" in view full plan 
    Then User should see heading "Diabetes Tips"
     Scenario: Verify the presence of  tips description for diabetes management
    Then User should see tips under diabetes tips
     Scenario: Verify the presence of "Glycemic Impact:" 
    Then User should see text "Glycemic Impact:"
     Scenario: Verify the presence of impact value
    Then User should see impact value
     Scenario: Validate impact value
    Then Impact value should be valid
     Scenario:Validate navigation of bact to plan button
    When User clicks back to plan button
    Then User should redirected to Home page
    
