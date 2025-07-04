package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pageFactory.ExerciseModuleOn_POM;
import pageFactory.Login_POM;
import utilities.ConfigReader;
import  utilities.CommonMethods;

public class ExerciseModuleOn_Steps {

	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	CommonMethods common = new CommonMethods();
	Login_POM login = new Login_POM();
	ExerciseModuleOn_POM exercisePage = new ExerciseModuleOn_POM();
	WebDriver webDriver = DriverFactory.getDriver();

	// TODO Auto-generated method stub
	@Given("User is Logged into the app")
	public void user_is_logged_into_the_app() {
		// Assuming a method to login already inside DriverFactory or another helper
		// For simplicity, if no login required, this step may be empty or check
		// homepage presence

		login.performLogin();
	}

	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
//		WebElement currentStatus = exercisePage.getCurrentStatusHeader();
//		common.waitForElementVisibilityOf(currentStatus);
	
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

		// Wait for correct URL
		wait.until(ExpectedConditions.urlToBe(ConfigReader.homeUrl()));
		String expectedHomeUrl = ConfigReader.homeUrl();
		String actualUrl = webDriver.getCurrentUrl();
		Assert.assertEquals("User is not on the expected homepage", expectedHomeUrl, actualUrl);
		}

	@When("User clicks the {string} option from the side panel")
	public void user_clicks_the_option_from_the_side_panel(String string) {
		if (string.equalsIgnoreCase("Exercise")) 
		{
			WebElement exerciseButton = exercisePage.getExerciseTabElement();
	        common.waitForElementTobeClick(exerciseButton);
			exercisePage.clickExerciseTab();
		}
	}

	@Then("{string} button is displayed on the right")
	public void button_is_displayed_on_the_right(String string) {
		Assert.assertTrue(exercisePage.isViewFullScheduleDisplayed());
	}

	@When("User clicks the {string} Schedulebutton")
	public void user_clicks_the_Schedule_button(String string) {
		exercisePage.clickViewFullScheduleButton();
	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to_page(String string) {
		Assert.assertTrue(exercisePage.isPageTitleDisplayed());
	}

	@Then("{string} tab is visible")
	public void tab_is_visible(String tabName) {
		switch (tabName) {
		case "Warm up":
			Assert.assertTrue(exercisePage.isWarmUpSectionDisplayed());
			break;
		case "Main Workout":
			Assert.assertTrue(exercisePage.isMainWorkoutSectionDisplayed());
			break;
		case "Cool Down":
			Assert.assertTrue(exercisePage.isCoolDownSectionDisplayed());
			break;
		default:
			throw new IllegalArgumentException("unknown tab:" + tabName);
		}

	}

	@Then("Exercise name is displayed under {string} tab")
	public void exercise_name_is_displayed_under_tab(String tabName) {
		String name = exercisePage.getExerciseName(tabName);
		Assert.assertNotNull("Exercise name is missing under " + tabName + " tab", name);
		Assert.assertFalse(name.isEmpty());

	}

	@Then("Description is shown below the Exercise name under {string}")
	public void description_is_shown_below_the_exercise_name_under(String tabName) {
		exercisePage.clickTab(tabName);
		Assert.assertTrue("Description not displayed under " + tabName, exercisePage.isDescriptionDisplayed());
	}

	@Then("Duration is displayed under {string} tab")
	public void duration_is_displayed_under_tab(String tabName) {
		exercisePage.clickTab(tabName);
		Assert.assertTrue("Duration not displayed under " + tabName, exercisePage.isDurationDisplayed());
	}

	@Then("Calories are displayed under {string} tab")
	public void calories_are_displayed_under_tab(String tabName) {
		exercisePage.clickTab(tabName);
		Assert.assertTrue("Calories not displayed under " + tabName, exercisePage.isCaloriesDisplayed());
	}

	@Then("Intensity level is displayed under {string} tab")
	public void intensity_level_is_displayed_under_tab(String tabName) {
		exercisePage.clickTab(tabName);
		Assert.assertTrue("Intensity not displayed under " + tabName, exercisePage.isIntensityDisplayed());
	}

	@Then("{string} button is displayed for all three sections")
	public void button_is_displayed_for_all_three_sections(String buttonText) {
		Assert.assertTrue("Button '" + buttonText + "' not displayed for Warm Up tab", exercisePage.isButtonVisibleForTab("Warm Up", buttonText));
		Assert.assertTrue("Button '" + buttonText + "' not displayed for Main Workout tab", exercisePage.isButtonVisibleForTab("Main Workout", buttonText));
		Assert.assertTrue("Button '" + buttonText + "' not displayed for Cool Down tab", exercisePage.isButtonVisibleForTab("Cool Down", buttonText));
	}

	@Then("Success dialog is shown")
	public void success_dialog_is_shown() {
		Assert.assertTrue(exercisePage.isSuccessDialogDisplayed());
	}

	@Then("Button changes to {string}")
	public void button_changes_to(String string) {
		Assert.assertTrue(exercisePage.isViewFullScheduleDisplayed());
	}

	@Then("Undo option is visible")
	public void undo_option_is_visible() {
		Assert.assertTrue(exercisePage.isUndoButtonDisplayed());
	}
}
