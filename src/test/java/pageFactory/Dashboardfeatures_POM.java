package pageFactory;
import org.openqa.selenium.By;
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

public class Dashboardfeatures_POM {
    private static final By breathingPhaseText = null;
	String baseURL = ConfigReader.baseUrl();
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
    
    public String auth_page = "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/auth";

    public Dashboardfeatures_POM() {
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
    @FindBy(xpath = " //*[@id=\"root\"]/div[1]/nav/div/div/button[3]")
    private WebElement dashboard;
    @FindBy(xpath = " //*[@id=\"age\"]")
    private WebElement age;
    @FindBy(xpath = " //*[@id=\"height\"]")
    private WebElement height;
    @FindBy(xpath = " //*[@id=\"weight\"]")
    private WebElement weight;
    @FindBy(xpath = " //*[@id=\"exerciseLevel\"]")
    private WebElement leveldropdown;
    @FindBy(xpath = " //*[@id=\"cuisinePreference\"]")
    private WebElement cuisine;
    @FindBy(xpath = " //*[@id=\"allergies\"]")
    private WebElement allergies;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-trigger-meditation\"]")
    private WebElement meditation;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-trigger-breathing\"]")
    private WebElement breathing;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-trigger-movement\"]")
    private WebElement movement;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-content-meditation\"]/div/div/div[2]/div/div[1]/button")
    private WebElement playbutton;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-trigger-mindfulness\"]")
    private WebElement mindfullness;
    @FindBy(xpath = " //*[@id=\"root\"]/div[1]/main/div[5]/div/div[3]/h4")
    private WebElement benefits;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-content-breathing\"]/div/div/div[2]/button")
    private WebElement startbreathing;
    @FindBy(xpath = " //*[@id=\"radix-:r6:-content-breathing\"]/div/div/div[2]/button")
    private WebElement stop;
    @FindBy(xpath = " //*[@id=\"root\"]/div[1]/main/div[1]/div[2]/p")
     WebElement message;
  ////*[@id="root"]/div[1]/main/div[1]/div[1]/h3/text()[1]
    
 // Login Method with explicit waits
    public void login() {
        driver.get(auth_page);
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("manasa.venna@yahoo.com");
        continueemail.click();
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys("number@123");
        signin.click();
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
    public boolean clickdashboard() {
    	login();
    	dashboard.click();
    	return true;
    }
    public void viewmetrics( ) {
    	clickdashboard();
    }
    public String getmessage()
    {
    	String value=message.getText();
    	return value;
    }
    public void premium() {
    	clickdashboard();
    }
    public void account() {
    	clickdashboard();
    }
    //public void save() {
    	//clickdashboard();
    //}
    
    public void accountinform() {
    	clickdashboard();
    }
    public void age() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	age.clear();
    	age.sendKeys("5");
    	
    }
    public void height() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	height.clear();
    	height.sendKeys("54");
    	
    }
    public void weight() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	weight.clear();
    	weight.sendKeys("6");
        }
    public void leveldropdown() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	leveldropdown.click();
        }
    public void cuisine() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	cuisine.click();
    	}
    public void allergies() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	allergies.click();
       }
    public void heading() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	}
    public void navigationbar() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	}
    public void clickeachtab() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	meditation.click();
    	breathing.click();
    	movement.click();
    	}
    public void meditation() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	meditation.click();
    	}
    public void duration() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	meditation.click();
    	}
    public void audio() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	meditation.click();
    	}
    public void playback() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	playbutton.click();
    	}
    public void movement() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	movement.click();
    	}
    public void mindfullness() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	mindfullness.click();
    	}
    public void benefits() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	benefits.click();
    	}
    public void breathingtab() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breathing.click();
    	}
    public void seestartbutton() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breathing.click();
    	}
    public void cyclescompleted() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breathing.click();
    	}
    public void currentphase() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breathing.click();
    	}
    public void steps() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	breathing.click();
    	}
    public void startbreathing() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	startbreathing.click();
    	}
    
    public void startBreathingCycle() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	startbreathing.click();
    }

    public String getCurrentBreathingPhase() {
        return driver.findElement(breathingPhaseText).getText().trim();
    }

    public boolean waitForPhase(String expectedPhase, int seconds) {
        long start = System.currentTimeMillis();
        while ((System.currentTimeMillis() - start) < (seconds * 1000L)) {
            String actualPhase = getCurrentBreathingPhase();
            if (actualPhase.equalsIgnoreCase(expectedPhase)) {
                return true;
            }
        }
        return false;
    }
    public void completeCycle() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	startbreathing.click();
    }
    public String getBreathingPhase() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	startbreathing.click();
		return auth_page;
    }
    
    public String stop() {
    	clickdashboard();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)");
    	startbreathing.click();
		return auth_page;
    }
	
}

