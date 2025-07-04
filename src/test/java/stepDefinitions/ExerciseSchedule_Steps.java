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
import pageFactory.ExerciseSchedule_POM;
import pageFactory.Login_POM;
import utilities.ConfigReader;
import  utilities.CommonMethods;


public class ExerciseSchedule_Steps {
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	Login_POM login = new Login_POM();
	ExerciseModuleOn_POM exercisePage = new ExerciseModuleOn_POM();
	ExerciseSchedule_POM schedulePage = new ExerciseSchedule_POM();
	WebDriver webDriver = DriverFactory.getDriver();
	  CommonMethods common = new CommonMethods();
	  
	    
		@Given("User is in home page after logging")
	    public void user_is_in_home_page_after_logging() {
	    	login.performLogin();
	    	 WebElement homePageTitle = exercisePage.getCurrentStatusHeader(); 
	    	 common.waitForElementVisibilityOf(homePageTitle);
	    	System.out.println("Current page title: " + webDriver.getTitle());
	    	 Assert.assertTrue("Home page title not displayed", homePageTitle.isDisplayed());
	    }

	    @Given("User is in the Exercise section")
	    public void user_is_in_the_exercise_section() {
	    	//webDriver.get("https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/exercise-schedule");
	    	WebElement exerciseButton = exercisePage.getExerciseTabElement();
	        common.waitForElementTobeClick(exerciseButton);
			exercisePage.clickExerciseTab();
	    	schedulePage.getExerciseURL();
	        Assert.assertTrue("User is not in Exercise section", schedulePage.isTitleDisplayed());
	    }

	    @When("User clicks Undo after marking Exercise as completed")
	    public void user_clicks_undo_after_marking_exercise_as_completed() {
	        schedulePage.clickUndo();
	    }

	    @Then("Button changes back to {string}")
	    public void button_changes_back_to(String expectedText) {
	        Assert.assertTrue("Expected button not visible", schedulePage.isMarkAsCompletedButtonVisible());
	    }

	    @When("User clicks {string}")
	    public void user_clicks(String buttonText) {
	        if (buttonText.equalsIgnoreCase("view full schedule")) {
	            schedulePage.clickViewFullSchedule();
	        }
	    }

	    @Then("User should redirect to Exercise schedule")
	    public void user_should_redirect_to_exercise_schedule() {
	    	String expPageTitle = "exercise-schedule";
			String actPageTitle = schedulePage.getExerciseURL();
			Assert.assertEquals(expPageTitle, actPageTitle);
	         }

	    @Then("User should see titleText {string}")
	    public void user_should_see_title_text(String titleText) {
	        Assert.assertTrue("Schedule title not visible", schedulePage.isTitleDisplayed());
	    }

	    @Then("User should see {string} button in Today's Exercise schedule page")
	    public void user_should_see_button_in_today_s_exercise_schedule_page(String buttonText) {
	        Assert.assertTrue("Back to Home button not visible", schedulePage.isBackToHomeBtnDisplayed());
	    }

	    @Then("{string} section should be visible")
	    public void section_should_be_visible(String sectionName) {
	        Assert.assertTrue(sectionName + " section not visible", schedulePage.isSectionVisible(sectionName));
	    }

	    @Then("Exercise name should be visible")
	    public void exercise_name_should_be_visible() {
	        Assert.assertTrue("Exercise names not visible", schedulePage.areExerciseNamesVisible());
	    }

	    @Then("Exercise description should be visible")
	    public void exercise_description_should_be_visible() {
	        Assert.assertTrue("Exercise descriptions not visible", schedulePage.areDescriptionsVisible());
	    }

	    @Then("Exercise durations should be visible")
	    public void exercise_durations_should_be_visible() {
	        Assert.assertTrue("Exercise durations not visible", schedulePage.areDurationsVisible());
	    }

	    @Then("Exercise calories should be visible")
	    public void exercise_calories_should_be_visible() {
	        Assert.assertTrue("Exercise calories not visible", schedulePage.areCaloriesVisible());
	    }

	    @Then("Exercise intensity should be visible")
	    public void exercise_intensity_should_be_visible() {
	        Assert.assertTrue("Exercise intensity not visible", schedulePage.areIntensityVisible());
	    }

	    @Then("Exercise intensity should low\\/medium\\/hard")
	    public void exercise_intensity_should_low_medium_hard() {
	        Assert.assertTrue("Invalid intensity values", schedulePage.isValidIntensityValues());
	    }

	    @Then("total duration should be displayed")
	    public void total_duration_should_be_displayed() {
	        Assert.assertTrue("Total duration not displayed", schedulePage.isTotalDurationDisplayed());
	    }

	    @Then("total duration should equal the sum of all individual durations")
	    public void total_duration_should_equal_the_sum_of_all_individual_durations() {
	        int expected = schedulePage.getSumOfIndividualDurations();
	        int actual = schedulePage.getTotalDuration();
	        Assert.assertEquals("Total duration mismatch", expected, actual);
	    }

	    @Then("total calories should equal the sum of all individual calories")
	    public void total_calories_should_equal_the_sum_of_all_individual_calories() {
	        int expected = schedulePage.getSumOfIndividualCalories();
	        int actual = schedulePage.getTotalCalories();
	        Assert.assertEquals("Total calories mismatch", expected, actual);
	    }
}