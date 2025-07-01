Feature: Functional testing for Medication

  Background:
    Given User clicks add medication after reaching medication tracker

  Scenario: Verify user able to add medication with valid data
    Given User is in Add new Medication iframe
    When User clicks add medication after entering valid
    Then User should see add medication button changes to "Adding"

  Scenario: Verify the added medication is displayed on the tracker page after redirection
    When User clicks add medication after entering valid
    Then User should be redirected to the tracker page with the newly added medication displayed

  Scenario: Verify user remove button visible after adding new medication
    When User clicks add medication after entering valid
    Then User should see "Remove" button visible next to the added medication in tracker page

  Scenario: Verify the presence of Schedule time
    When User clicks add medication after entering valid
    Then User should see "schedule time " below to the added medication in tracker page

  Scenario: Verify the presence of Mark as taken button for each schedule
    When User clicks add medication after entering valid
    Then User should see "Mark as taken " button to the added medication in tracker page

  Scenario: Verify the scheduled time for once daily
    When User clicks add medication after entering choosing once daily
    Then User should see Scheduled at 8:00 to the added medication in tracker page

  Scenario: Verify the scheduled time for twice daily
    When User clicks add medication after entering choosing twice daily
    Then User should see Scheduled at 8:00 , Scheduled to 20:00 to the added medication in tracker page

  Scenario: Verify the scheduled time for Three times daily
    When User clicks add medication after entering choosing three times daily
    Then User should see Scheduled at 8:00 , scheduled to 14:00 , Scheduled to 20:00 to the added medication in tracker page

  Scenario: Verify user able to add medication without dosage value
    When User clicks add medication leaving dosage value blank
    Then User should see alert with message "Error in adding medication Please try again"

  Scenario: Verify user able to add medication with invalid data in dosage
    When User clicks add medication after entering invalid in dosage
    Then User should see alert with message "Error in adding medication Please try again"

  Scenario: Verify remove icon after selecting medication
    When User selects medication from dropdown
    Then User should see "X" remove icon

  Scenario: Verify user able to remove the selected medication
    When User clicks X after selecting medication
    Then User should see "Select Medication" text in medication field

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
    When User clicks add medication after more than 250 words in notes
    Then User should see error message in alert
