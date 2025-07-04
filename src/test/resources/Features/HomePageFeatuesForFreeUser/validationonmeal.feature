 @meal
 Feature: Validation on meal section for registered free user account
 Background: User logs into the app

      @2
     Scenario: Verify nutrition bar is shown for each meal
     Then User should see horizontal bar for Carbs, Protein, and Fat
     @3
     Scenario: Verify pre-meal title is shown after main dish
     Then User should see the pre-meal title  (eg: pre-breakfast)
     @4
     Scenario: Verify the presence of Carbs value  for nutrition
     Then User should see Carbs value for the main meal
     @5
     Scenario: Verify the presence of Protein value for nutrition
     Then User should see Protein value for the main meal
     @6
     Scenario: Verify the presence of Fat value for nutrition
     Then User should see Fat value for the main meal
     @7
     Scenario: Verify the presence of intake time in each pre-meal
     Then User should see intake time in each pre-meal
     @8
     Scenario: Validate the indicator for snack pre-meal
     Then User should see indicator "PM" for snack  pre-meal
     @9
     Scenario: Verify the time format in  pre-meal snack
     Then  User should see  "hh:mm" based time in pre-meal snack (eg : 1:00)
     @10
     Scenario: Verify the time in pre-snack
     Then User should see 3 o'clock
     @11
     Scenario: Verify the dot indicator between time and calorie in each pre-meal session
     Then User should see dot between time and calorie in each pre-meal session
     @12
     Scenario: Verify the navigation of "View Full Plan" button 
     Then User should redirected to subscription page
     @13
     Scenario: Verify the title in Exercise section
     When User clicks exercise section
     Then  User should see title "Today's Exercise Plan"
     @14
     Scenario: Verify the presence of exercise list
     Then User should see 2 exercises listed for the day
      @15
     Scenario: Verify the presence of time in each exercise
     Then  User should see scheduled time of each exercise
     @16
     Scenario:  Verify the time for morning exercise
     Then   Morning exercise should be scheduled for 7 o'clock
     @17
     Scenario:  Verify the time for evening exercise
     Then   Evening exercise should be scheduled for 5 o'clock
     @18
     Scenario:  Verify the title for each exercise plan
     Then  User should see plan title for each exercise
     @19
     Scenario:   Verify the presence of 12-hour clock indicator is visible in each exercise plan
     Then  User should see 12-hour clock indicator with AM/PM.
     @20
     Scenario:  Verify the presence of duration in each exercise plan
     Then  User should see a duration in each exercise item
     @21
     Scenario:  Verify the duration format in each exercise plan
     Then  User should see duration format in mins for each exercise item
     @22
     Scenario:  Verify the dot indicator between duration and intensity  level
     Then  User should see dot between duration and intensity level
     @23
     Scenario:  Verify the presence of intensity level in each exercise item
     Then  User should see intensity level in each exercise
     @24
     Scenario: Verify the presence of  "View Full Schedule" button
     Then  User should see button with text "View Full Schedule"
     @25
     Scenario: Verify the navigation of  "View Full Schedule" button
     When User clicks view full schedule button after reaching exercise section 
     Then User should redirected to subscription page
