package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v131.input.Input;
import org.openqa.selenium.support.ui.Select;
import util.ElementHelper;

public class FormsPage {
    WebDriver driver;
    ElementHelper helper;
    By practiceFormsButton = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    By firstName = By.xpath("//input[@id='firstName']");
    By lastName = By.xpath("//input[@id='lastName']");
    By email = By.xpath("//input[@id='userEmail']");
    By maleRadioButton = By.xpath("//label[@for='gender-radio-1']");
    By mobileNumber = By.xpath("//input[@id='userNumber']");
    By datePickerButton = By.xpath("//input[@id='dateOfBirthInput']");
    By monthPickerButton = By.xpath("//select[@class='react-datepicker__month-select']");
    By yearPickerButton = By.xpath("//select[@class='react-datepicker__year-select']");
    By dayPickerButton = By.xpath("//div[@aria-label='Choose Monday, November 30th, 1992']");
    By subjects = By.xpath("//div[@id = \"subjectsContainer\"]//input");
    By hobby1 = By.xpath("//label[@for='hobbies-checkbox-1']");
    By hobby2 = By.xpath("//label[@for='hobbies-checkbox-2']");
    By uploadFile = By.xpath("//input[@id='uploadPicture']");
    By currentAddress = By.xpath("//textarea[@id='currentAddress']");
    By stateSelecter = By.xpath("//*[@id=\"react-select-3-input\"]");
    By citySelecter = By.xpath("//div[contains(text(),'Select City')]");


    public FormsPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    public void clickPracticeForm() {
        helper.click(practiceFormsButton);
    }

    public void provideCridentials() {
        helper.sendKeys(firstName, "Caner");
        helper.sendKeys(lastName, "Erdem");
        helper.sendKeys(email, "ccc@ccc.com");
        helper.scrollDown(150);
        helper.selectCheckBox(maleRadioButton);
        helper.sendKeys(mobileNumber, "1234567890");

        helper.findElement(datePickerButton).click();
        Select monthList = new Select(helper.findElement(monthPickerButton));
        Select yearList = new Select(helper.findElement(yearPickerButton));
        monthList.selectByVisibleText("November");
        yearList.selectByVisibleText("1992");
        helper.click(dayPickerButton);
        helper.sendKeys(subjects, "QA Engineer");
        helper.click(hobby1);
        helper.click(hobby2);

        helper.scrollDown(150);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.sendKeys(uploadFile, "C:\\Users\\cerdem\\Desktop\\Selenium Training\\DemoqaAutomation\\src\\test\\resources\\sampleFile.jpeg");
        helper.sendKeys(currentAddress, "Next to Mars");
        Select states = new Select(helper.findElement(stateSelecter));
        states.selectByIndex(1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Select cities = new Select(helper.findElement(citySelecter));
        cities.selectByIndex(1);
    }
}
