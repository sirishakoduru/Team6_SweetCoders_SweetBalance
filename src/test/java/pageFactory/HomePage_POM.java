package pageFactory;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.CommonMethods;

public class HomePage_POM {
		
	private WebDriver driver = null;
		
		@FindBy(xpath = ("//*[text()='SweetBalance']")) WebElement applicationName;
		@FindBy(xpath = ("//*[contains(text(), 'Terms of Service and Privacy Policy')]")) WebElement termCondition;
		@FindBy(xpath = ("//*[text()='Smart Diabetes Tracking ']")) WebElement smartDiabetes;
		@FindBy(xpath = ("//*[text()='Start Today ']")) WebElement startBttn;
		@FindBy(xpath = ("//*[contains(text(), 'Comprehensive Diabetes Management Tools')]")) WebElement diabetesTool;
		@FindBy(xpath = ("//*[text()='Health Tracking']")) WebElement healthTracking;
		@FindBy(xpath = ("//*[text()='Nutrition & Exercise']")) WebElement nutritionExcercise;
		@FindBy(xpath = ("//*[text()='Smart Insights']")) WebElement smartInsight;
		
		@FindBy(xpath = ("//*[contains(text(), 'Monitor glucose levels')]")) WebElement glucoselevels;
		@FindBy(xpath = ("//*[text()='Easy logging of daily readings']")) WebElement dailyReading;
		@FindBy(xpath = ("//*[text()='Visualize trends over time']")) WebElement trendsOverTime;
		@FindBy(xpath = ("//*[text()='Set personalized targets']")) WebElement personalizedTarget;
		
		@FindBy(xpath = ("//*[contains(text(), 'Balance diet and physical activity')]")) WebElement physicalActivity;
		@FindBy(xpath = ("//*[text()='Carb counting tools']")) WebElement carbTools;
		@FindBy(xpath = ("//*[text()='Customized exercise plans']")) WebElement excercisePlans;
		@FindBy(xpath = ("//*[text()='Meal suggestions based on readings']")) WebElement mealSuggestions;
		
		@FindBy(xpath = ("//*[contains(text(), 'Get personalized guidance based on your data')]")) WebElement personalizedGuidance;
		@FindBy(xpath = ("//*[text()='Pattern detection algorithms']")) WebElement detectionAlgorithams;
		@FindBy(xpath = ("//*[text()='Early warning notifications']")) WebElement warningNotice;
		@FindBy(xpath = ("//*[text()='Actionable recommendations']")) WebElement actionableRecommend;
		
		@FindBy(xpath = "//*[contains(@class, 'lucide lucide-heart h-8 w-8 text-primary mb-2')]") private WebElement heartIcon;
		@FindBy(xpath = "//*[contains(@class, 'lucide lucide-square-activity h-8 w-8')]") private WebElement squareIcon;
		@FindBy(xpath = "//*[contains(@class, 'lucide lucide-clock h-8 w-8 text-primary mb-2')]") private WebElement circleIcon;
		
		@FindBy(xpath = "//*[text()='James D.']") private WebElement JAmesD;
		@FindBy(xpath = "//*[text()='Maria L.']") private WebElement mariaL;
		@FindBy(xpath = "//*[text()='Robert T.']") private WebElement robertT;
		@FindBy(xpath = "//*[text()='Join our community of successful members']") private WebElement joinCommunity;
		@FindBy(xpath = "//*[contains(@class,'flex justify-center gap-1 mb-4')]") private WebElement fiveStarsCommunity;
		@FindBy(xpath = "//*[text()='JD']/../div[2]/div") private WebElement starsJamesD;
		@FindBy(xpath = "//*[text()='ML']/../div[2]/div") private WebElement starsMariaL;
		@FindBy(xpath = "//*[text()='RT']/../div[2]/div") private WebElement starsRobertT;
		@FindBy(xpath = "//*[text()='Take control of your diabetes today']") private WebElement takeControl;
		@FindBy(xpath = "//*[text()='Check Your Risk ']") private WebElement checkRiskBttn;
		
		@FindBy(xpath = "//*[text()=' Login']") private WebElement loginBttn;
		@FindBy(xpath = "//*[text()='Diabetes Risk Analyzer']") private WebElement diabetesPopUp;
		
		public HomePage_POM() {
			this.driver = DriverFactory.getDriver();
			PageFactory.initElements(driver, this);
		}
		
		public String getCurrentUrl() {
			return driver.getCurrentUrl();
		}

		public String getCurrentTitle() {
			return driver.getTitle();
		}
		
		public String getAppName() {
			CommonMethods.waitForElementVisibilityOf(applicationName);
			System.out.println("App name is: " +applicationName.getText());
			return applicationName.getText();
		}
		
		public boolean isAppNameDisplayed() {
			CommonMethods.waitForElementVisibilityOf(applicationName);
			return applicationName.isDisplayed();
		}
				
		public boolean isSmartDiabetesDisplayed() {
			CommonMethods.waitForElementVisibilityOf(smartDiabetes);
			return smartDiabetes.isDisplayed();
		}
		
		public boolean isStartBttnDisplayed() {
			CommonMethods.waitForElementVisibilityOf(startBttn);
			return startBttn.isDisplayed();
		}
		
		public boolean isdiabetesToolDisplayed() {
			CommonMethods.waitForElementVisibilityOf(diabetesTool);
			return diabetesTool.isDisplayed();
		}
		
		public boolean istermConditionDisplayed() {
			CommonMethods.waitForElementVisibilityOf(termCondition);
			return termCondition.isDisplayed();
		}
		
		public boolean ishealthTrackingDisplayed() {
			CommonMethods.waitForElementVisibilityOf(healthTracking);
			return healthTracking.isDisplayed();
		}
		
		public boolean isnutritionExcerciseDisplayed() {
			CommonMethods.waitForElementVisibilityOf(nutritionExcercise);
			return nutritionExcercise.isDisplayed();
		}
		
		public boolean issmartInsightDisplayed() {
			CommonMethods.waitForElementVisibilityOf(smartInsight);
			return smartInsight.isDisplayed();
		}
		
		public List<WebElement> gethealthTrackingTitles() {
			return Arrays.asList(glucoselevels, dailyReading, trendsOverTime, personalizedTarget);
		}
		
		public List<WebElement> getNutritionTitles() {
			return Arrays.asList(physicalActivity, carbTools, excercisePlans, mealSuggestions);
		}
		
		public List<WebElement> getSmartInsightsTitles() {
			return Arrays.asList(personalizedGuidance, detectionAlgorithams, warningNotice, actionableRecommend);
		}
		
		public boolean isheartIconDisplayed() {
			return heartIcon.isDisplayed();
		}
		public boolean issquareIconDisplayed() {
			return squareIcon.isDisplayed();
		}
		public boolean iscircleIconDisplayed() {
			return circleIcon.isDisplayed();
		}
		public boolean isJAmesDDisplayed() {
			return JAmesD.isDisplayed();
		}
		public boolean ismariaLDisplayed() {
			return mariaL.isDisplayed();
		}
		public boolean isrobertTDisplayed() {
			return robertT.isDisplayed();
		}
		public boolean isjoinCommunityDisplayed() {
			return joinCommunity.isDisplayed();
		}
		public boolean isfiveStarsCommunityDisplayed() {
			return fiveStarsCommunity.isDisplayed();
		}
		public boolean isstarsJamesDDisplayed() {
			return starsJamesD.isDisplayed();
		}
		public boolean isstarsMariaLDisplayed() {
			return starsMariaL.isDisplayed();
		}
		public boolean isstarsRobertTDisplayed() {
			return starsRobertT.isDisplayed();
		}
		public boolean istakeControlDisplayed() {
			return takeControl.isDisplayed();
		}
		public boolean ischeckRiskDisplayed() {
			return checkRiskBttn.isDisplayed();
		}
		public void clickStartBttn() {
			startBttn.click();
		}
		public boolean isloginBttnDisplayed() {
			return loginBttn.isDisplayed();
		}
		public void clickloginBttn() {
			loginBttn.click();
		}
		public void clickcheckRiskBttn() {
			CommonMethods.scrollToElement(checkRiskBttn);
			checkRiskBttn.click();
		}
		public boolean isdiabetesPopUpDisplayed() {
			CommonMethods.waitForElementVisibilityOf(diabetesPopUp);
			return diabetesPopUp.isDisplayed();
		}
}
