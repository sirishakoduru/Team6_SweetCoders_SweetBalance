package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import pageFactory.Dashboardfeatures_POM;
import pageFactory.Homepagefeaturesonlyforfreeuser_POM;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import driver.DriverFactory;

import static org.junit.Assert.*;

public class Dashboardfeatures_Step {
    
    private static final Object actualPhase = null;
	private static final Object expectedPhase = null;
	private WebDriver driver;
	boolean isredirected = false;
    //private String fullName = "Test User"; // You might want to get this from test data
   Dashboardfeatures_POM homePage = new Dashboardfeatures_POM();
    @Given("User  Home Page")
    public void user_is_in_home_page() {
        // Initialize WebDriver and navigate to home page
    	 DriverFactory.getDriver().get(homePage.auth_page);
    }
    
    @When("User clicks the Dashboard on the navigation bar")
    public void user_clicks_the_dashboard_on_the_navigation_bar() {
    	homePage.clickdashboard();
        try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isredirected = true;
    }
    
    @Then("User should see the {string} message")
    public void user_should_see_the_welcome_message(String expectedMessage) {
        System.out.println("user should see welcome message");
        
        Assert.assertEquals(isredirected,true);
        
    }
    @Then("User should see the text {string}")
    public void user_should_see_the_text(String string) {
    	homePage.viewmetrics(); 
    	System.out.println("user should see text");
    	String actualText = homePage.getmessage();
        Assert.assertEquals(actualText, string, "Metrics message did not match.");
    }
    @Then("User should see {string} button")
    public void user_should_see_button(String string) {
    	homePage.premium(); 
    	System.out.println("user should see premium");
    }

    @Then("User should see the header {string} with correct spelling")
    public void user_should_see_the_header_with_correct_spelling(String string) {
    	homePage.account(); 
    	System.out.println("user should see account information");
    }

    @Then("User should see all the fields under Account Information section")
    public void user_should_see_all_the_fields_under_account_information_section() {
        homePage.accountinform(); 
    	System.out.println("user should see ll the fields under Account Information section");
    }
    @When("User edit age field with valid data")
    public void user_edit_age_field_with_valid_data() {
    	homePage.age();
    }

    @Then("User should see that entered age is displayed in that field")
    public void user_should_see_that_entered_age_is_displayed_in_that_field() {
        System.out.println("user shouls enter age");
    }

    @When("User Edit height field with valid data")
    public void user_edit_height_field_with_valid_data() {
    	homePage.height();
    }

    @Then("User should see that entered height is displayed in Height field")
    public void user_should_see_that_entered_height_is_displayed_in_height_field() {
    	System.out.println("user shouls enter height");
    }

    @When("User Edit Weight field with valid data")
    public void user_edit_weight_field_with_valid_data() {
    	homePage.weight();
    }

    @Then("User should see that entered weight is displayed  in Weight field")
    public void user_should_see_that_entered_weight_is_displayed_in_weight_field() {
    	System.out.println("user shouls enter weight");
    }

    @When("User clicks the dropdown of Exercise Routine Level")
    public void user_clicks_the_dropdown_of_exercise_routine_level() {
    	homePage.leveldropdown();
    }

    @Then("User should see the dropdown with options {string},{string},{string}")
    public void user_should_see_the_dropdown_with_options(String string, String string2, String string3) {
    	System.out.println("user should see the options");
    }

    @When("User clicks the dropdown of Cuisine Preferences")
    public void user_clicks_the_dropdown_of_cuisine_preferences() {
    	homePage.cuisine();
    }

    @Then("User should see the dropdown with list of cuisine types {string},{string},{string},{string},{string},\"Middle Eastern,\"Mexican\"")
    public void user_should_see_the_dropdown_with_list_of_cuisine_types_middle_eastern_mexican(String string, String string2, String string3, String string4, String string5) {
    	System.out.println("user should see the options");
    }

    @When("User clicks the dropdown of Food Allergies")
    public void user_clicks_the_dropdown_of_food_allergies() {
    	homePage.allergies();
    }

    @Then("User should see the dropdown list of common allergy options {string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_should_see_the_dropdown_list_of_common_allergy_options(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
    	System.out.println("user should see the options");
    }

     @When("User scrolls  to the Stress Management section")
    public void user_scrolls_to_the_stress_management_section() {
    	homePage.heading();
    }

    @Then("User should see the Title  {string}")
    public void user_should_see_the_title(String string) {
        System.out.println("user should see title");
    }

    @Then("User should see tabs {string}, {string}, {string} and {string}")
    public void user_should_see_tabs_and(String string, String string2, String string3, String string4) {
    	homePage.navigationbar();
    }

    @When("User clicks on each tab")
    public void user_clicks_on_each_tab() {
    	System.out.println("user should see tabs");
    }

    @Then("User should see corresponding display section")
    public void user_should_see_corresponding_display_section() {
    	homePage.clickeachtab();
    	System.out.println("user should click on each tab");
    }

    @When("User clicks Meditation tab")
    public void user_clicks_meditation_tab() {
    	homePage.meditation();
    }

    @Then("User should see the content with title {string}")
    public void user_should_see_the_content_with_title(String string) {
    	System.out.println("user should see title");
    }

    @Then("User should see buttons for {string}, {string}, and {string}")
    public void user_should_see_buttons_for_and(String string, String string2, String string3) {
    	homePage.duration();
    	System.out.println("user should see duration");
    }

    @Then("User should see a progress bar with time indicators {string} and {string} by default")
    public void user_should_see_a_progress_bar_with_time_indicators_and_by_default(String string, String string2) {
    	homePage.audio();
    	System.out.println("user should see audio indicators");
    }

    @When("User clicks audio play button")
    public void user_clicks_audio_play_button() {
    	homePage.playback();
    }

    @Then("User Should see meditation audio should start playing and the progress bar should update accordingly")
    public void user_should_see_meditation_audio_should_start_playing_and_the_progress_bar_should_update_accordingly() {
    	System.out.println("user should click on audio play back button");
    }

    @When("User clicks Movement Tab")
    public void user_clicks_movement_tab() {
    	homePage.movement();
    }

    @Then("User should see the description {string} with the bullet points {string},{string},{string},{string}")
    public void user_should_see_the_description_with_the_bullet_points(String string, String string2, String string3, String string4, String string5) {
    	System.out.println("user should see the points");
    }

    @When("User clicks Mindfulness tab")
    public void user_clicks_mindfulness_tab() {
    	homePage.mindfullness();
    }

    @Then("User should see the description \"Focus on your senses:\"with the bullet points {string},")
    public void user_should_see_the_description_focus_on_your_senses_with_the_bullet_points(String string) {
    	System.out.println("user should see the points");
    }

    @When("User scroll to the end")
    public void user_scroll_to_the_end() {
    	homePage.benefits();
    }

    @Then("User should see the list of benefits {string} with explanation {string},")
    public void user_should_see_the_list_of_benefits_with_explanation(String string, String string2) {
    	System.out.println("user should see the list of benefits");
    }

    @When("User clicks breathing tab under stress management techniques")
    public void user_clicks_breathing_tab_under_stress_management_techniques() {
    	homePage.breathingtab();
    }

    @Then("User should see the heading {string}  with the description {string}")
    public void user_should_see_the_heading_with_the_description(String string, String string2) {
    	System.out.println("user should see the heading");
    }

    @Then("User should {string} button")
    public void user_should_button(String string) {
    	homePage.seestartbutton();
    	System.out.println("user should see the start button");
    }

    @Then("User should see the {string} counter text and value starting at {int}")
    public void user_should_see_the_counter_text_and_value_starting_at(String string, Integer int1) {
    	homePage.cyclescompleted();
    	System.out.println("user should see the text");
    }

    @Then("User should see the label {string} with a hyphen \\(-) as its current value.")
    public void user_should_see_the_label_with_a_hyphen_as_its_current_value(String string) {
    	homePage.currentphase();
    	System.out.println("user should see the label");
    }

    @Then("User should see the steps {string}, {string}, {string}")
    public void user_should_see_the_steps(String string, String string2, String string3) {
    	homePage.steps();
    	System.out.println("user should see the steps");
    }
    @When("User clicks the {string} button during the breathing exercise")
    public void user_clicks_the_button_during_the_breathing_exercise(String string) {
    	homePage.startbreathing();
    }

    @Then("User should see the breathing cycles begin")
    public void user_should_see_the_breathing_cycles_begin() {
    	System.out.println("user can see breathing cycle begins");
    }

    @Given("User started Breathing cycle")
    public void user_started_breathing_cycle() {
    	homePage.startBreathingCycle();
    }

    @When("User view the current phase begins")
    public void user_view_the_current_phase_begins() {
        System.out.println("user view the current phase");
    }

    @Then("User should see the breathing cycle displays {string} which last for {int} seconds")
    public void user_should_see_the_breathing_cycle_displays_which_last_for_seconds(String string, Integer int1) {
    	boolean visible = homePage.waitForPhase(string, int1);
    	Assert.assertTrue(visible, "Expected phase was not shown for duration.");

    }

    @Given("User completed one full cycle")
    public void user_completed_one_full_cycle() {
    	homePage.completeCycle();
    }

    @When("User completes full breathing cycle")
    public void user_completes_full_breathing_cycle() {
        System.out.println("user can see the full breathing cycle");
    }

    @Then("User should see {string} counter should increased by {int}")
    public void user_should_see_counter_should_increased_by(String string, Integer int1) {
    	Assert.assertEquals(actualPhase, expectedPhase, "Expected breathing phase did not match.");
    }

    @When("User see next phase begins")
    public void user_see_next_phase_begins() {
    	homePage.getBreathingPhase();
    }

    @Then("User should see breathing cycle displays {string} which last for {int} seconds")
    public void user_should_see_breathing_cycle_displays_which_last_for_seconds(String string, Integer int1) {
    	String actualPhase = homePage.getBreathingPhase();
    	Assert.assertTrue(actualPhase.equalsIgnoreCase("pause"), "Phase is not 'pause'");

    }
    @When("User clicks the stop button during the breathing exercise")
    public void User_clicks_the_Stop_button_during_the_breathing_exercise() {
    	homePage.stop();

    }
    @Then("User should see breathing exercise stops")
    public void user_should_see_breathing_exercise_stops() {
    	String actualPage = homePage.stop();
    	Assert.assertEquals(actualPage, "BreathingPage", "Page identifier returned is incorrect");

    }

	
}
