package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.CommonHomePage_POM;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class CommonHomePage_Step {

	CommonHomePage_POM commonHomePage = new CommonHomePage_POM();
	
	@Given("User is in password auth page")
	public void user_is_in_password_auth_page() {
		String nameApp = commonHomePage.getAppnameText();
		assertEquals(nameApp, "SweetBalance", "App name before sign in is not correct");	    
	}

	@When("User clicks sign in after entering password")
	public void user_clicks_sign_in_after_entering_password() {
		commonHomePage.clickLoginBttn();
		commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("email"));
		commonHomePage.clickContinueWithEmail();
		commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("password"));
		commonHomePage.clickSignInbttn();
	}

	@Then("User should see SweetBalance text on the left side of the page")
	public void user_should_see_sweet_balance_text_on_the_left_side_of_the_page() {
		String nameApp = commonHomePage.getAppnameTextAfterSignIn();
	    assertEquals(nameApp, "SweetBalance", "App name after sign in is not correct");
	}

	@Then("User should see name displayed at the top-right corner of the home page")
	public void user_should_see_name_displayed_at_the_top_right_corner_of_the_home_page() {
	    String username = commonHomePage.getUsernameTextAfterSignIn();
	    String expectedUsername = ConfigReader.getProperty("username");
	    assertEquals(username, expectedUsername ,"Correct username is not displayed");
	}

	@Then("User should see Logout link in the top-right corner")
	public void user_should_see_logout_link_in_the_top_right_corner() {
	    
		assertTrue(commonHomePage.isLogoutDisplayed(), "Logout button is not displayed");
	}

	@Then("User should see top navigation bar on the page")
	public void user_should_see_top_navigation_bar_on_the_page() {
		assertTrue(commonHomePage.isTopNavBarDisplayed(), "Top navigation bar is not displayed");
	    
	}
	@Then("User should see Home tab in the top navigation bar")
	public void user_should_see_home_tab_in_the_top_navigation_bar() {
		assertTrue(commonHomePage.isHomeDisplayed(), "Home button is not displayed");
	}

	@Then("User should see Dashboard tab in the top navigation bar")
	public void user_should_see_dashboard_tab_in_the_top_navigation_bar() {
		assertTrue(commonHomePage.isDashboardDisplayed());
	}

	@Then("User should see Education tab in the top navigation bar")
	public void user_should_see_education_tab_in_the_top_navigation_bar() {
		assertTrue(commonHomePage.isEducationDisplayed());
	}
	
	@Then("User should see Current Status section heading on the home page")
	public void user_should_see_current_status_section_heading_on_the_home_page() {
		assertTrue(commonHomePage.isCurrentStatusDisplayed());
	}

	@Then("User should see Last updated label below Current Status")
	public void user_should_see_last_updated_label_below_current_status() {
		assertTrue(commonHomePage.isLastUpdatedDisplayed());
	}

	@Then("User should see timestamp displayed next to the Last updated label")
	public void user_should_see_timestamp_displayed_next_to_the_last_updated_label() {
		String lastUpdatedText = commonHomePage.getlastUpdatedText();
		assertTrue(lastUpdatedText.toLowerCase().contains("last updated"), "Label 'Last updated' is not present.");
		assertTrue(lastUpdatedText.matches("(?i)^Last updated:.*\\d.*$"), "Timestamp is not displayed after 'Last updated:'");
	}
	
	@Then("User should see last updated timestamp in {int}-hour format as hh:mm:ss or relative format like {string} or {string}")
	public void user_should_see_last_updated_timestamp_in_hour_format_as_hh_mm_ss_or_relative_format_like_or(Integer int1, String string, String string2) {
	  
	}

	@Then("User should see {int}-hour clock indicator with AM\\/PM")
	public void user_should_see_hour_clock_indicator_with_am_pm(Integer int1) {
		String lastUpdatedText = commonHomePage.getlastUpdatedText();
		assertTrue(lastUpdatedText.toUpperCase().contains("AM") || lastUpdatedText.toUpperCase().contains("PM"),
	               "12-hour format indicator (AM/PM) is missing in the timestamp.");
	}

	@Then("User should see Latest HbA1C label")
	public void user_should_see_latest_hb_a1c_label() {
		assertTrue(commonHomePage.islatestHbA1cDisplayed());
	}

	@Then("User should see BMI label")
	public void user_should_see_bmi_label() {
		assertTrue(commonHomePage.isBMIdisplayed());
	}
	@Then("User should see Average Blood Sugar label")
	public void user_should_see_average_blood_sugar_label() {
		assertTrue(commonHomePage.isbloodSugarLeveldisplayed());
	}

	@Then("User should see Latest HbA1C value")
	public void user_should_see_latest_hb_a1c_value() {
	   assertNotNull(commonHomePage.getHbA1CValueText(), "HbA1C should not be null");
	}

	@Then("User should see BMI value")
	public void user_should_see_bmi_value() {
		assertNotNull(commonHomePage.getbmiValueText(), "BMI should not be null");
	}

	@Then("User should see Average Blood Sugar value")
	public void user_should_see_average_blood_sugar_value() {
		assertNotNull(commonHomePage.getbloodSugarValueText(), "Blood sugar should not be null");
	}
	@Then("User should see {string} as the condition text")
	public void user_should_see_as_the_condition_text(String string) {
		double range = commonHomePage.getHbA1CRangeText();
		String value = commonHomePage.getHbA1CValueText();
		if(range < 5.7) assertEquals(value, "Normal");
		if(range > 5.7 && range < 6.4)  assertEquals(value, "Pre-Diabetic");
		if(range > 6.5) assertEquals(value, "Diabetic");
	}

	@Then("User should see {string} as the BMI category")
	public void user_should_see_as_the_bmi_category(String string) {
		float range = commonHomePage.getbmiRangeText();
		String value = commonHomePage.getbmiValueText();
		if(range < 18.5) assertEquals(value, "Underweight");
		if(range > 18.5 && range < 24.9) assertEquals(value, "Normal");
		if(range > 25.0 && range < 29.9) assertEquals(value, "Overweight");
		if(range > 30.0) assertEquals(value, "Obese");
	}

	@Then("User should see range of Average Blood Sugar")
	public void user_should_see_range_of_average_blood_sugar() {
		assertNotNull(commonHomePage.getbloodSugarRangeText());
	}
	
	@Then("User should see {string} title")
	public void user_should_see_title(String string) {
		assertTrue(commonHomePage.istodayMealPlandisplayed());
	}

	@Then("User should see tabs: Breakfast, Lunch, Dinner, Snacks")
	public void user_should_see_tabs_breakfast_lunch_dinner_snacks() {
		for(WebElement mealItem : commonHomePage.getNavBarMealItems()) {
			assertTrue(mealItem.isDisplayed(), "Meal item " +mealItem+ "is not displayed");
		}
	}
	@Then("{string} tab should be selected by default")
	public void tab_should_be_selected_by_default(String string) {
		assertEquals(commonHomePage.breakfastColour(), "rgba(139, 92, 246, 1)"); 
	}
	@Then("User should see sidebar tab container within the flex layout")
	public void user_should_see_sidebar_tab_container_within_the_flex_layout() {
		assertTrue(commonHomePage.isleftBarContainerdisplayed());
	}

	@Then("User should see {string} label in the sidebar section")
	public void user_should_see_label_in_the_sidebar_section(String expectedLabel) {
		
		String actualLabel;
		switch(expectedLabel.toLowerCase()) {
			case "meal plan":
				actualLabel = commonHomePage.getmealPlanText();
				break;
			case "exercise":
				actualLabel = commonHomePage.getexcerciseText();
				break;
			default:
                throw new IllegalArgumentException("Unexpected label: " + expectedLabel);
		}
		LoggerLoad.info("Validate label: " +actualLabel);
		assertEquals(actualLabel.trim(), expectedLabel.trim(), "\"" +expectedLabel+ "\" Label is not visible");
	}
	@Then("User should see utensil icon \\(crossed fork and knife) in the Meal Plan tab")
	public void user_should_see_utensil_icon_crossed_fork_and_knife_in_the_meal_plan_tab() {
		assertTrue(commonHomePage.ismealSymbolDisplayed());
	}

	@Then("User should see dumbbell icon in the Exercise tab")
	public void user_should_see_dumbbell_icon_in_the_exercise_tab() {
		assertTrue(commonHomePage.isexcerciseSymbolDisplayed());
	}
	@Then("User should see {string} button in the Meal Plan section")
	public void user_should_see_button_in_the_meal_plan_section(String expectedLabel) {
		String actualLabel = commonHomePage.getviewfullMealPlanText();
		LoggerLoad.info("Validate label: " +actualLabel);
		assertEquals(actualLabel.trim(), expectedLabel.trim(), "\"" +expectedLabel+ "\" Label is not visible");
	}
	@Given("User is logged into the app")
	public void user_is_logged_into_the_app() {
		commonHomePage.clickLoginBttn();
		commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("email"));
		commonHomePage.clickContinueWithEmail();
		commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("password"));
		commonHomePage.clickSignInbttn();	    
	}

	@Given("User is in home page")
	public void user_is_in_home_page() throws InterruptedException {
		Thread.sleep(1000);
		String actualPageURL = commonHomePage.getCurrentUrl();
		assertEquals(actualPageURL, "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/", "User is not in home page");	    	    
	}

	@When("User clicks on the {string} section")
	public void user_clicks_on_the_section(String label) {
	    switch(label.toLowerCase()) {
	    case "breakfast":
	    	commonHomePage.clickbreakfast();
	    	break;
	    case "lunch":
	    	commonHomePage.clicklunch();
	    	break;
	    case "dinner":
	    	commonHomePage.clickdinner();
	    	break;
	    case "snacks":
	    	commonHomePage.clicksnacks();
	    	break;
	    default:
	    	throw new IllegalArgumentException("Unexpected label: " + label);
	    }	    
	}

	@Then("Breakfast details become visible")
	public void breakfast_details_become_visible() {
	    assertTrue(commonHomePage.isbreakfastDetailsDisplayed());
	    
	}

	@Then("Lunch details become visible")
	public void lunch_details_become_visible() {
		assertTrue(commonHomePage.islunchDetailsDisplayed());
	    
	}

	@Then("Dinner details become visible")
	public void dinner_details_become_visible() {
		assertTrue(commonHomePage.isdinnerDetailsDisplayed());
	    
	}

	@Then("Snacks details become visible")
	public void snacks_details_become_visible() {
		assertTrue(commonHomePage.issnacksDetailsDisplayed());
	    
	}
	@When("User clicks meal section")
	public void user_clicks_meal_section() {
	    commonHomePage.clickmealPlanBttn();
	    
	}

	@Then("User should see dish title")
	public void user_should_see_dish_title() {
		assertTrue(commonHomePage.istitlePremealDisplayed());
	    
	}

	@Then("User should see description for the dish")
	public void user_should_see_description_for_the_dish() {
		assertTrue(commonHomePage.isdetailsPreMealDisplayed());
	    
	}

	@Then("User should see the pre-meal item name")
	public void user_should_see_the_pre_meal_item_name() {
		assertTrue(commonHomePage.isitemPreMealDisplayed());
	    
	}

	@Then("User should see the pre-meal calorie value")
	public void user_should_see_the_pre_meal_calorie_value() {
		assertTrue(commonHomePage.iscaloriePreMealDisplayed());
	    
	}

	@When("User clicks breakfast in meal section")
	public void user_clicks_breakfast_in_meal_section() {
		commonHomePage.clickbreakfast();
	}
	@Then("User should see indicator {string} for breakfast pre-meal")
	public void user_should_see_indicator_for_breakfast_pre_meal(String string) {
		List<String> timeTexts = commonHomePage.retrivetimeElementsTexts();
		for(String timeText : timeTexts) {
			LoggerLoad.info("Time text of breakfast element is: " +timeText);
			assertTrue(timeText.contains("AM"), "Text does not contain 'AM': " +timeText);
		}
	    
	}
	@When("User clicks lunch in meal section")
	public void user_clicks_lunch_in_meal_section() {
		commonHomePage.clicklunch();
	}
	@Then("User should see indicator {string} for lunch pre-meal")
	public void user_should_see_indicator_for_lunch_pre_meal(String string) {
		
		List<String> timeTexts = commonHomePage.retrivetimeElementsTexts();
		for(String timeText : timeTexts) {
			LoggerLoad.info("Time text of lunch element is: " +timeText);
			assertTrue(timeText.contains("PM"), "Text does not contain 'PM': " +timeText);
		}
	}
	@When("User clicks dinner in meal section")
	public void user_clicks_dinner_in_meal_section() {
		commonHomePage.clickdinner();
	}
	@Then("User should see indicator {string} for dinner pre-meal")
	public void user_should_see_indicator_for_dinner_pre_meal(String string) {
		
		List<String> timeTexts = commonHomePage.retrivetimeElementsTexts();
		for(String timeText : timeTexts) {
			LoggerLoad.info("Time text of dinner element is: " +timeText);
			assertTrue(timeText.contains("PM"), "Text does not contain 'PM': " +timeText);
		}
	}

	@Then("User should see {string} based time in pre-meal \\(eg : {int}:{int})")
	public void user_should_see_based_time_in_pre_meal_eg(String string, Integer int1, Integer int2) {
	    
	    
	}

	@Then("User should see {int} in pre-breakfast")
	public void user_should_see_in_pre_breakfast(Integer int1) {
		List<String> timeTexts = commonHomePage.retrivetimeElementsTexts();
		for(String timeText : timeTexts) {
			LoggerLoad.info("Time text of breakfast element is: " +timeText);
			assertTrue(timeText.contains("7"), "Text does not contain 7 time: " +timeText);
		}    
	}

	@Then("User should see {int} in pre-lunch")
	public void user_should_see_in_pre_lunch(Integer int1) {
		List<String> timeTexts = commonHomePage.retrivetimeElementsTexts();
		for(String timeText : timeTexts) {
			LoggerLoad.info("Time text of lunch element is: " +timeText);
			assertTrue(timeText.contains("12"), "Text does not contain 7 time: " +timeText);
		}    	    
	}
	@Then("User should see {int} in pre-dinner")
	public void user_should_see_in_pre_dinner(Integer int1) {
		List<String> timeTexts = commonHomePage.retrivetimeElementsTexts();
		for(String timeText : timeTexts) {
			LoggerLoad.info("Time text of dinner element is: " +timeText);
			assertTrue(timeText.contains("6"), "Text does not contain 7 time: " +timeText);
		}    
	}
	@Then("User should see green color for Carbs")
	public void user_should_see_green_color_for_carbs() {
		String carbColour = commonHomePage.getCarbsBackgroundcolour();
	    LoggerLoad.info("Carb colour: " +carbColour);
	    assertTrue(carbColour.contains("209, 250, 229, 1"), "Carb is not green colour");
	}

	@Then("User should see purple color for Fat")
	public void user_should_see_purple_color_for_fat() {
		String fatColour = commonHomePage.getfatBackgroundcolour();
	    LoggerLoad.info("Fat colour: " +fatColour);
	    assertTrue(fatColour.contains("237, 233, 254, 1"), "Fat is not green colour");
	}

	@Then("User should see pink color for Protein")
	public void user_should_see_pink_color_for_protein() {
		String proteinColour = commonHomePage.getproteinBackgroundcolour();
	    LoggerLoad.info("protein colour: " +proteinColour);
	    assertTrue(proteinColour.contains("252, 231, 243, 1"), "Protein is not green colour");
	}

	@Then("It should display the unit as {string}")
	public void it_should_display_the_unit_as(String unit) {
		List<String> caloriesWeight = commonHomePage.getcaloriesWeight();
	    for(String calorieWeight : caloriesWeight ) {
	    	LoggerLoad.info("Carbs weight: " +calorieWeight);
	    	assertTrue(calorieWeight.contains(unit), "Calorie does not contain valid unit");
	    }
	}

	@Then("User should see text {string} after the calorie value in pre meal")
	public void user_should_see_text_after_the_calorie_value_in_pre_meal(String text) {
		assertTrue(commonHomePage.getcaloriesText().contains(text));	    
	}
}
