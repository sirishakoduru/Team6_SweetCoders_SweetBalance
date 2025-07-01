Feature: Profile form verification

Background: User clicks continue with email button after entering a valid new email
Given User is on login page
When User enters a valid new email and clicks continue with email button

@LoginProfile_01
Scenario Outline: Verify Create Account button is enabled after valid input
Given User is on complete profile form page
When User checks the Terms & conditions box after filling all fields from "<sheetname>" and "<TestCase>".
Then "Create Account" button should be enabled
Examples:
|sheetname |TestCase |
|Login|Valid data|

@LoginProfile_02
Scenario Outline: Verify Create account form  with valid data
Given User is on complete profile form page
When User clicks create account button after filling valid data in all fields from "<sheetname>" and "<TestCase>".
Then User should redirected to upload blood report 
Examples:
|sheetname |TestCase |
|Login|Valid data|

@LoginProfile_03
Scenario Outline: Verify Create account form  with invalid data
Given User is on complete profile form page
When User clicks create account button after filling invalid data from "<sheetname>" and "<TestCase>".
Then User should see error message
Examples:
|sheetname |TestCase |
|Login|Invalid data|

@LoginProfile_04
Scenario Outline: Verify presence of Upload Blood Report button
Given User is on complete profile form page
When User clicks create account button after filling valid data in all fields from "<sheetname>" and "<TestCase>" for blood report
Then User should see Upload Blood Report button
Examples:
|sheetname |TestCase |
|Login|BloodReport|

@LoginProfile_05
Scenario Outline: Verify presence of Step Through Onboarding button
Given User is on complete profile form page
When User clicks create account button after filling valid data in all fields from "<sheetname>" and "<TestCase>" for onboarding.
Then User should see Step Through Onboarding button
Examples:
|sheetname |TestCase |
|Login|Onboarding|