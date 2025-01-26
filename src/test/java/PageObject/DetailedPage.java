package PageObject;

import TestBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailedPage extends BasePage {

    //Constructor
    public DetailedPage(WebDriver driver) {
        super(driver);

    }

    //Locator
    @FindBy(xpath = "//span[contains(text(),'$100.00')]")
    WebElement SonyXperia_detailed_price;

    //Action
    public String GetPriceInDetailedPage(){
        return getMessage(SonyXperia_detailed_price);
    }

}
