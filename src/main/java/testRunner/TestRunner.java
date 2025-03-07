package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"util", "stepDefinitions"},
        tags = "@UploadDownload"
        //plugin = {"summary", "pretty", "html:Reports/CucumberReports/Reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}