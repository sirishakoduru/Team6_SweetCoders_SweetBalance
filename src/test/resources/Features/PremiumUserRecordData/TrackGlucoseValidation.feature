@tag
Feature: Track Glucose Validation

  Background:
    Given User is in home page after logged into app

  Scenario: Verify title in blood glucose form
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see title "Track Glucose"

  Scenario: Verify subtext in form
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see glucose subtext " Keep your health in check"

  Scenario: Verify fields in track glucose
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see field for Blood Glucose Level, Reading Type, Date

  Scenario: Verify input field
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see text field for blood glucose

  Scenario: Verify the placeholder input in blood glucose field
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see text "Enter blood glucose level"

  Scenario: Verify the text in the input field
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see "mg/dL"

  Scenario: Verify the presence of transition field in track glucose
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see three transition details with text "Low, normal, high"

  Scenario: Verify the color of transition in Low
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see Red color in low

  Scenario: Verify the color of transition in normal
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see green color in normal

  Scenario: Verify the color of transition in height
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see yellow color in high

  Scenario: Verify the four button below reading type
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see button "Fasting,Pre-meal,Post-meal,Bedtime"

  Scenario: Verify the date picker option
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see date picker

  Scenario: Verify the last reading time
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see last ready details

  Scenario: Verify the record reading button
    Given User is in home page
    When User clicks Blood Glucose
    Then User should see record reading button

