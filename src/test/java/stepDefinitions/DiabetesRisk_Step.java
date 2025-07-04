package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.DiabetesRisk_POM;
import utilities.LoggerLoad;

public class DiabetesRisk_Step {

	DiabetesRisk_POM diabetesRisk = new DiabetesRisk_POM();
	
	@Given("User is on the SweetBalance homepage")
	public void user_is_on_the_sweet_balance_homepage() {
		LoggerLoad.info("User is on sweetbalance homepage");
	}
	@When("User clicks {string} button")
	public void user_clicks_button(String string) {
	    diabetesRisk.clickCheckRiskRttn();	    
	}

	@Then("User should see {string} header")
	public void user_should_see_header(String string) {
	    assertTrue(diabetesRisk.isdiabetesPopUpDisplayed());	    
	}

	@Then("User see  {string} text")
	public void user_see_text(String string) {
	    String textQue = diabetesRisk.getanswerQuestext();
	    LoggerLoad.info("Ques title: " +textQue);
	    assertTrue(textQue.equalsIgnoreCase("Answer a few questions to assess your risk of developing diabetes"));
	}

	@Then("User should see Cancel button")
	public void user_should_see_cancel_button() {
		assertTrue(diabetesRisk.iscancelBttnDisplayed());	    
	}

	@Then("User should see Calculate Risk button")
	public void user_should_see_calculate_risk_button() {	    
		assertTrue(diabetesRisk.iscalculateRiskBttnDisplayed());
	}

	@Then("User should see Calculate Risk button disabled")
	public void user_should_see_calculate_risk_button_disabled() {
		assertFalse(diabetesRisk.iscalculateRiskBttnEnabled());	    
	}

	@Then("User should see Age input field to have stepper controls")
	public void user_should_see_age_input_field_to_have_stepper_controls() {
	    assertTrue("number".equalsIgnoreCase(diabetesRisk.getAgeInputType()));	    
	}

	@Then("User should see weight input field to have stepper controls")
	public void user_should_see_weight_input_field_to_have_stepper_controls() {
		assertTrue("number".equalsIgnoreCase(diabetesRisk.getWeightInputType()));	    
	}

	@Then("User should see check box for Family history of diabetes field")
	public void user_should_see_check_box_for_family_history_of_diabetes_field() {
		assertTrue(diabetesRisk.isfamilyHistoryInputDisplayed());	    
	}

	@Then("User should be able to view the placeholder {string} in the age field")
	public void user_should_be_able_to_view_the_placeholder_in_the_age_field(String valuePlaceholer) {
	    String agePlaceholer = diabetesRisk.getAgeInputplaceholder();
	    LoggerLoad.info("Actual agePlaceholer: " +agePlaceholer);
	    LoggerLoad.info("Expected agePlaceholer: " +valuePlaceholer);
	    assertEquals(agePlaceholer, valuePlaceholer);
	}

	@Then("User should see {string} in weight field")
	public void user_should_see_in_weight_field(String valuePlaceholer) {
	    String weightPlaceholer = diabetesRisk.getWeightInputplaceholder();
	    LoggerLoad.info("Actual agePlaceholer: " +weightPlaceholer);
	    LoggerLoad.info("Expected agePlaceholer: " +valuePlaceholer);
	    assertEquals(weightPlaceholer, valuePlaceholer);
	}
	
	@Then("User should see  dropdown for Physical Activity Level")
	public void user_should_see_dropdown_for_physical_activity_level() {
		assertTrue("select".equalsIgnoreCase(diabetesRisk.getphysicalActivityTagName()));	    
	}

	@Then("User should see dropdown for Blood Pressure")
	public void user_should_see_dropdown_for_blood_pressure() {
	    assertEquals(diabetesRisk.getbloodPressureTagName(), "select");	    
	}

	@Then("User should see dropdown for Diet Quality")
	public void user_should_see_dropdown_for_diet_quality() {
		assertEquals(diabetesRisk.getdietQualityTagName(), "select");	    
	}

	@Then("User should see {string} as the default option")
	public void user_should_see_as_the_default_option(String optionText) {
	
		switch(optionText) {
		case "Select activity level":
			LoggerLoad.info("Actual text: " +diabetesRisk.getphysicalActivityText());
			LoggerLoad.info("Expected text: " +optionText);
			assertTrue(diabetesRisk.getphysicalActivityText().contains(optionText));
			break;
		case "Select blood pressure status":
			LoggerLoad.info("Actual text: " +diabetesRisk.getbloodPressureText());
			LoggerLoad.info("Expected text: " +optionText);
			assertTrue(diabetesRisk.getbloodPressureText().contains(optionText));
			break;
		case "Select diet quality":
			LoggerLoad.info("Actual text: " +diabetesRisk.getdietQualityText());
			LoggerLoad.info("Expected text: " +optionText);
			assertTrue(diabetesRisk.getdietQualityText().contains(optionText));
			break;
		default:
            throw new IllegalArgumentException("Unexpected optionText: " + optionText);
		}
	}

	@Then("User should see the {string}")
	public void user_should_see_the(String optionText) {
		if (optionText.contains("Active")) {
			String actualText = diabetesRisk.getphysicalActivityText().replaceAll("[\\r\\n]+", " ").trim();
			LoggerLoad.info("Actual text: " +actualText);
			LoggerLoad.info("Expected text: " +optionText);
			assertTrue(actualText.contains(optionText));
		} else if (optionText.contains("Normal")) {
			String actualText = diabetesRisk.getbloodPressureText().replaceAll("[\\r\\n]+", " ").trim();
			LoggerLoad.info("Actual text: " +actualText);
			LoggerLoad.info("Expected text: " +optionText);
			assertTrue(actualText.contains(optionText));
		} else if (optionText.contains("Excellent")) {
			String actualText = diabetesRisk.getdietQualityText().replaceAll("[\\r\\n]+", " ").trim();
			LoggerLoad.info("Actual text: " +actualText);
			LoggerLoad.info("Expected text: " +optionText);
			assertTrue(actualText.contains(optionText));
		} else {
            throw new IllegalArgumentException("Unexpected optionText: " + optionText);
		}    
	}
	
	@Given("User is in diabetes risk analyzer")
	public void user_is_in_diabetes_risk_analyzer() {
	    diabetesRisk.clickCheckRiskRttn();	    
	}
	@When("User clicks Cancel button")
	public void user_clicks_cancel_button() {	    
	    diabetesRisk.clickCancelBttn();
	}

	@Then("User should be returned to the home page")
	public void user_should_be_returned_to_the_home_page() {
	    String actualUrl = diabetesRisk.getCurrentUrl();
	    assertEquals(actualUrl, "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/firstPage");
	}

	@When("User enters values in all fields")
	public void user_enters_values_in_all_fields() {
	    Random random = new Random();
	    int randomValue = 1 + random.nextInt(2);    // 0 to 3
	    
	    diabetesRisk.enterAgeInput();
	    diabetesRisk.enterWeightInput();
	    //diabetesRisk.clickphysicalActivity();
	    if(randomValue==1) {
		    diabetesRisk.clickactivePA();
		    diabetesRisk.clicknormalBP();
		    diabetesRisk.clickexcellentDQ();
	    }
	    else if(randomValue == 2) {
	        diabetesRisk.clickmoderatePA();
		    diabetesRisk.clickelevatedBP();
		    diabetesRisk.clickaverageDQ();
	    }
	    else if(randomValue == 3) {
	        diabetesRisk.clicksedentaryPA();
		    diabetesRisk.clickhighBP();
		    diabetesRisk.clickpoorDQ();
	    }
	}

	@Then("User should see {string} button is  enabled")
	public void user_should_see_button_is_enabled(String string) {
		assertTrue(diabetesRisk.iscalculateRiskBttnEnabled());	    
	}

	@When("User clicks {string} button after entering valid values in all fields")
	public void user_clicks_button_after_entering_valid_values_in_all_fields(String string) {
	    Random random = new Random();
	    int randomValue = 1 + random.nextInt(2);    // 0 to 3
	    
	    diabetesRisk.enterAgeInput();
	    diabetesRisk.enterWeightInput();
	    if(randomValue==1) {
		    diabetesRisk.clickactivePA();
		    diabetesRisk.clicknormalBP();
		    diabetesRisk.clickexcellentDQ();
	    }
	    else if(randomValue == 2) {
	        diabetesRisk.clickmoderatePA();
		    diabetesRisk.clickelevatedBP();
		    diabetesRisk.clickaverageDQ();
	    }
	    else if(randomValue == 3) {
	        diabetesRisk.clicksedentaryPA();
		    diabetesRisk.clickhighBP();
		    diabetesRisk.clickpoorDQ();
	    }
	    diabetesRisk.clickcalculateRiskBttn();    
	}

	@Then("User should see {string} dialog box")
	public void user_should_see_dialog_box(String string) {
		assertTrue(diabetesRisk.isassessmentPopUpDisplayed());	    
	}
}
