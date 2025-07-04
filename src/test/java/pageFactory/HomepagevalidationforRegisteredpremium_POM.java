package pageFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import driver.DriverFactory;
import utilities.ConfigReader;
import static org.junit.Assert.*;
public class HomepagevalidationforRegisteredpremium_POM {
	String baseURL = ConfigReader.baseUrl();
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
    
    public String auth_page = "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/auth";

    public HomepagevalidationforRegisteredpremium_POM() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

 // WebElements with more stable locators
    @FindBy(id = ":r0:-form-item")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/form/button")
    private WebElement continueemail;
    @FindBy(xpath = "//*[@id=\":r7:-form-item\"]/input")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/form/button")
    private WebElement signin;// Login Method with explicit waits
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/nav/div/div/button[1]")
     WebElement message;//
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[1]/div[1]/button")
    WebElement challengeBanner;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[1]/div[1]/button")
    WebElement challengeText;

    @FindBy(xpath = " //*[@id=\"root\"]/div[1]/main/div[1]/div[2]/div/div[4]/div/div[1]/div/img")
    WebElement genderImage;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[1]/div[2]/div/div[4]/div/div[1]/div/span")
    WebElement emojiTopRight;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[1]/div[2]/div/div[4]/div/div[2]/div/button")
    WebElement moodLabel;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/div[2]/button")
    WebElement logButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[1]/div[2]/div/div[4]/div/div[2]/div/div")
    WebElement moodText;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[2]/button")
    WebElement weeklyPlanBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/h2")
    WebElement recordNewData;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[1]/span")
    WebElement btnBloodGlucose;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    WebElement btnPhysicalActivity;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[3]")
    WebElement btnFoodIntake;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[4]")
    WebElement btnMedication;

    // Icons
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[1]/span")
    WebElement iconBlood;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    WebElement iconPhysical;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[3]")
    WebElement iconFood;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[4]")
    WebElement iconPill;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[2]")
    WebElement mealplan;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/h3")
    WebElement mealtext;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/h3/span")
    WebElement alaramicon;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[4]")
    WebElement snack;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/h3")
    WebElement calorie;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[2]/h3")
    WebElement mainmeal;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div[1]")
    WebElement dish;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[2]/h3/span")
    WebElement mealicon;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/div/div[2]/span[1]")
    WebElement time;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[3]/button[2]")
    WebElement partiallycompleted;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[3]/button[3]")
    WebElement notcompleted;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[3]/button[1]")
    WebElement completed;
    /////
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[2]")
    WebElement mainlunch;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[3]")
    WebElement maindinner;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[4]")
    WebElement mainsnack;
    @FindBy(xpath = "//*[@id=\"radix-:r9:\"]")
    WebElement subtext;
    @FindBy(xpath = "//*[@id=\"radix-:r8:\"]/div[2]/button[1]")
   WebElement firstoption;
   @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[2]/button")
    WebElement weekly;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[1]")
    WebElement blood;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    WebElement physical;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[3]")
    WebElement intake;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[4]")
    WebElement medic;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/div/div[2]/button")
    WebElement out1;
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/nav/div/div/button[3]")
    WebElement board;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[1]/h2")
    WebElement flexCardSubtitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/h3")
    WebElement preMealCal;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/h3")
    WebElement mealCal;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/h3")
    WebElement totalCal;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[1]/div/div[1]")
    WebElement calorieInfo;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    WebElement donutChart;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    List<WebElement> donutSegments;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    List<WebElement> macroPercentages;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    List<WebElement> legendLabels;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    WebElement barChart;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[3]/div/button[2]")
    List<WebElement> macroBars;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/h3")
    WebElement calorie1;
    
    // Action Methods
    public void login() {
        driver.get(auth_page);
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("manasa.venna@yahoo.com");
        continueemail.click();
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys("number@123");
        signin.click();
        waitForPageToLoad();
    }
    
    private void waitForPageToLoad() {
        try {
            Thread.sleep(2000); // Brief pause for page transitions
            wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String message() {
    	String value=message.getText();
    	return value;
    }
    public void banner(){
    	login();
    System.out.println("the user should see the banner with title");
    }
    public String getChallengebanner() {
    	String value=challengeBanner.getText();
    	return value;
    }
    public void text(){
    	login();
    	Assert.assertTrue("Challenge text is not visible", isChallengeTextVisible());
    //System.out.println("the user should see the banner with title");
    }

    public boolean isChallengeTextVisible() {
        return challengeBanner.isDisplayed();
    }
    public void image() {
    	login();
    	Assert.assertTrue("image is not visible", isGenderImageVisible());
    }

    public boolean isGenderImageVisible() {
        return genderImage.isDisplayed();
    }
    public void emoji() {
    	login();
    	Assert.assertTrue("emoji is not visible", isEmojiVisible());
    }

    public boolean isEmojiVisible() {
        return emojiTopRight.isDisplayed();
    }
    public void mood() {
    	login();
    	Assert.assertTrue("mood is not visible", isMoodLabelVisible());
    }

    public boolean isMoodLabelVisible() {
        return moodLabel.isDisplayed();
    }
    public void log() {
    	login();
    	Assert.assertTrue("logout is not visible", isLogButtonVisible());
    }

    public boolean isLogButtonVisible() {
        return logButton.isDisplayed();
    }
    public void moodtext() {
    	login();
    }

    public String getMoodText() {
        return moodText.getText();
    }
    public void weekplan() {
    	login();
    	Assert.assertTrue("weekplan is not visible", isWeeklyPlanVisible());
    }
    public boolean isWeeklyPlanVisible() {
        return weeklyPlanBtn.isDisplayed();
    }
    public void record() {
    	login();
    	Assert.assertTrue("record is not visible", isRecordNewDataVisible());
    }

    public boolean isRecordNewDataVisible() {
        return recordNewData.isDisplayed();
    }
    public void buttonpresent() {
    	login();
    	Assert.assertTrue("button present is not visible", areAllButtonsPresent());
    }

    public boolean areAllButtonsPresent() {
        return btnBloodGlucose.isDisplayed()
                && btnPhysicalActivity.isDisplayed()
                && btnFoodIntake.isDisplayed()
                && btnMedication.isDisplayed();
    }
    
    public void iconspresent() {
    	login();
    	Assert.assertTrue("icons present is not visible", areAllIconsPresent());
    }
    public boolean areAllIconsPresent() {
        return iconBlood.isDisplayed()
                && iconPhysical.isDisplayed()
                && iconFood.isDisplayed()
                && iconPill.isDisplayed();
    }
    public void mealplan() {
    	login();
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
         mealplan.click();
    }
    public String plan() {
    	 return mealtext.getText();
    }
    //public String mealplan() {
        //login();
       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,500)");
       // mealplan.click();
        //waitForPageToLoad(); // Optional, if needed
       // return mealtext.getText().trim();
    public void alaram() {
    	login();
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Assert.assertTrue("icon is not visible", isalaramiconvisible());
    }
    public boolean isalaramiconvisible() {
    	 return alaramicon.isDisplayed();
    }

    public void premeal() {
    	login();
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Assert.assertTrue("premeal is not visible", ispremealvisible());
    }
    public boolean ispremealvisible() {
    	 return mealtext.isDisplayed();
    }
    public void snack() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("premeal is not visible", ispremealentryvisible());
       snack.click();
    }
    public boolean ispremealentryvisible() {
    	return mealtext.isDisplayed();
    }
    public void calorie() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("calorie is not visible", isCalorievisible());
       snack.click();
    }
    public boolean isCalorievisible() {
    	return calorie.isDisplayed();
    }
    public void mainmeal() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("mainmeal is not visible", ismainmealvisible());
       snack.click();
    }
    public boolean ismainmealvisible() {
    	return mainmeal.isDisplayed();
    }
    public void dish() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("dish is not visible", isdishvisible());
       snack.click();
    }
    public boolean isdishvisible() {
    	return dish.isDisplayed();
    }
    public void sub() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("sub meal is not visible", issubmealvisible());
    }
    public boolean issubmealvisible() {
    	return mainmeal.isDisplayed();
    }
    public boolean mealicon() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
      // Assert.assertTrue("meal icon is not visible", ismealiconvisible());
       return mealicon.isDisplayed();
    }
    public void time() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("time format is not visible", istimeformatvisible());
    }
    public boolean istimeformatvisible() {
    	return time.isDisplayed();
    }
    public void breakfast() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("breakfast AM is not visible", isbreakfastAMvisible());
    }
    public boolean isbreakfastAMvisible() {
    	return time.isDisplayed();
    }
    public void lunch() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("lunch PM is not visible", islunchPMvisible());
    }
    public boolean islunchPMvisible() {
    	return time.isDisplayed();
    }
    public void dinner() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("dinner PM is not visible", isdinnerPMvisible());
    }
    public boolean isdinnerPMvisible() {
    	return time.isDisplayed();
    }
    public void mainbreakfast() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("main breakfast is not visible", ismainbreakfastvisible());
    }
    public boolean ismainbreakfastvisible() {
    	return time.isDisplayed();
    }
    public void mainlunch() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("main lunch is not visible", ismainlunchvisible());
       mainlunch.click();
    }
    public boolean ismainlunchvisible() {
    	return time.isDisplayed();
    }
    public void maindinner() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("main dinner is not visible", ismaindinnervisible());
       maindinner.click();
    }
    public boolean ismaindinnervisible() {
    	return time.isDisplayed();
    }
    public void mainsnack() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("main snack is not visible", ismainsnackvisible());
       mainsnack.click();
    }
    public boolean ismainsnackvisible() {
    	return time.isDisplayed();
    }
    public void Calorie() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("calorie is not visible", iscalorievisible());
    }
    public boolean iscalorievisible() {
    	return calorie.isDisplayed();
    }
    public void Calorietext() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("calorie text not visible", iscalorietextvisible());
    }
    public boolean iscalorietextvisible() {
    	return calorie.isDisplayed();
    }
    public void completed() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("completed not visible", iscompletedtextvisible());
    }
    public boolean iscompletedtextvisible() {
    	return completed.isDisplayed();
    }
    
    public void partiallycompleted() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("partiallycompleted not visible", ispartiallycompletedtextvisible());
    }
    public boolean ispartiallycompletedtextvisible() {
    	return partiallycompleted.isDisplayed();
    }
    
    public void notcompleted() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("notcompleted not visible", isnotcompletedtextvisible());
    }
    public boolean isnotcompletedtextvisible() {
    	return notcompleted.isDisplayed();
    }
    public String getcompletedColor() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       completed.click();
        wait.until(ExpectedConditions.visibilityOf(completed));
        return completed.getCssValue("background-color");
    }
    
    public String getpartiallycompletedColor() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       partiallycompleted.click();
        wait.until(ExpectedConditions.visibilityOf(partiallycompleted));
        return partiallycompleted.getCssValue("background-color");
    }
    public String getnotcompletedColor() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       notcompleted.click();
        wait.until(ExpectedConditions.visibilityOf(notcompleted));
        return notcompleted.getCssValue("background-color");
    }//////////////////
    public String getFlexCardSubtitle() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return flexCardSubtitle.getText();
    }

    public String getPreMealCalories() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return preMealCal.getText();
    }

    public int getMealCalories() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return Integer.parseInt(mealCal.getText().replace("kcal", "").trim());
    }

    public int getTotalCalories() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return Integer.parseInt(totalCal.getText().replace("kcal", "").trim());
    }

    public boolean isCalorieInfoOnRight() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        String floatStyle = calorieInfo.getCssValue("float");
        return floatStyle.equalsIgnoreCase("right") || floatStyle.contains("right");
    }

    public boolean isDonutChartVisible() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return donutChart.isDisplayed();
    }

    public boolean areDonutChartColorsDistinct() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        Set<String> colors = donutSegments.stream()
            .map(e -> e.getCssValue("background-color"))
            .collect(Collectors.toSet());
        return colors.size() >= 4;
    }

    public boolean doMacroPercentagesMatchExpected() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        int[] expected = {40, 30, 20, 10};
        for (int i = 0; i < macroPercentages.size(); i++) {
            int val = Integer.parseInt(macroPercentages.get(i).getText().replace("%", "").trim());
            if (val != expected[i]) return false;
        }
        return true;
    }

    public boolean areSegmentColorsConsistentWithLabels() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        for (int i = 0; i < donutSegments.size(); i++) {
            if (!donutSegments.get(i).getCssValue("background-color")
                .equals(legendLabels.get(i).getCssValue("color"))) {
                return false;
            }
        }
        return true;
    }

    public boolean isBarChartVisible() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return barChart.isDisplayed();
    }

    public boolean areAllMacroBarsVisible() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return macroBars.size() >= 4;
    }

    public boolean areBarChartValuesConsistent() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        for (WebElement bar : macroBars) {
            String label = bar.getAttribute("data-label");
            String value = bar.getText().replace("g", "").trim();
            if (label == null || value.isEmpty()) return false;
        }
        return true;
    }

    public int getTotalMacroPercentage() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return macroPercentages.stream()
            .mapToInt(e -> Integer.parseInt(e.getText().replace("%", "").trim()))
            .sum();
    }

    public boolean isFullMealPlanPageDisplayed1() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
        return driver.getCurrentUrl().contains("/full-meal-plan");
    }


    //////homepage challenge
    public void challenge() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("challenge popup  not visible", ischallengepopuptextvisible());
       challengeBanner.click();
    }
    public boolean ischallengepopuptextvisible() {
    	return challengeBanner.isDisplayed();
    }
    public void subtext() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("subtext  not visible", issubtextvisible());
       challengeBanner.click();
    }
    public boolean issubtextvisible() {
    	return subtext.isDisplayed();
    }
    public void twooptions() {
    	subtext();
       //Assert.assertTrue("twooptions  not visible", istwooptionsvisible());
    //}
   // public boolean istwooptionsvisible() {
    //	return subtext.isDisplayed();
    }
    public void firstoptions() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
      // Assert.assertTrue("firstoptions  not visible", isfirstoptionsvisible());
       challengeBanner.click();
    //}
   // public boolean isfirstoptionsvisible() {
    //	return firstoption.isDisplayed();
    }
    ///////////verificationbutton
    public void weeklyplan() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("weeklyplan popup  not visible", isweeklypopuptextvisible());
       weekly.click();
    }
    public boolean isweeklypopuptextvisible() {
    	return weekly.isDisplayed();
    }
    public void glucose() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       //Assert.assertTrue("glucose popup  not visible", isglucosepopuptextvisible());
      //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      // WebElement button = wait.until(ExpectedConditions.elementToBeClickable(glucose));
       //blood.click();
    //}
    //public boolean isglucosepopuptextvisible() {
    //	return blood.isDisplayed();
    }
    public void activity() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("activity popup  not visible", isactivitypopuptextvisible());
       physical.click();
    }
    public boolean isactivitypopuptextvisible() {
    	return physical.isDisplayed();
    }
    public void food() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("food popup  not visible", isfoodpopuptextvisible());
       intake.click();
    }
    public boolean isfoodpopuptextvisible() {
    	return intake.isDisplayed();
    }
    public void medication() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("medication popup  not visible", ismedicationpopuptextvisible());
       medic.click();
    }
    public boolean ismedicationpopuptextvisible() {
    	return medic.isDisplayed();
    }
    public void logout() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("logout popup  not visible", islogoutpopuptextvisible());
       out1.click();
    }
    public boolean islogoutpopuptextvisible() {
    	return out1.isDisplayed();
    }
    //logstatus
    public void out() {
    	login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       Assert.assertTrue("board popup  not visible", isboardpopuptextvisible());
       board.click();
    }
    public boolean isboardpopuptextvisible() {
    	return board.isDisplayed();
    }
    }

    

    
