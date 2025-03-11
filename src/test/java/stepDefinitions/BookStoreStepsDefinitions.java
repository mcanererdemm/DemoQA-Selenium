package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.BookStorePage;
import util.DriverFactory;

public class BookStoreStepsDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    BookStorePage bookStorePage = new BookStorePage(driver);

    @And("Provide z into input bar")
    public void provideZIntoInputBar() {
        bookStorePage.provideZIntoInputBar();
    }

    @Then("Verify item in the table")
    public void verifyItemInTheTable() {
        bookStorePage.verifyItemInTheTable();
    }

    @And("User click Login Button")
    public void userClickLoginButton() {
        bookStorePage.userClickLoginButton();
    }

    @And("User provide credentials and click login")
    public void userProvideCredentialsAndClickLogin() {
        bookStorePage.userProvideCredentialsAndClickLogin();
    }

    @Then("Verify user is logged in")
    public void verifyUserIsLoggedIn() {
        bookStorePage.verifyUserIsLoggedIn();
    }

    @And("User click new user button")
    public void userClickNewUserButton() {
        bookStorePage.userClickNewUserButton();
    }

    @And("User provide credentials and click register")
    public void userProvideCredentialsAndClickRegister() {
        bookStorePage.userProvideCredentialsAndClickRegister();
    }

    @Then("Verify user is registered")
    public void verifyUserIsRegistered() {
        bookStorePage.verifyUserIsRegistered();
    }
}
