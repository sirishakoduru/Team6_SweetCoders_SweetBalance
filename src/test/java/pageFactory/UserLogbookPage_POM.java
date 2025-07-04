package pageFactory;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoggerLoad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;


public class UserLogbookPage_POM {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait;

    public UserLogbookPage_POM(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//button[text()='Logbook']")
    private WebElement logBookButton;

    //Blood Glucose Tracker section
    @FindBy(xpath= "//h2[@class='text-2xl font-semibold mb-6']")
    private WebElement bloodGlucoseTracker;
    @FindBy(xpath= "//div[text()='Fasting']")
    private WebElement fastingTitleTextColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]")
    private WebElement fastingGlucoseRange;
    @FindBy(xpath= "//div[text()='Pre-Meal']")
    private WebElement preMealTitleTextColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")
    private WebElement preMealGlucoseRange;
    @FindBy(xpath= "//div[text()='Post-Meal']")
    private WebElement postMealTitleTextColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]")
    private WebElement postMealGlucoseRange;
    @FindBy(xpath= "//div[text()='Bedtime']")
    private WebElement bedTimeTitleTextColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]")
    private WebElement bedTimeGlucoseRange;
    @FindBy(xpath= "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='g']")
    private List<WebElement> daysInXaxisInGlucoseTracker;
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
    @FindBy(xpath= "//h3[text()='Daily Nutrition Breakdown']")
    private WebElement dailyNutritionBreakdown;
    @FindBy(xpath= "//span[@class='recharts-legend-item-text' and text()='Carbs']")
    private WebElement textColorOfCarbs;
    @FindBy(xpath= "//span[@class='recharts-legend-item-text' and text()='Protein']")
    private WebElement textColorOfProtein;
    @FindBy(xpath= "//span[@class='recharts-legend-item-text' and text()='Fats']")
    private WebElement textColorOfFats;
    @FindBy(xpath= "")
    private List<WebElement> daysInXaxisInDailyNutrition;
    @FindBy(xpath= "//body[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='g']")
    private WebElement dailyNutritionEmptyBarChart;
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
    @FindBy(xpath= "//body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='text']/*[name()='tspan']")
    private WebElement numberOfDosageTextInYaxis;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]")
    private List<WebElement> medicalDosageBarChart;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]")
    private WebElement dosesInTotalScheduledDisplay;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[2]/div[2]")
    private WebElement dosesInDoseTakenDisplay;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[3]/div[2]")
    private WebElement dosesInDosageMissedDisplay;
    @FindBy(xpath= "//div[text() = 'Total Scheduled']")
    private WebElement totalScheduledText;
    @FindBy(xpath= "//div[text() = 'Doses Taken']")
    private WebElement doseTakenText;
    @FindBy(xpath= "//div[normalize-space()='Doses Missed']")
    private WebElement dosageMissedText;

    //Log review section
    @FindBy(xpath= "//h2[text()='Log Review']")
    private WebElement logReviewTitle;
    @FindBy(xpath= "//tr[@class='bg-white/20']/th")
    private List<WebElement> tableHeaders;
    @FindBy(xpath = "//tbody/tr/td[1]")
    private List<WebElement> dateColumnCells;
    @FindBy(xpath= "//tbody/tr/td[2]")
    private List<WebElement> bloodGlucoseColumn;
    @FindBy(xpath= "//tbody/tr/td[3]")
    private List<WebElement> nutritionColumn;
    @FindBy(xpath= "//tbody/tr/td[4]")
    private List<WebElement> activityColumn;
    @FindBy(xpath= "//tbody/tr/td[5]")
    private List<WebElement> medicationColumn;

    //Physical Activity Validation
    @FindBy(xpath= "//h2[text()='Physical Activity']")
    private WebElement physicalActivitySection;
    @FindBy(xpath= "//*[contains(@class, 'lucide lucide-activity')]")
    private WebElement physicalActivityIcon;
    @FindBy(xpath= "")
    private List<WebElement> daysInXaxisInPhysicalActivity;
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
    @FindBy(xpath= "//div//div//div[1]//div[2]//div[1]//div[1]//div[2]")
    private WebElement physicalActivityEmptyBarChart;
    @FindBy(xpath= "//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/*[name()='svg']/*[name()='g']/*[name()='g']/*[name()='g']/*[name()='g']")
    private List<WebElement> physicalActivityBarChart;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]")
    private WebElement totalCaloriesValue;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]")
    private WebElement dailyAverageValue;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[3]/div[2]")
    private WebElement peakDayValue;

    //Action methods
    public void navigateToLogBookPage(){
        logBookButton.click();
    }

//----------------------------------Blood Glucose Tracker section----------------------------------------------//
    public boolean isBloodGlucoseTrackerDisplayed() {
        return bloodGlucoseTracker.isDisplayed();
    }
    public String getBloodGlucoseTrackerTitle() {
        return bloodGlucoseTracker.getText().trim();
    }
    public String verifyColorCodeForFasting() {
        String fastingElementColor = fastingTitleTextColor.getCssValue("color");
        LoggerLoad.info("The color of the fasting label is: " + fastingElementColor);
        return fastingElementColor;
    }

    public String getFastingTitle(){
        return fastingTitleTextColor.getText().trim();
    }

    public String verifyFastingRangeDisplayed() {
        return fastingGlucoseRange.getText().trim();
    }

    public String verifyColorCodeForPreMeal() {
        String preMealElementColor = preMealTitleTextColor.getCssValue("color");
        LoggerLoad.info("The color of the pre-meal label is: " + preMealElementColor);
        return preMealElementColor;
    }

    public String getPreMealTitle(){
        return preMealTitleTextColor.getText().trim();
    }
    public String verifyPreMealRangeDisplayed() {
        return preMealGlucoseRange.getText().trim();
    }

    public String verifyColorCodeForPostMeal() {
        String postMealElementColor = postMealTitleTextColor.getCssValue("color");
        LoggerLoad.info("The color of the post-meal label is: " + postMealElementColor);
        return postMealElementColor;
    }

    public String getPostMealTitle(){
        return postMealTitleTextColor.getText().trim();
    }
    public String verifyPostMealRangeDisplayed() {
        return postMealGlucoseRange.getText().trim();
    }

    public String verifyColorCodeForBedtime() {
        String bedtimeElementColor = bedTimeTitleTextColor.getCssValue("color");
        LoggerLoad.info("The color of the bed time label is: " + bedtimeElementColor);
        return bedtimeElementColor;
    }

    public String getBedTimeTitle(){
        return bedTimeTitleTextColor.getText().trim();
    }
    public String verifyBedtimeRangeDisplayed() {
        return bedTimeGlucoseRange.getText().trim();
    }

    public List<WebElement> getDaysFromXaxisInBloodGlucoseChart() {
        return daysInXaxisInGlucoseTracker;
    }

    public int verifyYaxisMinValueInGlucoseChart() {
        String yMinText = bloodGlucoseYaxisStart70.getText().trim();
        LoggerLoad.info("Y-axis minimum value: " + yMinText);
        return Integer.parseInt(yMinText);
    }

    public int verifyYaxisMaxValueInGlucoseChart() {
        String yMaxText = bloodGlucoseYaxisEnds180.getText().trim();
        return Integer.parseInt(yMaxText);
    }


//------------------------------------Meal & Nutrition section-----------------------------------------------//
    public boolean verifyMealNutritionSectionDisplayed() {
        return mealNutritionSection.isDisplayed();
    }

    public String getMealNutritionSectionTitle() {
        return mealNutritionSection.getText().trim();
    }

    public boolean verifyMealNutritionIconDisplayed() {
        return mealNutritionIcon.isDisplayed();
    }

    public boolean verifySevenDayAggregateNutritionTitleDisplayed() {
        return sevenDayAggregateNutritionTitle.isDisplayed();
    }

    public boolean verifyDailyNutritionBreakdownDisplayed() {
        return dailyNutritionBreakdown.isDisplayed();
    }

    public String getCarbsTextColor() {
        String carbsColorText = textColorOfCarbs.getCssValue("color");
        LoggerLoad.info("The color of the carbs text is: " + carbsColorText);
        return carbsColorText;
    }

    public String getProteinTextColor() {
        String proteinColorText = textColorOfProtein.getCssValue("color");
        LoggerLoad.info("The color of the protein text is: " + proteinColorText);
        return proteinColorText;
    }

    public String getFatsTextColor() {
        String fatsColorText = textColorOfFats.getCssValue("color");
        LoggerLoad.info("The color of the fats text is: " + fatsColorText);
        return fatsColorText;
    }

    public List<WebElement> getDaysFromXaxisInDailyNutritionChart() {
        return  daysInXaxisInDailyNutrition;
    }

    public boolean verifyDailyNutritionEmptyBarChartDisplayed() {
        String chartContent = dailyNutritionEmptyBarChart.getText().trim();
        LoggerLoad.info("Chart content: " + chartContent);
        return chartContent.isEmpty();
    }

    public boolean verifyDailyNutritionPieChartDisplayed() {
        return dailyNutritionPieChart.isDisplayed();
    }

    public String getCarbsCardValue() {
        return carbsCardValue.getText().trim();
    }

    public boolean isCarbsCardValueDisplayed(){
        return carbsCardValue.isDisplayed();
    }

    public String getProteinCardValue() {
        return proteinCardValue.getText().trim();
    }

    public boolean isProteinCardValueDisplayed(){
        return proteinCardValue.isDisplayed();
    }

    public String getFatsCardValue() {
        return fatsCardValue.getText().trim();
    }

    public boolean isFatsCardValueDisplayed(){
        return fatsCardValue.isDisplayed();
    }


//------------------------------------Medical Dosage section--------------------------------------------------//
    public boolean verifyMedicalDosageSectionDisplayed() {
        return medicalDosageSection.isDisplayed();
    }

    public String getMedicalDosageSectionTitle() {
        return medicalDosageSection.getText().trim();
    }

    public boolean verifyMedicalDosageIconDisplayed() {
        return medicalDosageIcon.isDisplayed();
    }

    public String getDosageYAxisLabelText() {
        return numberOfDosageTextInYaxis.getText().trim();
    }

    public boolean verifyMedicalDosageChartDisplayed() {
        LoggerLoad.info("Checking if bars are present in Medical Dosage chart. Count: " + medicalDosageBarChart.size());
        return medicalDosageBarChart.isEmpty();
    }

    public String getTotalScheduledDoseValue() {
        return dosesInTotalScheduledDisplay.getText().trim();
    }

    public String getDosesTakenValue() {
        return dosesInDoseTakenDisplay.getText().trim();
    }

    public String getDosesMissedValue() {
        return dosesInDosageMissedDisplay.getText().trim();  
    }

    public String getTotalScheduledTextColor() {
        String totalScheduledTextColor = totalScheduledText.getCssValue("color");
        LoggerLoad.info("The color of the totalScheduledTextColor text is: " + totalScheduledTextColor);
        return totalScheduledTextColor;
    }

    public String getDoseTakenTextColor() {
        String dosageTakenTextColor = doseTakenText.getCssValue("color");
        LoggerLoad.info("The color of the dosageTakenTextColor text is: " + dosageTakenTextColor );
        return dosageTakenTextColor ;
    }

    public String getDosageMissedTextColor() {
        String dosageMissedTextColor = dosageMissedText.getCssValue("color");
        LoggerLoad.info("The color of the dosageMissedTextColor text is: " + dosageMissedTextColor);
        return dosageMissedTextColor;
    }
    public String verifyDosageMissedTextColor() {
        String color = dosageMissedText.getCssValue("color");
        LoggerLoad.info("✅ Fetched color: " + color);
        return color;
    }


//----------------------------------------Log review section---------------------------------------------------//
    public String verifyLogReviewTitleDisplayed() {
        return logReviewTitle.getText().trim();
    }

    public List<String> getLogReviewHeaderTitles() {
        return tableHeaders.stream()
                .map(e -> e.getText().trim().replaceAll("\\s+", " "))
                .collect(Collectors.toList());
    }

    public List<String> getDateColumnTexts() {
        return dateColumnCells.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

    public boolean verifyDatesInCorrectFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);

        for (WebElement dateCell : dateColumnCells) {
            String dateText = dateCell.getText().trim();
            try {
                LocalDate.parse(dateText, formatter);
            } catch (DateTimeParseException e) {
                LoggerLoad.error("Invalid date format: " + dateText);
                return false;
            }
        }
        return true;
    }

    public boolean verifyDatesInDescendingOrder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);

        List<LocalDate> extractedDates = dateColumnCells.stream()
                .map(cell -> LocalDate.parse(cell.getText().trim(), formatter))
                .collect(Collectors.toList());

        List<LocalDate> sortedDates = new ArrayList<>(extractedDates);
        sortedDates.sort(Comparator.reverseOrder());

        return extractedDates.equals(sortedDates);
    }

    //Reusable method
    public boolean verifyLogReviewColumnValuesAreHyphen(List<WebElement> columnCells) {
        for (WebElement cell : columnCells) {
            if (!cell.getText().trim().equals("-")) {
                LoggerLoad.warn("Expected '-', but found: " + cell.getText());
                return false;
            }
        }
        return true;
    }
    public boolean verifyBloodGlucoseColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(bloodGlucoseColumn);
    }

    public boolean verifyNutritionColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(nutritionColumn);
    }

    public boolean verifyActivityColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(activityColumn);
    }

    public boolean verifyMedicationColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(medicationColumn);
    }

    public boolean verifyAnyBloodGlucoseValueLogged() {
        for (WebElement e : bloodGlucoseColumn) {
            String text = e.getText().trim();
            System.out.println("Blood Glucose cell value: '" + text + "'");
            if (!text.equals("-") && !text.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyAnyNutrientValueLogged() {
        return nutritionColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }
    public boolean verifyAnyPhysicalActivityValueLogged() {
        return activityColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }
    public boolean verifyAnyMedicationValueLogged() {
        return medicationColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }

 //---------------------------------------Physical Activity Validation------------------------------------------//
    public boolean verifyPhysicalActivitySectionDisplayed() {
        return physicalActivitySection.isDisplayed();
    }

    public String getPhysicalActivityTitle() {
        return physicalActivitySection.getText();
    }

    public boolean verifyPhysicalActivityIconDisplayed() {
        return physicalActivityIcon.isDisplayed();
    }

    public List<String> getDaysFromXaxisInPhysicalActivityChart() {
        List<String> days = new ArrayList<>();
        for (WebElement day : daysInXaxisInPhysicalActivity) {
            days.add(day.getText().trim());
        }
        return days;
    }
    public boolean verifyStatisticCardsDisplayedHorizontally() {
        return statisticCardsDisplay.isDisplayed();
    }

    public String getTotalCaloriesTextColor() {
        String totalCaloriesTextColor = totalCaloriesText.getCssValue("color");
        LoggerLoad.info("The color of the totalCaloriesTextColor text is: " + totalCaloriesTextColor);
        return totalCaloriesTextColor;
    }

    public String getDailyAverageTextColor() {
        String dailyAverageTextColor = dailyAverageText.getCssValue("color");
        LoggerLoad.info("The color of the dailyAverageTextColor text is: " + dailyAverageTextColor);
        return dailyAverageTextColor;
    }

    public String getPeakDayTextColor() {
        String peakDayTextColor = peakDayText.getCssValue("color");
        LoggerLoad.info("The color of the peakDayTextColor text is: " + peakDayTextColor);
        return peakDayTextColor;
    }

    public String getYAxisLabelText() {
        return caloriesTextInYaxis.getText();
    }

    public boolean verifyEmptyBarChartDisplayed() {
        String chartContent = physicalActivityEmptyBarChart.getText().trim();
        LoggerLoad.info("Chart content: " + chartContent);
        return chartContent.isEmpty();
    }
    public String getTotalCaloriesValue() {
        return totalCaloriesValue.getText();
    }

    public String getDailyAverageValue() {
        return dailyAverageValue.getText();
    }

    public String verifyPeakDayValueDisplayed() {
         return peakDayValue.getText().trim();
    }

    public boolean verifyActivityBarsDisplayedForLoggedDaysOnly() {
        int barCount = physicalActivityBarChart.size();
        LoggerLoad.info("Number of activity bars displayed: " + barCount);
        return barCount > 0;
    }
}
