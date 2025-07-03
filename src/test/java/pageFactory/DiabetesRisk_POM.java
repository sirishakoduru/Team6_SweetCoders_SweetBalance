package pageFactory;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.CommonMethods;

public class DiabetesRisk_POM {

	private WebDriver driver = null;
	
	@FindBy(xpath = "//*[text()='Check Your Risk ']") private WebElement checkRiskBttn;
	@FindBy(xpath = "//*[text()='Diabetes Risk Analyzer']") private WebElement diabetesPopUp;
	@FindBy(xpath = "//*[contains(text(),'Answer a few questions to assess your')]") private WebElement answerQues;
	@FindBy(xpath = "//*[contains(text(),'Cancel')]") private WebElement cancelBttn;
	@FindBy(xpath = "//*[contains(text(),'Calculate Risk')]") private WebElement calculateRiskBttn;
	@FindBy(id = "risk_age") private WebElement ageInput;
	@FindBy(id = "risk_weight") private WebElement weightInput;
	@FindBy(id = "risk_familyHistory") private WebElement familyHistoryInput;
	@FindBy(id = "risk_activity") private WebElement physicalActivity;
	@FindBy(id = "risk_bloodPressure") private WebElement bloodPressure;
	@FindBy(id = "risk_diet") private WebElement dietQuality;
	@FindBy(xpath = "//*[@value='active']") private WebElement activePA;
	@FindBy(xpath = "//*[@value='moderate']") private WebElement moderatePA;
	@FindBy(xpath = "//*[@value='sedentary']") private WebElement sedentaryPA;
	@FindBy(xpath = "//*[@value='normal']") private WebElement normalBP;
	@FindBy(xpath = "//*[@value='elevated']") private WebElement elevatedBP;
	@FindBy(xpath = "//*[@value='high']") private WebElement highBP;
	@FindBy(xpath = "//*[@value='excellent']") private WebElement excellentDQ;
	@FindBy(xpath = "//*[@value='average']") private WebElement averageDQ;
	@FindBy(xpath = "//*[@value='poor']") private WebElement poorDQ;
	@FindBy(xpath = "//*[text()='Your Diabetes Risk Assessment']") private WebElement assessmentPopUp;
	
	public DiabetesRisk_POM() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public void clickCheckRiskRttn() {
		checkRiskBttn.click();
	}	
	public boolean isdiabetesPopUpDisplayed() {
		CommonMethods.waitForElementVisibilityOf(diabetesPopUp);
		return diabetesPopUp.isDisplayed();
	}
	public String getanswerQuestext() {
		return answerQues.getText();
	}
	public boolean iscancelBttnDisplayed() {
		CommonMethods.waitForElementVisibilityOf(cancelBttn);
		return cancelBttn.isDisplayed();
	}
	public boolean iscalculateRiskBttnDisplayed() {
		CommonMethods.waitForElementVisibilityOf(calculateRiskBttn);
		return calculateRiskBttn.isDisplayed();
	}
	public boolean iscalculateRiskBttnEnabled() {
		CommonMethods.waitForElementVisibilityOf(calculateRiskBttn);
		return calculateRiskBttn.isEnabled();
	}
	public String getAgeInputType() {
		return ageInput.getAttribute("type");
	}
	public String getWeightInputType() {
		return weightInput.getAttribute("type");
	}
	public boolean isfamilyHistoryInputDisplayed() {
		CommonMethods.waitForElementVisibilityOf(familyHistoryInput);
		return familyHistoryInput.isDisplayed();
	}
	public String getAgeInputplaceholder() {
		return ageInput.getAttribute("placeholder");
	}
	public String getWeightInputplaceholder() {
		return weightInput.getAttribute("placeholder");
	}
	public String getphysicalActivityTagName() {
		return physicalActivity.getTagName();
	}
	public String getbloodPressureTagName() {
		return bloodPressure.getTagName();
	}
	public String getdietQualityTagName() {
		return dietQuality.getTagName();
	}
	public String getphysicalActivityText() {
		return physicalActivity.getText();
	}
	public String getbloodPressureText() {
		return bloodPressure.getText();
	}
	public String getdietQualityText() {
		return dietQuality.getText();
	}
	public void clickCancelBttn() {
		cancelBttn.click();
	}
	public void enterAgeInput() {
	    Random random = new Random();
	    int randomAge = 1 + random.nextInt(140); // 0 to 150
	    ageInput.clear();
		ageInput.sendKeys(String.valueOf(randomAge));
	}
	public void enterWeightInput() {
	    Random random = new Random();
	    int randomAge = 1 + random.nextInt(499); // 0 to 500
	    weightInput.clear();
		weightInput.sendKeys(String.valueOf(randomAge));
	}
	public void clickphysicalActivity() {
		physicalActivity.click();
	}
	public void clickactivePA() {
		activePA.click();
	}
	public void clickmoderatePA() {
		moderatePA.click();
	}
	public void clicksedentaryPA() {
		sedentaryPA.click();
	}
	public void clicknormalBP() {
		normalBP.click();
	}
	public void clickelevatedBP() {
		elevatedBP.click();
	}
	public void clickhighBP() {
		highBP.click();
	}
	public void clickexcellentDQ() {
		excellentDQ.click();
	}
	public void clickaverageDQ() {
		averageDQ.click();
	}
	public void clickpoorDQ() {
		poorDQ.click();
	}
	public void clickcalculateRiskBttn() {
		calculateRiskBttn.click();
	}
	public boolean isassessmentPopUpDisplayed() {
		return assessmentPopUp.isDisplayed();
	}
}
