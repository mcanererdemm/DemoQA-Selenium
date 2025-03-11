package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.InteractionsPage;
import util.DriverFactory;

public class InteractionStepsDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    InteractionsPage interactionsPage = new InteractionsPage(driver);

    @And("Click Sortable button")
    public void clickSortableButton() {
        interactionsPage.clickSortableButton();
    }

    @And("Click Grid tab and click and hold six")
    public void clickGridTabAndClickHoldSixButton() {
        interactionsPage.clickGridTabAndClickHoldSixButton();
    }

    @Then("Verify attribute change in six element")
    public void verifyChangeAtSixButton() {
        interactionsPage.verifyChangeAtSixButton();
    }

    @And("Click Selectables button")
    public void clickSelectablesButton() {
        interactionsPage.clickSelectablesButton();
    }

    @And("Click Second and Third Items")
    public void clickSecondAndThirdItems() {
        interactionsPage.clickSecondAndThirdItems();
    }

    @Then("Verify attribute change in those two items")
    public void verifyAttributeChangeInThoseTwoItems() {
        interactionsPage.verifyAttributeChangeInThoseTwoItems();
    }

    @And("Click Resizable button")
    public void clickResizableButton() {
        interactionsPage.clickResizableButton();
    }

    @And("resize first shape")
    public void resizeFirstShape() {
        interactionsPage.resizeFirstShape();
    }

    @Then("Verify changes in first shape")
    public void verifyChangesInFirstShape() {
        interactionsPage.verifyChangesInFirstShape();
    }
}