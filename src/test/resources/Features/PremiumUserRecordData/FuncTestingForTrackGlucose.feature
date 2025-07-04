Feature: Functional testing for track glucose

  Background:
    Given User is in blood glucose

  Scenario: Verify user able to record reading
    When User clicks record reading after valid reading
    Then User should see the message "Reading successfully recorded!"

  Scenario: Verify user unable to enter invalid value
    When User enters invalid value in blood glucose
    Then User should see blank value

  Scenario: Verify transition details highlights
    When User enters value in blood glucose
    Then User should see transition details highlights

  Scenario: Verify datepicker option
    When User clicks date picker button
    Then User should see date calendar

  Scenario: Verify date in picker
    When User clicks date picker
    Then User should see today date highlighted

  Scenario: Verify the presence the previous button in date picker
    When User clicks date picker
    Then User should see previous button in date for glucose

  Scenario: Verify the presence the Next button in date picker
    When User clicks date picker
    Then User should see next button in date for glucose
