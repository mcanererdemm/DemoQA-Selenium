package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WidgetsPage {

    private final WebDriver driver;
    private final ElementHelper helper;
    private final WebDriverWait waiter;

    // Locators
    By accorianButton = By.xpath("//span[normalize-space()='Accordian']");
    By accorianButtonMessage = By.xpath("//h1[@class='text-center']");
    By thirdAccorianButtonMessage = By.xpath("//div[@id='section3Heading']");
    By firstAccordianMessage = By.xpath("//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]");


    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickAccordianButton() {
        helper.click(accorianButton);
        helper.assertText(accorianButtonMessage, "Accordian");
    }

    public void clickSecondAccordianButtonAndVerify() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = helper.findElement(firstAccordianMessage).getText();
        assertTrue(text.contains("Lorem Ipsum is simply dummy text of the printing a"));
    }

    public void clickThirdAccordianButton() {
        helper.scrollDown(150);
        helper.click(thirdAccorianButtonMessage);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        String attr = helper.findElement(By.xpath("//*[@id=\"accordianContainer\"]/div/div[3]/div[2]")).getDomAttribute("class");
        assertEquals(attr, "collapse show");
    }
}