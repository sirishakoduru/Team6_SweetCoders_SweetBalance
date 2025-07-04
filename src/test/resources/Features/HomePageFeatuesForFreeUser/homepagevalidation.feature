@all

Feature: Home page feature for free user
Background:  User is in password auth page 
@p
     Scenario: Verify order of text in navigation bar
     Given User is in password auth page
     When User clicks sign in after entering password
     Then User should see the navigation bar displaying items in the order: Home,Dashboard,Education
   
@p1
Scenario: Verify the presence of "Nutrition Insights" heading is shown for each meal
     Given User is in home page
     When User clicks on meal section
     Then User should see "Nutrition Insights" heading for each of the meal section




     