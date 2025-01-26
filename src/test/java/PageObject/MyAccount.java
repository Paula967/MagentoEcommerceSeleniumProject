package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends BasePage{

    //Constructor
    public MyAccount(WebDriver driver) {
        super(driver);

    }

    //Locators
    @FindBy(xpath = "//p[@class='hello']/strong")
    WebElement Welcome_MyAccount_Message;

    @FindBy(xpath = "//a[normalize-space()='TV']")
    WebElement TV_lnk;

    @FindBy(xpath ="//a[@class='skip-link skip-account']")
    WebElement MyAccount;

    @FindBy(xpath = "//a[contains(@title, 'My Wishlist')]")
    WebElement MyWishList_lnk;

    @FindBy(xpath = "//div[@class='block-content']/ul/li[4]/a")
    WebElement MyOrders_lnk;

    @FindBy(xpath = "//a[normalize-space()='View Order']")
    WebElement ViewOrder_lnk;

    @FindBy(xpath = "//td[@class='number']")
    WebElement OrderID;

    @FindBy(xpath = "//td[@class='status']/em")
    WebElement StatusOfOrder;

    @FindBy(xpath = "//a[normalize-space()='Reorder']")
    WebElement Reorder_lnk;

    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement Logout_lnk;


    //Actions
    public String GetMyAccountMessage(){
       return getMessage(Welcome_MyAccount_Message);
    }
    public TVPage ClickOnTvLink(){
        ClickOn(TV_lnk);
        return new TVPage(driver);
    }

    public MyWishListPage ClickOnMyWishListLink(){
        ClickOn(MyWishList_lnk);
        return new MyWishListPage(driver);
    }
    public void MyAccountlink(){
        ClickOn(MyAccount);
    }
    public void ClickOnMyOrders(){
        ClickOn(MyOrders_lnk);
    }
    public OrderDetailedPage ClickOnViewOrder(){
        ViewOrder_lnk.click();
        return new OrderDetailedPage(driver);
    }
    public String GetOrderID(){
        return OrderID.getText();
    }
    public String GetStatusOFOrder(){
        return StatusOfOrder.getText();
    }
    public String RetrieveOrderID(){
     return OrderID.getText();
    }
    public ShoppingCartPage ClickOnReorderLink(){
        Reorder_lnk.click();
        return new ShoppingCartPage(driver);
    }
    public void ClickOnLogout(){
        MyAccountlink();
        Logout_lnk.click();
    }

}
