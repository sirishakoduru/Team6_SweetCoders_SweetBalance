package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pageFactory.*;
import utilities.CommonMethods;
import utilities.ConfigReader;

public class RecordNewDataForTrackGlucose {
	
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	Login_POM login = new Login_POM();
	ExerciseModuleOn_POM exercisePage = new ExerciseModuleOn_POM();
	RecordNewDataTrackGlucose_POM TrackGlucosePage = new RecordNewDataTrackGlucose_POM();
	WebDriver webDriver = DriverFactory.getDriver();
	 CommonMethods common = new CommonMethods();
	  
	//------TrackGlucose Validation--------
//	@Given("User is in home page after logged into app")
//	public void user_is_in_home_page_after_logged_into_app() {
//	 	login.performLogin();
//   	 WebElement homePageTitle = exercisePage.getCurrentStatusHeader(); 
//   	 common.waitForElementVisibilityOf(homePageTitle);
//   	System.out.println("Current page title: " + webDriver.getTitle());
//   	 Assert.assertTrue("Home page title not displayed", homePageTitle.isDisplayed());
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("User clicks Blood Glucose")
	public void user_clicks_blood_glucose() {
		TrackGlucosePage.clickbloodGlucoseButton();
	}

	@Then("User should see title {string}\"Track Glucose\"")
	public void user_should_see_title(String expectedTitle) {
		Assert.assertEquals(expectedTitle, TrackGlucosePage.getTitleText());
	}
	
	@Then("User should see glucose subtext {string}")
	public void user_should_see_glucose_subtext(String expectedText) {
		Assert.assertEquals(expectedText, TrackGlucosePage.getSubtext());
	}

	@Then("User should see field for Blood Glucose Level, Reading Type, Date")
	public void user_should_see_field_for_blood_glucose_level_reading_type_date() {
		Assert.assertTrue(TrackGlucosePage.areFieldsPresent());
       	}

	@Then("User should see text field for blood glucose")
	public void user_should_see_text_field_for_blood_glucose() {
		Assert.assertTrue(TrackGlucosePage.isInputFieldDisplayed());
	}

	@Then("User should see text {string}")
	public void user_should_see_text(String expectedText) {
	   String placeholderText = TrackGlucosePage.getGlucoseInputValue();
	   Assert.assertEquals(expectedText, placeholderText);
	}

	@Then("User should see three transition details with text {string}")
	public void user_should_see_three_transition_details_with_text(String string) {
	  Assert.assertTrue(TrackGlucosePage.areTransitionLevelsPresent());
	}

	@Then("User should see Red color in low")
	public void user_should_see_red_color_in_low() {
		   String color = TrackGlucosePage.getLowColor();
	        Assert.assertTrue(color.contains("rgb(220,") || color.contains("red"));
	}

	@Then("User should see green color in normal")
	public void user_should_see_green_color_in_normal() {
		   String color =TrackGlucosePage.getNormalColor();
	        Assert.assertTrue(color.contains("rgb(22,") || color.contains("green"));
	}

	@Then("User should see yellow color in high")
	public void user_should_see_yellow_color_in_high() {
		   String color = TrackGlucosePage.getHighColor();
	        Assert.assertTrue(color.contains("rgb(217,") || color.contains("orange"));
	}

	@Then("User should see button {string}")
	public void user_should_see_button(String string) {
		Assert.assertTrue(TrackGlucosePage.areButtonsPresent());
	}

	@Then("User should see the date picker")
	public void user_should_see_the_date_picker() {
		Assert.assertTrue(TrackGlucosePage.isDatePickerPresent());
	}

	@Then("User should see last ready details")
	public void user_should_see_last_ready_details() {
		Assert.assertTrue(TrackGlucosePage.isLastReadingPresent());
	}

	@Then("User should see record reading button")
	public void user_should_see_record_reading_button() {
		Assert.assertTrue(TrackGlucosePage.isRecordReadingButtonPresent());
	}

//-----------------Functional Testing for track glucose----------
@Given("User is in blood glucose")
public void user_is_in_blood_glucose() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User clicks record reading after valid reading")
public void user_clicks_record_reading_after_valid_reading() {
	TrackGlucosePage.enterGlucoseValue("120");
	TrackGlucosePage.clickRecordReading();
}
@Then("User should see the message {string}")
public void user_should_see_the_message(String expected) {
	Assert.assertTrue(TrackGlucosePage.isSuccessMessageDisplayed());

}
@When("User enters invalid value in blood glucose")
public void user_enters_invalid_value_in_blood_glucose() {
	TrackGlucosePage.enterGlucoseValue("aa");
}

@Then("User should see blank value")
public void user_should_see_blank_value() {
	Assert.assertEquals("", TrackGlucosePage.getGlucoseInputValue());
}

@When("User enters value in blood glucose")
public void user_enters_value_in_blood_glucose() {
	TrackGlucosePage.enterGlucoseValue("180");
}

@Then("User should see transition details highlights")
public void user_should_see_transition_details_highlights() {
	 Assert.assertTrue(TrackGlucosePage.isAnyTransitionHighlighted());
}

@When("User clicks date picker button")
public void user_clicks_date_picker_button() {
   TrackGlucosePage.openDatePicker();
}

@Then("User should see date calendar visible")
public void user_should_see_date_calendar() {
	Assert.assertTrue(TrackGlucosePage.isCalendarVisible());
}

@Then("User should see today date highlighted")
public void user_should_see_today_date_highlighted() {
	Assert.assertTrue(TrackGlucosePage.isTodayDateHighlighted());
}

@Then("User should see previous button in date for glucose")
public void user_should_see_previous_button_in_date_for_glucose() {
	Assert.assertTrue(TrackGlucosePage.isPrevDateButtonVisible());
}

@Then("User should see next button in date for glucose")
public void user_should_see_next_button_in_date_for_glucose() {
	Assert.assertTrue(TrackGlucosePage.isNextDateButtonVisible());
}
}
