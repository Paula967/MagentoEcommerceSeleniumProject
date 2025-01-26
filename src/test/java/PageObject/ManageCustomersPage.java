package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomersPage extends BasePage{
    public ManageCustomersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    //Locators
    @FindBy(xpath = "//a[@title='close']")
    WebElement Close_btn;

    @FindBy(xpath = "(//a[@href='#'])[1]")
    WebElement Sales_lnk;

    @FindBy(xpath = "(//span[normalize-space()='Orders'])[1]")
    WebElement Orders_lnk;

    //Actions
    public void GotoOrdersPage(){
        Close_btn.click();
        Sales_lnk.click();
        Orders_lnk.click();
    }

}
