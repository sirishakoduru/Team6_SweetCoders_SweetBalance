Feature: Physical activity Validation

  Background:
    Given User is in home page after logged into app

  Scenario: Verify title in physical activity form
    When User clicks physical activity
    Then User should see physical activity title "Physical Activity"

  Scenario: Verify subtext in form
    Then User should see activity subtext "Track your fitness journey"

  Scenario: Verify fields in track glucose
    Then User should see field for Activity Type, Duration, Date, Intensity

  Scenario: Verify the presence of dropdown for Activity Type
    Then User should see dropdown for activity type

  Scenario: Verify the dropdown options for activity type
    Then User should see dropdown "Walking,Running,Cycling,Weight Training,Yoga,HIIT,Other"

  Scenario: Verify the presence input for Duration
    Then User should see input field for duration

  Scenario: Verify the placeholder text for Duration
    Then User should see "30" in placeholder field

  Scenario: Verify dropdown for duration options
    Then User should see drop down duration

  Scenario: Verify dropdon option in duration
    Then User should see "minutes, hours"

  Scenario: Verify the date picker option
    Then User should see date picker

  Scenario: Verify the presence of intensity
    Then User should see intensity field

  Scenario: Verify buttons for intensity
    Then User should see "Light, Moderate, Vigorous"

  Scenario: Verify the save activity button
    Then User should see save activity button