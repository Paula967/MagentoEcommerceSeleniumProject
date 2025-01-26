package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailedPage extends BasePage{
    //Constructor
    public OrderDetailedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    //Locators
    @FindBy(xpath = "//div[@class='page-title title-buttons']/a[normalize-space()='Print Order']")
    WebElement PrintOrder_lnk;

    //Actions
    public void ClickOnPrintOrder(){
        PrintOrder_lnk.click();
    }
}
