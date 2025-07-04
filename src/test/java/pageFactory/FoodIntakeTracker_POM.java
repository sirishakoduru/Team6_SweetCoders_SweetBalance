package pageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class FoodIntakeTracker_POM {
	 WebDriver driver = DriverFactory.getDriver();
	    WebDriverWait wait;

	    public FoodIntakeTracker_POM(){
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath = "//button[.//span[text()='Food Intake']]") WebElement foodIntakeButton;
	    @FindBy(xpath = "//button[text()='Breakfast']") WebElement breakfastTab;
	    @FindBy(xpath = "//button[text()='Lunch']") WebElement lunchTab;
	    @FindBy(xpath = "//button[text()='Dinner']") WebElement dinnerTab;
	    @FindBy(xpath = "//button[text()='Snack']") WebElement snackTab;
	    @FindBy(xpath = "//div[contains(@class,'flex bg-gray-100')]//button") List<WebElement> mealTabs;
	    @FindBy(xpath = "//h1[contains(text(),'Food Intake Tracker')]") WebElement formTitle;
	    @FindBy(xpath = "//*[contains(text(),'Track what you eat to manage your diabetes better')]") WebElement formSubtext;
  	    @FindBy(id = "foodName") WebElement foodNameInput;
	    @FindBy(xpath = "//input[@id='foodName' and @placeholder='e.g., Grilled Chicken Salad']") WebElement foodNamePlaceholder;
	    @FindBy(id = "servingSize") WebElement servingSizeDropdown;
	    @FindBy(xpath = "//select[@id='servingSize']/option") List<WebElement> servingSizeOptions;
	    @FindBy(xpath = "//select[@id='servingSize']/option[@selected]") WebElement servingSizeDefault;
	    @FindBy(xpath = "//input[@name='customServingSize']") WebElement customServingSizeInput;
   	    @FindBy(id = "calories") WebElement calorieInput;
	    @FindBy(xpath = "//input[@id='calories' and @placeholder='e.g., 250']") WebElement caloriePlaceholder;
	    @FindBy(xpath = "//*[contains(text(),'Enter calories or click the calculator icon')]") WebElement calorieHelperText;
	    @FindBy(xpath = "//*[contains(text(),'Calories calculated automatically')]")  WebElement calorieAutoHelperText;
	    @FindBy(xpath = "//button[contains(@title, 'Calculate calories')]") WebElement calorieIcon;
	    @FindBy(xpath = "//button[contains(@aria-haspopup,'dialog') and contains(text(),'July')]") WebElement datePickerButton;
	    @FindBy(css = ".selected-today") WebElement highlightedToday;
	    @FindBy(css = "button[aria-label='Previous']")  WebElement prevDateButton;
	    @FindBy(css = "button[aria-label='Next']") WebElement nextDateButton;   
	    @FindBy(id = "notes") WebElement notesInput;
	    @FindBy(xpath = "//textarea[@id='notes' and contains(@placeholder,'Add any additional')]") WebElement notesPlaceholder;
        @FindBy(xpath = "//button//span[contains(text(),'Save Food Entry')]")  WebElement saveFoodEntryButton;
   	    @FindBy(xpath = "//*[contains(text(),'Food Entry is recorded')]") WebElement successMessage;
	    @FindBy(xpath = "//*[contains(text(),'Food Name is required')]") WebElement errorFoodNameRequired;
	    @FindBy(xpath = "//*[contains(text(),'Failed to save food intake')]") WebElement errorSaveFailed;
	    @FindBy(xpath = "//*[contains(text(),'Notes cannot exceed 250 words')]") WebElement notesLimitError;


	    public void clickfoodIntakeButton()
		 {
	    	foodIntakeButton.click();	 
		 }
	    public WebElement getBreakfastTab() {
	        return breakfastTab;
	    }
	    public String getFormTitle() {
	        return formTitle.getText();
	    }

	    public String getFormSubtext() {
	        return formSubtext.getText();
	    }

	    public boolean isMealTabDisplayed(String tabName) {
	        return mealTabs.stream().anyMatch(tab -> tab.getText().equalsIgnoreCase(tabName));
	    }

	    public void enterFoodName(String foodName) {
	        foodNameInput.clear();
	        foodNameInput.sendKeys(foodName);
	    }
	    public String getFoodNamePlaceholderText() {
	        return foodNamePlaceholder.getAttribute("placeholder");
	    }
	    
	    public void selectServingSize(String optionText) {
	        Select select = new Select(servingSizeDropdown);
	        select.selectByVisibleText(optionText);
	    }

	    public List<String> getAllServingSizeOptions() {
	        return servingSizeOptions.stream().map(WebElement::getText).toList();
	    }

	    public String getDefaultServingSize() {
	        return new Select(servingSizeDropdown).getFirstSelectedOption().getText();
	    }
	    
	    public String getCalorieInputValue() {
	        return calorieInput.getAttribute("value");
	    }

	    public void enterCalories(String calories) {
	        calorieInput.clear();
	        calorieInput.sendKeys(calories);
	    }

	    public void clickCalorieIcon() {
	        calorieIcon.click();
	    }

	    public void openDatePicker() {
	        datePickerButton.click();
	    }

	    public void selectPreviousDate() {
	        openDatePicker();
	        prevDateButton.click();
	    }

	    public void selectNextDate() {
	        openDatePicker();
	        nextDateButton.click();
	    }

	    public void enterNotes(String notes) {
	        notesInput.clear();
	        notesInput.sendKeys(notes);
	    }

	    public void clickSave() {
	        saveFoodEntryButton.click();
	    }

	    public boolean isSuccessMessageVisible() {
	        return successMessage.isDisplayed();
	    }
	    public boolean isErrorsaveFailedVisible() {
	        return errorSaveFailed.isDisplayed();
	    }

	    public boolean isErrorForFoodNameVisible() {
	        return errorFoodNameRequired.isDisplayed();
	    }

	    public boolean isCustomServingInputVisible() {
	        try {
	            return customServingSizeInput.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }

	    public boolean isCalorieHelperVisible() {
	        return calorieHelperText.isDisplayed();
	    }

	    public boolean isCalorieAutoHelperVisible() {
	        return calorieAutoHelperText.isDisplayed();
	    }

	    public boolean isCalorieIconVisible() {
	        return calorieIcon.isDisplayed();
	    }

	    public String getCaloriePlaceholder() {
	        return calorieInput.getAttribute("placeholder");
	    }

	    public boolean isDateTodayHighlighted() {
	        return highlightedToday.isDisplayed();
	    }

	    public boolean isSaveButtonVisible() {
	        return saveFoodEntryButton.isDisplayed();
	    }

	    public boolean isNotesLimitErrorVisible() {
	        return notesLimitError.isDisplayed();
	    }

	    public String getNotesPlaceholder() {
	        return notesInput.getAttribute("placeholder");
	    } 
	    public boolean isFoodNameVisible() {
	        return foodNameInput.isDisplayed();
	    }

	    public boolean isServingSizeDropdownVisible() {
	        return servingSizeDropdown.isDisplayed();
	    }

	    public boolean isCalorieInputVisible() {
	        return calorieInput.isDisplayed();
	    }

	    public boolean isDatePickerVisible() {
	        return datePickerButton.isDisplayed();
	    }
	    
	    public String getSelectedDateText() {
	        return datePickerButton.getText();
	    }

	    public boolean isNotesInputVisible() {
	        return notesInput.isDisplayed();
	    }
}
