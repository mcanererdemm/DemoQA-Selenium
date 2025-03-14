package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ElementsPage;

public class ElementsPageStepsDefinitions {
    ElementsPage elementsPage = new ElementsPage();


    @Given("Reach demoqa home page")
    public void reachDemoQAHomePage() {
        elementsPage.reachHomePage();
    }

    @When("Click Elements to reach elements page")
    public void clickElementsToReachElementsPage() {
        elementsPage.clickElementsButton();
    }

    @And("Click Textbox to open form")
    public void clickTextboxToOpenForm() {
        elementsPage.clickTextbox();
    }

    @And("Provide credentials")
    public void provideCredentials() {
        elementsPage.provideCredentials();
    }

    @Then("Credentials shown in the same page")
    public void credentialsShownInTheSamePage() {
        elementsPage.credentialsShownCorrectly();
    }

    @And("Click checkbox link to open checkboxes")
    public void clickCheckboxLinkToOpenCheckboxes() {
        elementsPage.clickCheckboxLink();
    }

    @And("Click plus button to show all checkboxes")
    public void clickPlusButtonToShowAllCheckboxes() {
        elementsPage.plusButton();
    }

    @And("Select {string}, {string} and {string}")
    public void selectThreeCheckboxes(String arg0, String arg1, String arg2) {
        elementsPage.selectThreeCheckboxes();
    }

    @Then("Verify selected checkboxes")
    public void verifySelectedCheckboxes() {
        elementsPage.verifySelectedCheckboxes();
    }

    @And("Click Radio Button")
    public void clickRadioButton() {
        elementsPage.clickRadioButtonLink();
    }

    @When("Select a {string}<Impressive>{string}")
    public void select_a_ımpressive(String string, String string2) {
        elementsPage.selectAChoice("Impressive");
    }

    @Then("Verify Selection")
    public void verifySelection() {
        elementsPage.verifyRadioSelection();
    }

    @And("Click War Tables")
    public void clickWarTables() {
        elementsPage.clickWarTableLink();
    }

    @And("Provide personal cridentials and submit")
    public void providePersonalCredentialsAndSubmit() {
        elementsPage.provideWarTableCredential();
    }

    @Then("Verify added cridentials")
    public void verifyAddedCredentials() {
        elementsPage.verifyWarTableCredentials();
    }

    @And("Click Buttons link")
    public void clickButtonsLink() {
        elementsPage.clickButtonsLink();
    }

    @And("Double Click first button")
    public void doubleClickFirstButton() {
        elementsPage.doubleClickFirstbutton();
    }

    @And("Right Click second button")
    public void rightClickSecondButton() {
        elementsPage.rightClickSecondButton();
    }

    @And("Click third button")
    public void clickThirdButton() {
        elementsPage.clickThirdButton();
    }

    @Then("Verify button clicks")
    public void verifyButtonClicks() {
        elementsPage.verifyButtonClicks();
    }

    @And("Click Links button")
    public void clickLinksButton() {
        elementsPage.clickLinksPage();
    }

    @And("Click HomeDtej{int} link")
    public void clickHomeDtejLink(int arg0) {
        elementsPage.clickLinkOne("HomeDtej4");
    }

    @Then("Verify new tab")
    public void verifyNewTab() {
        elementsPage.verifyLinksNewPage();
    }

    @And("Click Not Found link")
    public void clickNotFoundLink() {
        elementsPage.clickNotFoundLink();
    }

    @Then("Verify {string} message")
    public void verifyMessage(String arg0) {
        elementsPage.verifyNotFoundMessage();
    }

    @And("Click Broken Links button")
    public void clickBrokenLinksButton() {
        elementsPage.clickBrokenLinksButton();
    }

    @And("Click Broken Link")
    public void clickBrokenLink() {
        elementsPage.clickBrokenLinksText();
    }

    @Then("Verify <Status Codes> message")
    public void verifyStatusCodesMessage() {
        elementsPage.verifyBrokenLink();
    }

    @And("Click Upload Downlaoad Links button")
    public void clickUploadDownlaoadLinksButton() {
        elementsPage.clickUploadDonwloadButton();
    }

    @And("Click Download Link")
    public void clickDownloadLink() {
        elementsPage.clickDownloadLink();
    }

    @Then("Verify Downloaded File")
    public void verifyDownloadedFile() {
        elementsPage.verifyDownloadedFile();
    }

    @And("Click Dynamic Properties Links button")
    public void clickDynamicPropertiesLinksButton() {
        elementsPage.clickDynamicPropertiesButton();
    }

    @Then("Verify Color Change Button")
    public void verifyColorChangeButton() {
        elementsPage.verifyButtonColorChange();
    }

    @And("Verify Color Visible After {int} Seconds Button")
    public void verifyColorVisibleAfterSecondsButton(int arg0) {
        elementsPage.verifyVisibleElementAfter5Seconds();
    }
}
