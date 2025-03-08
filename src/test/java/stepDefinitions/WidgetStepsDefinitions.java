package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AlertsPage;
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
}
