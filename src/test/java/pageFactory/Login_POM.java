package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import utilities.ConfigReader;

public class Login_POM {
	
	String baseURL = ConfigReader.baseUrl();
	WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;

	public Login_POM() {
		PageFactory.initElements(driver, this);
	}
}
