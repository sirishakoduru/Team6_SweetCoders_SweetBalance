package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

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
	        System.out.println("🟢 New user detected");

	        login.enterOnboardingFullname("AutoName");
	        login.enterOnboardingUsername("AutoUser123");
	        login.enterOnboardingPassword("Test@1234");
	        login.clickTermsAndConditionsCheckbox();
	        login.clickCreateAccountButton();

	    } else if (login.isPasswordFieldVisible()) {
	        System.out.println("🟡 Existing user detected");

	        login.enterOnboardingPassword("Test@1234");
	        login.clickSigninButton();

	    } else {
	        throw new RuntimeException("❌ Could not detect any known form");
	    }
		
	}

	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() {
	    
	    System.out.println("User is on the blood report page");
	}

	@When("User clicks on step for onboarding button")
	public void user_clicks_on_step_for_onboarding_button() {
	    
	    login.clickStepsThroughOnboardingButton();
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
	    
		Assert.assertTrue("Steps indicator is not present",login.isStep1Indicator()); 
	}

	@Then("User should see an option labeled  {string}")
	public void user_should_see_an_option_labeled(String string) {
	    
		Assert.assertTrue("type 2 option is not present",login.isOptionType2SugarRebellionVisible());
		Assert.assertTrue("I dont know option is not present",login.isOption2OfSugarRebellionVisible());
	}

	

}
