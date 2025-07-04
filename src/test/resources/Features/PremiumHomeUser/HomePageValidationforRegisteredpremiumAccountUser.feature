@authpage

Feature: Home Page Validation for Registered premium Account User

Background: User is in password auth page
@tc1
Scenario: Verify order of text in navigation bar
Given   User  in password auth page
When   User  sign in after entering password
Then   User should see the navigation bar displaying items in the order: Home,Logbook,Dashboard,Education
@tc2
Scenario: Verify the presence of animation in challenge yourself button
Then  User should see animation in challenge yourself button
@tc3
Scenario: Verify the presence of  Challenge yourself today button
Then  User should see a  "Challenge yourself today!"  button
@tc4
Scenario: Verify the presence of gender image in the grid
Then  User should see a gender-specific image 
@tc5
Scenario: Verify the presence of emoji on the top right of gender image
Then  User should see an emoji displayed on the top right 
@tc6
Scenario: Verify the presence of  label for gender image 
Then   User should see label "Mood:" below the gender image
@tc7
Scenario: Verify the presence of log button
Then  User should see log button under gender image
@tc8
Scenario: Verify display mood text based on emoji
Then   User should see mood text based on the emoji
@tc9
Scenario: Verify the presence of Weekly plan button
Then  User should see Week plan button
@tc10
Scenario: Verify the presence of "Record New Data" in the bottom
Then  User should see Record New Data text
@tc11
Scenario: Verify the presence of 4 button option below Record New Data
Then   User should see 4 button options
@tc12
Scenario: Verify  the presence of all 4 button icons
Then   User should see icons for Blood, Physical, Food, Medication
