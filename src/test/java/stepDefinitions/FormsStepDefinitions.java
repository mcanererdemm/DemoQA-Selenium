package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.FormsPage;
import util.DriverFactory;
import util.ElementHelper;

public class FormsStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    FormsPage formsPage = new FormsPage(driver);

    @And("Click Practice Form")
    public void clickPracticeForm() {
        formsPage.clickPracticeForm();
    }

    @And("Provide Student credentials")
    public void provideStudentCredentials() {
        formsPage.provideCridentials();
    }

    @Then("Verify Credentials")
    public void verifyCredentials() {
    }
}
