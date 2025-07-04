package pageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class SubscriptionPage_POM {

	private WebDriver driver = null;
	@FindBy(xpath = "//*[text()='Dashboard']") private WebElement dashboardBttn;
	@FindBy(xpath = "//*[text()='Upgrade to Premium']") private WebElement premiumBttn;
	@FindBy(xpath = "//*[text()='Daily Meal Plan']/..") private WebElement dailyMealFeature;
	@FindBy(xpath = "//*[text()='Weekly Meal Plan']/..") private WebElement weeklyMealFeature;
	@FindBy(xpath = "//*[text()='Personalized Exercise Plan']/..") private WebElement excercisePlan;
	@FindBy(xpath = "//*[text()='10-Day Quick Reversal Plan']/..") private WebElement tendayPlan;
	@FindBy(xpath = "//*[text()='30-Day Blood Sugar Reduction Plan']/..") private WebElement thirtyDayPlan;
	@FindBy(xpath = "//*[text()='Glucose Level Graph']/..") private WebElement gloucoseGraph;
	@FindBy(xpath = "//*[text()='BMI Calculation']/..") private WebElement bmiCalculation;
	@FindBy(xpath = "//*[text()='Downloadable Meal Plan PDF']/..") private WebElement mealPlanPDF;
	@FindBy(xpath = "//*[text()='Reminders (Medication, Appointments, Health Tasks)']/..") private WebElement raminderTasks;
	@FindBy(xpath = "//*[text()='Continue Free']") private WebElement continueFreeBttn;
	@FindBy(xpath = "//*[text()='Upgrade to Premium']") private WebElement upgradPremiumBttn;
	@FindBy(xpath = "//*[text()='Free Account']") private WebElement freeAccountLabel;
	@FindBy(xpath = "//*[text()='Premium Account']") private WebElement premiumAccountLabel;
	@FindBy(xpath = "//*[contains(@class,'text-xs text-white/70 text-center mt-8')]") private WebElement termCondition;
	@FindBy(xpath = "//*[contains(@class,'text-white/80 text-lg')]") private WebElement upgradPremiumTitle;
	@FindBy(xpath = "//*[contains(@class,'hover:bg-purple-50/50 transition-colors duration-200')]") private List<WebElement> listFeatures ;
	@FindBy(xpath = "//*[text()='Upgrade to Premium']") private WebElement upgradePremiumTitle;
	@FindBy(xpath = "//*[contains(text(),'features to better manage your diabetes.')]") private WebElement manageDiabetes;
	@FindBy(xpath = "//*[text()='Premium Features']") private WebElement premiumFeatures;
	@FindBy(xpath = "//li[contains(@class,'flex items-center')]") private List<WebElement> listPremiunFeatures;
	@FindBy(xpath = "//*[contains(@class,'text-2xl font-bold text-purple-600 mb-2')]") private WebElement priceHeading;
	@FindBy(xpath = "//*[text()='Cancel anytime']") private WebElement cancelAnytime;
	@FindBy(xpath = "//*[text()='Card Number']") private WebElement cardNumber;
	@FindBy(xpath = "//*[text()='Expiration Date']") private WebElement expirationDate;
	@FindBy(xpath = "//*[text()='CVC']") private WebElement cvc;
	@FindBy(xpath = "//*[contains(@class,'inline-flex items-center justify')]") private WebElement submitbttn;
	@FindBy(xpath = "//*[contains(@class,'text-xs text-gray-500 mt-6')]") private WebElement termServiceNotice;
	
	public SubscriptionPage_POM() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public void clickdashboardBttn() {
		CommonMethods.waitForElementVisibilityOf(dashboardBttn);
		dashboardBttn.click();
	}
	public void clickpremiumBttn() {
		CommonMethods.waitForElementTobeClick(premiumBttn);
		premiumBttn.click();
	}
	public String getDailyFreeMark() {
		CommonMethods.waitForElementVisibilityOf(dailyMealFeature);
	    return dailyMealFeature.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getDailyPremiumMark() {
		CommonMethods.waitForElementVisibilityOf(dailyMealFeature);
	    return dailyMealFeature.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getWeeklyFreeMark() {
		CommonMethods.waitForElementVisibilityOf(weeklyMealFeature);
	    return weeklyMealFeature.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getWeeklyPremiumMark() {
		CommonMethods.waitForElementVisibilityOf(weeklyMealFeature);
	    return weeklyMealFeature.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getexcercisePlanFreeMark() {
		CommonMethods.waitForElementVisibilityOf(excercisePlan);
	    return excercisePlan.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getexcercisePlanPremiumMark() {
		CommonMethods.waitForElementVisibilityOf(excercisePlan);
	    return excercisePlan.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String gettendayPlanFreeMark() {
		CommonMethods.waitForElementVisibilityOf(tendayPlan);
	    return tendayPlan.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String gettendayPlanPremiumMark() {
		CommonMethods.waitForElementVisibilityOf(tendayPlan);
	    return tendayPlan.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getthirtyDayPlanFreeMark() {
		CommonMethods.waitForElementVisibilityOf(thirtyDayPlan);
	    return thirtyDayPlan.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getthirtyDayPlanPremiumMark() {
	    return thirtyDayPlan.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getgloucoseGraphFreeMark() {
	    return gloucoseGraph.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getgloucoseGraphPremiumMark() {
	    return gloucoseGraph.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getbmiCalculationFreeMark() {
	    return bmiCalculation.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getbmiCalculationPremiumMark() {
	    return bmiCalculation.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getmealPlanPDFFreeMark() {
	    return mealPlanPDF.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getmealPlanPDFPremiumMark() {
	    return mealPlanPDF.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public String getraminderTasksFreeMark() {
	    return raminderTasks.findElements(By.tagName("td")).get(1).getText().trim();
	}
	public String getraminderTasksPremiumMark() {
	    return raminderTasks.findElements(By.tagName("td")).get(2).getText().trim();
	}
	public boolean iscontinueFreeBttnDisplayed() {
		CommonMethods.waitForElementTobeClick(continueFreeBttn);
		return continueFreeBttn.isDisplayed();
	}
	public boolean isupgradPremiumBttnDisplayed() {
		return upgradPremiumBttn.isDisplayed();
	}
	public boolean isfreeAccountLabelDisplayed() {
		return freeAccountLabel.isDisplayed();
	}
	public boolean ispremiumAccountLabelDisplayed() {
		return premiumAccountLabel.isDisplayed();
	}
	public boolean iscontinueFreeBttnEnabled() {
		return continueFreeBttn.isEnabled();
	}
	public boolean isupgradPremiumBttnEnabled() {
		return upgradPremiumBttn.isEnabled();
	}
	public String getTermConditionText() {
		return termCondition.getText();
	}
	public String getupgradPremiumTitleText() {
		return upgradPremiumTitle.getText();
	}
	public int getNoOflistFeatures() {
		return listFeatures.size();
	}
	public List<String> getColourRightCheckMark() {
		List<String> colorTexts = new ArrayList<String>();
		String checkmark;
		for (WebElement item : listFeatures) {
			LoggerLoad.info("Item text: " +item.getText());
			checkmark = item.findElements(By.tagName("td")).get(1).getText().trim();
			if(checkmark.equals("✓")) {
				colorTexts.add(item.findElements(By.tagName("td")).get(1).getCssValue("color"));
				LoggerLoad.info("Checkmark color: " +item.findElements(By.tagName("td")).get(1).getCssValue("color"));
			}
			checkmark = item.findElements(By.tagName("td")).get(2).getText().trim();
			if(checkmark.equals("✓")) {
				colorTexts.add(item.findElements(By.tagName("td")).get(2).getCssValue("color"));
				LoggerLoad.info("Checkmark color: " +item.findElements(By.tagName("td")).get(2).getCssValue("color"));
			}
		}
		return colorTexts;
	}
	public List<String> getColourCrossCheckMark() {
		List<String> colorTexts = new ArrayList<String>();
		String checkmark;
		for (WebElement item : listFeatures) {
			LoggerLoad.info("Item text: " +item.getText());
			checkmark = item.findElements(By.tagName("td")).get(1).getText().trim();
			if(checkmark.equals("✕")) {
				colorTexts.add(item.findElements(By.tagName("td")).get(1).getCssValue("color"));
				LoggerLoad.info("Checkmark color: " +item.findElements(By.tagName("td")).get(1).getCssValue("color"));
			}
			checkmark = item.findElements(By.tagName("td")).get(2).getText().trim();
			if(checkmark.equals("✕")) {
				colorTexts.add(item.findElements(By.tagName("td")).get(2).getCssValue("color"));
				LoggerLoad.info("Checkmark color: " +item.findElements(By.tagName("td")).get(2).getCssValue("color"));
			}
		}
		return colorTexts;
	}
	public void clickupgradPremiumBttn() {
		CommonMethods.scrollToElement(upgradPremiumBttn);
		upgradPremiumBttn.click();
	}
	public String getupgradePremiumTitleText() {
		return upgradePremiumTitle.getText();
	}
	public String getmanageDiabetesText() {
		return manageDiabetes.getText();
	}
	public String getpremiumFeaturesText() {
		return premiumFeatures.getText();
	}
	public List<String> getlistPremiunFeaturesHeading() {
		List<String> itemTexts = new ArrayList<String>();
		for (WebElement item : listPremiunFeatures) {
			String fullText = item.getText().trim();
			String cleanText = fullText.replace("✓", "").trim();
			itemTexts.add(cleanText);
		}
		return itemTexts;
	}
	public String getpriceHeadingText() {
		CommonMethods.waitForElementVisibilityOf(priceHeading);
		return priceHeading.getText();
	}
	public String getcancelAnytimeText() {
		CommonMethods.waitForElementVisibilityOf(cancelAnytime);
		return cancelAnytime.getText();
	}
	public boolean iscardNumberDisplayed() {
		return cardNumber.isDisplayed();
	}
	public boolean isexpirationDateDisplayed() {
		return expirationDate.isDisplayed();
	}
	public boolean isCVCDisplayed() {
		return cvc.isDisplayed();
	}
	public boolean issubmitbttnDisplayed() {
		return submitbttn.isDisplayed();
	}
	public boolean issubmitbttnEnabled() {
		return submitbttn.isEnabled();
	}
	public boolean istermServiceNoticeDisplayed() {
		return termServiceNotice.isDisplayed();
	}
	public void clickcontinueFreeBttn() {
		continueFreeBttn.click();
	}
}
