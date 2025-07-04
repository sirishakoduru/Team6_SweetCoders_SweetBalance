Feature: Blood Report Upload Modal  navigation

Background: User should have completed until filling profile form
Given User is on the open Page
When User clicks login button and fill the form

Scenario: Verify navigation of blood report modal
Given User is in upload blood report page
When User clicks on "Upload Blood Report" button
Then User should navigate to blood report modal.