package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.CommonHomePage_POM;
import pageFactory.SubscriptionPage_POM;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class SubscriptionPage_Step {

	SubscriptionPage_POM subscriptionPage = new SubscriptionPage_POM();
	CommonHomePage_POM commonHomePage = new CommonHomePage_POM();
	
	@Given("User is logged in and on free user account")
	public void user_is_logged_in_and_on_free_user_account() {
		commonHomePage.clickLoginBttn();
		commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("freeUSerEmail"));
		commonHomePage.clickContinueWithEmail();
		commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("freeUserPassword"));
		commonHomePage.clickSignInbttn();
	}

	@When("User clicks Upgrade to Premium button after Dashboard button")
	public void user_clicks_upgrade_to_premium_button_after_dashboard_button() {
		subscriptionPage.clickdashboardBttn();
		subscriptionPage.clickpremiumBttn();
	}

	@Then("Both Free and Premium should show Daily Meal Plan as available")
	public void both_free_and_premium_should_show_daily_meal_plan_as_available() {
		LoggerLoad.info("Daily meal free mark: " + subscriptionPage.getDailyFreeMark());
		assertEquals(subscriptionPage.getDailyFreeMark(), "✓");
		
		LoggerLoad.info("Daily meal premium mark: " + subscriptionPage.getDailyPremiumMark());
		assertEquals(subscriptionPage.getDailyPremiumMark(), "✓");
	}
	
	@Then("Weekly Meal Plan should be available only in Premium")
	public void weekly_meal_plan_should_be_available_only_in_premium() {
		LoggerLoad.info("Weekly meal free mark: " + subscriptionPage.getWeeklyFreeMark());
		assertEquals(subscriptionPage.getWeeklyFreeMark(), "✕");
		
		LoggerLoad.info("Weekly meal premium mark: " + subscriptionPage.getWeeklyPremiumMark());
		assertEquals(subscriptionPage.getWeeklyPremiumMark(), "✓");	    
	}

	@Then("Personalized Exercise Plan should be available only in Premium")
	public void personalized_exercise_plan_should_be_available_only_in_premium() {
		LoggerLoad.info("excercisePlan free mark: " + subscriptionPage.getexcercisePlanFreeMark());
		assertEquals(subscriptionPage.getexcercisePlanFreeMark(), "✕");
		
		LoggerLoad.info("excercisePlan premium mark: " + subscriptionPage.getexcercisePlanPremiumMark());
		assertEquals(subscriptionPage.getexcercisePlanPremiumMark(), "✓");	  	    
	}

	@Then("{int}-Day Quick Reversal Plan should be available only in Premium")
	public void day_quick_reversal_plan_should_be_available_only_in_premium(Integer int1) {
		LoggerLoad.info("Ten day free mark: " + subscriptionPage.gettendayPlanFreeMark());
		assertEquals(subscriptionPage.gettendayPlanFreeMark(), "✕");
		
		LoggerLoad.info("Ten day premium mark: " + subscriptionPage.gettendayPlanPremiumMark());
		assertEquals(subscriptionPage.gettendayPlanPremiumMark(), "✓");	  	    
	}

	@Then("{int}-Day Blood Sugar Reduction Plan should be available only in Premium")
	public void day_blood_sugar_reduction_plan_should_be_available_only_in_premium(Integer int1) {
		LoggerLoad.info("thirtyDayPlan free mark: " + subscriptionPage.getthirtyDayPlanFreeMark());
		assertEquals(subscriptionPage.getthirtyDayPlanFreeMark(), "✕");
		
		LoggerLoad.info("thirtyDayPlan premium mark: " + subscriptionPage.getthirtyDayPlanPremiumMark());
		assertEquals(subscriptionPage.getthirtyDayPlanPremiumMark(), "✓");	  	    
	}

	@Then("Both Free and Premium should show Glucose Level Graph as available")
	public void both_free_and_premium_should_show_glucose_level_graph_as_available() {
		LoggerLoad.info("gloucose free mark: " + subscriptionPage.getgloucoseGraphFreeMark());
		assertEquals(subscriptionPage.getgloucoseGraphFreeMark(), "✓");
		
		LoggerLoad.info("gloucose premium mark: " + subscriptionPage.getgloucoseGraphPremiumMark());
		assertEquals(subscriptionPage.getgloucoseGraphPremiumMark(), "✓");	    
	}

	@Then("Both Free and Premium should show BMI Calculation as available")
	public void both_free_and_premium_should_show_bmi_calculation_as_available() {
		LoggerLoad.info("bmi free mark: " + subscriptionPage.getbmiCalculationFreeMark());
		assertEquals(subscriptionPage.getbmiCalculationFreeMark(), "✓");
		
		LoggerLoad.info("bmi premium mark: " + subscriptionPage.getbmiCalculationPremiumMark());
		assertEquals(subscriptionPage.getbmiCalculationPremiumMark(), "✓");	    
	}

	@Then("Downloadable Meal Plan PDF should be available only in Premium")
	public void downloadable_meal_plan_pdf_should_be_available_only_in_premium() {
		LoggerLoad.info("mealPlan pdf free mark: " + subscriptionPage.getmealPlanPDFFreeMark());
		assertEquals(subscriptionPage.getmealPlanPDFFreeMark(), "✕");
		
		LoggerLoad.info("mealPlan pdf premium mark: " + subscriptionPage.getmealPlanPDFPremiumMark());
		assertEquals(subscriptionPage.getmealPlanPDFPremiumMark(), "✓");	  	 	    
	}

	@Then("Reminders should be available only in Premium")
	public void reminders_should_be_available_only_in_premium() {
		LoggerLoad.info("raminderTasks free mark: " + subscriptionPage.getraminderTasksFreeMark());
		assertEquals(subscriptionPage.getraminderTasksFreeMark(), "✕");
		
		LoggerLoad.info("raminderTasks premium mark: " + subscriptionPage.getraminderTasksPremiumMark());
		assertEquals(subscriptionPage.getraminderTasksPremiumMark(), "✓");	  	 	    
	}
	@Then("The {string} button should be visible")
	public void the_button_should_be_visible(String buttonName) {
		if(buttonName.equalsIgnoreCase("Continue free")) {
			LoggerLoad.info("Button name is: " +buttonName);
			assertTrue(subscriptionPage.iscontinueFreeBttnDisplayed());
		}
		else if(buttonName.equalsIgnoreCase("Upgrade to Premium")) {
			LoggerLoad.info("Button name is: " +buttonName);
			assertTrue(subscriptionPage.isupgradPremiumBttnDisplayed());
		}
	}

	@Then("It should display {string}")
	public void it_should_display(String accountName) {
		if(accountName.equalsIgnoreCase("Free Account")) {
			LoggerLoad.info("Button name is: " +accountName);
			assertTrue(subscriptionPage.isfreeAccountLabelDisplayed());
		}
		else if(accountName.equalsIgnoreCase("Premium Account")) {
			LoggerLoad.info("Button name is: " +accountName);
			assertTrue(subscriptionPage.ispremiumAccountLabelDisplayed());
		}	    
	}

	@Then("Features not included should have red X icons")
	public void features_not_included_should_have_red_x_icons() {
		List<String> crossMarkcolors = subscriptionPage.getColourCrossCheckMark();
	    for(String crossMarkcolor : crossMarkcolors) {
	    	assertEquals(crossMarkcolor, "rgba(2, 8, 23, 1)");
	    }
	}

	@Then("All included features should have green checkmarks")
	public void all_included_features_should_have_green_checkmarks() {
		List<String> rightMarkColors = subscriptionPage.getColourRightCheckMark();
	    for(String rightMarkColor : rightMarkColors) {
	    	assertEquals(rightMarkColor, "rgba(2, 8, 23, 1)");
	    }
	}

	@Then("It should list exactly {int} features")
	public void it_should_list_exactly_features(Integer expectedNoFeatures) {
		LoggerLoad.info("Actual no of features: " +subscriptionPage.getNoOflistFeatures());
		assertEquals(subscriptionPage.getNoOflistFeatures(), expectedNoFeatures);	    
	}

	@Then("{string} button should appear")
	public void button_should_appear(String buttonName) {
		if(buttonName.equalsIgnoreCase("Continue free")) {
			LoggerLoad.info("Button name is: " +buttonName);
			assertTrue(subscriptionPage.iscontinueFreeBttnEnabled());
		}
		else if(buttonName.equalsIgnoreCase("Upgrade to Premium")) {
			LoggerLoad.info("Button name is: " +buttonName);
			assertTrue(subscriptionPage.isupgradPremiumBttnEnabled());
		}	    
	}

	@Then("Terms & Conditions and Privacy Policy text should be visible")
	public void terms_conditions_and_privacy_policy_text_should_be_visible() {
		LoggerLoad.info("Term condition text: " +subscriptionPage.getTermConditionText());
	    assertEquals(subscriptionPage.getTermConditionText(), "By purchasing, you agree to our Terms & Conditions and Privacy Policy.");	    
	}

	@Then("It should show the text “Upgrade to premium for complete diabetes management”")
	public void it_should_show_the_text_upgrade_to_premium_for_complete_diabetes_management() {
		LoggerLoad.info("Upgrade Premium text: " +subscriptionPage.getupgradPremiumTitleText());
	    assertEquals(subscriptionPage.getupgradPremiumTitleText(), "Upgrade to premium for complete diabetes management");	 	    
	}

	@Then("The Free and Premium plans should be displayed side-by-side in clearly separated columns")
	public void the_free_and_premium_plans_should_be_displayed_side_by_side_in_clearly_separated_columns() {
	    
	    
	}
	@Given("User is in upgrade page")
	public void user_is_in_upgrade_page() {
		commonHomePage.clickLoginBttn();
		commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("freeUSerEmail"));
		commonHomePage.clickContinueWithEmail();
		commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("freeUserPassword"));
		commonHomePage.clickSignInbttn();
		subscriptionPage.clickdashboardBttn();
		subscriptionPage.clickpremiumBttn();
	}

	@When("User clicks the Upgrade to Premium button")
	public void user_clicks_the_upgrade_to_premium_button() {
	    subscriptionPage.clickupgradPremiumBttn();
	    
	}

	@Then("User should be redirected to the subscription payment screen")
	public void user_should_be_redirected_to_the_subscription_payment_screen() {
	    String actualPageURL = subscriptionPage.getCurrentUrl();
	    assertEquals(actualPageURL, "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/Premium");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		assertEquals(subscriptionPage.getupgradePremiumTitleText(), expectedTitle);
	    
	}

	@Then("User should see {string} on Upgrade to Premium page")
	public void user_should_see_on_upgrade_to_premium_page(String expectedLabel) {
		String actualLabel;
		if(expectedLabel.contains("manage your diabetes")) {
			actualLabel = subscriptionPage.getmanageDiabetesText();
			LoggerLoad.info("Validate label: " +actualLabel);
			assertEquals(actualLabel.trim(), expectedLabel.trim(), "\"" +expectedLabel+ "\" Label is not visible");
		}
		else if (expectedLabel.contains("premium features")) {
			actualLabel = subscriptionPage.getpremiumFeaturesText();
			LoggerLoad.info("Validate label: " +actualLabel);
			assertTrue(actualLabel.equalsIgnoreCase(expectedLabel), "\"" +expectedLabel+ "\" Label is not visible");
		}
		else if (expectedLabel.contains("month")) {
			actualLabel = subscriptionPage.getpriceHeadingText();
			LoggerLoad.info("Validate label: " +actualLabel);
			assertTrue(actualLabel.equalsIgnoreCase(expectedLabel), "\"" +expectedLabel+ "\" Label is not visible");
		}
	    else {
	    	throw new IllegalArgumentException("Unexpected label: " + expectedLabel);
	    }    	    
	}

//	@Then("User should see text {string}")
//	public void user_should_see_text(String string) {
//	    
//	    
//	}

	@Then("User should see text {string} on Upgrade to Premium page")
	public void user_should_see_text_on_upgrade_to_premium_page(String string) {
	    List<String> listPremiunFeaturesHeading = subscriptionPage.getlistPremiunFeaturesHeading();
	    for(String premiumFeatureHeading : listPremiunFeaturesHeading) {	    	
	    	if(premiumFeatureHeading.contains("meal plan")) {
	    		LoggerLoad.info("premiumFeatureHeading is : " +premiumFeatureHeading);
	    		assertEquals(premiumFeatureHeading, "Personalized meal plans");
	    	}
	    	else if(premiumFeatureHeading.contains("analytics")) {
	    		LoggerLoad.info("premiumFeatureHeading is : " +premiumFeatureHeading);
	    		assertEquals(premiumFeatureHeading, "Advanced analytics");
	    	}
	    	else if(premiumFeatureHeading.contains("support")) {
	    		LoggerLoad.info("premiumFeatureHeading is : " +premiumFeatureHeading);
	    		assertEquals(premiumFeatureHeading, "Priority support");
	    	}
		    else {
		    	throw new IllegalArgumentException("Unexpected premiumFeatureHeading: " + premiumFeatureHeading);
		    }    	
	    }
	}

	@Then("User should see cancel anytime text below the pricing details on Upgrade to Premium page")
	public void user_should_see_cancel_anytime_text_below_the_pricing_details_on_upgrade_to_premium_page() {
		LoggerLoad.info("Actual text below pricing detail: " +subscriptionPage.getcancelAnytimeText());
		assertEquals(subscriptionPage.getcancelAnytimeText(), "Cancel anytime", "cancel anytime is not displayed below the pricing details");	    
	}

	@Then("User should see heading {string} on Upgrade to Premium page")
	public void user_should_see_heading_on_upgrade_to_premium_page(String string) {
	    assertTrue(subscriptionPage.iscardNumberDisplayed());	    
	}

	@Then("User should see card number, expiration , cvv field on Upgrade to Premium page")
	public void user_should_see_card_number_expiration_cvv_field_on_upgrade_to_premium_page() {
		assertTrue(subscriptionPage.isexpirationDateDisplayed());
		assertTrue(subscriptionPage.isCVCDisplayed());
	}

	@Then("User should see {string} button on Upgrade to Premium page")
	public void user_should_see_button_on_upgrade_to_premium_page(String string) {
		assertTrue(subscriptionPage.issubmitbttnDisplayed());
		assertTrue(subscriptionPage.issubmitbttnEnabled());
	}

	@Then("User should see terms of service and auto-renewal notice on Upgrade to Premium page")
	public void user_should_see_terms_of_service_and_auto_renewal_notice_on_upgrade_to_premium_page() {
		assertTrue(subscriptionPage.istermServiceNoticeDisplayed());	    
	}

	@When("user clicks the Continue free button")
	public void user_clicks_the_continue_free_button() {
	    subscriptionPage.clickcontinueFreeBttn();	    
	}

	@Then("User should be redirected to the home page on Upgrade to Premium page")
	public void user_should_be_redirected_to_the_home_page_on_upgrade_to_premium_page() {
	    String actualPageURL = subscriptionPage.getCurrentUrl();
	    assertEquals(actualPageURL, "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/free");	    
	}
}
