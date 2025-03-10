package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

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
    By autoComletebutton = By.xpath("//span[normalize-space()='Auto Complete']");
    By multiAutoComleteText = By.xpath("//*[@id=\"autoCompleteMultipleInput\"]");
    By singleAutoComleteText = By.xpath("//*[@id=\"autoCompleteSingleInput\"]");
    By multiAutoComleteBlueText = By.xpath("//*[@id=\"autoCompleteMultipleContainer\"]/div/div[1]/div[2]/div[1]");
    By multiAutoComleteWhiteText = By.xpath("//*[@id=\"autoCompleteMultipleContainer\"]/div/div[1]/div[1]/div[1]");
    By datePickerButton = By.xpath("//input[@id='datePickerMonthYearInput']");
    By datePickerlink = By.xpath("//span[normalize-space()='Date Picker']");
    By dateAndTimePicker = By.xpath("//input[@id='dateAndTimePickerInput']");
    By monthPickerButton = By.xpath("//select[@class='react-datepicker__month-select']");
    By yearPickerButton = By.xpath("//select[@class='react-datepicker__year-select']");
    By timeListTexts = By.xpath("//li[contains(@class, \"react-datepicker__time-list-item \")]");
    By sliderButton = By.xpath("//span[normalize-space()='Slider']");
    By sliderBar = By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input");

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
            System.out.println(e.getLocalizedMessage());
        }
        String attr = helper.findElement(By.xpath("//*[@id=\"accordianContainer\"]/div/div[3]/div[2]")).getDomAttribute("class");
        assertEquals(attr, "collapse show");
    }

    public void clickAutoCompleteButton() {
        helper.click(autoComletebutton);
    }

    public void provideColorPrefixIEBlAndSelectBlue() {
        helper.click(multiAutoComleteText);
        helper.sendKeys(multiAutoComleteText, "bl");
        this.driver.findElement(multiAutoComleteText).sendKeys(Keys.ARROW_DOWN);
        this.driver.findElement(multiAutoComleteText).sendKeys(Keys.ENTER);
    }

    public void provideColorPrefixIEWhAndSelectWhite() {
        helper.click(multiAutoComleteText);
        helper.sendKeys(multiAutoComleteText, "wh");
        this.driver.findElement(multiAutoComleteText).sendKeys(Keys.ARROW_DOWN);
        this.driver.findElement(multiAutoComleteText).sendKeys(Keys.ENTER);
    }


    public void verifySelectedColorNames() {
        helper.assertText(multiAutoComleteBlueText, "Blue");
        helper.assertText(multiAutoComleteWhiteText, "White");
    }

    public void provideSingleColorPrefixIEYeAndSelectYellow() {
        helper.click(singleAutoComleteText);
        helper.sendKeys(singleAutoComleteText, "ye");
        this.driver.findElement(singleAutoComleteText).sendKeys(Keys.ARROW_DOWN);
        this.driver.findElement(singleAutoComleteText).sendKeys(Keys.ENTER);
        helper.assertText(singleAutoComleteText, "Yellow");
    }

    public void provideSingleColorPrefixIEGreAndSelectGreen() {
        helper.click(singleAutoComleteText);
        helper.sendKeys(singleAutoComleteText, "gr");
        this.driver.findElement(singleAutoComleteText).sendKeys(Keys.ARROW_DOWN);
        this.driver.findElement(singleAutoComleteText).sendKeys(Keys.ENTER);
    }

    public void verifyLastSelectedColorNames() {
        helper.assertText(singleAutoComleteText, "Green");
    }

    public void clickDatePickerButton() {
        helper.click(datePickerlink);
    }

    public void clickDatePickerText() {
        helper.findElement(datePickerButton).click();
        Select monthList = new Select(helper.findElement(monthPickerButton));
        Select yearList = new Select(helper.findElement(yearPickerButton));
        monthList.selectByVisibleText("November");
        yearList.selectByVisibleText("1992");
        helper.scrollDown(150);
        List<WebElement> dayList = helper.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]//div[contains(@class, \"react-datepicker__day\") and not(contains(@class, \"react-datepicker__day--outside-month\"))]"));
        dayList.stream().filter(webElement -> webElement.getText().equals("30")).toList().get(0).click();
    }

    public void verifySelectedDate() {
        helper.assertText(datePickerButton, "11/30/1992");
    }

    public void clickDateAndTimePickerText() {
        helper.findElement(dateAndTimePicker).click();
        helper.scrollDown(250);
        driver.switchTo().activeElement();

        WebElement monthView = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='react-datepicker__month-read-view--selected-month']")));
        monthView.click();

        WebElement specificDiv = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div[11]")));
        specificDiv.click();
        helper.scrollDown(150);
        List<WebElement> dayList = helper.findElements(By.xpath("//div[@class=\"react-datepicker__month\"]//div[contains(@class, \"react-datepicker__day\") and not(contains(@class, \"react-datepicker__day--outside-month\"))]"));
        dayList.stream().filter(webElement -> webElement.getText().equals("30")).toList().get(0).click();
        List<WebElement> timeList = helper.findElements(timeListTexts);
        timeList.stream().filter(webElement -> webElement.getText().equals("11:30")).toList().get(0).click();

    }

    public void verifySelectedDateAndTime() {
        helper.assertText(dateAndTimePicker, "November 30, 2025 11:30 AM");
    }

    public void clickSliderButton() {
        helper.click(sliderButton);
    }

    public void provideSliderValue() {
        WebElement slider = helper.findElement(sliderBar);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int currentValue = Integer.parseInt(slider.getAttribute("value")); // Mevcut değer
        int targetValue = 53;
        int min = Integer.parseInt(slider.getAttribute("min")); // 0
        int max = Integer.parseInt(slider.getAttribute("max")); // 100

        int sliderWidth = slider.getSize().getWidth();
        int step = sliderWidth / (max - min);

        int offset = (targetValue - currentValue - 25) * step;
        helper.action.clickAndHold(slider)
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }

    public void verifySliderValue() {
        WebElement slider = helper.findElement(sliderBar);
        String newId = slider.getDomAttribute("value");
        assertEquals(newId, "53");
    }
}