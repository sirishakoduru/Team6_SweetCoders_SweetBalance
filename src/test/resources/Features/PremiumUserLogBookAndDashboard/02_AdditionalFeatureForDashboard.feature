Feature: Dashboard page validation for Registered premium account user
  Background: User logged into the app

  Scenario: Verify display of  King symbol next to their name
    Given User is in Home page
    When User click dashboard on the navigation bar
    Then User should see the King symbol 👑 displayed next to their name

  Scenario: Verify display of  premium activated status next to their name
    Given User is in Home page
    When User click dashboard on the navigation bar
    Then User should see the "Premium Activated" status next to the symbol

  Scenario: Verify manage premium button is visible
    Given User is in Home page
    When User click dashboard on the navigation bar
    Then User should see the "Manage premium" button

  Scenario: Verify manage premium button is clickable
    Given User is in Home page
    When User clicks the "Manage Premium" button
    Then User should see the dialog box open

  Scenario: Verify the display of start date text and its value
    Given User is in Home page
    When User click dashboard on the navigation bar
    Then User should see the "Start Date:" with value in format "EEE, MMM dd, yyyy"

  Scenario: Verify the display of End date Text and its value
    Given User is in Home page
    When User click dashboard on the navigation bar
    Then User should see the "End Date:" with value in format "EEE, MMM dd, yyyy"





