package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import driver.DriverFactory;
import utilities.ConfigReader;

public class Homepagefeaturesonlyforfreeuser_POM {
    String baseURL = ConfigReader.baseUrl();
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
    
    public String auth_page = "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/auth";

    public Homepagefeaturesonlyforfreeuser_POM() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // WebElements with more stable locators
    @FindBy(id = ":r0:-form-item")
    private WebElement email;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/form/button")
    private WebElement continueemail;

    @FindBy(xpath = "//*[@id=\":r7:-form-item\"]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div[2]/form/button")
    private WebElement signin;
    @FindBy(xpath ="//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[4]")
    private WebElement nutritionheading;
    @FindBy(xpath ="//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[1]/button[1]")
    private WebElement  breakfast;
    @FindBy(xpath ="//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[1]/div/button")
    private WebElement fulplan;
    @FindBy(xpath ="//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[1]/div/button[2]")
    private WebElement excercise;
    @FindBy(xpath ="//*[@id=\"root\"]/div[1]/main/div[2]/div/div/div[2]/div/div[1]/button")
    private WebElement excercisefullschedule;
  
    @FindBy(xpath ="//*[text()=' Login")
    private WebElement loginclick;
    // Login Method with explicit waits
    public void login() {
    	loginclick.click();
        driver.get(auth_page);
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("manasa.venna@yahoo.com");
        continueemail.click();
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys("number@123");
        signin.click();
        waitForPageToLoad();
    }

    public void heading() {
        login();
        wait.until(ExpectedConditions.elementToBeClickable(nutritionheading)).click();
        waitForPageToLoad();
    }
    
    private void waitForPageToLoad() {
        try {
            Thread.sleep(2000); // Brief pause for page transitions
            wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Add method to scroll to element if needed
    //private void scrollToElement(WebElement element) {
       // ((org.openqa.selenium.JavascriptExecutor) driver)
       //    .executeScript("arguments[0].scrollIntoView(true);", element);
       // try {
        /////    Thread.sleep(500); // Small pause after scroll
       // } catch (InterruptedException e) {
        //    e.printStackTrace();
       // }
   // }
    public void seehorizontalcrabs() {
    	heading();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	
    }
    public void premealtitle() {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    }
    public void carbsvalue() {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breakfast.click();
    	
    }
    public void proteinvalue( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breakfast.click();
    }
    public void fatvalue( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	nutritionheading.click();
    }
    public void intaketime( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breakfast.click();
    	
    }
    public void snacktime( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	nutritionheading.click();
    	
    }
    public void snack( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	nutritionheading.click();
    	
    }
    public void presnack( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	nutritionheading.click();
    	
    }
    public void premeal( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	nutritionheading.click();
    	
    }
    public void viewfullmealplan( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	//fulplan.click();
    	
    }
    public void clickexercise( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void exerciselist( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void time( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void morning( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void evening( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void plan( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void clockindicator( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void duration( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void format( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void indicator( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void exerciseitem( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void viewfullschedule( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	excercise.click();
    }
    public void clickfullschedule( ) {
    	login();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	//excercise.click();
    	//excercisefullschedule.click();
    	}

    }

