package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;

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
    By progressBarButton = By.xpath("//span[normalize-space()='Progress Bar']");
    By progressBarStartButton = By.xpath("//button[@id='startStopButton']");
    By progressBar = By.xpath("//div[@role='progressbar']");
    By originTab = By.xpath("//a[@id='demo-tab-origin']");
    By originTabParagraph = By.xpath("//p[contains(text(),'Contrary to popular belief, Lorem Ipsum is not sim')]");
    By tabButton = By.xpath("//span[normalize-space()='Tabs']");
    By toolTipButton = By.xpath("//span[normalize-space()='Tool Tips']");
    By hoverButton = By.xpath("//button[@id='toolTipButton']");
    By hoverInput = By.xpath("//input[@id='toolTipTextField']");
    By hoverLink = By.xpath("//a[normalize-space()='1.10.32']");
    By menuButton = By.xpath("//span[normalize-space()='Menu']");
    By mainItemTwo = By.xpath("//a[normalize-space()='Main Item 2']");
    By subSubList = By.xpath("//a[normalize-space()='SUB SUB LIST »']");
    By subSubItem1 = By.xpath("//a[normalize-space()='Sub Sub Item 1']");
    By selectMenuButton = By.xpath("//span[normalize-space()='Select Menu']");
    By selectOptionInput = By.xpath("//*[@id=\"withOptGroup\"]");
    By selectOptionOutput = By.xpath("*[@id=\"withOptGroup\"]/div/div[1]/div[1]");
    By selectTitleInput = By.xpath("//*[@id=\"selectOne\"]");
    By groupOneActionTwo = By.xpath("//*[@id=\"react-select-2-option-0-1\"]");
    By selectMrOption = By.xpath("//*[@id=\"selectOne\"]/div[2]//*[@id=\"react-select-3-option-0-1\"]");
    By selectMrOptionOutput = By.xpath("//*[@id=\"selectOne\"]/div/div[1]/div[1]");
    By selectMultiOptionInput = By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div");
    By selectMultiOptionOutput = By.xpath("//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[1]");
    By selectMultiOptionBlack = By.xpath("//*[@class=\" css-11unzgr\"]//*[@id=\"react-select-4-option-1\"]");
    By selectMultiOptionBlue = By.xpath("//*[@class=\" css-11unzgr\"]//*[@id=\"react-select-4-option-2\"]");


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
        helper.action.clickAndHold(slider).moveByOffset(offset, 0).release().perform();
    }

    public void verifySliderValue() {
        WebElement slider = helper.findElement(sliderBar);
        String newId = slider.getDomAttribute("value");
        assertEquals(newId, "53");
    }

    public void clickProgressBarButton() {
        helper.scrollDown(350);
        helper.click(progressBarButton);
    }

    public void clickStartButton() {
        helper.scrollUp(150);
        helper.click(progressBarStartButton);
    }

    public void clickStopButtonAtPercent() {
        while (true) {
            String progress = helper.findElement(progressBar).getDomAttribute("aria-valuenow");
            if (progress != null && (Integer.parseInt(progress) == 16)) {
                helper.click(progressBarStartButton);
                break;
            }
        }
    }

    public void verifyProgressBarPercentage() {
        String progress = helper.findElement(progressBar).getDomAttribute("aria-valuenow");
        boolean result = progress != null && (progress.contains("16") || progress.contains("17"));
        assertTrue(result);
    }

    public void clickTabsButton() {
        helper.scrollDown(350);
        helper.click(tabButton);
    }

    public void clickDemoTab() {
        helper.scrollUp(150);
        helper.click(originTab);
    }

    public void verifyDemoTabParagraph() {
        boolean isParagraphTrue = helper.containText(originTabParagraph, "Contrary to popular belief, Lorem Ipsum is not sim");
        assertTrue(isParagraphTrue);
    }

    public void clickToolTipsButton() {
        helper.scrollDown(350);
        helper.click(toolTipButton);
    }

    public void hoverOverFirstButtonAndVerifyText() {
        try {
            Thread.sleep(1_500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.action.moveToElement(driver.findElement(hoverButton)).perform();
        helper.assertText(By.xpath("//*[@id=\"buttonToolTip\"]/div[2]"), "You hovered over the Button");
    }

    public void hoverOverInputAndVerifyText() {
        helper.action.moveToElement(driver.findElement(hoverInput)).perform();
        helper.assertText(By.xpath("//*[@id=\"textFieldToolTip\"]/div[2]"), "You hovered over the text field");
    }

    public void hoverOverDateAndVerifyText() {
        helper.action.moveToElement(driver.findElement(hoverLink)).perform();
        helper.assertText(By.xpath("//*[@id=\"sectionToolTip\"]/div[2]"), "You hovered over the 1.10.32");
    }

    public void clickMenuButton() {
        helper.scrollDown(500);
        helper.click(menuButton);
    }

    public void hoverMainItem() {
        helper.scrollUp(250);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        helper.hoverOver(mainItemTwo);
    }

    public void hoverSubItemsList() {
        helper.hoverOver(subSubList);
    }

    public void hoverSubItem() {
        helper.hoverOver(subSubItem1);
    }

    public void verifyLastItem() {
        boolean isDisplayed = helper.findElement(subSubItem1).isDisplayed();
        assertTrue(isDisplayed);
    }

    public void clickSelectMenuButton() {
        helper.scrollDown(500);
        helper.click(selectMenuButton);
    }

    public void clickSelectOption() {
        helper.click(selectOptionInput);
    }

    public void selectGroupOneOptionTwo() {
        helper.click(groupOneActionTwo);
    }

    public void clickSelectTitle() {
        helper.scrollDown(150);
        helper.click(selectTitleInput);
    }

    public void selectMrOption() {
        helper.findElement(selectMrOption).click();
    }

    public void clickMultiSelectTitle() {
        helper.scrollDown(250);
        helper.click(selectMultiOptionInput);
    }

    public void selectBlueAndBlackOption() {
        helper.click(selectMultiOptionBlack);
        helper.click(selectMultiOptionBlue);
    }

    public void verifySelections() {
        boolean result1 = helper.assertText(selectOptionInput, "Group 1, option 2");
        boolean result2 = helper.assertText(selectMrOptionOutput, "Mr.");
        boolean result3 = helper.containText(selectMultiOptionOutput, "Blue") && helper.containText(selectMultiOptionOutput, "Black");
        assertTrue(result1 && result2 && result3);
    }
}