package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import driver.DriverFactory;
import utilities.ConfigReader;

public class ExerciseModuleOn_POM {
	String baseURL = ConfigReader.baseUrl();
	String loginURL = ConfigReader.loginUrl();
	String email = ConfigReader.loginEmail();
	WebDriver driver;
	WebDriverWait wait;
	
	 @FindBy(xpath = "//button[contains(text(),'🎯 Challenge Yourself Today!')]") WebElement challengeYourselfButton;
	 @FindBy(xpath = "//h3[contains(text(),'Current Status')]") WebElement currentStatusHeader;
	 @FindBy(xpath = "//button[.//span[text()='Exercise']]") WebElement exerciseTab;
	 @FindBy(xpath = "//button[contains(text(),'View Full Schedule')]") WebElement viewFullScheduleButton;
	 @FindBy(xpath = "//h2[contains(text(),\"Today's Exercise Schedule\")]") WebElement pageTitle;
	 @FindBy(xpath = "//button[contains(text(),'Back to Home')]") WebElement backToHomeButton;
	 @FindBy(xpath = "//h3[contains(text(),'Warm Up')]") WebElement warmUpSection;
	 @FindBy(xpath = "//h3[contains(text(),'Main Workout')]") WebElement mainWorkoutSection;
	 @FindBy(xpath = "//h3[contains(text(),'Cool Down')]") WebElement coolDownSection;
	 @FindBy(css = "h4")  WebElement exerciseName;
	 @FindBy(css = "p") WebElement exerciseDescription;
	 @FindBy(xpath = "//div[contains(text(),'Duration')]") WebElement durationText;
	 @FindBy(xpath = "//div[contains(text(),'Calories')]") WebElement caloriesText;
	 @FindBy(xpath = "//div[contains(text(),'Intensity')]")WebElement intensityText;
	 @FindBy(xpath = "(//button[contains(text(),'Mark As Completed')])[1]") WebElement markAsCompletedButton;
	 @FindBy(xpath = "//button[contains(text(),'Completed')]") WebElement completedButton;
	 @FindBy(xpath = "//div[contains(text(),'Success')]") WebElement successDialog;
	 @FindBy(xpath = "//button[contains(text(),'Undo')]") WebElement undoButton;
	 
	 public ExerciseModuleOn_POM() {
		 WebDriver driver = DriverFactory.getDriver();
			PageFactory.initElements(driver, this);
		}
	 
	 public WebElement getChallengeYourselfButton() {
		    return challengeYourselfButton;
		}
	 
	 public WebElement getCurrentStatusHeader() {
		    return currentStatusHeader;
		}
	 
	 public void clickExerciseTab()
	 {
		  exerciseTab.click();	 
	 }
	 
	 public boolean isViewFullScheduleDisplayed()
	 {
		 return viewFullScheduleButton.isDisplayed();	 
	 }
	 
	 public void clickViewFullScheduleButton()
	 {
		 viewFullScheduleButton.click();	 
	 }
	 
	 public boolean isPageTitleDisplayed()
	 {
		 return pageTitle.isDisplayed();	 
	 }
	 	 public boolean isWarmUpSectionDisplayed()
	 {
	 		return warmUpSection.isDisplayed();	 
	 }
	 	
	 public boolean isMainWorkoutSectionDisplayed()
	 {
		 return mainWorkoutSection.isDisplayed();	 
	 }
	 
	 public boolean isCoolDownSectionDisplayed()
	 {
		 return coolDownSection.isDisplayed();	 
	 }
	 
	 public void ClickBackToHomeButton()
	 {
		 backToHomeButton.click();	 
	 }
	 
	 public void clickTab(String tabName) {
	        switch (tabName) {
	            case "Warm Up":
	            	warmUpSection.click();
	                break;
	            case "Main Workout":
	                mainWorkoutSection.click();
	                break;
	            case "Cool Down":
	                coolDownSection.click();
	                break;
	        }
	    }
	 
	 public WebElement getExerciseTabElement() {
		    return exerciseTab;
		}
	 
	   public String getExerciseName(String Text) {
	        return exerciseName.getText();
	    }

	    public String getExerciseDescription() {
	        return exerciseDescription.getText();
	    }

	    public String getDurationText() {
	        return durationText.getText();
	    }

	    public String getCaloriesText() {
	        return caloriesText.getText();
	    }

	    public String getIntensityText() {
	        return intensityText.getText();
	    }
	    public boolean isExerciseNameDisplayed() {
	        return exerciseName.isDisplayed();
	    }

	    public boolean isDescriptionDisplayed() {
	        return exerciseDescription.isDisplayed();
	    }

	    public boolean isDurationDisplayed() {
	        return durationText.isDisplayed();
	    }

	    public boolean isCaloriesDisplayed() {
	        return caloriesText.isDisplayed();
	    }

	    public boolean isIntensityDisplayed() {
	        return intensityText.isDisplayed();
	    }
	    
	    public boolean isMarkAsCompletedButtonVisible() {
	        return markAsCompletedButton.isDisplayed();
	    }
	    
	    public boolean isButtonVisibleForTab(String tabName, String buttonText) {
	        clickTab(tabName); // click the correct tab first
	        try {
	            String dynamicXpath = "//section[.//h2[contains(text(),'" + tabName + "')]]//button[contains(text(),'" + buttonText + "')]";
	            WebElement button = driver.findElement(By.xpath(dynamicXpath));
	            return button.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	    
		 public void ClickMarkAsCompletedButton()
		 {
			 markAsCompletedButton.click();	 
		 }
		 
		 public boolean isCompletedButtonVisible() {
		       return completedButton.isDisplayed();
		    }
		  
		 public boolean isSuccessDialogDisplayed()
		 {
			 return successDialog.isDisplayed();	 
		 }
		 public boolean isUndoButtonDisplayed()
		 {
			 return undoButton.isDisplayed();	 
		 }
		 
		 public void clickUndoButton()
		 {
			 undoButton.click();	 
		 }

}
