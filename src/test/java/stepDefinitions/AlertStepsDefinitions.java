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
        alertPage.clickAlertsButton();
    }

    @And("Click First Button and accept")
    public void clickFirstButtonAndAccept() {
        alertPage.clickFirstButton();
    }

    @And("Click Second Button and accept")
    public void clickSecondButtonAndAccept() {
        alertPage.clickSecondButton();
    }

    @And("Click Third Button and accept")
    public void clickThirdButtonAndAccept() {
        alertPage.clickThirdButton();
    }

    @And("Click Fourth Button, provide an input and accept")
    public void clickFourthButtonProvideAnInputAndAccept() {
        alertPage.clickFourthBotton();
    }

    @Then("Verify Alert Messages")
    public void verifyAlertMessages() {
        alertPage.verifyAlertmessages();
    }

    @And("User click Frames Button")
    public void userClickFramesButton() {
        alertPage.clickFramesButton();
    }

    @Then("Verify First iFrame")
    public void verifyFirstIFrame() {
        alertPage.verifyIframeOne();
    }

    @And("Verify Second iFrame")
    public void verifySecondIFrame() {
        alertPage.verifyIframeTwo();
    }

    @And("User click Nested Frames Button")
    public void userClickNestedFramesButton() {
        alertPage.clickNestedFramesButton();
    }

    @Then("Verify First Parent Frame")
    public void verifyFirstParentFrame() {
        alertPage.verifyParentFrame();
    }

    @And("Verify Second Child Frame")
    public void verifySecondChildFrame() {
        alertPage.verifyChildFrame();
    }

    @And("User click Modals Dialog Button")
    public void userClickModalsDialogButton() {
        alertPage.clickModalsDialogButton();
    }

    @Then("Verify small dialog")
    public void verifySmallDialog() {
        alertPage.verifySmallDialog();
    }

    @And("Verify large dialog")
    public void verifyLargeDialog() {
        alertPage.verifyLargeDialog();
    }
}
