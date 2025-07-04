package pageFactory;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class AdditionalFeatureForDashboard_POM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait;
    CommonMethods commonMethods;

    public AdditionalFeatureForDashboard_POM(){
        PageFactory.initElements(driver, this);
        commonMethods = new CommonMethods();
    }

    @FindBy(xpath= "//button[text()='Dashboard']")
    private WebElement dashboardButton;

    //Dashboard page validation for Registered premium account user
    @FindBy(xpath= "//span[@class='ml-1']")
    private WebElement kingSymbolPremiumActivated;
    @FindBy(xpath= "//span[substring(normalize-space(.), string-length(normalize-space(.)) - string-length('Premium Activated') + 1) = 'Premium Activated']")
    private WebElement premiumActivatedText;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/button[1]")
    private WebElement managePremiumButton;
    @FindBy(xpath= "//div[@id='radix-:r0:']")
    private WebElement dialogBox;
    @FindBy(xpath= "//span[text()='Start Date:']")
    private WebElement startDate;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement startDateFormat;
    @FindBy(xpath= "//span[text()='End Date:']")
    private WebElement endDate;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")
    private WebElement endDateFormat;

    //Emotional Well being validations on Premium dashboard
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[4]/div[3]/div[1]/div[1]/span[1]")
    private WebElement emotionalWellBeing;
    @FindBy(xpath= "//label[normalize-space()='How are you feeling today?']")
    private WebElement questionIsDisplayed;
    @FindBy(xpath= "//div[@class='flex justify-between gap-2 mt-2']")
    private WebElement moodEmojisDisplayed;
    @FindBy(xpath= "//label[text()='Notes on your mood']")
    private WebElement notesOnMoodText;
    @FindBy(xpath= "//textarea[@id='notes']")
    private WebElement inputFieldText;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/main[1]/div[4]/div[3]/div[1]/div[4]/div[1]/label[1]")
    private WebElement energyLevelTextWithValue;
    @FindBy(xpath= "//span[@role='slider']")
    private WebElement energyLevelSlider;
    @FindBy(xpath = "//span[normalize-space()='Low']")
    private WebElement lowLabel;
    @FindBy(xpath = "//span[normalize-space()='High']")
    private WebElement highLabel;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[4]/div[3]/div[1]/div[2]/div[1]/button[1]/span[1]")
    private WebElement happyEmoji;
    @FindBy(xpath= "//button[text()='Log Emotional State']")
    private WebElement logEmotionalStateButton;
    @FindBy(xpath= "//div[@class='text-sm opacity-90']")
    private WebElement logEmotionalStateSuccessMessage;

    //User Activity Tracking on premium Dashboard
    @FindBy(xpath= "//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 mb-6']//div[@class='rounded-lg border bg-indigo-200 text-white shadow-lg']")
    private WebElement weeklyChecksCard;
    @FindBy(xpath= "//span[text()='Weekly Checks']")
    private WebElement weeklyChecksTitle;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]/div[2]")
    private WebElement weeklyChecksValue;
    @FindBy(xpath= "//p[normalize-space()='Total log entries per week']")
    private WebElement weeklyChecksText;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-300 text-white shadow-lg']")
    private WebElement exerciseMinuteCard;
    @FindBy(xpath= "//span[text()='Exercise Minutes']")
    private WebElement exerciseMinuteTitle;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-300 text-white shadow-lg']//div[@class='text-3xl font-bold mb-2 text-black/90']")
    private WebElement exerciseMinuteValue;
    @FindBy(xpath= "//p[text()='Target: 150 minutes per week']")
    private WebElement exerciseMinuteText;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-400 text-white shadow-lg']")
    private WebElement medAdherenceCard;
    @FindBy(xpath= "//span[text()='Med Adherence']")
    private WebElement medAdherenceTitle;
    @FindBy(xpath= "//span[normalize-space()='0%']")
    private WebElement medAdherenceValue;
    @FindBy(xpath= "//div[@class='text-xs mt-2 text-black/60']")
    private WebElement medAdherenceText;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-500 text-white shadow-lg']")
    private WebElement carbGoalsCard;
    @FindBy(xpath= "//span[text()='Carb Goals']")
    private WebElement carbGoalsTitle;
    @FindBy(xpath= "//div[normalize-space()='0/28']")
    private WebElement carbGoalsValue;
    @FindBy(xpath= "//p[text()='Weekly meals completed']")
    private WebElement carbGoalsText;


    //Smart Insights Validation on Premium dashboard
    @FindBy(xpath= "//span[text()='Smart Insights']")
    private WebElement smartInsightsSection;
    @FindBy(xpath= "//span[text()='Last 7 days']")
    private WebElement smartInsightsSectionLabel;
    @FindBy(xpath= "//span[normalize-space()='Target Achievement']")
    private WebElement targetAchievementTitle;
    @FindBy(xpath= "//div[@class='border-l-4 border-green-400 pl-3 py-2 bg-white/10 rounded-r']//p[@class='text-xs text-black/80']")
    private WebElement targetAchievementTextDisplay;
    @FindBy(xpath= "//span[normalize-space()='Pattern Detected']")
    private WebElement patternDetectedTitle;
    @FindBy(xpath= "//p[contains(text(),'Your glucose tends to spike between 2-3 PM. Consid')]")
    private WebElement patternDetectedTextDisplay;
    @FindBy(xpath= "//span[normalize-space()='Suggestion']")
    private WebElement suggestionTitle;
    @FindBy(xpath= "//p[contains(text(),'Walking for 15 minutes after dinner has shown to r')]")
    private WebElement suggestionTextDisplay;

    //Manage premium Dialog box Validation
    @FindBy(xpath= "//p[@id='radix-:r2:']")
    private WebElement messageDisplayInDialogBox;
    @FindBy(xpath= "//div[@class='bg-amber-50 p-4 rounded-lg border border-amber-200']")
    private WebElement featuresSectionIsDisplayed;
    @FindBy(xpath= "//div[@class='flex-col-reverse sm:flex-row sm:space-x-2 flex justify-between sm:justify-between gap-4']")
    private WebElement actionButtonsDisplay;
    @FindBy(xpath= "//button[text()='Keep Premium']")
    private WebElement keepPremiumButton;
    @FindBy(xpath= "//button[text()='Cancel Premium']")
    private WebElement cancelPremiumButton;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[2]/ol[1]/li[1]/div[1]/div[2]")
    private WebElement keepPremiumSuccessMessage;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[2]/ol[1]/li[1]/div[1]/div[2]")
    private WebElement cancelPremiumMessage;
    @FindBy(xpath= "/html[1]/body[1]/div[3]/button[1]/*[name()='svg'][1]")
    private WebElement xButton;

    //Action methods
    public void navigatedToDashboardPage() {
        dashboardButton.click();
    }
    public boolean verifyDashboardPageDisplayed() {
        try {
            WebElement dashboardHeader = dashboardButton;
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            LoggerLoad.error("Dashboard page not loaded: " + e.getMessage());
            return false;
        }
    }

//--------------------------Dashboard page validation for Registered premium account user--------------------------//
    public boolean verifyKingSymbolDisplayed() {
        return kingSymbolPremiumActivated.isDisplayed();
    }

    public String getPremiumStatusText() {
        String fullText = premiumActivatedText.getText();
        return fullText.replaceAll("^[^\\p{L}]+", "").trim();
    }

    public boolean verifyManagePremiumButtonVisible() {
        return managePremiumButton.isDisplayed();
    }

    public void clickManagePremiumButton() {
        managePremiumButton.click();
    }

    public boolean verifyDialogBoxVisible() {
        return dialogBox.isDisplayed();
    }

    public boolean isStartDateDisplayed() {
        return startDate.isDisplayed();
    }

    public boolean isEndDateDisplayed() {
        return endDate.isDisplayed();
    }

    public boolean isStartDateInExpectedFormat(String expectedFormat) {
        String actualDate = startDateFormat.getText().trim();
        return commonMethods.isDateInFormat(actualDate, expectedFormat);
    }

    public boolean isEndDateInExpectedFormat(String expectedFormat) {
        String actualDate = endDateFormat.getText().trim();
        return commonMethods.isDateInFormat(actualDate, expectedFormat);
    }


//--------------------------Emotional Well being validations on Premium dashboard---------------------------------//
    public WebElement getEmotionalWellBeingTitle() {
        return emotionalWellBeing;
    }

    public boolean verifyEmotionalWellBeingTitleVisible() {
        return emotionalWellBeing.isDisplayed();
    }

    public boolean verifyQuestionIsDisplayed() {
        return questionIsDisplayed.isDisplayed();
    }

    public boolean verifyMoodEmojisDisplayed() {
        return moodEmojisDisplayed.isDisplayed();
    }

    public boolean verifyNotesOnMoodLabelVisible() {
        return notesOnMoodText.isDisplayed();
    }

    public String getPlaceholderTextOfNotes() {
        return inputFieldText.getAttribute("placeholder");
    }

    public WebElement getInputFieldText() {
        return inputFieldText;
    }
    public void enterTextInNotes(String text) {
        inputFieldText.clear();
        inputFieldText.sendKeys(text);
    }

    public String getEnteredTextFromNotes() {
        return inputFieldText.getAttribute("value");
    }

    public WebElement getEnergyLevelSlider() {
        return energyLevelSlider;
    }
    public boolean verifyEnergyLevelTextDisplayed() {
        return energyLevelTextWithValue.isDisplayed();
    }

    public boolean verifyEnergyLevelSliderVisible() {
        return energyLevelSlider.isDisplayed();
    }
    public void moveEnergySlider(int xOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(energyLevelSlider)
                .moveByOffset(xOffset, 0)
                .release()
                .perform();
    }
    public WebElement getLowLabel() {
        return lowLabel;
    }
    public WebElement getHighLabel() {
        return highLabel;
    }
    public WebElement getEnergyLevelSliderValue() {
        return energyLevelTextWithValue;
    }

    public boolean verifyLogEmotionalStateButtonVisible() {
        return logEmotionalStateButton.isDisplayed();
    }

    public void clickHappyEmoji(){
        happyEmoji.click();
    }

    public void clickLogEmotionalStateButton() {
        logEmotionalStateButton.click();
    }

    public String getLogEmotionalStateSuccessMessage() {
        return logEmotionalStateSuccessMessage.getText();
    }


//---------------------------User Activity Tracking on premium Dashboard------------------------------------------//
    public String getWeeklyChecksTitle() {
        return weeklyChecksTitle.getText().trim();
    }
    public String getWeeklyChecksValue() {
        return weeklyChecksValue.getText().trim();
    }
    public String getWeeklyChecksText() {
        return weeklyChecksText.getText().trim();
    }

    public String getExerciseMinutesTitle() {
        return exerciseMinuteTitle.getText().trim();
    }
    public String getExerciseMinutesValue() {
        return exerciseMinuteValue.getText().trim();
    }
    public String getExerciseMinutesText() {
        return exerciseMinuteText.getText().trim();
    }

    public String getMedAdherenceTitle() {
        return medAdherenceTitle.getText().trim();
    }
    public String getMedAdherenceValue() {
        return medAdherenceValue.getText().trim();
    }
    public String getMedAdherenceText() {
        return medAdherenceText.getText().trim();
    }

    public String getCarbGoalsTitle() {
        return carbGoalsTitle.getText().trim();
    }
    public String getCarbGoalsValue() {
        return carbGoalsValue.getText().trim();
    }
    public String getCarbGoalsText() {
        return carbGoalsText.getText().trim();
    }


//------------------------------Smart Insights Validation on Premium dashboard------------------------------------//
    public boolean verifySmartInsightsTitleVisible() {
        return smartInsightsSection.isDisplayed();
    }

    public boolean verifyLast7DaysLabelVisible() {
        return smartInsightsSectionLabel.isDisplayed();
    }

    public String verifyTargetAchievementTitle(){
        return targetAchievementTitle.getText().trim();
    }
    public String getTargetAchievementText() {
        return targetAchievementTextDisplay.getText().trim();
    }

    public String verifyPatternDetectedTitle(){
        return patternDetectedTitle.getText().trim();
    }

    public String getPatternDetectedText() {
        return patternDetectedTextDisplay.getText().trim();
    }

    public String verifySuggestionTitle(){
        return suggestionTitle.getText().trim();
    }

    public String getSuggestionText() {
        return suggestionTextDisplay.getText().trim();
    }

    public String getSmartInsightsTitleText() {
        return smartInsightsSection.getText().trim();
    }

    public String getSmartInsightsLabelText() {
        return smartInsightsSectionLabel.getText().trim();
    }


//-----------------------------------Manage premium Dialog box Validation----------------------------------------//
    public String getDialogMessage() {
        return messageDisplayInDialogBox.getText().trim();
    }

    public boolean verifyLossFeatureSectionDisplayed() {
        return featuresSectionIsDisplayed.isDisplayed();
    }

    public String getLossFeatureText() {
        return featuresSectionIsDisplayed.getText().trim();
    }

    public boolean verifyActionButtonsVisible() {
        return keepPremiumButton.isDisplayed() && cancelPremiumButton.isDisplayed();
    }

    public String getKeepPremiumButtonBackgroundColor() {
        String keePremiumBGColor = keepPremiumButton.getCssValue("background-color");
        LoggerLoad.info("Keep Premium button background color: " + keePremiumBGColor);
        return keePremiumBGColor;
    }

    public String getKeepPremiumButtonTextColor() {
        String kPTextColor = keepPremiumButton.getCssValue("color");
        LoggerLoad.info("Keep Premium button text color: " + kPTextColor);
        return kPTextColor;
    }

    public String getCancelPremiumButtonBackgroundColor() {
        String cancelPremiumBGColor = cancelPremiumButton.getCssValue("background-color");
        LoggerLoad.info("Cancel Premium button background color: " + cancelPremiumBGColor);
        return cancelPremiumBGColor;
    }

    public String getCancelPremiumButtonTextColor() {
        String cPTextColor = cancelPremiumButton.getCssValue("color");
        LoggerLoad.info("Cancel Premium button text color: " + cPTextColor);
        return cPTextColor;
    }

    public void clickKeepPremiumButton() {
        keepPremiumButton.click();
    }

    public WebElement getKeepPremiumSuccessMessageElement() {
        return keepPremiumSuccessMessage;
    }

    public void clickCancelPremiumButton() {
        cancelPremiumButton.click();
    }

    public WebElement getCancelPremiumSuccessMessageElement() {
        return cancelPremiumMessage;
    }

    public void clickXButton() {
        xButton.click();
    }

    public boolean verifyDialogClosed() {
        try {
            return !messageDisplayInDialogBox.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        }
    }
}
