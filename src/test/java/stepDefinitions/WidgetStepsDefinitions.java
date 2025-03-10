package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.WidgetsPage;
import util.DriverFactory;

public class WidgetStepsDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    WidgetsPage widgetsPage = new WidgetsPage(driver);

    @And("Click First Accordian button and verify")
    public void clickFirstAccordianButtonAndVerify() {
        widgetsPage.clickAccordianButton();
    }

    @And("Click Second Accordian button and verify")
    public void clickSecondAccordianButtonAndVerify() {
        widgetsPage.clickSecondAccordianButtonAndVerify();
    }

    @Then("Click Third Accordian button")
    public void clickThirdAccordianButton() {
        widgetsPage.clickThirdAccordianButton();
    }

    @And("Click Auto Complete button")
    public void clickAutoCompleteButton() {
        widgetsPage.clickAutoCompleteButton();
    }

    @And("Provide color prefix i.e: bl and select blue")
    public void provideColorPrefixIEBlAndSelectBlue() {
        widgetsPage.provideColorPrefixIEBlAndSelectBlue();
    }

    @And("Provide color prefix i.e: wh and select white")
    public void provideColorPrefixIEWhAndSelectWhite() {
        widgetsPage.provideColorPrefixIEWhAndSelectWhite();
    }

    @Then("Verify selected color names")
    public void verifySelectedColorNames() {
        widgetsPage.verifySelectedColorNames();
    }

    @And("Provide single color prefix i.e: ye and select Yellow")
    public void provideSingleColorPrefixIEYeAndSelectYellow() {
        widgetsPage.provideSingleColorPrefixIEYeAndSelectYellow();
    }

    @And("Provide single color prefix i.e: gre and select Green")
    public void provideSingleColorPrefixIEGreAndSelectGreen() {
        widgetsPage.provideSingleColorPrefixIEGreAndSelectGreen();
    }

    @Then("Verify last selected color names")
    public void verifyLastSelectedColorNames() {
        widgetsPage.verifyLastSelectedColorNames();
    }

    @And("Click Datepicker button")
    public void clickDatepickerButton() {
        widgetsPage.clickDatePickerButton();
    }

    @And("Click Datepicker text")
    public void clickDatepickerText() {
        widgetsPage.clickDatePickerText();
    }

    @Then("Verify selected date")
    public void verifySelectedDate() {
        widgetsPage.verifySelectedDate();
    }

    @And("Click Date and Time picker text")
    public void clickDateAndTimePickerText() {
        widgetsPage.clickDateAndTimePickerText();
    }

    @Then("Verify selected date and time")
    public void verifySelectedDateAndTime() {
        widgetsPage.verifySelectedDateAndTime();
    }

    @And("Click Slider button")
    public void clickSliderButton() {
        widgetsPage.clickSliderButton();
    }

    @And("Provide slider value")
    public void provideSliderValue() {
        widgetsPage.provideSliderValue();
    }

    @Then("Verify slider value")
    public void verifySliderValue() {
        widgetsPage.verifySliderValue();
    }

    @And("Click Progress Bar button")
    public void clickProgressBarButton() {
        widgetsPage.clickProgressBarButton();
    }

    @And("Click Start button")
    public void clickStartButton() {
        widgetsPage.clickStartButton();
    }

    @And("Click Stop button at {int} percent")
    public void clickStopButtonAtPercent(int arg0) {
        widgetsPage.clickStopButtonAtPercent();
    }

    @Then("Verify progress bar percentage")
    public void verifyProgressBarPercentage() {
        widgetsPage.verifyProgressBarPercentage();
    }

    @And("Click Tabs button")
    public void clickTabsButton() {
        widgetsPage.clickTabsButton();
    }

    @And("Click Demo tab")
    public void clickDemoTab() {
        widgetsPage.clickDemoTab();
    }

    @Then("Verify demo tab paragraph")
    public void verifyDemoTabParagraph() {
        widgetsPage.verifyDemoTabParagraph();
    }

    @And("Click Tool Tips button")
    public void clickToolTipsButton() {
        widgetsPage.clickToolTipsButton();
    }

    @And("Hover over first button and verify text")
    public void hoverOverFirstButtonAndVerifyText() {
        widgetsPage.hoverOverFirstButtonAndVerifyText();
    }

    @And("Hover over input and verify text")
    public void hoverOverInputAndVerifyText() {
        widgetsPage.hoverOverInputAndVerifyText();
    }

    @And("Hover over date and verify text")
    public void hoverOverDateAndVerifyText() {
        widgetsPage.hoverOverDateAndVerifyText();
    }
}
