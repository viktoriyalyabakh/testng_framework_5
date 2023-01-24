package scripts;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");
    }

    @Test(priority = 1, description = "Select Delivery option")
    public void selectDeliveryOption(){
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                                               techGlobalDropdownsPage.deliveryDropdownOptions,
                                                 "Delivery");

    }

    @Test(priority = 2, description = "Select iPhone 14 Pro Max option")
    public void selectProductOption(){
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown, "iPhone 14 Pro Max");
    }

    @Test(priority = 3, description = "Select Yellow options")
    public void selectColorOption(){
        new Select(techGlobalDropdownsPage.colorDropdown).selectByValue("Yellow");
        Waiter.pause(5);
    }
    @Test(priority = 4, description = "Validate the selected item message")
    public void validateTheItemSelected(){
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown, "MacBook Pro 13");
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.colorDropdown, 3);

        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions,
                "Delivery");
        techGlobalDropdownsPage.submitButton.click();
        Assert.assertTrue(techGlobalDropdownsPage.resultMessage.getText().equals("Your Silver MacBook Pro 13 will be delivered to you."));
    }

    }
