Feature: Onboarding Step 1 UI validation

Background: User successfully completed profile setup
Given User is on complete profile form page for uploading blood report
When User fills out all fields and submits the profile form
Then User should redirected to upload blood report

@Onboarding_01
Scenario: Verify navigation to step for onboarding
Given User is in upload blood report page
When User clicks on step for onboarding button
Then User should navigate to onboarding Step 1 

@Onboarding_02
Scenario: Verify Step 1 heading is visible
Then Page should display title "So, Which sugar rebellion are we dealing with?'

@Onboarding_03
Scenario: Verify Step 1 sub text
Then Page should have sub text "This will help us tailor your plan to your condition"

@Onboarding_04
Scenario: Progress bar reflects Step 1 of 12
Then Progress bar should visually indicate "Step 1 of 12"

@Onboarding_05
Scenario: Progress bar reflects Step 1 of 12
Then Step 1 indicator should be highlighted

@Onboarding_06
Scenario: Verify options is displayed
Then User should see an option labeled  "Type 2,I don't know"