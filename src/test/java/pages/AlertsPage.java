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

public class AlertsPage {

    private final WebDriver driver;
    private final ElementHelper helper;
    private final WebDriverWait waiter;

    // Locators
    By browserWindowButton = By.xpath("//span[normalize-space()='Browser Windows']");
    By newTabButton = By.xpath("//button[@id='tabButton']");
    By newTabHeaderMessage = By.xpath("//h1[@id='sampleHeading']");
    By newWindowButton = By.xpath("//button[@id='windowButton']");
    // By newMessageWindowButton = By.xpath("//button[@id='messageWindowButton']");
    By alertsButton = By.xpath("//span[normalize-space()='Alerts']");
    By firstClickMeButton = By.xpath("//button[@id='alertButton']");
    By secondClickMeButton = By.xpath("//button[@id='timerAlertButton']");
    By thirdClickMeButton = By.xpath("//button[@id='confirmButton']");
    By thirdClickMeButtonMessage = By.xpath("//span[@id='confirmResult']");
    By fourthClickMeButton = By.xpath("//button[@id='promtButton']");
    By fourthClickMeButtonMessage = By.xpath("//span[@id='promptResult']");
    By framesButton = By.xpath("//span[normalize-space()='Frames']");
    By nestedFramesButton = By.xpath("//span[normalize-space()='Nested Frames']");
    By modalsDialogButton = By.xpath("//span[normalize-space()='Modal Dialogs']");
    By iframesOne = By.xpath("//*[@id=\"frame1\"]");
    By iframesTwo = By.xpath("//*[@id=\"frame2\"]");
    By iframesHeader = By.xpath("//*[@id=\"sampleHeading\"]");
    By smallModalButton = By.xpath("//button[@id='showSmallModal']");
    By smallModalMessage = By.xpath("//div[@id='example-modal-sizes-title-sm']");
    By largeModalButton = By.xpath("//button[@id='showLargeModal']");
    By largeModalMessage = By.xpath("//div[@id='example-modal-sizes-title-lg']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    public void clickAlertsButton() {
        helper.click(alertsButton);
    }

    public void clickFirstButton() {
        helper.click(firstClickMeButton);
        Alert alert = this.driver.switchTo().alert();
        String text = alert.getText();
        assertEquals(text, "You clicked a button");
        alert.accept();
    }

    public void clickSecondButton() {
        try {
            waiter.until(ExpectedConditions.elementToBeClickable(secondClickMeButton));
            helper.click(secondClickMeButton);
            // Alert'in görünmesini bekle (maksimum 10 saniye)
            waiter.until(ExpectedConditions.alertIsPresent());

            // Alert'i ele al ve kabul et
            String title = this.driver.switchTo().alert().getText();
            assertEquals(title, "This alert appeared after 5 seconds");
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Alert ele alınırken hata oluştu: " + e.getMessage());
        }
    }

    public void clickThirdButton() {
        helper.click(thirdClickMeButton);
        Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }

    public void clickFourthBotton() {
        helper.click(fourthClickMeButton);
        Alert alert = this.driver.switchTo().alert();
        alert.sendKeys("Caner Erdem");
        alert.accept();
    }

    public void verifyAlertmessages() {
        helper.assertText(thirdClickMeButtonMessage, "You selected Ok");
        helper.assertText(fourthClickMeButtonMessage, "You entered Caner Erdem");
    }

    public void clickFramesButton() {
        helper.click(framesButton);
    }

    public void verifyIframeOne() {
        WebElement iFrame = helper.findElement(iframesOne);
        this.driver.switchTo().frame(iFrame);
        helper.assertText(iframesHeader, "This is a sample page");
        this.driver.switchTo().defaultContent();
    }

    public void verifyIframeTwo() {
        WebElement iFrame = helper.findElement(iframesTwo);
        this.driver.switchTo().frame(iFrame);
        helper.assertText(iframesHeader, "This is a sample page");
    }

    public void clickNestedFramesButton() {
        helper.click(nestedFramesButton);
    }

    public void verifyParentFrame() {
        WebElement iFrame = helper.findElement(iframesOne);
        this.driver.switchTo().frame(iFrame);
        helper.assertText(By.xpath("/html/body"), "Parent frame");
        this.driver.switchTo().defaultContent();
    }

    public void verifyChildFrame() {
        WebElement iFrame = helper.findElement(iframesOne);
        this.driver.switchTo().frame(iFrame);
        WebElement iFrameTwo = helper.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]"));
        this.driver.switchTo().frame(iFrameTwo);
        helper.assertText(By.xpath("//p[normalize-space()='Child Iframe']"), "Child frame");
        this.driver.switchTo().defaultContent();
    }

    public void clickModalsDialogButton() {
        helper.click(modalsDialogButton);
    }

    public void verifySmallDialog() {
        helper.click(smallModalButton);
        this.driver.switchTo().activeElement();
        helper.assertText(smallModalMessage, "Small Modal");
        helper.click(By.xpath("//button[@id='closeSmallModal']"));
        this.driver.switchTo().defaultContent();
    }

    public void verifyLargeDialog() {
        helper.click(largeModalButton);
        this.driver.switchTo().activeElement();
        helper.assertText(largeModalMessage, "Large Modal");
    }
}