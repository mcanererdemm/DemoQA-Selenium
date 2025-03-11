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

    @And("Click Droppable button")
    public void clickDroppableButton() {
        interactionsPage.clickDroppableButton();
    }

    @And("Drag item at simple tab")
    public void dragItemAtSimpleTab() {
        interactionsPage.dragItemAtSimpleTab();
    }

    @Then("Verify changes Dropped at Simple tab")
    public void verifyChangesDroppedAtSimpleTab() {
        interactionsPage.verifyChangesDroppedAtSimpleTab();
    }

    @And("Click Accept tab")
    public void clickAcceptTab() {
        interactionsPage.clickAcceptTab();
    }

    @And("Drag acceptable item into drop here")
    public void dragAcceptableItemIntoDropHere() {
        interactionsPage.dragAcceptableItemIntoDropHere();
    }

    @And("Drag not acceptable item into drop here")
    public void dragNotAcceptableItemIntoDropHere() {
        interactionsPage.dragNotAcceptableItemIntoDropHere();
    }

    @Then("Verify changes Dropped at Accept tab")
    public void verifyChangesDroppedAtAcceptTab() {
        interactionsPage.verifyChangesDroppedAtAcceptTab();
    }

    @And("Click Dragabble button")
    public void clickDragabbleButton() {
        interactionsPage.clickDragabbleButton();
    }

    @And("Click Axis Restricted tab")
    public void clickAxisRestrictedTab() {
        interactionsPage.clickAxisRestrictedTab();
    }

    @And("Drag Only X item")
    public void dragOnlyXItem() {
        interactionsPage.dragOnlyXItem();
    }

    @And("Drag Only Y item")
    public void dragOnlyYItem() {
        interactionsPage.dragOnlyYItem();
    }

    @Then("Verify changes at dragabbles")
    public void verifyChangesAtDragabbles() {
        interactionsPage.verifyChangesAtDragabbles();
    }
}