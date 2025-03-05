package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initializeDriver(String browser) {
        properties = ConfigReader.getProperties();

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        String url = properties.getProperty("url");
        int pageLoadTimeout = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        int implicitTimeout = Integer.parseInt(properties.getProperty("impTimeout"));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeout));
        driver.manage().window().maximize();
        driver.get(url);

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
