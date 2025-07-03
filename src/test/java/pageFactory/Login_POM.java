package pageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Login_POM {
	
	String baseURL = ConfigReader.baseUrl();
	String loginURL = ConfigReader.loginUrl();
	String email = ConfigReader.loginEmail();
	String invalidEmail = ConfigReader.invalidLoginEmail();
	String password = ConfigReader.password();
	String homeURL = ConfigReader.homeUrl();
	String newEmail = ConfigReader.newEmail();
	String bloodReportUrl = ConfigReader.uploadBloodReportURL();
	String onboardingFullname = ConfigReader.OnboardingFullname();
	String onboardingUsername = ConfigReader.OnboardingUsername();
	String onboardingPassword = ConfigReader.OnboardingPassword();
	String onboardingUrl = ConfigReader.onboardingURL();
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;
	
	@FindBy(xpath = "//div[@class='flex space-x-4']//button") WebElement loginButton;
	@FindBy(xpath = "//h1[text()='Welcome back']") WebElement welcomeBackHeading;
	@FindBy(xpath = "//p[text()='Sign in to your account or create a new one']") WebElement signinAccountText;
	@FindBy(xpath = "//button[@class='absolute right-4 top-4 text-gray-400 hover:text-gray-600 transition-colors']") WebElement closeButton;
	@FindBy(xpath = "//input[@id=':r0:-form-item']") WebElement emailInput;
	@FindBy(xpath = "//input[@placeholder='Enter email']") WebElement enterEmailText;
	@FindBy(xpath = "//button[text()='Continue with email']") WebElement continueEmailButton;
	@FindBy(xpath = "//div[@class='space-y-3']//button") WebElement continueGoogleButton;
	@FindBy(xpath = "//div[@class='relative flex justify-center text-sm']//span") WebElement separatorOr;
	@FindBy(xpath = "//p[text()='By continuing you agree to our T&Cs and Privacy Policy']") WebElement privacyPolicyMessage;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordField;
	@FindBy(xpath = "//p[text()='Please enter a valid email address']") WebElement emailValidationError;
	@FindBy(xpath = "//button[text()='Sign in']") WebElement signinButton;
	@FindBy(xpath = "//p[@class='text-sm text-gray-500']") WebElement emailSubtext;
	@FindBy(xpath = "//button[text()='Forgot password?']") WebElement forgotPasswordLink;
	@FindBy(xpath = "//input[@placeholder='Enter your password']") WebElement passwordPlaceholderText;
	@FindBy(xpath = "//h2[text()='Complete your profile']") WebElement completeYourProfile;
	@FindBy(xpath = "//input[@id=':r7:-form-item']") WebElement fullNameInput;
	@FindBy(xpath = "//input[@id=':r8:-form-item']") WebElement usernameInput;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordInput;
	@FindBy(xpath = "//button[@id='terms']") WebElement termsAndConditionsCheckbox;
	@FindBy(xpath = "//button[text()='Create Account']") WebElement createAccountButton;
	@FindBy(xpath = "//button[text()='Upload Blood Report']") WebElement uploadBoodReport;
	@FindBy(xpath = "//p[@id=':r7:-form-item-message']") WebElement fullnameErrorMessage;
	@FindBy(xpath = "//p[@id=':r8:-form-item-message']") WebElement usernameErrorMessage;
	@FindBy(xpath = "//button[text()='Step Through Onboarding']") WebElement stepsThroughOnboardingButton;
	@FindBy(xpath = "//h1[text()='So, Which sugar rebellion are we dealing with?']") WebElement sugarRebillion;
	@FindBy(xpath = "//p[text()='This will help us tailor your plan to your condition']") WebElement tailorPlanSubtext;
	@FindBy(xpath = "//p[@class='text-sm text-gray-600 text-right']") WebElement progessBarSteps;
	@FindBy(xpath = "//div[@class='h-full bg-gradient-to-r from-violet-500 to-fuchsia-500 transition-all duration-300']") WebElement step1Indicator;
	@FindBy(xpath = "//button[1]/span[@class='text-lg']") WebElement optionType2SugarRebellion;
	@FindBy(xpath = "//button[2]/span[@class='text-lg']") WebElement option2OfSugarRebellion;

	public Login_POM() {
		PageFactory.initElements(driver, this);
	}
	
	public void getbaseurl() {
		driver.get(baseURL);
	}
	
	public void getloginurl()
	{
		driver.get(loginURL);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getloginHeadingText() {
		return welcomeBackHeading.getText();
	}
	
	public boolean isWelcomeBackVisible() {
		return welcomeBackHeading.isDisplayed();
	}
	
	public boolean isSigninAccountText() {
		return signinAccountText.isDisplayed();
	}
	
	public boolean isCloseButtonVisible() {
		return closeButton.isDisplayed();
	}
	
	public boolean isEmailInputVisible() {
		return emailInput.isDisplayed();
	}
	
	public String getEnterEmailPlaceholderText() {
		return enterEmailText.getAttribute("placeholder");
	}
	
	public String isEnterEmailTextVisible() {
		return enterEmailText.getText();
	}
	
	public boolean isContinueEmailButtonVisible() {
		return continueEmailButton.isDisplayed();
	}
	
	public boolean isContinueEmailButtonEnabled() {
		return continueEmailButton.isEnabled();
	}
	
	public boolean isContinueGoogleButtonVisible() {
		return continueGoogleButton.isDisplayed();
	}
	
	public boolean isSeparatorOrVisible() {
		return separatorOr.isDisplayed();
	}
	
	public String getPrivacyPolicyMessage() {
		return privacyPolicyMessage.getText();
	}
	
	public boolean isPrivacyPolicyMessageVisible() {
		return privacyPolicyMessage.isDisplayed();
	}
	
	public void enterEmail() {
		emailInput.sendKeys(email);
	}
	
	public void clickContinueWithEmail() {
		continueEmailButton.click();
	}
	
	public boolean isPasswordFieldVisible() {
		return passwordField.isDisplayed();
	}
	
	public void enterInvalidEmail() {
		emailInput.sendKeys(invalidEmail);
	}
	
	public String getInvalidErrorMessage() {
		return emailValidationError.getText();
	}
	
	public boolean isSigninButtonVisible() {
		return signinButton.isDisplayed();
	}
	
	public String isEmailSubtextVisible() {
		return emailSubtext.getText();
	}
	
	public boolean isForgotPasswordLinkVisible() {
		return forgotPasswordLink.isDisplayed();
	}
	
	public String getEnterPasswordPlaceholder() {
		return passwordPlaceholderText.getAttribute("placeholder");
	}
	
	public void enterPassword() {
		passwordField.sendKeys(password);
	}
	
	public void clickSigninButton() {
		signinButton.click();
	}
	
	public void getHomeurl() {
		driver.get(homeURL);
	}
	
	public String getHomeURL() {
	    return driver.getCurrentUrl();
	}
	
	public void enterNewEmail() {
		emailInput.sendKeys(newEmail);
	}
	
	public boolean isCompleteYourProfileVisible() {
		return completeYourProfile.isDisplayed();
	}
	
	public boolean isFullnameInputfieldVisible() {
		return fullNameInput.isDisplayed();
	}
	
	public boolean isUsernameInputfieldVisible() {
		return usernameInput.isDisplayed();
	}
	
	public boolean isPasswordInputFieldVisible() {
		return passwordInput.isDisplayed();
	}
	
	public boolean istermsAndConditionsCheckboxVisible() {
		return termsAndConditionsCheckbox.isDisplayed();
	}
	
	public boolean iscreateAccountButtonEnabled() {
		return createAccountButton.isEnabled();
	}
	
	public void readDataFromSheet(String sheetName, String testCase) throws IOException {
	    ExcelReader reader = new ExcelReader();
	    String fullNameExcelValue = reader.getTestData(sheetName, testCase, "FullName");
	    String userNameExcelValue = reader.getTestData(sheetName, testCase, "Username");
	    String passwordExcelValue = reader.getTestData(sheetName, testCase, "Password");
        fullNameInput.sendKeys(fullNameExcelValue);
        usernameInput.sendKeys(userNameExcelValue);
        passwordInput.sendKeys(passwordExcelValue);
    }
	
	public void readEmailFromSheet(String sheetName, String testCase) throws IOException {
		System.out.println("Reading form data from Excel: sheet=" + sheetName + ", testCase=" + testCase);
	    ExcelReader reader = new ExcelReader();
	    String emailExcelValue = reader.getTestData(sheetName, testCase, "Email");
	    emailInput.sendKeys(emailExcelValue);
    }

	
	public void clickTermsAndConditionsCheckbox() {
		termsAndConditionsCheckbox.click();
	}
	
	public void clickCreateAccountButton() {
		createAccountButton.click();
	}
	
	public void getBloodReportUrl() {
		 driver.get(bloodReportUrl);
	}
	
	public String getBloodReportURL() {
	    return driver.getCurrentUrl();
	}
	
	public String getFullnameErrorMessage() {
		return fullnameErrorMessage.getText();
	}
	
	public String getUsernameErrorMessage() {
		return usernameErrorMessage.getText();
	}
	
	public boolean isUploadBloodReportVisible() {
		return uploadBoodReport.isDisplayed();
	}
	
	public boolean isStepsThroughOnboardingButtonVisible() {
		return stepsThroughOnboardingButton.isDisplayed();
	}
	
	public void clickUploadBloodReport() {
		uploadBoodReport.click();
	}
	
	public void clickStepsThroughOnboardingButton() {
		stepsThroughOnboardingButton.click();
	}
	
	public void enterUserPassword() {
		passwordField.sendKeys("Team6Sweetcoders4");
	}
	public void navigateBack() {
	    driver.navigate().back();
	}
	
	public void enterOnboardingFullname() {
		fullNameInput.sendKeys(onboardingFullname);
	}
	
	public void enterOnboardingUsername() {
		usernameInput.sendKeys(onboardingUsername);
	}
	
	public void enterOnboardingPassword() {
		passwordInput.sendKeys(onboardingPassword);
	}
	
	public void getOnboardingUrl() {
		 driver.get(onboardingUrl);
	}
	
	public String getOnboardingReportUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isSugarRebillionVisible() {
		return sugarRebillion.isDisplayed();
	}
	
	public boolean isTailorPlanSubtextVisible() {
		return tailorPlanSubtext.isDisplayed();
	}
	
	public boolean isProgessbarStepsVisible() {
		return progessBarSteps.isDisplayed();
	}
	
	public boolean isStep1Indicator() {
		return step1Indicator.isDisplayed();
	}
	
	public boolean isOptionType2SugarRebellionVisible() {
		return optionType2SugarRebellion.isDisplayed();
	}
	
	public boolean isOption2OfSugarRebellionVisible() {
		return option2OfSugarRebellion.isDisplayed();
	}

	public void enterOnboardingFullname(String string) {
		fullNameInput.sendKeys("AutoNames");
	}

	public void enterOnboardingUsername(String string) {
		usernameInput.sendKeys("AutoUser1234");
		
	}

	public void enterOnboardingPassword(String password) {
	    try {
	        WebElement passwordInput = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(7))
	                .until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//input[@name='password']")));
	        passwordInput.clear();
	        passwordInput.sendKeys("AutoUser123");
	        System.out.println("✅ Password entered");
	    } catch (Exception e) {
	        System.out.println("❌ Failed to enter password: " + e.getMessage());
	    }
	}