Feature: Login Page UI Verification

@LoginUI_01
Scenario: Verify login form header is displayed
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see "Welcome back" heading

@LoginUI_02
Scenario: Verify sub text of the header
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see "Sign in to your account or create a new one"

@LoginUI_03
Scenario: Verify presence of close button
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see close button at the right corner

@LoginUI_04
Scenario: Verify email input field is displayed
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see an input field to enter email

@LoginUI_05
Scenario: Validate placeholder text in email field
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see text "Enter email" in email field placeholder 

@LoginUI_06
Scenario: Verify Continue with Email button is displayed
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see a "Continue with email" button

@LoginUI_07
Scenario: Verify Continue with Email is enabled
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see "Continue with email" button to be enabled

@LoginUI_08
Scenario: Verify Continue with Google button is displayed
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see a "Continue with Google" button for login

@LoginUI_09
Scenario: Verify OR separator is visible
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see an "OR" separator

@LoginUI_10
Scenario: Verify Terms and Privacy message is displayed
Given User is on SweetBalance homepage
When User clicks on "Login" link
Then User should see "By continuing you agree to our T&Cs and Privacy Policy" message