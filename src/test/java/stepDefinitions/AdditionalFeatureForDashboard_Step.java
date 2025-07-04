package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.AdditionalFeatureForDashboard_POM;
import pageFactory.CommonHomePage_POM;
import pageFactory.Login_POM;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalFeatureForDashboard_Step {

    WebDriver driver;
    Login_POM loginPom;
    CommonHomePage_POM commonHomePage;
    AdditionalFeatureForDashboard_POM dashboard;

    public AdditionalFeatureForDashboard_Step(){
        driver = DriverFactory.getDriver();
        loginPom = new Login_POM();
        commonHomePage = new CommonHomePage_POM();
        dashboard = new AdditionalFeatureForDashboard_POM();
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        loginPom.getloginurl();
        commonHomePage.enterEmailInTextBox(ConfigReader.getProperty("userEmail"));
        commonHomePage.clickContinueWithEmail();
        commonHomePage.enterPasswordInTextBox(ConfigReader.getProperty("userPassword"));
        commonHomePage.clickSignInbttn();
        LoggerLoad.info("Successfully navigated to Home Page after login");
    }

    //----------------------------------Dashboard page validation for Registered premium account user---------//
    @When("User click dashboard on the navigation bar")
    public void user_click_dashboard_on_the_navigation_bar() {
        LoggerLoad.info("Navigating to Dashboard page from home.");
        dashboard.navigatedToDashboardPage();
        LoggerLoad.info("Clicked on Dashboard button.");
        boolean isDashboardLoaded = dashboard.verifyDashboardPageDisplayed();
        Assert.assertTrue("Dashboard page did not load successfully.", isDashboardLoaded);
        LoggerLoad.info("Dashboard page loaded successfully.");
    }

    @Then("User should see the King symbol 👑 displayed next to their name")
    public void user_should_see_the_king_symbol_displayed_next_to_their_name() {
        boolean isKingIconVisible = dashboard.verifyKingSymbolDisplayed();
        Assert.assertTrue("King 👑 symbol is not displayed next to the user's name.", isKingIconVisible);
        LoggerLoad.info("King 👑 symbol is successfully displayed next to the user's name.");
    }

    @Then("User should see the {string} status next to the symbol")
    public void user_should_see_the_status_next_to_the_symbol(String expectedStatus) {
        String actualStatus = dashboard.getPremiumStatusText();
        LoggerLoad.info("Premium status is: " + actualStatus);
        Assert.assertEquals("Premium status next to the symbol does not match.", expectedStatus, actualStatus);
        LoggerLoad.info("Verified Premium status matches expected: " + expectedStatus);
    }

    @Then("User should see the {string} button")
    public void user_should_see_the_button(String buttonName) {
        boolean isButtonVisible = dashboard.verifyManagePremiumButtonVisible();
        Assert.assertTrue(buttonName + " button is not visible.", isButtonVisible);
        LoggerLoad.info(" User should see the Manage premium button.");
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_button(String buttonName) {
        dashboard.navigatedToDashboardPage();
        dashboard.clickManagePremiumButton();
        LoggerLoad.info(" User clicks on Manage premium button.");
    }

    @Then("User should see the dialog box open")
    public void user_should_see_the_dialog_box_open() {
        boolean isDialogBoxVisible = dashboard.verifyDialogBoxVisible();
        Assert.assertTrue("Dialog box is not visible after clicking manage premium button.", isDialogBoxVisible);
        LoggerLoad.info(" User should see the dialog box after clicking manage premium button.");
    }

    @Then("User should see the {string} with value in format {string}")
    public void user_should_see_the_with_value_in_format(String label, String format) {
        boolean isLabelVisible = false;
        boolean isValueFormatted = false;
        if (label.equalsIgnoreCase("Start Date:")) {
            isLabelVisible = dashboard.isStartDateDisplayed();
            isValueFormatted = dashboard.isStartDateInExpectedFormat(format);
        } else if (label.equalsIgnoreCase("End Date:")) {
            isLabelVisible = dashboard.isEndDateDisplayed();
            isValueFormatted = dashboard.isEndDateInExpectedFormat(format);
        }
        Assert.assertTrue(label + " label is not visible.", isLabelVisible);
        Assert.assertTrue(label + " value is not in expected format: " + format, isValueFormatted);
    }

//-------------------Emotional Well being validations on Premium dashboard----------------------------------//
    @Given("User is in Dashboard Page")
    public void user_is_in_dashboard_page() {
        dashboard.navigatedToDashboardPage();
        LoggerLoad.info("User navigated to Dashboard Page");
    }

    @When("User scrolls to the middle")
    public void user_scrolls_to_the_middle() {
        CommonMethods.scrollToElement(dashboard.getEmotionalWellBeingTitle());
        LoggerLoad.info("User scrolled to the Emotional Well being section");
    }

    @Then("User should see the subtitle {string}")
    public void user_should_see_the_subtitle(String expectedTitle) {
        String actualTitle = dashboard.getEmotionalWellBeingTitle().getText();
        String filteredTitle = actualTitle.replaceAll("[^\\p{L}\\p{Z}]", "").trim();
        Assert.assertEquals(expectedTitle, filteredTitle);
        LoggerLoad.info("User should see the subtitle Emotional Wellbeing");
    }

    @Then("User should see the question text {string}")
    public void user_should_see_the_question_text(String question) {
        boolean isQuestionVisible = dashboard.verifyQuestionIsDisplayed();
        Assert.assertTrue(question + " is not visible.", isQuestionVisible);
        LoggerLoad.info(" User should see the question in emotion well being section.");
    }

    @Then("User should see six emoji 😄 😊 😐 😔 😠 😰 options visible for selection")
    public void user_should_see_six_emoji_options_visible_for_selection() {
        boolean allEmojisVisible = dashboard.verifyMoodEmojisDisplayed();
        Assert.assertTrue("Not all 6 mood emojis are visible for selection", allEmojisVisible);
        LoggerLoad.info("User should see 6 mood emojis options for selection");
    }

    @Then("Usr should see the text {string}")
    public void usr_should_see_the_text(String label) {
        boolean isNotesOnMoodVisible = dashboard.verifyNotesOnMoodLabelVisible();
        Assert.assertTrue("User cannot see the text Notes on your mood", isNotesOnMoodVisible);
        LoggerLoad.info("User should see the text Notes on your mood");
    }

    @Then("User should see the Text {string} in input field")
    public void user_should_see_the_text_in_input_field(String expectedPlaceholder) {
        String actualPlaceholder = dashboard.getPlaceholderTextOfNotes();
        Assert.assertEquals("Input field placeholder text does not match", expectedPlaceholder, actualPlaceholder);
        LoggerLoad.info("Verified input field placeholder: " + actualPlaceholder);
    }

    @When("User scrolls to middle and enter value in notes on your mood input field")
    public void user_scrolls_to_middle_and_enter_value_in_notes_on_your_mood_input_field() {
        CommonMethods.scrollToElement(dashboard.getInputFieldText());
        String testNote = "Feeling good";
        dashboard.enterTextInNotes(testNote);
        LoggerLoad.info("Entered value in mood notes input field: " + testNote);
    }

    @Then("User should see the value entered in input field")
    public void user_should_see_the_value_entered_in_input_field() {
        String expectedValue = "Feeling good";
        String actualValue = dashboard.getInputFieldText().getAttribute("value");
        Assert.assertEquals("Entered value is not visible in the input field", expectedValue, actualValue);
        LoggerLoad.info("Verified entered value is visible in input field: " + actualValue);
    }

    @When("User scrolls to middle")
    public void user_scrolls_to_middle() {
        CommonMethods.scrollToElement(dashboard.getEnergyLevelSlider());
        LoggerLoad.info("User scrolled to the energy level slider");
    }

    @Then("User should see the energy level slider")
    public void user_should_see_the_energy_level_slider() {
        boolean isEnergyLevelSliderVisible = dashboard.verifyEnergyLevelSliderVisible();
        Assert.assertTrue("User cannot see the energy level slider", isEnergyLevelSliderVisible);
        LoggerLoad.info("User should see the energy level slider");
    }

    @Then("User should see Energy level slider with labels {string} and {string}")
    public void user_should_see_energy_level_slider_with_labels_and(String lowSide, String highSide) {
        // Verify slider is visible
        if (!dashboard.getEnergyLevelSlider().isDisplayed()) {
            throw new AssertionError("Energy level slider is not visible.");
        }
        if (!dashboard.getLowLabel().isDisplayed() ||
                !dashboard.getLowLabel().getText().equalsIgnoreCase(lowSide)) {
            throw new AssertionError("Low label not visible or does not match expected text: " + lowSide);
        }
        if (!dashboard.getHighLabel().isDisplayed() ||
                !dashboard.getHighLabel().getText().equalsIgnoreCase(highSide)) {
            throw new AssertionError("High label not visible or does not match expected text: " + highSide);
        }
    }

    @When("User scrolls to middle and moves Energy slider to new position")
    public void user_scrolls_to_middle_and_moves_energy_slider_to_new_position() {
        CommonMethods.scrollToElement(dashboard.getEnergyLevelSlider());
        dashboard.moveEnergySlider(50);
        LoggerLoad.info("User moves Energy slider to new position");
    }

    @Then("User should see the value  changes according to the position")
    public void user_should_see_the_value_changes_according_to_the_position() {
        String displayedValue = dashboard.getEnergyLevelSliderValue().getText();
        Assert.assertFalse("Value did not update", displayedValue.isEmpty());
    }

    @Then("User should see the \"log emotional state\"button")
    public void user_should_see_the_log_emotional_state_button() {
        boolean isLogEmotionalStateButtonVisible = dashboard.verifyLogEmotionalStateButtonVisible();
        Assert.assertTrue("User cannot see the log emotional state button", isLogEmotionalStateButtonVisible);
        LoggerLoad.info(" User should see the log emotional state button");
    }

    @When("User select mood emoji and click log emotional state button")
    public void user_select_mood_emoji_and_click_log_emotional_state_button() {
        dashboard.clickHappyEmoji();
        LoggerLoad.info(" User select the happy emoji");
        if (dashboard.verifyLogEmotionalStateButtonVisible()) {
            dashboard.clickLogEmotionalStateButton();
        } else {
            throw new AssertionError("Log Emotional State button is not visible.");
        }
    }

    @Then("User should see the success message {string}")
    public void user_should_see_the_success_message(String expectedMessage) {
        String actualMessage = dashboard.getLogEmotionalStateSuccessMessage();
        if (!actualMessage.equalsIgnoreCase(expectedMessage)) {
            throw new AssertionError("Expected message: \"" + expectedMessage + "\" but got: \"" + actualMessage + "\"");
        }
    }

// ---------------------------------User Activity Tracking on premium Dashboard-----------------------------------//
    @Given("User has not logged any weekly checks for the current week")
    public void user_has_not_logged_any_weekly_checks_for_the_current_week() {
        LoggerLoad.info("User has not logged any weekly checks for the current week");
    }

    @When("User navigates to dashboard page")
    public void user_navigates_to_dashboard_page() {
        dashboard.navigatedToDashboardPage();
        LoggerLoad.info("User navigated to Dashboard Page");
    }

    @Then("User should see  {string}  displaying {string} with subtitle {string}")
    public void user_should_see_displaying_with_subtitle(String expectedTitle, String expectedValue, String expectedText) {
        String actualTitle = dashboard.getWeeklyChecksTitle();
        String actualValue = dashboard.getWeeklyChecksValue();
        String actualText = dashboard.getWeeklyChecksText();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedValue, actualValue);
        Assert.assertEquals(expectedText, actualText);
    }

    @Given("User has logged weekly check for the current week")
    public void user_has_logged_weekly_check_for_the_current_week() {
        LoggerLoad.info("User has logged weekly check for the current week");
    }

    @Then("User should see {string} displaying value based on the logs")
    public void user_should_see_displaying_value_based_on_the_logs(String expectedTitle) {
        LoggerLoad.info("User should see Weekly Checks displaying value based on the logs");
        String actualTitle = dashboard.getWeeklyChecksTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Given("User has not logged any exercise minutes for the week")
    public void user_has_not_logged_any_exercise_minutes_for_the_week() {
        LoggerLoad.info("User has not logged any exercise minutes for the week");
    }

    @Then("User should see the {string} displaying {string} with subtitle {string}")
    public void user_should_see_the_displaying_with_subtitle(String expectedTitle, String expectedValue, String expectedText) {
        String actualTitle = dashboard.getExerciseMinutesTitle();
        String actualValue  = dashboard.getExerciseMinutesValue();
        String actualText = dashboard.getExerciseMinutesText();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedValue, actualValue);
        Assert.assertEquals(expectedText, actualText);
    }

    @Given("User has logged exercise minutes for the week")
    public void user_has_logged_exercise_minutes_for_the_week() {
        LoggerLoad.info("User has logged exercise minutes for the week");
    }

    @Then("User should see {string} displaying number of minutes based on the entries")
    public void user_should_see_displaying_number_of_minutes_based_on_the_entries(String expectedTitle) {
        LoggerLoad.info(" User should see Exercise Minutes displaying number of minutes based on the entries");
        String actualTitle = dashboard.getExerciseMinutesTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Given("User has not logged Medication adherence for the week")
    public void user_has_not_logged_medication_adherence_for_the_week() {
        LoggerLoad.info("User has not logged Medication adherence for the week");
    }

    @Then("User should see the title {string} displaying {string} with subtitle {string}")
    public void user_should_see_the_title_displaying_with_subtitle(String expectedTitle, String expectedValue, String expectedText) {
        String actualTitle = dashboard.getMedAdherenceTitle();
        String actualValue = dashboard.getMedAdherenceValue();
        String actualText = dashboard.getMedAdherenceText();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedValue, actualValue);
        Assert.assertEquals(expectedText, actualText);
    }

    @Given("User has logged Medication Adherence for the week")
    public void user_has_logged_medication_adherence_for_the_week() {
        LoggerLoad.info("User has logged Medication Adherence for the week");
    }

    @Then("User should see {string} displaying value based on the log")
    public void user_should_see_displaying_value_based_on_the_log(String expectedTitle) {
        LoggerLoad.info("User should see Med Adherence displaying value based on the log");
        String actualTitle = dashboard.getMedAdherenceTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Given("User has not logged Carb goals for the week")
    public void user_has_not_logged_carb_goals_for_the_week() {
        LoggerLoad.info("User has not logged Carb goals for the week");
    }

    @Then("User should see title {string}  displaying {string} with subtitle {string}")
    public void user_should_see_title_displaying_with_subtitle(String expectedTitle, String expectedValue, String expectedText) {
        String actualTitle = dashboard.getCarbGoalsTitle();
        String actualValue = dashboard.getCarbGoalsValue();
        String actualText = dashboard.getCarbGoalsText();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedValue, actualValue);
        Assert.assertEquals(expectedText, actualText);
    }

    @Given("User has logged carb goals for the week")
    public void user_has_logged_carb_goals_for_the_week() {
        LoggerLoad.info("User has logged carb goals for the week");
    }

    @Then("User should see the {string} displaying value based on the logs")
    public void user_should_see_the_displaying_value_based_on_the_logs(String expectedTitle) {
        LoggerLoad.info("User should see the Carb Goals displaying value based on the logs");
        String actualTitle = dashboard.getCarbGoalsTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

//----------------------------Smart Insights Validation on Premium dashboard------------------------------------//
    @Given("User has health data for the last {int} days")
    public void user_has_health_data_for_the_last_days(Integer int1) {
        LoggerLoad.info("User has health data for the last 7 days");
    }

    @Then("User should see the title {string} in smart insights section")
    public void user_should_see_the_title_in_smart_insights_section(String expectedTitle) {
        LoggerLoad.info("User should see the title Smart Insights in smart insights section");
        Assert.assertTrue(dashboard.verifySmartInsightsTitleVisible());
        Assert.assertEquals(expectedTitle, dashboard.getSmartInsightsTitleText());
    }

    @Then("User should see the label {string} in smart insights section")
    public void user_should_see_the_label_in_smart_insights_section(String expectedLabel) {
        LoggerLoad.info("User should see the label last 7 days in smart insights section");
        Assert.assertTrue(dashboard.verifyLast7DaysLabelVisible());
        Assert.assertEquals(expectedLabel, dashboard.getSmartInsightsLabelText());
    }

    @Then("User should see Titles {string},{string},{string}")
    public void user_should_see_titles(String title1, String title2, String title3) {
        LoggerLoad.info("User should see Titles Target Achievement, Pattern detected, Suggestion");
        String actualTitle1 =  dashboard.verifyTargetAchievementTitle();
        String actualTitle2 = dashboard.verifyPatternDetectedTitle();
        String actualTitle3 = dashboard.verifySuggestionTitle();
        Assert.assertEquals("Target Achievement title mismatch", title1, actualTitle1);
        Assert.assertEquals("Pattern Detected title mismatch", title2, actualTitle2);
        Assert.assertEquals("Suggestion title mismatch", title3, actualTitle3);
    }

    @Then("User should see the display of percentage of time the user was in the target range for the last {int} days with the percentage improvement compared to the previous week")
    public void user_should_see_the_display_of_percentage_of_time_the_user_was_in_the_target_range_for_the_last_days_with_the_percentage_improvement_compared_to_the_previous_week(Integer int1) {
        LoggerLoad.info("Verifying target range percentage and improvement over last week");
        String text = dashboard.getTargetAchievementText();
        Pattern pattern = Pattern.compile("up (\\d+)% from last week");
        Matcher matcher = pattern.matcher(text);
        Assert.assertTrue("Improvement percentage not found in the UI text: " + text, matcher.find());
        int improvement = Integer.parseInt(matcher.group(1));
        LoggerLoad.info("Improvement from last week: " + improvement + "%");
    }

    @Then("user should see  percentage of glucose value spike  with suggestion to improve")
    public void user_should_see_percentage_of_glucose_value_spike_with_suggestion_to_improve() {
        LoggerLoad.info("Verifying that glucose spike percentage suggestion is displayed...");
        String text = dashboard.getPatternDetectedText();
        Assert.assertNotNull("Pattern suggestion text should not be null", text);
        Assert.assertFalse("Pattern suggestion text should not be empty", text.trim().isEmpty());
    }


    @Then("user should see a suggestion of activity  with the average expected glucose reduction from this activity")
    public void user_should_see_a_suggestion_of_activity_with_the_average_expected_glucose_reduction_from_this_activity() {
        LoggerLoad.info("Checking if the activity suggestion is displayed...");
        String suggestionText = dashboard.getSuggestionText();
        Assert.assertNotNull("Suggestion text should not be null", suggestionText);
        Assert.assertFalse("Suggestion text should not be empty", suggestionText.trim().isEmpty());
    }

//----------------------------------Manage premium Dialog box Validation--------------------------------------//
    @Given("User is in premium subscription dialog box")
    public void user_is_in_premium_subscription_dialog_box() {
        dashboard.navigatedToDashboardPage();
        LoggerLoad.info("Navigated to the dashboard page");
        dashboard.clickManagePremiumButton();
        LoggerLoad.info("User clicks on manage premium button");
    }

    @When("User view Manage premium Dialog box")
    public void user_view_manage_premium_dialog_box() {
        LoggerLoad.info("User should see the Manage premium dialog box open");
        dashboard.verifyDialogBoxVisible();
    }

    @Then("User should see the  the message {string}")
    public void user_should_see_the_the_message(String expectedMessage) {
        String actualMessage = dashboard.getDialogMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User should see the section {string} with list {string},{string},{string},{string}")
    public void user_should_see_the_section_with_list(String subHeading, String line1, String line2, String line3, String line4) {
        Assert.assertTrue(dashboard.verifyLossFeatureSectionDisplayed());
        String actualSectionText = dashboard.getLossFeatureText();
        Assert.assertTrue(actualSectionText.contains(subHeading));
        Assert.assertTrue(actualSectionText.contains(line1));
        Assert.assertTrue(actualSectionText.contains(line2));
        Assert.assertTrue(actualSectionText.contains(line3));
        Assert.assertTrue(actualSectionText.contains(line4));

    }

    @Then("User should see {string} button and {string} button")
    public void user_should_see_button_and_button(String button1, String button2) {
        boolean isButtonsVisible = dashboard.verifyActionButtonsVisible();
        Assert.assertTrue("Expected buttons: " + button1 + " and " + button2 + " to be visible", isButtonsVisible);
    }

    @Then("User should See {string} button with white background and dark text")
    public void user_should_see_button_with_white_background_and_dark_text(String buttonName) {
        String bgColor = dashboard.getKeepPremiumButtonBackgroundColor();
        String textColor = dashboard.getKeepPremiumButtonTextColor();
        Assert.assertTrue("Expected white background, but got: " + bgColor, bgColor.contains("255, 255, 255"));
        int[] rgb = extractRGB(textColor);
        // Calculate luminance: 0 = black, 255 = white
        double luminance = 0.2126 * rgb[0] + 0.7152 * rgb[1] + 0.0722 * rgb[2];
        Assert.assertTrue("Expected dark text, but got: " + textColor + " (luminance=" + luminance + ")",
                luminance < 100);
    }
    // Helper method to extract RGB values from css color string
    private int[] extractRGB(String cssColor) {
        // Remove rgba(...) or rgb(...)
        String[] parts = cssColor.replaceAll("rgba?\\(", "").replaceAll("\\)", "").split(",");
        return new int[] {
                Integer.parseInt(parts[0].trim()),
                Integer.parseInt(parts[1].trim()),
                Integer.parseInt(parts[2].trim())
        };
    }

    @Then("User should see {string} button with red background and white text")
    public void user_should_see_button_with_red_background_and_white_text(String buttonName) {
        String bgColor = dashboard.getCancelPremiumButtonBackgroundColor();
        String textColor = dashboard.getCancelPremiumButtonTextColor();
        Assert.assertTrue("Expected red background, but got: " + bgColor,
                bgColor.contains("220, 38, 38") ||
                        bgColor.contains("200, 0, 0") ||
                        bgColor.contains("239, 68, 68"));
        Assert.assertTrue("Expected white text, but got: " + textColor, textColor.contains("255, 255, 255"));

    }

    @When("User clicks the Keep Premium button")
    public void user_clicks_the_keep_premium_button() {
        LoggerLoad.info("User clicks the Keep Premium button");
        dashboard.clickKeepPremiumButton();
    }

    @Then("User should see success message {string}")
    public void user_should_see_success_message(String expectedMsg) {
        dashboard.clickKeepPremiumButton();
        WebElement successMsgElement = dashboard.getKeepPremiumSuccessMessageElement();
        CommonMethods.scrollToElement(successMsgElement);
        CommonMethods.waitForElementVisibilityOf(successMsgElement);
        String actualMessage = successMsgElement.getText().trim();
        Assert.assertEquals(expectedMsg, actualMessage);
    }

    @When("User clicks the cancel Premium button")
    public void user_clicks_the_cancel_premium_button() {
        LoggerLoad.info("User clicks the Cancel Premium button");
        dashboard.clickCancelPremiumButton();
    }

    @Then("User should see message {string}")
    public void user_should_see_message(String expectedMsg) {
        dashboard.clickCancelPremiumButton();
        WebElement actualMsgElement = dashboard.getCancelPremiumSuccessMessageElement();
        CommonMethods.scrollToElement(actualMsgElement);
        CommonMethods.waitForElementVisibilityOf(actualMsgElement);
        String actualMessage = actualMsgElement.getText().trim();
        Assert.assertEquals(expectedMsg, actualMessage);
    }

    @When("User clicks the X button")
    public void user_clicks_the_x_button() {
        LoggerLoad.info("User clicks the X button");
        dashboard.clickXButton();
    }

    @Then("User should see the dialog box closed")
    public void user_should_see_the_dialog_box_closed() {
        dashboard.clickManagePremiumButton();
        dashboard. verifyDialogClosed();
        LoggerLoad.info("User should see the dialog box closed");
    }

}
