Feature: Login page field and functional Validation,Complete Profile Form validation for new user

Background: User clicked login button after reaching SweetBalance app homepage
Given User is on SweetBalance homepage
When User clicks on "Login" link  

@LoginFunctional_01
Scenario: Verify email input accepts valid existing email
Given User is on the login page
When Registered user clicks continue with email button after entering a valid existing email
Then User should get password field

@LoginFunctional_02
Scenario: Verify email input rejects invalid email
Given User is on the login page
When User enters an invalid email
Then Email field should show validation error

@LoginFunctional_03
Scenario: Verify Sign in  button in login page
Given User is on the login page
When Registered user clicks continue with email button after entering a valid email
Then User should see Sign in button

@LoginFunctional_04
Scenario: Verify sub text 
Given User is on the login page
When User clicks continue with email button after entering a valid email
Then User should see email id  in sub text

@LoginFunctional_05
Scenario: Verify presence of forgot password link 
Given User is on the login page
When Registered user clicks continue with email button after entering a valid email
Then User should see "Forgot password?" link

@LoginFunctional_06
Scenario: Verify presence of placeholder in password field
Given User is on the login page
When Registered user clicks continue with email button after entering a valid email
Then User should see text "Enter your password" as placeholder in password field

@LoginFunctional_07
Scenario: Verify password input accepts valid existing user
Given User is on the login page
When Registered user clicks sign in after entering password
Then User should be navigated to home page

@LoginFunctional_08
Scenario: Verify email input accepts valid new email
Given User is on the login page
When Unregistered user clicks continue with email button after entering a valid new email
Then User should get "Complete your profile"  form

@LoginFunctional_09
Scenario: Verify Full Name field is visible
Given User is on the login page
When User clicks continue with email button after entering a valid new email
Then "Full Name" input field should be displayed

@LoginFunctional_10
Scenario: Verify Username field is visible
Given User is on the login page
When User clicks continue with email button after entering a valid new email
Then "Username" input field should be displayed

@LoginFunctional_11
Scenario: Verify Password field is visible
Given User is on the login page
When User clicks continue with email button after entering a valid new email
Then "Password" input field should be displayed

@LoginFunctional_12
Scenario: Verify Terms & Conditions checkbox is visible
Given User is on the login page
When User clicks continue with email button after entering a valid new email
Then Terms & Conditions checkbox should be displayed

@LoginFunctional_13
Scenario: Verify Create Account button is disabled initially
Given User is on the login page
When User clicks continue with email button after entering a valid new email
Then "Create Account" button should be disabled