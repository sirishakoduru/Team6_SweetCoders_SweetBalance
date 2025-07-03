
package testRunner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;

//@RunWith(Cucumber.class)


//@CucumberOptions(features = {"src/test/resources/Features/CommonHome/CommonMeal.feature",
//							"src/test/resources/Features/Diabetes/DiabetesRisk.feature"},
@CucumberOptions(features = {"src/test/resources/Features"},
//tags = "@Login_01",

        publish = true,
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
//dryRun=true, // checks mapping between scenario steps and step definition methods
)
//public class Runner {
//}

public class RunnerCrossBrowser extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
	
	@BeforeMethod
	@Parameters({ "browser" })
	public void defineBrowser(@Optional("chrome") String browser) throws Throwable {
		ConfigReader.setBrowserType(browser);
	}
}
