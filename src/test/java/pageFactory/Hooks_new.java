package pageFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.*;

public class Hooks_new {

	private static boolean isBrowserLaunched = false;
    private static WebDriver driver;

    @Before
    public void setup(Scenario scenario) throws Exception {
        if (!isBrowserLaunched) {
            LoggerLoad.info("Launching browser...");
            ConfigReader.intializeProperties();

            String browser = ConfigReader.getBrowserType();
            if (browser == null) {
                browser = ConfigReader.getProperty("browser");
            }

            DriverFactory.initializeBrowser(browser);
            driver = DriverFactory.getDriver();
            driver.get(ConfigReader.getProperty("baseURL"));

            isBrowserLaunched = true;
        } else {
            LoggerLoad.info("Reusing existing browser session for scenario: " + scenario.getName());
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        String scenarioName = scenario.getName().replaceAll(" ", "_");

        if (scenario.isFailed() && driver != null) {
            LoggerLoad.error("Scenario Failed — taking screenshot");
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenarioName);

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenarioName + ".png"));
        }

        // DO NOT QUIT THE DRIVER HERE
        // If we quit here, the browser will close after every scenario
    }

    @AfterAll
    public static void afterAll() throws Throwable {
        LoggerLoad.info("Closing browser after all scenarios");
        DriverFactory.quitDriver();
        isBrowserLaunched = false;
    }
}
