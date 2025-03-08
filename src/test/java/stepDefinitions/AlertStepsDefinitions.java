package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AlertsPage;
import util.DriverFactory;

public class AlertStepsDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    AlertsPage alertPage = new AlertsPage(driver);

    @When("Click Browser Window Button")
    public void clickBrowserWindowButton() {
        alertPage.clickBrowserWindowbutton();
    }

    @When("Click New Tab button")
    public void clickNewTabButton() {
        alertPage.clickNewButton();
    }

    @When("Verify New Tab Message")
    public void verifyNewTabMessage() {
        alertPage.verifyNewTab();
    }

    @And("Click New Window button")
    public void clickNewWindowButton() {
        alertPage.clickNewWindowButton();
    }

    @Then("Verify New Window Message")
    public void verifyNewWindowMessage() {
        alertPage.verifyNewWindowMessage();
    }

    //    @And("Click New Window Message button")
//    public void clickNewWindowMessageButton() {
//        alertPage.clickNewWindowMessageButton();
//    }
//
//    @Then("Verify New Window Messages")
//    public void verifyNewWindowMessages() {
//        alertPage.verifyNewWindowMessages();
//    }

    @And("Click Alerts Button")
    public void clickAlertsButton() {
    }

    @And("Click First Button and accept")
    public void clickFirstButtonAndAccept() {
    }

    @And("Click Second Button and accept")
    public void clickSecondButtonAndAccept() {
    }

    @And("Click Third Button and accept")
    public void clickThirdButtonAndAccept() {
    }

    @And("Click Fourth Button, provide an input and accept")
    public void clickFourthButtonProvideAnInputAndAccept() {
    }

    @Then("Verify Alert Messages")
    public void verifyAlertMessages() {
    }
}
