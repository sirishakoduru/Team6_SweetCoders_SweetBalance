package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.CommonHomePage_POM;
import pageFactory.PaymentPage_POM;
import pageFactory.SubscriptionPage_POM;
import utilities.ConfigReader;
import utilities.LoggerLoad;


public class PaymentPage_Step {

	SubscriptionPage_POM subscriptionPage = new SubscriptionPage_POM();
	CommonHomePage_POM commonHomePage = new CommonHomePage_POM();
	PaymentPage_POM paymentPage = new PaymentPage_POM();
	
	@Given("User is in upgrade to premium page")
	public void user_is_in_upgrade_to_premium_page() {
		commonHomePage.clickLoginBttn();
		commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("freeUSerEmail"));
		commonHomePage.clickContinueWithEmail();
		commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("freeUserPassword"));
		commonHomePage.clickSignInbttn();
		subscriptionPage.clickdashboardBttn();
		subscriptionPage.clickpremiumBttn();
		subscriptionPage.clickupgradPremiumBttn();
	}

	@When("User clicks the {string} button without entering any card details")
	public void user_clicks_the_button_without_entering_any_card_details(String string) {
		paymentPage.clicksubmitbttn();
	}

	@Then("User should see validation messages for all required fields")
	public void user_should_see_validation_messages_for_all_required_fields() {
	    List<String> listValidationMsgs = paymentPage.getListValidationMsg();
	    for(String validationMsg : listValidationMsgs) {	    	
	    	if(validationMsg.contains("card number")) {
	    		LoggerLoad.info("validationMsg is : " +validationMsg);
	    		assertEquals(validationMsg, "Your card number is incomplete.");
	    	}
	    	else if(validationMsg.contains("expiration date")) {
	    		LoggerLoad.info("validationMsg is : " +validationMsg);
	    		assertEquals(validationMsg, "Your card’s expiration date is incomplete.");
	    	}
	    	else if(validationMsg.contains("security code")) {
	    		LoggerLoad.info("validationMsg is : " +validationMsg);
	    		assertEquals(validationMsg, "Your card’s security code is incomplete.");
	    	}
		    else {
		    	throw new IllegalArgumentException("Unexpected validationMsg: " + validationMsg);
		    }    	
	    }
	}

	@When("User clicks the {string} button with invalid card number")
	public void user_clicks_the_button_with_invalid_card_number(String string) {
	    paymentPage.enterCardNumber("2525252525252525");
	    paymentPage.clicksubmitbttn();
	}

	@Then("error message {string} should be displayed")
	public void error_message_should_be_displayed(String expectedMsg) {
		List<String> listValidationMsgs = paymentPage.getListValidationMsg();
	    for(String validationMsg : listValidationMsgs) {	    	
	    	if(validationMsg.contains("card number")) {
	    		LoggerLoad.info("validationMsg is : " +validationMsg);
	    		assertEquals(validationMsg, expectedMsg, "Error message after invalid card details does not match");
	    	}
	    	else if(validationMsg.contains("expiration date")) {
	    		LoggerLoad.info("validationMsg is : " +validationMsg);
	    		assertEquals(validationMsg, "Your card’s expiration date is incomplete.");
	    	}
	    	else if(validationMsg.contains("security code")) {
	    		LoggerLoad.info("validationMsg is : " +validationMsg);
	    		assertEquals(validationMsg, "Your card’s security code is incomplete.");
	    	}
		    else {
		    	throw new IllegalArgumentException("Unexpected validationMsg: " + validationMsg);
		    }    	
	    }
	    LoggerLoad.info("Actual error msg: " +paymentPage.geterrorMsgText());
	    assertEquals(paymentPage.geterrorMsgText(), "Please correct the errors in the payment form", "Did not get error message after invalid card details");
	}

	@When("User clicks the {string} button with expired card")
	public void user_clicks_the_button_with_expired_card(String string) {
		paymentPage.enterCardNumber("4242424242424242");
		paymentPage.enterExpiryDate("1024"); // card expired
		paymentPage.enterCVCdetail("258");
		paymentPage.clicksubmitbttn();
	}

	@When("User clicks the {string} button with valid payment details")
	public void user_clicks_the_button_with_valid_payment_details(String string) {
		paymentPage.enterCardNumber("4242424242424242");
		paymentPage.enterExpiryDate("0529"); // future date
		paymentPage.enterCVCdetail("258");
		paymentPage.clicksubmitbttn();
	}

	@Then("User should be redirected to the confirmation or home page with premium access enabled")
	public void user_should_be_redirected_to_the_confirmation_or_home_page_with_premium_access_enabled() {
	    String actualPageURL = subscriptionPage.getCurrentUrl();
	    assertEquals(actualPageURL, "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/Premium");
	}
}
