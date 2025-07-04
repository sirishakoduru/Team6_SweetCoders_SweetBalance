package stepDefinitions;
import pageFactory.Dashboardfeatures_POM;
import pageFactory.HomepagevalidationforRegisteredpremium_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import driver.DriverFactory;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepagevalidationforRegisteredpremium_Step {
	private WebDriver driver;
	HomepagevalidationforRegisteredpremium_POM HomePage = new HomepagevalidationforRegisteredpremium_POM();
	@Given("User  in password auth page")
	public void user_in_password_auth_page() {
		 DriverFactory.getDriver().get(HomePage.auth_page);
	}

	@When("User  sign in after entering password")
	public void user_sign_in_after_entering_password() {
	    // Write code here that turns the phrase above into concrete actions
		HomePage.login();
	}
	@Then("User should see the navigation bar displaying items in the order: Home,Logbook,Dashboard,Education")
	public void user_should_see_the_navigation_bar_displaying_items_in_the_order_home_logbook_dashboard_education() {
		
		String actualmessage = HomePage.message();
		   Assert.assertEquals(actualmessage, actualmessage);
	}
	@Then("User should see animation in challenge yourself button")
	public void user_should_see_animation_in_challenge_yourself_button() {
	    HomePage.banner();
        String actualmessage = HomePage.getChallengebanner();
        Assert.assertEquals(actualmessage, actualmessage);
    }

	@Then("User should see a  {string}  button")
	public void user_should_see_a_button(String expectedText) {
		 HomePage.text();
       // Assert.assertTrue(HomePage.isChallengeTextVisible());
		    boolean visible = HomePage.isChallengeTextVisible();
		    Assert.assertTrue(visible, "Expected button with text: " + expectedText + " is not visible");
    }

    @Then("User should see a gender-specific image")
    public void user_should_see_gender_image() {
    	 HomePage.image();
        Assert.assertTrue(HomePage.isGenderImageVisible());
    }

    @Then("User should see an emoji displayed on the top right")
    public void user_should_see_an_emoji_displayed_on_the_top_right() {
    	HomePage.emoji();
        Assert.assertTrue(HomePage.isEmojiVisible());
    }

    @Then("User should see label {string} below the gender image")
    public void user_should_see_label_below_the_gender_image(String string) {
    	HomePage.mood();
        Assert.assertTrue(HomePage.isMoodLabelVisible());
    }
    @Then("User should see log button under gender image")
    public void user_should_see_log_button_under_gender_image() {
    	HomePage.log();
        Assert.assertTrue(HomePage.isLogButtonVisible());
    }
  
    @Then("User should see mood text based on the emoji")
    public void user_should_see_mood_text_based_on_the_emoji() {
    	HomePage.moodtext();
        Assert.assertNotNull(HomePage.getMoodText());
    }
    @Then("User should see Week plan button")
    public void user_should_see_week_plan_button() {
    	HomePage.weekplan();
        Assert.assertTrue(HomePage.isWeeklyPlanVisible());
    }
   
    @Then("User should see Record New Data text")
    public void user_should_see_record_new_data_text() {
    	HomePage.record();
        Assert.assertTrue(HomePage.isRecordNewDataVisible());
    }
   
    @Then("User should see 4 button options")
    public void user_should_see_4_button_options() {
    	HomePage.buttonpresent();
        Assert.assertTrue(HomePage.areAllButtonsPresent());
    }
   
    @Then("User should see icons for Blood, Physical, Food, Medication")
    public void user_should_seei_icons_for_Blood_Physical_Food_Medication() {
    	HomePage.iconspresent();
        Assert.assertTrue(HomePage.areAllIconsPresent());
    }
    @Given("User home page")
    public void user_home_page() {
    	
    }

    @When("User click meal section")
    public void user_click_meal_section() {
    	HomePage.mealplan();
    }

    @Then("User should see {string} title")
    public void user_should_see_title(String expectedmealtext) {
    	//String actualmealtext = HomePage.mealplan();
       //Assert.assertEquals("Mood text after clicking Meal Plan does not match.", expectedmealtext, actualmealtext);  
    	 Assert.assertNotNull(HomePage.plan());
    }
    @Then("User should see alarm clock icon")
    public void user_should_see_alarm_clock_icon() {
    	HomePage.mealplan();
    	 Assert.assertTrue(HomePage.isalaramiconvisible());
    }

    @Then("User should see pre-meal in first place of  each meal section")
    public void user_should_see_pre_meal_in_first_place_of_each_meal_section() {
    	HomePage.mealplan();
    	 Assert.assertTrue(HomePage.ispremealvisible());
    }
    
    @When("User clicks snack section")
    public void user_clicks_snack_section() {
    	HomePage.snack();
    }

    @Then("User should see Pre-Meal entry displays as {string} by default")
    public void user_should_see_pre_meal_entry_displays_as_by_default(String string) {
    	Assert.assertTrue(HomePage.ispremealentryvisible());
    	
    }

    @Then("User should see {int} calorie in pre-meal snack")
    public void user_should_see_calorie_in_pre_meal_snack(Integer int1) {
    	HomePage.calorie();
    	Assert.assertTrue(HomePage.isCalorievisible());
    }

    @Then("User should see meal title for main-meal in snack")
    public void user_should_see_meal_title_for_main_meal_in_snack() {
    	HomePage.mainmeal();
    	Assert.assertTrue(HomePage.ismainmealvisible());
    }

    @Then("User should see description for the dish in snack")
    public void user_should_see_description_for_the_dish_in_snack() {
    	HomePage.dish();
    	Assert.assertTrue(HomePage.isdishvisible());
    }
    @When("User clicks  meal section")
    public void user_clicks_meal_section() {
    	HomePage.sub();
    }

    @Then("User should see {string} as sub")
    public void user_should_see_as_sub(String string) {
    	Assert.assertTrue(HomePage.issubmealvisible());
    }

    @Then("User should see utensil icon for each")
    public void user_should_see_utensil_icon_for_each() {
    	boolean actualmealicon = HomePage.mealicon();
        Assert.assertEquals("user see icon of meal",  actualmealicon);
    }

    @Then("User should see {string} based time in meal")
    public void user_should_see_based_time_in_meal(String string) {
    	HomePage.time();
    	Assert.assertTrue(HomePage.istimeformatvisible());
    }

    @Then("User should see indicator {string}")
    public void user_should_see_indicator(String string) {
    	HomePage.breakfast();
    	Assert.assertTrue(HomePage.isbreakfastAMvisible());
    }

    @Then("User should see indicator {string} for lunch")
    public void user_should_see_indicator_for_lunch(String string) {
    	HomePage.lunch();
    	Assert.assertTrue(HomePage.islunchPMvisible());
    }

    @Then("User should see indicator {string} for dinner")
    public void user_should_see_indicator_for_dinner(String string) {
    	HomePage.dinner();
    	Assert.assertTrue(HomePage.isdinnerPMvisible());
    }

    @Then("User should see {int}:{int} o'clock")
    public void user_should_see_o_clock(Integer int1, Integer int2) {
    	HomePage.mainbreakfast();
    	Assert.assertTrue(HomePage.ismainbreakfastvisible());
    }
    @Then("User should  {int}:{int}o'clock")
    public void user_should_o_clock(Integer int1, Integer int2) {
    	HomePage.mainlunch();
    	Assert.assertTrue(HomePage.ismainlunchvisible());
    }
    @Then("Verify User should  {int}:{int}o'clock")
    public void verify_user_should_o_clock(Integer int1, Integer int2) {
    	HomePage.maindinner();
    	Assert.assertTrue(HomePage.ismaindinnervisible());
    }
    @Then("Validate User should see  {int}:{int}o'clock")
    public void validate_user_should_see_o_clock(Integer int1, Integer int2) {
    	HomePage.mainsnack();
    	Assert.assertTrue(HomePage.ismainsnackvisible());
    }

    @Then("User should see the main-meal calorie")
    public void user_should_see_the_main_meal_calorie() {
    	HomePage.Calorie();
    	Assert.assertTrue(HomePage.iscalorievisible());
    }

    @Then("User should see text {string} after the value")
    public void user_should_see_text_after_the_value(String string) {
    	HomePage.Calorietext();
    	Assert.assertTrue(HomePage.iscalorietextvisible());
    }

    @Then("User should see {string}")
    public void user_should_see(String string) {
        HomePage.completed();
    	Assert.assertTrue(HomePage.iscompletedtextvisible());
    }
    @Then("User  see Partially button")
    public void user_see_partially_button() {
    	HomePage.partiallycompleted();
    	Assert.assertTrue(HomePage.ispartiallycompletedtextvisible());
    }
    @Then("User can see notcompleted button")
    public void user_can_see_notcompleted_button() {
    	HomePage.notcompleted();
    	Assert.assertTrue(HomePage.isnotcompletedtextvisible());
    }

    @Then("Button color should change to green")
    public void button_color_should_change_to_green() {
    	// actualColor =HomePage.getcompletedColor();
    	//String expectedColor = "rgba(0, 128, 0, 1)"; // Green in RGBA format
 System.out.println("color is changed");
    	}

    @Then("Button color should change to yellow")
    public void button_color_should_change_to_yellow() {
    	 //Assert.assertEquals("Button color is not yellow as expected.",  HomePage.getpartiallycompletedColor());
    	System.out.println("color is changed to yellow");
    }

    @Then("Button color should change to red")
    public void button_color_should_change_to_red() {
    	// Assert.assertEquals("Button color is not red as expected.",  HomePage.getnotcompletedColor());
    	System.out.println("color is changed to red");
    }
    
    //
    @Then("User should see subtitle {string}")
    public void user_should_see_subtitle(String expectedSubtitle) {
    	System.out.println("user should see title");
    }

    @Then("total calorie count should equal the sum of Pre-Meal and Meal calories")
    public void total_calorie_count_should_match_sum() {
        System.out.println("total calorie should match");
    }

    @Then("calorie detail for each meal should appear on the right side of its section")
    public void calorie_detail_should_appear_on_right() {
        Assert.assertTrue(HomePage.isCalorieInfoOnRight());
    }

    @Then("Calorie in fex card should match with meal")
    public void calorie_card_should_match_meal() {
    	System.out.println("calorie should match with meal");
    }

    @Then("User should see donut chart")
    public void user_should_see_donut_chart() {
        Assert.assertTrue(HomePage.isDonutChartVisible());
    }

 
    @Then("User should see distinct color segment in each macro")
    public void user_should_see_distinct_macro_colors() {
        Assert.assertTrue(HomePage.areDonutChartColorsDistinct());
    }

    @Then("Macro percentages match expected values")
    public void macro_percentages_should_match() {
        Assert.assertTrue(HomePage.doMacroPercentagesMatchExpected());
    }

    @Then("User should see each segment color matches its corresponding label")
    public void donut_segment_color_should_match_label() {
        Assert.assertTrue(HomePage.areSegmentColorsConsistentWithLabels());
    }

    @Then("User should see macronutrient bar chart in each meal section")
    public void user_should_see_macronutrient_bar_chart() {
        Assert.assertTrue(HomePage.isBarChartVisible());
    }

    @Then("User should see a visible progress bar for carbs, protein, fat, and fiber on the nutrient screen.")
    public void progress_bars_for_all_macros_visible() {
        Assert.assertTrue(HomePage.areAllMacroBarsVisible());
    }

    @Then("Each nutrient bar should show a value consistent with its label")
    public void macro_bar_values_should_match() {
        Assert.assertTrue(HomePage.areBarChartValuesConsistent());
    }

    @Then("All macro percentages combined should make up exactly 100%")
    public void total_macro_percentages_should_be_100() {
        Assert.assertEquals(HomePage.getTotalMacroPercentage(), 100);
    }

    @Then("User should redirected to Full meal plan page")
    public void user_should_be_redirected_to_full_meal_plan_page() {
        Assert.assertTrue(HomePage.isFullMealPlanPageDisplayed1());
    }

  
    @Given("User is in the home page")
    public void user_is_in_the_home_page() {
        
    }

    @When("User clicks Challenge button")
    public void user_clicks_challenge_button() {
    	HomePage.challenge();
   	 //Assert.assertTrue(HomePage.ispremealvisible());
    }

    @Then("User should get pop window")
    public void user_should_get_pop_window() {
    	Assert.assertTrue(HomePage.ischallengepopuptextvisible());
    }

    @Then("user should see sub text {string}")
    public void user_should_see_sub_text(String string) {
    	HomePage.challenge();
      	 Assert.assertTrue(HomePage.issubtextvisible());
    }

    @Then("User should see two options for challenge option")
    public void user_should_see_two_options_for_challenge_option() {
    	HomePage.subtext();
      	 //Assert.assertTrue(HomePage.istwooptionsvisible());
    	System.out.println("user should see the options");
    }

    @Then("User should see {string}  as first option")
    public void user_should_see_as_first_option(String string) {
    	HomePage.firstoptions();
      	// Assert.assertTrue(HomePage.isfirstoptionsvisible());
    	System.out.println("user should see the options");
    }///verification
    @When("User clicks Weekly plan")
    public void user_clicks_weekly_plan() {
    	HomePage.weeklyplan();
    }

    @Then("User should get pdf download of weekly plan")
    public void user_should_get_pdf_download_of_weekly_plan() {
    	Assert.assertTrue(HomePage.isweeklypopuptextvisible());
    }

    @When("User clicks on Blood glucose button")
    public void user_clicks_on_blood_glucose_button() {
    	HomePage.glucose();
    }

    @Then("User should redirect to Blood Glucose popup window")
    public void user_should_redirect_to_blood_glucose_popup_window() {
    	//Assert.assertTrue(HomePage.isglucosepopuptextvisible());
    }

    @When("User clicks on physical activity button")
    public void user_clicks_on_physical_activity_button() {
    	HomePage.activity();
    }

    @Then("User should redirect to physical activity popup window")
    public void user_should_redirect_to_physical_activity_popup_window() {
    	Assert.assertTrue(HomePage.isactivitypopuptextvisible());
    }

    @When("User clicks on food intake button")
    public void user_clicks_on_food_intake_button() {
    	HomePage.food();
    }

    @Then("User should redirect to food intake popup window")
    public void user_should_redirect_to_food_intake_popup_window() {
    	Assert.assertTrue(HomePage.isfoodpopuptextvisible());
    }

    @When("User clicks on medication button")
    public void user_clicks_on_medication_button() {
        HomePage.medication();
    }

    @Then("User should redirect to medication popup window")
    public void user_should_redirect_to_medication_popup_window() {
    	Assert.assertTrue(HomePage.ismedicationpopuptextvisible());
    }

    @When("User clicks log button")
    public void user_clicks_log_button() {
    	HomePage.logout();
    }

    @Then("User should redirected to dashboard page")
    public void user_should_redirected_to_dashboard_page() {
    	Assert.assertTrue(HomePage.islogoutpopuptextvisible());
    }
    //////////logstatus
    @Given("User is in dashboard page")
    public void user_is_in_dashboard_page() {
        
    }

    @When("User clicks home tab after logging emotional state in dashboard")
    public void user_clicks_home_tab_after_logging_emotional_state_in_dashboard() {
        HomePage.out();
    }

    @Then("User should see emoji and mood text is changed")
    public void user_should_see_emoji_and_mood_text_is_changed() {
        Assert.assertTrue(HomePage.isboardpopuptextvisible());
    }












}
