Feature: Blood Glucose Tracker Validation and Meal and Nutrition Validation and Medical Dosage Validation and Log review Validation
  Background: User logged into app

  Scenario: Verify presence of Blood Glucose Tracker section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see Blood Glucose Tracker

  Scenario: Verify title of Blood Glucose tracker section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see title "Blood Glucose Tracker"

  Scenario: Verify colour codes for Fasting
    Given User is in Home page
    When User navigate to logbook page
    Then User should see "Fasting" displayed in purple

  Scenario: Verify Fasting glucose type range displayed
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the range for "Fasting" be "70-100 mg/dL"

  Scenario: Verify colour codes for Pre-Meal
    Given User is in Home page
    When User navigate to logbook page
    Then User should see "Pre-Meal" displayed in green

  Scenario: Verify pre-meal glucose type range displayed
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the range for "Pre-Meal"  be "70-130 mg/dL"

  Scenario: Verify colour codes for Post-Meal
    Given User is in Home page
    When User navigate to logbook page
    Then User should see "Post-Meal"  displayed in yellow

  Scenario: Verify Post-meal glucose type range displayed
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the range for "Post-Meal"  be "<180 mg/dL"

  Scenario: Verify colour codes for Bedtime
    Given User is in Home page
    When User navigate to logbook page
    Then User should see "Bedtime" displayed in red

  Scenario: Verify bedtime glucose type range displayed
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the range for "Bedtime"  be "100-140 mg/dL"

  Scenario: Verify last 7 days are displayed on X-axis
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the X-axis display the last 7 days ending today

  Scenario: Verify Y-axis starts at 70 in glucose chart
    Given User is in Home page
    When User navigate to logbook page
    Then User should see Y-axis minimum value  70

  Scenario: Verify Y-axis ends at 180 in glucose chart
    Given User is in Home page
    When User navigate to logbook page
    Then User should see X-axis Maximum value 180



  Scenario: Verify presence of Meal & Nutrition section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see Meal & Nutrition Section

  Scenario: Verify title of Meal & Nutrition section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see Title "Meal & Nutrition"

  Scenario: Verify icon for Meal & Nutrition section is displayed
    Given User is in Home page
    When User navigate to logbook page
    Then User should see Icon  on the left side of "Meal & Nutrition" title

  Scenario: Verify the presence of 7-day aggregate nutrition section in Meal & Nutrition section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the section "7-Day Aggregate Nutrition"

  Scenario: Verify text color of Carbs in 7-day aggregate nutrition section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see carbs text colour pink

  Scenario: Verify text color of Protein in 7-day aggregate nutrition section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see protein Text colour blue

  Scenario: Verify text color of Fats in 7-day aggregate nutrition section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see Fats text colour yellow

  Scenario: Verify last 7 days are displayed on X-axis in Daily Nutrition breakdown section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the X-axis display the last 7 days ending today

  Scenario: Verify bar chart behavior when user has not logged any meals
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see no bars in Daily Nutrition breakdown section

  Scenario: Verify pie chart is hidden when user has not logged any meals
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should not see any pie chart in 7-day aggregate Nutrition section

  Scenario: Verify Carbs card displays 0g and 0%  in Daily nutrition breakdown section when there is no logs
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the Carbs card  displayed "0g (0%)"

  Scenario: Verify Protein card displays 0g and 0% in Daily nutrition breakdown section when there is no logs
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the protein card  displayed "0g (0%)"

  Scenario: Verify Fats card displays 0g and 0% in Daily nutrition breakdown section when there is no logs
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the fats card  displayed "0g (0%)"

  Scenario: Verify bar chart behavior when user has logged meals
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see Bars with nutrient distribution

  Scenario: Verify pie chart is visible when user has logged meals
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see pie chart displayed with nutrient distribution

  Scenario: Verify Carbs card displays correct value in Daily nutrition breakdown section when there is  logs
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see the value in the carbs card

  Scenario: Verify protein card displays correct value in Daily nutrition breakdown section when there is  logs
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see the value in protein card

  Scenario: Verify fats card displays correct value in Daily nutrition breakdown section when there is  logs
    Given User has logged meals in home page
    When User navigate to logbook page
    Then User should see the value in fats card




  Scenario: Verify the presence of Medical Dosage section
    Given User is in home page
    When User navigate to logbook page
    Then User should see the section Medical Dosage

  Scenario: Verify the title "Medical dosage"
    Given User is in home page
    When User navigate to logbook page
    Then User should see the title "Medical Dosage"

  Scenario: Verify the icon beside medical dosage
    Given User is in home page
    When User navigate to logbook page
    Then User should see the icon on left side of title

  Scenario: Verify the Y-axis has text "Number of Doses"
    Given User is in home page
    When User navigate to logbook page
    Then User should see the text "Number of Doses"on Y-axis

  Scenario: Verify display empty chart when no medication is scheduled
    Given User have not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see no bars in the chart

  Scenario: Verify Total scheduled will display 0 doses, if no medication is scheduled
    Given User have not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see "0 doses"  value in the Total scheduled statistics

  Scenario: Verify Doses Taken will display 0 doses , if no medication is displayed
    Given User have not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see "0 doses" value in the Doses taken statistics

  Scenario: Verify Doses Missed will display 0 doses, if no Medication is displayed
    Given User have not scheduled any medication for the week
    When User navigate to logbook page
    Then User should see "0 doses" value in the Doses Missed statistics

  Scenario: Verify the colour of Total Scheduled text
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see purple colour text

  Scenario: Verify the colour of Doses Taken text
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see green colour text

  Scenario: Verify the colour of Doses Missed text
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see yellow colour text

  Scenario: verify green colour bar is displayed for doses taken on one week schedule
    Given User should see yellow colour text
    When User navigate to logbook page
    Then User should see green colour bar for that day

  Scenario: Verify red colour bard is displayed for doses missed on one week schedule
    Given User should see yellow colour text
    When User navigate to logbook page
    Then User should see red colour bar for that day



  Scenario: Verify the Title of Log review section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the title "Log Review"

  Scenario: Verify table header in log review section
    Given User is in Home page
    When User navigate to logbook page
    Then User should see table header "Date","Blood Glucose","Nutrition","Activity",Medication"

  Scenario: Verify log review displays last 7 days of date entries including today
    Given User is in Home page
    When User navigate to logbook page
    Then User should see date of last seven days including today

  Scenario: Verify the display of date format
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the date format as "MMM dd, yyyy"

  Scenario: Verify the order of date
    Given User is in Home page
    When User navigate to logbook page
    Then User should see the date ordered in descending order for last 7 days including today

  Scenario: Verify the blood glucose value in log review section if there is no log
    Given user have not log any blood glucose value in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under blood glucose

  Scenario: Verify the nutrient value in log review section if there is no log
    Given User have not log any nutrition value in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under Nutrition value

  Scenario: Verify the physical activity value in log review section if there is no log
    Given User have not log any Physical activity in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under Activity

  Scenario: Verify the entries of Medication in log review section if there is no value
    Given User have not log any Medication dosage in home page
    When User navigate to logbook page
    Then User should see hyphen "-" for all the days under Medication

  Scenario: Verify the blood glucose entries in log review section if there is log
    Given User log blood glucose value in Home page
    When User navigate to logbook page
    Then User should see logged  value for those days under Blood glucose

  Scenario: Verify the nutrient value entries in log review section if there is log
    Given User log Nutrient value in Home page
    When User navigate to logbook page
    Then User should see logged value for those days under Nutrient value

  Scenario: Verify the physical activity entries in log review section if there is log
    Given User log Physical Activity in home page
    When User navigate to logbook page
    Then User should see logged value  for those days under physical activity

  Scenario: Verify the medication value in log review section if there is log
    Given User log Medication dosage in Home page
    When User navigate to logbook page
    Then User should see logged value for those under Medication Dosage




