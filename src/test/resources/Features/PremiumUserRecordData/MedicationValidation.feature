Feature: Medication Validation

  Background:
    Given User is in home page after logged into app

  Scenario: Verify title in Medication form
    Given User is in home page
    When User clicks Medication
    Then User should see title "Diabetes Medication Tracker"

  Scenario: Verify subtext in form
    Then User should see subtext "Keep track of your medications and never miss a dose"

  Scenario: Verify the heading in form
    Then User should see heading "Your Medications"

  Scenario: Verify the heading in flex
    Then User should see heading "Today's Medications" in flex

  Scenario: Verify the presence of date picker
    Then User should see date picker in tracker

  Scenario: Verify the default value in datepicker
    Then User should see today's date as default value in datepicker

  Scenario: Verify the message in flex card if no medication added
    Then User should see message "No medications added yet Click the 'Add Medication' button to get started"

  Scenario: Verify the presence of add medication button
    Then User should see Add medication button

  Scenario: Verify the presence of close button
    Then User should see close button in the form
