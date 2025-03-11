package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class InteractionsPage {

    private final WebDriver driver;
    private final ElementHelper helper;
    private final WebDriverWait waiter;

    // Locators
    By sortableButton = By.xpath("//span[normalize-space()='Sortable']");
    By selectablesButton = By.xpath("//span[normalize-space()='Selectable']");
    By resizableButton = By.xpath("//span[normalize-space()='Resizable']");
    By dragabbleButton = By.xpath("//span[normalize-space()='Dragabble']");

    By gridTab = By.xpath("//a[@id='demo-tab-grid']");
    By gridItemSixButton = By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action'][normalize-space()='Six']");
    By listSecondItem = By.xpath("//li[normalize-space()='Dapibus ac facilisis in']");
    By listSecondItemAfter = By.xpath("//li[normalize-space()='Dapibus ac facilisis in']");
    By listThirdItem = By.xpath("//li[normalize-space()='Morbi leo risus']");
    By listThirdItemAfter = By.xpath("//li[normalize-space()='Morbi leo risus']");
    By cornerOfFirstResizable = By.xpath("//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']");
    By firstResizableShapeAfter = By.xpath("//*[@id=\"resizableBoxWithRestriction\"]");
    By droppableButton = By.xpath("//span[normalize-space()='Droppable']");
    By droppableSimple = By.xpath("//div[@id='draggable']");
    By droppableSimpleDropHere = By.xpath("//*[@id=\"droppable\"]");
    By acceptTab = By.xpath("//a[@id='droppableExample-tab-accept']");
    By acceptableDrop = By.xpath("//div[@id='acceptable']");
    By notAcceptableDrop = By.xpath("//div[@id='notAcceptable']");
    By accaptableDropHere = By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']");
    By axisRestrictedTab = By.xpath("//a[@id='draggableExample-tab-axisRestriction']");
    By onlyXDrag = By.xpath("//div[@id='restrictedX']");
    By onlyYDrag = By.xpath("//div[@id='restrictedY']");

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickSortableButton() {
        helper.click(sortableButton);
    }

    public void clickGridTabAndClickHoldSixButton() {
        try {
            Thread.sleep(3000);
            helper.click(gridTab);
            helper.clickAndHold(gridItemSixButton);
            Thread.sleep(2000);
            String attStyle = helper.findElement(gridItemSixButton).getDomAttribute("style");
            assertEquals("opacity: 0; visibility: hidden;", attStyle);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyChangeAtSixButton() {
        String attStyle = helper.findElement(gridItemSixButton).getDomAttribute("style");
        assertEquals("opacity: 0; visibility: hidden;", attStyle);
    }

    public void clickSelectablesButton() {
        helper.click(selectablesButton);
    }

    public void clickSecondAndThirdItems() {
        helper.click(listSecondItem);
        helper.click(listThirdItem);
    }

    public void verifyAttributeChangeInThoseTwoItems() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String attrSecond = helper.findElement(listSecondItemAfter).getDomAttribute("class");
        String attrThird = helper.findElement(listThirdItemAfter).getDomAttribute("class");
        boolean result = attrSecond != null && attrSecond.equals(attrThird) && attrSecond.equals("mt-2 list-group-item active list-group-item-action");
        assertTrue(result);
    }

    public void clickResizableButton() {
        helper.click(resizableButton);
    }

    public void resizeFirstShape() {
        try {
            helper.scrollDown(250);
            Thread.sleep(3000);
            WebElement cornerElement = helper.findElement(cornerOfFirstResizable);
            helper.action.moveToElement(cornerElement).clickAndHold().moveByOffset(300, 200).release().perform();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyChangesInFirstShape() {
        String attr = helper.findElement(firstResizableShapeAfter).getDomAttribute("style");
        assertEquals("width: 500px; height: 300px;", attr);
    }

    public void clickDroppableButton() {
        helper.scrollDown(350);
        helper.click(droppableButton);
    }

    public void dragItemAtSimpleTab() {
        try {
            helper.scrollDown(250);
            Thread.sleep(2000);
            helper.action
                    .moveToElement(helper.findElement(droppableSimple)).clickAndHold()
                    .moveToElement(helper.findElement(droppableSimpleDropHere)).release().perform();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyChangesDroppedAtSimpleTab() {
        String attr = helper.findElement(droppableSimpleDropHere).getDomAttribute("class");
        assertEquals("drop-box ui-droppable ui-state-highlight", attr);
    }

    public void clickAcceptTab() {
        helper.click(acceptTab);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void dragAcceptableItemIntoDropHere() {
        waiter.until(ExpectedConditions.elementToBeClickable(acceptableDrop));
        helper.action
                .moveToElement(helper.findElement(acceptableDrop)).clickAndHold()
                .moveToElement(helper.findElement(accaptableDropHere)).release().perform();
        String attrOfDropHere = helper.findElement(accaptableDropHere).getDomAttribute("class");
        assertEquals("drop-box ui-droppable ui-state-highlight", attrOfDropHere);

    }

    public void dragNotAcceptableItemIntoDropHere() {
        waiter.until(ExpectedConditions.elementToBeClickable(notAcceptableDrop));
        helper.action.moveToElement(helper.findElement(notAcceptableDrop)).clickAndHold()
                .moveToElement(helper.findElement(accaptableDropHere)).release().perform();
        String attrOfDropHere = helper.findElement(accaptableDropHere).getDomAttribute("class");
        assertEquals("drop-box ui-droppable ui-state-highlight", attrOfDropHere);
    }

    public void verifyChangesDroppedAtAcceptTab() {
        String attrOfDropHere = helper.findElement(droppableSimpleDropHere).getDomAttribute("class");
        assertEquals("drop-box ui-droppable", attrOfDropHere);
    }

    public void clickDragabbleButton() {
        helper.scrollDown(400);
        waiter.until(ExpectedConditions.elementToBeClickable(helper.findElement(dragabbleButton))).click();
    }

    public void clickAxisRestrictedTab() {
        waiter.until(ExpectedConditions.elementToBeClickable(helper.findElement(axisRestrictedTab))).click();
    }

    public void dragOnlyXItem() {
        try {
            WebElement onlyX = waiter.until(ExpectedConditions.elementToBeClickable(helper.findElement(onlyXDrag)));
            Thread.sleep(1000);
            Point xStart = onlyX.getLocation();
            helper.action.moveToElement(onlyX).clickAndHold().moveByOffset(100, 100).release().perform();
            Point xEnd = onlyX.getLocation();
            assertEquals(xStart.getY(), xEnd.getY());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void dragOnlyYItem() {
        try {
            WebElement onlyY = waiter.until(ExpectedConditions.elementToBeClickable(helper.findElement(onlyYDrag)));
            Thread.sleep(1000);
            Point yStart = onlyY.getLocation();
            helper.action.moveToElement(onlyY).clickAndHold().moveByOffset(100, 100).release().perform();
            Point yEnd = onlyY.getLocation();
            assertEquals(yStart.getX(), yEnd.getX());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void verifyChangesAtDragabbles() {
    }
}