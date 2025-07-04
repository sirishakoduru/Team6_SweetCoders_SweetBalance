package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;

public class ExerciseSchedule_POM {
	
	String baseURL = ConfigReader.baseUrl();
	String loginURL = ConfigReader.loginUrl();
	String email = ConfigReader.loginEmail();
	WebDriver driver = DriverFactory.getDriver();;
	WebDriverWait wait;
	
	
	  // Header Title
    @FindBy(xpath = "//h1[contains(text(),\"Today's Exercise Schedule\")]")
    WebElement pageTitle;

    // Back Button
    @FindBy(xpath = "//button[contains(text(),'Back to Home')]")
    WebElement backToHomeBtn;
		
	 // Section Titles
    @FindBy(xpath = "//h3[text()='Warm Up']")
    WebElement warmUpSection;

    @FindBy(xpath = "//h3[text()='Main Workout']")
    WebElement mainWorkoutSection;

    @FindBy(xpath = "//h3[text()='Cool Down']")
    WebElement coolDownSection;

    // Exercise Fields - common
    @FindBy(xpath = "//div[contains(@class,'exercise-section')]//h4") List<WebElement> exerciseNames;
    @FindBy(xpath = "//div[contains(@class,'exercise-section')]//p[contains(@class,'description')]") List<WebElement> exerciseDescriptions;
    @FindBy(xpath = "//div[contains(@class,'exercise-section')]//p[contains(@class,'duration')]") List<WebElement> exerciseDurations;
    @FindBy(xpath = "//div[contains(@class,'exercise-section')]//p[contains(@class,'calories')]") List<WebElement> exerciseCalories;
    @FindBy(xpath = "//div[contains(@class,'exercise-section')]//p[contains(@class,'intensity')]") List<WebElement> exerciseIntensity;
    // Total duration and calories
    @FindBy(xpath = "//div[@class='total-duration']") WebElement totalDuration;
    @FindBy(xpath = "//div[@class='total-calories']") WebElement totalCalories;
    // Buttons
    @FindBy(xpath = "//button[contains(text(),'View Full Schedule')]") WebElement viewFullScheduleBtn;
    @FindBy(xpath = "//button[contains(text(),'Undo')]") WebElement undoBtn;
    @FindBy(xpath = "//button[contains(text(),'Mark As Completed')]") List<WebElement> markAsCompletedButtons;

    // Methods
    public String getExerciseURL() {
	    return driver.getTitle();
	}
	
    public boolean isTitleDisplayed() {
        return pageTitle.isDisplayed();
    }

    public boolean isBackToHomeBtnDisplayed() {
        return backToHomeBtn.isDisplayed();
    }

    public boolean isSectionVisible(String sectionName) {
        switch (sectionName) {
            case "Warm Up":
                return warmUpSection.isDisplayed();
            case "Main Workout":
                return mainWorkoutSection.isDisplayed();
            case "Cool Down":
                return coolDownSection.isDisplayed();
            default:
                return false;
        }
    }

    public boolean areExerciseNamesVisible() {
        return exerciseNames.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areDescriptionsVisible() {
        return exerciseDescriptions.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areDurationsVisible() {
        return exerciseDurations.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areCaloriesVisible() {
        return exerciseCalories.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areIntensityVisible() {
        return exerciseIntensity.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isValidIntensityValues() {
        for (WebElement el : exerciseIntensity) {
            String val = el.getText().toLowerCase();
            if (!(val.equals("low") || val.equals("medium") || val.equals("hard"))) {
                return false;
            }
        }
        return true;
    }

    public boolean isTotalDurationDisplayed() {
        return totalDuration.isDisplayed();
    }

    public int getTotalDuration() {
        return extractIntFromText(totalDuration.getText());
    }

    public int getSumOfIndividualDurations() {
        return exerciseDurations.stream().mapToInt(e -> extractIntFromText(e.getText())).sum();
    }

    public int getTotalCalories() {
        return extractIntFromText(totalCalories.getText());
    }

    public int getSumOfIndividualCalories() {
        return exerciseCalories.stream().mapToInt(e -> extractIntFromText(e.getText())).sum();
    }

    public void clickViewFullSchedule() {
        viewFullScheduleBtn.click();
    }

    public void clickUndo() {
        undoBtn.click();
    }

    public boolean isMarkAsCompletedButtonVisible() {
        return markAsCompletedButtons.get(0).isDisplayed();
    }

    private int extractIntFromText(String text) {
        return Integer.parseInt(text.replaceAll("\\D", ""));
    }
}