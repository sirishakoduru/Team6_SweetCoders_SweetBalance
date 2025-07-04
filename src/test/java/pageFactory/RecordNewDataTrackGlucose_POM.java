package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import utilities.ConfigReader;

public class RecordNewDataTrackGlucose_POM {

	String baseURL = ConfigReader.baseUrl();
	String loginURL = ConfigReader.loginUrl();
	String email = ConfigReader.loginEmail();
	WebDriver driver;
	WebDriverWait wait;
		  
    @FindBy(xpath = "//button[.//span[text()='Blood Glucose']]") WebElement bloodGlucoseButton;
    @FindBy(xpath = "//h1[text()='Track Glucose']") WebElement headerTrackGlucose;
    @FindBy(xpath = "//p[contains(text(),'Keep your health')]") WebElement subHeaderHealthCheck;
    @FindBy(xpath = "//label[contains(text(),'Blood Glucose Level')]") WebElement labelBloodGlucose;
    @FindBy(name = "value") WebElement inputBloodGlucose;
    @FindBy(xpath = "//label[contains(text(),'Reading Type')]") WebElement labelReadingType;
    @FindBy(xpath = "//label[contains(text(),'Date')]") WebElement labelDate;
    @FindBy(xpath = "//span[contains(text(),'mg/dL')]") WebElement labelMgDl;
    @FindBy(xpath = "//div[text()='Low']") WebElement LowLevel;
    @FindBy(xpath = "//div[text()='Normal']") WebElement NormalLevel;
    @FindBy(xpath = "//div[text()='High']") WebElement HighLevel;
    @FindBy(xpath = "//button[text()='Fasting']") WebElement btnFasting;
    @FindBy(xpath = "//button[text()='Pre-meal']") WebElement btnPreMeal;
    @FindBy(xpath = "//button[text()='Post-meal']") WebElement btnPostMeal;
    @FindBy(xpath = "//button[text()='Bedtime']") WebElement btnBedtime;
    @FindBy(xpath = "//button[contains(text(),'July 3rd, 2025')]") WebElement btnDatePicker;
    @FindBy(xpath = "//div[contains(@class,'calendar')]") WebElement calendar;
    @FindBy(xpath = "//div[contains(@class,'calendar')]//button[contains(@class,'prev')]") WebElement btnPrevDate;
    @FindBy(xpath = "//div[contains(@class,'calendar')]//button[contains(@class,'next')]") WebElement btnNextDate;
    @FindBy(xpath = "//div[contains(@class,'calendar')]//button[contains(@class,'today')]") WebElement btnTodayDate;
    @FindBy(xpath = "//div[contains(text(),'Last reading:')]") WebElement infoLastReading;
    @FindBy(xpath = "//button[normalize-space()='Record Reading']") WebElement RecordReadingButton;
    @FindBy(xpath = "//div[contains(text(),'Reading successfully recorded!')]") WebElement successMessage;

    public RecordNewDataTrackGlucose_POM() {
		 WebDriver driver = DriverFactory.getDriver();
		 PageFactory.initElements(driver, this);
		}
    
    public void clickbloodGlucoseButton()
	 {
		 bloodGlucoseButton.click();	 
	 }

    public boolean headerTrackGlucoseIsVisible()
	 {
		return  headerTrackGlucose.isDisplayed();	 
	 }	
    public void labelMgDlText()
 	 {
    	labelMgDl.getText();	 
 	 }
    
    public String getTitleText() {
        return headerTrackGlucose.getText();
    }

    public String getSubtext() {
        return subHeaderHealthCheck.getText();
    }
    
      public boolean areFieldsPresent() {
        return labelBloodGlucose.isDisplayed() &&
               labelReadingType.isDisplayed() &&
               labelDate.isDisplayed();
    }

      public boolean isInputFieldDisplayed() {
          return inputBloodGlucose.isDisplayed();
      }

      public boolean isMgDlDisplayed() {
          return labelMgDl.isDisplayed();
      }

      public boolean areTransitionLevelsPresent() {
          return LowLevel.isDisplayed() && NormalLevel.isDisplayed() && HighLevel.isDisplayed();
      }

      public String getLowColor() {
          return LowLevel.getCssValue("color");
      }

      public String getNormalColor() {
          return NormalLevel.getCssValue("color");
      }

      public String getHighColor() {
          return HighLevel.getCssValue("color");
      }
      
      public boolean areButtonsPresent() {
          return btnFasting.isDisplayed() && btnPreMeal.isDisplayed() &&
                 btnPostMeal.isDisplayed() && btnBedtime.isDisplayed();
      }

      public boolean isDatePickerPresent() {
          return btnDatePicker.isDisplayed();
      }

       public void openDatePicker() {
         btnDatePicker.click();
     }

     public boolean isLastReadingPresent() {
         return infoLastReading.isDisplayed();
     }
       
     public boolean isRecordReadingButtonPresent() {
         return RecordReadingButton.isDisplayed();
     }

     public void enterGlucoseValue(String value) {
         inputBloodGlucose.clear();
         inputBloodGlucose.sendKeys(value);
     }

     public String getGlucoseInputValue() {
         return inputBloodGlucose.getAttribute("value");
     }

     public void clickRecordReading() {
         RecordReadingButton.click();
     }

     public boolean isSuccessMessageDisplayed() {
         return successMessage.isDisplayed();
     }

     public boolean isAnyTransitionHighlighted() {
         // Example logic: check if any of the transition divs have a "highlighted" or similar class
         return LowLevel.getAttribute("class").contains("highlight") ||
                NormalLevel.getAttribute("class").contains("highlight") ||
                HighLevel.getAttribute("class").contains("highlight");
     }
     public boolean isCalendarVisible() {
         return calendar.isDisplayed();
     }

     public boolean isTodayDateHighlighted() {
         return btnTodayDate.getAttribute("class").contains("highlight");
     }

     public boolean isPrevDateButtonVisible() {
         return btnPrevDate.isDisplayed();
     }

     public boolean isNextDateButtonVisible() {
         return btnNextDate.isDisplayed();
     }
}
