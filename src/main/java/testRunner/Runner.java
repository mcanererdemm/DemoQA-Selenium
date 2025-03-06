package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"util", "stepDefinitions"},
        tags = "@NavigationSuite",
        plugin = {"summary", "pretty", "html:Reports/CucumberReports/Reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {
}