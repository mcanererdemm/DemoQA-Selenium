package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class NavigationPage {
    WebDriver driver = DriverFactory.getDriver();
    Properties properties = ConfigReader.getProperties();
    ElementHelper helper = new ElementHelper(driver);

    // Locators
    By elementsLink = By.xpath("//h5[normalize-space()='Elements']");
    By headerText = By.xpath("//div[@class='col-12 mt-4 col-md-6']");
    By formsLink = By.xpath("//h5[normalize-space()='Forms']");
    By alertsLink = By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']");
    By widgetsLink = By.xpath("//h5[normalize-space()='Widgets']");
    By interactionsLink = By.xpath("//h5[normalize-space()='Interactions']");
    By bookStoreLink = By.xpath("//h5[normalize-space()='Book Store Application']");
    By bannerImage = By.xpath("//img[@alt='Selenium Online Training']");
    By certificationHeader = By.xpath("//div[@class='enroll__heading']");
    By bookHeader = By.xpath("//button[@id='login']");


    public void homePage() {
        String text = helper.findElement(elementsLink).getText();
        assertEquals(text, "Elements");
    }

    public void clickElementsButton() {
        helper.click(elementsLink);
    }

    public void verifyElementsPage() {
        String text = helper.findElement(headerText).getText();
        assertEquals(text, "Please select an item from left to start practice.");
    }

    public void clickFormsButton() {
        helper.click(formsLink);
    }

    public void verifyFormsPage() {
        String text = helper.findElement(headerText).getText();
        assertEquals(text, "Please select an item from left to start practice.");
    }

    public void clickAlertsButton() {
        helper.click(alertsLink);
    }

    public void verifyAlertPage() {
        String text = helper.findElement(headerText).getText();
        assertEquals(text, "Please select an item from left to start practice.");
    }

    public void clickWidgetsLink() {
        helper.click(widgetsLink);
    }

    public void verifyWidgetPage() {
        String text = helper.findElement(headerText).getText();
        assertEquals(text, "Please select an item from left to start practice.");
    }

    public void clickInteractionPage() {
        helper.click(interactionsLink);
    }

    public void verifyInteractionsPage() {
        String text = helper.findElement(headerText).getText();
        assertEquals(text, "Please select an item from left to start practice.");
    }

    public void clickBookStoreLink() {
        helper.scrollDown(450);
        helper.click(bookStoreLink);
    }

    public void verifyBookStorePage() {
        String text = helper.findElement(bookHeader).getText();
        assertEquals(text, "Login");
    }

    public void clickBanner() {
        helper.click(bannerImage);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        String title = driver.getTitle();
        assertEquals(title, "Tools QA - Selenium Training");
    }

    public void verifyCertificationPage() {
        String text = helper.findElement(certificationHeader).getText();
        assertEquals(text, "Selenium Certification Training | Enroll Now | Study Online");
    }
}
