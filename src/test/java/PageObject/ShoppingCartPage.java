package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage{

    //constructor
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//input[@title='Qty']")
    WebElement Qty_input;

    @FindBy(xpath = "//p[@class='item-msg error']")
    WebElement Message_Error;

    @FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
    WebElement Empty_Cart_lnk;

    @FindBy(xpath = "//h1[normalize-space()='Shopping Cart is Empty']")
    WebElement Empty_ShoppingCart_Message;

    @FindBy(xpath = "//button[@title='Update']")
    WebElement btn_update;

    @FindBy(xpath = "//select[@id='country']")
    WebElement Country_dropDown;

    @FindBy(xpath = "//select[@id='region_id']")
    WebElement State_dropDown;

    @FindBy(xpath = "//input[@id='region']")
    WebElement State_txt;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement ZipCode_txt;

    @FindBy(xpath = "//span[contains(text(),'Estimate')]")
    WebElement Estimate_lnk;

    @FindBy(xpath = "//dt[normalize-space()='Flat Rate']")
    WebElement Flat_Rate;

    @FindBy(xpath = "//input[@id='s_method_flatrate_flatrate']")
    WebElement ShippingCost_radioButton;

    @FindBy(xpath = "//label[contains(text(),'Fixed')]")
    WebElement Fixed_FlatRate;

    @FindBy(xpath = "//button[@title='Update Total']")
    WebElement Update_total_btn;

    @FindBy(xpath = "//td[@class='a-right']//span[@class='price'][normalize-space()='$5.00']")
    WebElement Flat_Rate_Price;

    @FindBy(xpath = "//a[normalize-space()='Checkout with Multiple Addresses']")
    WebElement CheckoutWithMultipleAddress;

    @FindBy(xpath = "//strong/span[@class='price']")
    WebElement GrandTotalPrice;

    @FindBy(xpath = "//input[@id='coupon_code']")
    WebElement CouponCode_txt;

    @FindBy(xpath = "//button[@title='Apply']")
    WebElement Apply_btn;

    @FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
    WebElement DiscountMessage;

    //Actions
    public ShoppingCartPage SetQuantity(String num){
        Qty_input.clear();
        Qty_input.sendKeys(num);
        return this;
    }

    public String Get_ErrorMessage(){
       return Message_Error.getText();
    }

    public void ClickOnEmptyCart(){
        Empty_Cart_lnk.click();
    }
    public String GetEmptyShoppingCart_Message(){
        return  Empty_ShoppingCart_Message.getText();
    }

    public ShoppingCartPage clickOnUpdateButton(){
        btn_update.click();
        return this;
    }

    public ShoppingCartPage FillShippingInfoInShoppingCart(){

        Select Countryselect=new Select(Country_dropDown);
        Countryselect.selectByIndex(14);

        /*
        Select Stateselect=new Select(State_dropDown);
        Stateselect.selectByIndex();
        */
        State_txt.clear();
        State_txt.sendKeys("New South Wales");
        ZipCode_txt.clear();
        ZipCode_txt.sendKeys("2000");
        return this;
    }
    public ShoppingCartPage ClickOnEstimateLink(){
        Estimate_lnk.click();
        return this;
    }
    public String GetShoppingCostMessage(){
        return Flat_Rate.getText();
    }
    public ShoppingCartPage SelectShippingCost(){
        ShippingCost_radioButton.click();
        return this;
    }
    public ShoppingCartPage ClickOnUpdateTotal(){
        Update_total_btn.click();
        return this;
    }
    public String GetFixed_FlatRate(){
        return Fixed_FlatRate.getText();
    }
    public String GetFlatRatePrice(){
        return Flat_Rate_Price.getText();
    }
    public ShippingAddress ClickOnCheckoutWithMultipleAddress(){
        CheckoutWithMultipleAddress.click();
        return new ShippingAddress(driver);
    }
    public String GetGrandTotalPrice(){
        return GrandTotalPrice.getText();
    }
    public ShoppingCartPage EnterCouponCode(String Coupon){
        CouponCode_txt.sendKeys(Coupon);
        return this;
    }
    public ShoppingCartPage ClickOnApplyButton(){
        Apply_btn.click();
        return this;
    }
    public String GetDiscountMessage(){
        return DiscountMessage.getText();
    }
}
