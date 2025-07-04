Feature: Exercise Module Functional Testing

  Background:
    Given User is Logged into the app

  Scenario: Verify "View Full Schedule" button is displayed
    Given User is on the homepage
    When User clicks the "Exercise" option from the side panel
    Then "View Full Schedule" button is displayed on the right

  Scenario: Verify navigation to "Today's Exercise Schedule" page
    When User clicks the "View Full Schedule" Schedulebutton
    Then User is redirected to "Today's Exercise Schedule" page

  Scenario: Verify "Warm Up" tab is displayed
    When User clicks the "Exercise" option from the side panel
    Then "Warm Up" tab is visible

  Scenario: Verify "Main Workout" tab is displayed
    Then "Main Workout" tab is visible

  Scenario: Verify "Cool Down" tab is displayed
    Then "Cool Down" tab is visible

  Scenario: Verify Exercise name is displayed under "Warm Up" tab
    Then Exercise name is displayed under "Warm Up" tab

  Scenario: Verify Exercise name is displayed under "Main Workout" tab
    Then Exercise name is displayed under "Main Workout" tab

  Scenario: Verify Exercise name is displayed under "Cool Down" tab
    Then Exercise name is displayed under "Cool Down" tab

  Scenario: Verify Exercise description is displayed under "Warm Up" tab
    Then Description is shown below the Exercise name under "Warm Up"

  Scenario: Verify Exercise description is displayed under "Main Workout" tab
    Then Description is shown below the Exercise name under "Main Workout"

  Scenario: Verify Exercise description is displayed under "Cool Down" tab
    Then Description is shown below the Exercise name under "Cool Down"

  Scenario: Verify duration is displayed under "Warm Up" tab
    Then Duration is displayed under "Warm Up" tab

  Scenario: Verify calories are displayed under "Warm Up" tab
    Then Calories are displayed under "Warm Up" tab

  Scenario: Verify intensity level is displayed under "Warm Up" tab
    Then Intensity level is displayed under "Warm Up" tab

  Scenario: Verify duration is displayed under "Main Workout" tab
    Then Duration is displayed under "Main Workout" tab

  Scenario: Verify calories are displayed under "Main Workout" tab
    Then Calories are displayed under "Main Workout" tab

  Scenario: Verify intensity level is displayed under "Main Workout" tab
    Then Intensity level is displayed under "Main Workout" tab

  Scenario: Verify duration is displayed under "Cool Down" tab
    Then Duration is displayed under "Cool Down" tab

  Scenario: Verify calories are displayed under "Cool Down" tab
    Then Calories are displayed under "Cool Down" tab

  Scenario: Verify intensity level is displayed under "Cool Down" tab
    Then Intensity level is displayed under "Cool Down" tab

  Scenario: Verify "Mark As Completed" button is displayed
    Then "Mark As Completed" button is displayed for all three sections

  Scenario: Verify success dialog is shown after marking as completed
    When User clicks the "Mark As Completed" button
    Then Success dialog is shown

  Scenario: Verify button status changes to "Completed"
    When User clicks the "Mark As Completed" button1
    Then Button changes to "Completed"

  Scenario: Verify undo option is displayed after marking completed
    When User clicks the "Mark As Completed" button1
    Then Undo option is visible
