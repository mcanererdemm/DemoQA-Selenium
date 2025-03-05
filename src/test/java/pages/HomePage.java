package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.util.Properties;

public class HomePage {
    WebDriver driver = DriverFactory.getDriver();
    Properties properties = ConfigReader.getProperties();
    ElementHelper helper = new ElementHelper(driver);

    By elementsButton = By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]");
    By textBox = By.xpath("//span[normalize-space()='Text Box']");
    By fullName = By.xpath("//input[@id='userName']");
    By email = By.xpath("//input[@id='userEmail']");
    By currentAddress = By.xpath("//textarea[@id='currentAddress']");
    By permanentAddress = By.xpath("//textarea[@id='permanentAddress']");
    By submitButton = By.xpath("//button[@id='submit']");
    By resultName = By.xpath("//p[@id='name']");
    By resultEmail = By.xpath("//p[@id='email']");
    By resultCAddress = By.xpath("//p[@id='currentAddress']");
    By resultPAddress = By.xpath("//p[@id='permanentAddress']");

    public void reachHomePage() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, properties.getProperty("url"));
    }

    public void clickElementsButton() {
        helper.click(elementsButton);
    }

    public void clickTextbox() {
        helper.click(textBox);
    }

    public void provideCredentials() {
        helper.scrollDown(250);
        helper.clickAndSendKeys(fullName, "Caner Erdem");
        helper.clickAndSendKeys(email, "ccc@ccc.com");
        helper.clickAndSendKeys(currentAddress, "Current Address");
        helper.clickAndSendKeys(permanentAddress, "Permanent Address");
        helper.click(submitButton);
    }

    public void credentialsShownCorrectly() {
        helper.scrollDown(150);
        helper.assertText(resultName, "Name:Caner Erdem");
        helper.assertText(resultEmail, "Email:ccc@ccc.com");
        helper.assertText(resultCAddress, "Current Address :Current Address");
        helper.assertText(resultPAddress, "Permananet Address :Permanent Address");
    }
}
