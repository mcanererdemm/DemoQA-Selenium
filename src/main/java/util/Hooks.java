package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.util.Properties;

public class Hooks {
    private static WebDriver driver;

    @Before
    public static void setup() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        Properties properties = ConfigReader.initProperties();
        driver = DriverFactory.initializeDriver(browser);
    }

    @After
    public static void tearDown() {
        //driver.quit();
    }
}
