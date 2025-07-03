package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentPage_Step {

	@Given("User is in upgrade to premium page")
	public void user_is_in_upgrade_to_premium_page() {
	    
	}

	@When("User clicks the {string} button without entering any card details")
	public void user_clicks_the_button_without_entering_any_card_details(String string) {
	   
	}

	@Then("User should see validation messages for all required fields")
	public void user_should_see_validation_messages_for_all_required_fields() {
	 
	}

	@When("User clicks the {string} button with invalid card number")
	public void user_clicks_the_button_with_invalid_card_number(String string) {
	    
	}

	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
	    
	}

	@When("User clicks the {string} button with expired card")
	public void user_clicks_the_button_with_expired_card(String string) {
	   
	}

	@When("User clicks the {string} button with valid payment details")
	public void user_clicks_the_button_with_valid_payment_details(String string) {
	   
	}

	@Then("User should be redirected to the confirmation or home page with premium access enabled")
	public void user_should_be_redirected_to_the_confirmation_or_home_page_with_premium_access_enabled() {
	    
	}
}
