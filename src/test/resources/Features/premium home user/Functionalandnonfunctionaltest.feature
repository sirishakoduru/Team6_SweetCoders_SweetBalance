@functional

Feature: Functional and non functional test validation for premium account user

Background: User is logged into the app
@tc13
Scenario: Verify the presence of "Pre-meal" title in each meal section
Given   User home page
When   User click meal section
Then  User should see "Pre-Meal" title
@tc14
Scenario: Verify the presence of icon for Pre-meal  in each meal section
Then User should see alarm clock icon
@tc15
Scenario: Verify pre-meal title is shown before main meal
Then User should see pre-meal in first place of  each meal section
@tc16
Scenario: Verify "None" is displayed for Pre-Meal Snack by default
When User clicks snack section
Then User should see Pre-Meal entry displays as "None" by default
@tc17
Scenario: Verify calorie in pre-meal snack
Then User should see 0 calorie in pre-meal snack
@tc18
Scenario: Verify the presence of meal title for main meal in snack
Then User should see meal title for main-meal in snack
@tc19
Scenario: Verify meal section contains dish description in snack
Then User should see description for the dish in snack
@tc20
Scenario: Verify the presence of Sub title "Main-Meal"
When User clicks  meal section
Then User should see "Main-meal" as sub
@tc21
Scenario: Verify the presence of icon for main -meal
Then User should see utensil icon for each
@tc22
Scenario: Verify the time format in each main-meal
Then User should see "hh:mm" based time in meal
@tc23
Scenario:Validate the indicator for breakfast main-meal
Then User should see indicator "AM"
@tc24
Scenario: Validate the indicator for lunch main-meal
Then User should see indicator "PM" for lunch
@tc25
Scenario: Validate the indicator for dinner main-meal
Then User should see indicator "PM" for dinner
@tc26
Scenario: Verify the time in  main-breakfast
Then User should see 7:30 o'clock
#not working
@tc27
Scenario: Verify calories for main-meal is shown for each meal
Then User should see the main-meal calorie
@tc28
Scenario: Validate the text  " Calorie" in main-meal
Then User should see text "calorie" after the value
@tc29
Scenario: Verify the presence of "✅ Completed" button
Then User should see "✓Completed" button
@tc30
Scenario: Verify the presence of "⚠️ Partially Completed" button
Then User  see Partially button
@tc31
Scenario: Verify the presence of "❌ Not Completed" button
Then User can see notcompleted button
@tc32
Scenario: Verify color change of button  not completed
Then  Button color should change to green
@tc33
Scenario: Verify color change of button partially completed
Then Button color should change to yellow
@tc34
Scenario: Verify color change of button  not completed
Then  Button color should change to red