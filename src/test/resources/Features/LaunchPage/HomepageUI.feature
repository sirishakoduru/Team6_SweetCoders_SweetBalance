Feature: Verify Homepage UI components

Background:
Given User launches the browser
When User enters the SweetBalance url

Scenario: Validate the presence of App Name on the home page 
Then User should see app name on the top left

Scenario: Validate the presence of policy details
Then User should see the text - Our Terms of Service and Privacy Policy have recently been updated

Scenario: Verify the homepage heading is visible
Then User should see the text - Smart Diabetes Tracking Powered by AI

Scenario: Verify the Start Today input button is visible
Then User should see a "Start Today" input button

Scenario: Verify the diabetes management tools section is visible
Then User should see the text - Comprehensive Diabetes Management Tools

Scenario: Verify the Health Tracking card is visible
Then User should see a card with title - Health Tracking

Scenario: Verify the Nutrition & Exercise card is visible
Then User should see a card with title - Nutrition & Exercise

Scenario: Verify the Smart Insights card is visible
Then User should see a card with title - Smart Insights

Scenario: Validate description in Health Tracking feature card 
Then User should see the text - Monitor glucose levels, medication, and vital statistics, Easy logging of daily readings,Visualize trends over time,Set personalized targets

Scenario: Validate description in Nutrition & Exercise card 
Then User should see the text - Balance diet and physical activity for optimal control,Carb counting tools,Customized exercise plans, Meal suggestions based on readings

Scenario: Validate description in Smart Insights card 
Then User should see the text - Get personalized guidance based on your data, Pattern detection algorithms,Early warning notifications,Actionable recommendations

Scenario: Validate icon in Health tracking feature card
Then User should see heart icon 

Scenario: Validate icon in Nutrition & Exercise card 
Then User should see activity inside square icon 

Scenario: Validate icon in Smart Insights card 
Then User should see clock icon 

Scenario: Verify testimonial from James D. is visible
Then User should see a testimonial from user - James D.

Scenario: Verify testimonial from Maria L. is visible
Then User should see a testimonial from user - Maria L.

Scenario: Verify testimonial from Robert T. is visible
Then User should see a testimonial from user - Robert T.

Scenario: Validate "Join our community of successful members" text is visible above testimonial section
Then User should see - Join our community of successful members - text is visible above testimonial section

Scenario: Validate presence of 5 yellow stars above "Join our community of successful members" text
Then  User should see 5 yellow stars above "Join our community of successful members" text

Scenario: Validate rating for James D testimonial
Then User should see 5 stars under - James D.

Scenario: Validate rating for Maria L testimonial
Then User should see 5 stars under - Maria L.

Scenario: Validate rating for Robert T testimonial
Then User should see 5 stars under - Robert T

Scenario: Validate presence of bottom section heading in home page
Then User should see a section with heading - Take control of your diabetes today

Scenario: Validate the presence of button "Check your Risk"
Then User should see a button labeled - Check Your Risk
