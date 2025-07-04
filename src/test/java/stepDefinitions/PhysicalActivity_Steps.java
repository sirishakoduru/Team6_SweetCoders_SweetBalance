package stepDefinitions;

import org.junit.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pageFactory.Login_POM;
import pageFactory.PhysicalActivity_POM;
import pageFactory.RecordNewDataTrackGlucose_POM;
import utilities.ConfigReader;

public class PhysicalActivity_Steps {
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	Login_POM login = new Login_POM();
	PhysicalActivity_POM activityPage = new PhysicalActivity_POM();
	RecordNewDataTrackGlucose_POM TrackGlucosePage = new RecordNewDataTrackGlucose_POM();

//@Given("User is in home page after logged into app")
//public void user_is_in_home_page_after_logged_into_app() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
@When("User clicks physical activity")
public void user_clicks_physical_activity() {
activityPage.ClickPhysicalActivityButton();
}

@Then("User should see physical activity title {string}")
public void user_should_see_physical_activity_title(String expectedTitle) {
    Assert.assertEquals(expectedTitle, activityPage.getFormTitle());
}
@Then("User should see activity subtext {string}")
public void user_should_see_subtext(String expectedText) {
    Assert.assertEquals(expectedText, activityPage.getSubtext());
}

@Then("User should see field for Activity Type, Duration, Date, Intensity")
public void user_should_see_field_for_activity_type_duration_date_intensity() {
	 Assert.assertTrue(activityPage.isDropdownDisplayed());
     Assert.assertTrue(activityPage.isDurationFieldDisplayed());
     Assert.assertTrue(activityPage.isDurationUnitDropdownDisplayed());
     Assert.assertTrue(activityPage.areIntensityButtonsVisible());
}

@Then("User should see dropdown for activity type")
public void user_should_see_dropdown_for_activity_type() {
	Assert.assertTrue(activityPage.isDropdownDisplayed());
}

@Then("User should see {string}")
public void user_should_see(String optionsCsv) {
    String[] expectedOptions = optionsCsv.split(",");
    boolean allPresent = activityPage.verifyDropdownOptions(expectedOptions) ||
                         activityPage.verifyDurationUnitOptions(expectedOptions);
    Assert.assertTrue(allPresent);
}

@Then("User should see input field for duration")
public void user_should_see_input_field_for_duration() {
	Assert.assertTrue(activityPage.isDurationFieldDisplayed());
}

@Then("User should see {string} in placeholder field")
public void user_should_see_in_placeholder_field(String expectedPlaceholder) {
    Assert.assertTrue(activityPage.verifyDurationPlaceholder(expectedPlaceholder));
}

@Then("User should see drop down duration")
public void user_should_see_drop_down_duration() {
	Assert.assertTrue(activityPage.isDurationUnitDropdownDisplayed());
}

@Then("User should see date")
public void user_should_see_date() {
	Assert.assertTrue(activityPage.isCalendarVisible());
}

@Then("User should see intensity field")
public void user_should_see_intensity_field() {
	Assert.assertTrue(activityPage.areIntensityButtonsVisible());
}

@Then("User should see save activity button")
public void user_should_see_save_activity_button() {
	  Assert.assertTrue(activityPage.isSaveButtonVisible());
}
//---Functional testing for physical activity---

@Given("User is in physical activity")
public void user_is_in_physical_activity() {
	 activityPage.enterDuration("30");
     activityPage.selectIntensity("Moderate");
     activityPage.clickSaveActivity();
}

@When("User clicks save activity after entering valid")
public void User_clicks_save_activity_after_entering_valid() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User should see \"Your activity is recorded\"")
public void User_should_see_Text(String expected) {
    Assert.assertTrue(activityPage.isConfirmationVisible());
}

@When("User enters invalid value in duration text field")
public void user_enters_invalid_value_in_duration_text_field() {
	activityPage.enterDuration("abc");
}

@Then("User should see blank")
public void user_should_see_blank() {
	Assert.assertEquals("", activityPage.getDurationInputValue());
}

@When("User clicks date picker")
public void user_clicks_date_picker() {
	activityPage.clickDatePicker();
}

@Then("User should see date calendar")
public void user_should_see_date_calendar() {
	 Assert.assertTrue(activityPage.isCalendarVisible());
}

@Then("User should see todays date highlighted")
public void user_should_see_today_s_date_highlighted() {
	Assert.assertTrue(activityPage.isTodayHighlighted());
}

@Then("User should see previous button in date picker")
public void user_should_see_previous_button_in_date_picker() {
	Assert.assertTrue(TrackGlucosePage.isPrevDateButtonVisible());
}

@Then("User should see next button in date")
public void user_should_see_next_button_in_date() {
	Assert.assertTrue(TrackGlucosePage.isNextDateButtonVisible());
}

}
