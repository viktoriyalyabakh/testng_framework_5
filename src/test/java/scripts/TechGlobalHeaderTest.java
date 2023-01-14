package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TechGlobalHeaderTest extends TechGlobalBase {

    @Test
    public void validateTechGlobalHeaderDropdown() {
        WebElement headerDropdown = driver.findElement(By.id("dropdown-button"));

        Assert.assertTrue(headerDropdown.isDisplayed());
        Assert.assertEquals(headerDropdown.getText(), "Practices");
    }

    @Test
    public void validateTechGlobalHeaderDropdownOptions(){
        /*
        Go to TechGlobal Training website
        Click on "Practices" dropdown
        Validate options below are displayed and enabled and their text is as below
        Frontend Testing
        Backend Testing
        Java Exercises
         */
    }
}
