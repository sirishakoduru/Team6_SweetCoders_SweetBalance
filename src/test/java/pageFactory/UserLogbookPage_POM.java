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
    private WebElement fastingColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]']")
    private WebElement fastingGlucoseRange;
    @FindBy(xpath= "//div[text()='Pre-Meal']")
    private WebElement preMealColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")
    private WebElement preMealGlucoseRange;
    @FindBy(xpath= "//div[text()='Post-Meal']")
    private WebElement postMealColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]")
    private WebElement postMealGlucoseRange;
    @FindBy(xpath= "//div[text()='Bedtime']")
    private WebElement bedTimeColor;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]")
    private WebElement bedTimeGlucoseRange;
    @FindBy(xpath= "")
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
    @FindBy(xpath= "//h2[text()='/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][3]/*[name()='text'][1]/*[name()='tspan'][1]']")
    private WebElement numberOfDosageTextInYaxis;
    @FindBy(xpath= "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]")
    private WebElement medicalDosageBarChart;
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
    @FindBy(xpath= "//div[text() = 'Doses Missed']")
    private WebElement dosageMissedText;

    //Log review section
    @FindBy(xpath= "//h2[text()='Log Review']")
    private WebElement logReviewTitle;
    @FindBy(xpath= "//tr[@class='bg-white/20']")
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
    //Blood Glucose Tracker section
    public boolean isBloodGlucoseTrackerDisplayed() {
        return bloodGlucoseTracker.isDisplayed();
    }
    public String getBloodGlucoseTrackerTitle() {
        return bloodGlucoseTracker.getText().trim();
    }
    public String verifyColorCodeForFasting() {
        String fastingElementColor = fastingColor.getCssValue("color");
        LoggerLoad.info("The color of the fasting label is: " + fastingElementColor);
        return fastingElementColor;
    }

    public boolean isFastingRangeDisplayed() {
        return fastingGlucoseRange.isDisplayed();
    }

    public String verifyColorCodeForPreMeal() {
        String preMealElementColor = preMealColor.getCssValue("color");
        LoggerLoad.info("The color of the pre-meal label is: " + preMealElementColor);
        return preMealElementColor;
    }
    public boolean isPreMealRangeDisplayed() {
        return preMealGlucoseRange.isDisplayed();
    }

    public String verifyColorCodeForPostMeal() {
        String postMealElementColor = postMealColor.getCssValue("color");
        LoggerLoad.info("The color of the post-meal label is: " + postMealElementColor);
        return postMealElementColor;
    }
    public boolean isPostMealRangeDisplayed() {
        return postMealGlucoseRange.isDisplayed();
    }

    public String verifyColorCodeForBedtime() {
        String bedtimeElementColor = bedTimeColor.getCssValue("color");
        LoggerLoad.info("The color of the bed time label is: " + bedtimeElementColor);
        return bedtimeElementColor;
    }
    public boolean isBedtimeRangeDisplayed() {
        return bedTimeGlucoseRange.isDisplayed();
    }

    public List<String> getDaysFromXaxisInBloodGlucoseChart() {
        List<String> days = new ArrayList<>();
        for (WebElement day : daysInXaxisInGlucoseTracker) {
            days.add(day.getText().trim());
        }
        return days;
    }

    public boolean isYaxisStartAt70InGlucoseChart() {
        return bloodGlucoseYaxisStart70.isDisplayed();
    }

    public boolean isYaxisEndAt180InGlucoseChart() {
        return bloodGlucoseYaxisEnds180.isDisplayed();
    }


    //Meal & Nutrition section
    public boolean isMealNutritionSectionDisplayed() {
        return mealNutritionSection.isDisplayed();
    }

    public String getMealNutritionSectionTitle() {
        return mealNutritionSection.getText().trim();
    }

    public boolean isMealNutritionIconDisplayed() {
        return mealNutritionIcon.isDisplayed();
    }

    public boolean isSevenDayAggregateNutritionTitleDisplayed() {
        return sevenDayAggregateNutritionTitle.isDisplayed();
    }

    public boolean isDailyNutritionBreakdownDisplayed() {
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

    public List<String> getDaysFromXaxisInDailyNutritionChart() {
        List<String> days = new ArrayList<>();
        for (WebElement day : daysInXaxisInDailyNutrition) {
            days.add(day.getText().trim());
        }
        return days;
    }

    public boolean verifyDailyNutritionEmptyBarChartDisplayed() {
        String chartContent = dailyNutritionEmptyBarChart.getText().trim();
        LoggerLoad.info("Chart content: " + chartContent);
        return chartContent.isEmpty();
    }

    public boolean isDailyNutritionPieChartDisplayed() {
        return dailyNutritionPieChart.isDisplayed();
    }

    public String getCarbsCardValue() {
        return carbsCardValue.getText().trim();
    }

    public String getProteinCardValue() {
        return proteinCardValue.getText().trim();
    }

    public String getFatsCardValue() {
        return fatsCardValue.getText().trim();
    }


    //Medical Dosage section
    public boolean isMedicalDosageSectionDisplayed() {
        return medicalDosageSection.isDisplayed();
    }

    public String getMedicalDosageSectionTitle() {
        return medicalDosageSection.getText().trim();
    }

    public boolean isMedicalDosageIconDisplayed() {
        return medicalDosageIcon.isDisplayed();
    }

    public String getDosageYAxisLabelText() {
        return numberOfDosageTextInYaxis.getText().trim();
    }

    public boolean isMedicalDosageChartDisplayed() {
        return medicalDosageBarChart.isDisplayed();
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


    //Log review section
    public boolean isLogReviewTitleDisplayed() {
        return logReviewTitle.isDisplayed();
    }

    public List<String> getLogReviewHeaderTitles() {
        return tableHeaders.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

//    public boolean verifyLast7DaysDatesDisplayed() {
//        //Extracting displayed dates from page
//        List<String> displayedDates = dateColumnCells.stream()
//                .map(e -> e.getText().trim())
//                .collect(Collectors.toList());
//
//        //Generating last 7 dates (including today)
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
//        List<String> expectedDates =
//                LocalDate.now()
//                        .datesUntil(LocalDate.now().plusDays(1))  // include today only
//                        .limit(7)
//                        .map(date -> date.format(formatter))
//                        .collect(Collectors.toList());
//
//        expectedDates = LocalDate.now()
//                .minusDays(6)  // 6 days before today + today = 7 days
//                .datesUntil(LocalDate.now().plusDays(1))
//                .map(date -> date.format(formatter))
//                .collect(Collectors.toList());
//
//        return displayedDates.equals(expectedDates);
//    }

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
    public boolean isBloodGlucoseColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(bloodGlucoseColumn);
    }
    public boolean isNutritionColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(nutritionColumn);
    }
    public boolean isActivityColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(activityColumn);
    }
    public boolean isMedicationColumnEmpty() {
        return verifyLogReviewColumnValuesAreHyphen(medicationColumn);
    }

    public boolean isAnyBloodGlucoseValueLogged() {
        return bloodGlucoseColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }
    public boolean isAnyNutrientValueLogged() {
        return nutritionColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }
    public boolean isAnyPhysicalActivityValueLogged() {
        return activityColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }
    public boolean isAnyMedicationValueLogged() {
        return medicationColumn.stream()
                .anyMatch(e -> !e.getText().trim().equals("-"));
    }

    //Physical Activity Validation
    public boolean isPhysicalActivitySectionDisplayed() {
        return physicalActivitySection.isDisplayed();
    }

    public String getPhysicalActivityTitle() {
        return physicalActivitySection.getText();
    }

    public boolean isPhysicalActivityIconDisplayed() {
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

    public boolean isPeakDayValueDisplayed() {
        try {
            return peakDayValue.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean areActivityBarsDisplayedForLoggedDaysOnly() {
        int barCount = physicalActivityBarChart.size();
        LoggerLoad.info("Number of activity bars displayed: " + barCount);
        return barCount > 0;
    }
}
