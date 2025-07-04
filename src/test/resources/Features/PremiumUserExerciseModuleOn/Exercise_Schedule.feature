Feature: Exercise Schedule Page Validation

  Background:
    Given User is in home page after logging

  Scenario: Verify button reverts back after undo
    Given User is in the Exercise section
    When User clicks Undo after marking Exercise as completed
    Then Button changes back to "Mark As Completed"

  Scenario: Verify navigation to "View full schedule"
    Given User is in the Exercise section
    When User clicks "view full schedule"
    Then User should redirect to Exercise schedule

  Scenario: Verify page title is displayed
    Then User should see titleText "Today's Exercise Schedule"

  Scenario: Verify "Back to Home" button is visible
    Then User should see "Back to Home" button in Today's Exercise schedule page

  Scenario: Verify "Warm Up" section is displayed
    Then "Warm Up" section should be visible

  Scenario: Verify warm-up exercise name
    Then Exercise name should be visible

  Scenario: Verify warm-up exercise description
    Then Exercise description should be visible

  Scenario: Verify warm-up duration
    Then Exercise durations should be visible

  Scenario: Verify warm-up calories
    Then Exercise calories should be visible

  Scenario: Verify warm-up intensity
    Then Exercise intensity should be visible

  Scenario: Verify "Main Workout" section is displayed
    Then "Main Workout" section should be visible

  Scenario: Verify Main Workout exercise name
    Then Exercise name should be visible

  Scenario: Verify Main Workout exercise description
    Then Exercise description should be visible

  Scenario: Verify Main Workout duration
    Then Exercise durations should be visible

  Scenario: Verify Main Workout calories
    Then Exercise calories should be visible

  Scenario: Verify Main Workout intensity
    Then Exercise intensity should be visible

  Scenario: Verify "Cool Down" section is displayed
    Then "Cool Down" section should be visible

  Scenario: Verify Cool Down exercise name
    Then Exercise name should be visible

  Scenario: Verify Cool Down exercise description
    Then Exercise description should be visible

  Scenario: Verify Cool Down duration
    Then Exercise durations should be visible

  Scenario: Verify Cool Down calories
    Then Exercise calories should be visible

  Scenario: Verify Cool Down intensity
    Then Exercise intensity should be visible

  Scenario: Verify the intensity value
    Then Exercise intensity should low/medium/hard

  Scenario: Verify total duration is displayed
    Then total duration should be displayed

  Scenario: Verify total duration matches the sum of individual workout durations
    Then total duration should equal the sum of all individual durations

  Scenario: Verify total calories matches the sum of individual workout calories
    Then total calories should equal the sum of all individual calories
