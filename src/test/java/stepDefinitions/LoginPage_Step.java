package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Login_POM;
import utilities.ConfigReader;

public class LoginPage_Step {
	
	ConfigReader reader = new ConfigReader();
	DriverFactory driver = new DriverFactory();
	Login_POM login = new Login_POM();
	WebDriver wedDriver = DriverFactory.getDriver();
	
	
	@Given("User is on SweetBalance homepage")
	public void user_is_on_sweet_balance_homepage() {
	    
	    login.getbaseurl();
	}

	@When("User clicks on {string} link")
	public void user_clicks_on_link(String string) {
	    
	    login.clickLoginButton();
	}

	@Then("User should see {string} heading")
	public void user_should_see_heading(String string) {
	    
		String headingText = login.getloginHeadingText();
	    Assert.assertEquals(string,headingText);
	}

	@Then("User should see {string}")
	public void user_should_see(String string) {
	    
	    login.isSigninAccountText();
	}

	@Then("User should see close button at the right corner")
	public void user_should_see_close_button_at_the_right_corner() {
	    
		Assert.assertTrue("Close button is not visible at the right corner", login.isCloseButtonVisible());
	}

	@Then("User should see an input field to enter email")
	public void user_should_see_an_input_field_to_enter_email() {
	    
	    Assert.assertTrue("Email input feild is not present", login.isEmailInputVisible());
	}

	@Then("User should see text {string} in email field placeholder")
	public void user_should_see_text_in_email_field_placeholder(String string) {
	    
	    String EmailText = login.getEnterEmailPlaceholderText();
	    Assert.assertEquals(string,EmailText);
	    
	}

	@Then("User should see a {string} button")
	public void user_should_see_a_button(String string) {
	    
		Assert.assertTrue("continue email button is not present",login.isContinueEmailButtonVisible());
	}

	@Then("User should see {string} button to be enabled")
	public void user_should_see_button_to_be_enabled(String string) {
	    
		Assert.assertTrue("continue with email button is not enabled",login.isContinueEmailButtonEnabled());
	}

	@Then("User should see a {string} button for login")
	public void user_should_see_a_button_for_login(String string) {
	    
		Assert.assertTrue("continue with google button is not present",login.isContinueGoogleButtonVisible());
	}

	@Then("User should see an {string} separator")
	public void user_should_see_an_separator(String string) {
	    
		Assert.assertTrue("Separator OR is not present",login.isSeparatorOrVisible());
	}

	@Then("User should see {string} message")
	public void user_should_see_message(String string) {
	    
	    String PrivacyPolicyText = login.getPrivacyPolicyMessage();
		Assert.assertEquals(string, PrivacyPolicyText);
	}
	
//	-----------------------------------Login page feild functional validation--------------------------------------------------------------

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	   
	    login.getloginurl();
	}

	@When("Registered user clicks continue with email button after entering a valid existing email")
	public void registered_user_clicks_continue_with_email_button_after_entering_a_valid_existing_email() {
	   
	    login.enterEmail();
	    login.clickContinueWithEmail();
	}

	@Then("User should get password field")
	public void user_should_get_password_field() {
	   
		Assert.assertTrue("Password field is not present",login.isPasswordFieldVisible());
	}

	@When("User enters an invalid email")
	public void user_enters_an_invalid_email() {
	   
	    login.enterInvalidEmail();
	    login.clickContinueWithEmail();
	}

	@Then("Email field should show validation error")
	public void email_field_should_show_validation_error() {
	   
	   String actualErrorText = login.getInvalidErrorMessage();
	   String expectedError = "Please enter a valid email address";
	   Assert.assertEquals(expectedError,actualErrorText);
	}

	@When("Registered user clicks continue with email button after entering a valid email")
	public void registered_user_clicks_continue_with_email_button_after_entering_a_valid_email() {
	   
		login.enterEmail();
	    login.clickContinueWithEmail();
	}

	@Then("User should see Sign in button")
	public void user_should_see_sign_in_button() {
	   
		Assert.assertTrue("Sign in button is not present",login.isSigninButtonVisible());
	}

	@When("User clicks continue with email button after entering a valid email")
	public void user_clicks_continue_with_email_button_after_entering_a_valid_email() {
	   
		login.enterEmail();
	    login.clickContinueWithEmail();
	}

	@Then("User should see email id  in sub text")
	public void user_should_see_email_id_in_sub_text() {
	   
	    String emailText = login.isEmailSubtextVisible();
	    String expectedEmailText = ConfigReader.loginEmail();
	    Assert.assertEquals(expectedEmailText,emailText);
	    
	}

	@Then("User should see {string} link")
	public void user_should_see_link(String string) {
	   
		Assert.assertTrue("Forgot Password link is not present",login.isForgotPasswordLinkVisible());
	}

	@Then("User should see text {string} as placeholder in password field")
	public void user_should_see_text_as_placeholder_in_password_field(String string) {
	   
		 String PasswordText = login.getEnterPasswordPlaceholder();
		    Assert.assertEquals(string,PasswordText);
	}

	@When("Registered user clicks sign in after entering password")
	public void registered_user_clicks_sign_in_after_entering_password() {
	   
		login.enterEmail();
	    login.clickContinueWithEmail();
		login.enterPassword();
	    login.clickSigninButton();
	}

	@Then("User should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	   
		String expectedHomeUrl  = ConfigReader.homeUrl();
		WebDriverWait wait = new WebDriverWait(wedDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(expectedHomeUrl));
		String actualHomeUrl  = login.getHomeURL();
		System.out.println("Expected URL: " + expectedHomeUrl);
		System.out.println("Actual URL: " + actualHomeUrl);
		Assert.assertEquals(expectedHomeUrl,actualHomeUrl);
	}

	@When("Unregistered user clicks continue with email button after entering a valid new email")
	public void unregistered_user_clicks_continue_with_email_button_after_entering_a_valid_new_email() {
	   
	    login.enterNewEmail();
	    login.clickContinueWithEmail();
	}

	@Then("User should get {string}  form")
	public void user_should_get_form(String string) {
	   
		Assert.assertTrue("Complete your profile is not present",login.isCompleteYourProfileVisible());
	}
	
	@When("User clicks continue with email button after entering a valid new email")
	public void user_clicks_continue_with_email_button_after_entering_a_valid_new_email() {
	    
		login.enterNewEmail();
		login.clickContinueWithEmail();
	}

	@Then("{string} input field should be displayed")
	public void input_field_should_be_displayed(String inputfield) {
	    
		boolean fieldVisible = false;
		switch(inputfield) {
		case "Full Name" : fieldVisible = login.isFullnameInputfieldVisible();break;
		case "Username" : fieldVisible = login.isUsernameInputfieldVisible();break;
		case "Password" : fieldVisible = login.isPasswordInputFieldVisible();break;
		default:
		}
		
		Assert.assertTrue(inputfield+ "Inputs fields are not present",fieldVisible);
		
	}

	@Then("Terms & Conditions checkbox should be displayed")
	public void terms_conditions_checkbox_should_be_displayed() {
	   
		Assert.assertTrue("Terms and conditions checkbox is not present",login.istermsAndConditionsCheckboxVisible());
	}

	@Then("{string} button should be disabled")
	public void button_should_be_disabled(String string) {
	   
		Assert.assertFalse("Create account button is enabled",login.iscreateAccountButtonEnabled());
	}
	
//------------------------------------Login profile form--------------------------------------------------------------------------------
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    
		login.getbaseurl();
		login.clickLoginButton();
	}

	@When("User enters a valid new email and clicks continue with email button")
	public void user_enters_a_valid_new_email_and_clicks_continue_with_email_button() {
	    
	   login.enterNewEmail();
	   login.clickContinueWithEmail();
	}

	@Given("User is on complete profile form page")
	public void user_is_on_complete_profile_form_page() {
	    
	    System.out.println("User is on complete profile form");
	}

	@When("User checks the Terms & conditions box after filling all fields from {string} and {string}.")
	public void user_checks_the_terms_conditions_box_after_filling_all_fields_from_and(String testcase, String sheetname) throws IOException {
	    
		login.navigateBack();
		login.clickLoginButton();
		login.readEmailFromSheet(testcase, sheetname);
		login.clickContinueWithEmail();
	    login.readDataFromSheet(testcase, sheetname);
	    login.clickTermsAndConditionsCheckbox();
	}

	@Then("{string} button should be enabled")
	public void button_should_be_enabled(String string) {
	    
		Assert.assertTrue("Create account button is diabled",login.iscreateAccountButtonEnabled());
	}

	@When("User clicks create account button after filling valid data in all fields from {string} and {string}.")
	public void user_clicks_create_account_button_after_filling_valid_data_in_all_fields_from_and(String testcase, String sheetname) throws IOException {
	   
		login.navigateBack();
		login.clickLoginButton();
		login.readEmailFromSheet(testcase, sheetname);
		login.clickContinueWithEmail();
		login.readDataFromSheet(testcase, sheetname);
		 login.clickTermsAndConditionsCheckbox();
		 login.clickCreateAccountButton();
		    
	}

	@Then("User should redirected to upload blood report")
	public void user_should_redirected_to_upload_blood_report() {
	    
		String expectedUrl  = ConfigReader.uploadBloodReportURL();
		WebDriverWait wait = new WebDriverWait(wedDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		String actualUrl = login.getBloodReportURL();
		System.out.println("Expected URL: " + expectedUrl);
		System.out.println("Actual URL: " + actualUrl);
		Assert.assertEquals(expectedUrl,actualUrl);
		
	}

	@When("User clicks create account button after filling invalid data from {string} and {string}.")
	public void user_clicks_create_account_button_after_filling_invalid_data_from_and(String testcase, String sheetname) throws IOException {
	    
		login.navigateBack();
		login.clickLoginButton();
		login.readEmailFromSheet(testcase, sheetname);
		login.clickContinueWithEmail();
		 login.readDataFromSheet(testcase, sheetname);
		 login.clickTermsAndConditionsCheckbox();
		 login.clickCreateAccountButton();
	}

	@Then("User should see error message")
	public void user_should_see_error_message() {
	    
		String expectedErrorMessage = login.getFullnameErrorMessage();
		String actualMessage = "Full name can only contain letters, spaces, hyphens and apostrophes";
		Assert.assertEquals(actualMessage,expectedErrorMessage);
		String expectedUserErrorMessage = login.getUsernameErrorMessage();
		String actualUserErrorMessage = "Username can only contain letters, numbers, underscores and hyphens";
		Assert.assertEquals(actualUserErrorMessage,expectedUserErrorMessage);
	    
	}
	
	
	@When("User clicks create account button after filling valid data in all fields from {string} and {string} for blood report")
	public void user_clicks_create_account_button_after_filling_valid_data_in_all_fields_from_and_for_blood_report(String testcase, String sheetname) throws IOException {
	    
		login.navigateBack();
		login.clickLoginButton();
		login.readEmailFromSheet(testcase, sheetname);
		login.clickContinueWithEmail();
		login.readDataFromSheet(testcase, sheetname);
		 login.clickTermsAndConditionsCheckbox();
		 login.clickCreateAccountButton();
	}

	@Then("User should see Upload Blood Report button")
	public void user_should_see_upload_blood_report_button() {
	    
		Assert.assertTrue("Blood report button is visible",login.isUploadBloodReportVisible());
	}
	
	@When("User clicks create account button after filling valid data in all fields from {string} and {string} for onboarding.")
	public void user_clicks_create_account_button_after_filling_valid_data_in_all_fields_from_and_for_onboarding(String sheetname, String testcase) throws IOException {
	    
		login.navigateBack();
		login.clickLoginButton();
		login.readEmailFromSheet(sheetname, testcase);
		login.clickContinueWithEmail();
		login.readDataFromSheet(sheetname, testcase);
		 login.clickTermsAndConditionsCheckbox();
		 login.clickCreateAccountButton();
	}

	@Then("User should see Step Through Onboarding button")
	public void user_should_see_step_through_onboarding_button() {
	    
		Assert.assertTrue("Steps through onboarding button is visible",login.isStepsThroughOnboardingButtonVisible()); 
	}
	
	
//------------------------------------------------Onboarding Step 1 UI validation-----------------------------------------------------------------------------
	
	@Given("User is on complete profile form page for uploading blood report")
	public void user_is_on_complete_profile_form_page_for_uploading_blood_report() {
	    
		login.getbaseurl();
		login.clickLoginButton();
		login.enterNewEmail();
		login.clickContinueWithEmail();
	}

	@When("User fills out all fields and submits the profile form")
	public void user_fills_out_all_fields_and_submits_the_profile_form() {
	    
//	    login.enterOnboardingFullname();
//	    login.enterOnboardingUsername();
//	    login.enterOnboardingPassword();
//	    login.clickSigninButton();
//	    login.clickTermsAndConditionsCheckbox();
//		login.clickCreateAccountButton();
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
		
	}

	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() {
	    
	    System.out.println("User is on the blood report page");
	}

	@When("User clicks on step for onboarding button")
	public void user_clicks_on_step_for_onboarding_button() {
	    
//	    login.clickStepsThroughOnboardingButton();
	}

	@Then("User should navigate to onboarding Step {int}")
	public void user_should_navigate_to_onboarding_step(Integer int1) {
	    
		String expectedUploadUrl  = ConfigReader.onboardingURL();
		WebDriverWait wait = new WebDriverWait(wedDriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe(expectedUploadUrl));
		String actualUrl = login.getOnboardingReportUrl();
		System.out.println("Expected URL: " + expectedUploadUrl);
		System.out.println("Actual URL: " + actualUrl);
		Assert.assertEquals(expectedUploadUrl,actualUrl);
	    
	}

	@Then("Page should display title \"So, Which sugar rebellion are we dealing with?'")
	public void page_should_display_title_so_which_sugar_rebellion_are_we_dealing_with() {
		
		Assert.assertTrue("Sugar rebellion is not present",login.isSugarRebillionVisible());
	}

	@Then("Page should have sub text {string}")
	public void page_should_have_sub_text(String string) {
	
		Assert.assertTrue("Sub text is not present",login.isTailorPlanSubtextVisible());
	}

	@Then("Progress bar should visually indicate {string}")
	public void progress_bar_should_visually_indicate(String string) {

		Assert.assertTrue("progress bar is not present",login.isProgessbarStepsVisible());
	}

	@Then("Step {int} indicator should be highlighted")
	public void step_indicator_should_be_highlighted(Integer int1) {
	    
		Assert.assertTrue("Steps indicator is not present",login.isStep1IndicatorVisible()); 
	}

	@Then("User should see an option labeled  {string}")
	public void user_should_see_an_option_labeled(String string) {
	    
		Assert.assertTrue("type 2 option is not present",login.isOptionType2SugarRebellionVisible());
		Assert.assertTrue("I dont know option is not present",login.isOption2OfSugarRebellionVisible());
	}
	
//----------------------------------------------Onboarding Step2 ----------------------------------------------
	
	@Given("User is on the upload page")
	public void user_is_on_the_upload_page() {
	    
		login.getbaseurl();
		login.clickLoginButton();
		login.enterNewEmail();
		login.clickContinueWithEmail();
	}

	@When("User clicks onboarding button and goes to step {int}")
	public void user_clicks_onboarding_button_and_goes_to_step(Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in step {int}")
	public void user_is_in_step(Integer stepNumber) {
	    
		if(stepNumber == 1) {
	    	System.out.println("User is on Step1");
	    }
	    else {
	    	System.out.println("User is on step 2");
	    }
	}

	@When("User selects the condition in step {int}")
	public void user_selects_the_condition_in_step(Integer int1) {
	    
		login.clickOptionInStep1();
	}

	@Then("User should navigate to step {int}")
	public void user_should_navigate_to_step(Integer stepNumber) throws TimeoutException {
	    
//		String actualStep2text = login.getStep2Text();
//		Assert.assertEquals(actualStep2text,stepNumber);
		Assert.assertTrue("Page is not on Step 1", login.isstep1TitleVisible());
	}

	@Then("User should receive message {string}")
	public void user_should_receive_message(String expectedMessage) {
	    
		String actualMessage = login.getStep1Message();
////    String expectedMessage = "No worries, we're here to figure it out together! 🔍";
        Assert.assertEquals(actualMessage,expectedMessage);
	}

	@Then("User should see back button in step {int} of onboarding")
	public void user_should_see_back_button_in_step_of_onboarding(Integer int1) throws TimeoutException {
	    
		Assert.assertTrue("Bach button is not present",login.isBackButtonVisible());
	}

	@Then("Page should display title {string}")
	public void page_should_display_title(String title) {
	    
		String actualTitle = login.getStep2Title();
	    Assert.assertEquals(actualTitle,title);
	}

	@Then("Page should have sub text {string} visible")
	public void page_should_have_sub_text_visible(String subText) {
	    
		Assert.assertTrue("step2 is not present",login.isStep2SubTextVisible());
	}

	@Then("Step  indicator should be highlighted")
	public void step_indicator_should_be_highlighted() {
	    
		Assert.assertTrue("Steps indicator is not present",login.isStep1IndicatorVisible());
	}

	@Then("Progress bar should visually indicate {string} below progress bar")
	public void progress_bar_should_visually_indicate_below_progress_bar(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}

	@Then("User should see options labeled {string}{string}{string}")
	public void user_should_see_options_labeled(String option1, String option2, String option3) {
	    
		List<String> actualOptions = login.getGenderOptions();
		List<String> ExpextedgenderOptions = new ArrayList<>(Arrays.asList("Male 👨‍🦱, Female 👩‍🦰, Other ⚧️"));
	    Assert.assertEquals(ExpextedgenderOptions,actualOptions);

	}
	
//------------------------------------Onboarding Step3-------------------------------------------------------------------------

	@When("User goes to step {int} after clicking onboarding button and completes step {int}")
	public void user_goes_to_step_after_clicking_onboarding_button_and_completes_step(Integer int1, Integer int2) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@When("User clicks back button in step {int}")
	public void user_clicks_back_button_in_step(Integer int1) {
	    
	    login.clickBackButton();
	}

	@Then("User should redirected to step {int}")
	public void user_should_redirected_to_step(Integer stepNumber) {
	    
		Assert.assertTrue("Page is not on Step 1", login.isstep1TitleVisible());
	}

	@When("User selects a gender  in step {int}")
	public void user_selects_a_gender_in_step(Integer int1) {
	    
	   login.selectFemaleOption();
	}

	@Then("User should navitae to step {int}")
	public void user_should_navitae_to_step(Integer stepNumber) {
	    
		Assert.assertTrue("Page is not on Step 3" , login.isstep3TitleVisible());
	}

	@Then("Page should display title {string} here")
	public void page_should_display_title_here(String step3Title) {
	    
		String actualTitle = login.getStep3Title();
	    Assert.assertEquals(actualTitle,step3Title);
	}

	@Then("User should see sub text {string}")
	public void user_should_see_sub_text(String step3SubText) {
	    
		String actualSubtext = login.getStep3Subtext();
	    Assert.assertEquals(actualSubtext,step3SubText);
	}

	@Then("Progress bar should visually indicate {string} of step three")
	public void progress_bar_should_visually_indicate_of_step_three(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}

	@Then("Back button should be visible")
	public void back_button_should_be_visible() throws TimeoutException {
	    
		Assert.assertTrue("Back button is not present",login.isBackButtonVisible());
	}

	@Then("iframe options should have scroll option")
	public void iframe_options_should_have_scroll_option() {
	    Assert.assertTrue(login.isScrollableAgeContainerVisible());
	}

	@Then("User should see options for age {string}")
	public void user_should_see_options_for_age(String string) {
	    
		Assert.assertTrue("Age options are incomplete", login.isageOptionsVisible());
	}
	
//--------------------------------------------------Onboarding Step4---------------------------------------------------------
	
	@When("User clicks options to step {int} and {int}")
	public void user_clicks_options_to_step_and(Integer int1, Integer int2) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@When("User selects any age option in step {int}")
	public void user_selects_any_age_option_in_step(Integer ageGroup) {
	    login.clickAge();
	}
	
	@Then("User should navitae to step {int} age group")
	public void user_should_navitae_to_step_age_group(Integer int1) {
		Assert.assertTrue("Back button is not present",login.isstep4TitleVisible());
	}

	@When("User selects age option between {string}")
	public void user_selects_age_option_between(String ageGroup) {
		int ageToSelect;

	    switch (ageGroup.toLowerCase()) {
	        case "18-29":
	            ageToSelect = 25;
	            break;
	        case "30-49":
	            ageToSelect = 35;
	            break;
	        case "above 50":
	            ageToSelect = 60;
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid age group: " + ageGroup);
	    }

	    login.selectAgeOption(ageToSelect);
	    
	}

	@Then("User should see notification message {string}")
	public void user_should_see_notification_message(String string) {
	    
	    String actualMessage = login.getOptionMessage();
	    Assert.assertEquals(actualMessage,string);
	}
	
	@Then("User should redirected to step {int} from Step {int}")
	public void user_should_redirected_to_step_from_Step(Integer expectedStep, Integer fromStep) {
	    
		Assert.assertTrue("Page is not on Step 2", login.isstep2TitleVisible());
	}

	
	@Then("Page should display title {string} of step {int}")
	public void page_should_display_title_of_step(String string, Integer int1) {
		Assert.assertTrue("Page is not on Step 4" , login.isstep4TitleVisible());
	}
	
	@Then("User should see sub text {string} in step {int}")
	public void user_should_see_sub_text_in_step(String step4SubText, Integer int1) {
		String actualSubtext = login.getStep4Subtext();
	    Assert.assertEquals(actualSubtext,step4SubText);
	}
	
	@Then("Back button should be visible in step {int}")
	public void back_button_should_be_visible_in_step(Integer int1) throws TimeoutException {
	    
		Assert.assertTrue("Back button is not present",login.isBackButtonVisible());
	}

	@Then("The {int} tab option should be present")
	public void the_tab_option_should_be_present(Integer int1) {
	    
		List<String> actualTabOptions = login.getTabOptions();
		List<String> ExpextedTabOptions = new ArrayList<>(Arrays.asList("Centimeters", "Feet & Inches"));
	    Assert.assertEquals(ExpextedTabOptions,actualTabOptions);
		
		
	}

	@Then("The 1st tab should have Centimeters")
	public void the_1st_tab_should_have_centimeters() {
		String actual1TabText = login.getCentimeterTab();
		String expectedText = "Centimeters";
	    Assert.assertEquals(actual1TabText,expectedText); 
		
	}

	@Then("The 2nd tab should have Feet & Inches")
	public void the_2nd_tab_should_have_feet_inches() {
		String actual2TabText = login.getFeetAndInchesTab();
	    String expectedText = "Feet & Inches";
	    Assert.assertEquals(expectedText, actual2TabText);
	    
	}

	@Then("Centimeters option should have {int} to {int} cm")
	public void centimeters_option_should_have_to_cm(Integer int1, Integer int2) {
	    
		Assert.assertTrue("Height options are incomplete", login.isHeightOptionsVisible());
	}

	@Then("Inches options should have {int}'{int}\" to {int}\"{int}\".")
	public void inches_options_should_have_to(Integer int1, Integer int2, Integer int3, Integer int4) {
	    login.clickInchesTab();
		Assert.assertTrue("Inches options are incomplete", login.isInchesHeightOptionsVisible()); 
	}
	
//---------------------------------------------Onboarding Step5-----------------------------------------
	
	@When("User clicks options of step {double} and {int} to navigate to step {int}")
	public void user_clicks_options_of_step_and_to_navigate_to_step(Double double1, Integer int1, Integer int2) {
	   
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in Step four")
	public void user_is_in_step_four() {
	   
	   System.out.println("User is in Step 4");
	}

	@When("User selects a height option greater than {int} cm")
	public void user_selects_a_height_option_greater_than_cm(Integer int1) {
	   
	   login.clickHeightOptionAbove180();
	}

	@Then("User should see notification {string}")
	public void user_should_see_notification(String string) {
	   
		String actualMessage = login.getOptionMessage();
	    Assert.assertEquals(actualMessage,string);
	}

	@When("User selects a height option less than {int}")
	public void user_selects_a_height_option_less_than(Integer int1) {
	   
	   login.clickHeightOptionLess159();
	}

	@When("User selects a height option between {int}-{int}")
	public void user_selects_a_height_option_between(Integer int1, Integer int2) {
	   
	   login.clickHeightOptionLess160to179();
	}

	@When("User selects from options available in centimeters")
	public void user_selects_from_options_available_in_centimeters() {
	   
	   login.clickSelectHeight();
	}

	@Then("User should redirect to Step five")
	public void user_should_redirect_to_step_five() {
	   
		Assert.assertTrue("Page is not on Step 5" , login.isstep5TitleVisible());
	}

	@When("User selects from options available in feet & inches")
	public void user_selects_from_options_available_in_feet_inches() {
	   login.clickInchesTab();
	   login.clickHeightInFeetInches(5, 4);
	}

	@When("User clicks back button in step four")
	public void user_clicks_back_button_in_step_four() {
	   
	   login.clickBackButton();
	}

	@Then("User should redirected to step three")
	public void user_should_redirected_to_step_three() {
	   
		Assert.assertTrue("Page is not on Step 3" , login.isstep3TitleVisible());
	}

	@Then("Page should display title {string} for weight")
	public void page_should_display_title_for_weight(String string) {
	   
//		Assert.assertTrue("Page is not on Step 5" , login.isstep5TitleVisible());
		String actualTitle = login.getStep5Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see sub text {string} for weight")
	public void user_should_see_sub_text_for_weight(String step5SubText) {
	   
		String actualSubtext = login.getStep5Subtext();
	    Assert.assertEquals(actualSubtext,step5SubText);
	}

	@Then("Progress bar should visually indicate {string} of step five")
	public void progress_bar_should_visually_indicate_of_step_five(String steps) {
	   
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}

	@Then("Back button should be visible in step five")
	public void back_button_should_be_visible_in_step_five() throws TimeoutException {
	   
		Assert.assertTrue("Back button is not present",login.isBackButtonVisible());
	}

	@Then("{int} tab option should be present")
	public void tab_option_should_be_present(Integer int1) {
	   
		List<String> actualTabOptions = login.getWeightTabOptions();
		List<String> ExpextedTabOptions = new ArrayList<>(Arrays.asList("Kilograms", "Pounds"));
	    Assert.assertEquals(ExpextedTabOptions,actualTabOptions);
	}

	@Then("1st tab should have Kilograms")
	public void st_tab_should_have_kilograms() {
	   
		String actual1TabText = login.getKilogramsTabText();
		String expectedText = "Kilograms";
	    Assert.assertEquals(actual1TabText,expectedText);
	}

	@Then("2nd tab should have Pounds")
	public void nd_tab_should_have_pounds() {
	   
		String actual2TabText = login.getPoundsTabText();
		String expectedText = "Pounds";
	    Assert.assertEquals(actual2TabText,expectedText);
	}

	@Then("Kilogram option should have {int} to {int} kg")
	public void kilogram_option_should_have_to_kg(Integer int1, Integer int2) {
	   
		Assert.assertTrue("Kilograms options are incomplete", login.isKilogramsOptionsVisible());
	}

	@Then("Pounds options should have {int} to {int} lbs")
	public void pounds_options_should_have_to_lbs(Integer int1, Integer int2) {
	   login.clickPoundsTab();
		Assert.assertTrue("Pounds tab is not present",login.isPoundsOptionsVisible());
	}
	
//-------------------------------------------------Onboarding Step6--------------------------------------------------
	
	@When("User clicks options of step {double} and {int} to navigate to step five")
	public void user_clicks_options_of_step_and_to_navigate_to_step_five(Double double1, Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in step five")
	public void user_is_in_step_five() {
	    
		System.out.println("User is in Step 5");
	}

	@When("User selects a weight option less than {int}")
	public void user_selects_a_weight_option_less_than(Integer int1) {
	    
	   login.clickKilogramsOptionLessThan59(); 
	}

	@Then("User should see notification text {string}")
	public void user_should_see_notification_text(String string) {
	    
		String actualMessage = login.getOptionMessage();
	    Assert.assertEquals(actualMessage,string);
	}

	@When("User selects a weight option between {int} {int}")
	public void user_selects_a_weight_option_between(Integer int1, Integer int2) {
	    
	    login.clickKilogramsOptionBetween60to84();
	}

	@When("User selects a weight option greater than {int}")
	public void user_selects_a_weight_option_greater_than(Integer int1) {
	    
	    login.clickKilogramsOptionAbove85();
	}

	@When("User selects from options available in kilogram")
	public void user_selects_from_options_available_in_kilogram() {
	    
	    login.clickSelectKilogramOption();
	}

	@Then("User should redirect to Step six")
	public void user_should_redirect_to_step_six() {
	    
		Assert.assertTrue("Page is not on Step 6" , login.isstep6TitleVisible());
	}

	@When("User clicks back button in step five")
	public void user_clicks_back_button_in_step_five() throws TimeoutException {
	    
		login.clickBackButton();
	}
	
	@Then("User should redirect to Step four")
	public void user_should_redirect_to_step_four() {
		Assert.assertTrue("Page is not on Step 4" , login.isstep4TitleVisible()); 
	}

	@When("User selects from options available in pound")
	public void user_selects_from_options_available_in_pound() {
	    
	    login.clickPoundsTab();
	    login.clickSelectPoundOptions();
	}

	@Then("User should redirected to step four")
	public void user_should_redirected_to_step_four() {
	    
		Assert.assertTrue("Page is not on Step 4" , login.isstep4TitleVisible());
	}

	@Then("Page should display title {string} of Step six")
	public void page_should_display_title_of_step_six(String string) {
	    
		String actualTitle = login.getStep6Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see sub text {string} of step six")
	public void user_should_see_sub_text_of_step_six(String step6SubText) {
	    
		String actualSubtext = login.getStep6Subtext();
	    Assert.assertEquals(actualSubtext,step6SubText);
	}

	@Then("Progress bar should visually indicate {string} of step six")
	public void progress_bar_should_visually_indicate_of_step_six(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}

	@Then("Back button should be visible in step six")
	public void back_button_should_be_visible_in_step_six() throws TimeoutException {
	    
		Assert.assertTrue("Back button is not present",login.isBackButtonVisible());
	}

	@Then("User should see options labeled {string} for step six")
	public void user_should_see_options_labeled_for_step_six(String string) {
		List<String> actualOptions = login.getTasteBudOptions();
		List<String> ExpextedOptions = new ArrayList<>(Arrays.asList("All-inclusive diet 🍴🍖🍎", "Vegetarian 🥗🍆🥕", "Vegan 🥬🌱🌿"));
	    Assert.assertEquals(ExpextedOptions,actualOptions); 
	    
	}
	
//--------------------------------------------Onboarding Step7----------------------------------------------------------------------------

	@When("User clicks options of steps {double} and {int} to navigate to step six")
	public void user_clicks_options_of_steps_and_to_navigate_to_step_six(Double double1, Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in step six")
	public void user_is_in_step_six() {
	    
	    System.out.println("User is on the Step 6");
	}

	@When("User selects from the options in step six")
	public void user_selects_from_the_options_in_step_six() {
	    
	    login.clickSelectTasteBud();
	}

	@Then("User should redirect to step seven")
	public void user_should_redirect_to_step_seven() {
	    
		Assert.assertTrue("Page is not on Step 7" , login.isstep7TitleVisible());
	}

	@Then("User should see options {string} in step seven")
	public void user_should_see_options_in_step_seven(String string) {
	    
		List<String> actualOptions = login.getTasteBudOptions();
		List<String> ExpextedOptions = new ArrayList<>(Arrays.asList("Indian 🍛, American 🍔, Continental 🥖, Mediterranean 🥙, Asian 🍜, Middle Eastern 🥙, Mexican 🌮"));
	    Assert.assertEquals(ExpextedOptions,actualOptions); 
	}

	@Then("User should see title_1 {string}")
	public void user_should_see_title(String string) {
	    
		String actualTitle = login.getStep7Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see subtext {string} of step seven")
	public void user_should_see_subtext_of_step_seven(String step7SubText) {
	    
		String actualSubtext = login.getStep7Subtext();
	    Assert.assertEquals(actualSubtext,step7SubText);
	}

	@Then("Progress bar should visually indicate {string} of step seven")
	public void progress_bar_should_visually_indicate_of_step_seven(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}

	@Then("User should see the back button in left down corner of the page")
	public void user_should_see_the_back_button_in_left_down_corner_of_the_page() throws TimeoutException {
	    
		Assert.assertTrue("Back button is not present",login.isBackButtonVisible());
	}
	
//-----------------------------------Onboarding Step8------------------------------------------------------------------
	
	@When("User clicks options upto step {int} to navigate to step seven")
	public void user_clicks_options_upto_step_to_navigate_to_step_seven(Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();
	        login.clickSelectTasteBud();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@When("User selects from one of the cuisine options in step {int}")
	public void user_selects_from_one_of_the_cuisine_options_in_step(Integer int1) {
	    
	    login.clickSelectFoodOption();
	}

	@Then("User should see options yes ✅ ,No❌ in step {int}")
	public void user_should_see_options_yes_no_in_step(Integer int1) {
	    
		List<String> actualOptions = login.getTasteBudOptions();
		List<String> expectedOptions = Arrays.asList("Yes ✅", "No ❌");
	    Assert.assertEquals(expectedOptions,actualOptions);
	}

	@Then("User should see title {string} of step eight")
	public void user_should_see_title_of_step_eight(String string) {
	    
		String actualTitle = login.getStep8Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see subtext {string} of step eight.")
	public void user_should_see_subtext_of_step_eight(String step8SubText) {
	    
		String actualSubtext = login.getStep8Subtext();
	    Assert.assertEquals(actualSubtext,step8SubText);
	}

	@Then("Progress bar should visually indicate {string} in step eight")
	public void progress_bar_should_visually_indicate_in_step_eight(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}
	
//--------------------------------------------Onboarding Step9------------------------------------------------------------
	
	@When("User clicks options upto step {int} to navigate to step eight")
	public void user_clicks_options_upto_step_to_navigate_to_step_eight(Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();
	        login.clickSelectTasteBud();
	        login.clickSelectFoodOption();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in step eight")
	public void user_is_in_step_eight() {
	    
	    System.out.println("User is on Step 8");
	}

	@When("User select option yes")
	public void user_select_option_yes() {
	    
	    login.clickSelectAllergyYesOption();
	}

	@Then("User should see options Dairy, Gluten,Nuts,Shellfish,Soy,Eggs,Other,None in step {int}")
	public void user_should_see_options_dairy_gluten_nuts_shellfish_soy_eggs_other_none_in_step(Integer int1) {
	    
		List<String> actualOptions = login.getTasteBudOptions();
		List<String> expectedOptions = Arrays.asList("Dairy 🐄🥛", "Gluten 🥖🍞", "Nuts 🌰🥜", "Shellfish 🐚🍤", "Soy 🫘🥡", "Eggs 🍳🥚", "Other 🍽️🥴", "None");
	    Assert.assertEquals(expectedOptions,actualOptions);
	}

	@When("User select option no")
	public void user_select_option_no() {
	    
	    login.clickSelectAllergyNoOption();
	}

	@Then("User should be in step ten")
	public void user_should_be_in_step_ten() {
	    
		Assert.assertTrue("Page is not on Step 10" , login.isstep10TitleVisible());
	}

	@When("User select option yes  in step {int}")
	public void user_select_option_yes_in_step(Integer int1) {
	    
	    login.clickSelectAllergyYesOption();
	}

	@Then("User should see the title_1 {string}")
	public void user_should_see_the_title_1(String string) {
	    
		String actualTitle = login.getStep9Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see subtext {string}")
	public void user_should_see_subtext(String step9SubText) {
	    
		String actualSubtext = login.getStep9Subtext();
	    Assert.assertEquals(actualSubtext,step9SubText);
	}

	@Then("Progress bar should visually indicate {string} of step nine")
	public void progress_bar_should_visually_indicate_of_step_nine(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps); 
	}
	
//--------------------------------------------Onboarding Step10-----------------------------------------------
	
	@When("User clicks options upto step {int} to navigate to step ten by clicks No button")
	public void user_clicks_options_upto_step_to_navigate_to_step_ten_by_clicks_no_button(Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();
	        login.clickSelectTasteBud();
	        login.clickSelectFoodOption();
	        

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in Step ten")
	public void user_is_in_step_ten() {
	    
	    System.out.println("User is on Step 10");
	}

	@When("User clicks No button")
	public void user_clicks_no_button() {
	    
	    login.clickSelectAllergyNoOption();
	}

	@Then("User should see the option in step ten {string}")
	public void user_should_see_the_option_in_step_ten(String string) {
	    
		List<String> expectedOptions = Arrays.stream(string.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

		List<String> actualOptions = login.getMedicalptions().stream()
		.map(opt -> opt.replaceAll("\\s+", " ").trim())  // normalize spaces and newlines
		.collect(Collectors.toList());
		
		List<String> normalizedExpected = expectedOptions.stream()
		.map(opt -> opt.replaceAll("\\s+", " ").trim())
		.collect(Collectors.toList());
		
		Assert.assertEquals(normalizedExpected, actualOptions);
	}

	@Then("User should see subtext {string} of Step ten.")
	public void user_should_see_subtext_of_step_ten(String step10SubText) {
	    
		String actualSubtext = login.getStep10Subtext();
	    Assert.assertEquals(actualSubtext,step10SubText);
	}

	@Then("Progress bar should visually indicate {string} of step ten")
	public void progress_bar_should_visually_indicate_of_step_ten(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}
	
//-----------------------------------------Onboarding Step9 & step 10--------------------------------------------------------
	
	@When("User clicks options upto step {int} to navigate to step nine and clicks Yes button")
	public void user_clicks_options_upto_step_to_navigate_to_step_nine_and_clicks_yes_button(Integer int1) {
	   
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();
	        login.clickSelectTasteBud();
	        login.clickSelectFoodOption();
	        login.clickSelectAllergyYesOption();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	}

	@Given("User is in Step nine")
	public void user_is_in_step_nine() {
	   System.out.println("USer is on step 9");
	}

	@When("User clicks continue button by selecting allergy option")
	public void user_clicks_continue_button_by_selecting_allergy_option() {
	   
		login.clickSelectAllergyFood();
		login.clickContinueButton();
	}
	
//--------------------------------------------------OnBoarding Step 11---------------------------------------------
	
	@When("User clicks options upto step {int} to navigate to step ten by clicks No button in Step nine")
	public void user_clicks_options_upto_step_to_navigate_to_step_ten_by_clicks_no_button_in_step_nine(Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();
	        login.clickSelectTasteBud();
	        login.clickSelectFoodOption();
	        login.clickSelectAllergyNoOption();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	    
	}
	@When("User checks more than one checkbox")
	public void user_checks_more_than_one_checkbox() {
	    
	   login.clickSelectMedicalOption1();
	   login.clickSelectMedicalOption2();
	}

	@Then("User should see multiple checkbox selected")
	public void user_should_see_multiple_checkbox_selected() {
	    
		Assert.assertTrue("Multiple checkboxes are not selected" , login.isMultipleCheckboxSelectedVisible());
	}

	@When("User clicks continue in step ten")
	public void user_clicks_continue_in_step_ten() {
	   login.clickSelectMedicalOption1(); 
	   login.clickContinueButton();
	}

	@Then("User should see options {string},{string},{string} in step ten")
	public void user_should_see_options_in_step_ten(String string, String string2, String string3) {
	    
		List<String> actualOptions = login.getExeciseLevelOptions();
		List<String> expectedOptions = Arrays.asList("Easy 🦋", "Medium 💪", "Hard 🔥");
	    Assert.assertEquals(expectedOptions,actualOptions);
	}

	@Then("User should see title {string} of step eleven.")
	public void user_should_see_title_of_step_eleven(String string) {
	    
		String actualTitle = login.getStep11Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see subtext {string} of step {int}")
	public void user_should_see_subtext_of_step(String step11SubText, Integer int1) {
	    
		String actualSubtext = login.getStep11Subtext();
	    Assert.assertEquals(actualSubtext,step11SubText);
	}

	@Then("Progress bar should visually indicate {string} for step eleven.")
	public void progress_bar_should_visually_indicate_for_step_eleven(String steps) {
	    
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	}
	
//------------------------------------------------Onboarding Step12--------------------------------------------------
	
	@When("User clicks options upto step {int} to navigate to step twelve")
	public void user_clicks_options_upto_step_to_navigate_to_step_twelve(Integer int1) {
	    
		if (login.isFullnameInputfieldVisible()) {
	        System.out.println("New user detected");

	        login.enterOnboardingFullname();
	        login.enterOnboardingUsername();
	        login.enterOnboardingPassword();
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();
	        login.clickStepsThroughOnboardingButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("Existing user detected");

	        login.enterOnboardingPassword();
	        login.clickSigninButton();
	        login.clickOptionInStep1();
	        login.selectFemaleOption();
	        login.clickAge();
	        login.clickInchesTab();
	        login.clickHeightInFeetInches(5, 4);
	        login.clickSelectKilogramOption();
	        login.clickSelectTasteBud();
	        login.clickSelectFoodOption();
	        login.clickSelectAllergyNoOption();
	        login.clickSelectMedicalOption1();
	        login.clickContinueButton();

	    } else {
	        throw new RuntimeException("Could not detect any known form");
	    }
	    
	}

	@Given("User is in Step eleven")
	public void user_is_in_step_eleven() {
	    
		System.out.println("User is on Step 11");
	}

	@When("User clicks option from the preferred intensity level")
	public void user_clicks_option_from_the_preferred_intensity_level() {
	    
		login.clickSelectExeciseLevel();
	}

	@Then("User should see the title {string} inStep twelve.")
	public void user_should_see_the_title_in_step_twelve(String string) {
	    
		String actualTitle = login.getStep12Title();
	    Assert.assertEquals(actualTitle,string);
	}

	@Then("User should see input field with Text {string}")
	public void user_should_see_input_field_with_text(String string) {
	 
	 	String actualTitle = login.getHbValuePlaceholderText();
	 	String expected = "Enter your HbA1c value (e.g., 7.0)";
	    Assert.assertEquals(actualTitle,expected);
	}

	@Then("User should see the text {string} in Step twelve")
	public void user_should_see_the_text_in_step_twelve(String string) {
	    
		String actualText = login.getValueText();
	    Assert.assertEquals(actualText,string);
	}

	@Then("User should see {string} button")
	public void user_should_see_button(String string) {
	  
		Assert.assertTrue("Continue button is not selected" , login.isContinueButtonVisible());
	}

	@Then("User should see description {string}")
	public void user_should_see_description(String string) {
	    
		String actualText = login.getHbDescriptionText();
	    Assert.assertEquals(actualText,string);
	}

	@Then("Progress bar should visually indicate {string} of step twelve.")
	public void progress_bar_should_visually_indicate_of_step_twelve(String steps) {
		String StepsText = login.getprogessBarStepsText();
	    Assert.assertEquals(StepsText,steps);
	 
	}
	
//----------------------------------------OnBoarding Step12-------------------------------------------------
	
	@When("User enters valid range of value in input field")
	public void user_enters_valid_range_of_value_in_input_field() {
	   
	   login.enterHbValuePlaceholderText();
	}

	@Then("User should see input field accept the value")
	public void user_should_see_input_field_accept_the_value() {
	   
		Assert.assertTrue("Input fiels is not disabled" , login.isHbValuePlaceholderTextEmpty());
	}

	@Given("User is on Step {int} of the onboarding process after entering a valid HbA1c value")
	public void user_is_on_step_of_the_onboarding_process_after_entering_a_valid_hb_a1c_value(Integer int1) {
	   
	   login.enterHbValuePlaceholderValue();
	}

	@When("User clicks continue")
	public void user_clicks_continue() {
	   
	   login.clickContinueButton();
	}

	@Then("User should see success message")
	public void user_should_see_success_message() {
	   
		Assert.assertTrue("Succes message is not selected" , login.isSuccessMsgDisplayed());
	}

	@Then("User should see a loading indicator")
	public void user_should_see_a_loading_indicator() {
	   
		Assert.assertTrue("loading indicator is not selected" , login.isLoadingIndicator());
	}

	@Then("User should see the message {string} success.")
	public void user_should_see_the_message_success(String string) {
	   
		String actualText = login.getLoadingMessage();
	    Assert.assertEquals(actualText,string);
	}

	@Then("User should see the subtext {string} on screen")
	public void user_should_see_the_subtext_on_screen(String string) {
	   
	   
	}

	@Given("User is on loading personalised screen")
	public void user_is_on_loading_personalised_screen() {
	   
	   System.out.println("User is personalised screen");
	}

	@When("User views the screen")
	public void user_views_the_screen() {
	   
	   
	}

	@Then("User should be navigated to the {string} screen after loading personalised screen")
	public void user_should_be_navigated_to_the_screen_after_loading_personalised_screen(String string) {
	   
		Assert.assertTrue("Premium button is not visible" , login.isPremiumButtonVisible());
	}
	
//----------------------------------------Blood Report---------------------------------------------------------
	
	@Given("User is on the open Page")
	public void user_is_on_the_open_page() {
		login.getbaseurl();
	}

	@When("User clicks login button and fill the form")
	public void user_clicks_login_button_and_fill_the_form() {
	    login.clickLoginButton();
	    login.enterEmailText();
	    login.clickContinueWithEmail();
	    login.enterFullNameText();
	    login.enterUserNameText();
	    login.enterPasswordText();
	    login.clickTermsAndConditionsCheckbox();	    
	}

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) {
	   login.clickCreateAccountButton();
	}

	@Then("User should navigate to blood report modal.")
	public void user_should_navigate_to_blood_report_modal() {
		Assert.assertTrue("User is not on blood report model" , login.isStepsBeforeUploadingVisible());
	}
	
//-----------------------------------------Blood Report Uploading-------------------------------------------------------
	
	@Given("User is on onboarding page")
	public void user_is_on_onboarding_page() {
		login.clickLoginButton();
	    login.enterEmailText();
	    login.clickContinueWithEmail();
	    login.enterFullNameText();
	    login.enterUserNameText();
	    login.enterPasswordText();
	    login.clickTermsAndConditionsCheckbox();
	    login.clickCreateAccountButton();
	   
	}

	@When("User clicks upload blood report button")
	public void user_clicks_upload_blood_report_button() {
	    
	   login.clickUploadBloodReport();
	}

	@Given("User is on blood report modal")
	public void user_is_on_blood_report_modal() {
	    
		Assert.assertTrue("Blood Report Model Exists", login.isdrapAndDropTextVisible());
	}

	@When("User hovers over the upload box")
	public void user_hovers_over_the_upload_box() {
	    
	   login.hoverOverUploadBox();
	}

	@Then("Upload box should show drag & drop interaction")
	public void upload_box_should_show_drag_drop_interaction() throws InterruptedException {
	    
		Assert.assertEquals("rgb(125, 57, 236)", login.getDnDInteractionBorderColor());
	}

	@When("User tries to upload a non-PDF file")
	public void user_tries_to_upload_a_non_pdf_file() {
//	    login.clickDragAndDrop();
	   login.uploadNonPdfBloodReport();
	   login.clickUploadAndProcessButton();
	}

	@Then("User should see {string} error")
	public void user_should_see_error(String steps) {
	    
		String StepsText = login.getErrorMessage();
	    Assert.assertEquals(StepsText,steps);
	}

	@When("User uploads a PDF file over 10MB")
	public void user_uploads_a_pdf_file_over_10mb() {
	    
	   
	}

	@When("User uploads valid PDF file")
	public void user_uploads_valid_pdf_file() {
//	    login.clickDragAndDrop();
		login.uploadefile();
	}

	@Then("Upload should see processing percentage bar")
	public void upload_should_see_processing_percentage_bar() {
		login.clickUploadAndProcessButton();
		Assert.assertTrue("Process bar is not visible" , login.isProgressBarVisible());
	}

	@Then("{string} button should be enabled after uploading")
	public void button_should_be_enabled_after_uploading(String string) {
		Assert.assertTrue("Upload and process button is not enables" , login.UploadAndProcessButtonEnabled());
	   
	}

	@When("User clicks {string}")
	public void user_clicks(String string) {
	    
	   login.clickCancelButton();
	}

	@Then("Modal should be closed and user returned to previous screen")
	public void modal_should_be_closed_and_user_returned_to_previous_screen() {
	    
		Assert.assertTrue("Previous age is visible" , login.isStepsBeforeUploadingVisible());
	}

	@When("User clicks {string} after uploading valid file")
	public void user_clicks_after_uploading_valid_file(String string) {
		login.uploadefile();
		login.clickUploadAndProcessButton();
	}

	@Then("User  should see Report analysis")
	public void user_should_see_report_analysis() {
		Assert.assertTrue("Report analysis is not visible" , login.isReportAnalysisVisible());
	   
	}

	@Then("User  should see onboarding button")
	public void user_should_see_onboarding_button() {
//		login.uploadefile();
//		login.clickUploadAndProcessButton();
		Assert.assertTrue("Onboarding button is not visible" , login.isContinueOnboardingBUttonVisible());
	}

	@Then("User should see Blood Test Results,Complete Blood Count, Medical Conditions ,Abnormal Values, Recommendations")
	public void user_should_see_blood_test_results_complete_blood_count_medical_conditions_abnormal_values_recommendations() {
	    
	   
	}

}
