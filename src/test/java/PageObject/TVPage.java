package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVPage extends BasePage{

    //Constructor
    public TVPage(WebDriver driver) {
        super(driver);

    }

    //Locators
    @FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
    WebElement LG_LCD_Add_To_WishList_lnk;

    //Actions
    public MyWishListPage ClickOnLG_LCDAddToWishList(){
        LG_LCD_Add_To_WishList_lnk.click();
        return new MyWishListPage(driver);
    }

}
