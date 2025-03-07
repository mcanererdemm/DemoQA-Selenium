package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.time.Duration;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ElementsPage {
    WebDriver driver = DriverFactory.getDriver();
    Properties properties = ConfigReader.getProperties();
    ElementHelper helper = new ElementHelper(driver);
    WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(20));

    By elementsButton = By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]");
    By radioButton = By.xpath("//span[normalize-space()='Radio Button']");
    By warTablesButton = By.xpath("//span[normalize-space()='Web Tables']");
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
    By checkboxLink = By.xpath("//span[normalize-space()='Check Box']");
    By plusButton = By.xpath("//button[@title='Expand all']//*[name()='svg']");
    By notesCheckbox = By.xpath("//span[contains(text(),'Notes')]");
    By angularCheckbox = By.xpath("//span[contains(text(),'Angular')]");
    By generalCheckbox = By.xpath("//span[contains(text(),'General')]");
    By checkedCheckboxes = By.xpath("//*[@class=\"rct-icon rct-icon-check\"]");
    By impressiveLabel = By.xpath("//label[@for=\"impressiveRadio\"]");
    By radioButtonResult = By.xpath("//p[@class='mt-3']");
    By warTableAddButton = By.xpath("//button[@id='addNewRecordButton']");
    By warTableFirstName = By.xpath("//input[@id='firstName']");
    By warTableLastName = By.xpath("//input[@id='lastName']");
    By warTableEmail = By.xpath("//input[@id='userEmail']");
    By warTableAge = By.xpath("//input[@id='age']");
    By warTableSalary = By.xpath("//input[@id='salary']");
    By warTableDepartment = By.xpath("//input[@id='department']");
    By warTableRows = By.xpath("//div[@class=\"rt-tr-group\"]//div[@class=\"rt-tr -even\"]");
    By buttonsLink = By.xpath("//span[normalize-space()='Buttons']");
    By doubleClickButton = By.xpath("//button[@id=\"doubleClickBtn\"]");
    By doubleClickButtonMessage = By.xpath("//p[@id='doubleClickMessage']");
    By rightClickButton = By.xpath("//button[@id=\"rightClickBtn\"]");
    By rightClickButtonMessage = By.xpath("//p[@id='rightClickMessage']");
    By thirdClickButton = By.xpath("//div[@class = \"col-12 mt-4 col-md-6\"]//div/div[3]//button[1]");
    By thirdClickButtonMessage = By.xpath("//p[@id='dynamicClickMessage']");
    By linksButton = By.xpath("//span[normalize-space()='Links']");
    By homeBZY6wLink = By.xpath("//a[@id='dynamicLink']");
    By notFoundLink = By.xpath("//a[@id='invalid-url']");
    By notFoundLinkMessage = By.xpath("//p[@id='linkResponse']");
    By brokenLinksButton = By.xpath("//span[normalize-space()='Broken Links - Images']");
    By brokenLinksBrokenlinkText = By.xpath("//a[normalize-space()='Click Here for Broken Link']");
    By brokenLinksVerifyText = By.xpath("//h3[normalize-space()='Status Codes']");
    By downloadUploadButton = By.xpath("//li[@id='item-7' and @class = \"btn btn-light \"]//span[contains(text(),\"Upload and Download\")]");
    By downloadUploadlink = By.xpath("//a[@id='downloadButton']");
    By colorChangeButton = By.xpath("//button[@id='colorChange']");
    By visibleAfter5Button = By.xpath("//button[@id='visibleAfter']");
    By dynamicPropertiesButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-8']");


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

    public void clickCheckboxLink() {
        helper.click(checkboxLink);
    }

    public void plusButton() {
        helper.click(plusButton);
    }

    public void selectThreeCheckboxes() {
        helper.scrollDown(300);
        helper.selectCheckBox(notesCheckbox);
        helper.selectCheckBox(angularCheckbox);
        helper.selectCheckBox(generalCheckbox);
    }

    public void verifySelectedCheckboxes() {
        int checked = helper.findElements(checkedCheckboxes).size();
        Assert.assertEquals(checked, 3);
    }

    public void clickRadioButtonLink() {
        helper.click(radioButton);
    }

    public void selectAChoice(String choice) {
        if (choice.equals("Impressive")) {
            helper.click(impressiveLabel);
        }
    }

    public void verifyRadioSelection() {
        String text = helper.findElement(radioButtonResult).getText();
        Assert.assertEquals(text, "You have selected Impressive");
    }

    public void clickWarTableLink() {
        helper.click(warTablesButton);
    }

    public void provideWarTableCredential() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.click(warTableAddButton);
        helper.sendKeys(warTableFirstName, "Caner");
        helper.sendKeys(warTableLastName, "Erdem");
        helper.sendKeys(warTableEmail, "ccc@ccc.com");
        helper.sendKeys(warTableAge, "33");
        helper.sendKeys(warTableSalary, "33000");
        helper.sendKeys(warTableDepartment, "QA");
        helper.click(submitButton);
    }

    public void verifyWarTableCredentials() {
        WebElement element = helper.findElements(warTableRows).get(1);
        Assert.assertEquals(element.getText(), "Caner\n" +
                "Erdem\n" +
                "33\n" +
                "ccc@ccc.com\n" +
                "33000\n" +
                "QA");
    }

    public void clickButtonsLink() {
        helper.click(buttonsLink);
    }

    public void doubleClickFirstbutton() {
        helper.doubleClick(doubleClickButton);
    }

    public void rightClickSecondButton() {
        helper.scrollDown(150);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.rightClick(rightClickButton);
    }

    public void clickThirdButton() {
        helper.click(thirdClickButton);
    }


    public void verifyButtonClicks() {
        helper.scrollDown(150);
        boolean firstButton = helper.assertText(doubleClickButtonMessage, "You have done a double click");
        boolean secondButton = helper.assertText(rightClickButtonMessage, "You have done a right click");
        boolean thirdButton = helper.assertText(thirdClickButtonMessage, "You have done a dynamic click");
        Assert.assertTrue((firstButton && secondButton && thirdButton));
    }

    public void clickLinksPage() {
        helper.click(linksButton);
    }

    public void clickLinkOne(String text) {
        if (text.equals("HomeDtej4")) {
            helper.click(homeBZY6wLink);
        }
    }

    public void verifyLinksNewPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        String title = driver.getTitle();
        assertEquals(title, "DEMOQA");
    }

    public void clickNotFoundLink() {
        helper.click(notFoundLink);
    }

    public void verifyNotFoundMessage() {
        helper.assertText(notFoundLinkMessage, "Link has responded with staus 404 and status text Not Found");
    }

    public void clickBrokenLinksButton() {
        helper.click(brokenLinksButton);
    }

    public void clickBrokenLinksText() {
        helper.click(brokenLinksBrokenlinkText);
    }

    public void verifyBrokenLink() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.assertText(brokenLinksVerifyText, "Status Codes");
    }

    public void clickUploadDonwloadButton() {
        helper.click(downloadUploadButton);
    }

    public void clickDownloadLink() {
        helper.click(downloadUploadlink);
    }

    public void verifyDownloadedFile() {
        helper.isFileDownloaded("src/test/resources/", "sampleFile.jpeg");
    }

    public void clickDynamicPropertiesButton() {
        helper.click(dynamicPropertiesButton);
    }

    public void verifyButtonColorChange() {
        boolean result = waiter.until(ExpectedConditions.attributeContains(colorChangeButton, "class", "mt-4 text-danger btn btn-primary"));
        assertTrue(result);
    }

    public void verifyVisibleElementAfter5Seconds() {
        boolean result = waiter.until(ExpectedConditions.visibilityOfElementLocated(visibleAfter5Button)).isDisplayed();
        assertTrue(result);
    }
}
