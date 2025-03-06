package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NavigationPage;

public class NavigationStepsDefinitions {
    NavigationPage navigatePage = new NavigationPage();


    @Given("User reach home page")
    public void userReachHomePage() {
        navigatePage.homePage();
    }

    @When("User click elements link")
    public void userClickElementsButton() {
        navigatePage.clickElementsButton();
    }

    @Then("User navigates to elements page")
    public void userNavigatesToElementsPage() {
        navigatePage.verifyElementsPage();
    }

    @When("User click forms link {string}")
    public void userClickFormsLink(String forms) {
        navigatePage.clickFormsButton();
    }

    @Then("User navigates to forms page")
    public void userNavigatesToFormsPage() {
        navigatePage.verifyFormsPage();
    }

    @When("User click alerts link")
    public void userClickAlertsLink() {
        navigatePage.clickAlertsButton();
    }

    @Then("User navigates to alerts page")
    public void userNavigatesToAlertsPage() {
        navigatePage.verifyAlertPage();
    }

    @When("User click widgets link")
    public void userClickWidgetsLink() {
        navigatePage.clickWidgetsLink();
    }

    @Then("User navigates to widgets page")
    public void userNavigatesToWidgetsPage() {
        navigatePage.verifyWidgetPage();
    }

    @When("User click Interactions link")
    public void userClickInteractionsLink() {
        navigatePage.clickInteractionPage();
    }

    @Then("User navigates to Interactions page")
    public void userNavigatesToInteractionsPage() {
        navigatePage.verifyInteractionsPage();
    }

    @When("User click bookStore link")
    public void userClickBookStoreLink() {
        navigatePage.clickBookStoreLink();
    }

    @Then("User navigates to bookStore page")
    public void userNavigatesToBookStorePage() {
        navigatePage.verifyBookStorePage();
    }

    @When("User click banner link")
    public void userClickBannerLink() {
        navigatePage.clickBanner();
    }

    @Then("User navigates to certification page")
    public void userNavigatesToCertificationPage() {
        navigatePage.verifyCertificationPage();
    }
}
