package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePage_POM;
import utilities.LoggerLoad;


public class HomePage_Step {

	HomePage_POM lauchUI = new HomePage_POM();
	
	@Given("User launches the browser")
	public void user_launches_the_browser() {	
		LoggerLoad.info("User has already launched browser in hooks");
	}

	@When("User enters the SweetBalance url")
	public void user_enters_the_sweet_balance_url() {
		LoggerLoad.info("User is on sweet balance App");
	    //lauchUI.openBaseURL();
	}

	@Then("User should see app name on the top left")
	public void user_should_see_app_name_on_the_top_left() {
//		String nameApp = lauchUI.getAppName();
//		assertEquals(nameApp, "SweetBalance", "App name is not displayed on top left corner");
		assertTrue(lauchUI.isAppNameDisplayed(), "App name is not displayed");	    
	}
	
	@Then("User should see the text - Our Terms of Service and Privacy Policy have recently been updated")
	public void user_should_see_the_text_our_terms_of_service_and_privacy_policy_have_recently_been_updated() {
		assertTrue(lauchUI.istermConditionDisplayed(), "Term condition is not displayed");
	}
	
	@Then("User should see the text - Smart Diabetes Tracking Powered by AI")
	public void user_should_see_the_text_smart_diabetes_tracking_powered_by_ai() {
		assertTrue(lauchUI.isSmartDiabetesDisplayed(), "Diabetes tracking is not diaplayed");
	    
	}

	@Then("User should see a {string} input button")
	public void user_should_see_a_input_button(String string) {
	    
		assertTrue(lauchUI.isStartBttnDisplayed(), "Start button is not displayed");
	}

	@Then("User should see the text - Comprehensive Diabetes Management Tools")
	public void user_should_see_the_text_comprehensive_diabetes_management_tools() {
	    
		assertTrue(lauchUI.isdiabetesToolDisplayed(), "Comprehensive Diabetes Management Tools is not displayed");
	}

	@Then("User should see a card with title - Health Tracking")
	public void user_should_see_a_card_with_title_health_tracking() {
	    
		assertTrue(lauchUI.ishealthTrackingDisplayed(), "Health tracking is not displayed");
	}

	@Then("User should see a card with title - Nutrition & Exercise")
	public void user_should_see_a_card_with_title_nutrition_exercise() {
		assertTrue(lauchUI.isnutritionExcerciseDisplayed(), "Nutrition Exercise is not displayed");
	    
	}

	@Then("User should see a card with title - Smart Insights")
	public void user_should_see_a_card_with_title_smart_insights() {
	    
		assertTrue(lauchUI.issmartInsightDisplayed(), "Smart insights is not displayed");
	}

	@Then("User should see the text - Monitor glucose levels, medication, and vital statistics, Easy logging of daily readings,Visualize trends over time,Set personalized targets")
	public void user_should_see_the_text_monitor_glucose_levels_medication_and_vital_statistics_easy_logging_of_daily_readings_visualize_trends_over_time_set_personalized_targets() {
	    for(WebElement title : lauchUI.gethealthTrackingTitles()) {
	    	assertTrue(title.isDisplayed(), "title " +title+ " is not displayed");
	    }	    
	}

	@Then("User should see the text - Balance diet and physical activity for optimal control,Carb counting tools,Customized exercise plans, Meal suggestions based on readings")
	public void user_should_see_the_text_balance_diet_and_physical_activity_for_optimal_control_carb_counting_tools_customized_exercise_plans_meal_suggestions_based_on_readings() {
	    for(WebElement title : lauchUI.getNutritionTitles()) {
	    	assertTrue(title.isDisplayed(), "title " +title+ " is not displayed");
	    }	    	    
	}

	@Then("User should see the text - Get personalized guidance based on your data, Pattern detection algorithms,Early warning notifications,Actionable recommendations")
	public void user_should_see_the_text_get_personalized_guidance_based_on_your_data_pattern_detection_algorithms_early_warning_notifications_actionable_recommendations() {
	    for(WebElement title : lauchUI.getSmartInsightsTitles()) {
	    	assertTrue(title.isDisplayed(), "title " +title+ " is not displayed");
	    }	    	    
	}

	@Then("User should see heart icon")
	public void user_should_see_heart_icon() {
		assertTrue(lauchUI.isheartIconDisplayed());
	    
	}

	@Then("User should see activity inside square icon")
	public void user_should_see_activity_inside_square_icon() {
		assertTrue(lauchUI.issquareIconDisplayed());
	    
	}

	@Then("User should see clock icon")
	public void user_should_see_clock_icon() {
		assertTrue(lauchUI.iscircleIconDisplayed());
	    
	}

	@Then("User should see a testimonial from user - James D.")
	public void user_should_see_a_testimonial_from_user_james_d() {
		assertTrue(lauchUI.isJAmesDDisplayed());
	    
	}

	@Then("User should see a testimonial from user - Maria L.")
	public void user_should_see_a_testimonial_from_user_maria_l() {
		assertTrue(lauchUI.ismariaLDisplayed());
	    
	}

	@Then("User should see a testimonial from user - Robert T.")
	public void user_should_see_a_testimonial_from_user_robert_t() {
		assertTrue(lauchUI.isrobertTDisplayed());
	    
	}

	@Then("User should see - Join our community of successful members - text is visible above testimonial section")
	public void user_should_see_join_our_community_of_successful_members_text_is_visible_above_testimonial_section() {
		assertTrue(lauchUI.isjoinCommunityDisplayed());
	    
	}

	@Then("User should see {int} yellow stars above {string} text")
	public void user_should_see_yellow_stars_above_text(Integer int1, String string) {
		assertTrue(lauchUI.isfiveStarsCommunityDisplayed());
	    
	}

	@Then("User should see {int} stars under - James D.")
	public void user_should_see_stars_under_james_d(Integer int1) {
		assertTrue(lauchUI.isstarsJamesDDisplayed());
	    
	}

	@Then("User should see {int} stars under - Maria L.")
	public void user_should_see_stars_under_maria_l(Integer int1) {
		assertTrue(lauchUI.isstarsMariaLDisplayed());
	    
	}

	@Then("User should see {int} stars under - Robert T")
	public void user_should_see_stars_under_robert_t(Integer int1) {
		assertTrue(lauchUI.isstarsRobertTDisplayed());
	    
	}

	@Then("User should see a section with heading - Take control of your diabetes today")
	public void user_should_see_a_section_with_heading_take_control_of_your_diabetes_today() {
		assertTrue(lauchUI.istakeControlDisplayed());
	    
	}

	@Then("User should see a button labeled - Check Your Risk")
	public void user_should_see_a_button_labeled_check_your_risk() {
		assertTrue(lauchUI.ischeckRiskDisplayed());
	    
	}
	@When("User click the {string} button")
	public void user_click_the_button(String string) {
	    lauchUI.clickStartBttn();
	    
	}

	@Then("User should be redirected to the Login page")
	public void user_should_be_redirected_to_the_login_page() {
	    String actualPageURL = lauchUI.getCurrentUrl();
	    assertEquals(actualPageURL, "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/auth", 
	    		"User is not directed to login page");
	}

	@When("User look at the top right corner")
	public void user_look_at_the_top_right_corner() {
	    LoggerLoad.info("User is on home page");
	    
	}

	@Then("User should see a link labeled {string}")
	public void user_should_see_a_link_labeled(String string) {
	    assertTrue(lauchUI.isloginBttnDisplayed());
	    
	}

	@When("User click on the {string} link")
	public void user_click_on_the_link(String string) {
	    lauchUI.clickloginBttn();
	    
	}

	@When("User click on {string} button")
	public void user_click_on_button(String string) {
	    lauchUI.clickcheckRiskBttn();
	    
	}

	@Then("User should be redirected to the assessment modal dialog")
	public void user_should_be_redirected_to_the_assessment_modal_dialog() {
		assertTrue(lauchUI.isdiabetesPopUpDisplayed(), "Diabetes Risk Pop up screen is not displayed");
	    
	}
	
	@Given("User is in browser")
	public void user_is_in_browser() {
	    
	    lauchUI.navigateBack();
	}

	@Then("Page should be fully loaded within {int} seconds")
	public void page_should_be_fully_loaded_within_seconds(Integer int1) {
		
		long loadTime = lauchUI.verifyPageLoadTimeUnder3Seconds();
	    assertTrue(loadTime <= 3000, "Page did not load within 3 seconds");
	}

	@Then("All elements are readable and accessible without horizontal scrolling")
	public void all_elements_are_readable_and_accessible_without_horizontal_scrolling() {
		assertTrue(lauchUI.getHorizontalScrollwidth(), "Should not be accessible without horizontal scrolling");
	    
	}

	@Then("All major sections are accessible with appropriate labels and alt texts")
	public void all_major_sections_are_accessible_with_appropriate_labels_and_alt_texts() {
	    
	    
	}

	@Then("User finds the design visually appealing and readable")
	public void user_finds_the_design_visually_appealing_and_readable() {
	    
	    
	}

	@Then("User can access other sections without scrolling up")
	public void user_can_access_other_sections_without_scrolling_up() {
	    
	    
	}

	@Then("User has a consistent experience across browsers")
	public void user_has_a_consistent_experience_across_browsers() {
	    
	    
	}

}
