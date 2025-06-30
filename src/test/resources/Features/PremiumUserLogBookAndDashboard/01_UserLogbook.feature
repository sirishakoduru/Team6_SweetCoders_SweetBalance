Feature: Physical Activity Validation and Medical Dosage Validation
  Background: User is in home page after logged in

  Scenario: Verify the presence of Physical activity section
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see "physical Activity" section

  Scenario: Verify the title of physical activity section
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the title "Physical Activity"

  Scenario: Verify the presence of icons beside title physical activity
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the icons on left side of title

  Scenario: Verify last 7 days are displayed on X-axis
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see the X-axis display the last 7 days ending today

  Scenario: Verify the alignment of statistic card "Total calories","Daily Average","Peak day"
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see exactly 3 statistic cards displayed horizontally

  Scenario: Verify the text colour of total calories
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should the text in  purple colour

  Scenario: Verify the text colour of daily average
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see text in Orange/Brown color

  Scenario: verify the text colour of peak day
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see text in Red/Maroon color

  Scenario: Verify Y-axis has text calories
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see y-axis  clearly labeled with the text "Calories"

  Scenario: Verify display of empty chart for no activity log
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see no bars in the chart

  Scenario: verify the total calories value for no activity log
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see total calories has "0 cal" value

  Scenario: Verify the daily average value for no activity log
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see Daily average has "0 cal"  value

  Scenario: Verify the peak day value for no activity log
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then User should see no value

  Scenario: Verify the display of bars if there is activity log in home page
    Given User has not logged any meals in home page
    When User navigate to logbook page
    Then user should see the bars  displayed only for days with logged activities
