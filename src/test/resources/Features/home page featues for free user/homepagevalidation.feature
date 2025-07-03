@all

Feature: Home page feature for free user
Background:  User is in password auth page 

     Scenario: Verify order of text in navigation bar
     Given User is in password auth page
     When User clicks sign in after entering password
     Then User should see the navigation bar displaying items in the order: Home,Dashboard,Education
   






     