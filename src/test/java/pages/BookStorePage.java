package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;

public class BookStorePage {

    private final WebDriver driver;
    private final ElementHelper helper;
    private final WebDriverWait waiter;

    // Locators
    By inputSearchBox = By.xpath("//input[@id='searchBox']");
    By rowList = By.xpath("//div[contains(@role,'row') and @class=\"rt-tr-group\"]");
    By loginLink = By.xpath("//span[normalize-space()='Login']");
    By userName = By.xpath("//input[@id='userName']");
    By password = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@id='login']");
    By newUserButton = By.xpath("//button[@id='newUser']");
    By verficationText = By.xpath("//p[@id='name']");
    By firstName = By.xpath("//input[@id='firstname']");
    By lastName = By.xpath("//input[@id='lastname']");
    By registerButton = By.xpath("//button[@id='register']");
    By registerVerifyMessage = By.xpath("//*[@id=\"name\"]");


    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void provideZIntoInputBar() {
        try {
            Thread.sleep(3000);
            WebElement input = waiter.until(ExpectedConditions.elementToBeClickable(helper.findElement(inputSearchBox)));
            input.sendKeys("z");
            input.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            String text = helper.findElements(rowList).get(0).findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/img")).getDomAttribute("src");
            Assert.assertEquals(text, "/images/bookimage0.jpg");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyItemInTheTable() {
        int rowListNumber = helper.findElements(rowList).size();
        Assert.assertEquals(rowListNumber, 10);
    }

    public void userClickLoginButton() {
        helper.scrollDown(300);
        helper.click(loginLink);
    }

    public void userProvideCredentialsAndClickLogin() {
        helper.sendKeys(userName, "Caner");
        helper.sendKeys(password, "12345");
        helper.click(loginButton);
    }

    public void verifyUserIsLoggedIn() {
        String text = helper.findElement(verficationText).getText();
        Assert.assertEquals(text, "Invalid username or password!");
    }

    public void userClickNewUserButton() {
        helper.scrollDown(400);
        helper.click(newUserButton);
    }

    public void userProvideCredentialsAndClickRegister() {
        try {
            helper.scrollDown(300);
            helper.sendKeys(firstName, "Caner");
            helper.sendKeys(lastName, "Erdem");
            helper.sendKeys(userName, "Cerdem");
            helper.sendKeys(password, "Tcac123@");
            Thread.sleep(5_000);
            helper.click(registerButton);
            helper.scrollDown(300);
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyUserIsRegistered() {
        helper.scrollDown(300);
        WebElement element = helper.findElement(registerVerifyMessage);
        String text = element.getText();
        Assert.assertEquals(text, "User exists!");
    }
}