package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalDynamicTablesPage extends TechGlobalBasePage{

    public TechGlobalDynamicTablesPage(){
        super();
    }

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "modal_title")
    public WebElement modalCartTitle;

    @FindBy(css = ".input")
    public List<WebElement> productDetails;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "total_amount")
    public WebElement totalAmount;

    @FindBy(css = "body td:nth-child(1)")
    public List<WebElement> tableRow;

    @FindBy(css = "table")
    public WebElement table;

}



