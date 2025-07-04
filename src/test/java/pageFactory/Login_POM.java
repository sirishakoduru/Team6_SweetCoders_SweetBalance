package pageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	String uploadbloodReportUrl = ConfigReader.bloodReportUrl();
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
	@FindBy(xpath = "//div[contains(@class,'text-sm opacity-90')]") WebElement step1Message;
	@FindBy(xpath = "//button//span[text()='Back']") WebElement backButton;
	@FindBy(xpath = "//h1[text()='So, Which sugar rebellion are we dealing with?']") WebElement step1Title;
	@FindBy(xpath = "//h1[text()='Which fabulous label fits you best?']") WebElement step2Title;
	@FindBy(xpath = "//p[text()[2]]") WebElement Step2Text;
	@FindBy(xpath = "//span[contains(text(),'Male') or contains(text(),'Female') or contains(text(),'Other')]") List<WebElement> genderOptions;
	@FindBy(xpath = "//p[contains(text(),'Choose your gender')]") WebElement step2SubText;
	@FindBy(xpath = "//button[.//span[contains(text(),'Female')]]") WebElement femaleOption;
	@FindBy(xpath = "//h1[text()='Age: own it, pick your number.']") WebElement step3Title;
	@FindBy(xpath = "//p[text()='Please select your age']") WebElement step3Subtext;
	@FindBy(xpath = "//div[@data-radix-scroll-area-viewport]") WebElement scrollableAgeContainer;
	@FindBy(xpath = "//button//span[@class='text-lg']") List<WebElement> ageOptions;
	@FindBy(xpath = "//div[@class='grid gap-1']") WebElement optionMessage;
	@FindBy(xpath = "//button[.//span[contains(text(),'24')]]") WebElement age;
	@FindBy(xpath = "//h1[text()='How close are you to the clouds?']") WebElement step4Title;
	@FindBy(xpath = "//h1[text()='How much awesome do you weigh?']") WebElement step5Title;
	@FindBy(xpath = "//h1[text()='Your taste buds—what team are they on?']") WebElement step6Title;
	@FindBy(xpath = "//h1[@class='text-3xl font-italic bg-gradient-to-r from-violet-700 to-fuchsia-700 bg-clip-text text-transparent']") WebElement step7Title;
	@FindBy(xpath = "//h1[text()='Allergic to any foods?']") WebElement step8Title;
	@FindBy(xpath = "//h1[text()='Tap foods your body hates']") WebElement step9Title;
	@FindBy(xpath = "//h1[text()='Any medical quirks worth mentioning?']") WebElement step10Title;
	@FindBy(xpath = "//h1[text()='Pick your pace: chill stroll or marathon magic?']") WebElement step11Title;
	@FindBy(xpath = "//h1[text()='Final Step- What’s your latest HbA1c number?!']") WebElement step12Title;
	@FindBy(xpath = "//p[text()='Please enter your height']") WebElement step4Subtext;
	@FindBy(xpath = "//button[text()='Centimeters']") WebElement centimeterTab;
	@FindBy(xpath = "//button[text()=\"Feet & Inches\"]") WebElement feetAndInchesTab;
	@FindBy(xpath = "//button[contains(text(),'Centimeters') or contains(text(),'Feet & Inches')]") List<WebElement> tabOptions;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])]") List<WebElement> heightOptions;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])]") List<WebElement> inchesheightOptions;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])][30]") WebElement selectHeight;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])][12]") WebElement selectHeightInFeet;
	@FindBy(xpath = "//p[text()='We will personalize your nutrition plan to guide you towards your goals!']") WebElement step5Subtext;
	@FindBy(xpath = "//button[contains(text(),'Kilograms') or contains(text(),'Pounds')]") List<WebElement> weightTabOptions;
	@FindBy(xpath = "//button[text()='Kilograms']") WebElement kilogramsTab;
	@FindBy(xpath = "//button[text()='Pounds']") WebElement poundsTab;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])]") List<WebElement> kilogramsOptions;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])]") List<WebElement> poundsOptions;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])][20]") WebElement selectKilogramOption;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])][63]") WebElement selectPoundOptions;
	@FindBy(xpath = "//p[text()='Select your dietary preference']") WebElement step6Subtext;
	@FindBy(xpath = "//span[@class='text-lg']") List<WebElement>tasteBudOptions;
	@FindBy(xpath = "//button//span[text()='Vegetarian 🥗🍆🥕']") WebElement selectTasteBud;
	@FindBy(xpath= "//button[span and not(span[text()='Back'])]") List<WebElement> foodOptions;
	@FindBy(xpath = "//p[@class='text-gray-600']") WebElement step7Subtext;
	@FindBy(xpath = "//button[span and not(span[text()='Back'])][1]") WebElement selectFoodOption;
	@FindBy(xpath = "//button//span[contains(text(),'Yes ✅') or contains(text(),'No ❌')]") List<WebElement> allergyOptions;
	@FindBy(xpath = "//p[text()='Select yesif you have any food allergies']") WebElement step8Subtext;
	@FindBy(xpath = "//button[.//span[normalize-space(text())='Yes ✅']]") WebElement selectAllergyYesOption;
	@FindBy(xpath = "//button//span[text()='No ❌']") WebElement selectAllergyNoOption;
	@FindBy(xpath = "//div[contains(text(),'Dairy') or contains(text(),'Gluten') or contains(text(),'Nuts') or contains(text(),'Shellfish') or contains(text(),'Soy') or contains(text(),'Eggs') or contains(text(),'Other') or contains(text(),'None')]") List<WebElement>allergyFoodOptions;
	@FindBy(xpath = "//p[text()='Select all that apply']") WebElement step9SubText;
	@FindBy(xpath = "//div//div//div[contains(@class,'flex items-center')]") List<WebElement> medicalOptions;
	@FindBy(xpath = "//p[text()='Do you have any other medical conditions?']") WebElement step10Subtext;
	@FindBy(xpath = "//div//button[@id='dairy']") WebElement selectAllergyFood;
	@FindBy(xpath = "//button//span[text()='Continue']") WebElement continueButton;
	@FindBy(xpath = "//div//button[@id='high-blood-pressure']") WebElement selectMedicalOption1;
	@FindBy(xpath = "//div//button[@id='anemia']") WebElement selectMedicalOption2;
	@FindBy(xpath = "//span[@data-state='checked']") WebElement multipleCheckboxSelected;
	@FindBy(xpath = "//span[contains(text(),'Easy') or contains(text(),'Medium ') or contains(text(),'Hard')]") List<WebElement> exerciseLevelOptions;
	@FindBy(xpath = "//p[@class='text-gray-600']") WebElement step11Subtext;
	@FindBy(xpath = "//button//span[contains(text(),'Medium')]") WebElement selectExerciseLevel;
	@FindBy(xpath = "//p[text()='Please enter a value between 4.0 and 15.0']") WebElement valueText;
	@FindBy(xpath = "//input[@placeholder='Enter your HbA1c value (e.g., 7.0)']") WebElement hbValuePlaceholderText;
	@FindBy(xpath = "//div[@class='mt-4 bg-white/50 backdrop-blur-sm rounded-lg p-4 shadow-inner']") WebElement hbDescriptionText;
	@FindBy(xpath = "//div//div[1][contains(string(.),'Success') and contains(string(.),'HbA1c value 5% stored successfully')]") WebElement successMessage;
	@FindBy(xpath = "//div[@class='absolute inset-0 rounded-full border-4 border-purple-200']") WebElement loadingIndicator;
	@FindBy(xpath = "//p[text()='Getting you all set—like a VIP pass to better health!']") WebElement loadingMessage;
	@FindBy(xpath = "//button[text()='Upgrade to Premium']") WebElement premiumButton;
	@FindBy(xpath = "//button[text()='Upload Blood Report']") WebElement bloodReportButton;
	@FindBy(xpath = "//div[contains(@class,'border-dashed')]") WebElement dragAndDrop;
	//div[contains(@class,'border-dashed')]
	@FindBy(xpath = "//input[@type='file']") WebElement pdfFileInput;
	@FindBy(xpath = "//p[contains(text(),'Drag & drop or click to upload')]") WebElement dragAndDropText;
	@FindBy(xpath = "//div[text()='Upload failed']") WebElement uploadErrorMessage;
	@FindBy(xpath = "//button[text()='Upload & Process']") WebElement uploadAndProcessButton;
	@FindBy(xpath = "//button[text()='Cancel']") WebElement cancelButton;
	@FindBy(xpath= "//h1[text()='Drop a file, Dodge the boring steps!']") WebElement stepsBeforeUploading;
	@FindBy(xpath = "//div[@data-state='indeterminate']") WebElement progressBar;
	@FindBy(xpath = "//div[@role='progressbar']") WebElement progressBar2;
	@FindBy(xpath = "//h2[text()='Report Analysis Results']") WebElement ReportAnalysis;
	@FindBy(xpath = "//button[text()='Continue to Onboarding']") WebElement continueOnboardingBUtton;
	
	//button[.//span[contains(text(),'120')]]

	public Login_POM() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		try {
			return fullNameInput.isDisplayed();
		} catch (Exception e) {
			System.out.println("exception Error:" + e.getMessage());
			return false;
		}
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
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", uploadBoodReport);
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
	
	public boolean isStep1IndicatorVisible() {
		return step1Indicator.isDisplayed();
	}
	
	public boolean isOptionType2SugarRebellionVisible() {
		return optionType2SugarRebellion.isDisplayed();
	}
	
	public boolean isOption2OfSugarRebellionVisible() {
		return option2OfSugarRebellion.isDisplayed();
	}

//	public void enterOnboardingFullname(String string) {
//		fullNameInput.sendKeys("AutoNames");
//	}
//
//	public void enterOnboardingUsername(String string) {
//		usernameInput.sendKeys("AutoUser123456");
//		
//	}

	public void enterOnboardingPassword(String password) {
	    try {
	        WebElement passwordInput = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(7))
	                .until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//input[@name='password']")));
	        passwordInput.clear();
	        passwordInput.sendKeys("AutoUser123");
	        System.out.println("Password entered");
	    } catch (Exception e) {
	        System.out.println("Failed to enter password: " + e.getMessage());
	    }
	}
	

	  public void performLogin() {
		  	clickLoginButton();
	        enterEmail();
	        clickContinueWithEmail();
	        enterPassword();
	        clickSigninButton();
	    }
	
	public void clickOptionInStep1() {
		option2OfSugarRebellion.click();
	}

	
	public String getStep2Text() {
		return Step2Text.getText().trim();
	}
	
	public boolean waitForStep(int stepNumber) throws TimeoutException {
	    String expectedTitle;

	    switch (stepNumber) {
	        case 1:
	            expectedTitle = "So, Which sugar rebellion are we dealing with?";
	            break;
	        case 2:
	            expectedTitle = "Which fabulous label fits you best?";
	            break;
	        case 3:
	            expectedTitle = "Age: own it, pick your number.";
	            break;
	        case 4:
	            expectedTitle = "How close are you to the clouds?";
	            break;
	        case 5:
	            expectedTitle = "How much awesome do you weigh?";
	            break;
	        case 6:
	            expectedTitle = "Your taste buds—what team are they on?";
	            break;
	        case 7:
	            expectedTitle = "What's your go-to food passport?";
	            break;
	        case 8:
	            expectedTitle = "Allergic to any foods?";
	            break;
	        case 9:
	            expectedTitle = "Tap foods your body hates";
	            break;
	        case 10:
	            expectedTitle = "Any medical quirks worth mentioning?";
	            break;
	        case 11:
	            expectedTitle = "Pick your pace: chill stroll or marathon magic?";
	            break;
	        case 12:
	            expectedTitle = "Final Step- What’s your latest HbA1c number?!";
	            break;
	        default:
	            throw new RuntimeException("Step " + stepNumber + " is not handled");
	    }

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//h2[contains(text(),'" + expectedTitle + "')]")));
		return true;
	}
	
	public boolean isStep2SubTextVisible() {
		return step2SubText.isDisplayed();
	}
	
	public String getStep1Message() {
		return step1Message.getText();
	}
	
	public boolean isBackButtonVisible() throws TimeoutException {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOf(backButton)).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	public String getStep2Title() {
		return step2Title.getText();
	}
	
	public String getprogessBarStepsText() {
		return progessBarSteps.getText().trim();
	}
	
	public List<String> getGenderOptions() {
		List<String> labels = new ArrayList<>();
        for (WebElement option : genderOptions) {
            labels.add(option.getText().trim());
        }
        return labels;
    }
	
	public void clickBackButton() {
		backButton.click();
	}
	
	public void selectFemaleOption() {
		femaleOption.click();
	}
	
	public String getStep3Title() {
		return step3Title.getText();
	}
	
	public String getStep3Subtext() {
		return step3Subtext.getText();
	}
	public String getStep4Subtext() {
		return step4Subtext.getText();
	}

	
	public boolean isScrollableAgeContainerVisible() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean isScrollable = (Boolean) js.executeScript(
				"var elem = arguments[0];" +
				"return elem.scrollHeight > elem.clientHeight;", scrollableAgeContainer);
		
		return isScrollable;
	}
	
	public boolean isageOptionsVisible() {
		List<String> actualAges = ageOptions.stream()
		        .map(WebElement::getText)
		        .map(String::trim)
		        .collect(Collectors.toList());

		    List<String> expectedAges = new ArrayList<>();
		    for (int i = 18; i <= 100; i++) {
		        expectedAges.add(i + " years");
		    }
		    System.out.println("Actual Age Options: " + actualAges);
		    System.out.println("Expected Age Options: " + expectedAges);

		    return actualAges.containsAll(expectedAges) && actualAges.size() == expectedAges.size();
	
	}
	
	public boolean isstep2TitleVisible() {
		return step2Title.isDisplayed();
	}
	public boolean isstep1TitleVisible() {
		return step1Title.isDisplayed();
	}
	public boolean isstep3TitleVisible() {
		return step3Title.isDisplayed();
	}
	public boolean isstep4TitleVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOf(step4Title)).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }

	}
	public boolean isstep5TitleVisible() {
		return step5Title.isDisplayed();
	}
	public boolean isstep6TitleVisible() {
		return step6Title.isDisplayed();
	}
	public boolean isstep7TitleVisible() {
		return step7Title.isDisplayed();
	}
	public boolean isstep8TitleVisible() {
		return step8Title.isDisplayed();
	}
	public boolean isstep9TitleVisible() {
		return step9Title.isDisplayed();
	}
	public boolean isstep10TitleVisible() {
		return step10Title.isDisplayed();
	}
	public boolean isstep11TitleVisible() {
		return step11Title.isDisplayed();
	}
	public boolean isstep12TitleVisible() {
		return step12Title.isDisplayed();
	}
	
	public String getOptionMessage() {
		return optionMessage.getText();
	}
	
	
	public void selectAgeOption(int age) {
		    String xpath = "//button[.//span[contains(text(),'" + age + "')]]";  // proper Java string concatenation

		    WebElement ageElement = driver.findElement(By.xpath(xpath));

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ageElement);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(ageElement));

		    ageElement.click();
	}
	
	public void clickAge() {
		age.click();
	}
	
	public String getStep4Title() {
		return step4Title.getText();
	}
	public String getStep5Title() {
		return step5Title.getText();
	}
	public String getStep6Title() {
		return step6Title.getText();
	}
	public String getStep7Title() {
		return step7Title.getText();
	}
	public String getStep8Title() {
		return step8Title.getText();
	}
	public String getStep9Title() {
		return step9Title.getText();
	}
	public String getStep10Title() {
		return step10Title.getText();
	}
	public String getStep11Title() {
		return step11Title.getText();
	}
	public String getStep12Title() {
		return step12Title.getText();
	}
	public String getCentimeterTab() {
		return centimeterTab.getText();
	}
	public String getFeetAndInchesTab() {
		System.out.println("feet & Inches Text: " + feetAndInchesTab.getText());
		return feetAndInchesTab.getText();
	}
	public List<String> getTabOptions() {
		List<String> tabs = new ArrayList<>();
        for (WebElement option : tabOptions) {
        	tabs.add(option.getText().trim());
        }
        return tabs;
    }
	
	public boolean isHeightOptionsVisible() {
		List<String> actualHeight = heightOptions.stream()
		        .map(WebElement::getText)
		        .map(String::trim)
		        .collect(Collectors.toList());

		    List<String> expectedHeight = new ArrayList<>();
		    for (int i = 120; i <= 220; i++) {
		    	expectedHeight.add(i + " cm");
		    }
		    System.out.println("Actual height Options: " + actualHeight);
		    System.out.println("Expected height Options: " + expectedHeight);

		    return actualHeight.containsAll(expectedHeight) && actualHeight.size() == expectedHeight.size();
	
	}
	
	public boolean isInchesHeightOptionsVisible() {
		List<String> actualInchesHeight = inchesheightOptions.stream()
		        .map(WebElement::getText)
		        .map(String::trim)
		        .collect(Collectors.toList());

		List<String> expectedInchesHeight = new ArrayList<>();
		for (int feet = 4; feet <= 7; feet++) {
		    int inchStart = (feet == 4) ? 5 : 0;
		    int inchEnd = (feet == 7) ? 3 : 11;

		    for (int inch = inchStart; inch <= inchEnd; inch++) {
		    	expectedInchesHeight.add(String.format("%d' %d\"", feet, inch));
		    }
		}

		    System.out.println("Actual Inches Height Options: " + actualInchesHeight);
		    System.out.println("Expected Inches Height Options: " + expectedInchesHeight);

		    return actualInchesHeight.containsAll(expectedInchesHeight) &&
		           actualInchesHeight.size() == expectedInchesHeight.size();
	}
	
	public void clickCentimeterTab() {
		centimeterTab.click();
	}
	public void clickInchesTab() {
		feetAndInchesTab.click();
	}
	
	public void clickHeightOptionAbove180() {
	    for (WebElement option : heightOptions) {
	        String text = option.getText().replace("cm", "").trim();
	        try {
	            int cm = Integer.parseInt(text);
	            if (cm > 180) {
	                option.click();
	                return;
	            }
	        } catch (NumberFormatException ignored) {
	          
	        }
	    }
	    throw new NoSuchElementException("No height option found above 180 cm");
	}
	
	public void clickHeightOptionLess159() {
	    for (WebElement option : heightOptions) {
	        String text = option.getText().replace("cm", "").trim();
	        try {
	            int cm = Integer.parseInt(text);
	            if (cm < 159) {
	                option.click();
	                return;
	            }
	        } catch (NumberFormatException ignored) {
	          
	        }
	    }
	    throw new NoSuchElementException("No height option found less than 159 cm");
	}
	
	public void clickHeightOptionLess160to179() {
	    for (WebElement option : heightOptions) {
	        String text = option.getText().replace("cm", "").trim();
	        try {
	            int cm = Integer.parseInt(text);
	            if (cm >= 160 && cm <= 179) {
	                option.click();
	                return;
	            }
	        } catch (NumberFormatException ignored) {
	          
	        }
	    }
	    throw new NoSuchElementException("No height option found between 160cm to 159 cm");
	}
	
	public void clickSelectHeight() {
		selectHeight.click();
	}
	
	public void clickHeightInFeetInches(int feet, int inches) {
	  
	    String xpath = 
				"//span[normalize-space(.)=concat(\"" + feet + "\", \"'\", \" " + inches + "\", '\"')]/..";

	    WebElement option = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	    option.click();
	}
	
	public void clickSelectHeightInFeet() {
		selectHeightInFeet.click();
	}
	
	public String getStep5Subtext() {
		return step5Subtext.getText();
	}
	
	public List<String> getWeightTabOptions() {
		List<String> tabs = new ArrayList<>();
        for (WebElement option : weightTabOptions) {
        	tabs.add(option.getText().trim());
        }
        return tabs;
    }
	
	public String getKilogramsTabText() {
		return kilogramsTab.getText();
	}
	public String getPoundsTabText() {
		System.out.println("Pounds Text: " + poundsTab.getText());
		return poundsTab.getText();
	}
	
	public void clickKilogramsTab() {
		kilogramsTab.click();
	}
	public void clickPoundsTab() {
		poundsTab.click();
	}
	public boolean isKilogramsOptionsVisible() {
		List<String> actualKilograms = kilogramsOptions.stream()
		        .map(WebElement::getText)
		        .map(String::trim)
		        .collect(Collectors.toList());

		    List<String> expectedKilograms = new ArrayList<>();
		    for (int i = 40; i <= 190; i++) {
		    	expectedKilograms.add(i + " kg");
		    }
		    System.out.println("Actual height Options: " + actualKilograms);
		    System.out.println("Expected height Options: " + expectedKilograms);

		    return actualKilograms.containsAll(expectedKilograms) && actualKilograms.size() == expectedKilograms.size();
	
	}
	
	public boolean isPoundsOptionsVisible() {
		List<String> actualPounds = poundsOptions.stream()
		        .map(WebElement::getText)
		        .map(String::trim)
		        .collect(Collectors.toList());

		    List<String> expectedPounds = new ArrayList<>();
		    for (int i = 90; i <= 550; i++) {
		    	expectedPounds.add(i + " lbs");
		    }
		    System.out.println("Actual height Options: " + actualPounds);
		    System.out.println("Expected height Options: " + expectedPounds);

		    return actualPounds.containsAll(expectedPounds) && actualPounds.size() == expectedPounds.size();
	
	}
	
	public void clickKilogramsOptionLessThan59() {
	    for (WebElement option : kilogramsOptions) {
	        String text = option.getText().replace("kg", "").trim();
	        try {
	            int kg = Integer.parseInt(text);
	            if (kg < 59) {
	                option.click();
	                return;
	            }
	        } catch (NumberFormatException ignored) {
	          
	        }
	    }
	}
	    
	    public void clickKilogramsOptionBetween60to84() {
		    for (WebElement option : kilogramsOptions) {
		        String text = option.getText().replace("kg", "").trim();
		        try {
		            int cm = Integer.parseInt(text);
		            if (cm >= 60 && cm <= 84) {
		                option.click();
		                return;
		            }
		        } catch (NumberFormatException ignored) {
		          
		        }
		    }
		    throw new NoSuchElementException("No weight option found between 60kg to 84kg");
		}
	    
	    public void clickKilogramsOptionAbove85() {
		    for (WebElement option : kilogramsOptions) {
		        String text = option.getText().replace("kg", "").trim();
		        try {
		            int cm = Integer.parseInt(text);
		            if (cm > 85) {
		                option.click();
		                return;
		            }
		        } catch (NumberFormatException ignored) {
		          
		        }
		    }
		    throw new NoSuchElementException("No weight option found above 85 kg");
		}
	    
	    public void clickSelectKilogramOption() {
	    	selectKilogramOption.click();
	    }
	    public void clickSelectPoundOptions() {
	    	selectPoundOptions.click();
	    }
	    public String getStep6Subtext() {
			return step6Subtext.getText();
		}
	    
	    public List<String> getTasteBudOptions() {
			List<String> tasteBuds = new ArrayList<>();
	        for (WebElement option : tasteBudOptions) {
	        	tasteBuds.add(option.getText().trim());
	        }
	        return tasteBuds;
	    }
	    public void clickSelectTasteBud() {
	    	selectTasteBud.click();
	    }
	    public List<String> getFoodOptions() {
			List<String> food = new ArrayList<>();
	        for (WebElement option : foodOptions) {
	        	food.add(option.getText().trim());
	        }
	        return food;
	    }
	    
	    public void clickSelectFoodOption() {
	    	selectFoodOption.click();
	    }
	    public String getStep7Subtext() {
			return step7Subtext.getText();
		}
	    public List<String> getallergyptions() {
			List<String> labels = new ArrayList<>();
	        for (WebElement option : allergyOptions) {
	        	labels.add(option.getText().trim());
	        }
	        return labels;
	    }
	    public String getStep8Subtext() {
			return step8Subtext.getText();
		}
	    public void clickSelectAllergyYesOption() {
	    	new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(selectAllergyYesOption))
	        .click();
	    }
	    public void clickSelectAllergyNoOption() {
	    	new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(selectAllergyNoOption))
	        .click();
	  
	    }
	    
	    public List<String> getAllergyFoodptions() {
	    	System.out.println("Found options: " + allergyFoodOptions.size());
			List<String> labels = new ArrayList<>();
	        for (WebElement option : allergyFoodOptions) {
	        	labels.add(option.getText().trim());
	        }
	        return labels;
	    }
	    public String getStep9Subtext() {
	    	return step9SubText.getText();
	    }
	    public List<String> getMedicalptions() {
			List<String> labels = new ArrayList<>();
	        for (WebElement option : medicalOptions) {
	        	labels.add(option.getText().trim());
	        }
	        return labels;
	    }
	    public String getStep10Subtext() {
	    	return step10Subtext.getText();
	    }
	    public void clickSelectAllergyFood() {
	    	selectAllergyFood.click();
	    }
	    public void clickContinueButton() {
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
	    }
	    public void clickSelectMedicalOption1() {
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectMedicalOption1);
	  
	    }
	    public void clickSelectMedicalOption2() {
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectMedicalOption2);
	  
	    }
	    public boolean isMultipleCheckboxSelectedVisible() {
	    	return multipleCheckboxSelected.isDisplayed();
	    }
	    public List<String> getExeciseLevelOptions() {
			List<String> labels = new ArrayList<>();
	        for (WebElement option : exerciseLevelOptions) {
	        	labels.add(option.getText().trim());
	        }
	        return labels;
	    }
	    public String getStep11Subtext() {
	    	return step11Subtext.getText();
	    }
		public void clickSelectExeciseLevel() {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectExerciseLevel);
		}
		public String getValueText() {
			return valueText.getText();
		}
		public String getHbValuePlaceholderText() {
			return hbValuePlaceholderText.getAttribute("placeholder");
		}
		public String getHbDescriptionText() {
			return hbDescriptionText.getText();
		}
		public boolean isContinueButtonVisible() {
			return continueButton.isDisplayed();
		}
		public void enterHbValuePlaceholderText() {
			hbValuePlaceholderText.sendKeys("2");
			}
		public boolean isHbValuePlaceholderTextEmpty() {
			return !hbValuePlaceholderText.isEnabled();
		}
		public void enterHbValuePlaceholderValue() {
			hbValuePlaceholderText.sendKeys("5");
			}
		public Boolean isSuccessMsgDisplayed() {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
		    WebElement alert = wait.until(ExpectedConditions.visibilityOf(successMessage));
		    
		    String actualMsg = alert.getText().replaceAll("\\s+", " ").trim();
		    String expectedMsg = "Success HbA1c value 5% stored successfully".replaceAll("\\s+", " ").trim();

		    System.out.println("Actual: " + actualMsg);
		    System.out.println("Expected: " + expectedMsg);

		    return actualMsg.contains(expectedMsg);
		}
		public String getLoadingMessage() {
			return loadingMessage.getText();
		}
		public boolean isPremiumButtonVisible() {
			return premiumButton.isDisplayed();
		}
		public boolean isLoadingIndicator() {
			return loadingIndicator.isDisplayed();
		}
		public void enterEmailText() {
			emailInput.sendKeys(generateEmail());
		}
		public void enterFullNameText() {
			fullNameInput.sendKeys("Sweet-Nutri");
		}
		public void enterUserNameText() {
			usernameInput.sendKeys(generateUsername());
		}
		public void enterPasswordText() {
			passwordInput.sendKeys("SweetNutri");
		}
		public void hoverOverUploadBox() {
			Actions actions = new Actions(driver);
		    actions.moveToElement(dragAndDrop).perform();
		}
		public String getDnDInteractionBorderColor() throws InterruptedException {
			Thread.sleep(1000);
			String borderColor = dragAndDrop.getCssValue("border-color");
			System.out.println("Border color on hover: " + borderColor);
			return borderColor;
			
		}
		public boolean isdrapAndDropTextVisible() {
			return dragAndDropText.isDisplayed();
		}
//		public void uploadPdfBloodReport() {
//		    String filePath = ConfigReader.getProperty("pdfPath");
//		    
//		    // Optional: If the input is hidden, make it visible via JS
//		    if (!dragAndDrop.isDisplayed()) {
//		        JavascriptExecutor js = (JavascriptExecutor) driver;
//		        js.executeScript("arguments[0].style.display = 'block';", pdfFileInput);
//		    }
//
//		    pdfFileInput.sendKeys(filePath);
//		}
		public void uploadefile() {
			File file = new File(ConfigReader.getProperty("pdfPath"));
			String pathfile = file.getAbsolutePath();
//			String pathfile = System.getProperty("user.dir") + "\\Documents\\CBC-sample 1.pdf";
			pdfFileInput.sendKeys(pathfile);
		}
		public boolean isProgressBarVisible() {
			return progressBar.isDisplayed();
		}
		public boolean UploadAndProcessButtonEnabled() {
			return uploadAndProcessButton.isEnabled();
		}
		public void clickCancelButton() {
			cancelButton.click();
		}
		public boolean isStepsBeforeUploadingVisible() {
			return stepsBeforeUploading.isDisplayed();
		}
		public void clickUploadAndProcessButton() {
			uploadAndProcessButton.click();
		}
		public boolean isReportAnalysisVisible() {
			return ReportAnalysis.isDisplayed();
		}
		public boolean isContinueOnboardingBUttonVisible() {
			return continueOnboardingBUtton.isDisplayed();
		}
		public void getUploadBllodReportURL() {
			driver.get(uploadbloodReportUrl);
		}
		public void uploadNonPdfBloodReport() {
			File file = new File(ConfigReader.getProperty("excelFilePath"));
		    String pathfile = file.getAbsolutePath();
//			String pathfile = System.getProperty("user.dir") + "\\Documents\\CBC-sample 1.pdf";
			pdfFileInput.sendKeys(pathfile);
		}
		public void uploadnonPdfefile() {
			String pathfile = System.getProperty("user.dir") + "\\numpy ninja\\SweetBalanceTestData.xlsx";
			pdfFileInput.sendKeys(pathfile);	
		}
		public String getErrorMessage() {
			return uploadErrorMessage.getText();
		}
		public static String generateUsername() {
		    return "Sweet" + System.currentTimeMillis();
		}

		public static String generateEmail() {
		    return generateUsername() + "@testmail.com";
		}
		public void clickDragAndDrop() {
			dragAndDrop.click();
		}
		
	
	


	
}