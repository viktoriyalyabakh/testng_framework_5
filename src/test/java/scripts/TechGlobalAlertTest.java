package scripts;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.AlertHandler;
import utilities.Waiter;


public class TechGlobalAlertTest extends TechGlobalBase{
    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Alerts" card
    Click on "Warning alert" button
    Validate the alert text equals "You are on TechGlobal Training application."
    Click on "OK" button on the alert
    Validate the result message equals "You accepted warning by clicking OK."
     */

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Alerts");
    }

            /*
            Go to https://techglobal-training.netlify.app/
        Click on "Practices" dropdown in the header
        Select the "Frontend Testing" option
        Click on the "Alerts" card
        Click on "Warning alert" button
        Validate the alert text equals "You are on TechGlobal Training application."
        Click on "OK" button on the alert
        Validate the result message equals "You accepted warning by clicking OK."
             */

    @Test(priority = 1, description = "Validate warning Alert")
    public void validateWarningAlert() {
        techGlobalAlertsPage.clickOnAlert("Warning alert");
        //Validating alert text
        Assert.assertEquals(AlertHandler.getAlertText(driver), "You are on TechGlobal Training application.");

        AlertHandler.acceptAlert();
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You accepted warning by clicking OK.");
    }
            /*
               Go to https://techglobal-training.netlify.app/
        Click on "Practices" dropdown in the header
        Select the "Frontend Testing" option
        Click on the "Alerts" card
        Click on "Confirmation alert" button
        Validate the alert text equals "Would you like to stay on TechGlobal Training application?"
        Click on "Cancel" button on the alert
        Validate the result message equals "You rejected the alert by clicking Cancel."
        Click on "Confirmation alert" button again
        Click on "OK" button on the alert
        Validate the result message equals "You confirmed the alert by clicking OK."
                 */

    @Test(priority = 2, description = "Validate Confirmation Alert")
    public void validateConfirmationAlert() {
        techGlobalAlertsPage.clickOnAlert("Confirmation alert");
        Assert.assertEquals(AlertHandler.getAlertText(driver), "Would you like to stay on TechGlobal Training application?");
        AlertHandler.dismissAlert();
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You rejected the alert by clicking Cancel.");
        techGlobalAlertsPage.clickOnAlert("Confirmation alert");
        AlertHandler.acceptAlert();
        Waiter.pause(2);
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You confirmed the alert by clicking OK.");
    }

    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Alerts" card
    Click on "Prompt alert" button
    Validate the alert text equals "What would you like to say to TechGlobal?"
    Click on "Cancel" button on the alert
    Validate the result message equals "You rejected the alert by clicking Cancel."
    Click on "Prompt alert" button again
    Click on "OK" button on the alert
    Validate the result message equals "You entered "" in the alert and clicked OK."
    Click on "Prompt alert" button again
    Enter "Hello" to alert input box
    Click on "OK" button on the alert
    Validate the result message equals "You entered "Hello" in the alert and clicked OK."
     */

    @Test(priority = 2, description = "Validate Prompt Alert")
    public void validatePromptAlert() {
        techGlobalAlertsPage.clickOnAlert("Prompt alert");
        Assert.assertEquals(AlertHandler.getAlertText(driver), "What would you like to say to TechGlobal?");
        AlertHandler.dismissAlert();
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You rejected the alert by clicking Cancel.");

        techGlobalAlertsPage.clickOnAlert("Prompt alert");
        AlertHandler.acceptAlert();
        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You entered \"\" in the alert and clicked OK.");

        techGlobalAlertsPage.clickOnAlert("Prompt alert");
        AlertHandler.sendKeysToAlert("Hello");
        AlertHandler.acceptAlert();

        Assert.assertEquals(techGlobalAlertsPage.result.getText(), "You entered \"Hello\" in the alert and clicked OK.");
    }
}
