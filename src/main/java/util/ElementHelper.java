package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    private final WebDriver driver;
    private final WebDriverWait waiter;
    private final Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
    }

    public WebElement presenceElement(By key) {
        return waiter.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        return element.findElement(key);
    }

    public void click(By key) {
        this.findElement(key).click();
    }

    public void sendKeys(By key, String text) {
        this.findElement(key).sendKeys(text);
    }

    public void clickAndSendKeys(By key, String text) {
        this.findElement(key).click();
        this.findElement(key).sendKeys(text);
    }

    public void scrollDown(int length) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + length + ")", "");
    }

    public boolean assertText(By key, String text) {
        String elementText = this.findElement(key).getText();
        return elementText.equals(text);
    }
}
