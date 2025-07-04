package stepDefinitions;

import java.util.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mongodb.diagnostics.logging.Logger;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pageFactory.CommonHomePage_POM;
import pageFactory.FoodIntakeTracker_POM;
import pageFactory.Login_POM;
import pageFactory.RecordNewDataTrackGlucose_POM;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class FoodIntakeTracker_Step {
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	Login_POM login = new Login_POM();
	FoodIntakeTracker_POM foodIntakePage = new FoodIntakeTracker_POM();
	RecordNewDataTrackGlucose_POM TrackGlucosePage = new RecordNewDataTrackGlucose_POM();
	CommonHomePage_POM commonHomePage = new CommonHomePage_POM();
	WebDriver webDriver = DriverFactory.getDriver();
	
	@Given("User is in home page after logged into app")
	public void user_is_in_home_page_after_logged_into_app() {
		commonHomePage.clickLoginBttn();
		commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("freeUSerEmail"));
		commonHomePage.clickContinueWithEmail();
		commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("freeUserPassword"));
		commonHomePage.clickSignInbttn();
		LoggerLoad.info("User is on sweetbalance homepage");
	}
    @When("User clicks Food Intake")
    public void user_Clicks_FoodIntake() {
    	foodIntakePage.clickfoodIntakeButton();
    }

    @Then("User should see Food Intake title {string}")
    public void user_Should_See_FoodIntake_Title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, foodIntakePage.getFormTitle());
    }
	@Then("User should see the subtext {string}")
	public void user_should_see_subtext(String expectedText) {
		 Assert.assertEquals(expectedText, foodIntakePage.getFormSubtext());
	}

	@Then("User should see {string} tabs")
	public void user_should_see_tabs(String string) {
		   List<String> expectedTabs = Arrays.asList("Breakfast", "Lunch", "Dinner", "Snack");
	        for (String tab : expectedTabs) {
	            Assert.assertTrue(foodIntakePage.isMealTabDisplayed(tab));
	        }	
	      }

	@Then("User should see field for Food Name, Serving Size, Calorie, Date, Notes")
	public void user_should_see_field_for_food_name_serving_size_calorie_date_notes() {
			Assert.assertTrue(foodIntakePage.isFoodNameVisible());
	        Assert.assertTrue(foodIntakePage.isServingSizeDropdownVisible());
	        Assert.assertTrue(foodIntakePage.isCalorieInputVisible());
	        Assert.assertTrue(foodIntakePage.isDatePickerVisible());
	        Assert.assertTrue(foodIntakePage.isNotesInputVisible());
	}

	@Then("User should see {string} tab selected by default")
	public void user_should_see_tab_selected_by_default(String string) {
		Assert.assertTrue(foodIntakePage.getBreakfastTab().getAttribute("class").contains("selected"));
	}

	@Then("User should see input field for field food name")
	public void user_should_see_input_field_for_field_food_name() {
		 Assert.assertTrue(foodIntakePage.isFoodNameVisible());
	}

	@Then("User should see text {string} as placeholder in input field")
	public void user_should_see_text_as_placeholder_in_input_field(String string) {
		 Assert.assertEquals("e.g., Grilled Chicken Salad", foodIntakePage.getFoodNamePlaceholderText());
	}

	@Then("User should see {string} as the default value in the Serving Size dropdown")
	public void user_should_see_as_the_default_value_in_the_serving_size_dropdown(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should see small (half cup), Medium (1 cup), Large (2 cup),Custom")
	public void user_should_see_small_cup_medium_cup_large_cup_custom() {
		 Assert.assertEquals("Medium (1 cup)", foodIntakePage.getDefaultServingSize());	}

	@Then("User should see calculator icon in calorie")
	public void user_should_see_calculator_icon_in_calorie() {
		List<String> expected = Arrays.asList("Small (1/2 cup)", "Medium (1 cup)", "Large (2 cup)", "Custom");
        Assert.assertTrue(foodIntakePage.getAllServingSizeOptions().containsAll(expected));
	}

	@Then("User should see input field for calorie")
	public void user_should_see_input_field_for_calorie() {
		Assert.assertTrue(foodIntakePage.isCalorieIconVisible());
	}

	@Then("User should see text {string} as placeholder in calorie field")
	public void user_should_see_text_as_placeholder_in_calorie_field(String string) {
		Assert.assertTrue(foodIntakePage.isCalorieInputVisible());
	}

	@Then("User should see helper text {string}")
	public void user_should_see_helper_text(String string) {
        Assert.assertTrue(foodIntakePage.isCalorieHelperVisible());
	}

	@Then("User should see date picker")
	public void user_should_see_date_picker() {
        Assert.assertTrue(foodIntakePage.isDatePickerVisible());
	}

	@Then("User should see {string} displayed in the Date field")
	public void user_should_see_displayed_in_the_date_field(String expectedDate) {
		 Assert.assertTrue(foodIntakePage.getSelectedDateText().contains(expectedDate));
	}

	@Then("User should see input block for notes")
	public void user_should_see_input_block_for_notes() {
		Assert.assertTrue(foodIntakePage.isNotesInputVisible());
	}

	@Then("User should see text {string} in place holder")
	public void user_should_see_text_in_place_holder(String string) {
		 Assert.assertEquals("Add any additional info…", foodIntakePage.getNotesPlaceholder());
	}

	@Then("User should see save food entry button")
	public void user_should_see_save_food_entry_button() {
		  Assert.assertTrue(foodIntakePage.isSaveButtonVisible());
	}
//----Functional testing for Food Intake---
	@Given("User Food Intake in tracker")
	public void user_food_intake_in_tracker() {
		LoggerLoad.info("User is in Food intake Tracker");
	}
	   @Given("User is in the Breakfast section of the Food Intake Tracker")
	    public void user_Is_In_Breakfast_Tab() {
	        Assert.assertTrue(foodIntakePage.getBreakfastTab().getAttribute("class").contains("selected"));
	    }
	
	    @When("User clicks save food entry after entering valid")
	    public void user_Enters_Valid_And_Clicks_Save() {
	        foodIntakePage.enterFoodName("Oats");
	        foodIntakePage.selectServingSize("Medium (1 cup)");
	        foodIntakePage.enterCalories("150");
	        foodIntakePage.clickSave();
	    }
	 @Then("User should see \"Food Entry is recorded\"")
	public void user_Should_See_Food_Entry_Saved_Message() {
	        Assert.assertTrue(foodIntakePage.isSuccessMessageVisible());
	    }

	@When("User clicks save food entry button after entering invalid value in food name")
	public void user_clicks_save_food_entry_button_after_entering_invalid_value_in_food_name() {
		   foodIntakePage.enterFoodName("@#$$$");
	        foodIntakePage.clickSave();
	}

	@Then("User should see alert with message {string}")
	public void user_should_see_alert_with_message(String string) {
		Assert.assertTrue(foodIntakePage.isErrorsaveFailedVisible());
	}

	@When("User selects custom option in serving size")
	public void user_selects_custom_option_in_serving_size() {
		   foodIntakePage.selectServingSize("Custom");
	}

	@Then("User should see new input field added below the serving field")
	public void user_should_see_new_input_field_added_below_the_serving_field() {
		Assert.assertTrue(foodIntakePage.isCustomServingInputVisible());
	}

	@When("User enters invalid value in food name")
	public void user_enters_invalid_value_in_food_name() {
		foodIntakePage.enterFoodName("!@#$");
        foodIntakePage.clickCalorieIcon();
	}

	@Then("User should see error message {string}")
	public void user_should_see_error_message(String string) {
		Assert.assertTrue(foodIntakePage.isErrorForFoodNameVisible());
	}

	@When("User enters valid food name")
	public void user_enters_valid_food_name() {
		foodIntakePage.enterFoodName("Grilled Chicken");
        foodIntakePage.clickCalorieIcon();
	}

	@Then("User should see calorie value for the food name calculated automatically")
	public void user_should_see_calorie_value_for_the_food_name_calculated_automatically() {
		  Assert.assertFalse(foodIntakePage.getCalorieInputValue().isEmpty());
	}

	@Then("User should see helper text after automatic calorie calculation")
	public void user_should_see_helper_text_after_automatic_calorie_calculation() {
		Assert.assertTrue(foodIntakePage.isCalorieAutoHelperVisible());
	}

	@Then("User should see {string} as helper text in calorie field")
	public void user_should_see_as_helper_text_in_calorie_field(String string) {
		Assert.assertTrue(foodIntakePage.isCalorieAutoHelperVisible());
	}

	@When("User changes serving size from the default value after entering the food name")
	public void user_changes_serving_size_from_the_default_value_after_entering_the_food_name() {
		 foodIntakePage.enterFoodName("Rice");
	        foodIntakePage.clickCalorieIcon();
	        String oldCalorie = foodIntakePage.getCalorieInputValue();
	        foodIntakePage.selectServingSize("Large (2 cup)");
	        String newCalorie = foodIntakePage.getCalorieInputValue();
	        Assert.assertNotEquals(oldCalorie, newCalorie);
	        }
	
	
	@When("User edit calorie value after automatic calorie calculation")
	public void user_edit_calorie_value_after_automatic_calorie_calculation() {
		foodIntakePage.enterCalories("300");
	}

	@Then("User should see edited value in automatic calorie value")
	public void user_should_see_edited_value_in_automatic_calorie_value() {
		 Assert.assertEquals("300", foodIntakePage.getCalorieInputValue());
	}

	@When("User clicks the Save Food Entry button after leaving the Food Name field empty")
	public void user_clicks_the_save_food_entry_button_after_leaving_the_food_name_field_empty() {
		foodIntakePage.enterFoodName("");
        foodIntakePage.clickSave();
	}

	@Then("User should see an error message indicating that the Food Name is required")
	public void user_should_see_an_error_message_indicating_that_the_food_name_is_required() {
		Assert.assertTrue(foodIntakePage.isErrorForFoodNameVisible());
		}

	@When("User clicks on date field")
	public void user_clicks_on_date_field() {
		 foodIntakePage.openDatePicker();
	}

	@Then("User should see date calendar icon")
	public void user_should_see_date_calendar() {
		Assert.assertTrue(TrackGlucosePage.isTodayDateHighlighted());
	}

	@Then("User should see today's date highlighted")
	public void user_should_see_today_s_date_highlighted() {
		Assert.assertTrue(TrackGlucosePage.isTodayDateHighlighted());
	}

	@Then("User should see previous button in datepicker")
	public void user_should_see_previous_button_in_datepicker() {
		Assert.assertTrue(TrackGlucosePage.isPrevDateButtonVisible());
	}

	@Then("User should see next button in datepicker")
	public void user_should_see_next_button_in_date() {
		Assert.assertTrue(TrackGlucosePage.isNextDateButtonVisible());
	}
	
	@When("User selects previous date in the calendar after clicking date field")
	public void user_selects_previous_date_in_the_calendar_after_clicking_date_field() {
		foodIntakePage.selectPreviousDate();
	}

	@Then("User should see selected date in the field")
	public void user_should_see_selected_date_in_the_field(String expectedDate) {
		Assert.assertTrue(foodIntakePage.getSelectedDateText().contains(expectedDate));
	}

	@When("User clicks save food entry after more than {int} words in notes")
	public void user_clicks_save_food_entry_after_more_than_words_in_notes(Integer int1) {
		 String longNote = "word ".repeat(260);
	        foodIntakePage.enterNotes(longNote);
	        foodIntakePage.clickSave();
	}

	@Then("User should see error message in alert")
	public void user_should_see_error_message_in_alert() {
		Assert.assertTrue(foodIntakePage.isNotesLimitErrorVisible());
	}

}
