package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage extends BasePage{

    //Constructor
    public MyWishListPage(WebDriver driver) {
        super(driver);

    }

    //Locators
    @FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
    WebElement Share_WishList_btn;

    @FindBy(xpath = "//span[normalize-space()='Your Wishlist has been shared.']")
    WebElement WishListMessage;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    WebElement AddToCart_btn;

    //Actions
    public WishListSharingPage ClickOnShareWishList(){
        Share_WishList_btn.click();
        return new WishListSharingPage(driver);
    }
    public String GetWishListMessage(){
        return  WishListMessage.getText();

    }
    public ShoppingCartPage ClickOnAddToCart(){
        AddToCart_btn.click();
        return new ShoppingCartPage(driver);
    }
}
