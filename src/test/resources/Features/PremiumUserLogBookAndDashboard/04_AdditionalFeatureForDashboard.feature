@dashboard_3
Feature: Manage premium Dialog box Validation
  Background: User clicks manage premium in dashboard page after logging in
    Given User is logged in

  Scenario: Verify the message displayed in dialog box
    Given User is in premium subscription dialog box
    When User view Manage premium Dialog box
    Then User should see the  the message "Are you sure you want to cancel your premium subscription? You'll continue to have access to premium features until the end of your current billing period."

  Scenario: Verify loss of features section is displayed
    Given User is in premium subscription dialog box
    When User view Manage premium Dialog box
    Then User should see the section "What you'll lose:" with list "Personalized meal plans tailored to your health goals"," Advanced analytics and blood sugar insights","Specialized diabetes management plans","Priority support and premium features"

  Scenario: Verify action buttons are displayed
    Given User is in premium subscription dialog box
    When User view Manage premium Dialog box
    Then User should see "Keep Premium" button and "Cancel Premium" button

  Scenario: Verify style and colour of "Keep Premium" button
    Given User is in premium subscription dialog box
    When User view Manage premium Dialog box
    Then User should See "Keep Premium" button with white background and dark text

  Scenario: Verify style and colour of "Cancel Premium" button
    Given User is in premium subscription dialog box
    When User view Manage premium Dialog box
    Then User should see "Cancel Premium" button with red background and white text

  Scenario: Verify Keep premium button functionality
    Given User is in premium subscription dialog box
    When User clicks the Keep Premium button
    Then User should see success message " your premium subscription will continue"

  Scenario: Verify cancel premium button functionality
    Given User is in premium subscription dialog box
    When User clicks the cancel Premium button
    Then User should see message "your premium subscription will cancelled"

  Scenario: Verify "x" button
    Given User is in premium subscription dialog box
    When User clicks the X button
    Then User should see the dialog box closed