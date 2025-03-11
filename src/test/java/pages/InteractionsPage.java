package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;

public class InteractionsPage {

    private final WebDriver driver;
    private final ElementHelper helper;
    private final WebDriverWait waiter;

    // Locators
    By sortableButton = By.xpath("//span[normalize-space()='Sortable']");
    By gridTab = By.xpath("//a[@id='demo-tab-grid']");
    By gridItemSixButton = By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action'][normalize-space()='Six']");

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickSortableButton() {
        helper.click(sortableButton);
    }

    public void clickGridTabAndClickHoldSixButton() {
        try {
            Thread.sleep(3000);
            helper.click(gridTab);
            helper.clickAndHold(gridItemSixButton);
            Thread.sleep(2000);
            String attStyle = helper.findElement(gridItemSixButton).getDomAttribute("style");
            Assert.assertEquals(attStyle, "opacity: 0; visibility: hidden;");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyChangeAtSixButton() {
        String attStyle = helper.findElement(gridItemSixButton).getDomAttribute("style");
        Assert.assertEquals(attStyle, "opacity: 0; visibility: hidden;");
    }
}