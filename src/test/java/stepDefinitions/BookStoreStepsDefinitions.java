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
}
