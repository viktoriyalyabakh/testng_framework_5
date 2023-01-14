package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TechGlobalBase {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //We will set up our driver and the pages here
        //System.setProperty("webdriver.chrome.driver", "/Users/techglobal/IdeaProjects/initial_selenium_project_5/chromedriver");

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        driver.quit();
    }
}
