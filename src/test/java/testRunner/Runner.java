package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		//tags = "@Login_01",
		features = {"src/test/resources/features/PremiumUserRecordData/FoodIntakeValidation.feature"},
        publish = true,
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
//dryRun=true, // checks mapping between scenario steps and step definition methods
)
public class Runner {

}