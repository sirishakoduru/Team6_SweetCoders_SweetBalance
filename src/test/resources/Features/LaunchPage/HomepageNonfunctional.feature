Feature: Non-Functional Testing - Home Page

Background:
Given User is in browser
When User enters the SweetBalance url

Scenario: Homepage loads within acceptable time
Then Page should be fully loaded within 3 seconds

Scenario: Homepage is responsive
Then All elements are readable and accessible without horizontal scrolling
########## Need fix ################
Scenario: Homepage maintains accessibility standards
Then All major sections are accessible with appropriate labels and alt texts

Scenario: Website is visually appealing
Then User finds the design visually appealing and readable

Scenario: Navigation bar remains accessible
Then User can access other sections without scrolling up

Scenario: Website supports all browsers
Then User has a consistent experience across browsers
#####################################