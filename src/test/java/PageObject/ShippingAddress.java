package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingAddress extends BasePage{

    //Constructor
    public ShippingAddress(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//select[@id='country']")
    WebElement Country_dropDown;

    @FindBy(xpath = "//select[@id='region_id']")
    WebElement State_dropDown;

    @FindBy(xpath = "//input[@id='zip']")
    WebElement ZipCode_txt;

    @FindBy(xpath = "//input[@id='city']")
    WebElement City_txt;

    @FindBy(xpath = "//input[@id='street_1']")
    WebElement Address1_txt;

    @FindBy(xpath = "//input[@id='telephone']")
    WebElement Telephone_txt;

    @FindBy(xpath = "//button[@title='Save Address']")
    WebElement SaveAddress_btn;

    @FindBy(xpath = "//button[@title='Continue to Shipping Information']")
    WebElement ContinueToShoppingInfo_btn;

    //Actions
    public ShippingAddress EnterShippingInfo(){

        //For Country Information
        Select country=new Select(Country_dropDown);
        country.selectByVisibleText("France");

        //For State Information
        Select state=new Select(State_dropDown);
        state.selectByVisibleText("Paris");

        //For Zip code Text
        ZipCode_txt.sendKeys("542896");

        //For City Text
        City_txt.sendKeys("New York");

        //For Address1 Text
        Address1_txt.sendKeys("ABC");

        //For Telephone Text
        Telephone_txt.sendKeys("12345678");
        return this;
    }
    public ShippingAddress ClickOnSaveAddress(){
        SaveAddress_btn.click();
        return this;
    }
    public ShippingMethods ClickOnContinueToShoppingInfo()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ContinueToShoppingInfo_btn));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", button);
        return new ShippingMethods(driver);
    }

}
