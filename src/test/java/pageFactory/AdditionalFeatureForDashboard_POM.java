package pageFactory;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdditionalFeatureForDashboard_POM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait;

    public AdditionalFeatureForDashboard_POM(){
        PageFactory.initElements(driver, this);
    }

    //Dashboard page validation for Registered premium account user
    @FindBy(xpath= "//span[@class='ml-1']")
    private WebElement kingSymbolPremiumActivated;
    @FindBy(xpath= "//button[normalize-space()='Manage Premium']")
    private WebElement managePremiumButton;
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
    @FindBy(xpath= "//span[@role='slider']")
    private WebElement energyLevelSlider;
    @FindBy(xpath= "//button[text()='Log Emotional State']")
    private WebElement logEmotionalStateButton;
    @FindBy(xpath= "//div[@class='text-sm opacity-90']")
    private WebElement logEmotionalStateSuccessMessage;

    //User Activity Tracking on premium Dashboard
    @FindBy(xpath= "//div[@class='grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4 mb-6']//div[@class='rounded-lg border bg-indigo-200 text-white shadow-lg']")
    private WebElement weeklyChecksCard;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-300 text-white shadow-lg']")
    private WebElement exerciseMinuteCard;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-400 text-white shadow-lg']")
    private WebElement medAdherenceCard;
    @FindBy(xpath= "//div[@class='rounded-lg border bg-indigo-500 text-white shadow-lg']")
    private WebElement carbGoalsCard;

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
}
