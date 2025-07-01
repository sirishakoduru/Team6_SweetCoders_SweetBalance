Feature: Functional testing for physical activity

  Background:
    Given User is in physical activity

  Scenario: Verify user able to save activity
    When User clicks save activity after entering valid
    Then User should see "Your activity is recorded"

  Scenario: Verify user unable to enter invalid value
    When User enters invalid value in duration text field
    Then User should see blank

  Scenario: Verify datepicker option
    When User clicks date picker
    Then User should see date calendar

  Scenario: Verify date in picker
    When User clicks date picker
    Then User should see today's date highlighted

  Scenario: Verify the presence the previous button in date picker
    When User clicks date picker
    Then User should see previous button in date

  Scenario: Verify the presence the Next button in date picker
    When User clicks date picker
    Then User should see next button in date