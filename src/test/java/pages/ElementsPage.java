package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.ConfigReader;
import util.DriverFactory;
import util.ElementHelper;

import java.util.Properties;

public class ElementsPage {
    WebDriver driver = DriverFactory.getDriver();
    Properties properties = ConfigReader.getProperties();
    ElementHelper helper = new ElementHelper(driver);

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
}
