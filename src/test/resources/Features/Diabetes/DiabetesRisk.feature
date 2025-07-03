Feature: Verification on Diabetes Risk Analyzer

Background:
Given User is on the SweetBalance homepage

Scenario: Validate modal dialog heading
When User clicks "Check Your Risk" button
Then User should see "Diabetes Risk Analyzer" header

Scenario: Validate modal dialog sub text
When User clicks "Check Your Risk" button
Then User see  "Answer a few questions to assess your risk of developing diabetes" text

Scenario: Verify the presence of Cancel button 
When User clicks "Check Your Risk" button
Then User should see Cancel button

Scenario: Verify the presence of Calculate Risk button
When User clicks "Check Your Risk" button
Then User should see Calculate Risk button

Scenario: Validate "Calculate Risk" is disabled
When User clicks "Check Your Risk" button
Then User should see Calculate Risk button disabled

Scenario: Verify  age field with Stepper controls (up/down arrows) in dialog 
When User clicks "Check Your Risk" button
Then User should see Age input field to have stepper controls

Scenario: Verify  weight field with Stepper controls (up/down arrows) in dialog 
When User clicks "Check Your Risk" button
Then User should see weight input field to have stepper controls

Scenario: Verify the presence of checkbox
When User clicks "Check Your Risk" button
Then User should see check box for Family history of diabetes field

Scenario: Verify the placeholder text for Age field
When User clicks "Check Your Risk" button
Then User should be able to view the placeholder "Enter your age (1-150)" in the age field

Scenario: Verify the placeholder text for weight
When User clicks "Check Your Risk" button
Then User should see "Enter your weight in kg (1-999)" in weight field

Scenario: Verify the dropdown for Physical Activity Level
When User clicks "Check Your Risk" button
Then User should see  dropdown for Physical Activity Level

Scenario: Verify the dropdown for Blood Pressure
When User clicks "Check Your Risk" button
Then User should see dropdown for Blood Pressure

Scenario:  Verify the dropdown for Diet Quality
When User clicks "Check Your Risk" button
Then User should see dropdown for Diet Quality

Scenario: Verify the presence of initial value for Physical Activity Level
When User clicks "Check Your Risk" button
Then User should see "Select activity level" as the default option

Scenario: Verify the presence of initial value dropdown for Blood Pressure
When User clicks "Check Your Risk" button
Then User should see "Select blood pressure status" as the default option

Scenario: Verify the presence of initial value dropdown for Diet Quality
When User clicks "Check Your Risk" button
Then User should see "Select diet quality" as the default option

Scenario: Verify the values for Physical Activity Level
When User clicks "Check Your Risk" button
Then User should see the "Active (Exercise 3+ times a week) Moderate (Exercise 1-2 times a week) Sedentary (Rarely exercise)"

Scenario: Verify the values for Blood Pressure
When User clicks "Check Your Risk" button
Then User should see the "Normal Elevated High"

Scenario: Verify the values for Diet Quality
When User clicks "Check Your Risk" button
Then User should see the "Excellent (Balanced, mostly whole foods) Average (Mixed whole foods and processed foods) Poor (Mostly processed foods, high sugar)" 


