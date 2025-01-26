package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public String OrderID;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
}
