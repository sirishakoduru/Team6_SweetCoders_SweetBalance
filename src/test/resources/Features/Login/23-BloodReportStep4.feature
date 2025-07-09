Feature: Onboarding Step 3 UI

Background: User should have completed until step 2
Given User is on uploading page and clicks upload blood report
When User clicks continue onboarding button 

Scenario: Verify option is selectable
Given User is in step three
When User selects dietary preference
Then User should navitae to step four

Scenario: Verify back button function
Given User is in step three
When User clicks back button
Then User should navigate to step two

Scenario: Verify Step 4 heading is visible
Given User is in step three
When User selects dietary preference
Then Page should display title "What's your go-to food passport?" of blood report step four

Scenario: Verify step 4 sub text
Given User is in step three
When User selects dietary preference
Then User should see sub text "To create a meal plan you'll enjoy, please select your preferred cuisines!" of step four

Scenario: Progress bar reflects Step 4 of 5
Given User is in step three
When User selects dietary preference
Then Progress bar should visually indicate "Step 4 of 5" of step four

Scenario: Verify Back button is visible
Given User is in step three
When User selects dietary preference
Then Back button should be visible for steps

Scenario: Verify options is displayed
Given User is in step three
When User selects dietary preference
Then User should see options labeled "Indian ,American, Continental, Mediterranean, Asian, Middle Eastern, Mexican "