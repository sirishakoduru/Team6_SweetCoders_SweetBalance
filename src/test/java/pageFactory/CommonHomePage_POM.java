package pageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class CommonHomePage_POM {

	private WebDriver driver = null;
	
	@FindBy(xpath = "//div[text()='SweetBalance']") private WebElement Appname;
	@FindBy(xpath = "//*[text()=' Login']") private WebElement loginbttn;
	@FindBy(xpath = "//input[@placeholder='Enter email']") private WebElement enterEmail;
    @FindBy(xpath = "//button[text()='Continue with email']") private WebElement continueWithemail;
    @FindBy(xpath = "//input[@name='password']") private WebElement enterPassword;
    @FindBy(xpath = "//button[text()='Sign in']") private WebElement signInBttn;
    @FindBy(xpath = "//span[contains(@class, 'font-semibold')]") private WebElement appNameTextAfterSignIn;
    @FindBy(xpath = "//*[contains(@class, 'text-white/80')]")  private WebElement userNameAfterSignIn;
    @FindBy(xpath = "//*[text()='Logout']") private WebElement logoutbttn;
	@FindBy(xpath = "//*[contains(@class, 'flex space-x-8')]") private WebElement topNavigationBar;
	@FindBy(xpath = "//*[text()='Home']") private WebElement homebttn;
	@FindBy(xpath = "//*[text()='Dashboard']") private WebElement dashboardBttn;
	@FindBy(xpath = "//*[text()='Education']") private WebElement educationBttn;
	@FindBy(xpath = "//*[text()='Current Status']") private WebElement currentStatus;
	//@FindBy(xpath = "//*[text()='Last updated:']") private WebElement lastUpdated;
	@FindBy(xpath = "//div[starts-with(text(),'Last updated:')]") private WebElement lastUpdated;
	//@FindBy(xpath = "//*[contains(@class, 'text-white/80')]")  private WebElement timeStamp;
	@FindBy(xpath = "//*[text()='Latest HbA1c']") private WebElement latestHbA1c;
	@FindBy(xpath = "//*[text()='BMI']") private WebElement BMI;
	@FindBy(xpath = "//*[text()='Avg Blood Sugar']") private WebElement bloodSugarLevel;
	@FindBy(xpath = "//*[contains(@class, 'font-bold text-fuchsia-500')]") private WebElement HbA1CValue;
	@FindBy(xpath = "//*[contains(@class, 'text-sm font-bold text-blue-500')]") private WebElement bmiValue;
	@FindBy(xpath = "//*[contains(@class, 'text-sm font-bold text-rose-500')]") private WebElement bloodSugarValue;
	//@FindBy(xpath = "//span[contains(@class, 'text-3xl font-bold text-gradient bg-clip-text text-transparent bg-gradient-to-r from-violet-600 to-fuchsia-600')]") private WebElement HbA1CRange;
	@FindBy(xpath = "//*[text()='9']") private WebElement HbA1CRange;
	//@FindBy(xpath = "//span[contains(@class, 'bg-gradient-to-r from-indigo-600 to-purple-600')]") private WebElement BMIRange;
	@FindBy(xpath = "//*[text()='12.1']") private WebElement BMIRange;
	//@FindBy(xpath = "//span[contains(@class, 'bg-gradient-to-r from-pink-600 to-rose-600')]") private WebElement bloodSugarRange;
	@FindBy(xpath = "//*[text()='258']") private WebElement bloodSugarRange;
	@FindBy(xpath = "//*[contains(@class, 'text-xl font-bold text-violet-600')]") private WebElement todayMealPlan;
//	@FindBy(xpath = "//*[contains(@class, 'flex rounded-full bg-gray-100')]") private List<WebElement> navBarForMeal;
	@FindBy(xpath = "//*[text()='Breakfast']" ) private WebElement breakfastBttn;
	@FindBy(xpath = "//*[text()='Lunch']" ) private WebElement lunchBttn;
	@FindBy(xpath = "//*[text()='Dinner']" ) private WebElement dinnerBttn;
	@FindBy(xpath = "//*[text()='Snacks']" ) private WebElement snacksBttn;
	@FindBy(xpath = "//*[contains(@class, 'flex flex-col space-y-2 p-4')]") private WebElement leftBarContainer;
	@FindBy(xpath = "//*[contains(@class, 'flex flex-col space-y-2 p-4')]") private List<WebElement> listLeftBarContainer;
	@FindBy(xpath = "//*[text()='Meal Plan']") private WebElement mealPlanBttn;
	@FindBy(xpath = "//*[text()='Exercise']") private WebElement excerciseBttn;
	@FindBy(xpath = "//*[contains(@class, 'lucide lucide-utensils-crossed h-6 w-6 mx-auto')]") private WebElement mealSymbol;
	@FindBy(xpath = "//*[contains(@class,'lucide lucide-dumbbell h-6 w-6 mx-auto')]") private WebElement excerciseSymbol;
	@FindBy(xpath = "//*[text()='View Full Meal Plan']" ) private WebElement viewfullMealPlan;
	@FindBy(xpath = "//*[contains(@class, 'bg-white/70 backdrop-blur-lg rounded-2xl p-6 shadow-lg')]/div") private WebElement breakfastDetails;
	@FindBy(xpath = "//*[contains(@class, 'bg-white/70 backdrop-blur-lg rounded-2xl p-6 shadow-lg')]/div") private WebElement lunchDetails;
	@FindBy(xpath = "//*[contains(@class, 'bg-white/70 backdrop-blur-lg rounded-2xl p-6 shadow-lg')]/div") private WebElement dinnerDetails;
	@FindBy(xpath = "//*[contains(@class, 'bg-white/70 backdrop-blur-lg rounded-2xl p-6 shadow-lg')]/div") private WebElement snacksDetails;
	
	@FindBy(xpath = "//*[text()='Pre-Meal']") private WebElement titlePremeal;
	@FindBy(xpath = "//*[contains(@class,'flex rounded-full bg-gray-100/60 p-1 mb-6')]/../div[2]/div/div[1]/div") private WebElement detailsPreMeal;
	@FindBy(xpath = "//*[contains(@class,'text-gray-800 font-medium')]") private WebElement itemPreMeal;
	
	@FindBy(xpath = "//*[contains(@class, 'flex items-center text-sm text-gray-500 mt-1 space-x-4')]/span[1]") private List<WebElement> timeElements;
	@FindBy(xpath = "//span[contains(text(), 'calories')]") private WebElement caloriesPremeal;
	@FindBy(xpath = "//*[contains(@class,'inline-flex items-center px-2 py-1 rounded-full bg-emera')]") private WebElement carbs;
	@FindBy(xpath = "//*[contains(@class,'inline-flex items-center px-2 py-1 rounded-full bg-pink-100 text-xs')]") private WebElement protein;
	@FindBy(xpath = "//*[contains(@class,'inline-flex items-center px-2 py-1 rounded-full bg-violet-100 text-xs')]") private WebElement fat;
	@FindBy(xpath = "//*[contains(@class,'inline-flex items-center px-2 py-1 rounded-full bg-blue-100 text-xs')]") private WebElement fiber;
	@FindBy(xpath = "//*[contains(@class,'flex justify-between mb-1.5')]/span[2]") private List<WebElement> caloriesWeight;
	@FindBy(xpath = "//*[text()='Calories']") private WebElement caloriesText;
	
	public CommonHomePage_POM() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public String getAppnameText() {
		System.out.println("Name of app is: " +Appname.getText());
        return Appname.getText();
    }	
	public void clickLoginBttn() {
		CommonMethods.waitForElementTobeClick(loginbttn);
		loginbttn.click();
	}
	public void enterEmailInTextBox(String email) {
		enterEmail.clear();
		enterEmail.sendKeys(email);
	}
    public void clickContinueWithEmail() {
    	CommonMethods.waitForElementTobeClick(continueWithemail);
    	continueWithemail.click();
    }
    public void clickSignInbttn() {
    	CommonMethods.waitForElementVisibilityOf(signInBttn);
    	signInBttn.click();
    }
	public void enterPasswordInTextBox(String password) {
		CommonMethods.waitForElementVisibilityOf(enterPassword);
		enterPassword.clear();
		enterPassword.sendKeys(password);
	}
	public String getAppnameTextAfterSignIn() {
		CommonMethods.waitForElementVisibilityOf(appNameTextAfterSignIn);
		System.out.println("Name of app is: " +appNameTextAfterSignIn.getText());
        return appNameTextAfterSignIn.getText();
    }
	public String getUsernameTextAfterSignIn() {
		CommonMethods.waitForElementVisibilityOf(userNameAfterSignIn);
		System.out.println("Name of user is: " +userNameAfterSignIn.getText());
        return userNameAfterSignIn.getText();
    }
	public boolean isLogoutDisplayed() {
		CommonMethods.waitForElementVisibilityOf(logoutbttn);
		return logoutbttn.isDisplayed();
	}
	public boolean isTopNavBarDisplayed() {
		CommonMethods.waitForElementVisibilityOf(topNavigationBar);
		return topNavigationBar.isDisplayed();
	}
	public boolean isHomeDisplayed() {
		CommonMethods.waitForElementVisibilityOf(homebttn);
		return homebttn.isDisplayed();
	}
	public boolean isDashboardDisplayed() {
		CommonMethods.waitForElementVisibilityOf(dashboardBttn);
		return dashboardBttn.isDisplayed();
	}
	public boolean isEducationDisplayed() {
		CommonMethods.waitForElementVisibilityOf(educationBttn);
		return educationBttn.isDisplayed();
	}
	public boolean isCurrentStatusDisplayed() {
		CommonMethods.waitForElementVisibilityOf(currentStatus);
		return currentStatus.isDisplayed();
	}
	public boolean isLastUpdatedDisplayed() {	
		CommonMethods.waitForElementVisibilityOf(lastUpdated);
		return lastUpdated.isDisplayed();
	}
	public String getlastUpdatedText() {
		LoggerLoad.info("Last updated text: " +lastUpdated.getText());
		return lastUpdated.getText();
	}
//	public boolean isTimestampDisplayed() {               //Need to modify
//		return timeStamp.isDisplayed();
//	}
	public boolean islatestHbA1cDisplayed() {
		CommonMethods.waitForElementVisibilityOf(latestHbA1c);
		return latestHbA1c.isDisplayed();
	}
	public boolean isBMIdisplayed() {
		CommonMethods.waitForElementVisibilityOf(BMI);
		return BMI.isDisplayed();
	}
	public boolean isbloodSugarLeveldisplayed() {
		CommonMethods.waitForElementVisibilityOf(bloodSugarLevel);
		return bloodSugarLevel.isDisplayed();
	}
	public String getHbA1CValueText() {
		LoggerLoad.info("Value of HbA1C is: " +HbA1CValue.getText());
		return HbA1CValue.getText();
	}	
	public String getbmiValueText() {
		LoggerLoad.info("Value of HbA1C is: " +bmiValue.getText());
		return bmiValue.getText();
	}
	public String getbloodSugarValueText() {
		CommonMethods.waitForElementVisibilityOf(bloodSugarValue);
		LoggerLoad.info("Value of HbA1C is: " +bloodSugarValue.getText());
		return bloodSugarValue.getText();
	}
	public double getHbA1CRangeText() {
		CommonMethods.waitForElementVisibilityOf(HbA1CRange);
		double hba1c = Double.parseDouble(HbA1CRange.getText());
		LoggerLoad.info("Float Value of HbA1C is: " +hba1c);
		return hba1c;
	}	
	public float getbmiRangeText() {
		CommonMethods.waitForElementVisibilityOf(BMIRange);
		float bmi = Float.parseFloat(BMIRange.getText());
		LoggerLoad.info("Float Value of BMI is: " +bmi);
		return bmi;
	}
	public int getbloodSugarRangeText() {
		CommonMethods.waitForElementVisibilityOf(bloodSugarRange);
//		String text = bloodSugarRange.getText();
//		LoggerLoad.info("Value of blood sugar is: " +text);		
//		String cleanedText = bloodSugarRange.getText().trim().replaceAll("[^0-9]", "");
		int bloodSugar = Integer.parseInt(bloodSugarRange.getText());
		LoggerLoad.info("Integer Value of BMI is: " +bloodSugar);
		return bloodSugar;
	}
	public boolean istodayMealPlandisplayed() {
		CommonMethods.scrollToElement(todayMealPlan);
		return todayMealPlan.isDisplayed();
	}
	public List<WebElement> getNavBarMealItems() {
		return Arrays.asList(breakfastBttn, lunchBttn, dinnerBttn, snacksBttn);
	}
	public String breakfastColour() {
		String backgroundColor = breakfastBttn.getCssValue("background-color");
		return backgroundColor;
	}
	public boolean isleftBarContainerdisplayed() {
		return leftBarContainer.isDisplayed();
	}
	public List<String> retriveLeftBarItems() {
		List<String> itemTexts = new ArrayList<String>();
		for (WebElement item : listLeftBarContainer) {
			itemTexts.add(item.getText());
		}
		return itemTexts;
	}
	public String getmealPlanText() {
		CommonMethods.waitForElementVisibilityOf(mealPlanBttn);
		return mealPlanBttn.getText();
	}
	public String getexcerciseText() {
		CommonMethods.waitForElementVisibilityOf(excerciseBttn);
		return excerciseBttn.getText();
	}
	public boolean ismealSymbolDisplayed() {
		CommonMethods.waitForElementVisibilityOf(mealSymbol);
		return mealSymbol.isDisplayed();
	}
	public boolean isexcerciseSymbolDisplayed() {
		CommonMethods.waitForElementVisibilityOf(excerciseSymbol);
		return excerciseSymbol.isDisplayed();
	} 
	public String getviewfullMealPlanText() {
		CommonMethods.waitForElementVisibilityOf(viewfullMealPlan);
		return viewfullMealPlan.getText();
	}
	public void clickbreakfast() {
		CommonMethods.waitForElementTobeClick(breakfastBttn);;
		breakfastBttn.click();
	}
	public void clicklunch() {
		CommonMethods.waitForElementTobeClick(lunchBttn);
		lunchBttn.click();
	}
	public void clickdinner() {
		CommonMethods.waitForElementTobeClick(dinnerBttn);
		dinnerBttn.click();
	}
	public void clicksnacks() {
		CommonMethods.waitForElementTobeClick(snacksBttn);
		snacksBttn.click();
	}
	public boolean isbreakfastDetailsDisplayed() {
		CommonMethods.waitForElementVisibilityOf(breakfastDetails);
		return breakfastDetails.isDisplayed();
	}
	public boolean islunchDetailsDisplayed() {
		CommonMethods.waitForElementVisibilityOf(lunchDetails);
		return lunchDetails.isDisplayed();
	}
	public boolean isdinnerDetailsDisplayed() {
		CommonMethods.waitForElementVisibilityOf(dinnerDetails);
		return dinnerDetails.isDisplayed();
	}
	public boolean issnacksDetailsDisplayed() {
		CommonMethods.waitForElementVisibilityOf(snacksDetails);
		return snacksDetails.isDisplayed();
	}
	public void clickmealPlanBttn() {
		CommonMethods.waitForElementTobeClick(mealPlanBttn);
		mealPlanBttn.click();
	}
	public void clickexcerciseBttn() {
		CommonMethods.waitForElementTobeClick(excerciseBttn);
		excerciseBttn.click();
	}
	public boolean istitlePremealDisplayed() {
		CommonMethods.waitForElementVisibilityOf(titlePremeal);
		return titlePremeal.isDisplayed();
	}
	public boolean isdetailsPreMealDisplayed() {
		CommonMethods.waitForElementVisibilityOf(detailsPreMeal);
		return detailsPreMeal.isDisplayed();
	}
	public boolean isitemPreMealDisplayed() {
		CommonMethods.waitForElementVisibilityOf(itemPreMeal);
		return itemPreMeal.isDisplayed();
	}
	public boolean iscaloriePreMealDisplayed() {
		CommonMethods.waitForElementVisibilityOf(caloriesPremeal);
		return caloriesPremeal.isDisplayed();
	}
	public List<String> retrivetimeElementsTexts() {
		List<String> itemTexts = new ArrayList<String>();
		for (WebElement item : timeElements) {
			itemTexts.add(item.getText());
		}
		return itemTexts;
	}
	public String getCarbsBackgroundcolour() {
		String carbColour = carbs.getCssValue("background-color");
		return carbColour;
	}
	public String getproteinBackgroundcolour() {
		String proteinColour = protein.getCssValue("background-color");
		return proteinColour;
	}
	public String getfatBackgroundcolour() {
		String fatColour = fat.getCssValue("background-color");
		return fatColour;
	}
	public String getfiberBackgroundcolour() {
		String fiberColour = fiber.getCssValue("background-color");
		return fiberColour;
	}
	public List<String> getcaloriesWeight() {		
		List<String> itemTexts = new ArrayList<String>();
		for(WebElement item : caloriesWeight) {
			itemTexts.add(item.getText());
		}
		return itemTexts;
	}
	public String  getcaloriesText() {
		CommonMethods.waitForElementVisibilityOf(caloriesText);
		return caloriesText.getText();
	}
}

