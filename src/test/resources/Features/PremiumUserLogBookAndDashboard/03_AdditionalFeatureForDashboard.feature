Feature: Emotional Wellbeing validations on Premium dashboard and User Activity Tracking on premium Dashboard and Smart Insights Validation on Premium dashboard
  Background: User is in home page after logged in

  Scenario: Verify the title of emotional wellbeing
    Given User is in Dashboard Page
    When User scrolls to the middle
    Then User should see the title "Emotional Wellbeing"

  Scenario: Verify the question about wellbeing is displayed
    Given User is in Dashboard Page
    When User scrolls to the middle
    Then User should see the question text "How are you feeling today?"

  Scenario: Verify the mood emojis are displayed
    Given User is in Dashboard Page
    When User scrolls to the middle
    Then User should see six emoji 😄 😊 😐 😔 😠 😰 options visible for selection

  Scenario: Verify the text notes on your mood
    Given User is in Dashboard Page
    When User scrolls to the middle
    Then Usr should see the text "Notes on your mood"

  Scenario: Verify the input field of the notes
    Given User is in Dashboard Page
    When User scrolls to the middle
    Then User should see the Text "What's affecting your mood today?" in input field

  Scenario: Verify able to give inputs to "notes on your mood" input field
    Given User is in Dashboard Page
    When User scrolls to middle and enter value in notes on your mood input field
    Then User should see the value entered in input field

  Scenario: Verify the text energy level is present with value
    Given User is in Dashboard Page
    When User scrolls to middle
    Then User should see the energy level slider

  Scenario: Verify energy level slider is displayed
    Given User is in Dashboard Page
    When User scrolls to middle
    Then User should see Energy level slider with labels "low" and "high"

  Scenario: verify energy level changes when sliders move
    Given User is in Dashboard Page
    When User scrolls to middle and moves Energy slider to new position
    Then User should see the value  changes according to the position

  Scenario: Verify log Emotional state  button is displayed
    Given User is in Dashboard Page
    When User scrolls to middle
    Then User should see the "log emotional state"button

  Scenario: Verify Emotional state log success message
    Given User is in Dashboard Page
    When User select mood emoji and click log emotional state button
    Then User should see the success message "Your Emotional State has been recorded Successfully"



  Scenario: Verify Weekly Checks card shows "0" when the user hasn't logged any checks
    Given User has not logged any weekly checks for the current week
    When User navigates to dashboard page
    Then User should see  "Weekly Checks"  displaying "0" with subtitle "Total log entries per week"

  Scenario: Verify Weekly Checks card shows correct count based on existing check logs
    Given User has logged weekly check for the current week
    When User navigates to dashboard page
    Then User should see "Weekly checks" displaying value based on the logs

  Scenario: Verify Exercise Minutes card shows "0/150 this week" when there's no exercise logged
    Given User has not logged any exercise minutes for the week
    When User navigates to dashboard page
    Then User should see the "Exercise Minutes" displaying "0/150 this week" with subtitle "Target: 150 minutes per week"

  Scenario: Verify Exercise Minutes card shows correct minutes based on user entries
    Given User has logged exercise minutes for the week
    When User navigates to dashboard page
    Then User should see "Exercise Minutes" displaying number of minutes based on the entries

  Scenario: Verify Med Adherence shows "0%" with "Needs improvement" when there's no log
    Given User has not logged Medication adherence for the week
    When User navigates to dashboard page
    Then User should see "Med Adherence" displaying "0%" with subtitle "Needs improvement"

  Scenario: Verify  Med Adherence shows the correct percentage based on logged adherence
    Given User has logged Medication Adherence for the week
    When User navigates to dashboard page
    Then User should see "Med Adherence" displaying value based on the log

  Scenario: Verify Carb Goals card shows "0/28" when no meals are logged
    Given User has not logged Carb goals for the week
    When User navigates to dashboard page
    Then User should see "Carb Goals"  displaying "0/28" with subtitle "Weekly meals completed"

  Scenario: Verify Carb Goals shows correct number based on logged meal entries
    Given User has logged carb goals for the week
    When User navigates to dashboard page
    Then User should see "Carb goals" displaying value based on the logs



  Scenario: Verify smart insights section title
    Given User has health data for the last 7 days
    When User Navigates to dashboard page
    Then User should see the title "Smart Insights" in smart insights section

  Scenario: Verify smart insights section has the label "Last 7 days"
    Given User has health data for the last 7 days
    When User Navigates to dashboard page
    Then User should see the label "last 7 days" in smart insights section

  Scenario: Verify smart insights section has titles
    Given User has health data for the last 7 days
    When User Navigates to dashboard page
    Then User should see Titles " Target Achievement","Pattern detected","Suggestion"

  Scenario: Verify the display of Target Achievement based on health data
    Given User has health data for the last 7 days
    When User Navigates to dashboard page
    Then User should see the display of percentage of time the user was in the target range for the last 7 days with the percentage improvement compared to the previous week

  Scenario: Verify the display of Pattern detected based on health data
    Given User has health data for the last 7 days
    When User Navigates to dashboard page
    Then user should see  percentage of glucose value spike  with suggestion to improve

  Scenario: Verify the display of suggestion based on the health data
    Given User has health data for the last 7 days
    When User Navigates to dashboard page
    Then user should see a suggestion of activity  with the average expected glucose reduction from this activity



