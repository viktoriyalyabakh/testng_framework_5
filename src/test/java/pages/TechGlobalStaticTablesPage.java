package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalStaticTablesPage extends TechGlobalBasePage{

    public TechGlobalStaticTablesPage(){
        super();
    }

    @FindBy(css = ".header")
    public List<WebElement> tableHeader;

    @FindBy(css = "//tbody/tr")
    public List<WebElement> rows;
}
