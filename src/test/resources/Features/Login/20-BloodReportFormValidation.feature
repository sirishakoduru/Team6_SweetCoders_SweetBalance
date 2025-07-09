Feature: Onboarding Form Validation

Background: User successfully uploaded blood report
Given User is on uploading page and clicks upload blood report

#Scenario: Verify presence of text field 
#Given User is on report analysis
#When User clicks continue onboarding button
#Then User should see text field for Age, height , weight
#
#Scenario: Verify presence of dropdown
#When User clicks continue onboarding button
#Then User should dropdown option for Gender field
#
#Scenario: Verify dropdown text for gender
#When User clicks continue onboarding button
#Then User should see "Male , female, prefer not to say " options in dropdown
#
#Scenario: Verify presence of continue button
#When User clicks continue onboarding button
#Then User should see enabled "Continue" button
#
#Scenario: Verify navigation for step 1 onboarding 
#When User clicks continue after entering valid values of height and weight
#Then User should move to step 2 

Scenario: Validate error message for invalid input
When User clicks continue after entering invalid height and weight values.
Then User should receive error message if form have invalid values

#Scenario: Verify progress bar is visible
#When User clicks continue onboarding button
#Then Progress bar should be visible
#
#Scenario: Verify progress shows 1 of 5 steps
#When User clicks continue onboarding button
#Then Progress text should read Step 1 of 5
#
#Scenario: Verify step 1 progress is highlighted
#When User clicks continue onboarding button
#Then Step 1 indicator of uploading should be highlighted 
#
#Scenario: Verify incomplete steps (2-5) are not highlighted
#When User clicks continue onboarding button
#Then Steps 2 to 5 should remain unhighlighted/inactive
#
#
