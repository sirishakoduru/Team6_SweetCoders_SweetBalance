Feature: Functional scenarios for Step and non functional scenarios for  Step 2 

Background: User should clicked steps for onboarding button in upload page
Given User is on the upload page
When User clicks onboarding button and goes to step 1

@onboardingStep2_01
Scenario: Verify option is selectable
Given User is in step 1
When User selects the condition in step 1
Then User should navigate to step 2

@onboardingStep2_02
Scenario: Verify message after selecting condition in step 1
When User selects the condition in step 1
Then User should receive message "No worries, we're here to figure it out together! 🔍"

@onboardingStep2_03
Scenario: Verify presence of  back button in step 2
When User selects the condition in step 1
Then User should see back button in step 2 of onboarding

@onboardingStep2_04
Scenario: Verify Step 2 heading is visible 
When User selects the condition in step 1
Then Page should display title "Which fabulous label fits you best?"

@onboardingStep2_05
Scenario: Verify step 2 sub text
When User selects the condition in step 1
Then Page should have sub text "Choose your gender" visible

@onboardingStep2_06
Scenario: Verify step 2 progress is highlighted
When User selects the condition in step 1
Then Step  indicator should be highlighted

@onboardingStep2_07
Scenario: Progress bar reflects Step 2 of 12
When User selects the condition in step 1
Then Progress bar should visually indicate "Step 2 of 12" below progress bar

@onboardingStep2_08
Scenario: Verify gender options
When User selects the condition in step 1
Then User should see options labeled """Male 👨‍🦱,Female 👩‍🦰,Other ⚧️"""
 