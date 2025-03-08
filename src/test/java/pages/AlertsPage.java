package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class AlertsPage {

    private final WebDriver driver;
    private final ElementHelper helper;

    // Locators
    By browserWindowButton = By.xpath("//span[normalize-space()='Browser Windows']");
    By newTabButton = By.xpath("//button[@id='tabButton']");
    By newTabHeaderMessage = By.xpath("//h1[@id='sampleHeading']");
    By newWindowButton = By.xpath("//button[@id='windowButton']");
    By newMessageWindowButton = By.xpath("//button[@id='messageWindowButton']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
    }

    public void clickBrowserWindowbutton() {
        helper.click(browserWindowButton);
    }

    public void clickNewButton() {
        helper.click(newTabButton);
    }

    public void verifyNewTab() {
        Object[] windowHandles = this.driver.getWindowHandles().toArray();
        this.driver.switchTo().window((String) windowHandles[1]);
        String title = this.driver.findElement(newTabHeaderMessage).getText();
        assertEquals(title, "This is a sample page");
    }

    public void clickNewWindowButton() {
        helper.click(newWindowButton);
    }

    public void verifyNewWindowMessage() {
        Object[] windowHandles = this.driver.getWindowHandles().toArray();
        this.driver.switchTo().window((String) windowHandles[1]);
        String title = this.driver.findElement(newTabHeaderMessage).getText();
        assertEquals(title, "This is a sample page");
    }

//    public void clickNewWindowMessageButton() {
//        helper.click(newMessageWindowButton);
//    }
//
//    public void verifyNewWindowMessages() {
//        Object[] windowHandles = this.driver.getWindowHandles().toArray();
//        this.driver.switchTo().window((String) windowHandles[1]);
//        String title = this.driver.getPageSource();
//        System.out.println(title);
//        assertEquals(title, "");
//    }
}
