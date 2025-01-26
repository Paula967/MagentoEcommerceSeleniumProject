package PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListSharingPage extends BasePage{

    //constructor
    public WishListSharingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//textarea[@id='email_address']")
    WebElement EmailAddress_txtArea;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement Message_txtArea;

    @FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
    WebElement WishListButton;

    //Actions
    public WishListSharingPage FillTextArea(){
        Faker faker=new Faker();
        EmailAddress_txtArea.sendKeys(faker.internet().emailAddress());
        Message_txtArea.sendKeys("Hello This is My Wishlist For You ........");
        return this;
    }
    public MyWishListPage ClickOnWishListButton(){
        WishListButton.click();
        return new MyWishListPage(driver);
    }
}
