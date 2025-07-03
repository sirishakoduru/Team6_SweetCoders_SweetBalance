Feature: Verify Homepage navigation components

Background:
Given User is on SweetBalance homepage

Scenario: Verify redirection from Start Today button
When User click the "Start Today" button
Then User should be redirected to the Login page

Scenario: Validate Login link visibility
When User look at the top right corner
Then User should see a link labeled "Login"

Scenario: Validate Login link redirection
When User click on the "Login" link
Then User should be redirected to the Login page

Scenario: Verify redirection from Check Your Risk button
When User click on "Check Your Risk" button
Then User should be redirected to the assessment modal dialog
