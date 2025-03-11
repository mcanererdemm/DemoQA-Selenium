package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;

public class BookStorePage {

    private final WebDriver driver;
    private final ElementHelper helper;
    private final WebDriverWait waiter;

    // Locators
    By inputSearchBox = By.xpath("//input[@id='searchBox']");
    By rowList = By.xpath("//div[contains(@role,'row') and @class=\"rt-tr-group\"]");

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void provideZIntoInputBar() {
        try {
            Thread.sleep(3000);
            WebElement input = waiter.until(ExpectedConditions.elementToBeClickable(helper.findElement(inputSearchBox)));
            input.sendKeys("z");
            input.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            String text = helper.findElements(rowList).get(0).findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/img")).getDomAttribute("src");
            Assert.assertEquals(text, "/images/bookimage0.jpg");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyItemInTheTable() {
        int rowListNumber = helper.findElements(rowList).size();
        Assert.assertEquals(rowListNumber, 10);
    }
}