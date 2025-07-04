package stepDefinitions;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Homepagefeaturesonlyforfreeuser_POM;

public class Homepagefreeuser_Step {

    Homepagefeaturesonlyforfreeuser_POM homePage = new Homepagefeaturesonlyforfreeuser_POM();

    @Given("User is in password auth page")
    public void user_is_in_password_auth_page() {
        DriverFactory.getDriver().get(homePage.auth_page);
    }

    @When("User clicks sign in after entering password")
    public void user_clicks_sign_in_after_entering_password() {
        homePage.login();
        try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User should see the navigation bar displaying items in the order: Home,Dashboard,Education")
    public void user_should_see_the_navigation_bar_displaying_items_in_the_order_home_dashboard_education() {
        System.out.println("user should see the details");
    }

    @Given("User is in home page")
    public void user_is_in_home_page() {
	 System.out.println("user is in home page");
   }

    @When("User clicks on meal section")
    public void user_clicks_on_meal_section() {
	homePage.heading();
   }

     @Then("User should see {string} heading for each of the meal section")
     public void user_should_see_heading_for_each_of_the_meal_section(String string) {
    System.out.println("user should see  heading foe each meal");
   }
     @Then("User should see horizontal bar for Carbs, Protein, and Fat")
    public void user_should_see_horizontal_bar_for_carbs_protein_and_fat() {
	homePage.seehorizontalcrabs();
	System.out.println("user should see details");
    }

    @Then("User should see the pre-meal title  \\(eg: pre-breakfast)")
    public void user_should_see_the_pre_meal_title_eg_pre_breakfast() {
    	homePage.premealtitle();
    	System.out.println("user should see pre-meal title");
    }

    @Then("User should see Carbs value for the main meal")
    public void user_should_see_carbs_value_for_the_main_meal() {
    	homePage.carbsvalue();
    	System.out.println("user should see carbs value");
    }

    @Then("User should see Protein value for the main meal")
    public void user_should_see_protein_value_for_the_main_meal() {
    	homePage.proteinvalue();
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should see protein  value");
    }

    @Then("User should see Fat value for the main meal")
    public void user_should_see_fat_value_for_the_main_meal() {
    	homePage.fatvalue( );
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should see fat value");
    }

    @Then("User should see intake time in each pre-meal")
    public void user_should_see_intake_time_in_each_pre_meal() {
    	homePage.intaketime( );
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should see in-take time for meal");
    }

    @Then("User should see indicator {string} for snack  pre-meal")
    public void user_should_see_indicator_for_snack_pre_meal(String string) {
    	homePage.snacktime( );
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should see indicator for snack time");
    }

    @Then("User should see  {string} based time in pre-meal snack \\(eg : {int}:{int})")
    public void user_should_see_based_time_in_pre_meal_snack_eg(String string, Integer int1, Integer int2) {
      homePage.snack( );
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should see in format");
    }

    @Then("User should see {int} o'clock")
    public void user_should_see_o_clock(Integer int1) {
    	homePage.presnack( );
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should see integer for clock");
    }

    @Then("User should see dot between time and calorie in each pre-meal session")
    public void user_should_see_dot_between_time_and_calorie_in_each_pre_meal_session() {
    	homePage.premeal( );
    	try {
            Thread.sleep(5000); // TEMPORARY: let browser stay open for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	System.out.println("user should navigate to see time");
    }

    @Then("User should redirected to subscription page")
    public void user_should_redirected_to_subscription_page() {
    	homePage.viewfullmealplan( );
    	
    	System.out.println("user should navigate to page");
    }
     @When("User clicks exercise section")
    public void user_clicks_exercise_section() {
    	homePage.clickexercise();
    }

    @Then("User should see title1 {string}")
    public void user_should_see_title1(String string) {
        System.out.println("user should see title");
    }
    @Then("User should see {int} exercises listed for the day")
    public void user_should_see_exercises_listed_for_the_day(Integer int1) {
    	homePage.exerciselist();
    	System.out.println("user should see listed exercises");
    }

    @Then("User should see scheduled time of each exercise")
    public void user_should_see_scheduled_time_of_each_exercise() {
    	homePage.time();
    	System.out.println("user should see time");
    }

    @Then("Morning exercise should be scheduled for {int} o'clock")
    public void morning_exercise_should_be_scheduled_for_o_clock(Integer int1) {
    	homePage.morning();
    	System.out.println("user should see morning time exercise");
    }

    @Then("Evening exercise should be scheduled for {int} o'clock")
    public void evening_exercise_should_be_scheduled_for_o_clock(Integer int1) {
    	homePage.evening();
    	System.out.println("user should see evening time exercise");
    }

    @Then("User should see plan title for each exercise")
    public void user_should_see_plan_title_for_each_exercise() {
    	homePage.plan();
    	System.out.println("user should see plan title for each exercise");
    }

    @Then("User should see {int}-hour clock indicator with AM\\/PM.")
    public void user_should_see_hour_clock_indicator_with_am_pm(Integer int1) {
    	homePage.clockindicator();
    	System.out.println("user should see clock indicator");
    }

    @Then("User should see a duration in each exercise item")
    public void user_should_see_a_duration_in_each_exercise_item() {
    	homePage.duration();
    	System.out.println("user should see duration in exercise");
    }

    @Then("User should see duration format in mins for each exercise item")
    public void user_should_see_duration_format_in_mins_for_each_exercise_item() {
    	homePage.format();
    	System.out.println("user should see format");
    }

    @Then("User should see dot between duration and intensity level")
    public void user_should_see_dot_between_duration_and_intensity_level() {
    	homePage.indicator();
    	System.out.println("user should see see dot between duration");
    }

    @Then("User should see intensity level in each exercise")
    public void user_should_see_intensity_level_in_each_exercise() {
    	homePage.exerciseitem();
    	System.out.println("user should  see intensity level in each exercise");
    }

    @Then("User should see button with text {string}")
    public void user_should_see_button_with_text(String string) {
    	homePage.viewfullschedule();
    	System.out.println("user should see button with viewfullschedule");
    }

    @When("User clicks view full schedule button after reaching exercise section")
    public void user_clicks_view_full_schedule_button_after_reaching_exercise_section() {
    	homePage.clickfullschedule();
    	System.out.println("user should redirect to page");
    }



}
