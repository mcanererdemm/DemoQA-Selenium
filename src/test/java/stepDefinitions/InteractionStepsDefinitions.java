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
}