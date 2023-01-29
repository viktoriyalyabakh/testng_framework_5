package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIframePage;

public class TechGlobalIframeTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIframePage = new TechGlobalIframePage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }
/*
    Go to https://techglobal-training.netlify.app/
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “IFrames” card
    Validate the “Please fill out your information below” text

 */

    @Test(priority = 1)
    public void validateInputHeader(){
        driver.switchTo().frame(techGlobalIframePage.iFrameId);
        Assert.assertTrue(techGlobalIframePage.inputHeader.isDisplayed());
        Assert.assertEquals(techGlobalIframePage.inputHeader.getText(), "Please fill out your information below");
    }

    /*
    Go to https://techglobal-training.netlify.app/
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “IFrames” card
    Enter “John” to first name input box
    Enter “Doe” to last name input box
    Click on “SUBMIT” button
    Validate the result equals “You entered: John Doe”
     */
    @Test(priority = 2)
    public void validateIFrameInput(){

        driver.switchTo().frame(techGlobalIframePage.iFrameId );

        String[] credentials = {"John", "Doe"};

        for (int i = 0; i < credentials.length; i++) {
            techGlobalIframePage.inputs.get(i).sendKeys(credentials[i]);
        }
        techGlobalIframePage.submitButton.click();
        driver.switchTo().defaultContent();
        Assert.assertEquals(techGlobalIframePage.result.getText(), "You entered: " + credentials[0] + " " + credentials[1]);

    }

}
