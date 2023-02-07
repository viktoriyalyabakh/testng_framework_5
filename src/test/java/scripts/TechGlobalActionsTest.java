package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.Duration;

public class TechGlobalActionsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionsPage = new TechGlobalActionsPage();
        actions = new Actions(driver);
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled as "Click on me"
     * Verify that  message appears next of the element stating "You clicked on a button!"
     * Perform a right click action on the second web element labeled as "Right-Click on me""
     * Verify that  message appears next of the element stating "You right-clicked on a button!"
     * Perform a double click action on the third web element labeled as "Double-Click on me"
     * Verify that  message appears next of the element stating "You double-clicked on a button!"
     */

    @Test(priority = 1, description = "Click first thre boxes and validate results")
    public void clickAction(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://techglobal-training.netlify.app/frontend/actions");
        Assert.assertTrue(techGlobalActionsPage.clickBox.isDisplayed());
        actions.moveToElement(techGlobalActionsPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionsPage.clickResult.getText(), "You clicked on a button!");

        Assert.assertTrue(techGlobalActionsPage.rightClickBox.isDisplayed());
        actions.moveToElement(techGlobalActionsPage.rightClickBox).contextClick().perform();
        Assert.assertEquals(techGlobalActionsPage.rightClickResult.getText(), "You right-clicked on a button!");

        Assert.assertTrue(techGlobalActionsPage.doubleClickBox.isDisplayed());
        actions.moveToElement(techGlobalActionsPage.doubleClickBox).doubleClick().perform();
        Assert.assertEquals(techGlobalActionsPage.doubleClickResult.getText(), "You double-clicked on a button!");
    }

    @Test(priority = 2, description = "Validate click button")
    public void clickOnAction(){
        Assert.assertTrue(techGlobalActionsPage.clickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionsPage.clickBox.isEnabled());
       actions.moveToElement(techGlobalActionsPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionsPage.clickResult.getText(), "You clicked on a button!");
    }

    @Test(priority = 3, description = "Validate right-click button")
    public void rightClickAction(){
        Assert.assertTrue(techGlobalActionsPage.rightClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionsPage.rightClickBox.isEnabled());
        actions.moveToElement(techGlobalActionsPage.rightClickBox).contextClick().perform();
        Assert.assertEquals(techGlobalActionsPage.rightClickResult.getText(), "You right-clicked on a button!");
    }

    @Test(priority = 4, description = "Validate double-click button")
    public void doubleClickAction(){
        Assert.assertTrue(techGlobalActionsPage.doubleClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionsPage.doubleClickBox.isEnabled());
        actions.moveToElement(techGlobalActionsPage.doubleClickBox).doubleClick().perform();
        Waiter.waitForVisibilityOfElement(techGlobalActionsPage.doubleClickResult, 20);
        Assert.assertEquals(techGlobalActionsPage.doubleClickResult.getText(), "You double-clicked on a button!");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the  web element stating "An element dropped here!"
     */

    @Test(priority = 5, description = "Validate drag-and-drop element")
    public void dragAnDropAction(){

//        actions.moveToElement(techGlobalActionsPage.dragMeBox)
//                .clickAndHold().moveToElement(techGlobalActionsPage.dropHereBox)
//                .release().perform();

        actions.dragAndDrop(techGlobalActionsPage.dragMeBox, techGlobalActionsPage.dropHereBox).perform();

        Waiter.waitForVisibilityOfElement(techGlobalActionsPage.dragAndDropResult, 30);
        Assert.assertEquals(techGlobalActionsPage.dragAndDropResult.getText(), "An element dropped here!");
    }

    /**
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “techglobal” to input box with uppercases
     * Validate the value attribute for search input box is “TECHGLOBAL”
     * Then, copy the text and paste again
     * Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test(priority = 6, description = "Validate key action")
    public void keyBoardAction(){
        techGlobalActionsPage.inputBox.clear();
        actions.keyDown(Keys.SHIFT).sendKeys(techGlobalActionsPage.inputBox, "techglobal").keyUp(Keys.SHIFT)
                .keyDown(Keys.COMMAND).pause(Duration.ofSeconds(2)).sendKeys("a").sendKeys("c").keyUp(Keys.COMMAND).sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND).sendKeys("v").pause(Duration.ofSeconds(2)).perform();

        Assert.assertEquals(techGlobalActionsPage.inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
    }



}
