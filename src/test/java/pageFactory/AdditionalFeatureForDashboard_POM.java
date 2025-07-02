package pageFactory;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoggerLoad;

public class AdditionalFeatureForDashboard_POM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait;

    public AdditionalFeatureForDashboard_POM(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//button[text()='Dashboard']")
    private WebElement dashboardButton;

    //Dashboard page validation for Registered premium account user
    @FindBy(xpath= "//span[@class='ml-1']")
    private WebElement kingSymbolPremiumActivated;
    @FindBy(xpath= "//button[normalize-space()='Manage Premium']")
    private WebElement managePremiumButton;
    @FindBy(xpath= "//div[@id='radix-:r0:']")
    private WebElement dialogBox;
    @FindBy(xpath= "//span[text()='Start Date:']")
    private WebElement startDate;
    @FindBy(xpath= "//span[text()='End Date:']")
    private WebElement endDate;

    //Emotional Well being validations on Premium dashboard
    @FindBy(xpath= "//span[text()='\uD83D\uDE0A Emotional Wellbeing']")
    private WebElement emotionalWellBeing;
    @FindBy(xpath= "//label[normalize-space()='How are you feeling today?']")
    private WebElement questionIsDisplayed;
    @FindBy(xpath= "//div[@class='flex justify-between gap-2 mt-2']")
    private WebElement moodEmojisDisplayed;
    @FindBy(xpath= "//label[text()='Notes on your mood']")
    private WebElement notesOnMoodText;
    @FindBy(xpath= "//textarea[@id='notes']")
    private WebElement inputFieldText;
    @FindBy(xpath= "//label[normalize-space()='Energy Level: 7/10']")
    private WebElement energyLevelTextWithValue;
    @FindBy(xpath= "//span[@role='slider']")
    private WebElement energyLevelSlider;
    @FindBy(xpath= "//button[text()='Log Emotional State']")
    private WebElement logEmotionalStateButton;
    @FindBy(xpath= "//div[@class='text-sm opacity-90']")
    private WebElement logEmotionalStateSuccessMessage;

    //User Activity Tracking on premium Dashboard
    @FindBy(xpath= "//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 mb-6']//div[@class='rounded-lg border bg-indigo-200 text-white shadow-lg']")
    private WebElement weeklyChecksCard;
    @FindBy(xpath= "//span[text()='Weekly Checks']")
    private WebElement weeklyChecksTitle;
    @FindBy(xpath= "//div[normalize-space()='0']")
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


    // Smart Insights Validation on Premium dashboard
    @FindBy(xpath= "//span[text()='Smart Insights']")
    private WebElement smartInsightsSection;
    @FindBy(xpath= "//span[text()='Last 7 days']")
    private WebElement smartInsightsSectionLabel;
    @FindBy(xpath= "//div[@class='rounded-lg border md:col-span-3 bg-indigo-200 text-white shadow-lg']//div[@class='space-y-4']")
    private WebElement smartInsightsSectionTitles;
    @FindBy(xpath= "//div[@class='border-l-4 border-green-400 pl-3 py-2 bg-white/10 rounded-r']//p[@class='text-xs text-black/80']")
    private WebElement targetAchievementTextDisplay;
    @FindBy(xpath= "//p[contains(text(),'Your glucose tends to spike between 2-3 PM. Consid')]")
    private WebElement patternDetectedTextDisplay;
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
    @FindBy(xpath= "//div[@class='text-sm opacity-90']")
    private WebElement keepPremiumSuccessMessage;
    @FindBy(xpath= "//div[@class='text-sm opacity-90']")
    private WebElement cancelPremiumMessage;
    @FindBy(xpath= "//button[@class='absolute right-2 top-2 rounded-md p-1 text-foreground/50 opacity-0 transition-opacity hover:text-foreground focus:opacity-100 focus:outline-none focus:ring-2 group-hover:opacity-100']//*[name()='svg']")
    private WebElement xButton;

    //Action methods
    public boolean isKingSymbolDisplayed() {
        return kingSymbolPremiumActivated.isDisplayed();
    }

    public String getPremiumStatusText() {
        return kingSymbolPremiumActivated.getText();
    }

    public boolean isManagePremiumButtonVisible() {
        return managePremiumButton.isDisplayed();
    }

    public void clickManagePremiumButton() {
        managePremiumButton.click();
    }

    public boolean isDialogBoxVisible() {
        return dialogBox.isDisplayed();
    }

    public String getStartDateText() {
        return startDate.getText();
    }

    public String getEndDateText() {
        return endDate.getText();
    }

    //Emotional Well being validations on Premium dashboard
    public void scrollToMiddle() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
    }

    public boolean isEmotionalWellBeingTitleVisible() {
        return emotionalWellBeing.isDisplayed();
    }

    public boolean isQuestionDisplayed() {
        return questionIsDisplayed.isDisplayed();
    }

    public boolean areMoodEmojisDisplayed() {
        return moodEmojisDisplayed.isDisplayed();
    }

    public boolean isNotesOnMoodLabelVisible() {
        return notesOnMoodText.isDisplayed();
    }

    public String getPlaceholderTextOfNotes() {
        return inputFieldText.getAttribute("placeholder");
    }

    public void enterTextInNotes(String text) {
        inputFieldText.clear();
        inputFieldText.sendKeys(text);
    }

    public String getEnteredTextFromNotes() {
        return inputFieldText.getAttribute("value");
    }

    public boolean isEnergyLevelTextDisplayed() {
        return energyLevelTextWithValue.isDisplayed();
    }

    public boolean isEnergyLevelSliderVisible() {
        return energyLevelSlider.isDisplayed();
    }

    public void moveEnergySlider(int xOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(energyLevelSlider).moveByOffset(xOffset, 0).release().perform();
    }

    public boolean isLogEmotionalStateButtonVisible() {
        return logEmotionalStateButton.isDisplayed();
    }

    public void clickLogEmotionalStateButton() {
        logEmotionalStateButton.click();
    }

    public String getLogEmotionalStateSuccessMessage() {
        return logEmotionalStateSuccessMessage.getText();
    }

    //User Activity Tracking on premium Dashboard
    public String getWeeklyChecksSubTitle() {
        return weeklyChecksTitle.getText().trim();
    }
    public String getWeeklyChecksValue() {
        return weeklyChecksValue.getText().trim();
    }
    public String getWeeklyChecksText() {
        return weeklyChecksText.getText().trim();
    }

    public String getExerciseMinutesSubtitle() {
        return exerciseMinuteTitle.getText().trim();
    }
    public String getExerciseMinutesValue() {
        return exerciseMinuteValue.getText().trim();
    }
    public String getExerciseMinutesText() {
        return exerciseMinuteText.getText().trim();
    }

    public String getMedAdherenceSubtitle() {
        return medAdherenceTitle.getText().trim();
    }
    public String getMedAdherenceValue() {
        return medAdherenceValue.getText().trim();
    }
    public String getMedAdherenceText() {
        return medAdherenceText.getText().trim();
    }

    public String getCarbGoalsSubtitle() {
        return carbGoalsTitle.getText().trim();
    }
    public String getCarbGoalsValue() {
        return carbGoalsValue.getText().trim();
    }
    public String getCarbGoalsText() {
        return carbGoalsText.getText().trim();
    }


    // Smart Insights Validation on Premium dashboard
    public boolean isSmartInsightsTitleVisible() {
        return smartInsightsSection.isDisplayed();
    }

    public boolean isLast7DaysLabelVisible() {
        return smartInsightsSectionLabel.isDisplayed();
    }

    public boolean areSmartInsightsTitlesPresent() {
        String sectionText = smartInsightsSectionTitles.getText();
        return sectionText.contains("Target Achievement") &&
                sectionText.contains("Pattern detected") &&
                sectionText.contains("Suggestion");
    }

    public String getTargetAchievementText() {
        return targetAchievementTextDisplay.getText().trim();
    }

    public String getPatternDetectedText() {
        return patternDetectedTextDisplay.getText().trim();
    }

    public String getSuggestionText() {
        return suggestionTextDisplay.getText().trim();
    }

    //Manage premium Dialog box Validation
    public String getDialogMessage() {
        return messageDisplayInDialogBox.getText().trim();
    }

    public boolean isLossFeatureSectionDisplayed() {
        return featuresSectionIsDisplayed.isDisplayed();
    }

    public String getLossFeatureText() {
        return featuresSectionIsDisplayed.getText().trim();
    }

    public boolean areActionButtonsVisible() {
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

    public String getKeepPremiumSuccessMessage() {
        return keepPremiumSuccessMessage.getText().trim();
    }

    public void clickCancelPremiumButton() {
        cancelPremiumButton.click();
    }

    public String getCancelPremiumMessage() {
        return cancelPremiumMessage.getText().trim();
    }

    public void clickXButton() {
        xButton.click();
    }

    public boolean isDialogClosed() {
        try {
            return !messageDisplayInDialogBox.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        }
    }
}
