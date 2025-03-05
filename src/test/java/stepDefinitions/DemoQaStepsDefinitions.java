package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class DemoQaStepsDefinitions {
    HomePage homePage = new HomePage();


    @Given("Reach demoqa home page")
    public void reachDemoQAHomePage() {
        homePage.reachHomePage();
    }

    @When("Click Elements to reach elements page")
    public void clickElementsToReachElementsPage() {
        homePage.clickElementsButton();
    }

    @And("Click Textbox to open form")
    public void clickTextboxToOpenForm() {
        homePage.clickTextbox();
    }

    @And("Provide credentials")
    public void provideCredentials() {
        homePage.provideCredentials();
    }

    @Then("Credentials shown in the same page")
    public void credentialsShownInTheSamePage() {
        homePage.credentialsShownCorrectly();
    }
}
