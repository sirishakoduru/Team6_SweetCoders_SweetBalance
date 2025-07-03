Feature: Upgrade to Premium Subscription

Background: User clicks the "Upgrade to Premium" button after reaching subscription page
Given User is in upgrade to premium page

Scenario: Verify User able to do payment with empty fields
When User clicks the "Pay $9.99 USD" button without entering any card details
Then User should see validation messages for all required fields
#######Need fix- webelement not working###########
Scenario: Verify User able to do payment with invalid card number
When User clicks the "Pay $9.99 USD" button with invalid card number
Then error message "Your card number is invalid." should be displayed  

Scenario: Verify User able to do payment with expired card
When User clicks the "Pay $9.99 USD" button with expired card
Then error message "Your card number is incomplete." should be displayed  

Scenario: Verify User able to do payment with valid payment details
When User clicks the "Pay $9.99 USD" button with valid payment details
Then User should be redirected to the confirmation or home page with premium access enabled

