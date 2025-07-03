Feature: Post-Onboarding Navigation and Upgrade Flow

Background: User clicks submit / continue after completing onboarding process
Given User is in upgrade page

Scenario: Verify user able to go to subscription payment screen
When User clicks the Upgrade to Premium button
Then User should be redirected to the subscription payment screen

Scenario: Verify title of Upgrade screen
When User clicks the Upgrade to Premium button
Then Page title should be "Upgrade to Premium"

Scenario: Verify sub text 
When User clicks the Upgrade to Premium button
Then User should see "Get personalized insights and advanced features to better manage your diabetes." on Upgrade to Premium page

Scenario: Verify the presence of "premium features" 
When User clicks the Upgrade to Premium button
Then User should see "premium features" on Upgrade to Premium page

Scenario: verify the description for premium feature 
When User clicks the Upgrade to Premium button
Then User should see text "✓Personalized meal plans,✓Advanced analytics,✓Priority support" on Upgrade to Premium page

Scenario: verify the presence of subscription price
When User clicks the Upgrade to Premium button
Then User should see "$9.99/month" on Upgrade to Premium page

Scenario: verify the presence of cancel anytime text
When User clicks the Upgrade to Premium button
Then User should see cancel anytime text below the pricing details on Upgrade to Premium page

Scenario: Verify the presence of "Card Number"
When User clicks the Upgrade to Premium button
Then User should see heading "Card Number" on Upgrade to Premium page

Scenario: Verify the presence of fields in payment
When User clicks the Upgrade to Premium button
Then User should see card number, expiration , cvv field on Upgrade to Premium page

Scenario: Verify  presence of payment button
When User clicks the Upgrade to Premium button
Then User should see "Pay $9.99 USD" button on Upgrade to Premium page
 
Scenario: Verify  terms and renewal message
When User clicks the Upgrade to Premium button
Then User should see terms of service and auto-renewal notice on Upgrade to Premium page

Scenario: Verify user able to go to home page
When user clicks the Continue free button
Then User should be redirected to the home page on Upgrade to Premium page


