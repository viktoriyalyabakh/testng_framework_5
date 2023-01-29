package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalIframePage extends TechGlobalBasePage{

    public TechGlobalIframePage(){
        super();
    }

@FindBy(css = "#name_form>p")
    public WebElement inputHeader;

    @FindBy(css = "#form_frame")
    public WebElement iFrameId;

    @FindBy(css = ".input")
    public List<WebElement> inputs;

   // @FindBy(id = "last_name")
   // public WebElement inputLastName;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "result")
    public WebElement result;




}
