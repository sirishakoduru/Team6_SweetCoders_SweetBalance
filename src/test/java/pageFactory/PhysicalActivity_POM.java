package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class PhysicalActivity_POM {
	 WebDriver driver = DriverFactory.getDriver();
	    WebDriverWait wait;

	    public PhysicalActivity_POM(){
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath = "//button[.//span[text()='Physical Activity']]") WebElement physicalActivityButton;
	    @FindBy(xpath = "//h2[text()='Physical Activity']")
	    WebElement title;

	    @FindBy(xpath = "//p[contains(text(),'Track your fitness journey')]")
	    WebElement subtext;

	    @FindBy(id = "activityType")
	    WebElement activityTypeDropdown;

	    @FindBy(xpath = "//select[@id='activityType']/option")
	    List<WebElement> activityTypeOptions;

	    @FindBy(id = "duration")
	    WebElement durationInput;

	    @FindBy(name = "durationUnit")
	    WebElement durationUnitDropdown;

	    @FindBy(xpath = "//select[@name='durationUnit']/option")
	    List<WebElement> durationUnitOptions;

	    @FindBy(css = "button[aria-haspopup='dialog']")
	    WebElement datePickerButton;

	    @FindBy(css = "div[role='dialog']")
	    WebElement calendarPopup;

	    @FindBy(css = ".react-datepicker__day--today, .highlighted-today")
	    WebElement todayDate;

	    @FindBy(css = "button[aria-label='Previous Month']")
	    WebElement prevMonthButton;

	    @FindBy(css = "button[aria-label='Next Month']")
	    WebElement nextMonthButton;

	    @FindBy(xpath = "//button[text()='Light']")
	    WebElement lightIntensity;

	    @FindBy(xpath = "//button[text()='Moderate']")
	    WebElement moderateIntensity;

	    @FindBy(xpath = "//button[text()='Vigorous']")
	    WebElement vigorousIntensity;

	    @FindBy(xpath = "//button[contains(., 'Save Activity')]")
	    WebElement saveActivityButton;

	    @FindBy(xpath = "//*[contains(text(),'Your activity is recorded')]")
	    WebElement confirmationMessage;

	  
	    
	    public void ClickPhysicalActivityButton()
		 {
	    	physicalActivityButton.click();	 
		 }
	    public String getFormTitle() {
	        return title.getText();
	    }

	    public String getSubtext() {
	        return subtext.getText();
	    }

	    public boolean isDropdownDisplayed() {
	        return activityTypeDropdown.isDisplayed();
	    }

	    public boolean verifyDropdownOptions(String[] expectedOptions) {
	        for (String expected : expectedOptions) {
	            boolean found = activityTypeOptions.stream()
	                .anyMatch(option -> option.getText().trim().equalsIgnoreCase(expected));
	            if (!found) return false;
	        }
	        return true;
	    }

	    public boolean isDurationFieldDisplayed() {
	        return durationInput.isDisplayed();
	    }

	    public boolean verifyDurationPlaceholder(String expectedPlaceholder) {
	        return durationInput.getAttribute("placeholder").equals(expectedPlaceholder);
	    }

	    public boolean isDurationUnitDropdownDisplayed() {
	        return durationUnitDropdown.isDisplayed();
	    }

	    public boolean verifyDurationUnitOptions(String[] expectedUnits) {
	        for (String expected : expectedUnits) {
	            boolean found = durationUnitOptions.stream()
	                .anyMatch(option -> option.getText().trim().equalsIgnoreCase(expected));
	            if (!found) return false;
	        }
	        return true;
	    }

	    public void clickDatePicker() {
	        datePickerButton.click();
	    }

	    public boolean isCalendarVisible() {
	        return calendarPopup.isDisplayed();
	    }

	    public boolean isTodayHighlighted() {
	        return todayDate.isDisplayed();
	    }

	    public boolean isPrevNextButtonsVisible() {
	        return prevMonthButton.isDisplayed() && nextMonthButton.isDisplayed();
	    }

	    public boolean areIntensityButtonsVisible() {
	        return lightIntensity.isDisplayed() && moderateIntensity.isDisplayed() && vigorousIntensity.isDisplayed();
	    }

	    public void selectIntensity(String level) {
	        switch (level.toLowerCase()) {
	            case "light":
	                lightIntensity.click();
	                break;
	            case "moderate":
	                moderateIntensity.click();
	                break;
	            case "vigorous":
	                vigorousIntensity.click();
	                break;
	        }
	    }

	    public void enterDuration(String value) {
	        durationInput.clear();
	        durationInput.sendKeys(value);
	    }

	    public String getDurationInputValue() {
	         return durationInput.getAttribute("value");
	    }
	    
	    public void clickSaveActivity() {
	        saveActivityButton.click();
	    }

	    public boolean isConfirmationVisible() {
	        return confirmationMessage.isDisplayed();
	    }

	    public boolean isSaveButtonVisible() {
	        return saveActivityButton.isDisplayed();
	    }

}
