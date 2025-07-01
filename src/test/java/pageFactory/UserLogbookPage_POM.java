package pageFactory;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLogbookPage_POM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait;

    public UserLogbookPage_POM(){
        PageFactory.initElements(driver, this);
    }

    //Blood Glucose Tracker section
    @FindBy(xpath= "//h2[@class='text-2xl font-semibold mb-6']")
    private WebElement bloodGlucoseTracker;
    @FindBy(xpath= "//div[text()='Fasting']")
    private WebElement fasting;
    @FindBy(xpath= "//div[text()='70-100 mg/dL']")
    private WebElement fastingGlucoseRange;
    @FindBy(xpath= "//div[text()='Pre-Meal']")
    private WebElement preMeal;
    @FindBy(xpath= "//div[text()='70-130 mg/dL']")
    private WebElement preMealGlucoseRange;
    @FindBy(xpath= "//div[text()='Post-Meal']")
    private WebElement postMeal;
    @FindBy(xpath= "//div[text()='<180 mg/dL']")
    private WebElement postMealGlucoseRange;
    @FindBy(xpath= "//div[text()='Bedtime']")
    private WebElement bedTime;
    @FindBy(xpath= "//div[text()='100-140 mg/dL']")
    private WebElement bedTimeGlucoseRange;
    @FindBy(xpath= "")
    private WebElement daysInXaxisInGlucoseTracker;
    @FindBy(xpath = "//*[name()='tspan' and text()='70']")
    private WebElement bloodGlucoseYaxisStart70;
    @FindBy(xpath = "//*[name()='tspan' and text()='180']")
    private WebElement bloodGlucoseYaxisEnds180;

    //Meal & Nutrition section
    @FindBy(xpath= "//h2[text()='Meal & Nutrition']")
    private WebElement mealNutritionSection;
    @FindBy(xpath= "//*[contains(@class, 'lucide-cooking-pot')]")
    private WebElement mealNutritionIcon;
    @FindBy(xpath= "//h3[text()='7-Day Aggregate Nutrition']")
    private WebElement sevenDayAggregateNutritionTitle;
    @FindBy(xpath= "//span[@class='recharts-legend-item-text' and text()='Carbs']")
    private WebElement textColorOfCarbs;
    @FindBy(xpath= "//span[@class='recharts-legend-item-text' and text()='Protein']")
    private WebElement textColorOfProtein;
    @FindBy(xpath= "//span[@class='recharts-legend-item-text' and text()='Fats']")
    private WebElement textColorOfFats;
    @FindBy(xpath= "")
    private WebElement daysInXaxisInDailyNutrition;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/*[name()='svg'][1]")
    private WebElement dailyNutritionBarChart;
    @FindBy(xpath= "//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='g']")
    private WebElement dailyNutritionPieChart;
    @FindBy(xpath= "//body//div//div[2]//div[2]//div[3]//div[1]//div[2]")
    private WebElement carbsCardValue;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[2]")
    private WebElement proteinCardValue;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[3]/div[2]")
    private WebElement fatsCardValue;

    //Medical Dosage section
    @FindBy(xpath= "//h2[text()='Medication Dosage']")
    private WebElement medicalDosageSection;
    @FindBy(xpath= "//*[contains(@class, 'lucide lucide-pill')]")
    private WebElement medicalDosageIcon;
    @FindBy(xpath= "//h2[text()='/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]']")
    private WebElement numberOfDosageTextInYaxis;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]")
    private WebElement medicalDosageBarChart;
    @FindBy(xpath= "//div[@class='text-violet-600'][normalize-space()='0 doses']")
    private WebElement dosesInTotalScheduledDisplay;
    @FindBy(xpath= "//div[@class='text-emerald-600'][normalize-space()='0 doses']")
    private WebElement dosesInDoseTakenDisplay;
    @FindBy(xpath= "//div[@class='text-amber-600'][normalize-space()='0 doses']")
    private WebElement dosesInDosageMissedDisplay;
    @FindBy(xpath= "//div[text() = 'Total Scheduled']")
    private WebElement totalScheduledText;
    @FindBy(xpath= "//div[text() = 'Doses Taken']")
    private WebElement doseTakenText;
    @FindBy(xpath= "//div[text() = 'Doses Missed']")
    private WebElement dosageMissedText;

    //Log review section
    @FindBy(xpath= "//h2[text()='Log Review']")
    private WebElement logReviewTitle;
    @FindBy(xpath= "//tr[@class='bg-white/20']")
    private WebElement tableHeader;
    @FindBy(xpath= "//th[text()='Date']")
    private WebElement logReviewDaysDisplay;
    @FindBy(xpath= "//td[normalize-space()='Jun 30, 2025']")
    private WebElement verifyDateFormat;
    @FindBy(xpath= "//th[text()='Blood Glucose']")
    private WebElement bloodGlucoseValue;
    @FindBy(xpath= "//th[text()='Nutrition']")
    private WebElement nutritionValue;
    @FindBy(xpath= "//th[text()='Activity']")
    private WebElement activity;
    @FindBy(xpath= "//th[text()='Medication']")
    private WebElement medication;

    //Physical Activity Validation
    @FindBy(xpath= "//h2[text()='Physical Activity']")
    private WebElement physicalActivitySection;
    @FindBy(xpath= "//*[contains(@class, 'lucide lucide-activity')]")
    private WebElement physicalActivityIcon;
    @FindBy(xpath= "")
    private WebElement daysInXaxisInPhysicalActivity;
    @FindBy(xpath= "//div[@class='bg-white rounded-lg p-4']//div[@class='mt-6 grid grid-cols-3 gap-4 text-sm']")
    private WebElement statisticCardsDisplay;
    @FindBy(xpath= "//div[text() = 'Total Calories']")
    private WebElement totalCaloriesText;
    @FindBy(xpath= "//div[text() = 'Daily Average']")
    private WebElement dailyAverageText;
    @FindBy(xpath= "//div[text() = 'Peak Day']")
    private WebElement peakDayText;
    @FindBy(xpath= "//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='text']/*[name()='tspan']")
    private WebElement caloriesTextInYaxis;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/*[name()='svg'][1]")
    private WebElement physicalActivityBarChart;
    @FindBy(xpath= "//div[@class='text-violet-600'][normalize-space()='0 cal']")
    private WebElement totalCaloriesValue;
    @FindBy(xpath= "//div[@class='text-amber-600'][normalize-space()='0 cal']")
    private WebElement dailyAverageValue;
    @FindBy(xpath= "")
    private WebElement peakDayValue;
}
